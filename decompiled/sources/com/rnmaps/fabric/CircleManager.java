package com.rnmaps.fabric;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsCircleManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsCircleManagerInterface;
import com.rnmaps.maps.MapCircle;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = CircleManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class CircleManager extends ViewGroupManager<MapCircle> implements RNMapsCircleManagerInterface<MapCircle> {
    public static final String REACT_CLASS = "RNMapsCircle";
    private final RNMapsCircleManagerDelegate<MapCircle, CircleManager> delegate;

    public CircleManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsCircleManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapCircle> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapCircle createViewInstance(ThemedReactContext themedReactContext) {
        return new MapCircle(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapCircle.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setZIndex(MapCircle mapCircle, float f) {
        mapCircle.setZIndex(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setCenter(MapCircle mapCircle, @Nullable ReadableMap readableMap) {
        mapCircle.setCenter(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setFillColor(MapCircle mapCircle, @Nullable Integer num) {
        mapCircle.setFillColor(num.intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setRadius(MapCircle mapCircle, double d) {
        mapCircle.setRadius(d);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setStrokeColor(MapCircle mapCircle, @Nullable Integer num) {
        mapCircle.setStrokeColor(num.intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setStrokeWidth(MapCircle mapCircle, float f) {
        mapCircle.setStrokeWidth(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCircleManagerInterface
    public void setTappable(MapCircle mapCircle, boolean z) {
        mapCircle.setTappable(z);
    }
}
