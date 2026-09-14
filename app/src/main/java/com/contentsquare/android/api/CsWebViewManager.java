package com.contentsquare.android.api;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.sdk.C2624S8;
import com.contentsquare.android.sdk.C2661W6;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/contentsquare/android/api/CsWebViewManager;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "injectEventTrackingInterface", "", "webView", "Landroid/webkit/WebView;", "removeEventTrackingInterface", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class CsWebViewManager {

    @NotNull
    public static final CsWebViewManager INSTANCE = new CsWebViewManager();

    @NotNull
    private static final Logger logger = new Logger("CsWebViewManager");

    private CsWebViewManager() {
    }

    @JvmStatic
    @SuppressLint({"SetJavaScriptEnabled"})
    public static final void injectEventTrackingInterface(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (!webView.getSettings().getJavaScriptEnabled()) {
            logger.m833p("Enabling Javascript on the provided WebView");
            webView.getSettings().setJavaScriptEnabled(true);
        }
        C2624S8 c2624s8 = C2624S8.f2118a;
        C2624S8.m1031a(webView, new C2661W6());
        Telemetry.INSTANCE.collectApiCall("track_webview");
        logger.m833p("WebView detected and WebView tracking enabled on native side");
    }

    public final void removeEventTrackingInterface(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        C2624S8.m1030a(webView);
        Telemetry.INSTANCE.collectApiCall("untrack_webview");
    }
}
