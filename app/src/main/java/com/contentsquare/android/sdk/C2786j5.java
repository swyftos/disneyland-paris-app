package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2786j5 extends Lambda implements Function1<C2499G2, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2781a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2786j5(int i) {
        super(1);
        this.f2781a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(C2499G2 c2499g2) {
        C2499G2 jsonView = c2499g2;
        Intrinsics.checkNotNullParameter(jsonView, "jsonView");
        return Boolean.valueOf(jsonView.f1642f.getInt("y") < this.f2781a);
    }
}
