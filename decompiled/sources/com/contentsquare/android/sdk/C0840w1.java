package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.w1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0840w1 implements J7 {

    @NotNull
    public final C0831v1 a;

    public C0840w1(@NotNull C0831v1 etrSessionEventTracker) {
        Intrinsics.checkNotNullParameter(etrSessionEventTracker, "etrSessionEventTracker");
        this.a = etrSessionEventTracker;
    }

    @Override // com.contentsquare.android.sdk.J7
    @NotNull
    public final Pair<String, String> a() {
        return TuplesKt.to("etrs", String.valueOf(this.a.a));
    }
}
