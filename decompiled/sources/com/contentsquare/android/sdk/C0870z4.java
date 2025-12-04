package com.contentsquare.android.sdk;

import android.graphics.Rect;
import com.contentsquare.android.sdk.C0834v4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.z4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0870z4 extends Lambda implements Function1<C0834v4.a, Boolean> {
    public final /* synthetic */ Rect a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0870z4(Rect rect) {
        super(1);
        this.a = rect;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(C0834v4.a aVar) {
        C0834v4.a itemView = aVar;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        return Boolean.valueOf(itemView.c.bottom <= this.a.bottom);
    }
}
