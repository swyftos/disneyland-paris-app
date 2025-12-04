package com.contentsquare.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.android.R;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import com.contentsquare.android.sdk.S8;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nCsJavaScriptInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CsJavaScriptInterface.kt\ncom/contentsquare/android/internal/features/webviewbridge/CsJavaScriptInterface\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,322:1\n96#2:323\n*S KotlinDebug\n*F\n+ 1 CsJavaScriptInterface.kt\ncom/contentsquare/android/internal/features/webviewbridge/CsJavaScriptInterface\n*L\n205#1:323\n*E\n"})
/* loaded from: classes2.dex */
public final class M0 {

    @NotNull
    public final WebView a;
    public final long b;

    @NotNull
    public final G8 c;

    @NotNull
    public final Function0<com.contentsquare.android.internal.features.webviewbridge.assets.a> d;

    @NotNull
    public final Function0<C8> e;

    @NotNull
    public final Function0<PreferencesStore> f;

    @NotNull
    public final K8 g;

    @NotNull
    public final Handler h;

    @NotNull
    public final Logger i;
    public final Context j;

    @Nullable
    public A8 k;

    @Nullable
    public N8 l;

    public M0() {
        throw null;
    }

    public M0(WebView webView, long j, H8 webViewEventProcessorsFactory, S8.a webViewAssetsProcessor, S8.b transformerModeFactory, Function0 preferencesStore, K8 webViewJsExecutor, Handler mainThreadHandler) {
        Logger logger = new Logger("CsJavaScriptInterface");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(webViewEventProcessorsFactory, "webViewEventProcessorsFactory");
        Intrinsics.checkNotNullParameter(webViewAssetsProcessor, "webViewAssetsProcessor");
        Intrinsics.checkNotNullParameter(transformerModeFactory, "transformerModeFactory");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(webViewJsExecutor, "webViewJsExecutor");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = webView;
        this.b = j;
        this.c = webViewEventProcessorsFactory;
        this.d = webViewAssetsProcessor;
        this.e = transformerModeFactory;
        this.f = preferencesStore;
        this.g = webViewJsExecutor;
        this.h = mainThreadHandler;
        this.i = logger;
        this.j = webView.getContext().getApplicationContext();
    }

    public final boolean a() {
        PreferencesStore preferencesStoreInvoke = this.f.invoke();
        boolean z = preferencesStoreInvoke != null ? preferencesStoreInvoke.getBoolean(PreferencesKey.IS_OPT_OUT, false) : false;
        PreferencesStore preferencesStoreInvoke2 = this.f.invoke();
        boolean z2 = preferencesStoreInvoke2 != null ? preferencesStoreInvoke2.getBoolean(PreferencesKey.TRACKING_ENABLE, false) : false;
        PreferencesStore preferencesStoreInvoke3 = this.f.invoke();
        boolean z3 = preferencesStoreInvoke3 != null ? preferencesStoreInvoke3.getBoolean(PreferencesKey.FORGET_ME, false) : false;
        PreferencesStore preferencesStoreInvoke4 = this.f.invoke();
        return (z || !z2 || z3 || (preferencesStoreInvoke4 != null ? preferencesStoreInvoke4.getBoolean(PreferencesKey.PAUSE_TRACKING, false) : false)) ? false : true;
    }

    @Nullable
    public final A8 b() {
        Activity activity;
        A8 a8 = this.k;
        if (a8 != null) {
            return a8;
        }
        Object tag = this.a.getTag(R.string.contentsquare_react_native_web_view_activity_tag);
        if (tag instanceof Activity) {
            activity = (Activity) tag;
        } else if (this.a.getContext() instanceof Activity) {
            tag = this.a.getContext();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type android.app.Activity");
            activity = (Activity) tag;
        } else {
            activity = null;
        }
        if (activity == null) {
            return null;
        }
        A8 a8A = this.c.a(this.a, activity);
        this.k = a8A;
        return a8A;
    }

    @JavascriptInterface
    @NotNull
    public final String getAssetTransformerMode() {
        return this.e.invoke().name();
    }

    @JavascriptInterface
    public final int getVersion() {
        return 2;
    }

