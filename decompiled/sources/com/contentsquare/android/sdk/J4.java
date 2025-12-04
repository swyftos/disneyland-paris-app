package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nReusableBitmap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReusableBitmap.kt\ncom/contentsquare/android/internal/features/sessionreplay/bitmap/ReusableBitmap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
/* loaded from: classes2.dex */
public final class J4 {

    @NotNull
    public static final Bitmap h;

    @NotNull
    public final C0651d0 a;

    @NotNull
    public final Canvas b;

    @NotNull
    public Bitmap c;

    @NotNull
    public final Paint d;

    @NotNull
    public final Paint e;

    @NotNull
    public final Rect f;

    @NotNull
    public final Rect g;

    static {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        h = bitmapCreateBitmap;
    }

    public J4(int i, int i2) {
        C0651d0 bitmapInstantiable = new C0651d0();
        Canvas canvas = new Canvas();
        Intrinsics.checkNotNullParameter(bitmapInstantiable, "bitmapInstantiable");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.a = bitmapInstantiable;
        this.b = canvas;
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        this.d = paint;
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.e = paint2;
        this.f = new Rect();
        this.g = new Rect();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        this.c = bitmapCreateBitmap;
        canvas.setBitmap(bitmapCreateBitmap);
    }

    public final void a(int i, int i2) {
        Bitmap bitmapCreateBitmap;
        if (i != this.c.getWidth() || i2 != this.c.getHeight()) {
            if (i < 1 || i2 < 1) {
                bitmapCreateBitmap = h;
            } else {
                try {
                    this.c.reconfigure(i, i2, Bitmap.Config.ARGB_8888);
                } catch (IllegalArgumentException unused) {
                    C0651d0 c0651d0 = this.a;
                    Bitmap.Config config = Bitmap.Config.ARGB_8888;
                    c0651d0.getClass();
                    Intrinsics.checkNotNullParameter(config, "config");
                    bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                }
                this.b.setBitmap(this.c);
            }
            this.c = bitmapCreateBitmap;
            this.b.setBitmap(this.c);
        }
        this.c.eraseColor(0);
    }
}
