package com.contentsquare.android.api.bridge.xpf;

import android.webkit.WebView;
import com.contentsquare.android.sdk.J8;
import com.contentsquare.android.sdk.W6;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/XpfWebViewIdProvider;", "Lcom/contentsquare/android/sdk/J8;", "defaultWebViewIdProvider", "<init>", "(Lcom/contentsquare/android/sdk/J8;)V", "Landroid/webkit/WebView;", "webView", "", "getWebViewId", "(Landroid/webkit/WebView;)J", "id", "", "addWebViewId", "(Landroid/webkit/WebView;J)V", "removeWebViewId", "(Landroid/webkit/WebView;)V", "Lcom/contentsquare/android/sdk/J8;", "Ljava/util/WeakHashMap;", "registeredWebViewIds", "Ljava/util/WeakHashMap;", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class XpfWebViewIdProvider implements J8 {

    @NotNull
    private final J8 defaultWebViewIdProvider;

    @NotNull
    private final WeakHashMap<WebView, Long> registeredWebViewIds;

    public XpfWebViewIdProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void addWebViewId(@NotNull WebView webView, long id) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.registeredWebViewIds.put(webView, Long.valueOf(id));
    }

    @Override // com.contentsquare.android.sdk.J8
    public long getWebViewId(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Long l = this.registeredWebViewIds.get(webView);
        return l == null ? this.defaultWebViewIdProvider.getWebViewId(webView) : l.longValue();
    }

    public final void removeWebViewId(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.registeredWebViewIds.remove(webView);
    }

    public XpfWebViewIdProvider(@NotNull J8 defaultWebViewIdProvider) {
        Intrinsics.checkNotNullParameter(defaultWebViewIdProvider, "defaultWebViewIdProvider");
        this.defaultWebViewIdProvider = defaultWebViewIdProvider;
        this.registeredWebViewIds = new WeakHashMap<>();
    }

    public /* synthetic */ XpfWebViewIdProvider(J8 j8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new W6() : j8);
    }
}
