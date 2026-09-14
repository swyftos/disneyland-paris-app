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
import com.contentsquare.android.internal.features.webviewbridge.assets.C2431a;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.S8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nWebViewTrackingManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewTrackingManager.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTrackingManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1#2:195\n1#2:197\n1#2:199\n1#2:201\n1#2:203\n563#3:196\n563#3:198\n563#3:200\n215#3,2:204\n2634#4:202\n*S KotlinDebug\n*F\n+ 1 WebViewTrackingManager.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewTrackingManager\n*L\n121#1:197\n127#1:199\n136#1:201\n153#1:203\n121#1:196\n127#1:198\n136#1:200\n181#1:204,2\n153#1:202\n*E\n"})
public final class C2624S8 {

    /* JADX INFO: renamed from: e */
    @Nullable
    public static C2563M6 f2122e;

    /* JADX INFO: renamed from: f */
    public static boolean f2123f;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C2624S8 f2118a = new C2624S8();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Lazy f2119b = LazyKt.lazy(e.f2129a);

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final C2515H8 f2120c = new C2515H8(new C2494F7(C2598Q1.f1993f));

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Lazy f2121d = LazyKt.lazy(f.f2130a);

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final WeakHashMap<WebView, C2557M0> f2124g = new WeakHashMap<>();

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Handler f2125h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final Lazy f2126i = LazyKt.lazy(d.f2128a);

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$a */
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<C2431a> {
        public a(Object obj) {
            super(0, obj, C2624S8.class, "buildWebViewAssetProcessor", "buildWebViewAssetProcessor()Lcom/contentsquare/android/internal/features/webviewbridge/assets/WebViewAssetsProcessor;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2431a invoke() {
            C2563M6 staticResourceManager;
            C2563M6 staticResourceManager2;
            ((C2624S8) this.receiver).getClass();
            C2563M6 c2563m6 = C2624S8.f2122e;
            if (c2563m6 == null) {
                CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
                if (csApplicationModule != null && (staticResourceManager2 = csApplicationModule.getStaticResourceManager()) != null) {
                    C2624S8.f2122e = staticResourceManager2;
                }
                c2563m6 = C2624S8.f2122e;
            }
            if (c2563m6 == null) {
                return null;
            }
            CsApplicationModule csApplicationModule2 = CsApplicationModule.getInstance();
            if ((csApplicationModule2 != null ? csApplicationModule2.getWebViewAssetCache() : null) == null) {
                return null;
            }
            CsApplicationModule csApplicationModule3 = CsApplicationModule.getInstance();
            C2536K webViewAssetCache = csApplicationModule3 != null ? csApplicationModule3.getWebViewAssetCache() : null;
            Intrinsics.checkNotNull(webViewAssetCache);
            C2563M6 c2563m7 = C2624S8.f2122e;
            if (c2563m7 == null) {
                CsApplicationModule csApplicationModule4 = CsApplicationModule.getInstance();
                if (csApplicationModule4 != null && (staticResourceManager = csApplicationModule4.getStaticResourceManager()) != null) {
                    C2624S8.f2122e = staticResourceManager;
                }
                c2563m7 = C2624S8.f2122e;
            }
            Intrinsics.checkNotNull(c2563m7);
            return new C2431a(webViewAssetCache, c2563m7, (C2587P0) C2624S8.f2126i.getValue());
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$b */
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<EnumC2465C8> {
        public b(Object obj) {
            super(0, obj, C2624S8.class, "getCurrentTransformerMode", "getCurrentTransformerMode()Lcom/contentsquare/android/internal/features/webviewbridge/WebViewAssetTransformerMode;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EnumC2465C8 invoke() {
            ((C2624S8) this.receiver).getClass();
            return C2624S8.f2123f ? EnumC2465C8.ONLY_LOCAL_ASSETS : EnumC2465C8.NONE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$c */
    public static final class c extends Lambda implements Function0<PreferencesStore> {

        /* JADX INFO: renamed from: a */
        public static final c f2127a = new c();

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

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$d */
    public static final class d extends Lambda implements Function0<C2587P0> {

        /* JADX INFO: renamed from: a */
        public static final d f2128a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2587P0 invoke() {
            return new C2587P0(new C2597Q0(), new C2577O0());
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$e */
    public static final class e extends Lambda implements Function0<Logger> {

        /* JADX INFO: renamed from: a */
        public static final e f2129a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger("WebViewInjectionManager");
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.S8$f */
    public static final class f extends Lambda implements Function0<C2555L8> {

        /* JADX INFO: renamed from: a */
        public static final f f2130a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2555L8 invoke() {
            return new C2555L8();
        }
    }

    @JvmStatic
    @JvmOverloads
    @SuppressLint({"WebViewApiAvailability"})
    /* JADX INFO: renamed from: a */
    public static final void m1031a(@NotNull WebView webView, @NotNull InterfaceC2535J8 webViewIdProvider) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(webViewIdProvider, "webViewIdProvider");
        if (!webView.getSettings().getJavaScriptEnabled()) {
            f2118a.getClass();
            ((Logger) f2119b.getValue()).m831i("Can't attach webview, JavaScript is not enabled on this webView.");
            return;
        }
        long webViewId = webViewIdProvider.getWebViewId(webView);
        C2515H8 c2515h8 = f2120c;
        C2624S8 c2624s8 = f2118a;
        a aVar = new a(c2624s8);
        b bVar = new b(c2624s8);
        c cVar = c.f2127a;
        c2624s8.getClass();
        C2555L8 c2555l8 = (C2555L8) f2121d.getValue();
        boolean z = f2123f;
        c2555l8.getClass();
        Intrinsics.checkNotNullParameter(webView, "webView");
        C2557M0 c2557m0 = new C2557M0(webView, webViewId, c2515h8, aVar, bVar, cVar, new C2545K8(webView, z), f2125h);
        webView.addJavascriptInterface(c2557m0, "CSJavascriptBridge");
        WebViewClient webViewClient = webView.getWebViewClient();
        Intrinsics.checkNotNullExpressionValue(webViewClient, "webView.webViewClient");
        if (!(webViewClient instanceof CsWebViewClient)) {
            WebViewClient webViewClient2 = webView.getWebViewClient();
            Intrinsics.checkNotNullExpressionValue(webViewClient2, "webView.webViewClient");
            webView.setWebViewClient(new CsProxyWebViewClient(webViewClient2, null, 2, 0 == true ? 1 : 0));
        }
        CsJavascriptBridgeInjector.INSTANCE.ensureBridgeInjected(webView, c2557m0, "CSJavascriptBridge");
        f2124g.put(webView, c2557m0);
        ((Logger) f2119b.getValue()).m831i("Js interface added to the webView");
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m1030a(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (webView.getSettings().getJavaScriptEnabled()) {
            webView.removeJavascriptInterface("CSJavascriptBridge");
            f2124g.remove(webView);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1029a() {
        WeakHashMap<WebView, C2557M0> weakHashMap = f2124g;
        if (weakHashMap.isEmpty()) {
            return;
        }
        final EnumC2465C8 enumC2465C8 = f2123f ? EnumC2465C8.ONLY_LOCAL_ASSETS : EnumC2465C8.NONE;
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            f2125h.post(new Runnable() { // from class: com.contentsquare.android.sdk.S8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2624S8.m1032a(enumC2465C8);
                }
            });
            return;
        }
        Iterator<Map.Entry<WebView, C2557M0>> it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().f1848g.m971a(enumC2465C8);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1032a(EnumC2465C8 transformerMode) {
        Intrinsics.checkNotNullParameter(transformerMode, "$transformerMode");
        f2118a.getClass();
        Iterator<Map.Entry<WebView, C2557M0>> it = f2124g.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().f1848g.m971a(transformerMode);
        }
    }
}
