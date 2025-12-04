package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.sdk.C0736l5;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class H0 extends FunctionReferenceImpl implements Function3<Integer, Integer, Long, Unit> {
    public H0(Object obj) {
        super(3, obj, J0.class, "dispatchScrollEvent", "dispatchScrollEvent(IIJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(Integer num, Integer num2, Long l) {
        int iIntValue = num.intValue();
        int iIntValue2 = num2.intValue();
        long jLongValue = l.longValue();
        J0 j0 = (J0) this.receiver;
        j0.getClass();
        if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.EXPOSURE_METRICS)) {
            C0736l5.a aVar = (C0736l5.a) E1.a(j0.f, 23);
            aVar.k = j0.j.pixelsToDp(iIntValue);
            aVar.l = j0.j.pixelsToDp(iIntValue2);
            aVar.m = jLongValue;
            j0.c.a(aVar);
            j0.l.i("Scroll view event deltaX: " + iIntValue + " deltaY: " + iIntValue2 + " duration: " + jLongValue);
        }
        return Unit.INSTANCE;
    }
}
