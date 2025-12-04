package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
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
public final class OneIDSCALPBundle_MembersInjector implements MembersInjector<OneIDSCALPBundle> {
    private final Provider bundlerProvider;
    private final Provider contextProvider;
    private final Provider guestHandlerProvider;
    private final Provider initializationCallbackHolderProvider;
    private final Provider loggerProvider;
    private final Provider scalpControllerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;
    private final Provider webViewFactoryProvider;

    public OneIDSCALPBundle_MembersInjector(Provider<Logger> provider, Provider<SWID> provider2, Provider<Bundler> provider3, Provider<SCALPController> provider4, Provider<GuestHandler> provider5, Provider<Tracker> provider6, Provider<InitializationCallbackHolder> provider7, Provider<Context> provider8, Provider<OneIDWebViewFactory> provider9) {
        this.loggerProvider = provider;
        this.swidProvider = provider2;
        this.bundlerProvider = provider3;
        this.scalpControllerProvider = provider4;
        this.guestHandlerProvider = provider5;
        this.trackerProvider = provider6;
        this.initializationCallbackHolderProvider = provider7;
        this.contextProvider = provider8;
        this.webViewFactoryProvider = provider9;
    }

    public static MembersInjector<OneIDSCALPBundle> create(Provider<Logger> provider, Provider<SWID> provider2, Provider<Bundler> provider3, Provider<SCALPController> provider4, Provider<GuestHandler> provider5, Provider<Tracker> provider6, Provider<InitializationCallbackHolder> provider7, Provider<Context> provider8, Provider<OneIDWebViewFactory> provider9) {
        return new OneIDSCALPBundle_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDSCALPBundle oneIDSCALPBundle) {
        injectLogger(oneIDSCALPBundle, (Logger) this.loggerProvider.get2());
        injectSwid(oneIDSCALPBundle, (SWID) this.swidProvider.get2());
        injectBundler(oneIDSCALPBundle, (Bundler) this.bundlerProvider.get2());
        injectScalpController(oneIDSCALPBundle, (SCALPController) this.scalpControllerProvider.get2());
        injectGuestHandler(oneIDSCALPBundle, (GuestHandler) this.guestHandlerProvider.get2());
        injectTracker(oneIDSCALPBundle, (Tracker) this.trackerProvider.get2());
        injectInitializationCallbackHolder(oneIDSCALPBundle, (InitializationCallbackHolder) this.initializationCallbackHolderProvider.get2());
        injectContext(oneIDSCALPBundle, (Context) this.contextProvider.get2());
        injectWebViewFactory(oneIDSCALPBundle, (OneIDWebViewFactory) this.webViewFactoryProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.logger")
    public static void injectLogger(OneIDSCALPBundle oneIDSCALPBundle, Logger logger) {
        oneIDSCALPBundle.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.swid")
    public static void injectSwid(OneIDSCALPBundle oneIDSCALPBundle, SWID swid) {
        oneIDSCALPBundle.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.bundler")
    public static void injectBundler(OneIDSCALPBundle oneIDSCALPBundle, Bundler bundler) {
        oneIDSCALPBundle.bundler = bundler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.scalpController")
    public static void injectScalpController(OneIDSCALPBundle oneIDSCALPBundle, SCALPController sCALPController) {
        oneIDSCALPBundle.scalpController = sCALPController;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.guestHandler")
    public static void injectGuestHandler(OneIDSCALPBundle oneIDSCALPBundle, GuestHandler guestHandler) {
        oneIDSCALPBundle.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.tracker")
    public static void injectTracker(OneIDSCALPBundle oneIDSCALPBundle, Tracker tracker) {
        oneIDSCALPBundle.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.initializationCallbackHolder")
    public static void injectInitializationCallbackHolder(OneIDSCALPBundle oneIDSCALPBundle, InitializationCallbackHolder initializationCallbackHolder) {
        oneIDSCALPBundle.initializationCallbackHolder = initializationCallbackHolder;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.context")
    public static void injectContext(OneIDSCALPBundle oneIDSCALPBundle, Context context) {
        oneIDSCALPBundle.context = context;
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDSCALPBundle.webViewFactory")
    public static void injectWebViewFactory(OneIDSCALPBundle oneIDSCALPBundle, OneIDWebViewFactory oneIDWebViewFactory) {
        oneIDSCALPBundle.webViewFactory = oneIDWebViewFactory;
    }
}
