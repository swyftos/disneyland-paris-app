package com.contentsquare.android.sdk;

import android.util.SparseArray;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2474D7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f1526a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public SparseArray<C2454B7> f1527b;

    public C2474D7(@NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f1526a = deviceInfo;
        this.f1527b = new SparseArray<>();
    }

    /* JADX INFO: renamed from: a */
    public final void m899a(int i, long j, int i2, int i3) {
        C2454B7 c2454b7 = this.f1527b.get(i);
        if (c2454b7 == null) {
            c2454b7 = new C2454B7();
        }
        int iPixelsToDp = this.f1526a.pixelsToDp(i2);
        int iPixelsToDp2 = this.f1526a.pixelsToDp(i3);
        c2454b7.f1449a.add(Long.valueOf(j));
        c2454b7.f1450b.add(Integer.valueOf(iPixelsToDp));
        c2454b7.f1451c.add(Integer.valueOf(iPixelsToDp2));
        this.f1527b.put(i, c2454b7);
    }
}
