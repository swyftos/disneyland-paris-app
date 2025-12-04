package org.reactnative.maskedview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes6.dex */
public class RNCMaskedView extends ReactViewGroup {
    private Bitmap mBitmapMask;
    private boolean mBitmapMaskInvalidated;
    private Paint mPaint;
    private PorterDuffXfermode mPorterDuffXferMode;
    private int mRenderingMode;

    public RNCMaskedView(Context context) {
        super(context);
        this.mBitmapMask = null;
        this.mBitmapMaskInvalidated = false;
        this.mRenderingMode = 2;
        this.mPaint = new Paint(1);
        this.mPorterDuffXferMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mBitmapMaskInvalidated) {
            updateBitmapMask();
            this.mBitmapMaskInvalidated = false;
        }
        if (this.mBitmapMask != null) {
            setLayerType(this.mRenderingMode, this.mPaint);
            this.mPaint.setXfermode(this.mPorterDuffXferMode);
            canvas.drawBitmap(this.mBitmapMask, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.mPaint);
            this.mPaint.setXfermode(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        View childAt;
        super.onDescendantInvalidated(view, view2);
        if (!this.mBitmapMaskInvalidated && (childAt = getChildAt(0)) != null && childAt.equals(view)) {
            this.mBitmapMaskInvalidated = true;
        }
        invalidate();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.mBitmapMaskInvalidated = true;
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mBitmapMaskInvalidated = true;
    }

    private void updateBitmapMask() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setVisibility(0);
            Bitmap bitmap = this.mBitmapMask;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mBitmapMask = getBitmapFromView(childAt);
            childAt.setVisibility(4);
        }
    }

    public static Bitmap getBitmapFromView(View view) {
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public void setRenderingMode(String str) {
        this.mRenderingMode = str.equals("software") ? 1 : 2;
    }
}
