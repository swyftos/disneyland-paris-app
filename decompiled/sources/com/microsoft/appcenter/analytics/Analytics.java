package com.microsoft.appcenter.analytics;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.Flags;
import com.microsoft.appcenter.analytics.channel.AnalyticsListener;
import com.microsoft.appcenter.analytics.channel.AnalyticsValidator;
import com.microsoft.appcenter.analytics.channel.SessionTracker;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.analytics.ingestion.models.json.EventLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.PageLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.StartSessionLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.json.CommonSchemaEventLogFactory;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class Analytics extends AbstractAppCenterService {
    public static final String LOG_TAG = "AppCenterAnalytics";
    private static Analytics sInstance;
    private AnalyticsListener mAnalyticsListener;
    private Channel.Listener mAnalyticsTransmissionTargetListener;
    private AnalyticsValidator mAnalyticsValidator;
    private boolean mAutoPageTrackingEnabled = false;
    private Context mContext;
    private WeakReference mCurrentActivity;
    AnalyticsTransmissionTarget mDefaultTransmissionTarget;
    private final Map mFactories;
    private SessionTracker mSessionTracker;
    private boolean mStartedFromApp;
    private long mTransmissionInterval;
    private final Map mTransmissionTargets;

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public boolean isAppSecretRequired() {
        return false;
    }

    private Analytics() {
        HashMap map = new HashMap();
        this.mFactories = map;
        map.put(StartSessionLog.TYPE, new StartSessionLogFactory());
        map.put("page", new PageLogFactory());
        map.put("event", new EventLogFactory());
        map.put(CommonSchemaEventLog.TYPE, new CommonSchemaEventLogFactory());
        this.mTransmissionTargets = new HashMap();
        this.mTransmissionInterval = TimeUnit.SECONDS.toMillis(3L);
    }

    public static synchronized Analytics getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new Analytics();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        return getInstance().isInstanceEnabledAsync();
    }

    public static AppCenterFuture<Void> setEnabled(boolean z) {
        return getInstance().setInstanceEnabledAsync(z);
    }

    public static boolean setTransmissionInterval(int i) {
        return getInstance().setInstanceTransmissionInterval(i);
    }

    public static void pause() {
        getInstance().pauseInstanceAsync();
    }

    public static void resume() {
        getInstance().resumeInstanceAsync();
    }

    @VisibleForTesting
    protected static void setListener(AnalyticsListener analyticsListener) {
        getInstance().setInstanceListener(analyticsListener);
    }

    protected static boolean isAutoPageTrackingEnabled() {
        return getInstance().isInstanceAutoPageTrackingEnabled();
    }

    protected static void setAutoPageTrackingEnabled(boolean z) {
        getInstance().setInstanceAutoPageTrackingEnabled(z);
    }

    protected static void trackPage(String str) {
        trackPage(str, null);
    }

    protected static void trackPage(String str, Map<String, String> map) {
        getInstance().trackPageAsync(str, map);
    }

    public static void trackEvent(String str) {
        trackEvent(str, null, null, 1);
    }

    public static void trackEvent(String str, Map<String, String> map) {
        getInstance().trackEventAsync(str, convertProperties(map), null, 1);
    }

    public static void trackEvent(String str, Map<String, String> map, int i) {
        getInstance().trackEventAsync(str, convertProperties(map), null, i);
    }

    public static void trackEvent(String str, EventProperties eventProperties) {
        trackEvent(str, eventProperties, 1);
    }

    public static void trackEvent(String str, EventProperties eventProperties, int i) {
        trackEvent(str, eventProperties, null, i);
    }

    static void trackEvent(String str, EventProperties eventProperties, AnalyticsTransmissionTarget analyticsTransmissionTarget, int i) {
        getInstance().trackEventAsync(str, convertProperties(eventProperties), analyticsTransmissionTarget, i);
    }

    private static List convertProperties(EventProperties eventProperties) {
        if (eventProperties == null) {
            return null;
        }
        return new ArrayList(eventProperties.getProperties().values());
    }

    private static List convertProperties(Map map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            StringTypedProperty stringTypedProperty = new StringTypedProperty();
            stringTypedProperty.setName((String) entry.getKey());
            stringTypedProperty.setValue((String) entry.getValue());
            arrayList.add(stringTypedProperty);
        }
        return arrayList;
    }

    public static AnalyticsTransmissionTarget getTransmissionTarget(String str) {
        return getInstance().getInstanceTransmissionTarget(str);
    }

    private static String generatePageName(Class cls) {
        String simpleName = cls.getSimpleName();
        return (!simpleName.endsWith("Activity") || simpleName.length() <= 8) ? simpleName : simpleName.substring(0, simpleName.length() - 8);
    }

    private synchronized AnalyticsTransmissionTarget getInstanceTransmissionTarget(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                if (!AppCenter.isConfigured()) {
                    AppCenterLog.error(LOG_TAG, "Cannot create transmission target, AppCenter is not configured or started.");
                    return null;
                }
                AnalyticsTransmissionTarget analyticsTransmissionTarget = (AnalyticsTransmissionTarget) this.mTransmissionTargets.get(str);
                if (analyticsTransmissionTarget != null) {
                    AppCenterLog.debug(LOG_TAG, "Returning transmission target found with token " + str);
                    return analyticsTransmissionTarget;
                }
                AnalyticsTransmissionTarget analyticsTransmissionTargetCreateAnalyticsTransmissionTarget = createAnalyticsTransmissionTarget(str);
                this.mTransmissionTargets.put(str, analyticsTransmissionTargetCreateAnalyticsTransmissionTarget);
                return analyticsTransmissionTargetCreateAnalyticsTransmissionTarget;
            }
        }
        AppCenterLog.error(LOG_TAG, "Transmission target token may not be null or empty.");
        return null;
    }

    private AnalyticsTransmissionTarget createAnalyticsTransmissionTarget(String str) {
        final AnalyticsTransmissionTarget analyticsTransmissionTarget = new AnalyticsTransmissionTarget(str, null);
        AppCenterLog.debug(LOG_TAG, "Created transmission target with token " + str);
        postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.1
            @Override // java.lang.Runnable
            public void run() {
                analyticsTransmissionTarget.initInBackground(Analytics.this.mContext, ((AbstractAppCenterService) Analytics.this).mChannel);
            }
        });
        return analyticsTransmissionTarget;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected String getGroupName() {
        return "group_analytics";
    }

    @Override // com.microsoft.appcenter.AppCenterService
    public String getServiceName() {
        return "Analytics";
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected String getLoggerTag() {
        return LOG_TAG;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public Map<String, LogFactory> getLogFactories() {
        return this.mFactories;
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(final Activity activity) {
        final Runnable runnable = new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.2
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.mCurrentActivity = new WeakReference(activity);
            }
        };
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.3
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                Analytics.this.processOnResume(activity);
            }
        }, runnable, runnable);
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected long getTriggerInterval() {
        return this.mTransmissionInterval;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processOnResume(Activity activity) {
        SessionTracker sessionTracker = this.mSessionTracker;
        if (sessionTracker != null) {
            sessionTracker.onActivityResumed();
            if (this.mAutoPageTrackingEnabled) {
                queuePage(generatePageName(activity.getClass()), null);
            }
        }
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
        final Runnable runnable = new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.4
            @Override // java.lang.Runnable
            public void run() {
                Analytics.this.mCurrentActivity = null;
            }
        };
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.5
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                if (Analytics.this.mSessionTracker != null) {
                    Analytics.this.mSessionTracker.onActivityPaused();
                }
            }
        }, runnable, runnable);
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected Channel.GroupListener getChannelListener() {
        return new Channel.GroupListener() { // from class: com.microsoft.appcenter.analytics.Analytics.6
            @Override // com.microsoft.appcenter.channel.Channel.GroupListener
            public void onBeforeSending(Log log) {
                if (Analytics.this.mAnalyticsListener != null) {
                    Analytics.this.mAnalyticsListener.onBeforeSending(log);
                }
            }

            @Override // com.microsoft.appcenter.channel.Channel.GroupListener
            public void onSuccess(Log log) {
                if (Analytics.this.mAnalyticsListener != null) {
                    Analytics.this.mAnalyticsListener.onSendingSucceeded(log);
                }
            }

            @Override // com.microsoft.appcenter.channel.Channel.GroupListener
            public void onFailure(Log log, Exception exc) {
                if (Analytics.this.mAnalyticsListener != null) {
                    Analytics.this.mAnalyticsListener.onSendingFailed(log, exc);
                }
            }
        };
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService
    protected synchronized void applyEnabledState(boolean z) {
        try {
            if (z) {
                this.mChannel.addGroup("group_analytics_critical", getTriggerCount(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, getTriggerMaxParallelRequests(), null, getChannelListener());
                startAppLevelFeatures();
            } else {
                this.mChannel.removeGroup("group_analytics_critical");
                AnalyticsValidator analyticsValidator = this.mAnalyticsValidator;
                if (analyticsValidator != null) {
                    this.mChannel.removeListener(analyticsValidator);
                    this.mAnalyticsValidator = null;
                }
                SessionTracker sessionTracker = this.mSessionTracker;
                if (sessionTracker != null) {
                    this.mChannel.removeListener(sessionTracker);
                    this.mSessionTracker.clearSessions();
                    this.mSessionTracker = null;
                }
                Channel.Listener listener = this.mAnalyticsTransmissionTargetListener;
                if (listener != null) {
                    this.mChannel.removeListener(listener);
                    this.mAnalyticsTransmissionTargetListener = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void startAppLevelFeatures() {
        Activity activity;
        if (this.mStartedFromApp) {
            AnalyticsValidator analyticsValidator = new AnalyticsValidator();
            this.mAnalyticsValidator = analyticsValidator;
            this.mChannel.addListener(analyticsValidator);
            SessionTracker sessionTracker = new SessionTracker(this.mChannel, "group_analytics");
            this.mSessionTracker = sessionTracker;
            this.mChannel.addListener(sessionTracker);
            WeakReference weakReference = this.mCurrentActivity;
            if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
                processOnResume(activity);
            }
            Channel.Listener channelListener = AnalyticsTransmissionTarget.getChannelListener();
            this.mAnalyticsTransmissionTargetListener = channelListener;
            this.mChannel.addListener(channelListener);
        }
    }

    private synchronized void trackPageAsync(final String str, Map map) {
        final HashMap map2;
        if (map != null) {
            try {
                map2 = new HashMap(map);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            map2 = null;
        }
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.7
            @Override // java.lang.Runnable
            public void run() {
                if (Analytics.this.mStartedFromApp) {
                    Analytics.this.queuePage(str, map2);
                } else {
                    AppCenterLog.error(Analytics.LOG_TAG, "Cannot track page if not started from app.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queuePage(String str, Map map) {
        PageLog pageLog = new PageLog();
        pageLog.setName(str);
        pageLog.setProperties(map);
        this.mChannel.enqueue(pageLog, "group_analytics", 1);
    }

    private synchronized void trackEventAsync(final String str, final List list, final AnalyticsTransmissionTarget analyticsTransmissionTarget, final int i) {
        final String userId = UserIdContext.getInstance().getUserId();
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.8
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsTransmissionTarget analyticsTransmissionTarget2 = analyticsTransmissionTarget;
                if (analyticsTransmissionTarget2 == null) {
                    analyticsTransmissionTarget2 = Analytics.this.mDefaultTransmissionTarget;
                }
                EventLog eventLog = new EventLog();
                if (analyticsTransmissionTarget2 == null) {
                    if (!Analytics.this.mStartedFromApp) {
                        AppCenterLog.error(Analytics.LOG_TAG, "Cannot track event using Analytics.trackEvent if not started from app, please start from the application or use Analytics.getTransmissionTarget.");
                        return;
                    }
                } else {
                    if (!analyticsTransmissionTarget2.isEnabled()) {
                        AppCenterLog.error(Analytics.LOG_TAG, "This transmission target is disabled.");
                        return;
                    }
                    eventLog.addTransmissionTarget(analyticsTransmissionTarget2.getTransmissionTargetToken());
                    eventLog.setTag(analyticsTransmissionTarget2);
                    if (analyticsTransmissionTarget2 == Analytics.this.mDefaultTransmissionTarget) {
                        eventLog.setUserId(userId);
                    }
                }
                eventLog.setId(UUID.randomUUID());
                eventLog.setName(str);
                eventLog.setTypedProperties(list);
                int persistenceFlag = Flags.getPersistenceFlag(i, true);
                ((AbstractAppCenterService) Analytics.this).mChannel.enqueue(eventLog, persistenceFlag == 2 ? "group_analytics_critical" : "group_analytics", persistenceFlag);
            }
        });
    }

    private boolean isInstanceAutoPageTrackingEnabled() {
        return this.mAutoPageTrackingEnabled;
    }

    private synchronized void setInstanceAutoPageTrackingEnabled(boolean z) {
        this.mAutoPageTrackingEnabled = z;
    }

    private synchronized void setInstanceListener(AnalyticsListener analyticsListener) {
        this.mAnalyticsListener = analyticsListener;
    }

    private synchronized void pauseInstanceAsync() {
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.9
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractAppCenterService) Analytics.this).mChannel.pauseGroup("group_analytics", null);
                ((AbstractAppCenterService) Analytics.this).mChannel.pauseGroup("group_analytics_critical", null);
            }
        });
    }

    private synchronized void resumeInstanceAsync() {
        post(new Runnable() { // from class: com.microsoft.appcenter.analytics.Analytics.10
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractAppCenterService) Analytics.this).mChannel.resumeGroup("group_analytics", null);
                ((AbstractAppCenterService) Analytics.this).mChannel.resumeGroup("group_analytics_critical", null);
            }
        });
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        this.mContext = context;
        this.mStartedFromApp = z;
        super.onStarted(context, channel, str, str2, z);
        setDefaultTransmissionTarget(str2);
    }

    @Override // com.microsoft.appcenter.AbstractAppCenterService, com.microsoft.appcenter.AppCenterService
    public void onConfigurationUpdated(String str, String str2) {
        this.mStartedFromApp = true;
        startAppLevelFeatures();
        setDefaultTransmissionTarget(str2);
    }

    private void setDefaultTransmissionTarget(String str) {
        if (str != null) {
            this.mDefaultTransmissionTarget = createAnalyticsTransmissionTarget(str);
        }
    }

    private boolean setInstanceTransmissionInterval(int i) {
        if (this.mChannel != null) {
            AppCenterLog.error(LOG_TAG, "Transmission interval should be set before the service is started.");
            return false;
        }
        if (i < 3 || i > 86400) {
            AppCenterLog.error(LOG_TAG, String.format(Locale.ENGLISH, "The transmission interval is invalid. The value should be between %d seconds and %d seconds (%d day).", 3, 86400, Long.valueOf(TimeUnit.SECONDS.toDays(86400L))));
            return false;
        }
        this.mTransmissionInterval = TimeUnit.SECONDS.toMillis(i);
        return true;
    }

    void postCommand(Runnable runnable, DefaultAppCenterFuture defaultAppCenterFuture, Object obj) {
        postAsyncGetter(runnable, defaultAppCenterFuture, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.appcenter.AbstractAppCenterService
    public synchronized void post(Runnable runnable) {
        super.post(runnable);
    }

    void postCommandEvenIfDisabled(Runnable runnable) {
        post(runnable, runnable, runnable);
    }

    String getEnabledPreferenceKeyPrefix() {
        return getEnabledPreferenceKey() + "/";
    }
}
