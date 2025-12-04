package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

/* loaded from: classes4.dex */
public class MapPolygonManager extends ViewGroupManager<MapPolygon> {
    private final DisplayMetrics metrics;

    public MapPolygonManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapPolygon";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolygon createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolygon(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setCoordinates(readableArray);
    }

    @ReactProp(name = "holes")
    public void setHoles(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setHoles(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolygon mapPolygon, float f) {
        mapPolygon.setStrokeWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = SupportMenu.CATEGORY_MASK, name = "fillColor")
    public void setFillColor(MapPolygon mapPolygon, int i) {
        mapPolygon.setFillColor(i);
    }

    @ReactProp(customType = "Color", defaultInt = SupportMenu.CATEGORY_MASK, name = "strokeColor")
    public void setStrokeColor(MapPolygon mapPolygon, int i) {
        mapPolygon.setStrokeColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setTappable(z);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setGeodesic(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.Z_INDEX)
    public void setZIndex(MapPolygon mapPolygon, float f) {
        mapPolygon.setZIndex(f);
    }

    @ReactProp(name = "lineDashPattern")
    public void setLineDashPattern(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setLineDashPattern(readableArray);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
