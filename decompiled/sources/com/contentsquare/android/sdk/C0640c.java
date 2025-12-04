package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0640c extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ AbstractC0650d<View> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0640c(AbstractC0650d<View> abstractC0650d) {
        super(1);
        this.a = abstractC0650d;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        View forView = view;
        Intrinsics.checkNotNullParameter(forView, "$this$forView");
        AbstractC0650d<View> abstractC0650d = this.a;
        Function3<? super Integer, ? super Integer, ? super Long, Unit> function3 = abstractC0650d.f;
        if (function3 == null) {
            return null;
        }
        if (abstractC0650d.d == 0) {
            abstractC0650d.d = System.currentTimeMillis();
        }
        int iA = abstractC0650d.a();
        int iB = abstractC0650d.b();
        int i = iA - abstractC0650d.b;
        int i2 = iB - abstractC0650d.c;
        if (i != 0 || i2 != 0) {
            abstractC0650d.a.run(new C0630b(function3, i, i2, System.currentTimeMillis() - abstractC0650d.d, abstractC0650d, iA, iB));
        }
        return Unit.INSTANCE;
    }
}
