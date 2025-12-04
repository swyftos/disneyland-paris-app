package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class CircleView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mR;

    public CircleView(ReactContext reactContext) {
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

    public void setR(Dynamic dynamic) {
        this.mR = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.mCx);
        double dRelativeOnHeight = relativeOnHeight(this.mCy);
        double dRelativeOnOther = relativeOnOther(this.mR);
        path.addCircle((float) dRelativeOnWidth, (float) dRelativeOnHeight, (float) dRelativeOnOther, Path.Direction.CW);
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        double d = dRelativeOnHeight - dRelativeOnOther;
        arrayList.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point(dRelativeOnWidth, d)}));
        ArrayList<PathElement> arrayList2 = this.elements;
        ElementType elementType = ElementType.kCGPathElementAddLineToPoint;
        Point point = new Point(dRelativeOnWidth, d);
        double d2 = dRelativeOnWidth + dRelativeOnOther;
        arrayList2.add(new PathElement(elementType, new Point[]{point, new Point(d2, dRelativeOnHeight)}));
        double d3 = dRelativeOnHeight + dRelativeOnOther;
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d2, dRelativeOnHeight), new Point(dRelativeOnWidth, d3)}));
        double d4 = dRelativeOnWidth - dRelativeOnOther;
        this.elements.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d3), new Point(d4, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d4, dRelativeOnHeight), new Point(dRelativeOnWidth, d)}));
        return path;
    }
}
