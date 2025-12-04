package com.contentsquare.android.sdk;

import com.contentsquare.android.core.system.DeviceInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nScreenCaptureConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenCaptureConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCaptureConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1855#2,2:42\n1855#2,2:44\n*S KotlinDebug\n*F\n+ 1 ScreenCaptureConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCaptureConverter\n*L\n25#1:42,2\n39#1:44,2\n*E\n"})
/* loaded from: classes2.dex */
public final class R4 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final List<String> b;

    public R4(@NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.a = deviceInfo;
        this.b = CollectionsKt.listOf((Object[]) new String[]{"x", "y", "width", "height"});
    }

    public final void a(G2 g2) throws JSONException {
        JSONObject jSONObject = g2.f;
        for (String str : this.b) {
            if (jSONObject.has(str)) {
                jSONObject.put(str, this.a.pixelsToDp(jSONObject.getInt(str)));
            }
        }
        List<G2> list = g2.c;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a((G2) it.next());
            }
        }
    }
}
