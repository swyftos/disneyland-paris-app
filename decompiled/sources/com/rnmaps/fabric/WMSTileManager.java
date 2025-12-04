package com.rnmaps.fabric;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsWMSTileManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface;
import com.rnmaps.maps.MapWMSTile;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = WMSTileManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class WMSTileManager extends ViewGroupManager<MapWMSTile> implements RNMapsWMSTileManagerInterface<MapWMSTile> {
    public static final String REACT_CLASS = "RNMapsWMSTile";
    private final RNMapsWMSTileManagerDelegate<MapWMSTile, WMSTileManager> delegate;

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setShouldReplaceMapContent(MapWMSTile mapWMSTile, boolean z) {
    }

    public WMSTileManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsWMSTileManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapWMSTile> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapWMSTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapWMSTile(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setMaximumNativeZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMaximumNativeZ(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setMaximumZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMaximumZ(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setMinimumZ(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setMinimumZ(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setOfflineMode(MapWMSTile mapWMSTile, boolean z) {
        mapWMSTile.setOfflineMode(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setZIndex(@NonNull MapWMSTile mapWMSTile, float f) {
        super.setZIndex((WMSTileManager) mapWMSTile, f);
        mapWMSTile.setZIndex(f);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setOpacity(@NonNull MapWMSTile mapWMSTile, float f) {
        super.setOpacity((WMSTileManager) mapWMSTile, f);
        mapWMSTile.setOpacity(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setTileCacheMaxAge(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setTileCacheMaxAge(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setTileCachePath(MapWMSTile mapWMSTile, @Nullable String str) {
        mapWMSTile.setTileCachePath(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setTileSize(MapWMSTile mapWMSTile, int i) {
        mapWMSTile.setTileSize(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsWMSTileManagerInterface
    public void setUrlTemplate(MapWMSTile mapWMSTile, @Nullable String str) {
        mapWMSTile.setUrlTemplate(str);
    }
}
