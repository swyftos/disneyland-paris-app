package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPreviewBitmapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/PreviewBitmapBuilder\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,145:1\n43#2,3:146\n*S KotlinDebug\n*F\n+ 1 PreviewBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/PreviewBitmapBuilder\n*L\n97#1:146,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.b4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0635b4 {
    public int a;
    public int b;

    @Nullable
    public Bitmap c;
    public int d;

    @VisibleForTesting
    public final void a(@NotNull Bitmap appendBitmap, @NotNull Rect appendRect) {
        Bitmap.Config config;
        Bitmap bitmapCreateBitmap;
        int i;
        Intrinsics.checkNotNullParameter(appendBitmap, "appendBitmap");
        Intrinsics.checkNotNullParameter(appendRect, "appendRect");
        if (appendRect.width() <= 0 || appendRect.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.c;
        if (bitmap == null || (config = bitmap.getConfig()) == null) {
            config = appendBitmap.getConfig();
        }
        Intrinsics.checkNotNullExpressionValue(config, "bitmap?.config ?: appendBitmap.config");
        int iHeight = appendRect.height() + this.d;
        int i2 = this.b;
        if (iHeight <= i2) {
            bitmapCreateBitmap = Bitmap.createBitmap(appendRect.width(), appendRect.height() + this.d, ExtensionsKt.orDefault(config));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "{\n        Bitmap.createB…Default()\n        )\n    }");
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(RangesKt.coerceIn(MathKt.roundToInt(appendRect.width() * (i2 / (appendRect.height() + this.d))), 1, this.a), this.b, ExtensionsKt.orDefault(config));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "{\n        val scale = ma…Default()\n        )\n    }");
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float height = canvas.getHeight() / (appendRect.height() + this.d);
        Bitmap bitmap2 = this.c;
        if (bitmap2 != null) {
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            Rect rect2 = new Rect(0, 0, canvas.getWidth(), MathKt.roundToInt(this.d * height));
            canvas.drawBitmap(bitmap2, rect, rect2, (Paint) null);
            i = rect2.bottom;
        } else {
            i = 0;
        }
        canvas.drawBitmap(appendBitmap, appendRect, new Rect(0, i, canvas.getWidth(), canvas.getHeight()), (Paint) null);
        this.c = bitmapCreateBitmap;
        this.d = appendRect.height() + this.d;
    }
}
