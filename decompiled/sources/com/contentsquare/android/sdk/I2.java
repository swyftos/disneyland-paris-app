package com.contentsquare.android.sdk;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class I2 implements J7 {

    @NotNull
    public final J2 a;

    public I2(@NotNull J2 lastEventTimeTracker) {
        Intrinsics.checkNotNullParameter(lastEventTimeTracker, "lastEventTimeTracker");
        this.a = lastEventTimeTracker;
    }

    @Override // com.contentsquare.android.sdk.J7
    @NotNull
    public final Pair<String, String> a() {
        return TuplesKt.to("let", String.valueOf(this.a.a));
    }
}
