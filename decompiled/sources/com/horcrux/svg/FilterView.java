package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FilterView extends DefinitionView {
    private final FilterRegion mFilterRegion;
    private FilterProperties.Units mFilterUnits;
    private FilterProperties.Units mPrimitiveUnits;
    private final HashMap<String, Bitmap> mResultsMap;

    public FilterView(ReactContext reactContext) {
        super(reactContext);
        this.mResultsMap = new HashMap<>();
        this.mFilterRegion = new FilterRegion();
    }

    public void setX(Dynamic dynamic) {
        this.mFilterRegion.setX(dynamic);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mFilterRegion.setY(dynamic);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mFilterRegion.setWidth(dynamic);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mFilterRegion.setHeight(dynamic);
        invalidate();
    }

    public void setFilterUnits(String str) {
        this.mFilterUnits = FilterProperties.Units.getEnum(str);
        invalidate();
    }

    public void setPrimitiveUnits(String str) {
        this.mPrimitiveUnits = FilterProperties.Units.getEnum(str);
        invalidate();
    }

    public FilterRegion getFilterRegion() {
        return this.mFilterRegion;
    }

    @Override // com.horcrux.svg.VirtualView
    void saveDefinition() {
        SvgView svgView;
        if (this.mName == null || (svgView = getSvgView()) == null) {
            return;
        }
        svgView.defineFilter(this, this.mName);
    }

    public Bitmap applyFilter(Bitmap bitmap, Bitmap bitmap2, RectF rectF) {
        this.mResultsMap.clear();
        this.mResultsMap.put("SourceGraphic", bitmap);
        this.mResultsMap.put("SourceAlpha", FilterUtils.applySourceAlphaFilter(bitmap));
        this.mResultsMap.put("BackgroundImage", bitmap2);
        this.mResultsMap.put("BackgroundAlpha", FilterUtils.applySourceAlphaFilter(bitmap2));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect cropRect = this.mFilterRegion.getCropRect(this, this.mFilterUnits, rectF);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof FilterPrimitiveView) {
                FilterPrimitiveView filterPrimitiveView = (FilterPrimitiveView) childAt;
                bitmapCreateBitmap.eraseColor(0);
                FilterRegion filterRegion = filterPrimitiveView.mFilterSubregion;
                FilterProperties.Units units = this.mPrimitiveUnits;
                Rect cropRect2 = filterRegion.getCropRect(filterPrimitiveView, units, units == FilterProperties.Units.USER_SPACE_ON_USE ? new RectF(cropRect) : rectF);
                canvas.drawBitmap(filterPrimitiveView.applyFilter(this.mResultsMap, bitmap), cropRect2, cropRect2, (Paint) null);
                bitmap = bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true);
                String result = filterPrimitiveView.getResult();
                if (result != null) {
                    this.mResultsMap.put(result, bitmap);
                }
            } else {
                Log.e("RNSVG", "Invalid `Filter` child: Filter children can only be `Fe...` components");
            }
        }
        bitmapCreateBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, cropRect, cropRect, (Paint) null);
        return bitmapCreateBitmap;
    }
}
