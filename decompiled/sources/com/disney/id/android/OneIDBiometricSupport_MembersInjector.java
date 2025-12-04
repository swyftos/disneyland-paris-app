package com.disney.id.android;

import com.disney.id.android.localdata.LocalStorage;
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
public final class OneIDBiometricSupport_MembersInjector implements MembersInjector<OneIDBiometricSupport> {
    private final Provider loggerProvider;
    private final Provider scalpControllerProvider;
    private final Provider storageProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDBiometricSupport_MembersInjector(Provider<LocalStorage> provider, Provider<Logger> provider2, Provider<SCALPController> provider3, Provider<Tracker> provider4, Provider<SWID> provider5) {
        this.storageProvider = provider;
        this.loggerProvider = provider2;
        this.scalpControllerProvider = provider3;
        this.trackerProvider = provider4;
        this.swidProvider = provider5;
    }

    public static MembersInjector<OneIDBiometricSupport> create(Provider<LocalStorage> provider, Provider<Logger> provider2, Provider<SCALPController> provider3, Provider<Tracker> provider4, Provider<SWID> provider5) {
        return new OneIDBiometricSupport_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDBiometricSupport oneIDBiometricSupport) {
        injectStorage(oneIDBiometricSupport, (LocalStorage) this.storageProvider.get2());
        injectLogger(oneIDBiometricSupport, (Logger) this.loggerProvider.get2());
        injectScalpController(oneIDBiometricSupport, (SCALPController) this.scalpControllerProvider.get2());
        injectTracker(oneIDBiometricSupport, (Tracker) this.trackerProvider.get2());
        injectSwid(oneIDBiometricSupport, (SWID) this.swidProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDBiometricSupport.storage")
    public static void injectStorage(OneIDBiometricSupport oneIDBiometricSupport, LocalStorage localStorage) {
        oneIDBiometricSupport.storage = localStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDBiometricSupport.logger")
    public static void injectLogger(OneIDBiometricSupport oneIDBiometricSupport, Logger logger) {
        oneIDBiometricSupport.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDBiometricSupport.scalpController")
    public static void injectScalpController(OneIDBiometricSupport oneIDBiometricSupport, SCALPController sCALPController) {
        oneIDBiometricSupport.scalpController = sCALPController;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDBiometricSupport.tracker")
    public static void injectTracker(OneIDBiometricSupport oneIDBiometricSupport, Tracker tracker) {
        oneIDBiometricSupport.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDBiometricSupport.swid")
    public static void injectSwid(OneIDBiometricSupport oneIDBiometricSupport, SWID swid) {
        oneIDBiometricSupport.swid = swid;
    }
}
