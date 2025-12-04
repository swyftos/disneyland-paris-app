package com.contentsquare.android.sdk;

import android.graphics.Paint;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.s4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0804s4 {

    @NotNull
    public final K4 a;

    @NotNull
    public final ArrayList b;
    public int c;

    @NotNull
    public final Paint d;

    public C0804s4() {
        K4 reusableBitmapProvider = new K4();
        Intrinsics.checkNotNullParameter(reusableBitmapProvider, "reusableBitmapProvider");
        this.a = reusableBitmapProvider;
        this.b = new ArrayList();
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        this.d = paint;
    }
}
