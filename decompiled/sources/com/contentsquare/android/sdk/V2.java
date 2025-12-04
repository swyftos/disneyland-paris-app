package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class V2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ W2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V2(W2 w2) {
        super(0);
        this.a = w2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC0642c1 dialogFragmentC0642c1 = this.a.d;
        if (dialogFragmentC0642c1 != null) {
            dialogFragmentC0642c1.dismiss();
        }
        return Unit.INSTANCE;
    }
}
