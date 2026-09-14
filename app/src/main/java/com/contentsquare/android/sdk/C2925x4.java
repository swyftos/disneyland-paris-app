package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2925x4 extends Lambda implements Function1<View, C2905v4.a> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2905v4 f3227a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RecyclerView f3228b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2925x4(C2905v4 c2905v4, RecyclerView recyclerView) {
        super(1);
        this.f3227a = c2905v4;
        this.f3228b = recyclerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final C2905v4.a invoke(View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.getLocationOnScreen(this.f3227a.f3181h);
        int childAdapterPosition = this.f3228b.getChildAdapterPosition(view2);
        int[] iArr = this.f3227a.f3181h;
        int i = iArr[0];
        return new C2905v4.a(view2, childAdapterPosition, new Rect(i, iArr[1], view2.getWidth() + i, view2.getHeight() + this.f3227a.f3181h[1]));
    }
}
