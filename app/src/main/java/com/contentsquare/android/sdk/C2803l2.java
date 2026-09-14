package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2803l2 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f2843a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2803l2(boolean z) {
        super(0);
        this.f2843a = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        return this.f2843a ? EnumC2551L4.EVALUATE : EnumC2551L4.BREAK;
    }
}
