package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
        PathParser.mScale = this.mScale;
        this.mPath = new Path();
    }

    public void setD(String str) {
        this.mPath = PathParser.parse(str);
        ArrayList<PathElement> arrayList = PathParser.elements;
        this.elements = arrayList;
        Iterator<PathElement> it = arrayList.iterator();
        while (it.hasNext()) {
            for (Point point : it.next().points) {
                double d = point.x;
                float f = this.mScale;
                point.x = d * f;
                point.y *= f;
            }
        }
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
