package com.horcrux.svg;

import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes4.dex */
public class FilterRegion {

    /* JADX INFO: renamed from: mH */
    SVGLength f3614mH;

    /* JADX INFO: renamed from: mW */
    SVGLength f3615mW;

    /* JADX INFO: renamed from: mX */
    SVGLength f3616mX;

    /* JADX INFO: renamed from: mY */
    SVGLength f3617mY;

    public void setX(Dynamic dynamic) {
        this.f3616mX = SVGLength.from(dynamic);
    }

    public void setY(Dynamic dynamic) {
        this.f3617mY = SVGLength.from(dynamic);
    }

    public void setWidth(Dynamic dynamic) {
        this.f3615mW = SVGLength.from(dynamic);
    }

    public void setHeight(Dynamic dynamic) {
        this.f3614mH = SVGLength.from(dynamic);
    }

    private double getRelativeOrDefault(VirtualView virtualView, SVGLength sVGLength, float f, double d) {
        return (sVGLength == null || sVGLength.unit == SVGLength.UnitType.UNKNOWN) ? d : virtualView.relativeOn(sVGLength, f);
    }

    public Rect getCropRect(VirtualView virtualView, FilterProperties.Units units, RectF rectF) {
        double relativeOrDefault;
        double dRelativeOnFraction;
        double dRelativeOnFraction2;
        double dRelativeOnFraction3;
        if (rectF == null) {
            return new Rect(0, 0, 0, 0);
        }
        if (units == FilterProperties.Units.OBJECT_BOUNDING_BOX) {
            dRelativeOnFraction = ((double) rectF.left) + virtualView.relativeOnFraction(this.f3616mX, rectF.width());
            dRelativeOnFraction2 = ((double) rectF.top) + virtualView.relativeOnFraction(this.f3617mY, rectF.height());
            dRelativeOnFraction3 = virtualView.relativeOnFraction(this.f3615mW, rectF.width());
            relativeOrDefault = virtualView.relativeOnFraction(this.f3614mH, rectF.height());
        } else {
            float canvasWidth = virtualView.getSvgView().getCanvasWidth();
            float canvasHeight = virtualView.getSvgView().getCanvasHeight();
            double relativeOrDefault2 = getRelativeOrDefault(virtualView, this.f3616mX, canvasWidth, rectF.left);
            double relativeOrDefault3 = getRelativeOrDefault(virtualView, this.f3617mY, canvasHeight, rectF.top);
            double relativeOrDefault4 = getRelativeOrDefault(virtualView, this.f3615mW, canvasWidth, rectF.width());
            relativeOrDefault = getRelativeOrDefault(virtualView, this.f3614mH, canvasHeight, rectF.height());
            dRelativeOnFraction = relativeOrDefault2;
            dRelativeOnFraction2 = relativeOrDefault3;
            dRelativeOnFraction3 = relativeOrDefault4;
        }
        return new Rect((int) dRelativeOnFraction, (int) dRelativeOnFraction2, (int) (dRelativeOnFraction + dRelativeOnFraction3), (int) (dRelativeOnFraction2 + relativeOrDefault));
    }
}
