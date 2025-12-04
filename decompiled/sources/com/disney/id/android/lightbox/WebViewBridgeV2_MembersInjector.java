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
public final class WebViewBridgeV2_MembersInjector implements MembersInjector<WebViewBridgeV2> {
    private final Provider loggerProvider;
    private final Provider trackerProvider;

    public WebViewBridgeV2_MembersInjector(Provider<Logger> provider, Provider<Tracker> provider2) {
        this.loggerProvider = provider;
        this.trackerProvider = provider2;
    }

    public static MembersInjector<WebViewBridgeV2> create(Provider<Logger> provider, Provider<Tracker> provider2) {
        return new WebViewBridgeV2_MembersInjector(provider, provider2);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WebViewBridgeV2 webViewBridgeV2) {
        injectLogger(webViewBridgeV2, (Logger) this.loggerProvider.get2());
        injectTracker(webViewBridgeV2, (Tracker) this.trackerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebViewBridgeV2.logger")
    public static void injectLogger(WebViewBridgeV2 webViewBridgeV2, Logger logger) {
        webViewBridgeV2.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.WebViewBridgeV2.tracker")
    public static void injectTracker(WebViewBridgeV2 webViewBridgeV2, Tracker tracker) {
        webViewBridgeV2.tracker = tracker;
    }
}
