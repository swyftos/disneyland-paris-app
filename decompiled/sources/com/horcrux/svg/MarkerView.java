package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class MarkerView extends GroupView {
    String mAlign;
    private SVGLength mMarkerHeight;
    private String mMarkerUnits;
    private SVGLength mMarkerWidth;
    int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private String mOrient;
    private SVGLength mRefX;
    private SVGLength mRefY;
    private float mVbHeight;
    private float mVbWidth;
    Matrix markerTransform;

    public MarkerView(ReactContext reactContext) {
        super(reactContext);
        this.markerTransform = new Matrix();
    }

    public void setRefX(Dynamic dynamic) {
        this.mRefX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRefY(Dynamic dynamic) {
        this.mRefY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setMarkerWidth(Dynamic dynamic) {
        this.mMarkerWidth = SVGLength.from(dynamic);
        invalidate();
    }

    public void setMarkerHeight(Dynamic dynamic) {
        this.mMarkerHeight = SVGLength.from(dynamic);
        invalidate();
    }

    public void setMarkerUnits(String str) {
        this.mMarkerUnits = str;
        invalidate();
    }

    public void setOrient(String str) {
        this.mOrient = str;
        invalidate();
    }

    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMarker(this, this.mName);
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).saveDefinition();
                }
            }
        }
    }

    void renderMarker(Canvas canvas, Paint paint, float f, RNSVGMarkerPosition rNSVGMarkerPosition, float f2) {
        int iSaveAndSetupCanvas = saveAndSetupCanvas(canvas, this.mCTM);
        this.markerTransform.reset();
        Point point = rNSVGMarkerPosition.origin;
        this.markerTransform.setTranslate((float) point.x, (float) point.y);
        double d = "auto".equals(this.mOrient) ? -1.0d : Double.parseDouble(this.mOrient);
        if (d == -1.0d) {
            d = rNSVGMarkerPosition.angle;
        }
        this.markerTransform.preRotate(((float) d) + 180.0f);
        if ("strokeWidth".equals(this.mMarkerUnits)) {
            Matrix matrix = this.markerTransform;
            float f3 = this.mScale;
            matrix.preScale(f2 / f3, f2 / f3);
        }
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) (relativeOnWidth(this.mMarkerWidth) / this.mScale), (float) (relativeOnHeight(this.mMarkerHeight) / this.mScale));
        if (this.mAlign != null) {
            float f4 = this.mMinX;
            float f5 = this.mScale;
            float f6 = this.mMinY;
            Matrix transform = ViewBox.getTransform(new RectF(f4 * f5, f6 * f5, (f4 + this.mVbWidth) * f5, (f6 + this.mVbHeight) * f5), rectF, this.mAlign, this.mMeetOrSlice);
            float[] fArr = new float[9];
            transform.getValues(fArr);
            this.markerTransform.preScale(fArr[0], fArr[4]);
        }
        this.markerTransform.preTranslate((float) (-relativeOnWidth(this.mRefX)), (float) (-relativeOnHeight(this.mRefY)));
        canvas.concat(this.markerTransform);
        drawGroup(canvas, paint, f);
        restoreCanvas(canvas, iSaveAndSetupCanvas);
    }
}
