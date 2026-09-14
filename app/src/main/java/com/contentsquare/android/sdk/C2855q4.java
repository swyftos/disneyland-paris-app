package com.contentsquare.android.sdk;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2855q4 implements InterfaceC2534J7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final EnumC2571N4 f3031a;

    public C2855q4(@NotNull EnumC2571N4 samplingMode) {
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        this.f3031a = samplingMode;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2534J7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Pair<String, String> mo938a() {
        String str;
        int iOrdinal = this.f3031a.ordinal();
        if (iOrdinal == 0) {
            str = "5";
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            str = "7";
        }
        return TuplesKt.m1842to("rt", str);
    }
}
