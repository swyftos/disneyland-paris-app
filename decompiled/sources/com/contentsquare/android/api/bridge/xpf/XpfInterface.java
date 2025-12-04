package com.contentsquare.android.api.bridge.xpf;

import android.webkit.WebView;
import androidx.core.util.Consumer;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0866z0;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.S8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/XpfInterface;", "", "()V", "webViewIdProvider", "Lcom/contentsquare/android/api/bridge/xpf/XpfWebViewIdProvider;", "registerExternalBridge", "", "externalBridge", "Lcom/contentsquare/android/api/bridge/xpf/ExternalBridgeInterface;", "registerWebView", "webView", "Landroid/webkit/WebView;", "id", "", "unregisterExternalBridge", "unregisterWebView", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class XpfInterface {

    @NotNull
    public static final XpfInterface INSTANCE = new XpfInterface();

    @NotNull
    private static final XpfWebViewIdProvider webViewIdProvider = new XpfWebViewIdProvider(null, 1, 0 == true ? 1 : 0);

    private XpfInterface() {
    }

    private final void registerExternalBridge(final ExternalBridgeInterface externalBridge) {
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.api.bridge.xpf.XpfInterface$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                XpfInterface.registerExternalBridge$lambda$0(externalBridge, (M4) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerExternalBridge$lambda$0(ExternalBridgeInterface externalBridge, M4 m4) {
        Intrinsics.checkNotNullParameter(externalBridge, "$externalBridge");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        BridgeManager bridgeManager = csApplicationModule != null ? csApplicationModule.getBridgeManager() : null;
        if (bridgeManager != null) {
            bridgeManager.registerExternalBridge(externalBridge);
        }
    }

    private final void registerWebView(WebView webView, long id) {
        XpfWebViewIdProvider xpfWebViewIdProvider = webViewIdProvider;
        xpfWebViewIdProvider.addWebViewId(webView, id);
        S8.a(webView, xpfWebViewIdProvider);
    }

    private final void unregisterExternalBridge(final ExternalBridgeInterface externalBridge) {
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.api.bridge.xpf.XpfInterface$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                XpfInterface.unregisterExternalBridge$lambda$1(externalBridge, (M4) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterExternalBridge$lambda$1(ExternalBridgeInterface externalBridge, M4 m4) {
        Intrinsics.checkNotNullParameter(externalBridge, "$externalBridge");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        BridgeManager bridgeManager = csApplicationModule != null ? csApplicationModule.getBridgeManager() : null;
        if (bridgeManager != null) {
            bridgeManager.unregisterExternalBridge(externalBridge);
        }
    }

    private final void unregisterWebView(WebView webView) {
        webViewIdProvider.removeWebViewId(webView);
        S8.a(webView);
    }
}
