package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2609R3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2652V6 f2062a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final long[] f2063b;

    /* JADX INFO: renamed from: c */
    public int f2064c;

    /* JADX INFO: renamed from: d */
    public long f2065d;

    /* JADX INFO: renamed from: e */
    public boolean f2066e;

    public C2609R3(@NotNull C2652V6 systemClock) {
        Intrinsics.checkNotNullParameter(systemClock, "systemClock");
        this.f2062a = systemClock;
        this.f2063b = new long[10];
    }
}
