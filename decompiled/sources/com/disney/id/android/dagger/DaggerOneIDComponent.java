package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.BiometricSupport;
import com.disney.id.android.Config;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.Config_MembersInjector;
import com.disney.id.android.Connectivity;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.HeadlessListenerHolder;
import com.disney.id.android.InitializationCallbackHolder;
import com.disney.id.android.MigrationHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDBiometricSupport;
import com.disney.id.android.OneIDBiometricSupport_MembersInjector;
import com.disney.id.android.OneIDConnectivity;
import com.disney.id.android.OneIDConnectivity_MembersInjector;
import com.disney.id.android.OneIDMigrationHandler;
import com.disney.id.android.OneIDMigrationHandler_MembersInjector;
import com.disney.id.android.OneIDRecoveryContext;
import com.disney.id.android.OneIDRecoveryContext_MembersInjector;
import com.disney.id.android.OneIDSCALPBundle;
import com.disney.id.android.OneIDSCALPBundle_MembersInjector;
import com.disney.id.android.OneIDSCALPController;
import com.disney.id.android.OneIDSCALPController_MembersInjector;
import com.disney.id.android.OneIDSession;
import com.disney.id.android.OneIDSession_MembersInjector;
import com.disney.id.android.OneID_MembersInjector;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.OptionalConfigs_MembersInjector;
import com.disney.id.android.OptionalConfigs_OptionalConfigsBuilder_MembersInjector;
import com.disney.id.android.PasswordScore;
import com.disney.id.android.PasswordScore_MembersInjector;
import com.disney.id.android.PeriodicSCALPBundlerWorker;
import com.disney.id.android.PeriodicSCALPBundlerWorker_MembersInjector;
import com.disney.id.android.RecoveryContext;
import com.disney.id.android.SCALPBundle;
import com.disney.id.android.SCALPConfigHandler;
import com.disney.id.android.SCALPController;
import com.disney.id.android.SWID;
import com.disney.id.android.SWIDController;
import com.disney.id.android.SWIDController_MembersInjector;
import com.disney.id.android.Session;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.bundler.OneIDBundler;
import com.disney.id.android.bundler.OneIDBundler_MembersInjector;
import com.disney.id.android.crypto.BasicCrypto;
import com.disney.id.android.crypto.BasicCrypto_MembersInjector;
import com.disney.id.android.lightbox.BrowserPromptDialog;
import com.disney.id.android.lightbox.BrowserPromptDialog_MembersInjector;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.LightboxActivity_MembersInjector;
import com.disney.id.android.lightbox.LightboxConfig;
import com.disney.id.android.lightbox.LightboxConfig_MembersInjector;
import com.disney.id.android.lightbox.OneIDWebView;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.lightbox.OneIDWebViewFactory_MembersInjector;
import com.disney.id.android.lightbox.OneIDWebView_MembersInjector;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.disney.id.android.lightbox.WebToNativeBridgeBase_MembersInjector;
import com.disney.id.android.lightbox.WebViewBridgeV2;
import com.disney.id.android.lightbox.WebViewBridgeV2_MembersInjector;
import com.disney.id.android.lightbox.WebViewBridgeV4;
import com.disney.id.android.lightbox.WebViewBridgeV4_MembersInjector;
import com.disney.id.android.localdata.EncryptedSharedPreferences;
import com.disney.id.android.localdata.EncryptedSharedPreferences_MembersInjector;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.localdata.OneIDExposedStorage;
import com.disney.id.android.localdata.OneIDLocalStorage;
import com.disney.id.android.localdata.OneIDLocalStorage_MembersInjector;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.scalp.SiteConfigAndL10nProvider;
import com.disney.id.android.scalp.SiteConfigAndL10nProvider_MembersInjector;
import com.disney.id.android.services.AuthorizationInterceptor;
import com.disney.id.android.services.AuthorizationInterceptor_MembersInjector;
import com.disney.id.android.services.BundlerService;
import com.disney.id.android.services.GCService;
import com.disney.id.android.services.GuestControllerResponseInterceptor;
import com.disney.id.android.services.GuestControllerResponseInterceptor_MembersInjector;
import com.disney.id.android.services.LogGoService;
import com.disney.id.android.services.ReportingInterceptor;
import com.disney.id.android.services.ReportingInterceptor_MembersInjector;
import com.disney.id.android.tracker.CircularEventTrackingQueue;
import com.disney.id.android.tracker.CircularEventTrackingQueue_MembersInjector;
import com.disney.id.android.tracker.EventQueue;
import com.disney.id.android.tracker.LogGoSender;
import com.disney.id.android.tracker.LogGoSender_MembersInjector;
import com.disney.id.android.tracker.OneIDEventQueue;
import com.disney.id.android.tracker.OneIDEventQueue_MembersInjector;
import com.disney.id.android.tracker.OneIDTracker;
import com.disney.id.android.tracker.OneIDTracker_MembersInjector;
import com.disney.id.android.tracker.Tracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes3.dex */
public final class DaggerOneIDComponent {
    public static Builder builder() {
        return new Builder();
    }

