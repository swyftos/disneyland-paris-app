package com.contentsquare.android.sdk;

import android.util.SparseArray;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class D7 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public SparseArray<B7> b;

    public D7(@NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.a = deviceInfo;
        this.b = new SparseArray<>();
    }

    public final void a(int i, long j, int i2, int i3) {
        B7 b7 = this.b.get(i);
        if (b7 == null) {
            b7 = new B7();
        }
        int iPixelsToDp = this.a.pixelsToDp(i2);
        int iPixelsToDp2 = this.a.pixelsToDp(i3);
        b7.a.add(Long.valueOf(j));
        b7.b.add(Integer.valueOf(iPixelsToDp));
        b7.c.add(Integer.valueOf(iPixelsToDp2));
        this.b.put(i, b7);
    }
}
