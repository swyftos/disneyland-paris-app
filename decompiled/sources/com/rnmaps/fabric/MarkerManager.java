package com.rnmaps.fabric;

import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNMapsMarkerManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rnmaps.maps.MapCallout;
import com.rnmaps.maps.MapMarker;
import java.util.Map;

@ReactModule(name = MarkerManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class MarkerManager extends ViewGroupManager<MapMarker> implements RNMapsMarkerManagerInterface<MapMarker> {
    public static final String REACT_CLASS = "RNMapsMarker";
    private final RNMapsMarkerManagerDelegate<MapMarker, MarkerManager> delegate;

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void redraw(MapMarker mapMarker) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void redrawCallout(MapMarker mapMarker) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setCalloutAnchor(MapMarker mapMarker, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setCalloutOffset(MapMarker mapMarker, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setDisplayPriority(MapMarker mapMarker, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setIsPreselected(MapMarker mapMarker, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setSubtitleVisibility(MapMarker mapMarker, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setTitleVisibility(MapMarker mapMarker, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setUseLegacyPinView(MapMarker mapMarker, boolean z) {
    }

    public MarkerManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsMarkerManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapMarker> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapMarker createViewInstance(ThemedReactContext themedReactContext) {
        return new MapMarker(themedReactContext, null);
    }

    private MarkerOptions optionsForInitialProps(ReactStylesDiffMap reactStylesDiffMap) {
        MarkerOptions markerOptions = new MarkerOptions();
        if (reactStylesDiffMap != null) {
            if (reactStylesDiffMap.hasKey(ViewProps.OPACITY)) {
                markerOptions.alpha(reactStylesDiffMap.getFloat(ViewProps.OPACITY, 1.0f));
            }
            double d = 1.0d;
            double d2 = 0.5d;
            if (reactStylesDiffMap.hasKey("anchor")) {
                ReadableMap map = reactStylesDiffMap.getMap("anchor");
                markerOptions.anchor((float) ((map == null || !map.hasKey("x")) ? 0.5d : map.getDouble("x")), (float) ((map == null || !map.hasKey("y")) ? 1.0d : map.getDouble("y")));
            }
            if (reactStylesDiffMap.hasKey("coordinate")) {
                ReadableMap map2 = reactStylesDiffMap.getMap("coordinate");
                markerOptions.position(new LatLng(map2.getDouble("latitude"), map2.getDouble("longitude")));
            }
            if (reactStylesDiffMap.hasKey("title")) {
                markerOptions.title(reactStylesDiffMap.getString("title"));
            }
            if (reactStylesDiffMap.hasKey("description")) {
                markerOptions.snippet(reactStylesDiffMap.getString("description"));
            }
            if (reactStylesDiffMap.hasKey("draggable")) {
                markerOptions.draggable(reactStylesDiffMap.getBoolean("draggable", false));
            }
            if (reactStylesDiffMap.hasKey("rotation")) {
                markerOptions.rotation(reactStylesDiffMap.getFloat("rotation", BitmapDescriptorFactory.HUE_RED));
            }
            if (reactStylesDiffMap.hasKey("flat")) {
                markerOptions.flat(reactStylesDiffMap.getBoolean("flat", false));
            }
            if (reactStylesDiffMap.hasKey("calloutAnchor")) {
                ReadableMap map3 = reactStylesDiffMap.getMap("calloutAnchor");
                if (map3 != null && map3.hasKey("x")) {
                    d2 = map3.getDouble("x");
                }
                float f = (float) d2;
                if (map3 != null && map3.hasKey("y")) {
                    d = map3.getDouble("y");
                }
                markerOptions.infoWindowAnchor(f, (float) d);
            }
            if (reactStylesDiffMap.hasKey(ViewProps.Z_INDEX)) {
                markerOptions.zIndex(reactStylesDiffMap.getFloat(ViewProps.Z_INDEX, BitmapDescriptorFactory.HUE_RED));
            }
        }
        return markerOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapMarker createViewInstance(int i, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Object objUpdateState;
        MapMarker mapMarker = new MapMarker(themedReactContext, optionsForInitialProps(reactStylesDiffMap), null);
        mapMarker.setId(i);
        addEventEmitters(themedReactContext, mapMarker);
        if (reactStylesDiffMap != null) {
            updateProperties(mapMarker, reactStylesDiffMap);
        }
        if (stateWrapper != null && (objUpdateState = updateState(mapMarker, reactStylesDiffMap, stateWrapper)) != null) {
            updateExtraData((MarkerManager) mapMarker, objUpdateState);
        }
        return mapMarker;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapMarker.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapMarker.getExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setAnchor(MapMarker mapMarker, @Nullable ReadableMap readableMap) {
        mapMarker.setAnchor((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 1.0d : readableMap.getDouble("y"));
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setImage(MapMarker mapMarker, @Nullable ReadableMap readableMap) {
        mapMarker.setImage(readableMap.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI));
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setCoordinate(MapMarker mapMarker, @Nullable ReadableMap readableMap) {
        mapMarker.setCoordinate(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setDescription(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setSnippet(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setDraggable(MapMarker mapMarker, boolean z) {
        mapMarker.setDraggable(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setTitle(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setTitle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setIdentifier(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setIdentifier(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setOpacity(MapMarker mapMarker, double d) {
        mapMarker.setOpacity((float) d);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setPinColor(MapMarker mapMarker, @Nullable Integer num) {
        float[] fArr = new float[3];
        Color.colorToHSV(num.intValue(), fArr);
        mapMarker.setMarkerHue(fArr[0]);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void animateToCoordinates(MapMarker mapMarker, double d, double d2, int i) {
        mapMarker.animateToCoodinate(new LatLng(d, d2), Integer.valueOf(i));
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void setCoordinates(MapMarker mapMarker, double d, double d2) {
        mapMarker.setCoordinate(new LatLng(d, d2));
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void showCallout(MapMarker mapMarker) {
        ((Marker) mapMarker.getFeature()).showInfoWindow();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface
    public void hideCallout(MapMarker mapMarker) {
        ((Marker) mapMarker.getFeature()).hideInfoWindow();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapMarker mapMarker, View view, int i) {
        if (view instanceof MapCallout) {
            mapMarker.setCalloutView((MapCallout) view);
        } else {
            super.addView((MarkerManager) mapMarker, view, i);
            mapMarker.update(true);
        }
    }
}
