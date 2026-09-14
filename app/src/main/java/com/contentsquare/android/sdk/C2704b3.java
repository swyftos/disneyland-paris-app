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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMergedScreenshotsBitmapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MergedScreenshotsBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/MergedScreenshotsBitmapBuilder\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,148:1\n43#2,3:149\n*S KotlinDebug\n*F\n+ 1 MergedScreenshotsBitmapBuilder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/MergedScreenshotsBitmapBuilder\n*L\n103#1:149,3\n*E\n"})
public final class C2704b3 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public Bitmap f2403a;

    /* JADX INFO: renamed from: b */
    public int f2404b;

    /* JADX INFO: renamed from: c */
    public int f2405c;

    /* JADX INFO: renamed from: d */
    public int f2406d;

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public final void m1095a(@NotNull Bitmap appendBitmap, @NotNull Rect appendRect) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(appendBitmap, "appendBitmap");
        Intrinsics.checkNotNullParameter(appendRect, "appendRect");
        if (appendRect.width() <= 0 || appendRect.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.f2403a;
        if (bitmap != null) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), appendRect.height() + bitmap.getHeight(), ExtensionsKt.orDefault(bitmap.getConfig()));
        } else {
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(appendBitmap.getWidth(), appendRect.height(), ExtensionsKt.orDefault(appendBitmap.getConfig()));
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …fig.orDefault()\n        )");
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmap2 = this.f2403a;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        }
        Rect rect = new Rect(appendRect);
        Bitmap bitmap3 = this.f2403a;
        int height = bitmap3 != null ? bitmap3.getHeight() : 0;
        rect.top = height;
        rect.bottom = appendRect.height() + height;
        canvas.drawBitmap(appendBitmap, appendRect, rect, (Paint) null);
        this.f2403a = bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: b */
    public final void m1096b(@NotNull Bitmap screenshot, @NotNull Rect pageRect) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(pageRect, "pageRect");
        Rect rect = new Rect(0, pageRect.top, screenshot.getWidth(), pageRect.bottom);
        m1095a(screenshot, rect);
        int iHeight = rect.height() + this.f2404b;
        this.f2404b = iHeight;
        this.f2406d = iHeight - pageRect.bottom;
        Bitmap bitmap = this.f2403a;
        this.f2405c = (bitmap != null ? bitmap.getHeight() : 0) - pageRect.bottom;
    }

    /* JADX INFO: renamed from: a */
    public final void m1094a(int i) {
        int i2 = i + this.f2405c;
        Bitmap bitmap = this.f2403a;
        if (bitmap != null) {
            if (i2 >= bitmap.getHeight()) {
                this.f2403a = null;
                this.f2405c = 0;
            } else if (i2 > 0) {
                Rect rect = new Rect(0, i2, bitmap.getWidth(), bitmap.getHeight());
                this.f2403a = null;
                m1095a(bitmap, rect);
                this.f2405c -= i2;
            }
        }
    }
}
