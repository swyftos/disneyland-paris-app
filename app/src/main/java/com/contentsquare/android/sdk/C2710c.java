package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c */
/* JADX INFO: loaded from: classes2.dex */
public final class C2710c extends Lambda implements Function1<View, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC2720d<View> f2421a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2710c(AbstractC2720d<View> abstractC2720d) {
        super(1);
        this.f2421a = abstractC2720d;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        View forView = view;
        Intrinsics.checkNotNullParameter(forView, "$this$forView");
        AbstractC2720d<View> abstractC2720d = this.f2421a;
        Function3<? super Integer, ? super Integer, ? super Long, Unit> function3 = abstractC2720d.f2485f;
        if (function3 == null) {
            return null;
        }
        if (abstractC2720d.f2483d == 0) {
            abstractC2720d.f2483d = System.currentTimeMillis();
        }
        int iMo879a = abstractC2720d.mo879a();
        int iMo880b = abstractC2720d.mo880b();
        int i = iMo879a - abstractC2720d.f2481b;
        int i2 = iMo880b - abstractC2720d.f2482c;
        if (i != 0 || i2 != 0) {
            abstractC2720d.f2480a.run(new C2700b(function3, i, i2, System.currentTimeMillis() - abstractC2720d.f2483d, abstractC2720d, iMo879a, iMo880b));
        }
        return Unit.INSTANCE;
    }
}
