package com.contentsquare.android.sdk;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.contentsquare.android.sdk.s5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0805s5 extends AdaptedFunctionReference implements Function1<View, Unit> {
    public C0805s5(ArrayList arrayList) {
        super(1, arrayList, List.class, "add", "add(Ljava/lang/Object;)Z", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        View p0 = view;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((List) this.receiver).add(p0);
        return Unit.INSTANCE;
    }
}
