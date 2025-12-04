package com.disney.id.android;

import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PeriodicSCALPBundlerWorker_MembersInjector implements MembersInjector<PeriodicSCALPBundlerWorker> {
    private final Provider initializationCallbackHolderProvider;
    private final Provider oneIDSCALPBundleProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public PeriodicSCALPBundlerWorker_MembersInjector(Provider<Tracker> provider, Provider<SWID> provider2, Provider<InitializationCallbackHolder> provider3, Provider<SCALPBundle> provider4) {
        this.trackerProvider = provider;
        this.swidProvider = provider2;
        this.initializationCallbackHolderProvider = provider3;
        this.oneIDSCALPBundleProvider = provider4;
    }

    public static MembersInjector<PeriodicSCALPBundlerWorker> create(Provider<Tracker> provider, Provider<SWID> provider2, Provider<InitializationCallbackHolder> provider3, Provider<SCALPBundle> provider4) {
        return new PeriodicSCALPBundlerWorker_MembersInjector(provider, provider2, provider3, provider4);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker) {
        injectTracker(periodicSCALPBundlerWorker, (Tracker) this.trackerProvider.get2());
        injectSwid(periodicSCALPBundlerWorker, (SWID) this.swidProvider.get2());
        injectInitializationCallbackHolder(periodicSCALPBundlerWorker, (InitializationCallbackHolder) this.initializationCallbackHolderProvider.get2());
        injectOneIDSCALPBundle(periodicSCALPBundlerWorker, (SCALPBundle) this.oneIDSCALPBundleProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.PeriodicSCALPBundlerWorker.tracker")
    public static void injectTracker(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker, Tracker tracker) {
        periodicSCALPBundlerWorker.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.PeriodicSCALPBundlerWorker.swid")
    public static void injectSwid(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker, SWID swid) {
        periodicSCALPBundlerWorker.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.PeriodicSCALPBundlerWorker.initializationCallbackHolder")
    public static void injectInitializationCallbackHolder(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker, InitializationCallbackHolder initializationCallbackHolder) {
        periodicSCALPBundlerWorker.initializationCallbackHolder = initializationCallbackHolder;
    }

    @InjectedFieldSignature("com.disney.id.android.PeriodicSCALPBundlerWorker.oneIDSCALPBundle")
    public static void injectOneIDSCALPBundle(PeriodicSCALPBundlerWorker periodicSCALPBundlerWorker, SCALPBundle sCALPBundle) {
        periodicSCALPBundlerWorker.oneIDSCALPBundle = sCALPBundle;
    }
}
