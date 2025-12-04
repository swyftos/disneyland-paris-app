package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FilterPrimitiveView extends DefinitionView {
    public final FilterRegion mFilterSubregion;
    private String mResult;

    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        return null;
    }

    @Override // com.horcrux.svg.VirtualView
    void saveDefinition() {
    }

    public FilterPrimitiveView(ReactContext reactContext) {
        super(reactContext);
        this.mFilterSubregion = new FilterRegion();
    }

    public void setX(Dynamic dynamic) {
        this.mFilterSubregion.setX(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mFilterSubregion.setY(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mFilterSubregion.setWidth(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mFilterSubregion.setHeight(dynamic);
        invalidate();
    }

    public void setResult(String str) {
        this.mResult = str;
        invalidate();
    }

    public String getResult() {
        return this.mResult;
    }

    protected static Bitmap getSource(HashMap<String, Bitmap> map, Bitmap bitmap, String str) {
        Bitmap bitmap2 = str != null ? map.get(str) : null;
        return bitmap2 != null ? bitmap2 : bitmap;
    }
}
