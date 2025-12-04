package com.disney.id.android;

import android.content.Context;
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
public final class OneIDSession_MembersInjector implements MembersInjector<OneIDSession> {
    private final Provider appContextProvider;
    private final Provider configHandlerProvider;
    private final Provider connectivityProvider;
    private final Provider gcServiceProvider;
    private final Provider guestHandlerProvider;
    private final Provider headlessListenerHolderProvider;
    private final Provider loggerProvider;
    private final Provider oneIdStorageProvider;
    private final Provider recoveryContextProvider;
    private final Provider scalpControllerProvider;
    private final Provider storageProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDSession_MembersInjector(Provider<Context> provider, Provider<Logger> provider2, Provider<Connectivity> provider3, Provider<LocalStorage> provider4, Provider<ExposedStorage> provider5, Provider<ConfigHandler> provider6, Provider<SWID> provider7, Provider<GuestHandler> provider8, Provider<Tracker> provider9, Provider<GCService> provider10, Provider<SCALPController> provider11, Provider<RecoveryContext> provider12, Provider<HeadlessListenerHolder> provider13) {
        this.appContextProvider = provider;
        this.loggerProvider = provider2;
        this.connectivityProvider = provider3;
        this.storageProvider = provider4;
        this.oneIdStorageProvider = provider5;
        this.configHandlerProvider = provider6;
        this.swidProvider = provider7;
        this.guestHandlerProvider = provider8;
        this.trackerProvider = provider9;
        this.gcServiceProvider = provider10;
        this.scalpControllerProvider = provider11;
        this.recoveryContextProvider = provider12;
        this.headlessListenerHolderProvider = provider13;
    }

    public static MembersInjector<OneIDSession> create(Provider<Context> provider, Provider<Logger> provider2, Provider<Connectivity> provider3, Provider<LocalStorage> provider4, Provider<ExposedStorage> provider5, Provider<ConfigHandler> provider6, Provider<SWID> provider7, Provider<GuestHandler> provider8, Provider<Tracker> provider9, Provider<GCService> provider10, Provider<SCALPController> provider11, Provider<RecoveryContext> provider12, Provider<HeadlessListenerHolder> provider13) {
        return new OneIDSession_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDSession oneIDSession) {
        injectAppContext(oneIDSession, (Context) this.appContextProvider.get2());
        injectLogger(oneIDSession, (Logger) this.loggerProvider.get2());
        injectConnectivity(oneIDSession, (Connectivity) this.connectivityProvider.get2());
        injectStorage(oneIDSession, (LocalStorage) this.storageProvider.get2());
        injectOneIdStorage(oneIDSession, (ExposedStorage) this.oneIdStorageProvider.get2());
        injectConfigHandler(oneIDSession, (ConfigHandler) this.configHandlerProvider.get2());
        injectSwid(oneIDSession, (SWID) this.swidProvider.get2());
        injectGuestHandler(oneIDSession, (GuestHandler) this.guestHandlerProvider.get2());
        injectTracker(oneIDSession, (Tracker) this.trackerProvider.get2());
        injectGcService(oneIDSession, (GCService) this.gcServiceProvider.get2());
        injectScalpController(oneIDSession, (SCALPController) this.scalpControllerProvider.get2());
        injectRecoveryContext(oneIDSession, (RecoveryContext) this.recoveryContextProvider.get2());
        injectHeadlessListenerHolder(oneIDSession, (HeadlessListenerHolder) this.headlessListenerHolderProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.appContext")
    public static void injectAppContext(OneIDSession oneIDSession, Context context) {
        oneIDSession.appContext = context;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.logger")
    public static void injectLogger(OneIDSession oneIDSession, Logger logger) {
        oneIDSession.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.connectivity")
    public static void injectConnectivity(OneIDSession oneIDSession, Connectivity connectivity) {
        oneIDSession.connectivity = connectivity;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.storage")
    public static void injectStorage(OneIDSession oneIDSession, LocalStorage localStorage) {
        oneIDSession.storage = localStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.oneIdStorage")
    public static void injectOneIdStorage(OneIDSession oneIDSession, ExposedStorage exposedStorage) {
        oneIDSession.oneIdStorage = exposedStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.configHandler")
    public static void injectConfigHandler(OneIDSession oneIDSession, ConfigHandler configHandler) {
        oneIDSession.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.swid")
    public static void injectSwid(OneIDSession oneIDSession, SWID swid) {
        oneIDSession.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.guestHandler")
    public static void injectGuestHandler(OneIDSession oneIDSession, GuestHandler guestHandler) {
        oneIDSession.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.tracker")
    public static void injectTracker(OneIDSession oneIDSession, Tracker tracker) {
        oneIDSession.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.gcService")
    public static void injectGcService(OneIDSession oneIDSession, GCService gCService) {
        oneIDSession.gcService = gCService;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.scalpController")
    public static void injectScalpController(OneIDSession oneIDSession, SCALPController sCALPController) {
        oneIDSession.scalpController = sCALPController;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.recoveryContext")
    public static void injectRecoveryContext(OneIDSession oneIDSession, RecoveryContext recoveryContext) {
        oneIDSession.recoveryContext = recoveryContext;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSession.headlessListenerHolder")
    public static void injectHeadlessListenerHolder(OneIDSession oneIDSession, HeadlessListenerHolder headlessListenerHolder) {
        oneIDSession.headlessListenerHolder = headlessListenerHolder;
    }
}
