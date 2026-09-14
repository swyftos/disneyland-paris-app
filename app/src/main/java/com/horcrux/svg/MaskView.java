package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
class MaskView extends GroupView {

    /* JADX INFO: renamed from: mH */
    SVGLength f3628mH;
    private Brush.BrushUnits mMaskContentUnits;
    MaskType mMaskType;
    private Brush.BrushUnits mMaskUnits;

    /* JADX INFO: renamed from: mW */
    SVGLength f3629mW;

    /* JADX INFO: renamed from: mX */
    SVGLength f3630mX;

    /* JADX INFO: renamed from: mY */
    SVGLength f3631mY;

    enum MaskType {
        LUMINANCE,
        ALPHA
    }

    public MaskView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setX(Dynamic dynamic) {
        this.f3630mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.f3631mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.f3629mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.f3628mH = SVGLength.from(dynamic);
        invalidate();
    }

    public Brush.BrushUnits getMaskUnits() {
        return this.mMaskUnits;
    }

    public void setMaskUnits(int i) {
        if (i == 0) {
            this.mMaskUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public void setMaskContentUnits(int i) {
        if (i == 0) {
            this.mMaskContentUnits = Brush.BrushUnits.OBJECT_BOUNDING_BOX;
        } else if (i == 1) {
            this.mMaskContentUnits = Brush.BrushUnits.USER_SPACE_ON_USE;
        }
        invalidate();
    }

    public MaskType getMaskType() {
        return this.mMaskType;
    }

    public void setMaskType(int i) {
        if (i == 0) {
            this.mMaskType = MaskType.LUMINANCE;
        } else if (i == 1) {
            this.mMaskType = MaskType.ALPHA;
        }
        invalidate();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
