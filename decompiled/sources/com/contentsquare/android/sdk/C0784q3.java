package com.contentsquare.android.sdk;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.q3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0784q3 {

    @NotNull
    public final V6 a;
    public final long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;

    public C0784q3(@NotNull V6 systemClockInstantiable) {
        Intrinsics.checkNotNullParameter(systemClockInstantiable, "systemClockInstantiable");
        this.a = systemClockInstantiable;
        this.b = SystemClock.elapsedRealtime();
    }
}
