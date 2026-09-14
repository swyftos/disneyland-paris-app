package com.contentsquare.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.webviewbridge.assets.C2431a;
import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.M0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCsJavaScriptInterface.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CsJavaScriptInterface.kt\ncom/contentsquare/android/internal/features/webviewbridge/CsJavaScriptInterface\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,322:1\n96#2:323\n*S KotlinDebug\n*F\n+ 1 CsJavaScriptInterface.kt\ncom/contentsquare/android/internal/features/webviewbridge/CsJavaScriptInterface\n*L\n205#1:323\n*E\n"})
public final class C2557M0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final WebView f1842a;

    /* JADX INFO: renamed from: b */
    public final long f1843b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final InterfaceC2505G8 f1844c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Function0<C2431a> f1845d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Function0<EnumC2465C8> f1846e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Function0<PreferencesStore> f1847f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2545K8 f1848g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Handler f1849h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final Logger f1850i;

    /* JADX INFO: renamed from: j */
    public final Context f1851j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C2445A8 f1852k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C2575N8 f1853l;

    public C2557M0() {
        throw null;
    }

    public C2557M0(WebView webView, long j, C2515H8 webViewEventProcessorsFactory, C2624S8.a webViewAssetsProcessor, C2624S8.b transformerModeFactory, Function0 preferencesStore, C2545K8 webViewJsExecutor, Handler mainThreadHandler) {
        Logger logger = new Logger("CsJavaScriptInterface");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(webViewEventProcessorsFactory, "webViewEventProcessorsFactory");
        Intrinsics.checkNotNullParameter(webViewAssetsProcessor, "webViewAssetsProcessor");
        Intrinsics.checkNotNullParameter(transformerModeFactory, "transformerModeFactory");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(webViewJsExecutor, "webViewJsExecutor");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1842a = webView;
        this.f1843b = j;
        this.f1844c = webViewEventProcessorsFactory;
        this.f1845d = webViewAssetsProcessor;
        this.f1846e = transformerModeFactory;
        this.f1847f = preferencesStore;
        this.f1848g = webViewJsExecutor;
        this.f1849h = mainThreadHandler;
        this.f1850i = logger;
        this.f1851j = webView.getContext().getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m984a() {
        PreferencesStore preferencesStoreInvoke = this.f1847f.invoke();
        boolean z = preferencesStoreInvoke != null ? preferencesStoreInvoke.getBoolean(PreferencesKey.IS_OPT_OUT, false) : false;
        PreferencesStore preferencesStoreInvoke2 = this.f1847f.invoke();
        boolean z2 = preferencesStoreInvoke2 != null ? preferencesStoreInvoke2.getBoolean(PreferencesKey.TRACKING_ENABLE, false) : false;
        PreferencesStore preferencesStoreInvoke3 = this.f1847f.invoke();
        boolean z3 = preferencesStoreInvoke3 != null ? preferencesStoreInvoke3.getBoolean(PreferencesKey.FORGET_ME, false) : false;
        PreferencesStore preferencesStoreInvoke4 = this.f1847f.invoke();
        return (z || !z2 || z3 || (preferencesStoreInvoke4 != null ? preferencesStoreInvoke4.getBoolean(PreferencesKey.PAUSE_TRACKING, false) : false)) ? false : true;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final C2445A8 m985b() {
        Activity activity;
        C2445A8 c2445a8 = this.f1852k;
        if (c2445a8 != null) {
            return c2445a8;
        }
        Object tag = this.f1842a.getTag(C2362R.string.contentsquare_react_native_web_view_activity_tag);
        if (tag instanceof Activity) {
            activity = (Activity) tag;
        } else if (this.f1842a.getContext() instanceof Activity) {
            tag = this.f1842a.getContext();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type android.app.Activity");
            activity = (Activity) tag;
        } else {
            activity = null;
        }
        if (activity == null) {
            return null;
        }
        C2445A8 c2445a8Mo927a = this.f1844c.mo927a(this.f1842a, activity);
        this.f1852k = c2445a8Mo927a;
        return c2445a8Mo927a;
    }

    @JavascriptInterface
    @NotNull
    public final String getAssetTransformerMode() {
        return this.f1846e.invoke().name();
    }

    @JavascriptInterface
    public final int getVersion() {
        return 2;
    }

    @JavascriptInterface
    public final void onWebviewTrackingReady() {
        this.f1850i.m827d("onWebViewTrackingReady");
        if (m984a()) {
            this.f1849h.post(new Runnable() { // from class: com.contentsquare.android.sdk.M0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2557M0.m983a(this.f$0);
                }
            });
        }
    }

    @JavascriptInterface
    public final void optIn() {
        this.f1850i.m827d("optIn triggered");
        Contentsquare.optIn(this.f1851j);
    }

    @JavascriptInterface
    public final void optOut() {
        this.f1850i.m827d("optOut triggered");
        Contentsquare.optOut(this.f1851j);
    }

    @JavascriptInterface
    public final void sendAssets(@NotNull String jsonAssets, @Nullable String str) {
        Intrinsics.checkNotNullParameter(jsonAssets, "jsonAssets");
        try {
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            List<WebViewAsset> list = (List) companion.decodeFromString(new ArrayListSerializer(WebViewAsset.Companion.serializer()), jsonAssets);
            PreferencesStore preferencesStoreInvoke = this.f1847f.invoke();
            if (preferencesStoreInvoke != null) {
                boolean z = preferencesStoreInvoke.getBoolean(PreferencesKey.IS_OPT_OUT, false);
                C2431a c2431aInvoke = this.f1845d.invoke();
                if (c2431aInvoke != null) {
                    c2431aInvoke.m851a(list, str, z);
                }
            }
        } catch (SerializationException e) {
            C2599Q2.m1011a(this.f1850i, "Json Error while parsing " + jsonAssets, e);
        }
    }

    @JavascriptInterface
    public final void sendDynamicVar(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            long j = Long.parseLong(value);
            this.f1850i.m827d("Receiving Dvar, with key = " + key + ", value(int) = " + j);
            Contentsquare.send(key, j);
        } catch (NumberFormatException unused) {
            this.f1850i.m827d("Receiving Dvar, with key = " + key + ", value(String) = " + value);
            Contentsquare.send(key, value);
        }
    }

    @JavascriptInterface
    public final void sendEvent(@NotNull String obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f1850i.m827d("sendEvent triggered: " + obj);
        try {
            JSONObject jSONObject = new JSONObject(obj);
            C2445A8 c2445a8M985b = m985b();
            if (c2445a8M985b != null) {
                c2445a8M985b.m873a(jSONObject);
            }
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1850i, "Error while parsing " + obj, e);
        }
    }

    @JavascriptInterface
    public final void sendLog(@NotNull String obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.f1850i.m827d("sendLog triggered: " + obj);
        try {
            JSONObject jSONObject = new JSONObject(obj);
            String string = jSONObject.getString("message");
            String string2 = jSONObject.getString("errorCode");
            String level = jSONObject.getString("level");
            C2445A8 c2445a8M985b = m985b();
            if (c2445a8M985b != null) {
                Intrinsics.checkNotNullExpressionValue(level, "level");
                c2445a8M985b.m872a(string, string2, level);
            }
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1850i, "Error while parsing " + obj, e);
        }
    }

    @JavascriptInterface
    public final void sendNativeSREvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.f1850i.m827d("sendNativeSREvent triggered: " + event);
            JSONObject jSONObject = new JSONObject(event);
            C2575N8 c2575n8Mo928a = this.f1853l;
            if (c2575n8Mo928a == null) {
                c2575n8Mo928a = this.f1844c.mo928a();
                this.f1853l = c2575n8Mo928a;
            }
            if (c2575n8Mo928a != null) {
                c2575n8Mo928a.m994a(jSONObject);
            }
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1850i, "Json Error while parsing " + event, e);
        }
    }

    @JavascriptInterface
    public final void sendSREvent(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1850i.m827d("sendSrEvent triggered: " + event);
        C2462C5 c2462c5 = C2462C5.f1468k;
        if (c2462c5 != null) {
            C2585O8 event2 = new C2585O8(event, this.f1843b);
            Intrinsics.checkNotNullParameter(event2, "event");
            c2462c5.f1476d.m945a(event2);
        }
    }

    @JavascriptInterface
    public final void sendTransaction(@Nullable String str, float f, @NotNull String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.f1850i.m827d("Receiving transaction, with id = " + str + ", value(float) = " + f + ", currency = " + currency);
        Transaction.TransactionBuilder transactionBuilderBuilder = Transaction.INSTANCE.builder(f, currency);
        if (str != null) {
            transactionBuilderBuilder.m794id(str);
        }
        Contentsquare.send(transactionBuilderBuilder.build());
    }

    /* JADX INFO: renamed from: a */
    public static final void m983a(C2557M0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1848g.m969a();
        if (C2462C5.f1468k != null) {
            this$0.f1850i.m827d("onWebViewTrackingReady => startSR");
            this$0.f1848g.m973b();
        }
    }
}
