package com.disney.id.android.lightbox;

import android.content.Context;
import com.disney.id.android.BiometricSupport;
import com.disney.id.android.SCALPController;
import com.disney.id.android.SWID;
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
public final class WebToNativeBridgeBase_MembersInjector implements MembersInjector<WebToNativeBridgeBase> {
    private final Provider appContextProvider;
    private final Provider biometricsProvider;
    private final Provider loggerProvider;
    private final Provider scalpControllerProvider;
    private final Provider storageProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;

    public WebToNativeBridgeBase_MembersInjector(Provider<Logger> provider, Provider<Context> provider2, Provider<Tracker> provider3, Provider<LocalStorage> provider4, Provider<SWID> provider5, Provider<BiometricSupport> provider6, Provider<SCALPController> provider7) {
        this.loggerProvider = provider;
        this.appContextProvider = provider2;
        this.trackerProvider = provider3;
        this.storageProvider = provider4;
        this.swidProvider = provider5;
        this.biometricsProvider = provider6;
        this.scalpControllerProvider = provider7;
    }

    public static MembersInjector<WebToNativeBridgeBase> create(Provider<Logger> provider, Provider<Context> provider2, Provider<Tracker> provider3, Provider<LocalStorage> provider4, Provider<SWID> provider5, Provider<BiometricSupport> provider6, Provider<SCALPController> provider7) {
        return new WebToNativeBridgeBase_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WebToNativeBridgeBase webToNativeBridgeBase) {
        injectLogger(webToNativeBridgeBase, (Logger) this.loggerProvider.get2());
        injectAppContext(webToNativeBridgeBase, (Context) this.appContextProvider.get2());
        injectTracker(webToNativeBridgeBase, (Tracker) this.trackerProvider.get2());
        injectStorage(webToNativeBridgeBase, (LocalStorage) this.storageProvider.get2());
        injectSwid(webToNativeBridgeBase, (SWID) this.swidProvider.get2());
        injectBiometrics(webToNativeBridgeBase, (BiometricSupport) this.biometricsProvider.get2());
        injectScalpController(webToNativeBridgeBase, (SCALPController) this.scalpControllerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.logger")
    public static void injectLogger(WebToNativeBridgeBase webToNativeBridgeBase, Logger logger) {
        webToNativeBridgeBase.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.appContext")
    public static void injectAppContext(WebToNativeBridgeBase webToNativeBridgeBase, Context context) {
        webToNativeBridgeBase.appContext = context;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.tracker")
    public static void injectTracker(WebToNativeBridgeBase webToNativeBridgeBase, Tracker tracker) {
        webToNativeBridgeBase.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.storage")
    public static void injectStorage(WebToNativeBridgeBase webToNativeBridgeBase, LocalStorage localStorage) {
        webToNativeBridgeBase.storage = localStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.swid")
    public static void injectSwid(WebToNativeBridgeBase webToNativeBridgeBase, SWID swid) {
        webToNativeBridgeBase.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.biometrics")
    public static void injectBiometrics(WebToNativeBridgeBase webToNativeBridgeBase, BiometricSupport biometricSupport) {
        webToNativeBridgeBase.biometrics = biometricSupport;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebToNativeBridgeBase.scalpController")
    public static void injectScalpController(WebToNativeBridgeBase webToNativeBridgeBase, SCALPController sCALPController) {
        webToNativeBridgeBase.scalpController = sCALPController;
    }
}
