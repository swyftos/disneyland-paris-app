package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
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
                double d = point.f3639x;
                float f = this.mScale;
                point.f3639x = d * ((double) f);
                point.f3640y *= (double) f;
            }
        }
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
