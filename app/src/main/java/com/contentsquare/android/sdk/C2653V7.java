package com.contentsquare.android.sdk;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2653V7 extends Lambda implements Function2<View, C2499G2, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ List<C2499G2> f2195a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2653V7(ArrayList arrayList) {
        super(2);
        this.f2195a = arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(View view, C2499G2 c2499g2) {
        C2499G2 json = c2499g2;
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.f1644h == C2499G2.a.ANDROID_COMPOSE_VIEW) {
            this.f2195a.add(json);
        }
        return Unit.INSTANCE;
    }
}
