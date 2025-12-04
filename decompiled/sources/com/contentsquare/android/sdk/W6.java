package com.contentsquare.android.sdk;

import android.webkit.WebView;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class W6 implements J8 {

    @NotNull
    public final SystemInstantiable a;

    public W6() {
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.a = systemInstantiable;
    }

    @Override // com.contentsquare.android.sdk.J8
    public final long getWebViewId(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return this.a.identityHashCode(webView);
    }
}
