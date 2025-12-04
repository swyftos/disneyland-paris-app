package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMergedScreenshotsBitmapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MergedScreenshotsBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/MergedScreenshotsBitmapBuilder\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,148:1\n43#2,3:149\n*S KotlinDebug\n*F\n+ 1 MergedScreenshotsBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/MergedScreenshotsBitmapBuilder\n*L\n103#1:149,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.b3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0634b3 {

    @Nullable
    public Bitmap a;
    public int b;
    public int c;
    public int d;

    @VisibleForTesting
    public final void a(@NotNull Bitmap appendBitmap, @NotNull Rect appendRect) {
        Intrinsics.checkNotNullParameter(appendBitmap, "appendBitmap");
        Intrinsics.checkNotNullParameter(appendRect, "appendRect");
        if (appendRect.width() <= 0 || appendRect.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.a;
        Bitmap bitmapCreateBitmap = bitmap != null ? Bitmap.createBitmap(bitmap.getWidth(), appendRect.height() + bitmap.getHeight(), ExtensionsKt.orDefault(bitmap.getConfig())) : null;
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(appendBitmap.getWidth(), appendRect.height(), ExtensionsKt.orDefault(appendBitmap.getConfig()));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …fig.orDefault()\n        )");
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmap2 = this.a;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        }
        Rect rect = new Rect(appendRect);
        Bitmap bitmap3 = this.a;
        int height = bitmap3 != null ? bitmap3.getHeight() : 0;
        rect.top = height;
        rect.bottom = appendRect.height() + height;
        canvas.drawBitmap(appendBitmap, appendRect, rect, (Paint) null);
        this.a = bitmapCreateBitmap;
    }

    public final void b(@NotNull Bitmap screenshot, @NotNull Rect pageRect) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(pageRect, "pageRect");
        Rect rect = new Rect(0, pageRect.top, screenshot.getWidth(), pageRect.bottom);
        a(screenshot, rect);
        int iHeight = rect.height() + this.b;
        this.b = iHeight;
        this.d = iHeight - pageRect.bottom;
        Bitmap bitmap = this.a;
        this.c = (bitmap != null ? bitmap.getHeight() : 0) - pageRect.bottom;
    }

    public final void a(int i) {
        int i2 = i + this.c;
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            if (i2 >= bitmap.getHeight()) {
                this.a = null;
                this.c = 0;
            } else if (i2 > 0) {
                Rect rect = new Rect(0, i2, bitmap.getWidth(), bitmap.getHeight());
                this.a = null;
                a(bitmap, rect);
                this.c -= i2;
            }
        }
    }
}
