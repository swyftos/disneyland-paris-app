package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.contentsquare.android.sdk.r4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0794r4 {

    @NonNull
    public final a a = new a();

    @NonNull
    public final Point b = new Point();

    /* renamed from: com.contentsquare.android.sdk.r4$a */
    public static class a {

        @NonNull
        public final Rect a = new Rect();
        public float b;
    }

    @NonNull
    public final a a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        float f;
        a aVar = this.a;
        Rect rect = aVar.a;
        rect.left = i;
        rect.top = i2;
        int i9 = i + i3;
        rect.right = i9;
        int i10 = i2 + i4;
        rect.bottom = i10;
        boolean z2 = true;
        if (i < i5) {
            rect.left = i5;
            z = true;
        } else {
            z = false;
        }
        if (i2 < i6) {
            rect.top = i6;
            z = true;
        }
        int i11 = i5 + i7;
        if (i9 > i11) {
            rect.right = i11;
            z = true;
        }
        int i12 = i6 + i8;
        if (i10 > i12) {
            rect.bottom = i12;
        } else {
            z2 = z;
        }
        if (z2) {
            int i13 = i3 * i4;
            int iHeight = this.a.a.height() * rect.width();
            f = (i13 == 0 || iHeight == 0) ? 1.0f : iHeight / i13;
        } else {
            f = BitmapDescriptorFactory.HUE_RED;
        }
        aVar.b = f;
        return this.a;
    }
}
