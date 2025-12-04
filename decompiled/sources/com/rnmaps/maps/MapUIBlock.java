package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import java.util.function.Function;

/* loaded from: classes4.dex */
public class MapUIBlock implements UIBlock, com.facebook.react.fabric.interop.UIBlock {
    private ReactApplicationContext context;
    private Function mapOperation;
    private Promise promise;
    private int tag;

    public MapUIBlock(int i, Promise promise, ReactApplicationContext reactApplicationContext, Function<MapView, Void> function) {
        this.tag = i;
        this.promise = promise;
        this.context = reactApplicationContext;
        this.mapOperation = function;
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        executeImpl(nativeViewHierarchyManager, null);
    }

    @Override // com.facebook.react.fabric.interop.UIBlock
    public void execute(UIBlockViewResolver uIBlockViewResolver) {
        executeImpl(null, uIBlockViewResolver);
    }

    private void executeImpl(NativeViewHierarchyManager nativeViewHierarchyManager, UIBlockViewResolver uIBlockViewResolver) {
        MapView mapView = (MapView) (uIBlockViewResolver != null ? uIBlockViewResolver.resolveView(this.tag) : nativeViewHierarchyManager.resolveView(this.tag));
        if (mapView == null) {
            this.promise.reject("AirMapView not found");
        } else if (mapView.map == null) {
            this.promise.reject("AirMapView.map is not valid");
        } else {
            this.mapOperation.apply(mapView);
        }
    }

    public void addToUIManager() {
        ((FabricUIManager) UIManagerHelper.getUIManager(this.context, 2)).addUIBlock(this);
    }
}
