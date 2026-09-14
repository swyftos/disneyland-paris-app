package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2484E7 implements C2539K2.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2929x8<View> f1562a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f1563b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1564c;

    public C2484E7(C2929x8<View> c2929x8, int i, int i2) {
        this.f1562a = c2929x8;
        this.f1563b = i;
        this.f1564c = i2;
    }

    @Override // com.contentsquare.android.sdk.C2539K2.a
    /* JADX INFO: renamed from: a */
    public final void mo913a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getVisibility() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = this.f1563b;
            int i4 = this.f1564c;
            if (i3 < i || i3 > i + width || i4 < i2 || i4 > i2 + height || !ViewCompat.isAttachedToWindow(view)) {
                return;
            }
            C2929x8<View> c2929x8 = this.f1562a;
            C2929x8.a aVar = c2929x8.f3248b;
            C2929x8.a aVar2 = new C2929x8.a(view);
            c2929x8.f3248b = aVar2;
            if (aVar == null) {
                c2929x8.f3247a = aVar2;
            } else {
                aVar2.f3251c = aVar;
                aVar.f3250b = aVar2;
            }
        }
    }
}
