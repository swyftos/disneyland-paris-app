package com.rnmaps.maps;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticBackport2;
import com.facebook.fbreact.specs.NativeAirMapsModuleSpec;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.rnmaps.fabric.CalloutManager;
import com.rnmaps.fabric.CircleManager;
import com.rnmaps.fabric.MapViewManager;
import com.rnmaps.fabric.MarkerManager;
import com.rnmaps.fabric.NativeAirMapsModule;
import com.rnmaps.fabric.OverlayManager;
import com.rnmaps.fabric.PolygonManager;
import com.rnmaps.fabric.PolylineManager;
import com.rnmaps.fabric.UrlTileManager;
import com.rnmaps.fabric.WMSTileManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class MapsPackage extends BaseReactPackage implements ReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return ImageAnalysis$$ExternalSyntheticBackport2.m(new ViewManager[]{new MapViewManager(reactApplicationContext), new MarkerManager(reactApplicationContext), new CalloutManager(reactApplicationContext), new PolygonManager(reactApplicationContext), new PolylineManager(reactApplicationContext), new CircleManager(reactApplicationContext), new OverlayManager(reactApplicationContext), new UrlTileManager(reactApplicationContext), new WMSTileManager(reactApplicationContext), new MapGradientPolylineManager(reactApplicationContext), new MapLocalTileManager(reactApplicationContext), new MapHeatmapManager()});
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (OverlayManager.REACT_CLASS.equals(str)) {
            return new OverlayManager(reactApplicationContext);
        }
        if (CircleManager.REACT_CLASS.equals(str)) {
            return new CircleManager(reactApplicationContext);
        }
        if (PolylineManager.REACT_CLASS.equals(str)) {
            return new PolylineManager(reactApplicationContext);
        }
        if (PolygonManager.REACT_CLASS.equals(str)) {
            return new PolygonManager(reactApplicationContext);
        }
        if (CalloutManager.REACT_CLASS.equals(str)) {
            return new CalloutManager(reactApplicationContext);
        }
        if (MarkerManager.REACT_CLASS.equals(str)) {
            return new MarkerManager(reactApplicationContext);
        }
        if (MapViewManager.REACT_CLASS.equals(str)) {
            return new MapViewManager(reactApplicationContext);
        }
        if (UrlTileManager.REACT_CLASS.equals(str)) {
            return new UrlTileManager(reactApplicationContext);
        }
        if (WMSTileManager.REACT_CLASS.equals(str)) {
            return new WMSTileManager(reactApplicationContext);
        }
        if (NativeAirMapsModuleSpec.NAME.equals(str)) {
            return new NativeAirMapsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.rnmaps.maps.MapsPackage.1
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public Map getReactModuleInfos() {
                HashMap map = new HashMap();
                map.put(NativeAirMapsModuleSpec.NAME, new ReactModuleInfo(NativeAirMapsModuleSpec.NAME, NativeAirMapsModuleSpec.NAME, false, false, false, true));
                return map;
            }
        };
    }
}
