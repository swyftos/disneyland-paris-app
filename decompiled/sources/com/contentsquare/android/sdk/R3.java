package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class R3 {

    @NotNull
    public final V6 a;

    @NotNull
    public final long[] b;
    public int c;
    public long d;
    public boolean e;

    public R3(@NotNull V6 systemClock) {
        Intrinsics.checkNotNullParameter(systemClock, "systemClock");
        this.a = systemClock;
        this.b = new long[10];
    }
}