    public static OneIDComponent create() {
        return new Builder().build();
    }

    public static final class Builder {
        private OneIDModule oneIDModule;

        private Builder() {
        }

        public Builder oneIDModule(OneIDModule oneIDModule) {
            this.oneIDModule = (OneIDModule) Preconditions.checkNotNull(oneIDModule);
            return this;
        }

        public OneIDComponent build() {
            if (this.oneIDModule == null) {
                this.oneIDModule = new OneIDModule();
            }
            return new OneIDComponentImpl(this.oneIDModule);
        }
    }

    private static final class OneIDComponentImpl implements OneIDComponent {
        private final OneIDComponentImpl oneIDComponentImpl;
        private final OneIDModule oneIDModule;
        private Provider provideBiometricSupportProvider;
        private Provider provideBundlerOkHttpClientProvider;
        private Provider provideBundlerProvider;
        private Provider provideBundlerServiceProvider;
        private Provider provideConfigHandlerProvider;
        private Provider provideConnectivityProvider;
        private Provider provideContextProvider;
        private Provider provideEventQueueProvider;
        private Provider provideGCOkHttpClientProvider;
        private Provider provideGCServiceProvider;
        private Provider provideGCURLProvider;
        private Provider provideGuestProvider;
        private Provider provideHeadlessListenerHolderProvider;
        private Provider provideInitializationCallbackHolderProvider;
        private Provider provideLocalStorageProvider;
        private Provider provideLogGoOkHttpClientProvider;
        private Provider provideLogGoServiceProvider;
        private Provider provideLogGoUrlProvider;
        private Provider provideLoggerProvider;
        private Provider provideMigrationHandlerProvider;
        private Provider provideOneIDSharedPreferencesProvider;
        private Provider provideOneIDWebViewFactoryProvider;
        private Provider provideRecoveryContextProvider;
        private Provider provideSCALPBundleProvider;
        private Provider provideSCALPConfigHandlerProvider;
        private Provider provideSCALPControllerProvider;
        private Provider provideSWIDProvider;
        private Provider provideSessionProvider;
        private Provider provideTrackerProvider;

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(ConfigHandler configHandler) {
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDExposedStorage oneIDExposedStorage) {
        }

        private OneIDComponentImpl(OneIDModule oneIDModule) {
            this.oneIDComponentImpl = this;
            this.oneIDModule = oneIDModule;
            initialize(oneIDModule);
        }

