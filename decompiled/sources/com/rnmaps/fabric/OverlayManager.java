package com.rnmaps.fabric;

import androidx.annotation.Nullable;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsOverlayManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsOverlayManagerInterface;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.rnmaps.maps.MapOverlay;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = OverlayManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class OverlayManager extends ViewGroupManager<MapOverlay> implements RNMapsOverlayManagerInterface<MapOverlay> {
    public static final String REACT_CLASS = "RNMapsOverlay";
    private final RNMapsOverlayManagerDelegate<MapOverlay, OverlayManager> delegate;

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setOpacity(MapOverlay mapOverlay, float f) {
    }

    public OverlayManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsOverlayManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapOverlay> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapOverlay createViewInstance(ThemedReactContext themedReactContext) {
        return new MapOverlay(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapOverlay.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setZIndex(MapOverlay mapOverlay, float f) {
        mapOverlay.setZIndex(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsOverlayManagerInterface
    public void setBearing(MapOverlay mapOverlay, float f) {
        mapOverlay.setBearing(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsOverlayManagerInterface
    public void setBounds(MapOverlay mapOverlay, @Nullable ReadableMap readableMap) {
        mapOverlay.setBounds(new LatLngBounds(new LatLng(readableMap.getMap("southWest").getDouble("latitude"), readableMap.getMap("southWest").getDouble("longitude")), new LatLng(readableMap.getMap("northEast").getDouble("latitude"), readableMap.getMap("northEast").getDouble("longitude"))));
    }

    @Override // com.facebook.react.viewmanagers.RNMapsOverlayManagerInterface
    public void setImage(MapOverlay mapOverlay, @Nullable ReadableMap readableMap) throws NumberFormatException {
        if (readableMap != null) {
            mapOverlay.setImage(readableMap.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI));
        }
    }

    @Override // com.facebook.react.viewmanagers.RNMapsOverlayManagerInterface
    public void setTappable(MapOverlay mapOverlay, boolean z) {
        mapOverlay.setTappable(z);
    }
}
