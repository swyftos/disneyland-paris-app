package com.rnmaps.maps;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* loaded from: classes4.dex */
public class MapUrlTileManager extends ViewGroupManager<MapUrlTile> {
    public MapUrlTileManager(ReactApplicationContext reactApplicationContext) {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapUrlTile";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapUrlTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapUrlTile(themedReactContext);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setUrlTemplate(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = GroundOverlayOptions.NO_DIMENSION, name = ViewProps.Z_INDEX)
    public void setZIndex(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setZIndex(f);
    }

    @ReactProp(defaultInt = 0, name = "minimumZ")
    public void setMinimumZ(MapUrlTile mapUrlTile, int i) {
        mapUrlTile.setMinimumZ(i);
    }

    @ReactProp(defaultInt = 100, name = "maximumZ")
    public void setMaximumZ(MapUrlTile mapUrlTile, int i) {
        mapUrlTile.setMaximumZ(i);
    }

    @ReactProp(defaultInt = 100, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapUrlTile mapUrlTile, int i) {
        mapUrlTile.setMaximumNativeZ(i);
    }

    @ReactProp(defaultBoolean = false, name = "flipY")
    public void setFlipY(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setFlipY(z);
    }

    @ReactProp(defaultInt = 256, name = "tileSize")
    public void setTileSize(MapUrlTile mapUrlTile, int i) {
        mapUrlTile.setTileSize(i);
    }

    @ReactProp(defaultBoolean = false, name = "doubleTileSize")
    public void setDoubleTileSize(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setDoubleTileSize(z);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setTileCachePath(str);
    }

    @ReactProp(defaultInt = 0, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapUrlTile mapUrlTile, int i) {
        mapUrlTile.setTileCacheMaxAge(i);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setOfflineMode(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.OPACITY)
    public void setOpacity(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setOpacity(f);
    }
}
