package com.contentsquare.android.sdk;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2935y4 extends Lambda implements Function1<C2905v4.a, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2905v4 f3260a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2935y4(C2905v4 c2905v4) {
        super(1);
        this.f3260a = c2905v4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(C2905v4.a aVar) {
        C2905v4.a itemView = aVar;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        return Boolean.valueOf(this.f3260a.f3179f.contains(Integer.valueOf(itemView.f3183b)));
    }
}
