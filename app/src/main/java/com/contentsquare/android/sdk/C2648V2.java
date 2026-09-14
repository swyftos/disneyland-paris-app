package com.contentsquare.android.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2648V2 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2657W2 f2191a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2648V2(C2657W2 c2657w2) {
        super(0);
        this.f2191a = c2657w2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC2712c1 dialogFragmentC2712c1 = this.f2191a.f2208d;
        if (dialogFragmentC2712c1 != null) {
            dialogFragmentC2712c1.dismiss();
        }
        return Unit.INSTANCE;
    }
}
