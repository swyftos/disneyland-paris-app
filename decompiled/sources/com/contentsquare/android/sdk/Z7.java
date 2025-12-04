package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nVerticalInsertAtTopStrategy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalInsertAtTopStrategy.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/VerticalInsertAtTopStrategy\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n43#2,2:101\n45#2:104\n1#3:103\n*S KotlinDebug\n*F\n+ 1 VerticalInsertAtTopStrategy.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/previewbuilder/VerticalInsertAtTopStrategy\n*L\n72#1:101,2\n72#1:104\n*E\n"})
/* loaded from: classes2.dex */
public final class Z7 implements P4<J> {
    @Override // com.contentsquare.android.sdk.P4
    public final Bitmap a(Bitmap bitmap, Bitmap appendBitmap, J context) {
        Bitmap.Config config;
        Intrinsics.checkNotNullParameter(appendBitmap, "screenshot");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appendBitmap, "appendBitmap");
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (bitmap == null || (config = bitmap.getConfig()) == null) {
            config = appendBitmap.getConfig();
        }
        Intrinsics.checkNotNullExpressionValue(config, "currentBitmap?.config ?: appendBitmap.config");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appendBitmap, "appendBitmap");
        Rect rect = context.a;
        Rect appendRect = context.e ? new Rect(0, 0, appendBitmap.getWidth(), rect.bottom) : context.d ? new Rect(0, (((context.c - 1) * rect.height()) + rect.top) - context.b, appendBitmap.getWidth(), appendBitmap.getHeight()) : new Rect(0, rect.top, appendBitmap.getWidth(), rect.bottom);
        if (appendRect.width() <= 0 || appendRect.height() <= 0) {
            return bitmap;
        }
        Intrinsics.checkNotNullParameter(appendRect, "appendRect");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(width, appendRect.width()), appendRect.height() + height, ExtensionsKt.orDefault(config));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …fig.orDefault()\n        )");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, appendRect.height(), (Paint) null);
        }
        Rect rect2 = new Rect(appendRect);
        rect2.offsetTo(0, 0);
        canvas.drawBitmap(appendBitmap, appendRect, rect2, (Paint) null);
        return bitmapCreateBitmap;
    }
}
