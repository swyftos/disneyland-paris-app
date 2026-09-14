package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2519I2 implements InterfaceC2534J7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2529J2 f1704a;

    public C2519I2(@NotNull C2529J2 lastEventTimeTracker) {
        Intrinsics.checkNotNullParameter(lastEventTimeTracker, "lastEventTimeTracker");
        this.f1704a = lastEventTimeTracker;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2534J7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Pair<String, String> mo938a() {
        return TuplesKt.m1842to("let", String.valueOf(this.f1704a.f1741a));
    }
}
