package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nWebViewSessionReplayEventProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewSessionReplayEventProcessor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/webview/WebViewSessionReplayEventProcessor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
/* loaded from: classes2.dex */
public final class N8 {

    @NotNull
    public final E1 a;

    @NotNull
    public final Function0<ErrorAnalysisInterface> b;

    @NotNull
    public final Function0<C5> c;

    @NotNull
    public final C0849x1 d;

    @NotNull
    public final ScreenViewTracker e;

    @NotNull
    public final Logger f;

    /* JADX WARN: Multi-variable type inference failed */
    public N8(@NotNull E1 eventsBuildersFactory, @NotNull Function0<? extends ErrorAnalysisInterface> errorAnalysisModuleProvider, @NotNull Function0<C5> sessionReplayProvider, @NotNull C0849x1 eventLimiter, @NotNull ScreenViewTracker screenViewTracker) {
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(errorAnalysisModuleProvider, "errorAnalysisModuleProvider");
        Intrinsics.checkNotNullParameter(sessionReplayProvider, "sessionReplayProvider");
        Intrinsics.checkNotNullParameter(eventLimiter, "eventLimiter");
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        this.a = eventsBuildersFactory;
        this.b = errorAnalysisModuleProvider;
        this.c = sessionReplayProvider;
        this.d = eventLimiter;
        this.e = screenViewTracker;
        this.f = new Logger("WebViewSessionReplayEventProcessor");
    }

    public final void a(@NotNull JSONObject json) throws JSONException {
        boolean zA;
        Intrinsics.checkNotNullParameter(json, "json");
        int i = json.getInt("type");
        if (this.d.a(i)) {
            return;
        }
        if (i == SessionRecordingV1.Event.EventCase.JS_ERROR.getNumber()) {
            zA = C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_JS_ERRORS);
            if (zA) {
                JSONObject dataObject = json.getJSONObject("data");
                E1 e1 = this.a;
                Intrinsics.checkNotNullExpressionValue(dataObject, "dataObject");
                A2 a2 = new A2(F8.b(e1, dataObject, this.e));
                C5 c5Invoke = this.c.invoke();
                if (c5Invoke != null) {
                    C2 event = new C2(a2);
                    Intrinsics.checkNotNullParameter(event, "event");
                    c5Invoke.b.a(event);
                }
            }
        } else if (i == SessionRecordingV1.Event.EventCase.CUSTOM_ERROR.getNumber()) {
            zA = C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_CUSTOM_ERRORS);
            if (zA) {
                JSONObject dataObject2 = json.getJSONObject("data");
                E1 e12 = this.a;
                Intrinsics.checkNotNullExpressionValue(dataObject2, "dataObject");
                T0 t0 = new T0(F8.a(e12, dataObject2, this.e));
                C5 c5Invoke2 = this.c.invoke();
                if (c5Invoke2 != null) {
                    V0 event2 = new V0(t0);
                    Intrinsics.checkNotNullParameter(event2, "event");
                    c5Invoke2.c.a(event2);
                }
            }
        } else if (i == SessionRecordingV1.Event.EventCase.NETWORK_REQUEST_METRIC.getNumber()) {
            boolean zA2 = C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.WEBVIEW_API_ERRORS);
            JSONObject dataObject3 = json.getJSONObject("data");
            Intrinsics.checkNotNullExpressionValue(dataObject3, "dataObject");
            NetworkEvent networkEventA = F8.a(dataObject3);
            ErrorAnalysisInterface errorAnalysisInterfaceInvoke = this.b.invoke();
            if (errorAnalysisInterfaceInvoke == null || !zA2) {
                this.f.e("Unable to send API Error - Error Analysis Module is not available");
                zA = false;
            } else {
                if (networkEventA != null) {
                    errorAnalysisInterfaceInvoke.sendNetworkEvent(networkEventA);
                }
                zA = true;
            }
        } else {
            zA = false;
        }
        if (zA) {
            C0849x1 c0849x1 = this.d;
            c0849x1.getClass();
            if (C0849x1.c.contains(Integer.valueOf(i))) {
                LinkedHashMap linkedHashMap = c0849x1.b;
                Integer numValueOf = Integer.valueOf(i);
                Integer num = (Integer) c0849x1.b.get(Integer.valueOf(i));
                linkedHashMap.put(numValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        }
    }
}
