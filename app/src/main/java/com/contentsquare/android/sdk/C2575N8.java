package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nWebViewSessionReplayEventProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewSessionReplayEventProcessor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/webview/WebViewSessionReplayEventProcessor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class C2575N8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2478E1 f1901a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Function0<ErrorAnalysisInterface> f1902b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Function0<C2462C5> f1903c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2922x1 f1904d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final ScreenViewTracker f1905e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Logger f1906f;

    /* JADX WARN: Multi-variable type inference failed */
    public C2575N8(@NotNull C2478E1 eventsBuildersFactory, @NotNull Function0<? extends ErrorAnalysisInterface> errorAnalysisModuleProvider, @NotNull Function0<C2462C5> sessionReplayProvider, @NotNull C2922x1 eventLimiter, @NotNull ScreenViewTracker screenViewTracker) {
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(errorAnalysisModuleProvider, "errorAnalysisModuleProvider");
        Intrinsics.checkNotNullParameter(sessionReplayProvider, "sessionReplayProvider");
        Intrinsics.checkNotNullParameter(eventLimiter, "eventLimiter");
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        this.f1901a = eventsBuildersFactory;
        this.f1902b = errorAnalysisModuleProvider;
        this.f1903c = sessionReplayProvider;
        this.f1904d = eventLimiter;
        this.f1905e = screenViewTracker;
        this.f1906f = new Logger("WebViewSessionReplayEventProcessor");
    }

    /* JADX INFO: renamed from: a */
    public final void m994a(@NotNull JSONObject json) throws JSONException {
        boolean zM1230a;
        Intrinsics.checkNotNullParameter(json, "json");
        int i = json.getInt("type");
        if (this.f1904d.m1231a(i)) {
            return;
        }
        if (i == SessionRecordingV1.Event.EventCase.JS_ERROR.getNumber()) {
            zM1230a = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_JS_ERRORS);
            if (zM1230a) {
                JSONObject dataObject = json.getJSONObject("data");
                C2478E1 c2478e1 = this.f1901a;
                Intrinsics.checkNotNullExpressionValue(dataObject, "dataObject");
                C2439A2 c2439a2 = new C2439A2(C2495F8.m919b(c2478e1, dataObject, this.f1905e));
                C2462C5 c2462c5Invoke = this.f1903c.invoke();
                if (c2462c5Invoke != null) {
                    C2459C2 event = new C2459C2(c2439a2);
                    Intrinsics.checkNotNullParameter(event, "event");
                    c2462c5Invoke.f1474b.m877a(event);
                }
            }
        } else if (i == SessionRecordingV1.Event.EventCase.CUSTOM_ERROR.getNumber()) {
            zM1230a = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_CUSTOM_ERRORS);
            if (zM1230a) {
                JSONObject dataObject2 = json.getJSONObject("data");
                C2478E1 c2478e2 = this.f1901a;
                Intrinsics.checkNotNullExpressionValue(dataObject2, "dataObject");
                C2626T0 c2626t0 = new C2626T0(C2495F8.m918a(c2478e2, dataObject2, this.f1905e));
                C2462C5 c2462c5Invoke2 = this.f1903c.invoke();
                if (c2462c5Invoke2 != null) {
                    C2646V0 event2 = new C2646V0(c2626t0);
                    Intrinsics.checkNotNullParameter(event2, "event");
                    c2462c5Invoke2.f1475c.m1041a(event2);
                }
            }
        } else if (i == SessionRecordingV1.Event.EventCase.NETWORK_REQUEST_METRIC.getNumber()) {
            boolean zM1230a2 = C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_API_ERRORS);
            JSONObject dataObject3 = json.getJSONObject("data");
            Intrinsics.checkNotNullExpressionValue(dataObject3, "dataObject");
            NetworkEvent networkEventM917a = C2495F8.m917a(dataObject3);
            ErrorAnalysisInterface errorAnalysisInterfaceInvoke = this.f1902b.invoke();
            if (errorAnalysisInterfaceInvoke == null || !zM1230a2) {
                this.f1906f.m829e("Unable to send API Error - Error Analysis Module is not available");
                zM1230a = false;
            } else {
                if (networkEventM917a != null) {
                    errorAnalysisInterfaceInvoke.sendNetworkEvent(networkEventM917a);
                }
                zM1230a = true;
            }
        } else {
            zM1230a = false;
        }
        if (zM1230a) {
            C2922x1 c2922x1 = this.f1904d;
            c2922x1.getClass();
            if (C2922x1.f3222c.contains(Integer.valueOf(i))) {
                LinkedHashMap linkedHashMap = c2922x1.f3224b;
                Integer numValueOf = Integer.valueOf(i);
                Integer num = (Integer) c2922x1.f3224b.get(Integer.valueOf(i));
                linkedHashMap.put(numValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        }
    }
}
