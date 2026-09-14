package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2583O6 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2573N6 f1945a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2583O6(C2573N6 c2573n6) {
        super(0);
        this.f1945a = c2573n6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC2712c1 dialogFragmentC2712c1 = this.f1945a.f1892c;
        if (dialogFragmentC2712c1 != null) {
            dialogFragmentC2712c1.dismiss();
        }
        return Unit.INSTANCE;
    }
}
