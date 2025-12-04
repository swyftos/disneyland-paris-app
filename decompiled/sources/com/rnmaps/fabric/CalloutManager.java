package com.rnmaps.fabric;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsCalloutManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsCalloutManagerInterface;
import com.rnmaps.maps.MapCallout;
import com.rnmaps.maps.SizeReportingShadowNode;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = CalloutManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class CalloutManager extends ViewGroupManager<MapCallout> implements RNMapsCalloutManagerInterface<MapCallout> {
    public static final String REACT_CLASS = "RNMapsCallout";
    private final RNMapsCalloutManagerDelegate<MapCallout, CalloutManager> delegate;

    @Override // com.facebook.react.viewmanagers.RNMapsCalloutManagerInterface
    public void setAlphaHitTest(MapCallout mapCallout, boolean z) {
    }

    public CalloutManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsCalloutManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapCallout> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapCallout createViewInstance(ThemedReactContext themedReactContext) {
        return new MapCallout(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapCallout.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return new HashMap();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsCalloutManagerInterface
    public void setTooltip(MapCallout mapCallout, boolean z) {
        mapCallout.setTooltip(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }
}
