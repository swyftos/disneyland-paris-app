package com.microsoft.appcenter.analytics;

import android.content.Context;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class AnalyticsTransmissionTarget {
    static AuthenticationProvider sAuthenticationProvider;
    private Channel mChannel;
    Context mContext;
    final AnalyticsTransmissionTarget mParentTarget;
    private final String mTransmissionTargetToken;
    private final Map mChildrenTargets = new HashMap();
    private final PropertyConfigurator mPropertyConfigurator = new PropertyConfigurator(this);

    AnalyticsTransmissionTarget(String str, AnalyticsTransmissionTarget analyticsTransmissionTarget) {
        this.mTransmissionTargetToken = str;
        this.mParentTarget = analyticsTransmissionTarget;
    }

    void initInBackground(Context context, Channel channel) {
        this.mContext = context;
        this.mChannel = channel;
        channel.addListener(this.mPropertyConfigurator);
    }

    public static synchronized void addAuthenticationProvider(final AuthenticationProvider authenticationProvider) {
        if (authenticationProvider == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "Authentication provider may not be null.");
            return;
        }
        if (authenticationProvider.getType() == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "Authentication provider type may not be null.");
            return;
        }
        if (authenticationProvider.getTicketKey() == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "Authentication ticket key may not be null.");
        } else {
            if (authenticationProvider.getTokenProvider() == null) {
                AppCenterLog.error(Analytics.LOG_TAG, "Authentication token provider may not be null.");
                return;
            }
            if (AppCenter.isConfigured()) {
                Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnalyticsTransmissionTarget.updateProvider(authenticationProvider);
                    }
                });
            } else {
                updateProvider(authenticationProvider);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateProvider(AuthenticationProvider authenticationProvider) {
        sAuthenticationProvider = authenticationProvider;
        authenticationProvider.acquireTokenAsync();
    }

    public void trackEvent(String str) {
        trackEvent(str, (EventProperties) null, 1);
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, 1);
    }

    public void trackEvent(String str, Map<String, String> map, int i) {
        EventProperties eventProperties;
        if (map != null) {
            eventProperties = new EventProperties();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                eventProperties.set(entry.getKey(), entry.getValue());
            }
        } else {
            eventProperties = null;
        }
        trackEvent(str, eventProperties, i);
    }

    public void trackEvent(String str, EventProperties eventProperties) {
        trackEvent(str, eventProperties, 1);
    }

    public void trackEvent(String str, EventProperties eventProperties, int i) {
        EventProperties eventProperties2 = new EventProperties();
        for (AnalyticsTransmissionTarget analyticsTransmissionTarget = this; analyticsTransmissionTarget != null; analyticsTransmissionTarget = analyticsTransmissionTarget.mParentTarget) {
            analyticsTransmissionTarget.getPropertyConfigurator().mergeEventProperties(eventProperties2);
        }
        if (eventProperties != null) {
            eventProperties2.getProperties().putAll(eventProperties.getProperties());
        } else if (eventProperties2.getProperties().isEmpty()) {
            eventProperties2 = null;
        }
        Analytics.trackEvent(str, eventProperties2, this, i);
    }

    public synchronized AnalyticsTransmissionTarget getTransmissionTarget(String str) {
        final AnalyticsTransmissionTarget analyticsTransmissionTarget;
        analyticsTransmissionTarget = (AnalyticsTransmissionTarget) this.mChildrenTargets.get(str);
        if (analyticsTransmissionTarget == null) {
            analyticsTransmissionTarget = new AnalyticsTransmissionTarget(str, this);
            this.mChildrenTargets.put(str, analyticsTransmissionTarget);
            Analytics.getInstance().postCommandEvenIfDisabled(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.2
                @Override // java.lang.Runnable
                public void run() {
                    AnalyticsTransmissionTarget analyticsTransmissionTarget2 = analyticsTransmissionTarget;
                    AnalyticsTransmissionTarget analyticsTransmissionTarget3 = AnalyticsTransmissionTarget.this;
                    analyticsTransmissionTarget2.initInBackground(analyticsTransmissionTarget3.mContext, analyticsTransmissionTarget3.mChannel);
                }
            });
        }
        return analyticsTransmissionTarget;
    }

    public AppCenterFuture<Boolean> isEnabledAsync() {
        final DefaultAppCenterFuture defaultAppCenterFuture = new DefaultAppCenterFuture();
        Analytics.getInstance().postCommand(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.3
            @Override // java.lang.Runnable
            public void run() {
                defaultAppCenterFuture.complete(Boolean.valueOf(AnalyticsTransmissionTarget.this.isEnabled()));
            }
        }, defaultAppCenterFuture, Boolean.FALSE);
        return defaultAppCenterFuture;
    }

    public AppCenterFuture<Void> setEnabledAsync(final boolean z) {
        final DefaultAppCenterFuture defaultAppCenterFuture = new DefaultAppCenterFuture();
        Analytics.getInstance().postCommand(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.4
            @Override // java.lang.Runnable
            public void run() {
                if (AnalyticsTransmissionTarget.this.areAncestorsEnabled()) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(AnalyticsTransmissionTarget.this);
                    while (!linkedList.isEmpty()) {
                        ListIterator listIterator = linkedList.listIterator();
                        while (listIterator.hasNext()) {
                            AnalyticsTransmissionTarget analyticsTransmissionTarget = (AnalyticsTransmissionTarget) listIterator.next();
                            listIterator.remove();
                            SharedPreferencesManager.putBoolean(analyticsTransmissionTarget.getEnabledPreferenceKey(), z);
                            Iterator it = analyticsTransmissionTarget.mChildrenTargets.values().iterator();
                            while (it.hasNext()) {
                                listIterator.add((AnalyticsTransmissionTarget) it.next());
                            }
                        }
                    }
                } else {
                    AppCenterLog.error(Analytics.LOG_TAG, "One of the parent transmission target is disabled, cannot change state.");
                }
                defaultAppCenterFuture.complete(null);
            }
        }, defaultAppCenterFuture, null);
        return defaultAppCenterFuture;
    }

    public void pause() {
        Analytics.getInstance().post(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.5
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsTransmissionTarget.this.mChannel.pauseGroup("group_analytics", AnalyticsTransmissionTarget.this.mTransmissionTargetToken);
                AnalyticsTransmissionTarget.this.mChannel.pauseGroup("group_analytics_critical", AnalyticsTransmissionTarget.this.mTransmissionTargetToken);
            }
        });
    }

    public void resume() {
        Analytics.getInstance().post(new Runnable() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.6
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsTransmissionTarget.this.mChannel.resumeGroup("group_analytics", AnalyticsTransmissionTarget.this.mTransmissionTargetToken);
                AnalyticsTransmissionTarget.this.mChannel.resumeGroup("group_analytics_critical", AnalyticsTransmissionTarget.this.mTransmissionTargetToken);
            }
        });
    }

    String getTransmissionTargetToken() {
        return this.mTransmissionTargetToken;
    }

    static Channel.Listener getChannelListener() {
        return new AbstractChannelListener() { // from class: com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.7
            @Override // com.microsoft.appcenter.channel.AbstractChannelListener, com.microsoft.appcenter.channel.Channel.Listener
            public void onPreparingLog(Log log, String str) {
                AnalyticsTransmissionTarget.addTicketToLog(log);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addTicketToLog(Log log) {
        AuthenticationProvider authenticationProvider = sAuthenticationProvider;
        if (authenticationProvider == null || !(log instanceof CommonSchemaLog)) {
            return;
        }
        ((CommonSchemaLog) log).getExt().getProtocol().setTicketKeys(Collections.singletonList(authenticationProvider.getTicketKeyHash()));
        sAuthenticationProvider.checkTokenExpiry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEnabledPreferenceKey() {
        return Analytics.getInstance().getEnabledPreferenceKeyPrefix() + PartAUtils.getTargetKey(this.mTransmissionTargetToken);
    }

    private boolean isEnabledInStorage() {
        return SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean areAncestorsEnabled() {
        do {
            this = this.mParentTarget;
            if (this == null) {
                return true;
            }
        } while (this.isEnabledInStorage());
        return false;
    }

    boolean isEnabled() {
        return areAncestorsEnabled() && isEnabledInStorage();
    }

    public PropertyConfigurator getPropertyConfigurator() {
        return this.mPropertyConfigurator;
    }
}
