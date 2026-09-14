package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {
    private boolean mClockwise;
    private int mInterval;
    private boolean mIsScheduled;
    float mRotationAngle;

    public AutoRotateDrawable(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public AutoRotateDrawable(Drawable drawable, int i, boolean z) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mRotationAngle = BitmapDescriptorFactory.HUE_RED;
        this.mIsScheduled = false;
        this.mInterval = i;
        this.mClockwise = z;
    }

    public void reset() {
        this.mRotationAngle = BitmapDescriptorFactory.HUE_RED;
        this.mIsScheduled = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    public void setClockwise(boolean z) {
        this.mClockwise = z;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = i - i2;
        int i4 = bounds.bottom;
        int i5 = bounds.top;
        int i6 = i4 - i5;
        float f = this.mRotationAngle;
        if (!this.mClockwise) {
            f = 360.0f - f;
        }
        canvas.rotate(f, i2 + (i3 / 2), i5 + (i6 / 2));
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        scheduleNextFrame();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mIsScheduled = false;
        this.mRotationAngle += getIncrement();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    @Nullable
    public AutoRotateDrawable cloneDrawable() {
        Drawable drawableCloneDrawable = DrawableUtils.cloneDrawable(getDrawable());
        if (drawableCloneDrawable == null) {
            return null;
        }
        return new AutoRotateDrawable(drawableCloneDrawable, this.mInterval, this.mClockwise);
    }

    private void scheduleNextFrame() {
        if (this.mIsScheduled) {
            return;
        }
        this.mIsScheduled = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    private int getIncrement() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
