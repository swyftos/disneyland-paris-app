package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2862r1 implements InterfaceC2534J7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2852q1 f3057a;

    public C2862r1(@NotNull C2852q1 etrScreenEventTracker) {
        Intrinsics.checkNotNullParameter(etrScreenEventTracker, "etrScreenEventTracker");
        this.f3057a = etrScreenEventTracker;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2534J7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Pair<String, String> mo938a() {
        return TuplesKt.m1842to("etrp", String.valueOf(this.f3057a.f3022a));
    }
}
