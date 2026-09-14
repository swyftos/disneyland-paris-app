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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nScreenCaptureConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenCaptureConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCaptureConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1855#2,2:42\n1855#2,2:44\n*S KotlinDebug\n*F\n+ 1 ScreenCaptureConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCaptureConverter\n*L\n25#1:42,2\n39#1:44,2\n*E\n"})
public final class C2610R4 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f2067a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final List<String> f2068b;

    public C2610R4(@NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f2067a = deviceInfo;
        this.f2068b = CollectionsKt.listOf((Object[]) new String[]{"x", "y", "width", "height"});
    }

    /* JADX INFO: renamed from: a */
    public final void m1021a(C2499G2 c2499g2) throws JSONException {
        JSONObject jSONObject = c2499g2.f1642f;
        for (String str : this.f2068b) {
            if (jSONObject.has(str)) {
                jSONObject.put(str, this.f2067a.pixelsToDp(jSONObject.getInt(str)));
            }
        }
        List<C2499G2> list = c2499g2.f1639c;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                m1021a((C2499G2) it.next());
            }
        }
    }
}
