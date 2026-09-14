package com.contentsquare.android.sdk;

import android.webkit.WebView;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2661W6 implements InterfaceC2535J8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final SystemInstantiable f2215a;

    public C2661W6() {
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        this.f2215a = systemInstantiable;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2535J8
    public final long getWebViewId(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return this.f2215a.identityHashCode(webView);
    }
}
