package com.microsoft.appcenter;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import ch.qos.logback.classic.net.SyslogAppender;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.channel.OneCollectorChannelListener;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.models.CustomPropertiesLog;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.ingestion.models.json.CustomPropertiesLogFactory;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.json.StartServiceLogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.ApplicationLifecycleListener;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes4.dex */
public class AppCenter {
    public static final String LOG_TAG = "AppCenter";
    private static AppCenter sInstance;
    private AppCenterHandler mAppCenterHandler;
    private String mAppSecret;
    private Application mApplication;
    private ApplicationLifecycleListener mApplicationLifecycleListener;
    private Channel mChannel;
    private boolean mConfiguredFromApp;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mLogLevelConfigured;
    private LogSerializer mLogSerializer;
    private String mLogUrl;
    private OneCollectorChannelListener mOneCollectorChannelListener;
    private Set mServices;
    private Set mServicesStartedFromLibrary;
    private DefaultAppCenterFuture mSetMaxStorageSizeFuture;
    private String mTransmissionTargetToken;
    private UncaughtExceptionHandler mUncaughtExceptionHandler;
    private final List mStartedServicesNamesToLog = new ArrayList();
    private long mMaxStorageSizeInBytes = SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE;

    public static synchronized AppCenter getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new AppCenter();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static void setWrapperSdk(WrapperSdk wrapperSdk) {
        getInstance().setInstanceWrapperSdk(wrapperSdk);
    }

    @IntRange(from = 2, to = 8)
    public static int getLogLevel() {
        return AppCenterLog.getLogLevel();
    }

    public static void setLogLevel(@IntRange(from = 2, to = 8) int i) {
        getInstance().setInstanceLogLevel(i);
    }

    public static void setLogUrl(String str) {
        getInstance().setInstanceLogUrl(str);
    }

    public static String getSdkVersion() {
        return "3.3.0";
    }

    public static void setCustomProperties(CustomProperties customProperties) {
        getInstance().setInstanceCustomProperties(customProperties);
    }

    public static boolean isConfigured() {
        return getInstance().isInstanceConfigured();
    }

