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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nReusableBitmap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReusableBitmap.kt\ncom/contentsquare/android/internal/features/sessionreplay/bitmap/ReusableBitmap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
public final class C2531J4 {

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Bitmap f1743h;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2721d0 f1744a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Canvas f1745b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Bitmap f1746c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Paint f1747d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Paint f1748e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Rect f1749f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Rect f1750g;

    static {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        f1743h = bitmapCreateBitmap;
    }

    public C2531J4(int i, int i2) {
        C2721d0 bitmapInstantiable = new C2721d0();
        Canvas canvas = new Canvas();
        Intrinsics.checkNotNullParameter(bitmapInstantiable, "bitmapInstantiable");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.f1744a = bitmapInstantiable;
        this.f1745b = canvas;
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        this.f1747d = paint;
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f1748e = paint2;
        this.f1749f = new Rect();
        this.f1750g = new Rect();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        this.f1746c = bitmapCreateBitmap;
        canvas.setBitmap(bitmapCreateBitmap);
    }

    /* JADX INFO: renamed from: a */
    public final void m956a(int i, int i2) {
        Bitmap bitmapCreateBitmap;
        if (i != this.f1746c.getWidth() || i2 != this.f1746c.getHeight()) {
            if (i < 1 || i2 < 1) {
                bitmapCreateBitmap = f1743h;
            } else {
                try {
                    this.f1746c.reconfigure(i, i2, Bitmap.Config.ARGB_8888);
                } catch (IllegalArgumentException unused) {
                    C2721d0 c2721d0 = this.f1744a;
                    Bitmap.Config config = Bitmap.Config.ARGB_8888;
                    c2721d0.getClass();
                    Intrinsics.checkNotNullParameter(config, "config");
                    bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                    this.f1746c = bitmapCreateBitmap;
                }
                this.f1745b.setBitmap(this.f1746c);
            }
            this.f1746c = bitmapCreateBitmap;
            this.f1745b.setBitmap(this.f1746c);
        }
        this.f1746c.eraseColor(0);
    }
}
