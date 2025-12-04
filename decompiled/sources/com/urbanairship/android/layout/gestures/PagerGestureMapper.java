package com.urbanairship.android.layout.gestures;

import android.graphics.RectF;
import android.view.MotionEvent;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.common.RotationOptions;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.property.GestureDirection;
import com.urbanairship.android.layout.property.GestureLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J*\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012J\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureMapper;", "", "rect", "Landroid/graphics/RectF;", "isRtl", "", "(Landroid/graphics/RectF;Z)V", "bottomRegion", "Lcom/urbanairship/android/layout/gestures/BottomRegion;", "leftRegion", "Lcom/urbanairship/android/layout/gestures/LeftRegion;", "rightRegion", "Lcom/urbanairship/android/layout/gestures/RightRegion;", "topRegion", "Lcom/urbanairship/android/layout/gestures/TopRegion;", "getSwipeAngle", "", "x1", "", "y1", "x2", "y2", "getSwipeDistance", "mapSwipe", "Lcom/urbanairship/android/layout/property/GestureDirection;", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "velocityY", "mapTap", "", "Lcom/urbanairship/android/layout/property/GestureLocation;", "x", "y", "onLayoutChanged", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PagerGestureMapper {
    private BottomRegion bottomRegion;
    private boolean isRtl;
    private LeftRegion leftRegion;
    private RectF rect;
    private RightRegion rightRegion;
    private TopRegion topRegion;
    private static final Companion Companion = new Companion(null);
    private static final ClosedFloatingPointRange UP_RANGE = RangesKt.rangeTo(75.0d, 105.0d);
    private static final ClosedFloatingPointRange DOWN_RANGE = RangesKt.rangeTo(255.0d, 285.0d);

    public PagerGestureMapper(@NotNull RectF rect, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
        this.isRtl = z;
        this.topRegion = new TopRegion(this.rect);
        this.bottomRegion = new BottomRegion(this.rect);
        this.leftRegion = new LeftRegion(this.rect);
        this.rightRegion = new RightRegion(this.rect);
    }

    public final void onLayoutChanged(@NotNull RectF rect, boolean isRtl) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (Intrinsics.areEqual(this.rect, rect) && isRtl == this.isRtl) {
            return;
        }
        this.rect = rect;
        this.isRtl = isRtl;
        this.topRegion = new TopRegion(rect);
        this.bottomRegion = new BottomRegion(rect);
        this.leftRegion = new LeftRegion(rect);
        this.rightRegion = new RightRegion(rect);
    }

    @Nullable
    public final List<GestureLocation> mapTap(float x, float y) {
        int i = (int) x;
        int i2 = (int) y;
        if (this.topRegion.contains(i, i2)) {
            return CollectionsKt.listOf(GestureLocation.TOP);
        }
        if (this.bottomRegion.contains(i, i2)) {
            return CollectionsKt.listOf(GestureLocation.BOTTOM);
        }
        if (this.leftRegion.contains(i, i2)) {
            return CollectionsKt.listOf((Object[]) new GestureLocation[]{GestureLocation.LEFT, this.isRtl ? GestureLocation.END : GestureLocation.START});
        }
        if (this.rightRegion.contains(i, i2)) {
            return CollectionsKt.listOf((Object[]) new GestureLocation[]{GestureLocation.RIGHT, this.isRtl ? GestureLocation.START : GestureLocation.END});
        }
        return null;
    }

    @Nullable
    public final GestureDirection mapSwipe(@Nullable MotionEvent e1, @NotNull MotionEvent e2, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (e1 == null) {
            return null;
        }
        UALog.w("PagerGestureMapper - mapSwipe: " + e1 + ", " + e2 + ", " + velocityX + ", " + velocityY, new Object[0]);
        if (e1.getPointerCount() > 1 || e2.getPointerCount() > 1) {
            return null;
        }
        Pair pair = TuplesKt.to(Float.valueOf(e1.getX()), Float.valueOf(e1.getY()));
        float fFloatValue = ((Number) pair.component1()).floatValue();
        float fFloatValue2 = ((Number) pair.component2()).floatValue();
        Pair pair2 = TuplesKt.to(Float.valueOf(e2.getX()), Float.valueOf(e2.getY()));
        float fFloatValue3 = ((Number) pair2.component1()).floatValue();
        float fFloatValue4 = ((Number) pair2.component2()).floatValue();
        if (getSwipeDistance(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4) < 120.0d) {
            return null;
        }
        double swipeAngle = getSwipeAngle(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4);
        if (UP_RANGE.contains(Double.valueOf(swipeAngle))) {
            return GestureDirection.UP;
        }
        if (DOWN_RANGE.contains(Double.valueOf(swipeAngle))) {
            return GestureDirection.DOWN;
        }
        return null;
    }

    private final double getSwipeAngle(float x1, float y1, float x2, float y2) {
        double dAtan2 = ((float) Math.atan2(y1 - y2, x2 - x1)) + 3.141592653589793d;
        double d = RotationOptions.ROTATE_180;
        return (((dAtan2 * d) / 3.141592653589793d) + d) % Currencies.IDR;
    }

    private final double getSwipeDistance(float x1, float y1, float x2, float y2) {
        float f = y2 - y1;
        double d = 2;
        return Math.sqrt(((float) Math.pow(x2 - x1, d)) + ((float) Math.pow(f, d)));
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