        private void initialize(OneIDModule oneIDModule) {
            this.provideContextProvider = DoubleCheck.provider(OneIDModule_ProvideContextFactory.create(oneIDModule));
            this.provideLoggerProvider = DoubleCheck.provider(OneIDModule_ProvideLoggerFactory.create(oneIDModule));
            this.provideConnectivityProvider = DoubleCheck.provider(OneIDModule_ProvideConnectivityFactory.create(oneIDModule));
            this.provideConfigHandlerProvider = DoubleCheck.provider(OneIDModule_ProvideConfigHandlerFactory.create(oneIDModule));
            this.provideSWIDProvider = DoubleCheck.provider(OneIDModule_ProvideSWIDFactory.create(oneIDModule));
            this.provideGuestProvider = DoubleCheck.provider(OneIDModule_ProvideGuestFactory.create(oneIDModule));
            this.provideMigrationHandlerProvider = DoubleCheck.provider(OneIDModule_ProvideMigrationHandlerFactory.create(oneIDModule));
            this.provideTrackerProvider = DoubleCheck.provider(OneIDModule_ProvideTrackerFactory.create(oneIDModule, this.provideContextProvider));
            this.provideSessionProvider = DoubleCheck.provider(OneIDModule_ProvideSessionFactory.create(oneIDModule));
            this.provideSCALPControllerProvider = DoubleCheck.provider(OneIDModule_ProvideSCALPControllerFactory.create(oneIDModule));
            this.provideOneIDWebViewFactoryProvider = DoubleCheck.provider(OneIDModule_ProvideOneIDWebViewFactoryFactory.create(oneIDModule, this.provideContextProvider));
            this.provideBundlerProvider = DoubleCheck.provider(OneIDModule_ProvideBundlerFactory.create(oneIDModule));
            this.provideGCOkHttpClientProvider = DoubleCheck.provider(OneIDModule_ProvideGCOkHttpClientFactory.create(oneIDModule, this.provideContextProvider));
            OneIDModule_ProvideGCURLFactory oneIDModule_ProvideGCURLFactoryCreate = OneIDModule_ProvideGCURLFactory.create(oneIDModule, this.provideConfigHandlerProvider);
            this.provideGCURLProvider = oneIDModule_ProvideGCURLFactoryCreate;
            this.provideGCServiceProvider = DoubleCheck.provider(OneIDModule_ProvideGCServiceFactory.create(oneIDModule, this.provideGCOkHttpClientProvider, this.provideConfigHandlerProvider, oneIDModule_ProvideGCURLFactoryCreate, this.provideLoggerProvider));
            this.provideLocalStorageProvider = DoubleCheck.provider(OneIDModule_ProvideLocalStorageFactory.create(oneIDModule, this.provideContextProvider));
            this.provideOneIDSharedPreferencesProvider = DoubleCheck.provider(OneIDModule_ProvideOneIDSharedPreferencesFactory.create(oneIDModule, this.provideContextProvider));
            this.provideInitializationCallbackHolderProvider = DoubleCheck.provider(OneIDModule_ProvideInitializationCallbackHolderFactory.create(oneIDModule));
            this.provideHeadlessListenerHolderProvider = DoubleCheck.provider(OneIDModule_ProvideHeadlessListenerHolderFactory.create(oneIDModule));
            this.provideSCALPBundleProvider = DoubleCheck.provider(OneIDModule_ProvideSCALPBundleFactory.create(oneIDModule));
            this.provideRecoveryContextProvider = DoubleCheck.provider(OneIDModule_ProvideRecoveryContextFactory.create(oneIDModule));
            this.provideEventQueueProvider = DoubleCheck.provider(OneIDModule_ProvideEventQueueFactory.create(oneIDModule, this.provideContextProvider, this.provideConfigHandlerProvider));
            this.provideSCALPConfigHandlerProvider = DoubleCheck.provider(OneIDModule_ProvideSCALPConfigHandlerFactory.create(oneIDModule));
            this.provideLogGoOkHttpClientProvider = DoubleCheck.provider(OneIDModule_ProvideLogGoOkHttpClientFactory.create(oneIDModule, this.provideContextProvider));
            OneIDModule_ProvideLogGoUrlFactory oneIDModule_ProvideLogGoUrlFactoryCreate = OneIDModule_ProvideLogGoUrlFactory.create(oneIDModule, this.provideConfigHandlerProvider);
            this.provideLogGoUrlProvider = oneIDModule_ProvideLogGoUrlFactoryCreate;
            this.provideLogGoServiceProvider = DoubleCheck.provider(OneIDModule_ProvideLogGoServiceFactory.create(oneIDModule, this.provideLogGoOkHttpClientProvider, oneIDModule_ProvideLogGoUrlFactoryCreate));
            this.provideBiometricSupportProvider = DoubleCheck.provider(OneIDModule_ProvideBiometricSupportFactory.create(oneIDModule));
            Provider provider = DoubleCheck.provider(OneIDModule_ProvideBundlerOkHttpClientFactory.create(oneIDModule, this.provideContextProvider, this.provideOneIDSharedPreferencesProvider));
            this.provideBundlerOkHttpClientProvider = provider;
            this.provideBundlerServiceProvider = DoubleCheck.provider(OneIDModule_ProvideBundlerServiceFactory.create(oneIDModule, provider));
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDConnectivity oneIDConnectivity) {
            injectOneIDConnectivity(oneIDConnectivity);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(Config config) {
            injectConfig(config);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneID oneID) {
            injectOneID(oneID);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDSession oneIDSession) {
            injectOneIDSession(oneIDSession);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDTracker oneIDTracker) {
            injectOneIDTracker(oneIDTracker);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDSCALPController oneIDSCALPController) {
            injectOneIDSCALPController(oneIDSCALPController);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OptionalConfigs optionalConfigs) {
            injectOptionalConfigs(optionalConfigs);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OptionalConfigs.OptionalConfigsBuilder optionalConfigsBuilder) {
            injectOptionalConfigsBuilder(optionalConfigsBuilder);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDEventQueue oneIDEventQueue) {
            injectOneIDEventQueue(oneIDEventQueue);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(CircularEventTrackingQueue circularEventTrackingQueue) {
            injectCircularEventTrackingQueue(circularEventTrackingQueue);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(LogGoSender logGoSender) {
            injectLogGoSender(logGoSender);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDWebView oneIDWebView) {
            injectOneIDWebView(oneIDWebView);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDWebViewFactory oneIDWebViewFactory) {
            injectOneIDWebViewFactory(oneIDWebViewFactory);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDLocalStorage oneIDLocalStorage) {
            injectOneIDLocalStorage(oneIDLocalStorage);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(WebToNativeBridgeBase webToNativeBridgeBase) {
            injectWebToNativeBridgeBase(webToNativeBridgeBase);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(WebViewBridgeV2 webViewBridgeV2) {
            injectWebViewBridgeV2(webViewBridgeV2);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(WebViewBridgeV4 webViewBridgeV4) {
            injectWebViewBridgeV4(webViewBridgeV4);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(LightboxConfig lightboxConfig) {
            injectLightboxConfig(lightboxConfig);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(LightboxActivity lightboxActivity) {
            injectLightboxActivity(lightboxActivity);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(BrowserPromptDialog browserPromptDialog) {
            injectBrowserPromptDialog(browserPromptDialog);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDBundler oneIDBundler) {
            injectOneIDBundler(oneIDBundler);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(BasicCrypto basicCrypto) {
            injectBasicCrypto(basicCrypto);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(EncryptedSharedPreferences encryptedSharedPreferences) {
            injectEncryptedSharedPreferences(encryptedSharedPreferences);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker) {
            injectPeriodicSCALPBundlerWorker(periodicSCALPBundlerWorker);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(AuthorizationInterceptor authorizationInterceptor) {
            injectAuthorizationInterceptor(authorizationInterceptor);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(ReportingInterceptor reportingInterceptor) {
            injectReportingInterceptor(reportingInterceptor);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(SWIDController sWIDController) {
            injectSWIDController(sWIDController);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDMigrationHandler oneIDMigrationHandler) {
            injectOneIDMigrationHandler(oneIDMigrationHandler);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(PasswordScore passwordScore) {
            injectPasswordScore(passwordScore);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDRecoveryContext oneIDRecoveryContext) {
            injectOneIDRecoveryContext(oneIDRecoveryContext);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(GuestControllerResponseInterceptor guestControllerResponseInterceptor) {
            injectGuestControllerResponseInterceptor(guestControllerResponseInterceptor);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDBiometricSupport oneIDBiometricSupport) {
            injectOneIDBiometricSupport(oneIDBiometricSupport);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(OneIDSCALPBundle oneIDSCALPBundle) {
            injectOneIDSCALPBundle(oneIDSCALPBundle);
        }

        @Override // com.disney.id.android.dagger.OneIDComponent
        public void inject(SiteConfigAndL10nProvider siteConfigAndL10nProvider) {
            injectSiteConfigAndL10nProvider(siteConfigAndL10nProvider);
        }

        private OneIDConnectivity injectOneIDConnectivity(OneIDConnectivity oneIDConnectivity) {
            OneIDConnectivity_MembersInjector.injectAppContext(oneIDConnectivity, (Context) this.provideContextProvider.get2());
            OneIDConnectivity_MembersInjector.injectLogger(oneIDConnectivity, (Logger) this.provideLoggerProvider.get2());
            return oneIDConnectivity;
        }

        private Config injectConfig(Config config) {
            Config_MembersInjector.injectLogger(config, (Logger) this.provideLoggerProvider.get2());
            return config;
        }

        private OneID injectOneID(OneID oneID) {
            OneID_MembersInjector.injectConnectivity(oneID, (Connectivity) this.provideConnectivityProvider.get2());
            OneID_MembersInjector.injectConfigHandler(oneID, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneID_MembersInjector.injectLogger(oneID, (Logger) this.provideLoggerProvider.get2());
            OneID_MembersInjector.injectSwid(oneID, (SWID) this.provideSWIDProvider.get2());
            OneID_MembersInjector.injectGuestHandler(oneID, (GuestHandler) this.provideGuestProvider.get2());
            OneID_MembersInjector.injectMigrationHandler(oneID, (MigrationHandler) this.provideMigrationHandlerProvider.get2());
            OneID_MembersInjector.injectTracker(oneID, (Tracker) this.provideTrackerProvider.get2());
            OneID_MembersInjector.injectSession(oneID, (Session) this.provideSessionProvider.get2());
            OneID_MembersInjector.injectScalpController(oneID, (SCALPController) this.provideSCALPControllerProvider.get2());
            OneID_MembersInjector.injectOneIDWebViewFactory(oneID, (OneIDWebViewFactory) this.provideOneIDWebViewFactoryProvider.get2());
            OneID_MembersInjector.injectBundler(oneID, (Bundler) this.provideBundlerProvider.get2());
            OneID_MembersInjector.injectGcService(oneID, (GCService) this.provideGCServiceProvider.get2());
            OneID_MembersInjector.injectStorage(oneID, (LocalStorage) this.provideLocalStorageProvider.get2());
            OneID_MembersInjector.injectOneIdStorage(oneID, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            OneID_MembersInjector.injectInitializationCallbackHolder(oneID, (InitializationCallbackHolder) this.provideInitializationCallbackHolderProvider.get2());
            OneID_MembersInjector.injectHeadlessListenerHolder(oneID, (HeadlessListenerHolder) this.provideHeadlessListenerHolderProvider.get2());
            OneID_MembersInjector.injectScalpBundleDownloader(oneID, (SCALPBundle) this.provideSCALPBundleProvider.get2());
            return oneID;
        }

        private OneIDSession injectOneIDSession(OneIDSession oneIDSession) {
            OneIDSession_MembersInjector.injectAppContext(oneIDSession, (Context) this.provideContextProvider.get2());
            OneIDSession_MembersInjector.injectLogger(oneIDSession, (Logger) this.provideLoggerProvider.get2());
            OneIDSession_MembersInjector.injectConnectivity(oneIDSession, (Connectivity) this.provideConnectivityProvider.get2());
            OneIDSession_MembersInjector.injectStorage(oneIDSession, (LocalStorage) this.provideLocalStorageProvider.get2());
            OneIDSession_MembersInjector.injectOneIdStorage(oneIDSession, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            OneIDSession_MembersInjector.injectConfigHandler(oneIDSession, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneIDSession_MembersInjector.injectSwid(oneIDSession, (SWID) this.provideSWIDProvider.get2());
            OneIDSession_MembersInjector.injectGuestHandler(oneIDSession, (GuestHandler) this.provideGuestProvider.get2());
            OneIDSession_MembersInjector.injectTracker(oneIDSession, (Tracker) this.provideTrackerProvider.get2());
            OneIDSession_MembersInjector.injectGcService(oneIDSession, (GCService) this.provideGCServiceProvider.get2());
            OneIDSession_MembersInjector.injectScalpController(oneIDSession, (SCALPController) this.provideSCALPControllerProvider.get2());
            OneIDSession_MembersInjector.injectRecoveryContext(oneIDSession, (RecoveryContext) this.provideRecoveryContextProvider.get2());
            OneIDSession_MembersInjector.injectHeadlessListenerHolder(oneIDSession, (HeadlessListenerHolder) this.provideHeadlessListenerHolderProvider.get2());
            return oneIDSession;
        }

        private OneIDTracker injectOneIDTracker(OneIDTracker oneIDTracker) {
            OneIDTracker_MembersInjector.injectLogger(oneIDTracker, (Logger) this.provideLoggerProvider.get2());
            OneIDTracker_MembersInjector.injectSwid(oneIDTracker, (SWID) this.provideSWIDProvider.get2());
            OneIDTracker_MembersInjector.injectEventQueue(oneIDTracker, (EventQueue) this.provideEventQueueProvider.get2());
            OneIDTracker_MembersInjector.injectMigrationHandler(oneIDTracker, (MigrationHandler) this.provideMigrationHandlerProvider.get2());
            OneIDTracker_MembersInjector.injectConfigHandler(oneIDTracker, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneIDTracker_MembersInjector.injectGuestHandler(oneIDTracker, (GuestHandler) this.provideGuestProvider.get2());
            OneIDTracker_MembersInjector.injectScalpConfigHandler(oneIDTracker, (SCALPConfigHandler) this.provideSCALPConfigHandlerProvider.get2());
            OneIDTracker_MembersInjector.injectConn(oneIDTracker, (Connectivity) this.provideConnectivityProvider.get2());
            return oneIDTracker;
        }

        private OneIDSCALPController injectOneIDSCALPController(OneIDSCALPController oneIDSCALPController) {
            OneIDSCALPController_MembersInjector.injectOneIDStorage(oneIDSCALPController, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            OneIDSCALPController_MembersInjector.injectLogger(oneIDSCALPController, (Logger) this.provideLoggerProvider.get2());
            OneIDSCALPController_MembersInjector.injectConfigHandler(oneIDSCALPController, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneIDSCALPController_MembersInjector.injectSwid(oneIDSCALPController, (SWID) this.provideSWIDProvider.get2());
            OneIDSCALPController_MembersInjector.injectTracker(oneIDSCALPController, (Tracker) this.provideTrackerProvider.get2());
            OneIDSCALPController_MembersInjector.injectScalpConfigHandler(oneIDSCALPController, (SCALPConfigHandler) this.provideSCALPConfigHandlerProvider.get2());
            return oneIDSCALPController;
        }

        private OptionalConfigs injectOptionalConfigs(OptionalConfigs optionalConfigs) {
            OptionalConfigs_MembersInjector.injectLogger(optionalConfigs, (Logger) this.provideLoggerProvider.get2());
            return optionalConfigs;
        }

        private OptionalConfigs.OptionalConfigsBuilder injectOptionalConfigsBuilder(OptionalConfigs.OptionalConfigsBuilder optionalConfigsBuilder) {
            OptionalConfigs_OptionalConfigsBuilder_MembersInjector.injectLogger(optionalConfigsBuilder, (Logger) this.provideLoggerProvider.get2());
            return optionalConfigsBuilder;
        }

        private OneIDEventQueue injectOneIDEventQueue(OneIDEventQueue oneIDEventQueue) {
            OneIDEventQueue_MembersInjector.injectLogger(oneIDEventQueue, (Logger) this.provideLoggerProvider.get2());
            OneIDEventQueue_MembersInjector.injectSender(oneIDEventQueue, OneIDModule_ProvideSenderFactory.provideSender(this.oneIDModule));
            OneIDEventQueue_MembersInjector.injectConnectivity(oneIDEventQueue, (Connectivity) this.provideConnectivityProvider.get2());
            return oneIDEventQueue;
        }

        private CircularEventTrackingQueue injectCircularEventTrackingQueue(CircularEventTrackingQueue circularEventTrackingQueue) {
            CircularEventTrackingQueue_MembersInjector.injectLogger(circularEventTrackingQueue, (Logger) this.provideLoggerProvider.get2());
            return circularEventTrackingQueue;
        }

        private LogGoSender injectLogGoSender(LogGoSender logGoSender) {
            LogGoSender_MembersInjector.injectLogger(logGoSender, (Logger) this.provideLoggerProvider.get2());
            LogGoSender_MembersInjector.injectLogGoService(logGoSender, (LogGoService) this.provideLogGoServiceProvider.get2());
            return logGoSender;
        }

        private OneIDWebView injectOneIDWebView(OneIDWebView oneIDWebView) {
            OneIDWebView_MembersInjector.injectOneIDStorage(oneIDWebView, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            OneIDWebView_MembersInjector.injectLogger(oneIDWebView, (Logger) this.provideLoggerProvider.get2());
            OneIDWebView_MembersInjector.injectBundle(oneIDWebView, (Bundler) this.provideBundlerProvider.get2());
            OneIDWebView_MembersInjector.injectTracker(oneIDWebView, (Tracker) this.provideTrackerProvider.get2());
            OneIDWebView_MembersInjector.injectSwid(oneIDWebView, (SWID) this.provideSWIDProvider.get2());
            return oneIDWebView;
        }

        private OneIDWebViewFactory injectOneIDWebViewFactory(OneIDWebViewFactory oneIDWebViewFactory) {
            OneIDWebViewFactory_MembersInjector.injectLogger(oneIDWebViewFactory, (Logger) this.provideLoggerProvider.get2());
            OneIDWebViewFactory_MembersInjector.injectTracker(oneIDWebViewFactory, (Tracker) this.provideTrackerProvider.get2());
            OneIDWebViewFactory_MembersInjector.injectSwid(oneIDWebViewFactory, (SWID) this.provideSWIDProvider.get2());
            return oneIDWebViewFactory;
        }

        private OneIDLocalStorage injectOneIDLocalStorage(OneIDLocalStorage oneIDLocalStorage) {
            OneIDLocalStorage_MembersInjector.injectLogger(oneIDLocalStorage, (Logger) this.provideLoggerProvider.get2());
            return oneIDLocalStorage;
        }

        private WebToNativeBridgeBase injectWebToNativeBridgeBase(WebToNativeBridgeBase webToNativeBridgeBase) {
            WebToNativeBridgeBase_MembersInjector.injectLogger(webToNativeBridgeBase, (Logger) this.provideLoggerProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectAppContext(webToNativeBridgeBase, (Context) this.provideContextProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectTracker(webToNativeBridgeBase, (Tracker) this.provideTrackerProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectStorage(webToNativeBridgeBase, (LocalStorage) this.provideLocalStorageProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectSwid(webToNativeBridgeBase, (SWID) this.provideSWIDProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectBiometrics(webToNativeBridgeBase, (BiometricSupport) this.provideBiometricSupportProvider.get2());
            WebToNativeBridgeBase_MembersInjector.injectScalpController(webToNativeBridgeBase, (SCALPController) this.provideSCALPControllerProvider.get2());
            return webToNativeBridgeBase;
        }

        private WebViewBridgeV2 injectWebViewBridgeV2(WebViewBridgeV2 webViewBridgeV2) {
            WebViewBridgeV2_MembersInjector.injectLogger(webViewBridgeV2, (Logger) this.provideLoggerProvider.get2());
            WebViewBridgeV2_MembersInjector.injectTracker(webViewBridgeV2, (Tracker) this.provideTrackerProvider.get2());
            return webViewBridgeV2;
        }

        private WebViewBridgeV4 injectWebViewBridgeV4(WebViewBridgeV4 webViewBridgeV4) {
            WebViewBridgeV4_MembersInjector.injectLogger(webViewBridgeV4, (Logger) this.provideLoggerProvider.get2());
            WebViewBridgeV4_MembersInjector.injectTracker(webViewBridgeV4, (Tracker) this.provideTrackerProvider.get2());
            return webViewBridgeV4;
        }

        private LightboxConfig injectLightboxConfig(LightboxConfig lightboxConfig) {
            LightboxConfig_MembersInjector.injectOneIdStorage(lightboxConfig, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            LightboxConfig_MembersInjector.injectLogger(lightboxConfig, (Logger) this.provideLoggerProvider.get2());
            LightboxConfig_MembersInjector.injectGuestHandler(lightboxConfig, (GuestHandler) this.provideGuestProvider.get2());
            LightboxConfig_MembersInjector.injectBiometricSupport(lightboxConfig, (BiometricSupport) this.provideBiometricSupportProvider.get2());
            return lightboxConfig;
        }

        private LightboxActivity injectLightboxActivity(LightboxActivity lightboxActivity) {
            LightboxActivity_MembersInjector.injectLogger(lightboxActivity, (Logger) this.provideLoggerProvider.get2());
            LightboxActivity_MembersInjector.injectSwid(lightboxActivity, (SWID) this.provideSWIDProvider.get2());
            LightboxActivity_MembersInjector.injectTracker(lightboxActivity, (Tracker) this.provideTrackerProvider.get2());
            LightboxActivity_MembersInjector.injectWebViewFactory(lightboxActivity, (OneIDWebViewFactory) this.provideOneIDWebViewFactoryProvider.get2());
            LightboxActivity_MembersInjector.injectConfigHandler(lightboxActivity, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            return lightboxActivity;
        }

        private BrowserPromptDialog injectBrowserPromptDialog(BrowserPromptDialog browserPromptDialog) {
            BrowserPromptDialog_MembersInjector.injectLogger(browserPromptDialog, (Logger) this.provideLoggerProvider.get2());
            BrowserPromptDialog_MembersInjector.injectScalpController(browserPromptDialog, (SCALPController) this.provideSCALPControllerProvider.get2());
            return browserPromptDialog;
        }

        private OneIDBundler injectOneIDBundler(OneIDBundler oneIDBundler) {
            OneIDBundler_MembersInjector.injectLogger(oneIDBundler, (Logger) this.provideLoggerProvider.get2());
            OneIDBundler_MembersInjector.injectConfigHandler(oneIDBundler, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneIDBundler_MembersInjector.injectSwid(oneIDBundler, (SWID) this.provideSWIDProvider.get2());
            OneIDBundler_MembersInjector.injectTracker(oneIDBundler, (Tracker) this.provideTrackerProvider.get2());
            OneIDBundler_MembersInjector.injectBundlerService(oneIDBundler, (BundlerService) this.provideBundlerServiceProvider.get2());
            OneIDBundler_MembersInjector.injectGuestHandler(oneIDBundler, (GuestHandler) this.provideGuestProvider.get2());
            OneIDBundler_MembersInjector.injectAppContext(oneIDBundler, (Context) this.provideContextProvider.get2());
            OneIDBundler_MembersInjector.injectExposedStorage(oneIDBundler, (ExposedStorage) this.provideOneIDSharedPreferencesProvider.get2());
            return oneIDBundler;
        }

        private BasicCrypto injectBasicCrypto(BasicCrypto basicCrypto) {
            BasicCrypto_MembersInjector.injectLogger(basicCrypto, (Logger) this.provideLoggerProvider.get2());
            return basicCrypto;
        }

        private EncryptedSharedPreferences injectEncryptedSharedPreferences(EncryptedSharedPreferences encryptedSharedPreferences) {
            EncryptedSharedPreferences_MembersInjector.injectLogger(encryptedSharedPreferences, (Logger) this.provideLoggerProvider.get2());
            return encryptedSharedPreferences;
        }

        private PeriodicSCALPBundlerWorker injectPeriodicSCALPBundlerWorker(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker) {
            PeriodicSCALPBundlerWorker_MembersInjector.injectTracker(periodicSCALPBundlerWorker, (Tracker) this.provideTrackerProvider.get2());
            PeriodicSCALPBundlerWorker_MembersInjector.injectSwid(periodicSCALPBundlerWorker, (SWID) this.provideSWIDProvider.get2());
            PeriodicSCALPBundlerWorker_MembersInjector.injectInitializationCallbackHolder(periodicSCALPBundlerWorker, (InitializationCallbackHolder) this.provideInitializationCallbackHolderProvider.get2());
            PeriodicSCALPBundlerWorker_MembersInjector.injectOneIDSCALPBundle(periodicSCALPBundlerWorker, (SCALPBundle) this.provideSCALPBundleProvider.get2());
            return periodicSCALPBundlerWorker;
        }

        private AuthorizationInterceptor injectAuthorizationInterceptor(AuthorizationInterceptor authorizationInterceptor) {
            AuthorizationInterceptor_MembersInjector.injectLogger(authorizationInterceptor, (Logger) this.provideLoggerProvider.get2());
            AuthorizationInterceptor_MembersInjector.injectGuestHandler(authorizationInterceptor, (GuestHandler) this.provideGuestProvider.get2());
            AuthorizationInterceptor_MembersInjector.injectRecoveryContext(authorizationInterceptor, (RecoveryContext) this.provideRecoveryContextProvider.get2());
            return authorizationInterceptor;
        }

        private ReportingInterceptor injectReportingInterceptor(ReportingInterceptor reportingInterceptor) {
            ReportingInterceptor_MembersInjector.injectLogger(reportingInterceptor, (Logger) this.provideLoggerProvider.get2());
            ReportingInterceptor_MembersInjector.injectTracker(reportingInterceptor, (Tracker) this.provideTrackerProvider.get2());
            return reportingInterceptor;
        }

        private SWIDController injectSWIDController(SWIDController sWIDController) {
            SWIDController_MembersInjector.injectStorage(sWIDController, (LocalStorage) this.provideLocalStorageProvider.get2());
            return sWIDController;
        }

        private OneIDMigrationHandler injectOneIDMigrationHandler(OneIDMigrationHandler oneIDMigrationHandler) {
            OneIDMigrationHandler_MembersInjector.injectStorage(oneIDMigrationHandler, (LocalStorage) this.provideLocalStorageProvider.get2());
            OneIDMigrationHandler_MembersInjector.injectContext(oneIDMigrationHandler, (Context) this.provideContextProvider.get2());
            OneIDMigrationHandler_MembersInjector.injectSwidController(oneIDMigrationHandler, (SWID) this.provideSWIDProvider.get2());
            OneIDMigrationHandler_MembersInjector.injectConfigHandler(oneIDMigrationHandler, (ConfigHandler) this.provideConfigHandlerProvider.get2());
            OneIDMigrationHandler_MembersInjector.injectLogger(oneIDMigrationHandler, (Logger) this.provideLoggerProvider.get2());
            return oneIDMigrationHandler;
        }

        private PasswordScore injectPasswordScore(PasswordScore passwordScore) {
            PasswordScore_MembersInjector.injectLogger(passwordScore, (Logger) this.provideLoggerProvider.get2());
            return passwordScore;
        }

        private OneIDRecoveryContext injectOneIDRecoveryContext(OneIDRecoveryContext oneIDRecoveryContext) {
            OneIDRecoveryContext_MembersInjector.injectStorage(oneIDRecoveryContext, (LocalStorage) this.provideLocalStorageProvider.get2());
            return oneIDRecoveryContext;
        }

        private GuestControllerResponseInterceptor injectGuestControllerResponseInterceptor(GuestControllerResponseInterceptor guestControllerResponseInterceptor) {
            GuestControllerResponseInterceptor_MembersInjector.injectTracker(guestControllerResponseInterceptor, (Tracker) this.provideTrackerProvider.get2());
            GuestControllerResponseInterceptor_MembersInjector.injectSession(guestControllerResponseInterceptor, DoubleCheck.lazy(this.provideSessionProvider));
            return guestControllerResponseInterceptor;
        }

        private OneIDBiometricSupport injectOneIDBiometricSupport(OneIDBiometricSupport oneIDBiometricSupport) {
            OneIDBiometricSupport_MembersInjector.injectStorage(oneIDBiometricSupport, (LocalStorage) this.provideLocalStorageProvider.get2());
            OneIDBiometricSupport_MembersInjector.injectLogger(oneIDBiometricSupport, (Logger) this.provideLoggerProvider.get2());
            OneIDBiometricSupport_MembersInjector.injectScalpController(oneIDBiometricSupport, (SCALPController) this.provideSCALPControllerProvider.get2());
            OneIDBiometricSupport_MembersInjector.injectTracker(oneIDBiometricSupport, (Tracker) this.provideTrackerProvider.get2());
            OneIDBiometricSupport_MembersInjector.injectSwid(oneIDBiometricSupport, (SWID) this.provideSWIDProvider.get2());
            return oneIDBiometricSupport;
        }

        private OneIDSCALPBundle injectOneIDSCALPBundle(OneIDSCALPBundle oneIDSCALPBundle) {
            OneIDSCALPBundle_MembersInjector.injectLogger(oneIDSCALPBundle, (Logger) this.provideLoggerProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectSwid(oneIDSCALPBundle, (SWID) this.provideSWIDProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectBundler(oneIDSCALPBundle, (Bundler) this.provideBundlerProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectScalpController(oneIDSCALPBundle, (SCALPController) this.provideSCALPControllerProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectGuestHandler(oneIDSCALPBundle, (GuestHandler) this.provideGuestProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectTracker(oneIDSCALPBundle, (Tracker) this.provideTrackerProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectInitializationCallbackHolder(oneIDSCALPBundle, (InitializationCallbackHolder) this.provideInitializationCallbackHolderProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectContext(oneIDSCALPBundle, (Context) this.provideContextProvider.get2());
            OneIDSCALPBundle_MembersInjector.injectWebViewFactory(oneIDSCALPBundle, (OneIDWebViewFactory) this.provideOneIDWebViewFactoryProvider.get2());
            return oneIDSCALPBundle;
        }

        private SiteConfigAndL10nProvider injectSiteConfigAndL10nProvider(SiteConfigAndL10nProvider siteConfigAndL10nProvider) {
            SiteConfigAndL10nProvider_MembersInjector.injectBundlerService(siteConfigAndL10nProvider, (BundlerService) this.provideBundlerServiceProvider.get2());
            SiteConfigAndL10nProvider_MembersInjector.injectTracker(siteConfigAndL10nProvider, (Tracker) this.provideTrackerProvider.get2());
            SiteConfigAndL10nProvider_MembersInjector.injectSwid(siteConfigAndL10nProvider, (SWID) this.provideSWIDProvider.get2());
            SiteConfigAndL10nProvider_MembersInjector.injectLogger(siteConfigAndL10nProvider, (Logger) this.provideLoggerProvider.get2());
            return siteConfigAndL10nProvider;
        }
    }
}
