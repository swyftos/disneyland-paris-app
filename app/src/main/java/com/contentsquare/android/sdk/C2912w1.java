package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.w1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2912w1 implements InterfaceC2534J7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2902v1 f3200a;

    public C2912w1(@NotNull C2902v1 etrSessionEventTracker) {
        Intrinsics.checkNotNullParameter(etrSessionEventTracker, "etrSessionEventTracker");
        this.f3200a = etrSessionEventTracker;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2534J7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Pair<String, String> mo938a() {
        return TuplesKt.m1842to("etrs", String.valueOf(this.f3200a.f3167a));
    }
}
