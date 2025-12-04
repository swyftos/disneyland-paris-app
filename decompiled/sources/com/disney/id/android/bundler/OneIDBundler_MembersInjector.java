package com.disney.id.android.bundler;

import android.content.Context;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.SWID;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.BundlerService;
import com.disney.id.android.tracker.Tracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDBundler_MembersInjector implements MembersInjector<OneIDBundler> {
    private final Provider appContextProvider;
    private final Provider bundlerServiceProvider;
    private final Provider configHandlerProvider;
    private final Provider exposedStorageProvider;
    private final Provider guestHandlerProvider;
    private final Provider loggerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public OneIDBundler_MembersInjector(Provider<Logger> provider, Provider<ConfigHandler> provider2, Provider<SWID> provider3, Provider<Tracker> provider4, Provider<BundlerService> provider5, Provider<GuestHandler> provider6, Provider<Context> provider7, Provider<ExposedStorage> provider8) {
        this.loggerProvider = provider;
        this.configHandlerProvider = provider2;
        this.swidProvider = provider3;
        this.trackerProvider = provider4;
        this.bundlerServiceProvider = provider5;
        this.guestHandlerProvider = provider6;
        this.appContextProvider = provider7;
        this.exposedStorageProvider = provider8;
    }

    public static MembersInjector<OneIDBundler> create(Provider<Logger> provider, Provider<ConfigHandler> provider2, Provider<SWID> provider3, Provider<Tracker> provider4, Provider<BundlerService> provider5, Provider<GuestHandler> provider6, Provider<Context> provider7, Provider<ExposedStorage> provider8) {
        return new OneIDBundler_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDBundler oneIDBundler) {
        injectLogger(oneIDBundler, (Logger) this.loggerProvider.get2());
        injectConfigHandler(oneIDBundler, (ConfigHandler) this.configHandlerProvider.get2());
        injectSwid(oneIDBundler, (SWID) this.swidProvider.get2());
        injectTracker(oneIDBundler, (Tracker) this.trackerProvider.get2());
        injectBundlerService(oneIDBundler, (BundlerService) this.bundlerServiceProvider.get2());
        injectGuestHandler(oneIDBundler, (GuestHandler) this.guestHandlerProvider.get2());
        injectAppContext(oneIDBundler, (Context) this.appContextProvider.get2());
        injectExposedStorage(oneIDBundler, (ExposedStorage) this.exposedStorageProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.logger")
    public static void injectLogger(OneIDBundler oneIDBundler, Logger logger) {
        oneIDBundler.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.configHandler")
    public static void injectConfigHandler(OneIDBundler oneIDBundler, ConfigHandler configHandler) {
        oneIDBundler.configHandler = configHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.swid")
    public static void injectSwid(OneIDBundler oneIDBundler, SWID swid) {
        oneIDBundler.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.tracker")
    public static void injectTracker(OneIDBundler oneIDBundler, Tracker tracker) {
        oneIDBundler.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.bundlerService")
    public static void injectBundlerService(OneIDBundler oneIDBundler, BundlerService bundlerService) {
        oneIDBundler.bundlerService = bundlerService;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.guestHandler")
    public static void injectGuestHandler(OneIDBundler oneIDBundler, GuestHandler guestHandler) {
        oneIDBundler.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.appContext")
    public static void injectAppContext(OneIDBundler oneIDBundler, Context context) {
        oneIDBundler.appContext = context;
    }

    @InjectedFieldSignature("com.disney.id.android.bundler.OneIDBundler.exposedStorage")
    public static void injectExposedStorage(OneIDBundler oneIDBundler, ExposedStorage exposedStorage) {
        oneIDBundler.exposedStorage = exposedStorage;
    }
}
