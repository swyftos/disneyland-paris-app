package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.pm.PackageInfoCompat;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.actions.DeepLinkListener;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.base.Supplier;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.ChannelRegistrar;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.RemoteConfigObserver;
import com.urbanairship.contacts.Contact;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.http.DefaultRequestSession;
import com.urbanairship.images.AirshipGlideImageLoader;
import com.urbanairship.images.ImageLoader;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.inputvalidation.DefaultInputValidator;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.meteredusage.AirshipMeteredUsage;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.Modules;
import com.urbanairship.modules.location.AirshipLocationClient;
import com.urbanairship.modules.location.LocationModule;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.remoteconfig.RemoteConfigManager;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.util.AppStoreUtils;
import com.urbanairship.util.Clock;
import com.urbanairship.util.ProcessUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public class UAirship {

    @NonNull
    public static final String ACTION_AIRSHIP_READY = "com.urbanairship.AIRSHIP_READY";
    public static final int AMAZON_PLATFORM = 1;
    public static final int ANDROID_PLATFORM = 2;

    @NonNull
    public static final String EXTRA_AIRSHIP_DEEP_LINK_SCHEME = "uairship";

    @NonNull
    public static final String EXTRA_APP_KEY_KEY = "app_key";

    @NonNull
    public static final String EXTRA_CHANNEL_ID_KEY = "channel_id";

    @NonNull
    public static final String EXTRA_PAYLOAD_VERSION_KEY = "payload_version";
    public static boolean LOG_TAKE_OFF_STACKTRACE = false;
    public static final int UNKNOWN_PLATFORM = -1;
    static Application application = null;
    static volatile boolean isFlying = false;
    static volatile boolean isMainProcess = false;
    static volatile boolean isTakingOff = false;
    static UAirship sharedAirship;
    ActionRegistry actionRegistry;
    AirshipConfigOptions airshipConfigOptions;
    Analytics analytics;
    ApplicationMetrics applicationMetrics;
    AirshipChannel channel;
    ChannelCapture channelCapture;
    private final Map componentClassMap = new HashMap();
    List components = new ArrayList();
    Contact contact;
    private DeepLinkListener deepLinkListener;
    ExperimentManager experimentManager;
    ImageLoader imageLoader;
    AirshipInputValidation.Validator inputValidator;
    LocaleManager localeManager;
    AirshipLocationClient locationClient;
    AirshipMeteredUsage meteredUsageManager;
    PermissionsManager permissionsManager;
    PreferenceDataStore preferenceDataStore;
    PrivacyManager privacyManager;
    PushManager pushManager;
    RemoteConfigManager remoteConfigManager;
    RemoteData remoteData;
    AirshipRuntimeConfig runtimeConfig;
    UrlAllowList urlAllowList;
    private static final Object airshipLock = new Object();
    private static final List pendingAirshipRequests = new ArrayList();
    private static boolean queuePendingAirshipRequests = true;

    public interface OnReadyCallback {
        void onAirshipReady(@NonNull UAirship uAirship);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Platform {
    }

    UAirship(AirshipConfigOptions airshipConfigOptions) {
        this.airshipConfigOptions = airshipConfigOptions;
    }

    @NonNull
    public static UAirship shared() {
        UAirship uAirshipWaitForTakeOff;
        synchronized (airshipLock) {
            try {
                if (!isTakingOff && !isFlying) {
                    throw new IllegalStateException("Take off must be called before shared()");
                }
                uAirshipWaitForTakeOff = waitForTakeOff(0L);
            } catch (Throwable th) {
                throw th;
            }
        }
        return uAirshipWaitForTakeOff;
    }

    @NonNull
    public static Cancelable shared(@NonNull OnReadyCallback onReadyCallback) {
        return shared(null, onReadyCallback);
    }

    @Nullable
    public static UAirship waitForTakeOff(long j) {
        synchronized (airshipLock) {
            if (isFlying) {
                return sharedAirship;
            }
            try {
                if (j > 0) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jElapsedRealtime2 = j;
                    while (!isFlying && jElapsedRealtime2 > 0) {
                        airshipLock.wait(jElapsedRealtime2);
                        jElapsedRealtime2 = j - (SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }
                } else {
                    while (!isFlying) {
                        airshipLock.wait();
                    }
                }
                if (isFlying) {
                    return sharedAirship;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            return null;
        }
    }

    @NonNull
    public static Cancelable shared(@Nullable Looper looper, @NonNull final OnReadyCallback onReadyCallback) {
        CancelableOperation cancelableOperation = new CancelableOperation(looper) { // from class: com.urbanairship.UAirship.1
            @Override // com.urbanairship.CancelableOperation
            public void onRun() {
                OnReadyCallback onReadyCallback2 = onReadyCallback;
                if (onReadyCallback2 != null) {
                    onReadyCallback2.onAirshipReady(UAirship.shared());
                }
            }
        };
        List list = pendingAirshipRequests;
        synchronized (list) {
            try {
                if (queuePendingAirshipRequests) {
                    list.add(cancelableOperation);
                } else {
                    cancelableOperation.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancelableOperation;
    }

    @MainThread
    public static void takeOff(@NonNull Application application2) {
        takeOff(application2, null, null);
    }

    @MainThread
    public static void takeOff(@NonNull Application application2, @Nullable OnReadyCallback onReadyCallback) {
        takeOff(application2, null, onReadyCallback);
    }

    @MainThread
    public static void takeOff(@NonNull Application application2, @Nullable AirshipConfigOptions airshipConfigOptions) {
        takeOff(application2, airshipConfigOptions, null);
    }

    @MainThread
    public static void takeOff(@NonNull final Application application2, @Nullable final AirshipConfigOptions airshipConfigOptions, @Nullable final OnReadyCallback onReadyCallback) {
        if (application2 == null) {
            throw new IllegalArgumentException("Application argument must not be null");
        }
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            UALog.e("takeOff() must be called on the main thread!", new Object[0]);
        }
        isMainProcess = ProcessUtils.isMainProcess(application2);
        AirshipAppBootstrap.init(application2);
        if (LOG_TAKE_OFF_STACKTRACE) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : new Exception().getStackTrace()) {
                sb.append("\n\tat ");
                sb.append(stackTraceElement.toString());
            }
            UALog.d("Takeoff stack trace: %s", sb.toString());
        }
        synchronized (airshipLock) {
            try {
                if (!isFlying && !isTakingOff) {
                    UALog.i("Airship taking off!", new Object[0]);
                    isTakingOff = true;
                    application = application2;
                    AirshipExecutors.threadPoolExecutor().execute(new Runnable() { // from class: com.urbanairship.UAirship.2
                        @Override // java.lang.Runnable
                        public void run() {
                            UAirship.executeTakeOff(application2, airshipConfigOptions, onReadyCallback);
                        }
                    });
                    return;
                }
                UALog.e("You can only call takeOff() once.", new Object[0]);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void executeTakeOff(Application application2, AirshipConfigOptions airshipConfigOptions, OnReadyCallback onReadyCallback) {
        if (airshipConfigOptions == null) {
            airshipConfigOptions = new AirshipConfigOptions.Builder().applyDefaultProperties(application2.getApplicationContext()).build();
        }
        airshipConfigOptions.validate();
        UALog.setLogLevel(airshipConfigOptions.logLevel);
        UALog.setLogPrivacyLevel(airshipConfigOptions.logPrivacyLevel);
        UALog.setTag(getAppName() + " - " + UALog.DEFAULT_TAG);
        UALog.i("Airship taking off!", new Object[0]);
        UALog.i("Airship log level: %s", Integer.valueOf(airshipConfigOptions.logLevel));
        UALog.i("UA Version: %s / App key = %s Production = %s", getVersion(), airshipConfigOptions.appKey, Boolean.valueOf(airshipConfigOptions.inProduction));
        UALog.v(BuildConfig.SDK_VERSION, new Object[0]);
        sharedAirship = new UAirship(airshipConfigOptions);
        synchronized (airshipLock) {
            try {
                isFlying = true;
                isTakingOff = false;
                sharedAirship.init();
                UALog.i("Airship ready!", new Object[0]);
                if (onReadyCallback != null) {
                    onReadyCallback.onAirshipReady(sharedAirship);
                }
                Iterator<AirshipComponent> it = sharedAirship.getComponents().iterator();
                while (it.hasNext()) {
                    it.next().onAirshipReady(sharedAirship);
                }
                List list = pendingAirshipRequests;
                synchronized (list) {
                    try {
                        queuePendingAirshipRequests = false;
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            ((Runnable) it2.next()).run();
                        }
                        pendingAirshipRequests.clear();
                    } finally {
                    }
                }
                Intent intentAddCategory = new Intent(ACTION_AIRSHIP_READY).setPackage(getPackageName()).addCategory(getPackageName());
                if (sharedAirship.runtimeConfig.getConfigOptions().extendedBroadcastsEnabled) {
                    intentAddCategory.putExtra("channel_id", sharedAirship.channel.getId());
                    intentAddCategory.putExtra(EXTRA_APP_KEY_KEY, sharedAirship.runtimeConfig.getConfigOptions().appKey);
                    intentAddCategory.putExtra(EXTRA_PAYLOAD_VERSION_KEY, 1);
                }
                application2.sendBroadcast(intentAddCategory);
                airshipLock.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void land() {
        synchronized (airshipLock) {
            try {
                if (isTakingOff || isFlying) {
                    shared().tearDown();
                    isFlying = false;
                    isTakingOff = false;
                    sharedAirship = null;
                    application = null;
                    queuePendingAirshipRequests = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDeepLinkListener(@Nullable DeepLinkListener deepLinkListener) {
        this.deepLinkListener = deepLinkListener;
    }

    public static String getPackageName() {
        return getApplicationContext().getPackageName();
    }

    @NonNull
    public static PackageManager getPackageManager() {
        return getApplicationContext().getPackageManager();
    }

    @Nullable
    public DeepLinkListener getDeepLinkListener() {
        return this.deepLinkListener;
    }

    @Nullable
    public static PackageInfo getPackageInfo() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            UALog.w(e, "UAirship - Unable to get package info.", new Object[0]);
            return null;
        }
    }

    @NonNull
    public static ApplicationInfo getAppInfo() {
        return getApplicationContext().getApplicationInfo();
    }

    @NonNull
    public static String getAppName() {
        return getPackageManager().getApplicationLabel(getAppInfo()).toString();
    }

    public static int getAppIcon() {
        ApplicationInfo appInfo = getAppInfo();
        if (appInfo != null) {
            return appInfo.icon;
        }
        return -1;
    }

    public static long getAppVersion() {
        PackageInfo packageInfo = getPackageInfo();
        if (packageInfo != null) {
            return PackageInfoCompat.getLongVersionCode(packageInfo);
        }
        return -1L;
    }

    @NonNull
    public static Context getApplicationContext() {
        Application application2 = application;
        if (application2 == null) {
            throw new IllegalStateException("TakeOff must be called first.");
        }
        return application2.getApplicationContext();
    }

    public static boolean isFlying() {
        return isFlying;
    }

    public static boolean isTakingOff() {
        return isTakingOff;
    }

    public static boolean isMainProcess() {
        return isMainProcess;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageLoader getImageLoader() {
        if (this.imageLoader == null) {
            this.imageLoader = AirshipGlideImageLoader.INSTANCE;
        }
        return this.imageLoader;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AirshipRuntimeConfig getRuntimeConfig() {
        return this.runtimeConfig;
    }

    @NonNull
    public static String getVersion() {
        return "19.9.1";
    }

    private void init() {
        PreferenceDataStore preferenceDataStoreLoadDataStore = PreferenceDataStore.loadDataStore(getApplicationContext(), this.airshipConfigOptions);
        this.preferenceDataStore = preferenceDataStoreLoadDataStore;
        RemoteConfigObserver remoteConfigObserver = new RemoteConfigObserver(preferenceDataStoreLoadDataStore);
        PreferenceDataStore preferenceDataStore = this.preferenceDataStore;
        AirshipConfigOptions airshipConfigOptions = this.airshipConfigOptions;
        this.privacyManager = new PrivacyManager(preferenceDataStore, airshipConfigOptions.enabledFeatures, remoteConfigObserver, airshipConfigOptions.resetEnabledFeatures);
        this.permissionsManager = new PermissionsManager(application);
        this.localeManager = new LocaleManager(application, this.preferenceDataStore);
        Supplier supplierLazyLoader = PushProviders.lazyLoader(application, this.airshipConfigOptions);
        AudienceOverridesProvider audienceOverridesProvider = new AudienceOverridesProvider();
        DeferredPlatformProvider deferredPlatformProvider = new DeferredPlatformProvider(application, this.preferenceDataStore, this.privacyManager, supplierLazyLoader);
        DefaultRequestSession defaultRequestSession = new DefaultRequestSession(this.airshipConfigOptions, deferredPlatformProvider);
        this.runtimeConfig = new AirshipRuntimeConfig((Provider<AirshipConfigOptions>) new Provider() { // from class: com.urbanairship.UAirship$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Provider
            public final Object get() {
                return this.f$0.lambda$init$0();
            }
        }, defaultRequestSession, remoteConfigObserver, deferredPlatformProvider);
        AirshipChannel airshipChannel = new AirshipChannel(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.permissionsManager, this.localeManager, audienceOverridesProvider, new ChannelRegistrar(getApplicationContext(), this.preferenceDataStore, this.runtimeConfig, this.privacyManager));
        this.channel = airshipChannel;
        defaultRequestSession.setChannelAuthTokenProvider(airshipChannel.getAuthTokenProvider());
        this.components.add(this.channel);
        this.urlAllowList = UrlAllowList.createDefaultUrlAllowList(this.airshipConfigOptions);
        ActionRegistry actionRegistry = new ActionRegistry();
        this.actionRegistry = actionRegistry;
        actionRegistry.registerDefaultActions(getApplicationContext());
        AirshipEventFeed airshipEventFeed = new AirshipEventFeed(this.privacyManager, this.airshipConfigOptions.analyticsEnabled);
        Analytics analytics = new Analytics(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.channel, this.localeManager, this.permissionsManager, airshipEventFeed);
        this.analytics = analytics;
        this.components.add(analytics);
        this.inputValidator = new DefaultInputValidator(this.runtimeConfig);
        ApplicationMetrics applicationMetrics = new ApplicationMetrics(application, this.preferenceDataStore, this.privacyManager);
        this.applicationMetrics = applicationMetrics;
        this.components.add(applicationMetrics);
        PushManager pushManager = new PushManager(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, supplierLazyLoader, this.channel, this.analytics, this.permissionsManager);
        this.pushManager = pushManager;
        this.components.add(pushManager);
        Application application2 = application;
        ChannelCapture channelCapture = new ChannelCapture(application2, this.airshipConfigOptions, this.channel, this.preferenceDataStore, GlobalActivityMonitor.shared(application2));
        this.channelCapture = channelCapture;
        this.components.add(channelCapture);
        Contact contact = new Contact(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.channel, this.localeManager, audienceOverridesProvider, this.pushManager, this.inputValidator);
        this.contact = contact;
        this.components.add(contact);
        defaultRequestSession.setContactAuthTokenProvider(this.contact.getAuthTokenProvider());
        DeferredResolver deferredResolver = new DeferredResolver(this.runtimeConfig, audienceOverridesProvider);
        RemoteData remoteData = new RemoteData(application, this.runtimeConfig, this.preferenceDataStore, this.privacyManager, this.localeManager, this.pushManager, supplierLazyLoader, this.contact);
        this.remoteData = remoteData;
        this.components.add(remoteData);
        AirshipMeteredUsage airshipMeteredUsage = new AirshipMeteredUsage(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.contact);
        this.meteredUsageManager = airshipMeteredUsage;
        this.components.add(airshipMeteredUsage);
        RemoteConfigManager remoteConfigManager = new RemoteConfigManager(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.remoteData);
        this.remoteConfigManager = remoteConfigManager;
        this.components.add(remoteConfigManager);
        AirshipCache airshipCache = new AirshipCache(application, this.runtimeConfig);
        AudienceEvaluator audienceEvaluator = new AudienceEvaluator(airshipCache);
        ExperimentManager experimentManager = new ExperimentManager(application, this.preferenceDataStore, this.remoteData, Clock.DEFAULT_CLOCK, audienceEvaluator);
        this.experimentManager = experimentManager;
        this.components.add(experimentManager);
        processModule(Modules.debug(application, this.preferenceDataStore, this.remoteData));
        processModule(Modules.messageCenter(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.channel, this.pushManager));
        LocationModule locationModuleLocation = Modules.location(application, this.preferenceDataStore, this.privacyManager, this.channel, this.permissionsManager);
        processModule(locationModuleLocation);
        this.locationClient = locationModuleLocation == null ? null : locationModuleLocation.getLocationClient();
        processModule(Modules.automation(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.channel, this.pushManager, this.analytics, this.remoteData, this.experimentManager, this.meteredUsageManager, deferredResolver, airshipEventFeed, this.applicationMetrics, airshipCache, audienceEvaluator));
        processModule(Modules.adId(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.analytics));
        processModule(Modules.preferenceCenter(application, this.preferenceDataStore, this.privacyManager, this.remoteData, this.inputValidator));
        processModule(Modules.liveUpdateManager(application, this.preferenceDataStore, this.runtimeConfig, this.privacyManager, this.channel, this.pushManager));
        processModule(Modules.featureFlags(application, this.preferenceDataStore, this.remoteData, this.analytics, airshipCache, deferredResolver, this.privacyManager));
        Iterator it = this.components.iterator();
        while (it.hasNext()) {
            ((AirshipComponent) it.next()).init();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AirshipConfigOptions lambda$init$0() {
        return this.airshipConfigOptions;
    }

    private void processModule(Module module) {
        if (module != null) {
            this.components.addAll(module.getComponents());
            module.registerActions(application, getActionRegistry());
        }
    }

    private void tearDown() {
        Iterator<AirshipComponent> it = getComponents().iterator();
        while (it.hasNext()) {
            it.next().tearDown();
        }
        this.preferenceDataStore.tearDown();
    }

    @NonNull
    public AirshipConfigOptions getAirshipConfigOptions() {
        return this.airshipConfigOptions;
    }

    @NonNull
    public PushManager getPushManager() {
        return this.pushManager;
    }

    @NonNull
    public AirshipChannel getChannel() {
        return this.channel;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AirshipLocationClient getLocationClient() {
        return this.locationClient;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteData getRemoteData() {
        return this.remoteData;
    }

    @NonNull
    public Analytics getAnalytics() {
        return this.analytics;
    }

    @NonNull
    public PermissionsManager getPermissionsManager() {
        return this.permissionsManager;
    }

    @NonNull
    public ApplicationMetrics getApplicationMetrics() {
        return this.applicationMetrics;
    }

    @NonNull
    public UrlAllowList getUrlAllowList() {
        return this.urlAllowList;
    }

    @NonNull
    public AirshipInputValidation.Validator getInputValidator() {
        return this.inputValidator;
    }

    @NonNull
    public ActionRegistry getActionRegistry() {
        return this.actionRegistry;
    }

    @NonNull
    public ChannelCapture getChannelCapture() {
        return this.channelCapture;
    }

    @NonNull
    public Contact getContact() {
        return this.contact;
    }

    public int getPlatformType() {
        return this.runtimeConfig.getPlatform();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<AirshipComponent> getComponents() {
        return this.components;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T extends AirshipComponent> T getComponent(@NonNull Class<T> cls) {
        T t = (T) this.componentClassMap.get(cls);
        if (t == null) {
            Iterator it = this.components.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                AirshipComponent airshipComponent = (AirshipComponent) it.next();
                if (airshipComponent.getClass().equals(cls)) {
                    this.componentClassMap.put(cls, airshipComponent);
                    t = (T) airshipComponent;
                    break;
                }
            }
        }
        if (t != null) {
            return t;
        }
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T extends AirshipComponent> T requireComponent(@NonNull Class<T> cls) {
        T t = (T) getComponent(cls);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Unable to find component " + cls);
    }

    @MainThread
    public boolean deepLink(@NonNull String str) {
        Uri uri = Uri.parse(str);
        if ("uairship".equals(uri.getScheme())) {
            if (handleAirshipDeeplink(uri, getApplicationContext())) {
                return true;
            }
            Iterator<AirshipComponent> it = getComponents().iterator();
            while (it.hasNext()) {
                if (it.next().onAirshipDeepLink(uri)) {
                    return true;
                }
            }
            DeepLinkListener deepLinkListener = getDeepLinkListener();
            if (deepLinkListener != null && deepLinkListener.onDeepLink(str)) {
                return true;
            }
            UALog.d("Airship deep link not handled: %s", str);
            return true;
        }
        DeepLinkListener deepLinkListener2 = getDeepLinkListener();
        return deepLinkListener2 != null && deepLinkListener2.onDeepLink(str);
    }

    private boolean handleAirshipDeeplink(Uri uri, Context context) {
        String encodedAuthority = uri.getEncodedAuthority();
        encodedAuthority.hashCode();
        if (encodedAuthority.equals("app_settings")) {
            context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), null)).addFlags(268435456));
            return true;
        }
        if (!encodedAuthority.equals("app_store")) {
            return false;
        }
        context.startActivity(AppStoreUtils.getAppStoreIntent(context, getPlatformType(), getAirshipConfigOptions()).addFlags(268435456));
        return true;
    }

    @NonNull
    public PrivacyManager getPrivacyManager() {
        return this.privacyManager;
    }

    public void setLocaleOverride(@Nullable Locale locale) {
        this.localeManager.setLocaleOverride(locale);
    }

    public Locale getLocale() {
        return this.localeManager.getLocale();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LocaleManager getLocaleManager() {
        return this.localeManager;
    }
}
