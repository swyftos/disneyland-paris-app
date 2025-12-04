package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class P6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ N6 a;
    public final /* synthetic */ Function0<Unit> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P6(N6 n6, com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.c cVar) {
        super(0);
        this.a = n6;
        this.b = cVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC0642c1 dialogFragmentC0642c1 = this.a.c;
        if (dialogFragmentC0642c1 != null) {
            dialogFragmentC0642c1.dismiss();
        }
        this.b.invoke();
        return Unit.INSTANCE;
    }
}
