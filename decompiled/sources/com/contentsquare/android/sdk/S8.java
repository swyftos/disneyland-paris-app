package com.contentsquare.android.sdk;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.contentsquare.android.api.CsJavascriptBridgeInjector;
import com.contentsquare.android.api.CsProxyWebViewClient;
import com.contentsquare.android.api.CsWebViewClient;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWebViewTrackingManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewTrackingManager.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTrackingManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1#2:195\n1#2:197\n1#2:199\n1#2:201\n1#2:203\n563#3:196\n563#3:198\n563#3:200\n215#3,2:204\n2634#4:202\n*S KotlinDebug\n*F\n+ 1 WebViewTrackingManager.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTrackingManager\n*L\n121#1:197\n127#1:199\n136#1:201\n153#1:203\n121#1:196\n127#1:198\n136#1:200\n181#1:204,2\n153#1:202\n*E\n"})
/* loaded from: classes2.dex */
public final class S8 {

    @Nullable
    public static M6 e;
    public static boolean f;

    @NotNull
    public static final S8 a = new S8();

    @NotNull
    public static final Lazy b = LazyKt.lazy(e.a);

    @NotNull
    public static final H8 c = new H8(new F7(Q1.f));

    @NotNull
    public static final Lazy d = LazyKt.lazy(f.a);

    @NotNull
    public static final WeakHashMap<WebView, M0> g = new WeakHashMap<>();

    @NotNull
    public static final Handler h = new Handler(Looper.getMainLooper());

    @NotNull
    public static final Lazy i = LazyKt.lazy(d.a);

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<com.contentsquare.android.internal.features.webviewbridge.assets.a> {
        public a(Object obj) {
            super(0, obj, S8.class, "buildWebViewAssetProcessor", "buildWebViewAssetProcessor()Lcom/contentsquare/android/internal/features/webviewbridge/assets/WebViewAssetsProcessor;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final com.contentsquare.android.internal.features.webviewbridge.assets.a invoke() {
            M6 staticResourceManager;
            M6 staticResourceManager2;
            ((S8) this.receiver).getClass();
            M6 m6 = S8.e;
            if (m6 == null) {
                CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
                if (csApplicationModule != null && (staticResourceManager2 = csApplicationModule.getStaticResourceManager()) != null) {
                    S8.e = staticResourceManager2;
                }
                m6 = S8.e;
            }
            if (m6 == null) {
                return null;
            }
            CsApplicationModule csApplicationModule2 = CsApplicationModule.getInstance();
            if ((csApplicationModule2 != null ? csApplicationModule2.getWebViewAssetCache() : null) == null) {
                return null;
            }
            CsApplicationModule csApplicationModule3 = CsApplicationModule.getInstance();
            K webViewAssetCache = csApplicationModule3 != null ? csApplicationModule3.getWebViewAssetCache() : null;
            Intrinsics.checkNotNull(webViewAssetCache);
            M6 m62 = S8.e;
            if (m62 == null) {
                CsApplicationModule csApplicationModule4 = CsApplicationModule.getInstance();
                if (csApplicationModule4 != null && (staticResourceManager = csApplicationModule4.getStaticResourceManager()) != null) {
                    S8.e = staticResourceManager;
                }
                m62 = S8.e;
            }
            Intrinsics.checkNotNull(m62);
            return new com.contentsquare.android.internal.features.webviewbridge.assets.a(webViewAssetCache, m62, (P0) S8.i.getValue());
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<C8> {
        public b(Object obj) {
            super(0, obj, S8.class, "getCurrentTransformerMode", "getCurrentTransformerMode()Lcom/contentsquare/android/internal/features/webviewbridge/WebViewAssetTransformerMode;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C8 invoke() {
            ((S8) this.receiver).getClass();
            return S8.f ? C8.ONLY_LOCAL_ASSETS : C8.NONE;
        }
    }

    public static final class c extends Lambda implements Function0<PreferencesStore> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final PreferencesStore invoke() {
            CoreModule companion = CoreModule.INSTANCE.getInstance();
            if (companion != null) {
                return companion.getPreferencesStore();
            }
            return null;
        }
    }

    public static final class d extends Lambda implements Function0<P0> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final P0 invoke() {
            return new P0(new Q0(), new O0());
        }
    }

    public static final class e extends Lambda implements Function0<Logger> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger("WebViewInjectionManager");
        }
    }

    public static final class f extends Lambda implements Function0<L8> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final L8 invoke() {
            return new L8();
        }
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"WebViewApiAvailability"})
    public static final void a(@NotNull WebView webView, @NotNull J8 webViewIdProvider) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(webViewIdProvider, "webViewIdProvider");
        if (!webView.getSettings().getJavaScriptEnabled()) {
            a.getClass();
            ((Logger) b.getValue()).i("Can't attach webview, JavaScript is not enabled on this webView.");
            return;
        }
        long webViewId = webViewIdProvider.getWebViewId(webView);
        H8 h8 = c;
        S8 s8 = a;
        a aVar = new a(s8);
        b bVar = new b(s8);
        c cVar = c.a;
        s8.getClass();
        L8 l8 = (L8) d.getValue();
        boolean z = f;
        l8.getClass();
        Intrinsics.checkNotNullParameter(webView, "webView");
        M0 m0 = new M0(webView, webViewId, h8, aVar, bVar, cVar, new K8(webView, z), h);
        webView.addJavascriptInterface(m0, "CSJavascriptBridge");
        WebViewClient webViewClient = webView.getWebViewClient();
        Intrinsics.checkNotNullExpressionValue(webViewClient, "webView.webViewClient");
        if (!(webViewClient instanceof CsWebViewClient)) {
            WebViewClient webViewClient2 = webView.getWebViewClient();
            Intrinsics.checkNotNullExpressionValue(webViewClient2, "webView.webViewClient");
            webView.setWebViewClient(new CsProxyWebViewClient(webViewClient2, null, 2, 0 == true ? 1 : 0));
        }
        CsJavascriptBridgeInjector.INSTANCE.ensureBridgeInjected(webView, m0, "CSJavascriptBridge");
        g.put(webView, m0);
        ((Logger) b.getValue()).i("Js interface added to the webView");
    }

    @JvmStatic
    public static final void a(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (webView.getSettings().getJavaScriptEnabled()) {
            webView.removeJavascriptInterface("CSJavascriptBridge");
            g.remove(webView);
        }
    }

    public static void a() {
        WeakHashMap<WebView, M0> weakHashMap = g;
        if (weakHashMap.isEmpty()) {
            return;
        }
        final C8 c8 = f ? C8.ONLY_LOCAL_ASSETS : C8.NONE;
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            h.post(new Runnable() { // from class: com.contentsquare.android.sdk.S8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    S8.a(c8);
                }
            });
            return;
        }
        Iterator<Map.Entry<WebView, M0>> it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g.a(c8);
        }
    }

    public static final void a(C8 transformerMode) {
        Intrinsics.checkNotNullParameter(transformerMode, "$transformerMode");
        a.getClass();
        Iterator<Map.Entry<WebView, M0>> it = g.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g.a(transformerMode);
        }
    }
}
