package com.disney.id.android;

import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDSCALPController_MembersInjector implements MembersInjector<OneIDSCALPController> {
    private final Provider configHandlerProvider;
    private final Provider loggerProvider;
    private final Provider oneIDStorageProvider;
    private final Provider scalpConfigHandlerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDSCALPController_MembersInjector(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<ConfigHandler> provider3, Provider<SWID> provider4, Provider<Tracker> provider5, Provider<SCALPConfigHandler> provider6) {
        this.oneIDStorageProvider = provider;
        this.loggerProvider = provider2;
        this.configHandlerProvider = provider3;
        this.swidProvider = provider4;
        this.trackerProvider = provider5;
        this.scalpConfigHandlerProvider = provider6;
    }

    public static MembersInjector<OneIDSCALPController> create(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<ConfigHandler> provider3, Provider<SWID> provider4, Provider<Tracker> provider5, Provider<SCALPConfigHandler> provider6) {
        return new OneIDSCALPController_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDSCALPController oneIDSCALPController) {
        injectOneIDStorage(oneIDSCALPController, (ExposedStorage) this.oneIDStorageProvider.get2());
        injectLogger(oneIDSCALPController, (Logger) this.loggerProvider.get2());
        injectConfigHandler(oneIDSCALPController, (ConfigHandler) this.configHandlerProvider.get2());
        injectSwid(oneIDSCALPController, (SWID) this.swidProvider.get2());
        injectTracker(oneIDSCALPController, (Tracker) this.trackerProvider.get2());
        injectScalpConfigHandler(oneIDSCALPController, (SCALPConfigHandler) this.scalpConfigHandlerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.oneIDStorage")
    public static void injectOneIDStorage(OneIDSCALPController oneIDSCALPController, ExposedStorage exposedStorage) {
        oneIDSCALPController.oneIDStorage = exposedStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.logger")
    public static void injectLogger(OneIDSCALPController oneIDSCALPController, Logger logger) {
        oneIDSCALPController.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.configHandler")
    public static void injectConfigHandler(OneIDSCALPController oneIDSCALPController, ConfigHandler configHandler) {
        oneIDSCALPController.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.swid")
    public static void injectSwid(OneIDSCALPController oneIDSCALPController, SWID swid) {
        oneIDSCALPController.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.tracker")
    public static void injectTracker(OneIDSCALPController oneIDSCALPController, Tracker tracker) {
        oneIDSCALPController.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPController.scalpConfigHandler")
    public static void injectScalpConfigHandler(OneIDSCALPController oneIDSCALPController, SCALPConfigHandler sCALPConfigHandler) {
        oneIDSCALPController.scalpConfigHandler = sCALPConfigHandler;
    }
}
