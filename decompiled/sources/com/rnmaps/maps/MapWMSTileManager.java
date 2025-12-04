package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* loaded from: classes4.dex */
public class MapWMSTileManager extends ViewGroupManager<MapWMSTile> {
    public MapWMSTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapWMSTile";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapWMSTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapWMSTile(themedReactContext);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setUrlTemplate(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = GroundOverlayOptions.NO_DIMENSION, name = ViewProps.Z_INDEX)
    public void setZIndex(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setZIndex(f);
    }

    @ReactProp(defaultInt = 0, name = "minimumZ")
    public void setMinimumZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMinimumZ(i);
    }

    @ReactProp(defaultInt = 100, name = "maximumZ")
    public void setMaximumZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMaximumZ(i);
    }

    @ReactProp(defaultInt = 100, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMaximumNativeZ(i);
    }

    @ReactProp(defaultInt = 256, name = "tileSize")
    public void setTileSize(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setTileSize(i);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setTileCachePath(str);
    }

    @ReactProp(defaultInt = 0, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setTileCacheMaxAge(i);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapWMSTile mapWMSTile, boolean z) {
        mapWMSTile.setOfflineMode(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.OPACITY)
    public void setOpacity(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setOpacity(f);
    }
}
