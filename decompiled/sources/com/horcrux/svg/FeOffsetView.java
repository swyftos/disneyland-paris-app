package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FeOffsetView extends FilterPrimitiveView {
    SVGLength mDx;
    SVGLength mDy;
    String mIn1;

    public FeOffsetView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setDx(Dynamic dynamic) {
        this.mDx = SVGLength.from(dynamic);
        invalidate();
    }

    public void setDy(Dynamic dynamic) {
        this.mDy = SVGLength.from(dynamic);
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        Bitmap source = FilterPrimitiveView.getSource(map, bitmap, this.mIn1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        SVGLength sVGLength = this.mDx;
        float fRelativeOnWidth = sVGLength != null ? (float) relativeOnWidth(sVGLength) : 0.0f;
        SVGLength sVGLength2 = this.mDy;
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, fRelativeOnWidth, sVGLength2 != null ? (float) relativeOnHeight(sVGLength2) : 0.0f);
        getSvgView().getCtm().mapRect(rectF);
        float fWidth = rectF.left;
        if (fWidth >= BitmapDescriptorFactory.HUE_RED) {
            fWidth = rectF.width();
        }
        float fHeight = rectF.top;
        if (fHeight >= BitmapDescriptorFactory.HUE_RED) {
            fHeight = rectF.height();
        }
        canvas.drawBitmap(source, fWidth, fHeight, (Paint) null);
        return bitmapCreateBitmap;
    }
}