    public static boolean isRunningInAppCenterTestCloud() {
        try {
            return "1".equals(InstrumentationRegistryHelper.getArguments().getString("RUNNING_IN_APP_CENTER"));
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public static void configure(Application application, String str) {
        getInstance().configureInstanceWithRequiredAppSecret(application, str);
    }

    public static void configure(Application application) {
        getInstance().configureInstance(application, null, true);
    }

    @SafeVarargs
    public static void start(Class<? extends AppCenterService>... clsArr) {
        getInstance().startServices(true, clsArr);
    }

    @SafeVarargs
    public static void start(Application application, String str, Class<? extends AppCenterService>... clsArr) {
        getInstance().configureAndStartServices(application, str, clsArr);
    }

    @SafeVarargs
    public static void start(Application application, Class<? extends AppCenterService>... clsArr) {
        getInstance().configureAndStartServices(application, null, true, clsArr);
    }

    @SafeVarargs
    public static void startFromLibrary(Context context, Class<? extends AppCenterService>... clsArr) {
        getInstance().startInstanceFromLibrary(context, clsArr);
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        return getInstance().isInstanceEnabledAsync();
    }

    public static AppCenterFuture<Void> setEnabled(boolean z) {
        return getInstance().setInstanceEnabledAsync(z);
    }

    public static AppCenterFuture<UUID> getInstallId() {
        return getInstance().getInstanceInstallIdAsync();
    }

    public static AppCenterFuture<Boolean> setMaxStorageSize(long j) {
        return getInstance().setInstanceMaxStorageSizeAsync(j);
    }

    private synchronized void setInstanceUserId(String str) {
        if (!this.mConfiguredFromApp) {
            AppCenterLog.error("AppCenter", "AppCenter must be configured from application, libraries cannot use call setUserId.");
            return;
        }
        String str2 = this.mAppSecret;
        if (str2 == null && this.mTransmissionTargetToken == null) {
            AppCenterLog.error("AppCenter", "AppCenter must be configured with a secret from application to call setUserId.");
            return;
        }
        if (str != null) {
            if (str2 != null && !UserIdContext.checkUserIdValidForAppCenter(str)) {
                return;
            }
            if (this.mTransmissionTargetToken != null && !UserIdContext.checkUserIdValidForOneCollector(str)) {
                return;
            }
        }
        UserIdContext.getInstance().setUserId(str);
    }

    private synchronized boolean checkPrecondition() {
        if (isInstanceConfigured()) {
            return true;
        }
        AppCenterLog.error("AppCenter", "App Center hasn't been configured. You need to call AppCenter.start with appSecret or AppCenter.configure first.");
        return false;
    }

    private synchronized void setInstanceWrapperSdk(WrapperSdk wrapperSdk) {
        DeviceInfoHelper.setWrapperSdk(wrapperSdk);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    AppCenter.this.mChannel.invalidateDeviceCache();
                }
            });
        }
    }

    private synchronized void setInstanceLogLevel(int i) {
        this.mLogLevelConfigured = true;
        AppCenterLog.setLogLevel(i);
    }

    private synchronized void setInstanceLogUrl(final String str) {
        this.mLogUrl = str;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AppCenter.this.mAppSecret != null) {
                        AppCenterLog.info("AppCenter", "The log url of App Center endpoint has been changed to " + str);
                        AppCenter.this.mChannel.setLogUrl(str);
                        return;
                    }
                    AppCenterLog.info("AppCenter", "The log url of One Collector endpoint has been changed to " + str);
                    AppCenter.this.mOneCollectorChannelListener.setLogUrl(str);
                }
            });
        }
    }

    private synchronized void setInstanceCustomProperties(CustomProperties customProperties) {
        if (customProperties == null) {
            AppCenterLog.error("AppCenter", "Custom properties may not be null.");
            return;
        }
        final Map properties = customProperties.getProperties();
        if (properties.size() == 0) {
            AppCenterLog.error("AppCenter", "Custom properties may not be empty.");
        } else {
            handlerAppCenterOperation(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.3
                @Override // java.lang.Runnable
                public void run() {
                    AppCenter.this.queueCustomProperties(properties);
                }
            }, null);
        }
    }

    private synchronized AppCenterFuture setInstanceMaxStorageSizeAsync(long j) {
        DefaultAppCenterFuture defaultAppCenterFuture = new DefaultAppCenterFuture();
        if (this.mConfiguredFromApp) {
            AppCenterLog.error("AppCenter", "setMaxStorageSize may not be called after App Center has been configured.");
            defaultAppCenterFuture.complete(Boolean.FALSE);
            return defaultAppCenterFuture;
        }
        if (j < 24576) {
            AppCenterLog.error("AppCenter", "Maximum storage size must be at least 24576 bytes.");
            defaultAppCenterFuture.complete(Boolean.FALSE);
            return defaultAppCenterFuture;
        }
        if (this.mSetMaxStorageSizeFuture != null) {
            AppCenterLog.error("AppCenter", "setMaxStorageSize may only be called once per app launch.");
            defaultAppCenterFuture.complete(Boolean.FALSE);
            return defaultAppCenterFuture;
        }
        this.mMaxStorageSizeInBytes = j;
        this.mSetMaxStorageSizeFuture = defaultAppCenterFuture;
        return defaultAppCenterFuture;
    }

    private synchronized boolean isInstanceConfigured() {
        return this.mApplication != null;
    }

    private void configureInstanceWithRequiredAppSecret(Application application, String str) {
        if (str == null || str.isEmpty()) {
            AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
        } else {
            configureInstance(application, str, true);
        }
    }

    private synchronized boolean configureInstance(Application application, String str, final boolean z) {
        if (application == null) {
            AppCenterLog.error("AppCenter", "Application context may not be null.");
            return false;
        }
        if (!this.mLogLevelConfigured && (application.getApplicationInfo().flags & 2) == 2) {
            AppCenterLog.setLogLevel(5);
        }
        String str2 = this.mAppSecret;
        if (z && !configureSecretString(str)) {
            return false;
        }
        if (this.mHandler != null) {
            String str3 = this.mAppSecret;
            if (str3 != null && !str3.equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AppCenter.this.mChannel.setAppSecret(AppCenter.this.mAppSecret);
                        AppCenter.this.applyStorageMaxSize();
                    }
                });
            }
            return true;
        }
        this.mApplication = application;
        HandlerThread handlerThread = new HandlerThread("AppCenter.Looper");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mAppCenterHandler = new AppCenterHandler() { // from class: com.microsoft.appcenter.AppCenter.5
            @Override // com.microsoft.appcenter.AppCenterHandler
            public void post(Runnable runnable, Runnable runnable2) {
                AppCenter.this.handlerAppCenterOperation(runnable, runnable2);
            }
        };
        ApplicationLifecycleListener applicationLifecycleListener = new ApplicationLifecycleListener(this.mHandler);
        this.mApplicationLifecycleListener = applicationLifecycleListener;
        this.mApplication.registerActivityLifecycleCallbacks(applicationLifecycleListener);
        this.mServices = new HashSet();
        this.mServicesStartedFromLibrary = new HashSet();
        this.mHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.6
            @Override // java.lang.Runnable
            public void run() {
                AppCenter.this.finishConfiguration(z);
            }
        });
        AppCenterLog.info("AppCenter", "App Center SDK configured successfully.");
        return true;
    }

    private boolean configureSecretString(String str) {
        if (this.mConfiguredFromApp) {
            AppCenterLog.warn("AppCenter", "App Center may only be configured once.");
            return false;
        }
        this.mConfiguredFromApp = true;
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.split("=", -1);
                String str3 = strArrSplit[0];
                if (strArrSplit.length == 1) {
                    if (!str3.isEmpty()) {
                        this.mAppSecret = str3;
                    }
                } else if (!strArrSplit[1].isEmpty()) {
                    String str4 = strArrSplit[1];
                    if ("appsecret".equals(str3)) {
                        this.mAppSecret = str4;
                    } else if (TypedValues.AttributesType.S_TARGET.equals(str3)) {
                        this.mTransmissionTargetToken = str4;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handlerAppCenterOperation(final Runnable runnable, final Runnable runnable2) {
        try {
            if (checkPrecondition()) {
                Runnable runnable3 = new Runnable() { // from class: com.microsoft.appcenter.AppCenter.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AppCenter.this.isInstanceEnabled()) {
                            runnable.run();
                            return;
                        }
                        Runnable runnable4 = runnable2;
                        if (runnable4 != null) {
                            runnable4.run();
                        } else {
                            AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
                        }
                    }
                };
                if (Thread.currentThread() == this.mHandlerThread) {
                    runnable.run();
                } else {
                    this.mHandler.post(runnable3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishConfiguration(boolean z) {
        Constants.loadFromContext(this.mApplication);
        FileManager.initialize(this.mApplication);
        SharedPreferencesManager.initialize(this.mApplication);
        SessionContext.getInstance();
        boolean zIsInstanceEnabled = isInstanceEnabled();
        HttpClient httpClient = DependencyConfiguration.getHttpClient();
        if (httpClient == null) {
            httpClient = HttpUtils.createHttpClient(this.mApplication);
        }
        DefaultLogSerializer defaultLogSerializer = new DefaultLogSerializer();
        this.mLogSerializer = defaultLogSerializer;
        defaultLogSerializer.addLogFactory(StartServiceLog.TYPE, new StartServiceLogFactory());
        this.mLogSerializer.addLogFactory(CustomPropertiesLog.TYPE, new CustomPropertiesLogFactory());
        DefaultChannel defaultChannel = new DefaultChannel(this.mApplication, this.mAppSecret, this.mLogSerializer, httpClient, this.mHandler);
        this.mChannel = defaultChannel;
        if (z) {
            applyStorageMaxSize();
        } else {
            defaultChannel.setMaxStorageSize(SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE);
        }
        this.mChannel.setEnabled(zIsInstanceEnabled);
        this.mChannel.addGroup("group_core", 50, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, 3, null, null);
        this.mOneCollectorChannelListener = new OneCollectorChannelListener(this.mChannel, this.mLogSerializer, httpClient, IdHelper.getInstallId());
        if (this.mLogUrl != null) {
            if (this.mAppSecret != null) {
                AppCenterLog.info("AppCenter", "The log url of App Center endpoint has been changed to " + this.mLogUrl);
                this.mChannel.setLogUrl(this.mLogUrl);
            } else {
                AppCenterLog.info("AppCenter", "The log url of One Collector endpoint has been changed to " + this.mLogUrl);
                this.mOneCollectorChannelListener.setLogUrl(this.mLogUrl);
            }
        }
        this.mChannel.addListener(this.mOneCollectorChannelListener);
        if (!zIsInstanceEnabled) {
            NetworkStateHelper.getSharedInstance(this.mApplication).close();
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler(this.mHandler, this.mChannel);
        this.mUncaughtExceptionHandler = uncaughtExceptionHandler;
        if (zIsInstanceEnabled) {
            uncaughtExceptionHandler.register();
        }
        AppCenterLog.debug("AppCenter", "App Center initialized.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyStorageMaxSize() {
        boolean maxStorageSize = this.mChannel.setMaxStorageSize(this.mMaxStorageSizeInBytes);
        DefaultAppCenterFuture defaultAppCenterFuture = this.mSetMaxStorageSizeFuture;
        if (defaultAppCenterFuture != null) {
            defaultAppCenterFuture.complete(Boolean.valueOf(maxStorageSize));
        }
    }

    private final synchronized void startServices(final boolean z, Class... clsArr) {
        if (clsArr == null) {
            AppCenterLog.error("AppCenter", "Cannot start services, services array is null. Failed to start services.");
            return;
        }
        if (this.mApplication == null) {
            StringBuilder sb = new StringBuilder();
            for (Class cls : clsArr) {
                sb.append(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                sb.append(cls.getName());
                sb.append("\n");
            }
            AppCenterLog.error("AppCenter", "Cannot start services, App Center has not been configured. Failed to start the following services:\n" + ((Object) sb));
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (Class cls2 : clsArr) {
            if (cls2 == null) {
                AppCenterLog.warn("AppCenter", "Skipping null service, please check your varargs/array does not contain any null reference.");
            } else {
                try {
                    startOrUpdateService((AppCenterService) cls2.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), arrayList, arrayList2, z);
                } catch (Exception e) {
                    AppCenterLog.error("AppCenter", "Failed to get service instance '" + cls2.getName() + "', skipping it.", e);
                }
            }
        }
        this.mHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.8
            @Override // java.lang.Runnable
            public void run() {
                AppCenter.this.finishStartServices(arrayList2, arrayList, z);
            }
        });
    }

    private void startOrUpdateService(AppCenterService appCenterService, Collection collection, Collection collection2, boolean z) {
        if (z) {
            startOrUpdateServiceFromApp(appCenterService, collection, collection2);
        } else {
            if (this.mServices.contains(appCenterService)) {
                return;
            }
            startServiceFromLibrary(appCenterService, collection);
        }
    }

    private void startOrUpdateServiceFromApp(AppCenterService appCenterService, Collection collection, Collection collection2) {
        String serviceName = appCenterService.getServiceName();
        if (this.mServices.contains(appCenterService)) {
            if (this.mServicesStartedFromLibrary.remove(appCenterService)) {
                collection2.add(appCenterService);
                return;
            }
            AppCenterLog.warn("AppCenter", "App Center has already started the service with class name: " + appCenterService.getServiceName());
            return;
        }
        if (this.mAppSecret == null && appCenterService.isAppSecretRequired()) {
            AppCenterLog.error("AppCenter", "App Center was started without app secret, but the service requires it; not starting service " + serviceName + InstructionFileId.DOT);
            return;
        }
        startService(appCenterService, collection);
    }

    private void startServiceFromLibrary(AppCenterService appCenterService, Collection collection) {
        String serviceName = appCenterService.getServiceName();
        if (appCenterService.isAppSecretRequired()) {
            AppCenterLog.error("AppCenter", "This service cannot be started from a library: " + serviceName + InstructionFileId.DOT);
            return;
        }
        if (startService(appCenterService, collection)) {
            this.mServicesStartedFromLibrary.add(appCenterService);
        }
    }

    private boolean startService(AppCenterService appCenterService, Collection collection) {
        String serviceName = appCenterService.getServiceName();
        if (ServiceInstrumentationUtils.isServiceDisabledByInstrumentation(serviceName)) {
            AppCenterLog.debug("AppCenter", "Instrumentation variable to disable service has been set; not starting service " + serviceName + InstructionFileId.DOT);
            return false;
        }
        appCenterService.onStarting(this.mAppCenterHandler);
        this.mApplicationLifecycleListener.registerApplicationLifecycleCallbacks(appCenterService);
        this.mApplication.registerActivityLifecycleCallbacks(appCenterService);
        this.mServices.add(appCenterService);
        collection.add(appCenterService);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishStartServices(Iterable iterable, Iterable iterable2, boolean z) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            AppCenterService appCenterService = (AppCenterService) it.next();
            appCenterService.onConfigurationUpdated(this.mAppSecret, this.mTransmissionTargetToken);
            AppCenterLog.info("AppCenter", appCenterService.getClass().getSimpleName() + " service configuration updated.");
        }
        boolean zIsInstanceEnabled = isInstanceEnabled();
        Iterator it2 = iterable2.iterator();
        while (it2.hasNext()) {
            AppCenterService appCenterService2 = (AppCenterService) it2.next();
            Map<String, LogFactory> logFactories = appCenterService2.getLogFactories();
            if (logFactories != null) {
                for (Map.Entry<String, LogFactory> entry : logFactories.entrySet()) {
                    this.mLogSerializer.addLogFactory(entry.getKey(), entry.getValue());
                }
            }
            if (!zIsInstanceEnabled && appCenterService2.isInstanceEnabled()) {
                appCenterService2.setInstanceEnabled(false);
            }
            if (z) {
                appCenterService2.onStarted(this.mApplication, this.mChannel, this.mAppSecret, this.mTransmissionTargetToken, true);
                AppCenterLog.info("AppCenter", appCenterService2.getClass().getSimpleName() + " service started from application.");
            } else {
                appCenterService2.onStarted(this.mApplication, this.mChannel, null, null, false);
                AppCenterLog.info("AppCenter", appCenterService2.getClass().getSimpleName() + " service started from library.");
            }
        }
        if (z) {
            Iterator it3 = iterable.iterator();
            while (it3.hasNext()) {
                this.mStartedServicesNamesToLog.add(((AppCenterService) it3.next()).getServiceName());
            }
            Iterator it4 = iterable2.iterator();
            while (it4.hasNext()) {
                this.mStartedServicesNamesToLog.add(((AppCenterService) it4.next()).getServiceName());
            }
            sendStartServiceLog();
        }
    }

    private void sendStartServiceLog() {
        if (this.mStartedServicesNamesToLog.isEmpty() || !isInstanceEnabled()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mStartedServicesNamesToLog);
        this.mStartedServicesNamesToLog.clear();
        StartServiceLog startServiceLog = new StartServiceLog();
        startServiceLog.setServices(arrayList);
        this.mChannel.enqueue(startServiceLog, "group_core", 1);
    }

    private synchronized void configureAndStartServices(Application application, String str, Class[] clsArr) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
                } else {
                    configureAndStartServices(application, str, true, clsArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
        }
    }

    private synchronized void startInstanceFromLibrary(Context context, Class[] clsArr) {
        Application application;
        if (context != null) {
            try {
                application = (Application) context.getApplicationContext();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            application = null;
        }
        configureAndStartServices(application, null, false, clsArr);
    }

    private void configureAndStartServices(Application application, String str, boolean z, Class[] clsArr) {
        if (configureInstance(application, str, z)) {
            startServices(z, clsArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueCustomProperties(Map map) {
        CustomPropertiesLog customPropertiesLog = new CustomPropertiesLog();
        customPropertiesLog.setProperties(map);
        this.mChannel.enqueue(customPropertiesLog, "group_core", 1);
    }

    private synchronized AppCenterFuture isInstanceEnabledAsync() {
        final DefaultAppCenterFuture defaultAppCenterFuture;
        try {
            defaultAppCenterFuture = new DefaultAppCenterFuture();
            if (checkPrecondition()) {
                this.mAppCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.9
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultAppCenterFuture.complete(Boolean.TRUE);
                    }
                }, new Runnable() { // from class: com.microsoft.appcenter.AppCenter.10
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultAppCenterFuture.complete(Boolean.FALSE);
                    }
                });
            } else {
                defaultAppCenterFuture.complete(Boolean.FALSE);
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultAppCenterFuture;
    }

    boolean isInstanceEnabled() {
        return SharedPreferencesManager.getBoolean("enabled", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInstanceEnabled(boolean z) {
        this.mChannel.setEnabled(z);
        boolean zIsInstanceEnabled = isInstanceEnabled();
        boolean z2 = zIsInstanceEnabled && !z;
        boolean z3 = !zIsInstanceEnabled && z;
        if (z3) {
            this.mUncaughtExceptionHandler.register();
            NetworkStateHelper.getSharedInstance(this.mApplication).reopen();
        } else if (z2) {
            this.mUncaughtExceptionHandler.unregister();
            NetworkStateHelper.getSharedInstance(this.mApplication).close();
        }
        if (z) {
            SharedPreferencesManager.putBoolean("enabled", true);
        }
        if (!this.mStartedServicesNamesToLog.isEmpty() && z3) {
            sendStartServiceLog();
        }
        for (AppCenterService appCenterService : this.mServices) {
            if (appCenterService.isInstanceEnabled() != z) {
                appCenterService.setInstanceEnabled(z);
            }
        }
        if (!z) {
            SharedPreferencesManager.putBoolean("enabled", false);
        }
        if (z2) {
            AppCenterLog.info("AppCenter", "App Center has been disabled.");
            return;
        }
        if (z3) {
            AppCenterLog.info("AppCenter", "App Center has been enabled.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("App Center has already been ");
        sb.append(z ? "enabled" : "disabled");
        sb.append(InstructionFileId.DOT);
        AppCenterLog.info("AppCenter", sb.toString());
    }

    private synchronized AppCenterFuture setInstanceEnabledAsync(final boolean z) {
        final DefaultAppCenterFuture defaultAppCenterFuture;
        try {
            defaultAppCenterFuture = new DefaultAppCenterFuture();
            if (checkPrecondition()) {
                this.mHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.11
                    @Override // java.lang.Runnable
                    public void run() {
                        AppCenter.this.setInstanceEnabled(z);
                        defaultAppCenterFuture.complete(null);
                    }
                });
            } else {
                defaultAppCenterFuture.complete(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultAppCenterFuture;
    }

    private synchronized AppCenterFuture getInstanceInstallIdAsync() {
        final DefaultAppCenterFuture defaultAppCenterFuture;
        try {
            defaultAppCenterFuture = new DefaultAppCenterFuture();
            if (checkPrecondition()) {
                this.mAppCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.AppCenter.12
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultAppCenterFuture.complete(IdHelper.getInstallId());
                    }
                }, new Runnable() { // from class: com.microsoft.appcenter.AppCenter.13
                    @Override // java.lang.Runnable
                    public void run() {
                        defaultAppCenterFuture.complete(null);
                    }
                });
            } else {
                defaultAppCenterFuture.complete(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultAppCenterFuture;
    }

    public static void setUserId(String str) {
        getInstance().setInstanceUserId(str);
    }

    @VisibleForTesting
    public void setChannel(Channel channel) {
        this.mChannel = channel;
    }
}
