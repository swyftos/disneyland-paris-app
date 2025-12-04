package com.contentsquare.android.sdk;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.q4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0785q4 implements J7 {

    @NotNull
    public final N4 a;

    public C0785q4(@NotNull N4 samplingMode) {
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        this.a = samplingMode;
    }

    @Override // com.contentsquare.android.sdk.J7
    @NotNull
    public final Pair<String, String> a() {
        String str;
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            str = "5";
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            str = "7";
        }
        return TuplesKt.to("rt", str);
    }
}
