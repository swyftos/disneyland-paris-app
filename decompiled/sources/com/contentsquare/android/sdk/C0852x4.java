package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.contentsquare.android.sdk.C0834v4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.x4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0852x4 extends Lambda implements Function1<View, C0834v4.a> {
    public final /* synthetic */ C0834v4 a;
    public final /* synthetic */ RecyclerView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0852x4(C0834v4 c0834v4, RecyclerView recyclerView) {
        super(1);
        this.a = c0834v4;
        this.b = recyclerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final C0834v4.a invoke(View view) {
        View view2 = view;
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.getLocationOnScreen(this.a.h);
        int childAdapterPosition = this.b.getChildAdapterPosition(view2);
        int[] iArr = this.a.h;
        int i = iArr[0];
        return new C0834v4.a(view2, childAdapterPosition, new Rect(i, iArr[1], view2.getWidth() + i, view2.getHeight() + this.a.h[1]));
    }
}
