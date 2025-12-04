package com.contentsquare.android.sdk;

import android.graphics.Rect;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.u0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0820u0 extends Lambda implements Function1<Rect, String> {
    public final /* synthetic */ InterfaceC0679f8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0820u0(InterfaceC0679f8 interfaceC0679f8) {
        super(1);
        this.a = interfaceC0679f8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Rect rect) {
        Rect bounds = rect;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        InterfaceC0679f8 interfaceC0679f8 = this.a;
        int i = bounds.left;
        int i2 = bounds.top;
        return interfaceC0679f8.a(i, i2, bounds.right - i, bounds.bottom - i2);
    }
}
