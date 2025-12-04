package com.horcrux.svg;

import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.horcrux.svg.FilterProperties;
import com.horcrux.svg.SVGLength;

/* loaded from: classes4.dex */
public class FilterRegion {
    SVGLength mH;
    SVGLength mW;
    SVGLength mX;
    SVGLength mY;

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
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
            dRelativeOnFraction = rectF.left + virtualView.relativeOnFraction(this.mX, rectF.width());
            dRelativeOnFraction2 = rectF.top + virtualView.relativeOnFraction(this.mY, rectF.height());
            dRelativeOnFraction3 = virtualView.relativeOnFraction(this.mW, rectF.width());
            relativeOrDefault = virtualView.relativeOnFraction(this.mH, rectF.height());
        } else {
            float canvasWidth = virtualView.getSvgView().getCanvasWidth();
            float canvasHeight = virtualView.getSvgView().getCanvasHeight();
            double relativeOrDefault2 = getRelativeOrDefault(virtualView, this.mX, canvasWidth, rectF.left);
            double relativeOrDefault3 = getRelativeOrDefault(virtualView, this.mY, canvasHeight, rectF.top);
            double relativeOrDefault4 = getRelativeOrDefault(virtualView, this.mW, canvasWidth, rectF.width());
            relativeOrDefault = getRelativeOrDefault(virtualView, this.mH, canvasHeight, rectF.height());
            dRelativeOnFraction = relativeOrDefault2;
            dRelativeOnFraction2 = relativeOrDefault3;
            dRelativeOnFraction3 = relativeOrDefault4;
        }
        return new Rect((int) dRelativeOnFraction, (int) dRelativeOnFraction2, (int) (dRelativeOnFraction + dRelativeOnFraction3), (int) (dRelativeOnFraction2 + relativeOrDefault));
    }
}
