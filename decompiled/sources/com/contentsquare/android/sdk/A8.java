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
import com.contentsquare.android.sdk.C0793r3;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class A8 {

    @NotNull
    public static final Map<Integer, String> l = MapsKt.mapOf(TuplesKt.to(25, "Custom error"), TuplesKt.to(26, "Javascript error"), TuplesKt.to(21, "API error"));

    @NotNull
    public final Handler a;

    @NotNull
    public final AbstractC0620a b;

    @NotNull
    public final C0663e2 c;

    @NotNull
    public final C0710j d;

    @NotNull
    public final E1 e;

    @NotNull
    public final C0849x1 f;

    @NotNull
    public final ScreenViewTracker g;

    @NotNull
    public final Logger h;

    @NotNull
    public final WeakReference<Activity> i;

    @NotNull
    public final WeakReference<WebView> j;
    public boolean k;

    public A8(Activity activity, Handler handler, WebView webView, C0686g5 screenChangedCallback, C0663e2 gestureProcessor, C0710j analyticsPipeline, E1 eventsBuildersFactory, C0849x1 eventLimiter, ScreenViewTracker screenViewTracker) {
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
        this.a = handler;
        this.b = screenChangedCallback;
        this.c = gestureProcessor;
        this.d = analyticsPipeline;
        this.e = eventsBuildersFactory;
        this.f = eventLimiter;
        this.g = screenViewTracker;
        this.h = logger;
        this.i = new WeakReference<>(activity);
        this.j = new WeakReference<>(webView);
        this.k = true;
    }

    public final void a(int i) {
        String str = l.get(Integer.valueOf(i));
        this.h.i("Limit of 20 " + str + "s per screenview has been reached for the current screenview. " + str + " collection is paused until next screenview");
    }

    public final void b(int i) {
        if (this.g.isSentBeforeFirstScreen()) {
            String str = l.get(Integer.valueOf(i));
            this.h.i("No screenview detected. " + str + " is linked to screenviews. Please implement screenview tracking to enable it.");
        }
    }

    @VisibleForTesting
    public final void c(@NotNull final JSONObject dataJsonObject) {
        Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
        this.a.post(new Runnable() { // from class: com.contentsquare.android.sdk.A8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                A8.a(this.f$0, dataJsonObject);
            }
        });
    }

    public final void a() {
        final WebView webView = this.j.get();
        if (!this.k || webView == null) {
            return;
        }
        this.k = false;
        this.a.post(new Runnable() { // from class: com.contentsquare.android.sdk.A8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A8.a(this.f$0, webView);
            }
        });
    }

    public final boolean b(@NotNull JSONObject dataJsonObject) {
        Intrinsics.checkNotNullParameter(dataJsonObject, "json");
        boolean zA = C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_API_ERRORS);
        if (zA) {
            E1 eventsBuildersFactory = this.e;
            Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
            Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
            C0793r3.a aVar = (C0793r3.a) E1.a(eventsBuildersFactory, 21);
            aVar.k = ExtensionsKt.getStringOrNull(dataJsonObject, "url");
            Integer intOrNull = ExtensionsKt.getIntOrNull(dataJsonObject, "statusCode");
            aVar.o = intOrNull != null ? intOrNull.intValue() : 0;
            Long longOrNull = ExtensionsKt.getLongOrNull(dataJsonObject, "responseTime");
            aVar.n = longOrNull != null ? longOrNull.longValue() : 0L;
            Long longOrNull2 = ExtensionsKt.getLongOrNull(dataJsonObject, "requestTime");
            aVar.m = longOrNull2 != null ? longOrNull2.longValue() : 0L;
            aVar.l = ExtensionsKt.getStringOrNull(dataJsonObject, "method");
            aVar.p = "webview";
            this.d.a(aVar);
        }
        return zA;
    }

    public static final void a(A8 this$0, WebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h.p("WebView Tracking Tag is detected on page: " + webView.getUrl());
    }

    public final void a(@Nullable String str, @Nullable String str2, @NotNull String level) {
        Intrinsics.checkNotNullParameter(level, "level");
        try {
            String upperCase = level.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            int iA = y8.a(upperCase);
            if (iA == 3 || iA == 4) {
                this.h.i("[WebView JS log] (" + str2 + ") " + str);
            }
        } catch (IllegalArgumentException e) {
            Q2.a(this.h, "Error while parsing the log level: " + level, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7 A[Catch: JSONException -> 0x0049, TryCatch #0 {JSONException -> 0x0049, blocks: (B:3:0x0007, B:7:0x003d, B:28:0x00c7, B:30:0x00d8, B:32:0x00ec, B:33:0x00f0, B:12:0x0050, B:14:0x0069, B:17:0x007b, B:19:0x0094, B:22:0x00a6, B:24:0x00b4, B:34:0x00f9), top: B:38:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.NotNull org.json.JSONObject r9) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.A8.a(org.json.JSONObject):void");
    }

    public static final void a(A8 this$0, JSONObject dataJsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataJsonObject, "$dataJsonObject");
        Activity activity = this$0.i.get();
        if (activity != null) {
            this$0.h.w("WebView PAGE_VIEW triggered");
            try {
                String url = dataJsonObject.getString("url");
                AbstractC0620a abstractC0620a = this$0.b;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                abstractC0620a.a(activity, url);
            } catch (JSONException e) {
                Q2.a(this$0.h, "Error while parsing " + dataJsonObject, e);
            }
        }
    }
}
