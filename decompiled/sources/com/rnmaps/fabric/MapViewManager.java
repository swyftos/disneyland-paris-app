package com.rnmaps.fabric;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNMapsMapViewManagerDelegate;
import com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapsSdkInitializedCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.rnmaps.maps.MapManager;
import com.rnmaps.maps.MapMarker;
import com.rnmaps.maps.MapView;
import com.rnmaps.maps.SizeReportingShadowNode;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = MapViewManager.REACT_CLASS)
/* loaded from: classes4.dex */
public class MapViewManager extends ViewGroupManager<MapView> implements RNMapsMapViewManagerInterface<MapView> {
    public static final String REACT_CLASS = "RNMapsMapView";
    private static boolean rendererInitialized = false;
    private final RNMapsMapViewManagerDelegate<MapView, MapViewManager> delegate;

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCameraZoomRange(MapView mapView, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCompassOffset(MapView mapView, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setFollowsUserLocation(MapView mapView, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setGoogleMapId(MapView mapView, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setLegalLabelInsets(MapView mapView, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setLiteMode(MapView mapView, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMaxDelta(MapView mapView, double d) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMinDelta(MapView mapView, double d) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setPaddingAdjustmentBehavior(MapView mapView, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsScale(MapView mapView, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setTintColor(MapView mapView, @Nullable Integer num) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserInterfaceStyle(MapView mapView, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserLocationAnnotationTitle(MapView mapView, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserLocationCalloutEnabled(MapView mapView, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setZoomTapEnabled(MapView mapView, boolean z) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected void setupViewRecycling() {
    }

    public MapViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNMapsMapViewManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<MapView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(ThemedReactContext themedReactContext) {
        return new MapView(themedReactContext, new GoogleMapOptions());
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

    private GoogleMapOptions optionsForInitialProps(ReactStylesDiffMap reactStylesDiffMap) {
        CameraPosition cameraPositionCameraPositionFromMap;
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (reactStylesDiffMap != null) {
            setGoogleRenderer((MapView) null, reactStylesDiffMap.getString("googleRenderer"));
            if (reactStylesDiffMap.hasKey("liteMode")) {
                googleMapOptions.liteMode(reactStylesDiffMap.getBoolean("liteMode", false));
            }
            if (reactStylesDiffMap.hasKey("googleMapId")) {
                googleMapOptions.mapId(reactStylesDiffMap.getString("googleMapId"));
            }
            if (reactStylesDiffMap.getMap("initialCamera") != null && (cameraPositionCameraPositionFromMap = MapView.cameraPositionFromMap(reactStylesDiffMap.getMap("initialCamera"))) != null) {
                googleMapOptions.camera(cameraPositionCameraPositionFromMap);
            }
            if (reactStylesDiffMap.hasKey("mapType") && reactStylesDiffMap.getString("mapType") != null) {
                googleMapOptions.mapType(mapTypeFromStrValue(reactStylesDiffMap.getString("mapType")));
            }
            if (reactStylesDiffMap.hasKey("minZoom") && reactStylesDiffMap.getInt("minZoom", 0) != 0) {
                googleMapOptions.minZoomPreference(reactStylesDiffMap.getInt("minZoom", 0));
            }
            if (reactStylesDiffMap.hasKey("maxZoom") && reactStylesDiffMap.getInt("maxZoom", 0) != 0) {
                googleMapOptions.maxZoomPreference(reactStylesDiffMap.getInt("maxZoom", 0));
            }
            if (reactStylesDiffMap.hasKey("userInterfaceStyle") && !reactStylesDiffMap.hasKey("liteMode")) {
                String string = reactStylesDiffMap.getString("userInterfaceStyle");
                if ("system".equals(string)) {
                    googleMapOptions.mapColorScheme(2);
                } else if ("light".equals(string)) {
                    googleMapOptions.mapColorScheme(0);
                } else if ("dark".equals(string)) {
                    googleMapOptions.mapColorScheme(1);
                }
            }
            if (reactStylesDiffMap.hasKey("pitchEnabled")) {
                googleMapOptions.tiltGesturesEnabled(reactStylesDiffMap.getBoolean("pitchEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("rotateEnabled")) {
                googleMapOptions.rotateGesturesEnabled(reactStylesDiffMap.getBoolean("rotateEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("scrollDuringRotateOrZoomEnabled")) {
                googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(reactStylesDiffMap.getBoolean("scrollDuringRotateOrZoomEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("scrollEnabled")) {
                googleMapOptions.scrollGesturesEnabled(reactStylesDiffMap.getBoolean("scrollEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("showsCompass")) {
                googleMapOptions.compassEnabled(reactStylesDiffMap.getBoolean("showsCompass", true));
            }
            if (reactStylesDiffMap.hasKey("toolbarEnabled")) {
                googleMapOptions.mapToolbarEnabled(reactStylesDiffMap.getBoolean("toolbarEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("zoomControlEnabled")) {
                googleMapOptions.zoomControlsEnabled(reactStylesDiffMap.getBoolean("zoomControlEnabled", true));
            }
            if (reactStylesDiffMap.hasKey("zoomEnabled")) {
                googleMapOptions.zoomGesturesEnabled(reactStylesDiffMap.getBoolean("zoomEnabled", true));
            }
        }
        return googleMapOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public MapView createViewInstance(int i, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Object objUpdateState;
        MapView mapView = new MapView(themedReactContext, optionsForInitialProps(reactStylesDiffMap));
        mapView.setId(i);
        addEventEmitters(themedReactContext, mapView);
        if (reactStylesDiffMap != null) {
            updateProperties(mapView, reactStylesDiffMap);
        }
        if (stateWrapper != null && (objUpdateState = updateState(mapView, reactStylesDiffMap, stateWrapper)) != null) {
            updateExtraData((MapViewManager) mapView, objUpdateState);
        }
        return mapView;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapView.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapView.getExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCacheEnabled(MapView mapView, boolean z) {
        mapView.setCacheEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCamera(MapView mapView, @Nullable ReadableMap readableMap) {
        mapView.setCamera(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setPoiClickEnabled(MapView mapView, boolean z) {
        mapView.setPoiClickEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setInitialCamera(MapView mapView, @Nullable ReadableMap readableMap) {
        if (MapView.cameraPositionFromMap(readableMap) != null) {
            mapView.setInitialCameraSet(true);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setInitialRegion(MapView mapView, @Nullable ReadableMap readableMap) {
        mapView.setInitialRegion(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setKmlSrc(MapView mapView, @Nullable String str) throws ExecutionException, InterruptedException {
        mapView.setKmlSrc(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setGoogleRenderer(MapView mapView, @Nullable String str) {
        if (rendererInitialized) {
            return;
        }
        MapsInitializer.Renderer renderer = MapsInitializer.Renderer.LATEST;
        if ("LEGACY".equals(str)) {
            renderer = MapsInitializer.Renderer.LEGACY;
        }
        MapsInitializer.initialize(getReactApplicationContext(), renderer, new OnMapsSdkInitializedCallback() { // from class: com.rnmaps.fabric.MapViewManager$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.maps.OnMapsSdkInitializedCallback
            public final void onMapsSdkInitialized(MapsInitializer.Renderer renderer2) {
                MapViewManager.lambda$setGoogleRenderer$0(renderer2);
            }
        });
        rendererInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setGoogleRenderer$0(MapsInitializer.Renderer renderer) {
        Log.d("AirMapRenderer", "Init with renderer: " + renderer);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setLoadingBackgroundColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingBackgroundColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setLoadingEnabled(MapView mapView, boolean z) {
        mapView.setLoadingEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setLoadingIndicatorColor(MapView mapView, @Nullable Integer num) {
        mapView.setLoadingIndicatorColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
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
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(final MapView mapView, final View view, int i) {
        if (view instanceof MapMarker) {
            MapMarker mapMarker = (MapMarker) view;
            if (mapMarker.isLoadingImage()) {
                mapMarker.setImageLoadedListener(new ImageManager.OnImageLoadedListener() { // from class: com.rnmaps.fabric.MapViewManager$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.common.images.ImageManager.OnImageLoadedListener
                    public final void onImageLoaded(Uri uri, Drawable drawable, boolean z) {
                        MapViewManager.lambda$addView$1(mapView, view, uri, drawable, z);
                    }
                });
                return;
            }
        }
        mapView.addFeature(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addView$1(MapView mapView, View view, Uri uri, Drawable drawable, boolean z) {
        mapView.addFeature(view, mapView.getFeatureCount());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMapType(MapView mapView, @Nullable String str) {
        mapView.setMapType(mapTypeFromStrValue(str));
    }

    private static int mapTypeFromStrValue(String str) {
        if ("hybrid".equals(str)) {
            return 4;
        }
        if ("none".equals(str)) {
            return 0;
        }
        if ("satellite".equals(str)) {
            return 2;
        }
        return (!Constants.COLLATION_STANDARD.equals(str) && "terrain".equals(str)) ? 3 : 1;
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMaxZoom(MapView mapView, float f) {
        mapView.setMaxZoomLevel(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMinZoom(MapView mapView, float f) {
        mapView.setMinZoomLevel(f);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setMoveOnMarkerPress(MapView mapView, boolean z) {
        mapView.setMoveOnMarkerPress(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setHandlePanDrag(MapView mapView, boolean z) {
        mapView.setHandlePanDrag(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setPitchEnabled(MapView mapView, boolean z) {
        mapView.setPitchEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setRegion(MapView mapView, @Nullable ReadableMap readableMap) {
        mapView.setRegion(readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setRotateEnabled(MapView mapView, boolean z) {
        mapView.setRotateEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setScrollDuringRotateOrZoomEnabled(MapView mapView, boolean z) {
        mapView.setScrollDuringRotateOrZoomEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setScrollEnabled(MapView mapView, boolean z) {
        mapView.setScrollEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsBuildings(MapView mapView, boolean z) {
        mapView.setShowBuildings(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsCompass(MapView mapView, boolean z) {
        mapView.setShowsCompass(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsIndoorLevelPicker(MapView mapView, boolean z) {
        mapView.setShowsIndoorLevelPicker(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsIndoors(MapView mapView, boolean z) {
        mapView.setShowIndoors(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsMyLocationButton(MapView mapView, boolean z) {
        mapView.setShowsMyLocationButton(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsUserLocation(MapView mapView, boolean z) {
        mapView.setShowsUserLocation(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setToolbarEnabled(MapView mapView, boolean z) {
        mapView.setToolbarEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCustomMapStyleString(MapView mapView, @Nullable String str) {
        mapView.setMapStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserLocationFastestInterval(MapView mapView, int i) {
        mapView.setUserLocationFastestInterval(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserLocationPriority(MapView mapView, @Nullable String str) {
        mapView.setUserLocationPriority(MapManager.MY_LOCATION_PRIORITY.get(str).intValue());
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setUserLocationUpdateInterval(MapView mapView, int i) {
        mapView.setUserLocationUpdateInterval(i);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setZoomControlEnabled(MapView mapView, boolean z) {
        mapView.setZoomControlEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setZoomEnabled(MapView mapView, boolean z) {
        mapView.setZoomEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setShowsTraffic(MapView mapView, boolean z) {
        mapView.setShowsTraffic(z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void animateToRegion(MapView mapView, String str, int i) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            double d = jSONObject.getDouble("longitude");
            double d2 = jSONObject.getDouble("latitude");
            double d3 = jSONObject.getDouble("longitudeDelta");
            double d4 = jSONObject.getDouble("latitudeDelta") / 2.0d;
            double d5 = d3 / 2.0d;
            mapView.animateToRegion(new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d2 + d4, d + d5)), i);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setCamera(MapView mapView, String str) {
        try {
            mapView.moveToCamera(mapView.cameraPositionFromJSON(new JSONObject(str)));
        } catch (JSONException e) {
            Log.e("MapViewManager", "parse camera exception " + e);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void animateCamera(MapView mapView, String str, int i) {
        try {
            mapView.animateToCamera(mapView.cameraPositionFromJSON(new JSONObject(str)), i);
        } catch (JSONException e) {
            Log.e("MapViewManager", "parse camera exception " + e);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void fitToElements(MapView mapView, String str, boolean z) {
        WritableMap writableMapConvertJsonToWritable;
        if (str != null) {
            try {
                writableMapConvertJsonToWritable = JSONUtil.convertJsonToWritable(new JSONObject(str));
            } catch (JSONException e) {
                Log.e("MapViewManager", "parse edgePaddingJSON exception " + e);
                return;
            }
        } else {
            writableMapConvertJsonToWritable = null;
        }
        mapView.fitToElements(writableMapConvertJsonToWritable, z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void fitToSuppliedMarkers(MapView mapView, String str, String str2, boolean z) {
        WritableArray writableArrayConvertJsonArrayToWritable;
        if (str != null) {
            try {
                writableArrayConvertJsonArrayToWritable = JSONUtil.convertJsonArrayToWritable(new JSONArray(str));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            writableArrayConvertJsonArrayToWritable = null;
        }
        mapView.fitToSuppliedMarkers(writableArrayConvertJsonArrayToWritable, str2 != null ? JSONUtil.convertJsonToWritable(new JSONObject(str2)) : null, z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void fitToCoordinates(MapView mapView, String str, String str2, boolean z) {
        WritableArray writableArrayConvertJsonArrayToWritable;
        if (str != null) {
            try {
                writableArrayConvertJsonArrayToWritable = JSONUtil.convertJsonArrayToWritable(new JSONArray(str));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            writableArrayConvertJsonArrayToWritable = null;
        }
        mapView.fitToCoordinates(writableArrayConvertJsonArrayToWritable, str2 != null ? JSONUtil.convertJsonToWritable(new JSONObject(str2)) : null, z);
    }

    @Override // com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface
    public void setIndoorActiveLevelIndex(MapView mapView, int i) {
        mapView.setIndoorActiveLevelIndex(i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(MapView mapView) {
        super.onDropViewInstance((MapViewManager) mapView);
        mapView.onDestroy();
    }
}
