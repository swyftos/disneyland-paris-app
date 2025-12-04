package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.sdk.C0673f2;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.h0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0691h0 extends C0673f2 {

    /* renamed from: com.contentsquare.android.sdk.h0$a */
    public static final class a {
        @JvmStatic
        @NotNull
        public static C0691h0 a(@NotNull JSONObject gestureObject, @NotNull Y6 defaultPathDescriptor) {
            Y6 r8;
            Intrinsics.checkNotNullParameter(gestureObject, "gestureObject");
            Intrinsics.checkNotNullParameter(defaultPathDescriptor, "defaultPathDescriptor");
            C0691h0 c0691h0 = new C0691h0();
            c0691h0.b = gestureObject.optInt("type", -1);
            JSONObject jSONObjectOptJSONObject = gestureObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                String tvp = jSONObjectOptJSONObject.optString("path", "");
                Intrinsics.checkNotNullExpressionValue(tvp, "tvp");
                String path = defaultPathDescriptor.a();
                Intrinsics.checkNotNullParameter(path, "path");
                if (!StringsKt.contains$default((CharSequence) path, (CharSequence) ">FlutterView", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) path, (CharSequence) ">PlatformViewWrapper", false, 2, (Object) null)) {
                    if (C0673f2.a.a(path)) {
                        r8 = new R8(defaultPathDescriptor, tvp);
                    }
                    c0691h0.c = defaultPathDescriptor;
                    c0691h0.e = jSONObjectOptJSONObject.optDouble("distance", AudioStats.AUDIO_AMPLITUDE_NONE);
                    c0691h0.f = jSONObjectOptJSONObject.optDouble("velocity", AudioStats.AUDIO_AMPLITUDE_NONE);
                    c0691h0.d = jSONObjectOptJSONObject.optInt("direction", 0);
                } else {
                    r8 = new T1(defaultPathDescriptor, tvp);
                }
                defaultPathDescriptor = r8;
                c0691h0.c = defaultPathDescriptor;
                c0691h0.e = jSONObjectOptJSONObject.optDouble("distance", AudioStats.AUDIO_AMPLITUDE_NONE);
                c0691h0.f = jSONObjectOptJSONObject.optDouble("velocity", AudioStats.AUDIO_AMPLITUDE_NONE);
                c0691h0.d = jSONObjectOptJSONObject.optInt("direction", 0);
            }
            return c0691h0;
        }
    }
}
