package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
class RectView extends RenderableView {

    /* JADX INFO: renamed from: mH */
    private SVGLength f3641mH;
    private SVGLength mRx;
    private SVGLength mRy;

    /* JADX INFO: renamed from: mW */
    private SVGLength f3642mW;

    /* JADX INFO: renamed from: mX */
    private SVGLength f3643mX;

    /* JADX INFO: renamed from: mY */
    private SVGLength f3644mY;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setX(Dynamic dynamic) {
        this.f3643mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.f3644mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.f3642mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.f3641mH = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRx(Dynamic dynamic) {
        this.mRx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setRy(Dynamic dynamic) {
        this.mRy = SVGLength.from(dynamic);
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        double dRelativeOnWidth;
        double dRelativeOnHeight;
        double d;
        double d2;
        Path path = new Path();
        double dRelativeOnWidth2 = relativeOnWidth(this.f3643mX);
        double dRelativeOnHeight2 = relativeOnHeight(this.f3644mY);
        double dRelativeOnWidth3 = relativeOnWidth(this.f3642mW);
        double dRelativeOnHeight3 = relativeOnHeight(this.f3641mH);
        SVGLength sVGLength = this.mRx;
        if (sVGLength != null || this.mRy != null) {
            if (sVGLength == null) {
                dRelativeOnWidth = relativeOnHeight(this.mRy);
            } else {
                if (this.mRy == null) {
                    dRelativeOnWidth = relativeOnWidth(sVGLength);
                } else {
                    dRelativeOnWidth = relativeOnWidth(sVGLength);
                    dRelativeOnHeight = relativeOnHeight(this.mRy);
                }
                d = dRelativeOnWidth3 / 2.0d;
                if (dRelativeOnWidth > d) {
                    dRelativeOnWidth = d;
                }
                d2 = dRelativeOnHeight3 / 2.0d;
                if (dRelativeOnHeight > d2) {
                    dRelativeOnHeight = d2;
                }
                path.addRoundRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), (float) dRelativeOnWidth, (float) dRelativeOnHeight, Path.Direction.CW);
            }
            dRelativeOnHeight = dRelativeOnWidth;
            d = dRelativeOnWidth3 / 2.0d;
            if (dRelativeOnWidth > d) {
                dRelativeOnWidth = d;
            }
            d2 = dRelativeOnHeight3 / 2.0d;
            if (dRelativeOnHeight > d2) {
                dRelativeOnHeight = d2;
            }
            path.addRoundRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), (float) dRelativeOnWidth, (float) dRelativeOnHeight, Path.Direction.CW);
        } else {
            path.addRect((float) dRelativeOnWidth2, (float) dRelativeOnHeight2, (float) (dRelativeOnWidth2 + dRelativeOnWidth3), (float) (dRelativeOnHeight2 + dRelativeOnHeight3), Path.Direction.CW);
            path.close();
        }
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(dRelativeOnWidth2, dRelativeOnHeight2)}));
        ArrayList<PathElement> arrayList2 = this.elements;
        ElementType elementType = ElementType.kCGPathElementAddLineToPoint;
        double d3 = dRelativeOnWidth2 + dRelativeOnWidth3;
        arrayList2.add(new PathElement(elementType, new Point[]{new Point(d3, dRelativeOnHeight2)}));
        double d4 = dRelativeOnHeight2 + dRelativeOnHeight3;
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d3, d4)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth2, d4)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth2, dRelativeOnHeight2)}));
        return path;
    }
}
