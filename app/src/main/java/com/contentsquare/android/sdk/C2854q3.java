package com.contentsquare.android.sdk;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2854q3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2652V6 f3024a;

    /* JADX INFO: renamed from: b */
    public final long f3025b;

    /* JADX INFO: renamed from: c */
    public long f3026c;

    /* JADX INFO: renamed from: d */
    public long f3027d;

    /* JADX INFO: renamed from: e */
    public long f3028e;

    /* JADX INFO: renamed from: f */
    public long f3029f;

    /* JADX INFO: renamed from: g */
    public long f3030g;

    public C2854q3(@NotNull C2652V6 systemClockInstantiable) {
        Intrinsics.checkNotNullParameter(systemClockInstantiable, "systemClockInstantiable");
        this.f3024a = systemClockInstantiable;
        this.f3025b = SystemClock.elapsedRealtime();
    }
}
