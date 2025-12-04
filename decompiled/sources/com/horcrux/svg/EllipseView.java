package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class EllipseView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mRx;
    private SVGLength mRy;

    public EllipseView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setCx(Dynamic dynamic) {
        this.mCx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setCy(Dynamic dynamic) {
        this.mCy = SVGLength.from(dynamic);
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

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.mCx);
        double dRelativeOnHeight = relativeOnHeight(this.mCy);
        double dRelativeOnWidth2 = relativeOnWidth(this.mRx);
        double dRelativeOnHeight2 = relativeOnHeight(this.mRy);
        double d = dRelativeOnWidth - dRelativeOnWidth2;
        double d2 = dRelativeOnHeight - dRelativeOnHeight2;
        double d3 = dRelativeOnWidth2 + dRelativeOnWidth;
        double d4 = dRelativeOnHeight2 + dRelativeOnHeight;
        path.addOval(new RectF((float) d, (float) d2, (float) d3, (float) d4), Path.Direction.CW);
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(dRelativeOnWidth, d2)}));
        ArrayList<PathElement> arrayList2 = this.elements;
        ElementType elementType = ElementType.kCGPathElementAddLineToPoint;
        arrayList2.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d2), new Point(d3, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d3, dRelativeOnHeight), new Point(dRelativeOnWidth, d4)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d4), new Point(d, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d, dRelativeOnHeight), new Point(dRelativeOnWidth, d2)}));
        return path;
    }
}
