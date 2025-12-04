package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.r1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0791r1 implements J7 {

    @NotNull
    public final C0782q1 a;

    public C0791r1(@NotNull C0782q1 etrScreenEventTracker) {
        Intrinsics.checkNotNullParameter(etrScreenEventTracker, "etrScreenEventTracker");
        this.a = etrScreenEventTracker;
    }

    @Override // com.contentsquare.android.sdk.J7
    @NotNull
    public final Pair<String, String> a() {
        return TuplesKt.to("etrp", String.valueOf(this.a.a));
    }
}
