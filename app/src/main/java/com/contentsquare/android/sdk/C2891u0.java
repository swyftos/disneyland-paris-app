package com.contentsquare.android.sdk;

import android.graphics.Rect;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2891u0 extends Lambda implements Function1<Rect, String> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC2749f8 f3137a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2891u0(InterfaceC2749f8 interfaceC2749f8) {
        super(1);
        this.f3137a = interfaceC2749f8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Rect rect) {
        Rect bounds = rect;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        InterfaceC2749f8 interfaceC2749f8 = this.f3137a;
        int i = bounds.left;
        int i2 = bounds.top;
        return interfaceC2749f8.mo1134a(i, i2, bounds.right - i, bounds.bottom - i2);
    }
}
