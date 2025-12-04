package com.rnmaps.fabric;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsPolylineManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface;
import com.rnmaps.maps.MapPolyline;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = PolylineManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class PolylineManager extends ViewGroupManager<MapPolyline> implements RNMapsPolylineManagerInterface<MapPolyline> {
    public static final String REACT_CLASS = "RNMapsPolyline";
    private final RNMapsPolylineManagerDelegate<MapPolyline, PolylineManager> delegate;
    private DisplayMetrics metrics;

    public PolylineManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsPolylineManagerDelegate<>(this);
        this.metrics = new DisplayMetrics();
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(this.metrics);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapPolyline> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolyline(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapPolyline.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setCoordinates(MapPolyline mapPolyline, @Nullable ReadableArray readableArray) {
        mapPolyline.setCoordinates(readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setStrokeColor(MapPolyline mapPolyline, @Nullable Integer num) {
        mapPolyline.setColor(num.intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setStrokeColors(MapPolyline mapPolyline, @Nullable ReadableArray readableArray) {
        mapPolyline.setStrokeColors(readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setStrokeWidth(MapPolyline mapPolyline, float f) {
        mapPolyline.setWidth(this.metrics.density * f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setGeodesic(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setGeodesic(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setLineCap(MapPolyline mapPolyline, @Nullable String str) {
        mapPolyline.setLineCap(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setLineDashPattern(MapPolyline mapPolyline, @Nullable ReadableArray readableArray) {
        mapPolyline.setLineDashPattern(readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setLineJoin(MapPolyline mapPolyline, @Nullable String str) {
        mapPolyline.setLineJoin(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsPolylineManagerInterface
    public void setTappable(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setTappable(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setZIndex(MapPolyline mapPolyline, float f) {
        mapPolyline.setZIndex(f);
    }
}
