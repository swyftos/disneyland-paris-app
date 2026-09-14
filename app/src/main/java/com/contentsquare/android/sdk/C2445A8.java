package com.contentsquare.android.sdk;

import android.app.Activity;
import android.os.Handler;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2445A8 {

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final Map<Integer, String> f1417l = MapsKt.mapOf(TuplesKt.m1842to(25, "Custom error"), TuplesKt.m1842to(26, "Javascript error"), TuplesKt.m1842to(21, "API error"));

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Handler f1418a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final AbstractC2690a f1419b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2733e2 f1420c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2780j f1421d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2478E1 f1422e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2922x1 f1423f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final ScreenViewTracker f1424g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Logger f1425h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final WeakReference<Activity> f1426i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final WeakReference<WebView> f1427j;

    /* JADX INFO: renamed from: k */
    public boolean f1428k;

    public C2445A8(Activity activity, Handler handler, WebView webView, C2756g5 screenChangedCallback, C2733e2 gestureProcessor, C2780j analyticsPipeline, C2478E1 eventsBuildersFactory, C2922x1 eventLimiter, ScreenViewTracker screenViewTracker) {
        Logger logger = new Logger("WebViewAnalyticsEventProcessor");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(screenChangedCallback, "screenChangedCallback");
        Intrinsics.checkNotNullParameter(gestureProcessor, "gestureProcessor");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(eventLimiter, "eventLimiter");
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1418a = handler;
        this.f1419b = screenChangedCallback;
        this.f1420c = gestureProcessor;
        this.f1421d = analyticsPipeline;
        this.f1422e = eventsBuildersFactory;
        this.f1423f = eventLimiter;
        this.f1424g = screenViewTracker;
        this.f1425h = logger;
        this.f1426i = new WeakReference<>(activity);
        this.f1427j = new WeakReference<>(webView);
        this.f1428k = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m871a(int i) {
        String str = f1417l.get(Integer.valueOf(i));
        this.f1425h.m831i("Limit of 20 " + str + "s per screenview has been reached for the current screenview. " + str + " collection is paused until next screenview");
    }

    /* JADX INFO: renamed from: b */
    public final void m874b(int i) {
        if (this.f1424g.isSentBeforeFirstScreen()) {
            String str = f1417l.get(Integer.valueOf(i));
            this.f1425h.m831i("No screenview detected. " + str + " is linked to screenviews. Please implement screenview tracking to enable it.");
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public final void m876c(@NotNull final JSONObject dataJsonObject) {
        Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
        this.f1418a.post(new Runnable() { // from class: com.contentsquare.android.sdk.A8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2445A8.m869a(this.f$0, dataJsonObject);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public final void m870a() {
        final WebView webView = this.f1427j.get();
        if (!this.f1428k || webView == null) {
            return;
        }
        this.f1428k = false;
        this.f1418a.post(new Runnable() { // from class: com.contentsquare.android.sdk.A8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2445A8.m868a(this.f$0, webView);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public final boolean m875b(@NotNull JSONObject dataJsonObject) {
        Intrinsics.checkNotNullParameter(dataJsonObject, "json");
        boolean zM1230a = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_API_ERRORS);
        if (zM1230a) {
            C2478E1 eventsBuildersFactory = this.f1422e;
            Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
            Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
            C2864r3.a aVar = (C2864r3.a) C2478E1.m901a(eventsBuildersFactory, 21);
            aVar.f3067k = ExtensionsKt.getStringOrNull(dataJsonObject, "url");
            Integer intOrNull = ExtensionsKt.getIntOrNull(dataJsonObject, "statusCode");
            aVar.f3071o = intOrNull != null ? intOrNull.intValue() : 0;
            Long longOrNull = ExtensionsKt.getLongOrNull(dataJsonObject, "responseTime");
            aVar.f3070n = longOrNull != null ? longOrNull.longValue() : 0L;
            Long longOrNull2 = ExtensionsKt.getLongOrNull(dataJsonObject, "requestTime");
            aVar.f3069m = longOrNull2 != null ? longOrNull2.longValue() : 0L;
            aVar.f3068l = ExtensionsKt.getStringOrNull(dataJsonObject, TCEventPropertiesNames.TCE_METHOD);
            aVar.f3072p = "webview";
            this.f1421d.m1159a(aVar);
        }
        return zM1230a;
    }

    /* JADX INFO: renamed from: a */
    public static final void m868a(C2445A8 this$0, WebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1425h.m833p("WebView Tracking Tag is detected on page: " + webView.getUrl());
    }

    /* JADX INFO: renamed from: a */
    public final void m872a(@Nullable String str, @Nullable String str2, @NotNull String level) {
        Intrinsics.checkNotNullParameter(level, "level");
        try {
            String upperCase = level.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            int iM1238a = C2939y8.m1238a(upperCase);
            if (iM1238a == 3 || iM1238a == 4) {
                this.f1425h.m831i("[WebView JS log] (" + str2 + ") " + str);
            }
        } catch (IllegalArgumentException e) {
            C2599Q2.m1011a(this.f1425h, "Error while parsing the log level: " + level, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c9 A[Catch: JSONException -> 0x004b, TryCatch #0 {JSONException -> 0x004b, blocks: (B:3:0x0008, B:7:0x003f, B:28:0x00c9, B:30:0x00da, B:32:0x00ee, B:33:0x00f2, B:12:0x0052, B:14:0x006b, B:17:0x007d, B:19:0x0096, B:22:0x00a8, B:24:0x00b6, B:34:0x00fb), top: B:38:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00da A[Catch: JSONException -> 0x004b, TryCatch #0 {JSONException -> 0x004b, blocks: (B:3:0x0008, B:7:0x003f, B:28:0x00c9, B:30:0x00da, B:32:0x00ee, B:33:0x00f2, B:12:0x0052, B:14:0x006b, B:17:0x007d, B:19:0x0096, B:22:0x00a8, B:24:0x00b6, B:34:0x00fb), top: B:38:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ee A[Catch: JSONException -> 0x004b, TryCatch #0 {JSONException -> 0x004b, blocks: (B:3:0x0008, B:7:0x003f, B:28:0x00c9, B:30:0x00da, B:32:0x00ee, B:33:0x00f2, B:12:0x0052, B:14:0x006b, B:17:0x007d, B:19:0x0096, B:22:0x00a8, B:24:0x00b6, B:34:0x00fb), top: B:38:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    public final void m873a(@NotNull JSONObject json) {
        boolean zM875b;
        C2922x1 c2922x1;
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            int i = json.getInt("type");
            this.f1425h.m834w("type: " + i);
            m870a();
            WebView webView = this.f1427j.get();
            m874b(i);
            if (this.f1423f.m1231a(i)) {
                m871a(i);
                return;
            }
            if (i != 4) {
                if (i == 26) {
                    JSONObject json2 = json.getJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(json2, "dataObject");
                    Intrinsics.checkNotNullParameter(json2, "json");
                    zM875b = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_JS_ERRORS);
                    if (zM875b) {
                        this.f1421d.m1159a(C2495F8.m919b(this.f1422e, json2, this.f1424g));
                    }
                } else if (i == 25) {
                    JSONObject json3 = json.getJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(json3, "dataObject");
                    Intrinsics.checkNotNullParameter(json3, "json");
                    zM875b = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_CUSTOM_ERRORS);
                    if (zM875b) {
                        this.f1421d.m1159a(C2495F8.m918a(this.f1422e, json3, this.f1424g));
                    }
                } else if (i == 21) {
                    JSONObject dataObject = json.getJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(dataObject, "dataObject");
                    zM875b = m875b(dataObject);
                } else if (webView != null) {
                    this.f1420c.m1120b(C2761h0.a.m1142a(json, new C2784j3(webView)));
                } else {
                    zM875b = false;
                }
                if (zM875b) {
                    c2922x1 = this.f1423f;
                    c2922x1.getClass();
                    if (C2922x1.f3222c.contains(Integer.valueOf(i))) {
                        LinkedHashMap linkedHashMap = c2922x1.f3224b;
                        Integer numValueOf = Integer.valueOf(i);
                        Integer num = (Integer) c2922x1.f3224b.get(Integer.valueOf(i));
                        linkedHashMap.put(numValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                    }
                }
            }
            JSONObject dataObject2 = json.getJSONObject("data");
            Intrinsics.checkNotNullExpressionValue(dataObject2, "dataObject");
            m876c(dataObject2);
            zM875b = true;
            if (zM875b) {
                c2922x1 = this.f1423f;
                c2922x1.getClass();
                if (C2922x1.f3222c.contains(Integer.valueOf(i))) {
                    LinkedHashMap linkedHashMap2 = c2922x1.f3224b;
                    Integer numValueOf2 = Integer.valueOf(i);
                    Integer num2 = (Integer) c2922x1.f3224b.get(Integer.valueOf(i));
                    linkedHashMap2.put(numValueOf2, Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1));
                }
            }
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1425h, "Error while parsing " + json, e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m869a(C2445A8 this$0, JSONObject dataJsonObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataJsonObject, "$dataJsonObject");
        Activity activity = this$0.f1426i.get();
        if (activity != null) {
            this$0.f1425h.m834w("WebView PAGE_VIEW triggered");
            try {
                String url = dataJsonObject.getString("url");
                AbstractC2690a abstractC2690a = this$0.f1419b;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                abstractC2690a.m1079a(activity, url);
            } catch (JSONException e) {
                C2599Q2.m1011a(this$0.f1425h, "Error while parsing " + dataJsonObject, e);
            }
        }
    }
}
