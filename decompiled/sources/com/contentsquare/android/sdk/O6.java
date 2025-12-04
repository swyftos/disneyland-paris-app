package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class O6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ N6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O6(N6 n6) {
        super(0);
        this.a = n6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC0642c1 dialogFragmentC0642c1 = this.a.c;
        if (dialogFragmentC0642c1 != null) {
            dialogFragmentC0642c1.dismiss();
        }
        return Unit.INSTANCE;
    }
}
