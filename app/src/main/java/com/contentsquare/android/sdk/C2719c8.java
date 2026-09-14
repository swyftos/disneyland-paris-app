package com.contentsquare.android.sdk;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2719c8 extends Lambda implements Function2<View, C2499G2, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC2727d6.e f2478a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Ref.ObjectRef<C2499G2> f2479b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2719c8(AbstractC2727d6.e eVar, Ref.ObjectRef<C2499G2> objectRef) {
        super(2);
        this.f2478a = eVar;
        this.f2479b = objectRef;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.contentsquare.android.sdk.G2, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(View view, C2499G2 c2499g2) {
        View view2 = view;
        C2499G2 json = c2499g2;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual(view2.getParent(), this.f2478a.f2525f.mo1226a())) {
            this.f2479b.element = json;
        }
        return Unit.INSTANCE;
    }
}
