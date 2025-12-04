package com.contentsquare.rn.utils;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/contentsquare/rn/utils/WebViewUtils;", "", "<init>", "()V", "getWebViewClient", "Landroid/webkit/WebViewClient;", "webView", "Landroid/webkit/WebView;", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewUtils {

    @NotNull
    public static final WebViewUtils INSTANCE = new WebViewUtils();

    private WebViewUtils() {
    }

    @SuppressLint({"WebViewApiAvailability", "NewApi"})
    @Nullable
    public final WebViewClient getWebViewClient(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (VersionUtils.INSTANCE.isApiLevelAtLeast(26)) {
            return webView.getWebViewClient();
        }
        return null;
    }
}
