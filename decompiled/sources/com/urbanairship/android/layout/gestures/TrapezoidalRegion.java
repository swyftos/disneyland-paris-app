package com.urbanairship.android.layout.gestures;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
abstract class TrapezoidalRegion extends Region {
    public static final Companion Companion = new Companion(null);
    private final float height;
    private final float width;

    public TrapezoidalRegion(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.width = rect.width() * 0.3f;
        this.height = rect.height() * 0.3f;
    }

    protected final float getWidth() {
        return this.width;
    }

    protected final float getHeight() {
        return this.height;
    }

    protected final Region toRegion(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/gestures/TrapezoidalRegion$Companion;", "", "()V", "REGION_FRACTION", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
