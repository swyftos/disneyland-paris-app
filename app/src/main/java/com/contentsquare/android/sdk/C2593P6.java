package com.contentsquare.android.sdk;

import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.overlay.C2367c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.P6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2593P6 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2573N6 f1966a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function0<Unit> f1967b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2593P6(C2573N6 c2573n6, C2367c c2367c) {
        super(0);
        this.f1966a = c2573n6;
        this.f1967b = c2367c;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        DialogFragmentC2712c1 dialogFragmentC2712c1 = this.f1966a.f1892c;
        if (dialogFragmentC2712c1 != null) {
            dialogFragmentC2712c1.dismiss();
        }
        this.f1967b.invoke();
        return Unit.INSTANCE;
    }
}
