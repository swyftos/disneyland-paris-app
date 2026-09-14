package com.contentsquare.android.sdk;

import android.graphics.Rect;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2945z4 extends Lambda implements Function1<C2905v4.a, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Rect f3310a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2945z4(Rect rect) {
        super(1);
        this.f3310a = rect;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(C2905v4.a aVar) {
        C2905v4.a itemView = aVar;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        return Boolean.valueOf(itemView.f3184c.bottom <= this.f3310a.bottom);
    }
}
