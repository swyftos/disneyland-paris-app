package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.C0834v4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.y4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0861y4 extends Lambda implements Function1<C0834v4.a, Boolean> {
    public final /* synthetic */ C0834v4 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0861y4(C0834v4 c0834v4) {
        super(1);
        this.a = c0834v4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(C0834v4.a aVar) {
        C0834v4.a itemView = aVar;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        return Boolean.valueOf(this.a.f.contains(Integer.valueOf(itemView.b)));
    }
}
