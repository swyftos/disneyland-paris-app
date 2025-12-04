package com.urbanairship.android.layout.gestures;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class BottomRegion extends TrapezoidalRegion {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomRegion(RectF rect) {
        super(rect);
        Intrinsics.checkNotNullParameter(rect, "rect");
        Path path = new Path();
        path.moveTo(rect.left, rect.bottom);
        path.lineTo(rect.right, rect.bottom);
        path.lineTo(rect.right - getWidth(), rect.bottom - getHeight());
        path.lineTo(rect.left + getWidth(), rect.bottom - getHeight());
        path.close();
        setPath(path, toRegion(path));
    }
}
