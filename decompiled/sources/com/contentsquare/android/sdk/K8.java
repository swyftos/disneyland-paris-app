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

/* loaded from: classes2.dex */
public final class K8 {

    @NotNull
    public static final Pair d = TuplesKt.to(null, "");

    @NotNull
    public final WebView a;
    public boolean b;

    @NotNull
    public final Logger c;

    public K8(@NotNull WebView webView, boolean z) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = webView;
        this.b = z;
        this.c = new Logger("WebViewJsExecutor");
    }

    public static final void b(K8 this$0, Function1 callback, String str) {
        Pair pair;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getClass();
        if (str == null || str.length() == 0 || StringsKt.equals(str, "null", true)) {
            this$0.a(this$0.a, callback);
            return;
        }
        if (this$0.b) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                callback.invoke(TuplesKt.to(ExtensionsKt.getStringOrNull(jSONObject, "serializationId"), jSONObject.optString("serializedDom")));
                return;
            } catch (JSONException e) {
                Q2.a(this$0.c, "Failed to serialized WebView result callback to JSON", e);
                pair = d;
            }
        } else {
            pair = TuplesKt.to(null, str);
        }
        callback.invoke(pair);
    }

    public final void a(WebView webView, final Function1<? super Pair<String, String>, Unit> function1) {
        webView.evaluateJavascript("JSON.parse(cs_wvt.push(['serializeWebView']));", new ValueCallback() { // from class: com.contentsquare.android.sdk.K8$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                K8.a(this.f$0, function1, (String) obj);
            }
        });
    }

    @MainThread
    public final void c() {
        this.a.evaluateJavascript("window._uxa.push(['webview:analytics:stop'])", null);
    }

    @MainThread
    public final void d() {
        this.a.evaluateJavascript("window._uxa.push(['webview:replay:stop'])", null);
    }

    public static final void a(K8 this$0, Function1 callback, String str) {
        Pair pair;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getClass();
        if (str == null || str.length() == 0 || StringsKt.equals(str, "null", true)) {
            this$0.c.w("Failed to get tracking tag result callback from WebView");
            pair = d;
        } else {
            pair = TuplesKt.to(null, str);
        }
        callback.invoke(pair);
    }

    @MainThread
    public final void b() {
        this.a.evaluateJavascript("window._uxa.push(['webview:replay:start'])", null);
    }

    @MainThread
    public final void a(@NotNull final L1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = String.format("JSON.parse(window._uxa.push(['serializeWebView', { withAssets: %s }]));", Arrays.copyOf(new Object[]{String.valueOf(this.b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        this.a.evaluateJavascript(str, new ValueCallback() { // from class: com.contentsquare.android.sdk.K8$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                K8.b(this.f$0, callback, (String) obj);
            }
        });
    }

    @MainThread
    public final void a(@NotNull C8 transformerMode) {
        Intrinsics.checkNotNullParameter(transformerMode, "transformerMode");
        String str = String.format("window._uxa.push(['setAssetTransformerMode', '%s']);", Arrays.copyOf(new Object[]{transformerMode.name()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        this.a.evaluateJavascript(str, null);
    }

    @MainThread
    public final void a() {
        this.a.evaluateJavascript("window._uxa.push(['webview:analytics:start'])", null);
    }
}
