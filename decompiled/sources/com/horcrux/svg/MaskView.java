package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class MaskView extends GroupView {
    SVGLength mH;
    private Brush.BrushUnits mMaskContentUnits;
    MaskType mMaskType;
    private Brush.BrushUnits mMaskUnits;
    SVGLength mW;
    SVGLength mX;
    SVGLength mY;

    enum MaskType {
        LUMINANCE,
        ALPHA
    }

    public MaskView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
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
