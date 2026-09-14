package com.contentsquare.android.sdk;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.K8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2545K8 {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Pair f1797d = TuplesKt.m1842to(null, "");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final WebView f1798a;

    /* JADX INFO: renamed from: b */
    public boolean f1799b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1800c;

    public C2545K8(@NotNull WebView webView, boolean z) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f1798a = webView;
        this.f1799b = z;
        this.f1800c = new Logger("WebViewJsExecutor");
    }

    /* JADX INFO: renamed from: b */
    public static final void m968b(C2545K8 this$0, Function1 callback, String str) {
        Pair pairM1842to;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getClass();
        if (str == null || str.length() == 0 || StringsKt.equals(str, "null", true)) {
            this$0.m970a(this$0.f1798a, callback);
            return;
        }
        if (this$0.f1799b) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                callback.invoke(TuplesKt.m1842to(ExtensionsKt.getStringOrNull(jSONObject, "serializationId"), jSONObject.optString("serializedDom")));
                return;
            } catch (JSONException e) {
                C2599Q2.m1011a(this$0.f1800c, "Failed to serialized WebView result callback to JSON", e);
                pairM1842to = f1797d;
            }
        } else {
            pairM1842to = TuplesKt.m1842to(null, str);
        }
        callback.invoke(pairM1842to);
    }

    /* JADX INFO: renamed from: a */
    public final void m970a(WebView webView, final Function1<? super Pair<String, String>, Unit> function1) {
        webView.evaluateJavascript("JSON.parse(cs_wvt.push(['serializeWebView']));", new ValueCallback() { // from class: com.contentsquare.android.sdk.K8$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C2545K8.m967a(this.f$0, function1, (String) obj);
            }
        });
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m974c() {
        this.f1798a.evaluateJavascript("window._uxa.push(['webview:analytics:stop'])", null);
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public final void m975d() {
        this.f1798a.evaluateJavascript("window._uxa.push(['webview:replay:stop'])", null);
    }

    /* JADX INFO: renamed from: a */
    public static final void m967a(C2545K8 this$0, Function1 callback, String str) {
        Pair pairM1842to;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getClass();
        if (str == null || str.length() == 0 || StringsKt.equals(str, "null", true)) {
            this$0.f1800c.m834w("Failed to get tracking tag result callback from WebView");
            pairM1842to = f1797d;
        } else {
            pairM1842to = TuplesKt.m1842to(null, str);
        }
        callback.invoke(pairM1842to);
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final void m973b() {
        this.f1798a.evaluateJavascript("window._uxa.push(['webview:replay:start'])", null);
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m972a(@NotNull final C2548L1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = String.format("JSON.parse(window._uxa.push(['serializeWebView', { withAssets: %s }]));", Arrays.copyOf(new Object[]{String.valueOf(this.f1799b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        this.f1798a.evaluateJavascript(str, new ValueCallback() { // from class: com.contentsquare.android.sdk.K8$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C2545K8.m968b(this.f$0, callback, (String) obj);
            }
        });
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m971a(@NotNull EnumC2465C8 transformerMode) {
        Intrinsics.checkNotNullParameter(transformerMode, "transformerMode");
        String str = String.format("window._uxa.push(['setAssetTransformerMode', '%s']);", Arrays.copyOf(new Object[]{transformerMode.name()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        this.f1798a.evaluateJavascript(str, null);
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m969a() {
        this.f1798a.evaluateJavascript("window._uxa.push(['webview:analytics:start'])", null);
    }
}
