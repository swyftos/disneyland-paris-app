package com.disney.id.android.lightbox;

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
public final class WebViewBridgeV4_MembersInjector implements MembersInjector<WebViewBridgeV4> {
    private final Provider loggerProvider;
    private final Provider trackerProvider;

    public WebViewBridgeV4_MembersInjector(Provider<Logger> provider, Provider<Tracker> provider2) {
        this.loggerProvider = provider;
        this.trackerProvider = provider2;
    }

    public static MembersInjector<WebViewBridgeV4> create(Provider<Logger> provider, Provider<Tracker> provider2) {
        return new WebViewBridgeV4_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WebViewBridgeV4 webViewBridgeV4) {
        injectLogger(webViewBridgeV4, (Logger) this.loggerProvider.get2());
        injectTracker(webViewBridgeV4, (Tracker) this.trackerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebViewBridgeV4.logger")
    public static void injectLogger(WebViewBridgeV4 webViewBridgeV4, Logger logger) {
        webViewBridgeV4.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebViewBridgeV4.tracker")
    public static void injectTracker(WebViewBridgeV4 webViewBridgeV4, Tracker tracker) {
        webViewBridgeV4.tracker = tracker;
    }
}
