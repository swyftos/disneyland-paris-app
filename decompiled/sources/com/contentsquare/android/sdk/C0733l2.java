package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.l2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0733l2 extends Lambda implements Function0<L4> {
    public final /* synthetic */ boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0733l2(boolean z) {
        super(0);
        this.a = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        return this.a ? L4.EVALUATE : L4.BREAK;
    }
}
