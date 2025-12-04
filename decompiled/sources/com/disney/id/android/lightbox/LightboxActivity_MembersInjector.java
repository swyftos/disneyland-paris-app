package com.disney.id.android.lightbox;

import com.disney.id.android.ConfigHandler;
import com.disney.id.android.SWID;
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
public final class LightboxActivity_MembersInjector implements MembersInjector<LightboxActivity> {
    private final Provider configHandlerProvider;
    private final Provider loggerProvider;
    private final Provider swidProvider;
    private final Provider trackerProvider;
    private final Provider webViewFactoryProvider;

    public LightboxActivity_MembersInjector(Provider<Logger> provider, Provider<SWID> provider2, Provider<Tracker> provider3, Provider<OneIDWebViewFactory> provider4, Provider<ConfigHandler> provider5) {
        this.loggerProvider = provider;
        this.swidProvider = provider2;
        this.trackerProvider = provider3;
        this.webViewFactoryProvider = provider4;
        this.configHandlerProvider = provider5;
    }

    public static MembersInjector<LightboxActivity> create(Provider<Logger> provider, Provider<SWID> provider2, Provider<Tracker> provider3, Provider<OneIDWebViewFactory> provider4, Provider<ConfigHandler> provider5) {
        return new LightboxActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LightboxActivity lightboxActivity) {
        injectLogger(lightboxActivity, (Logger) this.loggerProvider.get2());
        injectSwid(lightboxActivity, (SWID) this.swidProvider.get2());
        injectTracker(lightboxActivity, (Tracker) this.trackerProvider.get2());
        injectWebViewFactory(lightboxActivity, (OneIDWebViewFactory) this.webViewFactoryProvider.get2());
        injectConfigHandler(lightboxActivity, (ConfigHandler) this.configHandlerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxActivity.logger")
    public static void injectLogger(LightboxActivity lightboxActivity, Logger logger) {
        lightboxActivity.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxActivity.swid")
    public static void injectSwid(LightboxActivity lightboxActivity, SWID swid) {
        lightboxActivity.swid = swid;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxActivity.tracker")
    public static void injectTracker(LightboxActivity lightboxActivity, Tracker tracker) {
        lightboxActivity.tracker = tracker;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxActivity.webViewFactory")
    public static void injectWebViewFactory(LightboxActivity lightboxActivity, OneIDWebViewFactory oneIDWebViewFactory) {
        lightboxActivity.webViewFactory = oneIDWebViewFactory;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxActivity.configHandler")
    public static void injectConfigHandler(LightboxActivity lightboxActivity, ConfigHandler configHandler) {
        lightboxActivity.configHandler = configHandler;
    }
}
