package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2761h0 extends C2743f2 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h0$a */
    public static final class a {
        @JvmStatic
        @NotNull
        /* JADX INFO: renamed from: a */
        public static C2761h0 m1142a(@NotNull JSONObject gestureObject, @NotNull InterfaceC2679Y6 defaultPathDescriptor) {
            InterfaceC2679Y6 c2614r8;
            Intrinsics.checkNotNullParameter(gestureObject, "gestureObject");
            Intrinsics.checkNotNullParameter(defaultPathDescriptor, "defaultPathDescriptor");
            C2761h0 c2761h0 = new C2761h0();
            c2761h0.f2601b = gestureObject.optInt("type", -1);
            JSONObject jSONObjectOptJSONObject = gestureObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                String tvp = jSONObjectOptJSONObject.optString("path", "");
                Intrinsics.checkNotNullExpressionValue(tvp, "tvp");
                String path = defaultPathDescriptor.mo1022a();
                Intrinsics.checkNotNullParameter(path, "path");
                if (!StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null)) {
                    if (C2743f2.a.m1126a(path)) {
                        c2614r8 = new C2614R8(defaultPathDescriptor, tvp);
                    }
                    c2761h0.f2602c = defaultPathDescriptor;
                    c2761h0.f2604e = jSONObjectOptJSONObject.optDouble("distance", AudioStats.AUDIO_AMPLITUDE_NONE);
                    c2761h0.f2605f = jSONObjectOptJSONObject.optDouble("velocity", AudioStats.AUDIO_AMPLITUDE_NONE);
                    c2761h0.f2603d = jSONObjectOptJSONObject.optInt("direction", 0);
                } else {
                    c2614r8 = new C2627T1(defaultPathDescriptor, tvp);
                }
                defaultPathDescriptor = c2614r8;
                c2761h0.f2602c = defaultPathDescriptor;
                c2761h0.f2604e = jSONObjectOptJSONObject.optDouble("distance", AudioStats.AUDIO_AMPLITUDE_NONE);
                c2761h0.f2605f = jSONObjectOptJSONObject.optDouble("velocity", AudioStats.AUDIO_AMPLITUDE_NONE);
                c2761h0.f2603d = jSONObjectOptJSONObject.optInt("direction", 0);
            }
            return c2761h0;
        }
    }
}
