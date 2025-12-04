package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.contentsquare.android.sdk.K2;
import com.contentsquare.android.sdk.x8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class E7 implements K2.a {
    public final /* synthetic */ x8<View> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public E7(x8<View> x8Var, int i, int i2) {
        this.a = x8Var;
        this.b = i;
        this.c = i2;
    }

    @Override // com.contentsquare.android.sdk.K2.a
    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getVisibility() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = this.b;
            int i4 = this.c;
            if (i3 < i || i3 > i + width || i4 < i2 || i4 > i2 + height || !ViewCompat.isAttachedToWindow(view)) {
                return;
            }
            x8<View> x8Var = this.a;
            x8.a aVar = x8Var.b;
            x8.a aVar2 = new x8.a(view);
            x8Var.b = aVar2;
            if (aVar == null) {
                x8Var.a = aVar2;
            } else {
                aVar2.c = aVar;
                aVar.b = aVar2;
            }
        }
    }
}
