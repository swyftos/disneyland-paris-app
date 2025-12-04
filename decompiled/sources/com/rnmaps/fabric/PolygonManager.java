package com.rnmaps.fabric;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface;
import com.rnmaps.maps.MapPolygon;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = PolygonManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class PolygonManager extends ViewGroupManager<MapPolygon> implements RNMapsGooglePolygonManagerInterface<MapPolygon> {
    public static final String REACT_CLASS = "RNMapsGooglePolygon";
    private final RNMapsGooglePolygonManagerDelegate<MapPolygon, PolygonManager> delegate;

    public PolygonManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsGooglePolygonManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapPolygon> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolygon createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolygon(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapPolygon.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setCoordinates(MapPolygon mapPolygon, @Nullable ReadableArray readableArray) {
        mapPolygon.setCoordinates(readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setFillColor(MapPolygon mapPolygon, @Nullable Integer num) {
        mapPolygon.setFillColor(num.intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setStrokeColor(MapPolygon mapPolygon, @Nullable Integer num) {
        mapPolygon.setStrokeColor(num.intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setGeodesic(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setGeodesic(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setHoles(MapPolygon mapPolygon, @Nullable ReadableArray readableArray) {
        mapPolygon.setHoles(readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsGooglePolygonManagerInterface
    public void setTappable(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setTappable(z);
    }
}
