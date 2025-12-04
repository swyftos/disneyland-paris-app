package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.j5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0716j5 extends Lambda implements Function1<G2, Boolean> {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0716j5(int i) {
        super(1);
        this.a = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(G2 g2) {
        G2 jsonView = g2;
        Intrinsics.checkNotNullParameter(jsonView, "jsonView");
        return Boolean.valueOf(jsonView.f.getInt("y") < this.a);
    }
}