    @JavascriptInterface
    public final void onWebviewTrackingReady() {
        this.i.d("onWebViewTrackingReady");
        if (a()) {
            this.h.post(new Runnable() { // from class: com.contentsquare.android.sdk.M0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    M0.a(this.f$0);
                }
            });
        }
    }

    @JavascriptInterface
    public final void optIn() {
        this.i.d("optIn triggered");
        Contentsquare.optIn(this.j);
    }

    @JavascriptInterface
    public final void optOut() {
        this.i.d("optOut triggered");
        Contentsquare.optOut(this.j);
    }

    @JavascriptInterface
    public final void sendAssets(@NotNull String jsonAssets, @Nullable String str) {
        Intrinsics.checkNotNullParameter(jsonAssets, "jsonAssets");
        try {
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            List<WebViewAsset> list = (List) companion.decodeFromString(new ArrayListSerializer(WebViewAsset.Companion.serializer()), jsonAssets);
            PreferencesStore preferencesStoreInvoke = this.f.invoke();
            if (preferencesStoreInvoke != null) {
                boolean z = preferencesStoreInvoke.getBoolean(PreferencesKey.IS_OPT_OUT, false);
                com.contentsquare.android.internal.features.webviewbridge.assets.a aVarInvoke = this.d.invoke();
                if (aVarInvoke != null) {
                    aVarInvoke.a(list, str, z);
                }
            }
        } catch (SerializationException e) {
            Q2.a(this.i, "Json Error while parsing " + jsonAssets, e);
        }
    }

    @JavascriptInterface
    public final void sendDynamicVar(@NotNull String key, @NotNull String value) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            long j = Long.parseLong(value);
            this.i.d("Receiving Dvar, with key = " + key + ", value(int) = " + j);
            Contentsquare.send(key, j);
        } catch (NumberFormatException unused) {
            this.i.d("Receiving Dvar, with key = " + key + ", value(String) = " + value);
            Contentsquare.send(key, value);
        }
    }

    @JavascriptInterface
    public final void sendEvent(@NotNull String obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.i.d("sendEvent triggered: " + obj);
        try {
            JSONObject jSONObject = new JSONObject(obj);
            A8 a8B = b();
            if (a8B != null) {
                a8B.a(jSONObject);
            }
        } catch (JSONException e) {
            Q2.a(this.i, "Error while parsing " + obj, e);
        }
    }

    @JavascriptInterface
    public final void sendLog(@NotNull String obj) throws JSONException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.i.d("sendLog triggered: " + obj);
        try {
            JSONObject jSONObject = new JSONObject(obj);
            String string = jSONObject.getString("message");
            String string2 = jSONObject.getString("errorCode");
            String level = jSONObject.getString("level");
            A8 a8B = b();
            if (a8B != null) {
                Intrinsics.checkNotNullExpressionValue(level, "level");
                a8B.a(string, string2, level);
            }
        } catch (JSONException e) {
            Q2.a(this.i, "Error while parsing " + obj, e);
        }
    }

    @JavascriptInterface
    public final void sendNativeSREvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.i.d("sendNativeSREvent triggered: " + event);
            JSONObject jSONObject = new JSONObject(event);
            N8 n8A = this.l;
            if (n8A == null) {
                n8A = this.c.a();
                this.l = n8A;
            }
            if (n8A != null) {
                n8A.a(jSONObject);
            }
        } catch (JSONException e) {
            Q2.a(this.i, "Json Error while parsing " + event, e);
        }
    }

    @JavascriptInterface
    public final void sendSREvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.i.d("sendSrEvent triggered: " + event);
        C5 c5 = C5.k;
        if (c5 != null) {
            O8 event2 = new O8(event, this.b);
            Intrinsics.checkNotNullParameter(event2, "event");
            c5.d.a(event2);
        }
    }

    @JavascriptInterface
    public final void sendTransaction(@Nullable String str, float f, @NotNull String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.i.d("Receiving transaction, with id = " + str + ", value(float) = " + f + ", currency = " + currency);
        Transaction.TransactionBuilder transactionBuilderBuilder = Transaction.INSTANCE.builder(f, currency);
        if (str != null) {
            transactionBuilderBuilder.id(str);
        }
        Contentsquare.send(transactionBuilderBuilder.build());
    }

    public static final void a(M0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g.a();
        if (C5.k != null) {
            this$0.i.d("onWebViewTrackingReady => startSR");
            this$0.g.b();
        }
    }
}
