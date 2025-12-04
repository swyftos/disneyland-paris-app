package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.sdk.AbstractC0657d6;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: com.contentsquare.android.sdk.b8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0639b8 extends Lambda implements Function2<View, G2, Unit> {
    public final /* synthetic */ AbstractC0657d6.e a;
    public final /* synthetic */ Ref.ObjectRef<G2> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0639b8(AbstractC0657d6.e eVar, Ref.ObjectRef<G2> objectRef) {
        super(2);
        this.a = eVar;
        this.b = objectRef;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.contentsquare.android.sdk.G2, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(View view, G2 g2) {
        View view2 = view;
        G2 json = g2;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual(view2.getParent(), this.a.f.a())) {
            this.b.element = json;
        }
        return Unit.INSTANCE;
    }
}
