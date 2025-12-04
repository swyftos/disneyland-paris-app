package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.sdk.G2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class V7 extends Lambda implements Function2<View, G2, Unit> {
    public final /* synthetic */ List<G2> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V7(ArrayList arrayList) {
        super(2);
        this.a = arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(View view, G2 g2) {
        G2 json = g2;
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.h == G2.a.ANDROID_COMPOSE_VIEW) {
            this.a.add(json);
        }
        return Unit.INSTANCE;
    }
}
