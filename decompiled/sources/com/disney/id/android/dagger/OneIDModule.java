package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.BiometricSupport;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.Connectivity;
import com.disney.id.android.EnvironmentConfiguration;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.HeadlessListenerHolder;
import com.disney.id.android.InitializationCallbackHolder;
import com.disney.id.android.MigrationHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDBiometricSupport;
import com.disney.id.android.OneIDConnectivity;
import com.disney.id.android.OneIDGuestHandler;
import com.disney.id.android.OneIDHeadlessListenerHolder;
import com.disney.id.android.OneIDInitializationCallbackHolder;
import com.disney.id.android.OneIDMigrationHandler;
import com.disney.id.android.OneIDRecoveryContext;
import com.disney.id.android.OneIDSCALPBundle;
import com.disney.id.android.OneIDSCALPConfigHandler;
import com.disney.id.android.OneIDSCALPController;
import com.disney.id.android.OneIDSession;
import com.disney.id.android.RecoveryContext;
import com.disney.id.android.SCALPBundle;
import com.disney.id.android.SCALPConfigHandler;
import com.disney.id.android.SCALPController;
import com.disney.id.android.SWID;
import com.disney.id.android.SWIDController;
import com.disney.id.android.Session;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.bundler.OneIDBundler;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.localdata.OneIDExposedStorage;
import com.disney.id.android.localdata.OneIDLocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.logging.OneIDLogger;
import com.disney.id.android.services.AuthorizationInterceptor;
import com.disney.id.android.services.BundlerService;
import com.disney.id.android.services.GCErrorHandlingAdapter;
import com.disney.id.android.services.GCService;
import com.disney.id.android.services.GuestControllerResponseInterceptor;
import com.disney.id.android.services.LogGoService;
import com.disney.id.android.services.ReportingInterceptor;
import com.disney.id.android.services.UserAgentInterceptor;
import com.disney.id.android.tracker.EventQueue;
import com.disney.id.android.tracker.LogGoSender;
import com.disney.id.android.tracker.OneIDEventQueue;
import com.disney.id.android.tracker.OneIDTracker;
import com.disney.id.android.tracker.Sender;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.utils.GsonUtils;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\nH\u0017J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0011H\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J,\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0011H\u0017J\b\u0010 \u001a\u00020!H\u0017J\b\u0010\"\u001a\u00020#H\u0017J\b\u0010$\u001a\u00020%H\u0017J\u0010\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u001c\u0010)\u001a\u00020*2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010+\u001a\u00020,H\u0017J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u0011H\u0017J\b\u0010.\u001a\u00020\u001eH\u0017J\b\u0010/\u001a\u000200H\u0017J\u0010\u00101\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u00102\u001a\u0002032\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u000207H\u0017J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020=H\u0017J\b\u0010>\u001a\u00020?H\u0017J\b\u0010@\u001a\u00020AH\u0017J\u0010\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006E"}, d2 = {"Lcom/disney/id/android/dagger/OneIDModule;", "", "()V", "provideBiometricSupport", "Lcom/disney/id/android/BiometricSupport;", "provideBundler", "Lcom/disney/id/android/bundler/Bundler;", "provideBundlerOkHttpClient", "Lokhttp3/OkHttpClient;", "appContext", "Landroid/content/Context;", "exposedStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "provideBundlerService", "Lcom/disney/id/android/services/BundlerService;", "okHttpClient", "provideConfigHandler", "Lcom/disney/id/android/ConfigHandler;", "provideConnectivity", "Lcom/disney/id/android/Connectivity;", "provideContext", "provideEventQueue", "Lcom/disney/id/android/tracker/EventQueue;", "configHandler", "provideGCOkHttpClient", "provideGCService", "Lcom/disney/id/android/services/GCService;", "baseUrl", "", "logger", "Lcom/disney/id/android/logging/Logger;", "provideGCURL", "provideGuest", "Lcom/disney/id/android/GuestHandler;", "provideHeadlessListenerHolder", "Lcom/disney/id/android/HeadlessListenerHolder;", "provideInitializationCallbackHolder", "Lcom/disney/id/android/InitializationCallbackHolder;", "provideLocalStorage", "Lcom/disney/id/android/localdata/LocalStorage;", "provideLogGoOkHttpClient", "provideLogGoService", "Lcom/disney/id/android/services/LogGoService;", "httpUrl", "Lokhttp3/HttpUrl;", "provideLogGoUrl", "provideLogger", "provideMigrationHandler", "Lcom/disney/id/android/MigrationHandler;", "provideOneIDSharedPreferences", "provideOneIDWebViewFactory", "Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "provideRecoveryContext", "Lcom/disney/id/android/RecoveryContext;", "provideSCALPBundle", "Lcom/disney/id/android/SCALPBundle;", "provideSCALPConfigHandler", "Lcom/disney/id/android/SCALPConfigHandler;", "provideSCALPController", "Lcom/disney/id/android/SCALPController;", "provideSWID", "Lcom/disney/id/android/SWID;", "provideSender", "Lcom/disney/id/android/tracker/Sender;", "provideSession", "Lcom/disney/id/android/Session;", "provideTracker", "Lcom/disney/id/android/tracker/Tracker;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public class OneIDModule {
    public static final long CONNECTION_TIMEOUT_SECONDS = 5;

    @NotNull
    public static final String LOCAL_BUNDLER_CUSTOM_HOST_KEY = "localBundlerUseCustomHost";

    @NotNull
    public static final String LOCAL_BUNDLER_CUSTOM_HOST_PORT_KEY = "localBundlerCustomHostPort";

    @NotNull
    public static final String LOCAL_BUNDLER_CUSTOM_HOST_URL_KEY = "localBundlerCustomHostURL";

    @NotNull
    public static final String LOCAL_BUNDLER_KEY = "localBundler";
    public static final long NETWORK_READ_TIMEOUT_SECONDS = 30;

    @Provides
    @Singleton
    @NotNull
    public Context provideContext() {
        return OneID.INSTANCE.getAppContext$OneID_release();
    }

    @Provides
    @Singleton
    @NotNull
    public Connectivity provideConnectivity() {
        return new OneIDConnectivity();
    }

    @Provides
    @Singleton
    @NotNull
    public ConfigHandler provideConfigHandler() {
        return OneID.INSTANCE.getConfigHandler$OneID_release();
    }

    @Provides
    @Singleton
    @NotNull
    public Logger provideLogger() {
        return new OneIDLogger();
    }

    @Provides
    @Singleton
    @NotNull
    public SWID provideSWID() {
        return new SWIDController();
    }

    @Provides
    @Singleton
    @NotNull
    public GuestHandler provideGuest() {
        return new OneIDGuestHandler();
    }

    @Provides
    @Singleton
    @NotNull
    public Tracker provideTracker(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return new OneIDTracker(appContext);
    }

    @Provides
    @Singleton
    @NotNull
    public EventQueue provideEventQueue(@NotNull Context appContext, @NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(configHandler, "configHandler");
        return new OneIDEventQueue(appContext);
    }

    @Provides
    @NotNull
    public Sender provideSender() {
        return new LogGoSender();
    }

    @Provides
    @Singleton
    @NotNull
    public Session provideSession() {
        return new OneIDSession();
    }

    @Provides
    @Singleton
    @NotNull
    public SCALPController provideSCALPController() {
        return new OneIDSCALPController();
    }

    @Provides
    @Singleton
    @NotNull
    public SCALPConfigHandler provideSCALPConfigHandler() {
        return new OneIDSCALPConfigHandler();
    }

    @Provides
    @Singleton
    @NotNull
    public RecoveryContext provideRecoveryContext() {
        return new OneIDRecoveryContext();
    }

    @Provides
    @Named("GC")
    @NotNull
    @Singleton
    public OkHttpClient provideGCOkHttpClient(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderAddInterceptor = builder.connectTimeout(5L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(new AuthorizationInterceptor(appContext)).addInterceptor(new GuestControllerResponseInterceptor()).addInterceptor(new ReportingInterceptor()).addInterceptor(new UserAgentInterceptor());
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClientBuild = builderAddInterceptor.addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "build(...)");
        return okHttpClientBuild;
    }

    @Provides
    @Named("GC")
    @NotNull
    public String provideGCURL(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "configHandler");
        EnvironmentConfiguration environmentConfigurationConfigurationFor = EnvironmentConfiguration.INSTANCE.configurationFor(configHandler.get().getEnvironment());
        return environmentConfigurationConfigurationFor.getGuestControllerURL() + configHandler.get().getClientId() + "-" + environmentConfigurationConfigurationFor.getClientIDEnvKey() + "/";
    }

    @Provides
    @Singleton
    @NotNull
    public GCService provideGCService(@Named("GC") @NotNull OkHttpClient okHttpClient, @NotNull ConfigHandler configHandler, @Named("GC") @NotNull String baseUrl, @NotNull Logger logger) throws SecurityException {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(configHandler, "configHandler");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Object objCreate = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addCallAdapterFactory(new GCErrorHandlingAdapter.GCErrorHandlingCallAdapterFactory(logger)).addConverterFactory(GsonConverterFactory.create(GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null))).build().create(GCService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (GCService) objCreate;
    }

    @Provides
    @Named("Bundler")
    @NotNull
    @Singleton
    public OkHttpClient provideBundlerOkHttpClient(@NotNull Context appContext, @NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(exposedStorage, "exposedStorage");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(5L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(new UserAgentInterceptor()).addInterceptor(new ReportingInterceptor());
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClientBuild = builder.addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "build(...)");
        return okHttpClientBuild;
    }

    @Provides
    @Singleton
    @NotNull
    public Bundler provideBundler() {
        return new OneIDBundler();
    }

    @Provides
    @Singleton
    @NotNull
    public BundlerService provideBundlerService(@Named("Bundler") @NotNull OkHttpClient okHttpClient) throws SecurityException {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Object objCreate = new Retrofit.Builder().baseUrl("http://127.0.0.1").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build().create(BundlerService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (BundlerService) objCreate;
    }

    @Provides
    @Named("LogGo")
    @NotNull
    @Singleton
    public OkHttpClient provideLogGoOkHttpClient(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderAddInterceptor = builder.connectTimeout(5L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(new UserAgentInterceptor());
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClientBuild = builderAddInterceptor.addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "build(...)");
        return okHttpClientBuild;
    }

    @Provides
    @Named("LogGo")
    @NotNull
    public HttpUrl provideLogGoUrl(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "configHandler");
        HttpUrl httpUrl = HttpUrl.get(EnvironmentConfiguration.INSTANCE.configurationFor(configHandler.get().getEnvironment()).getLogGoURL());
        Intrinsics.checkNotNullExpressionValue(httpUrl, "get(...)");
        return httpUrl;
    }

    @Provides
    @Singleton
    @NotNull
    public LogGoService provideLogGoService(@Named("LogGo") @NotNull OkHttpClient okHttpClient, @Named("LogGo") @NotNull HttpUrl httpUrl) throws SecurityException {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(httpUrl, "httpUrl");
        Object objCreate = new Retrofit.Builder().baseUrl(httpUrl).client(okHttpClient).build().create(LogGoService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (LogGoService) objCreate;
    }

    @Provides
    @Singleton
    @NotNull
    public OneIDWebViewFactory provideOneIDWebViewFactory(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return new OneIDWebViewFactory(appContext);
    }

    @Provides
    @Singleton
    @NotNull
    public LocalStorage provideLocalStorage(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return new OneIDLocalStorage(appContext);
    }

    @Provides
    @Singleton
    @NotNull
    public ExposedStorage provideOneIDSharedPreferences(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return new OneIDExposedStorage(appContext);
    }

    @Provides
    @Singleton
    @NotNull
    public MigrationHandler provideMigrationHandler() {
        return new OneIDMigrationHandler();
    }

    @Provides
    @Singleton
    @NotNull
    public SCALPBundle provideSCALPBundle() {
        return new OneIDSCALPBundle();
    }

    @Provides
    @Singleton
    @NotNull
    public BiometricSupport provideBiometricSupport() {
        return new OneIDBiometricSupport();
    }

    @Provides
    @Singleton
    @NotNull
    public InitializationCallbackHolder provideInitializationCallbackHolder() {
        return new OneIDInitializationCallbackHolder();
    }

    @Provides
    @Singleton
    @NotNull
    public HeadlessListenerHolder provideHeadlessListenerHolder() {
        return new OneIDHeadlessListenerHolder();
    }
}
