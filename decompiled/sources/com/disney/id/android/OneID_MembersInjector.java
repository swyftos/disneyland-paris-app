package com.disney.id.android;

import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.GCService;
import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneID_MembersInjector implements MembersInjector<OneID> {
    private final Provider bundlerProvider;
    private final Provider configHandlerProvider;
    private final Provider connectivityProvider;
    private final Provider gcServiceProvider;
    private final Provider guestHandlerProvider;
    private final Provider headlessListenerHolderProvider;
    private final Provider initializationCallbackHolderProvider;
    private final Provider loggerProvider;
    private final Provider migrationHandlerProvider;
    private final Provider oneIDWebViewFactoryProvider;
    private final Provider oneIdStorageProvider;
    private final Provider scalpBundleDownloaderProvider;
    private final Provider scalpControllerProvider;
    private final Provider sessionProvider;
    private final Provider storageProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneID_MembersInjector(Provider<Connectivity> provider, Provider<ConfigHandler> provider2, Provider<Logger> provider3, Provider<SWID> provider4, Provider<GuestHandler> provider5, Provider<MigrationHandler> provider6, Provider<Tracker> provider7, Provider<Session> provider8, Provider<SCALPController> provider9, Provider<OneIDWebViewFactory> provider10, Provider<Bundler> provider11, Provider<GCService> provider12, Provider<LocalStorage> provider13, Provider<ExposedStorage> provider14, Provider<InitializationCallbackHolder> provider15, Provider<HeadlessListenerHolder> provider16, Provider<SCALPBundle> provider17) {
        this.connectivityProvider = provider;
        this.configHandlerProvider = provider2;
        this.loggerProvider = provider3;
        this.swidProvider = provider4;
        this.guestHandlerProvider = provider5;
        this.migrationHandlerProvider = provider6;
        this.trackerProvider = provider7;
        this.sessionProvider = provider8;
        this.scalpControllerProvider = provider9;
        this.oneIDWebViewFactoryProvider = provider10;
        this.bundlerProvider = provider11;
        this.gcServiceProvider = provider12;
        this.storageProvider = provider13;
        this.oneIdStorageProvider = provider14;
        this.initializationCallbackHolderProvider = provider15;
        this.headlessListenerHolderProvider = provider16;
        this.scalpBundleDownloaderProvider = provider17;
    }

    public static MembersInjector<OneID> create(Provider<Connectivity> provider, Provider<ConfigHandler> provider2, Provider<Logger> provider3, Provider<SWID> provider4, Provider<GuestHandler> provider5, Provider<MigrationHandler> provider6, Provider<Tracker> provider7, Provider<Session> provider8, Provider<SCALPController> provider9, Provider<OneIDWebViewFactory> provider10, Provider<Bundler> provider11, Provider<GCService> provider12, Provider<LocalStorage> provider13, Provider<ExposedStorage> provider14, Provider<InitializationCallbackHolder> provider15, Provider<HeadlessListenerHolder> provider16, Provider<SCALPBundle> provider17) {
        return new OneID_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneID oneID) {
        injectConnectivity(oneID, (Connectivity) this.connectivityProvider.get2());
        injectConfigHandler(oneID, (ConfigHandler) this.configHandlerProvider.get2());
        injectLogger(oneID, (Logger) this.loggerProvider.get2());
        injectSwid(oneID, (SWID) this.swidProvider.get2());
        injectGuestHandler(oneID, (GuestHandler) this.guestHandlerProvider.get2());
        injectMigrationHandler(oneID, (MigrationHandler) this.migrationHandlerProvider.get2());
        injectTracker(oneID, (Tracker) this.trackerProvider.get2());
        injectSession(oneID, (Session) this.sessionProvider.get2());
        injectScalpController(oneID, (SCALPController) this.scalpControllerProvider.get2());
        injectOneIDWebViewFactory(oneID, (OneIDWebViewFactory) this.oneIDWebViewFactoryProvider.get2());
        injectBundler(oneID, (Bundler) this.bundlerProvider.get2());
        injectGcService(oneID, (GCService) this.gcServiceProvider.get2());
        injectStorage(oneID, (LocalStorage) this.storageProvider.get2());
        injectOneIdStorage(oneID, (ExposedStorage) this.oneIdStorageProvider.get2());
        injectInitializationCallbackHolder(oneID, (InitializationCallbackHolder) this.initializationCallbackHolderProvider.get2());
        injectHeadlessListenerHolder(oneID, (HeadlessListenerHolder) this.headlessListenerHolderProvider.get2());
        injectScalpBundleDownloader(oneID, (SCALPBundle) this.scalpBundleDownloaderProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.connectivity")
    public static void injectConnectivity(OneID oneID, Connectivity connectivity) {
        oneID.connectivity = connectivity;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.configHandler")
    public static void injectConfigHandler(OneID oneID, ConfigHandler configHandler) {
        oneID.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.logger")
    public static void injectLogger(OneID oneID, Logger logger) {
        oneID.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.swid")
    public static void injectSwid(OneID oneID, SWID swid) {
        oneID.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.guestHandler")
    public static void injectGuestHandler(OneID oneID, GuestHandler guestHandler) {
        oneID.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.migrationHandler")
    public static void injectMigrationHandler(OneID oneID, MigrationHandler migrationHandler) {
        oneID.migrationHandler = migrationHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.tracker")
    public static void injectTracker(OneID oneID, Tracker tracker) {
        oneID.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.session")
    public static void injectSession(OneID oneID, Session session) {
        oneID.session = session;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.scalpController")
    public static void injectScalpController(OneID oneID, SCALPController sCALPController) {
        oneID.scalpController = sCALPController;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.oneIDWebViewFactory")
    public static void injectOneIDWebViewFactory(OneID oneID, OneIDWebViewFactory oneIDWebViewFactory) {
        oneID.oneIDWebViewFactory = oneIDWebViewFactory;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.bundler")
    public static void injectBundler(OneID oneID, Bundler bundler) {
        oneID.bundler = bundler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.gcService")
    public static void injectGcService(OneID oneID, GCService gCService) {
        oneID.gcService = gCService;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.storage")
    public static void injectStorage(OneID oneID, LocalStorage localStorage) {
        oneID.storage = localStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.oneIdStorage")
    public static void injectOneIdStorage(OneID oneID, ExposedStorage exposedStorage) {
        oneID.oneIdStorage = exposedStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.initializationCallbackHolder")
    public static void injectInitializationCallbackHolder(OneID oneID, InitializationCallbackHolder initializationCallbackHolder) {
        oneID.initializationCallbackHolder = initializationCallbackHolder;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.headlessListenerHolder")
    public static void injectHeadlessListenerHolder(OneID oneID, HeadlessListenerHolder headlessListenerHolder) {
        oneID.headlessListenerHolder = headlessListenerHolder;
    }

    @InjectedFieldSignature("com.disney.id.android.OneID.scalpBundleDownloader")
    public static void injectScalpBundleDownloader(OneID oneID, SCALPBundle sCALPBundle) {
        oneID.scalpBundleDownloader = sCALPBundle;
    }
}
