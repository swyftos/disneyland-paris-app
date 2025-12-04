package com.rnmaps.maps;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.urbanairship.push.PushMessage;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public class MapManager extends ViewGroupManager<MapView> {
    public static final Map<String, Integer> MY_LOCATION_PRIORITY = MapBuilder.of("balanced", 102, PushMessage.PRIORITY_HIGH, 100, "low", 104, "passive", 105);
    private static final String REACT_CLASS = "AIRMap";
    private final Map<String, Integer> MAP_TYPES = MapBuilder.of(Constants.COLLATION_STANDARD, 1, "satellite", 2, "hybrid", 4, "terrain", 3, "none", 0);
    private final ReactApplicationContext appContext;
    protected GoogleMapOptions googleMapOptions;
    private MapMarkerManager markerManager;
    protected MapsInitializer.Renderer renderer;

    @ReactProp(name = "googleRenderer")
    public void setGoogleRenderer(MapView mapView, @Nullable String str) {
    }

    public MapManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
    }

    public MapMarkerManager getMarkerManager() {
        return this.markerManager;
    }

    public void setMarkerManager(MapMarkerManager mapMarkerManager) {
        this.markerManager = mapMarkerManager;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new MapView(themedReactContext, this.appContext, this, this.googleMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(int i, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        CameraPosition cameraPositionCameraPositionFromMap;
        this.googleMapOptions = new GoogleMapOptions();
        if (reactStylesDiffMap != null) {
            if (reactStylesDiffMap.getString("googleMapId") != null) {
                this.googleMapOptions.mapId(reactStylesDiffMap.getString("googleMapId"));
            }
            if (reactStylesDiffMap.hasKey("liteMode")) {
                this.googleMapOptions.liteMode(reactStylesDiffMap.getBoolean("liteMode", false));
            }
            if (reactStylesDiffMap.hasKey("initialCamera")) {
                CameraPosition cameraPositionCameraPositionFromMap2 = MapView.cameraPositionFromMap(reactStylesDiffMap.getMap("initialCamera"));
                if (cameraPositionCameraPositionFromMap2 != null) {
                    this.googleMapOptions.camera(cameraPositionCameraPositionFromMap2);
                }
            } else if (reactStylesDiffMap.hasKey("camera") && (cameraPositionCameraPositionFromMap = MapView.cameraPositionFromMap(reactStylesDiffMap.getMap("camera"))) != null) {
                this.googleMapOptions.camera(cameraPositionCameraPositionFromMap);
            }
            if (reactStylesDiffMap.hasKey("googleRenderer") && "LEGACY".equals(reactStylesDiffMap.getString("googleRenderer"))) {
                this.renderer = MapsInitializer.Renderer.LEGACY;
            } else {
                this.renderer = MapsInitializer.Renderer.LATEST;
            }
        }
        return (MapView) super.createViewInstance(i, themedReactContext, reactStylesDiffMap, stateWrapper);
    }

    private void emitMapError(ThemedReactContext themedReactContext, String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("message", str);
        writableMapCreateMap.putString("type", str2);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) themedReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(PDFView.EVENT_ON_ERROR, writableMapCreateMap);
    }

    @ReactProp(name = "region")
    public void setRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setRegion(readableMap);
    }

    @ReactProp(defaultBoolean = false, name = "liteMode")
    public void setLiteMode(MapView mapView, boolean z) {
        this.googleMapOptions.liteMode(z);
    }

    @ReactProp(name = "googleMapId")
    public void setGoogleMapId(MapView mapView, @Nullable String str) {
        if (str != null) {
            this.googleMapOptions.mapId(str);
        }
    }

    @ReactProp(name = "initialRegion")
    public void setInitialRegion(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialRegion(readableMap);
    }

    @ReactProp(name = "camera")
    public void setCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setCamera(readableMap);
    }

    @ReactProp(name = "initialCamera")
    public void setInitialCamera(MapView mapView, ReadableMap readableMap) {
        mapView.setInitialCamera(readableMap);
    }

    @ReactProp(name = "mapType")
    public void setMapType(MapView mapView, @Nullable String str) {
        mapView.map.setMapType(this.MAP_TYPES.get(str).intValue());
    }

    @ReactProp(name = "customMapStyleString")
    public void setMapStyle(MapView mapView, @Nullable String str) {
        mapView.setMapStyle(str);
    }

    @ReactProp(name = "mapPadding")
    public void setMapPadding(MapView mapView, @Nullable ReadableMap readableMap) {
        int i;
        int i2;
        int i3;
        double d = mapView.getResources().getDisplayMetrics().density;
        if (readableMap != null) {
            int i4 = readableMap.hasKey(ViewProps.LEFT) ? (int) (readableMap.getDouble(ViewProps.LEFT) * d) : 0;
            i2 = readableMap.hasKey(ViewProps.TOP) ? (int) (readableMap.getDouble(ViewProps.TOP) * d) : 0;
            i3 = readableMap.hasKey(ViewProps.RIGHT) ? (int) (readableMap.getDouble(ViewProps.RIGHT) * d) : 0;
            i = readableMap.hasKey(ViewProps.BOTTOM) ? (int) (readableMap.getDouble(ViewProps.BOTTOM) * d) : 0;
            i = i4;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        mapView.applyBaseMapPadding(i, i2, i3, i);
        mapView.map.setPadding(i, i2, i3, i);
    }

    @ReactProp(defaultBoolean = false, name = "showsUserLocation")
    public void setShowsUserLocation(MapView mapView, boolean z) {
        mapView.setShowsUserLocation(z);
    }

    @ReactProp(name = "userLocationPriority")
    public void setUserLocationPriority(MapView mapView, @Nullable String str) {
        mapView.setUserLocationPriority(MY_LOCATION_PRIORITY.get(str).intValue());
    }

    @ReactProp(defaultInt = 5000, name = "userLocationUpdateInterval")
    public void setUserLocationUpdateInterval(MapView mapView, int i) {
        mapView.setUserLocationUpdateInterval(i);
    }

    @ReactProp(defaultInt = 5000, name = "userLocationFastestInterval")
    public void setUserLocationFastestInterval(MapView mapView, int i) {
        mapView.setUserLocationFastestInterval(i);
    }

    @ReactProp(defaultBoolean = true, name = "showsMyLocationButton")
    public void setShowsMyLocationButton(MapView mapView, boolean z) {
        mapView.setShowsMyLocationButton(z);
    }

    @ReactProp(defaultBoolean = true, name = "toolbarEnabled")
    public void setToolbarEnabled(MapView mapView, boolean z) {
        mapView.setToolbarEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "handlePanDrag")
    public void setHandlePanDrag(MapView mapView, boolean z) {
        mapView.setHandlePanDrag(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsTraffic")
    public void setShowTraffic(MapView mapView, boolean z) {
        mapView.map.setTrafficEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsBuildings")
    public void setShowBuildings(MapView mapView, boolean z) {
        mapView.setShowBuildings(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoors")
    public void setShowIndoors(MapView mapView, boolean z) {
        mapView.setShowIndoors(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsIndoorLevelPicker")
    public void setShowsIndoorLevelPicker(MapView mapView, boolean z) {
        mapView.setShowsIndoorLevelPicker(z);
    }

    @ReactProp(defaultBoolean = false, name = "showsCompass")
    public void setShowsCompass(MapView mapView, boolean z) {
        mapView.setShowsCompass(z);
    }

    @ReactProp(defaultBoolean = false, name = "scrollEnabled")
    public void setScrollEnabled(MapView mapView, boolean z) {
        mapView.setScrollEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "zoomEnabled")
    public void setZoomEnabled(MapView mapView, boolean z) {
        mapView.setZoomEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "zoomControlEnabled")
    public void setZoomControlEnabled(MapView mapView, boolean z) {
        mapView.setZoomControlEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "rotateEnabled")
    public void setRotateEnabled(MapView mapView, boolean z) {
        mapView.setRotateEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "scrollDuringRotateOrZoomEnabled")
    public void setScrollDuringRotateOrZoomEnabled(MapView mapView, boolean z) {
        mapView.setScrollDuringRotateOrZoomEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "cacheEnabled")
    public void setCacheEnabled(MapView mapView, boolean z) {
        mapView.setCacheEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "poiClickEnabled")
    public void setPoiClickEnabled(MapView mapView, boolean z) {
        mapView.setPoiClickEnabled(z);
    }

    @ReactProp(defaultBoolean = false, name = "loadingEnabled")
    public void setLoadingEnabled(MapView mapView, boolean z) {
        mapView.setLoadingEnabled(z);
    }

    @ReactProp(defaultBoolean = true, name = "moveOnMarkerPress")
    public void setMoveOnMarkerPress(MapView mapView, boolean z) {
        mapView.setMoveOnMarkerPress(z);
    }

    @ReactProp(customType = "Color", name = "loadingBackgroundColor")
    public void setLoadingBackgroundColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingBackgroundColor(num);
    }

    @ReactProp(customType = "Color", name = "loadingIndicatorColor")
    public void setLoadingIndicatorColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingIndicatorColor(num);
    }

    @ReactProp(defaultBoolean = false, name = "pitchEnabled")
    public void setPitchEnabled(MapView mapView, boolean z) {
        mapView.setPitchEnabled(z);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(MapView mapView, float f) {
        mapView.setMinZoomLevel(f);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(MapView mapView, float f) {
        mapView.setMaxZoomLevel(f);
    }

    @ReactProp(name = "kmlSrc")
    public void setKmlSrc(MapView mapView, String str) throws ExecutionException, InterruptedException {
        if (str != null) {
            mapView.setKmlSrc(str);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = ViewProps.ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(MapView mapView, @Nullable String str) {
        mapView.setTag(com.facebook.react.R.id.accessibility_label, str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull MapView mapView, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "fitToSuppliedMarkers":
                if (readableArray != null) {
                    mapView.fitToSuppliedMarkers(readableArray.getArray(0), readableArray.getMap(1), readableArray.getBoolean(2));
                    break;
                }
                break;
            case "setIndoorActiveLevelIndex":
                if (readableArray != null) {
                    mapView.setIndoorActiveLevelIndex(readableArray.getInt(0));
                    break;
                }
                break;
            case "setCamera":
                if (readableArray != null) {
                    mapView.animateToCamera(readableArray.getMap(0), 0);
                    break;
                }
                break;
            case "setMapBoundaries":
                if (readableArray != null) {
                    mapView.setMapBoundaries(readableArray.getMap(0), readableArray.getMap(1));
                    break;
                }
                break;
            case "fitToElements":
                if (readableArray != null) {
                    mapView.fitToElements(readableArray.getMap(0), readableArray.getBoolean(1));
                    break;
                }
                break;
            case "animateCamera":
                if (readableArray != null) {
                    mapView.animateToCamera(readableArray.getMap(0), readableArray.getInt(1));
                    break;
                }
                break;
            case "animateToRegion":
                if (readableArray != null) {
                    ReadableMap map = readableArray.getMap(0);
                    int i = readableArray.getInt(1);
                    double d = map.getDouble("longitude");
                    double d2 = map.getDouble("latitude");
                    double d3 = map.getDouble("longitudeDelta");
                    double d4 = map.getDouble("latitudeDelta") / 2.0d;
                    double d5 = d3 / 2.0d;
                    mapView.animateToRegion(new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d2 + d4, d + d5)), i);
                    break;
                }
                break;
            case "fitToCoordinates":
                if (readableArray != null) {
                    mapView.fitToCoordinates(readableArray.getArray(0), readableArray.getMap(1), readableArray.getBoolean(2));
                    break;
                }
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map mapOf = MapBuilder.of("onMapReady", MapBuilder.of("registrationName", "onMapReady"), "onPress", MapBuilder.of("registrationName", "onPress"), "onLongPress", MapBuilder.of("registrationName", "onLongPress"), "onMarkerPress", MapBuilder.of("registrationName", "onMarkerPress"), "onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress"));
        mapOf.putAll(MapBuilder.of("onUserLocationChange", MapBuilder.of("registrationName", "onUserLocationChange"), "onMarkerDragStart", MapBuilder.of("registrationName", "onMarkerDragStart"), "onMarkerDrag", MapBuilder.of("registrationName", "onMarkerDrag"), "onMarkerDragEnd", MapBuilder.of("registrationName", "onMarkerDragEnd"), "onPanDrag", MapBuilder.of("registrationName", "onPanDrag"), "onKmlReady", MapBuilder.of("registrationName", "onKmlReady"), "onPoiClick", MapBuilder.of("registrationName", "onPoiClick")));
        mapOf.putAll(MapBuilder.of("onIndoorLevelActivated", MapBuilder.of("registrationName", "onIndoorLevelActivated"), "onIndoorBuildingFocused", MapBuilder.of("registrationName", "onIndoorBuildingFocused"), "onDoublePress", MapBuilder.of("registrationName", "onDoublePress"), "onMapLoaded", MapBuilder.of("registrationName", "onMapLoaded"), "onMarkerSelect", MapBuilder.of("registrationName", "onMarkerSelect"), "onMarkerDeselect", MapBuilder.of("registrationName", "onMarkerDeselect"), "onRegionChangeStart", MapBuilder.of("registrationName", "onRegionChangeStart")));
        return mapOf;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapView mapView, View view, int i) {
        mapView.addFeature(view, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(MapView mapView) {
        return mapView.getFeatureCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(MapView mapView, int i) {
        return mapView.getFeatureAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapView mapView, int i) {
        mapView.removeFeatureAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapView mapView, Object obj) {
        mapView.updateExtraData(obj);
    }

    void pushEvent(ThemedReactContext themedReactContext, View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) themedReactContext.getReactApplicationContext().getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), str, writableMap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(MapView mapView) {
        mapView.doDestroy();
        super.onDropViewInstance((MapManager) mapView);
    }
}
