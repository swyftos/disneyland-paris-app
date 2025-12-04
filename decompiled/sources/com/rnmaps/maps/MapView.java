package com.rnmaps.maps;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.maps.android.collections.CircleManager;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Renderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.rnmaps.fabric.event.OnCalloutPressEvent;
import com.rnmaps.fabric.event.OnDeselectEvent;
import com.rnmaps.fabric.event.OnDoublePressEvent;
import com.rnmaps.fabric.event.OnDragEndEvent;
import com.rnmaps.fabric.event.OnDragEvent;
import com.rnmaps.fabric.event.OnDragStartEvent;
import com.rnmaps.fabric.event.OnIndoorBuildingFocusedEvent;
import com.rnmaps.fabric.event.OnIndoorLevelActivatedEvent;
import com.rnmaps.fabric.event.OnKmlReadyEvent;
import com.rnmaps.fabric.event.OnLongPressEvent;
import com.rnmaps.fabric.event.OnMapLoadedEvent;
import com.rnmaps.fabric.event.OnMapReadyEvent;
import com.rnmaps.fabric.event.OnMarkerDeselectEvent;
import com.rnmaps.fabric.event.OnMarkerDragEndEvent;
import com.rnmaps.fabric.event.OnMarkerDragEvent;
import com.rnmaps.fabric.event.OnMarkerDragStartEvent;
import com.rnmaps.fabric.event.OnMarkerPressEvent;
import com.rnmaps.fabric.event.OnMarkerSelectEvent;
import com.rnmaps.fabric.event.OnPanDragEvent;
import com.rnmaps.fabric.event.OnPoiClickEvent;
import com.rnmaps.fabric.event.OnPressEvent;
import com.rnmaps.fabric.event.OnRegionChangeCompleteEvent;
import com.rnmaps.fabric.event.OnRegionChangeEvent;
import com.rnmaps.fabric.event.OnRegionChangeStartEvent;
import com.rnmaps.fabric.event.OnSelectEvent;
import com.rnmaps.fabric.event.OnUserLocationChangeEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
public class MapView extends com.google.android.gms.maps.MapView implements GoogleMap.InfoWindowAdapter, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnPoiClickListener, GoogleMap.OnIndoorStateChangeListener, DefaultLifecycleObserver {
    private static final String[] PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private final ViewAttacherGroup attacherGroup;
    int baseBottomMapPadding;
    int baseLeftMapPadding;
    int baseRightMapPadding;
    int baseTopMapPadding;
    private LatLngBounds boundsToMove;
    private boolean cacheEnabled;
    private ImageView cacheImageView;
    private ReadableMap camera;
    private LatLngBounds cameraLastIdleBounds;
    private int cameraMoveReason;
    private CameraUpdate cameraToSet;
    private CircleManager.Collection circleCollection;
    private final ThemedReactContext context;
    private String customMapStyleString;
    private boolean destroyed;
    int edgeBottomPadding;
    int edgeLeftPadding;
    int edgeRightPadding;
    int edgeTopPadding;
    private final List features;
    private final FusedLocationSource fusedLocationSource;
    private final GestureDetectorCompat gestureDetector;
    private final Map gradientPolylineMap;
    private GroundOverlayManager.Collection groundOverlayCollection;
    private GroundOverlayManager groundOverlayManager;
    private boolean handlePanDrag;
    private final Map heatmapMap;
    private ReadableMap initialCamera;
    private boolean initialCameraSet;
    private ReadableMap initialRegion;
    private boolean initialRegionSet;
    private Boolean isMapLoaded;
    private Boolean isMapReady;
    private String kmlSrc;
    private Integer loadingBackgroundColor;
    private Integer loadingIndicatorColor;
    public GoogleMap map;
    private RelativeLayout mapLoadingLayout;
    private ProgressBar mapLoadingProgressBar;
    private MarkerManager.Collection markerCollection;
    private MarkerManager markerManager;
    private final Map markerMap;
    private Float maxZoomLevel;
    private final Runnable measureAndLayout;
    private Float minZoomLevel;
    private boolean moveOnMarkerPress;
    private final Map overlayMap;
    private boolean paused;
    private Boolean pitchEnabled;
    private boolean poiClickEnabled;
    private PolygonManager.Collection polygonCollection;
    private PolygonManager polygonManager;
    private final Map polygonMap;
    private PolylineManager.Collection polylineCollection;
    private PolylineManager polylineManager;
    private final Map polylineMap;
    private ReadableMap region;
    private Boolean rotateEnabled;
    private Boolean scrollDuringRotateOrZoomEnabled;
    private Boolean scrollEnabled;
    private MapMarker selectedMarker;
    private boolean setPaddingDeferred;
    private Boolean setShowBuildings;
    private Boolean showIndoors;
    private boolean showUserLocation;
    private Boolean showsCompass;
    private Boolean showsIndoorLevelPicker;
    private boolean showsTraffic;
    private LatLng tapLocation;
    private Boolean zoomControlEnabled;
    private Boolean zoomEnabled;

    @FunctionalInterface
    public interface EventCreator<T extends Event> {
        T create(int i, int i2, WritableMap writableMap);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate((Bundle) null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner lifecycleOwner) {
        GoogleMap googleMap;
        if (hasPermissions() && (googleMap = this.map) != null) {
            googleMap.setMyLocationEnabled(this.showUserLocation);
            this.map.setLocationSource(this.fusedLocationSource);
        }
        synchronized (this) {
            try {
                if (!this.destroyed) {
                    onResume();
                }
                this.paused = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner lifecycleOwner) {
        GoogleMap googleMap;
        try {
            super.onPause();
            if (hasPermissions() && (googleMap = this.map) != null) {
                googleMap.setMyLocationEnabled(false);
            }
            synchronized (this) {
                try {
                    if (!this.destroyed) {
                        onPause();
                    }
                    this.paused = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            Log.e("MapView", "onPause crash", e);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        try {
            super.onStop();
        } catch (Exception e) {
            Log.e("MapView", "onStop crash", e);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        try {
            doDestroy();
        } catch (Exception e) {
            Log.e("MapView", "onDestroy crash", e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            ComponentCallbacks2 currentActivity = this.context.getCurrentActivity();
            if (currentActivity instanceof LifecycleOwner) {
                ((LifecycleOwner) currentActivity).getLifecycle().removeObserver(this);
            }
        } catch (Exception e) {
            Log.e("MapView", "onDetachedFromWindow crash", e);
        }
    }

    public MapView(ThemedReactContext themedReactContext, GoogleMapOptions googleMapOptions) {
        super(themedReactContext, googleMapOptions);
        Boolean bool = Boolean.FALSE;
        this.isMapLoaded = bool;
        this.isMapReady = bool;
        this.loadingBackgroundColor = null;
        this.loadingIndicatorColor = null;
        this.setPaddingDeferred = false;
        this.showUserLocation = false;
        this.showsTraffic = false;
        this.handlePanDrag = false;
        this.moveOnMarkerPress = true;
        this.cacheEnabled = false;
        this.poiClickEnabled = true;
        this.initialRegionSet = false;
        this.initialCameraSet = false;
        this.cameraMoveReason = 0;
        this.features = new ArrayList();
        this.markerMap = new HashMap();
        this.polylineMap = new HashMap();
        this.polygonMap = new HashMap();
        this.overlayMap = new HashMap();
        this.heatmapMap = new HashMap();
        this.gradientPolylineMap = new HashMap();
        this.paused = false;
        this.destroyed = false;
        this.kmlSrc = null;
        this.measureAndLayout = new Runnable() { // from class: com.rnmaps.maps.MapView.11
            @Override // java.lang.Runnable
            public void run() {
                MapView mapView = MapView.this;
                mapView.measure(View.MeasureSpec.makeMeasureSpec(mapView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(MapView.this.getHeight(), 1073741824));
                MapView mapView2 = MapView.this;
                mapView2.layout(mapView2.getLeft(), MapView.this.getTop(), MapView.this.getRight(), MapView.this.getBottom());
            }
        };
        this.context = themedReactContext;
        ComponentCallbacks2 currentActivity = themedReactContext.getCurrentActivity();
        if (currentActivity instanceof LifecycleOwner) {
            ((LifecycleOwner) currentActivity).getLifecycle().addObserver(this);
        }
        super.getMapAsync(this);
        this.fusedLocationSource = new FusedLocationSource(themedReactContext);
        this.gestureDetector = new GestureDetectorCompat(themedReactContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.rnmaps.maps.MapView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!MapView.this.handlePanDrag) {
                    return false;
                }
                MapView.this.onPanDrag(motionEvent2);
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                MapView.this.onDoublePress(motionEvent);
                return false;
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.rnmaps.maps.MapView.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                try {
                    if (MapView.this.paused) {
                        return;
                    }
                    MapView.this.cacheView();
                } catch (Exception e) {
                    Log.e("MapView", "onLayoutChange crash", e);
                }
            }
        });
        ViewAttacherGroup viewAttacherGroup = new ViewAttacherGroup(themedReactContext);
        this.attacherGroup = viewAttacherGroup;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.leftMargin = 99999999;
        layoutParams.topMargin = 99999999;
        viewAttacherGroup.setLayoutParams(layoutParams);
        addView(viewAttacherGroup);
    }

    public MapView(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext, MapManager mapManager, GoogleMapOptions googleMapOptions) {
        this(null, googleMapOptions);
    }

    public double[][] getMarkersFrames(boolean z) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        LatLngBounds latLngBounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        boolean z2 = false;
        for (MapFeature mapFeature : this.features) {
            if (mapFeature instanceof MapMarker) {
                Marker marker = (Marker) mapFeature.getFeature();
                if (!z || latLngBounds.contains(marker.getPosition())) {
                    builder.include(marker.getPosition());
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return null;
        }
        LatLngBounds latLngBoundsBuild = builder.build();
        LatLng latLng = latLngBoundsBuild.northeast;
        LatLng latLng2 = latLngBoundsBuild.southwest;
        return new double[][]{new double[]{latLng.longitude, latLng.latitude}, new double[]{latLng2.longitude, latLng2.latitude}};
    }

    public void setShowsTraffic(boolean z) {
        this.showsTraffic = z;
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setTrafficEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEvent(WritableMap writableMap, EventCreator eventCreator) {
        dispatchEvent(writableMap, eventCreator, getId(), this.context);
    }

    public static <T extends Event> void dispatchEvent(WritableMap writableMap, EventCreator<T> eventCreator, int i, ReactContext reactContext) {
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, i);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(eventCreator.create(UIManagerHelper.getSurfaceId(reactContext), i, writableMap));
        }
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(@NonNull final GoogleMap googleMap) throws ExecutionException, InterruptedException {
        if (this.destroyed) {
            return;
        }
        this.map = googleMap;
        post(new Runnable() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                googleMap.setMapType(0);
            }
        });
        post(new Runnable() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MapView.lambda$onMapReady$1(googleMap);
            }
        });
        Float f = this.maxZoomLevel;
        if (f != null) {
            setMaxZoomLevel(f.floatValue());
        }
        Float f2 = this.minZoomLevel;
        if (f2 != null) {
            setMinZoomLevel(f2.floatValue());
        }
        Boolean bool = this.pitchEnabled;
        if (bool != null) {
            setPitchEnabled(bool.booleanValue());
        }
        Boolean bool2 = this.showsCompass;
        if (bool2 != null) {
            setShowsCompass(bool2.booleanValue());
        }
        Boolean bool3 = this.rotateEnabled;
        if (bool3 != null) {
            setRotateEnabled(bool3.booleanValue());
        }
        Boolean bool4 = this.zoomEnabled;
        if (bool4 != null) {
            setZoomEnabled(bool4.booleanValue());
        }
        Boolean bool5 = this.zoomControlEnabled;
        if (bool5 != null) {
            setZoomControlEnabled(bool5.booleanValue());
        }
        Boolean bool6 = this.setShowBuildings;
        if (bool6 != null) {
            setShowBuildings(bool6.booleanValue());
        }
        Boolean bool7 = this.showsIndoorLevelPicker;
        if (bool7 != null) {
            setShowsIndoorLevelPicker(bool7.booleanValue());
        }
        Boolean bool8 = this.showIndoors;
        if (bool8 != null) {
            setShowIndoors(bool8.booleanValue());
        }
        Boolean bool9 = this.scrollEnabled;
        if (bool9 != null) {
            setScrollEnabled(bool9.booleanValue());
        }
        Boolean bool10 = this.scrollDuringRotateOrZoomEnabled;
        if (bool10 != null) {
            setScrollDuringRotateOrZoomEnabled(bool10.booleanValue());
        }
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.markerManager = markerManager;
        this.markerCollection = markerManager.newCollection();
        PolylineManager polylineManager = new PolylineManager(googleMap);
        this.polylineManager = polylineManager;
        this.polylineCollection = polylineManager.newCollection();
        PolygonManager polygonManager = new PolygonManager(googleMap);
        this.polygonManager = polygonManager;
        this.polygonCollection = polygonManager.newCollection();
        this.circleCollection = new CircleManager(googleMap).newCollection();
        GroundOverlayManager groundOverlayManager = new GroundOverlayManager(googleMap);
        this.groundOverlayManager = groundOverlayManager;
        this.groundOverlayCollection = groundOverlayManager.newCollection();
        this.markerCollection.setInfoWindowAdapter(this);
        this.markerCollection.setOnMarkerDragListener(this);
        this.map.setOnIndoorStateChangeListener(this);
        applyBridgedProps();
        dispatchEvent(new WritableNativeMap(), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda3
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnMapReadyEvent(i, i2, writableMap);
            }
        });
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: com.rnmaps.maps.MapView.3
            @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
            public void onMyLocationChange(Location location) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putDouble("latitude", location.getLatitude());
                writableNativeMap2.putDouble("longitude", location.getLongitude());
                writableNativeMap2.putDouble("altitude", location.getAltitude());
                writableNativeMap2.putDouble("timestamp", location.getTime());
                writableNativeMap2.putDouble("accuracy", location.getAccuracy());
                writableNativeMap2.putDouble("speed", location.getSpeed());
                writableNativeMap2.putDouble("heading", location.getBearing());
                writableNativeMap2.putBoolean("isFromMockProvider", location.isFromMockProvider());
                writableNativeMap.putMap("coordinate", writableNativeMap2);
                MapView.this.dispatchEvent(writableNativeMap, new EventCreator() { // from class: com.rnmaps.maps.MapView$3$$ExternalSyntheticLambda0
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnUserLocationChangeEvent(i, i2, writableMap);
                    }
                });
            }
        });
        this.markerCollection.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.rnmaps.maps.MapView.4
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                MapMarker markerMap = MapView.this.getMarkerMap(marker);
                WritableMap writableMapMakeClickEventData = MapView.this.makeClickEventData(marker.getPosition());
                writableMapMakeClickEventData.putString("action", "marker-press");
                writableMapMakeClickEventData.putString("id", markerMap.getIdentifier());
                markerMap.dispatchEvent(writableMapMakeClickEventData, new MapView$$ExternalSyntheticLambda21());
                WritableMap writableMapMakeClickEventData2 = MapView.this.makeClickEventData(marker.getPosition());
                writableMapMakeClickEventData2.putString("action", "marker-press");
                writableMapMakeClickEventData2.putString("id", markerMap.getIdentifier());
                MapView.this.dispatchEvent(writableMapMakeClickEventData2, new EventCreator() { // from class: com.rnmaps.maps.MapView$4$$ExternalSyntheticLambda0
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnMarkerPressEvent(i, i2, writableMap);
                    }
                });
                MapView.this.handleMarkerSelection(markerMap);
                if (this.moveOnMarkerPress) {
                    return false;
                }
                marker.showInfoWindow();
                return true;
            }
        });
        this.polygonCollection.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() { // from class: com.rnmaps.maps.MapView.5
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public void onPolygonClick(Polygon polygon) {
                MapView mapView = MapView.this;
                WritableMap writableMapMakeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                writableMapMakeClickEventData.putString("action", "polygon-press");
                MapPolygon mapPolygon = (MapPolygon) MapView.this.polygonMap.get(polygon);
                mapPolygon.dispatchEvent(writableMapMakeClickEventData, new MapView$$ExternalSyntheticLambda21(), MapView.this.context);
                MapView mapView2 = MapView.this;
                WritableMap writableMapMakeClickEventData2 = mapView2.makeClickEventData(mapView2.tapLocation);
                writableMapMakeClickEventData2.putString("action", "polygon-press");
                writableMapMakeClickEventData2.putString("id", String.valueOf(mapPolygon.getId()));
                MapView.this.dispatchEvent(writableMapMakeClickEventData2, new MapView$$ExternalSyntheticLambda21());
            }
        });
        this.polylineCollection.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() { // from class: com.rnmaps.maps.MapView.6
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public void onPolylineClick(Polyline polyline) {
                MapView mapView = MapView.this;
                WritableMap writableMapMakeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                writableMapMakeClickEventData.putString("action", "polyline-press");
                MapView.this.dispatchEvent(writableMapMakeClickEventData, new MapView$$ExternalSyntheticLambda21());
                MapView mapView2 = MapView.this;
                MapView.dispatchEvent(mapView2.makeClickEventData(mapView2.tapLocation), new MapView$$ExternalSyntheticLambda21(), ((MapPolyline) MapView.this.polylineMap.get(polyline)).getId(), MapView.this.context);
            }
        });
        this.markerCollection.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                this.f$0.lambda$onMapReady$2(marker);
            }
        });
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: com.rnmaps.maps.MapView.7
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public void onMapClick(LatLng latLng) {
                WritableMap writableMapMakeClickEventData = MapView.this.makeClickEventData(latLng);
                writableMapMakeClickEventData.putString("action", "press");
                MapView.this.dispatchEvent(writableMapMakeClickEventData, new MapView$$ExternalSyntheticLambda21());
                MapView.this.handleMarkerSelection(null);
            }
        });
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() { // from class: com.rnmaps.maps.MapView.8
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public void onMapLongClick(LatLng latLng) {
                WritableMap writableMapMakeClickEventData = MapView.this.makeClickEventData(latLng);
                writableMapMakeClickEventData.putString("action", "long-press");
                MapView.this.dispatchEvent(writableMapMakeClickEventData, new EventCreator() { // from class: com.rnmaps.maps.MapView$8$$ExternalSyntheticLambda0
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnLongPressEvent(i, i2, writableMap);
                    }
                });
            }
        });
        this.groundOverlayCollection.setOnGroundOverlayClickListener(new GoogleMap.OnGroundOverlayClickListener() { // from class: com.rnmaps.maps.MapView.9
            @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
            public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                WritableMap writableMapMakeClickEventData = MapView.this.makeClickEventData(groundOverlay.getPosition());
                writableMapMakeClickEventData.putString("action", "overlay-press");
                MapView.this.dispatchEvent(writableMapMakeClickEventData, new MapView$$ExternalSyntheticLambda21());
                MapView.dispatchEvent(MapView.this.makeClickEventData(groundOverlay.getPosition()), new MapView$$ExternalSyntheticLambda21(), ((MapOverlay) MapView.this.overlayMap.get(groundOverlay)).getId(), MapView.this.context);
            }
        });
        googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i) {
                this.f$0.lambda$onMapReady$3(i);
            }
        });
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                this.f$0.lambda$onMapReady$4(googleMap);
            }
        });
        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                this.f$0.lambda$onMapReady$5(googleMap);
            }
        });
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public final void onMapLoaded() {
                this.f$0.lambda$onMapReady$6();
            }
        });
        googleMap.setTrafficEnabled(this.showsTraffic);
        this.isMapReady = Boolean.TRUE;
        String str = this.kmlSrc;
        if (str != null) {
            setKmlSrc(str);
            this.kmlSrc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMapReady$1(GoogleMap googleMap) {
        googleMap.setLatLngBoundsForCameraTarget(new LatLngBounds(new LatLng(48.80686346d, 2.63671875d), new LatLng(48.92249926d, 2.90039062d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$2(Marker marker) {
        WritableMap writableMapMakeClickEventData = makeClickEventData(marker.getPosition());
        writableMapMakeClickEventData.putString("action", "callout-press");
        dispatchEvent(writableMapMakeClickEventData, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda20
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnCalloutPressEvent(i, i2, writableMap);
            }
        });
        WritableMap writableMapMakeClickEventData2 = makeClickEventData(marker.getPosition());
        writableMapMakeClickEventData2.putString("action", "callout-press");
        MapMarker markerMap = getMarkerMap(marker);
        dispatchEvent(writableMapMakeClickEventData2, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda20
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnCalloutPressEvent(i, i2, writableMap);
            }
        }, markerMap.getId(), this.context);
        MapCallout calloutView = markerMap.getCalloutView();
        if (calloutView != null) {
            WritableMap writableMapMakeClickEventData3 = makeClickEventData(marker.getPosition());
            writableMapMakeClickEventData3.putString("action", "callout-press");
            dispatchEvent(writableMapMakeClickEventData3, new MapView$$ExternalSyntheticLambda21(), calloutView.getId(), this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$3(int i) {
        this.cameraMoveReason = i;
        boolean z = 1 == i;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("isGesture", z);
        dispatchEvent(writableNativeMap, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda22
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i2, int i3, WritableMap writableMap) {
                return new OnRegionChangeStartEvent(i2, i3, writableMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$4(GoogleMap googleMap) {
        LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
        this.cameraLastIdleBounds = null;
        dispatchEvent(OnRegionChangeEvent.payLoadFor(latLngBounds, true, 1 == this.cameraMoveReason), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda23
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnRegionChangeEvent(i, i2, writableMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$5(GoogleMap googleMap) {
        LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
        if (this.cameraMoveReason != 0) {
            LatLngBounds latLngBounds2 = this.cameraLastIdleBounds;
            if (latLngBounds2 == null || LatLngBoundsUtils.BoundsAreDifferent(latLngBounds, latLngBounds2)) {
                this.cameraLastIdleBounds = latLngBounds;
                dispatchEvent(OnRegionChangeEvent.payLoadFor(latLngBounds, false, 1 == this.cameraMoveReason), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda25
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnRegionChangeCompleteEvent(i, i2, writableMap);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$6() {
        this.isMapLoaded = Boolean.TRUE;
        dispatchEvent(new WritableNativeMap(), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda24
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnMapLoadedEvent(i, i2, writableMap);
            }
        });
        cacheView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleMarkerSelection(MapMarker mapMarker) {
        try {
            MapMarker mapMarker2 = this.selectedMarker;
            if (mapMarker2 == mapMarker) {
                return;
            }
            if (mapMarker2 != null) {
                WritableMap writableMapMakeClickEventData = makeClickEventData(mapMarker2.getPosition());
                writableMapMakeClickEventData.putString("action", "marker-deselect");
                writableMapMakeClickEventData.putString("id", this.selectedMarker.getIdentifier());
                this.selectedMarker.dispatchEvent(writableMapMakeClickEventData, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda26
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnDeselectEvent(i, i2, writableMap);
                    }
                });
                WritableMap writableMapMakeClickEventData2 = makeClickEventData(this.selectedMarker.getPosition());
                writableMapMakeClickEventData2.putString("action", "marker-deselect");
                writableMapMakeClickEventData2.putString("id", this.selectedMarker.getIdentifier());
                dispatchEvent(writableMapMakeClickEventData2, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda27
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnMarkerDeselectEvent(i, i2, writableMap);
                    }
                });
            }
            if (mapMarker != null) {
                WritableMap writableMapMakeClickEventData3 = makeClickEventData(mapMarker.getPosition());
                writableMapMakeClickEventData3.putString("action", "marker-select");
                writableMapMakeClickEventData3.putString("id", mapMarker.getIdentifier());
                mapMarker.dispatchEvent(writableMapMakeClickEventData3, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda28
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnSelectEvent(i, i2, writableMap);
                    }
                });
                WritableMap writableMapMakeClickEventData4 = makeClickEventData(mapMarker.getPosition());
                writableMapMakeClickEventData4.putString("action", "marker-select");
                writableMapMakeClickEventData4.putString("id", mapMarker.getIdentifier());
                dispatchEvent(writableMapMakeClickEventData4, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda29
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnMarkerSelectEvent(i, i2, writableMap);
                    }
                });
            }
            this.selectedMarker = mapMarker;
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean hasPermissions() {
        Context context = getContext();
        String[] strArr = PERMISSIONS;
        return PermissionChecker.checkSelfPermission(context, strArr[0]) == 0 || PermissionChecker.checkSelfPermission(getContext(), strArr[1]) == 0;
    }

    public static Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPressEvent.EVENT_NAME));
        builder.put(OnLongPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnLongPressEvent.EVENT_NAME));
        return builder.build();
    }

    public static Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnMarkerPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerPressEvent.EVENT_NAME));
        builder.put(OnCalloutPressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnCalloutPressEvent.EVENT_NAME));
        builder.put(OnMarkerDragEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerDragEvent.EVENT_NAME));
        builder.put(OnMarkerDragStartEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerDragStartEvent.EVENT_NAME));
        builder.put(OnMarkerDragEndEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerDragEndEvent.EVENT_NAME));
        builder.put(OnPoiClickEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPoiClickEvent.EVENT_NAME));
        builder.put(OnDoublePressEvent.EVENT_NAME, MapBuilder.of("registrationName", OnDoublePressEvent.EVENT_NAME));
        builder.put(OnPanDragEvent.EVENT_NAME, MapBuilder.of("registrationName", OnPanDragEvent.EVENT_NAME));
        builder.put(OnMarkerSelectEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerSelectEvent.EVENT_NAME));
        builder.put(OnMarkerDeselectEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMarkerDeselectEvent.EVENT_NAME));
        builder.put(OnMapLoadedEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMapLoadedEvent.EVENT_NAME));
        builder.put(OnMapReadyEvent.EVENT_NAME, MapBuilder.of("registrationName", OnMapReadyEvent.EVENT_NAME));
        builder.put(OnUserLocationChangeEvent.EVENT_NAME, MapBuilder.of("registrationName", OnUserLocationChangeEvent.EVENT_NAME));
        builder.put(OnRegionChangeEvent.EVENT_NAME, MapBuilder.of("registrationName", OnRegionChangeEvent.EVENT_NAME));
        builder.put(OnRegionChangeStartEvent.EVENT_NAME, MapBuilder.of("registrationName", OnRegionChangeStartEvent.EVENT_NAME));
        builder.put(OnRegionChangeCompleteEvent.EVENT_NAME, MapBuilder.of("registrationName", OnRegionChangeCompleteEvent.EVENT_NAME));
        builder.put(OnIndoorBuildingFocusedEvent.EVENT_NAME, MapBuilder.of("registrationName", OnIndoorBuildingFocusedEvent.EVENT_NAME));
        builder.put(OnIndoorLevelActivatedEvent.EVENT_NAME, MapBuilder.of("registrationName", OnIndoorLevelActivatedEvent.EVENT_NAME));
        builder.put(OnKmlReadyEvent.EVENT_NAME, MapBuilder.of("registrationName", OnKmlReadyEvent.EVENT_NAME));
        return builder.build();
    }

    public synchronized void doDestroy() {
        try {
            if (this.destroyed) {
                return;
            }
            this.destroyed = true;
            ComponentCallbacks2 currentActivity = this.context.getCurrentActivity();
            if (currentActivity instanceof LifecycleOwner) {
                ((LifecycleOwner) currentActivity).getLifecycle().removeObserver(this);
            }
            if (!this.paused) {
                onPause();
                this.paused = true;
            }
            onDestroy();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInitialCameraSet(boolean z) {
        this.initialCameraSet = z;
    }

    public void setInitialRegion(ReadableMap readableMap) {
        this.initialRegion = readableMap;
        if (this.initialRegionSet || this.map == null) {
            return;
        }
        moveToRegion(readableMap);
        this.initialRegionSet = true;
    }

    public void setInitialCamera(ReadableMap readableMap) {
        this.initialCamera = readableMap;
        if (this.initialCameraSet || this.map == null) {
            return;
        }
        moveToCamera(readableMap);
        this.initialCameraSet = true;
    }

    private void applyBridgedProps() {
        ReadableMap readableMap = this.initialRegion;
        if (readableMap != null) {
            moveToRegion(readableMap);
            this.initialRegionSet = true;
        } else {
            ReadableMap readableMap2 = this.region;
            if (readableMap2 != null) {
                moveToRegion(readableMap2);
            } else {
                ReadableMap readableMap3 = this.initialCamera;
                if (readableMap3 != null) {
                    moveToCamera(readableMap3);
                    this.initialCameraSet = true;
                } else {
                    ReadableMap readableMap4 = this.camera;
                    if (readableMap4 != null) {
                        moveToCamera(readableMap4);
                    }
                }
            }
        }
        if (this.customMapStyleString != null) {
            this.map.setMapStyle(new MapStyleOptions(this.customMapStyleString));
        }
        setPoiClickEnabled(this.poiClickEnabled);
        if (this.setPaddingDeferred) {
            int i = this.baseLeftMapPadding;
            if (i == 0 && this.baseTopMapPadding == 0 && this.baseRightMapPadding == 0 && this.baseBottomMapPadding == 0) {
                return;
            }
            applyBaseMapPadding(i, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
        }
    }

    public static LatLngBounds latLngBoundsFromRegion(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        double d = readableMap.getDouble("longitude");
        double d2 = readableMap.getDouble("latitude");
        double d3 = readableMap.getDouble("longitudeDelta");
        double d4 = readableMap.getDouble("latitudeDelta") / 2.0d;
        double d5 = d3 / 2.0d;
        return new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d2 + d4, d + d5));
    }

    private void moveToRegion(ReadableMap readableMap) {
        LatLngBounds latLngBoundsLatLngBoundsFromRegion = latLngBoundsFromRegion(readableMap);
        if (latLngBoundsLatLngBoundsFromRegion == null) {
            return;
        }
        double d = readableMap.getDouble("longitude");
        double d2 = readableMap.getDouble("latitude");
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d), 10.0f));
            this.boundsToMove = latLngBoundsLatLngBoundsFromRegion;
        } else {
            this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBoundsLatLngBoundsFromRegion, 0));
            this.boundsToMove = null;
        }
    }

    public void setRegion(ReadableMap readableMap) {
        this.region = readableMap;
        if (readableMap == null || this.map == null) {
            return;
        }
        moveToRegion(readableMap);
    }

    public void setCamera(ReadableMap readableMap) {
        this.camera = readableMap;
        if (readableMap == null || this.map == null) {
            return;
        }
        moveToCamera(readableMap);
    }

    public static CameraPosition cameraPositionFromMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder();
        ReadableMap map = readableMap.getMap("center");
        if (map != null) {
            builder.target(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        builder.tilt((float) readableMap.getDouble("pitch"));
        builder.bearing((float) readableMap.getDouble("heading"));
        builder.zoom((float) readableMap.getDouble("zoom"));
        return builder.build();
    }

    public CameraPosition cameraPositionFromJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || this.map == null) {
            return null;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder();
        if (jSONObject.has("center")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("center");
            if (jSONObject2 != null) {
                builder.target(new LatLng(jSONObject2.getDouble("latitude"), jSONObject2.getDouble("longitude")));
            }
        } else {
            builder.target(this.map.getCameraPosition().target);
        }
        if (jSONObject.has("pitch")) {
            builder.tilt((float) jSONObject.getDouble("pitch"));
        } else {
            builder.tilt(this.map.getCameraPosition().tilt);
        }
        if (jSONObject.has("heading")) {
            builder.bearing((float) jSONObject.getDouble("heading"));
        } else {
            builder.bearing(this.map.getCameraPosition().bearing);
        }
        if (jSONObject.has("zoom")) {
            builder.zoom((float) jSONObject.getDouble("zoom"));
        } else {
            builder.zoom(this.map.getCameraPosition().zoom);
        }
        return builder.build();
    }

    public void moveToCamera(ReadableMap readableMap) {
        moveToCamera(cameraPositionFromMap(readableMap));
    }

    public void moveToCamera(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return;
        }
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(cameraPosition);
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.cameraToSet = cameraUpdateNewCameraPosition;
        } else {
            this.map.moveCamera(cameraUpdateNewCameraPosition);
            this.cameraToSet = null;
        }
    }

    public void setMapStyle(@Nullable String str) {
        this.customMapStyleString = str;
        GoogleMap googleMap = this.map;
        if (googleMap == null || str == null) {
            return;
        }
        googleMap.setMapStyle(new MapStyleOptions(str));
    }

    public void setShowsUserLocation(boolean z) {
        GoogleMap googleMap;
        this.showUserLocation = z;
        if (!hasPermissions() || (googleMap = this.map) == null) {
            return;
        }
        googleMap.setLocationSource(this.fusedLocationSource);
        this.map.setMyLocationEnabled(z);
    }

    public void setUserLocationPriority(int i) {
        this.fusedLocationSource.setPriority(i);
    }

    public void setUserLocationUpdateInterval(int i) {
        this.fusedLocationSource.setInterval(i);
    }

    public void setUserLocationFastestInterval(int i) {
        this.fusedLocationSource.setFastestInterval(i);
    }

    public void setShowsMyLocationButton(boolean z) {
        if (this.map != null) {
            if (hasPermissions() || !z) {
                this.map.getUiSettings().setMyLocationButtonEnabled(z);
            }
        }
    }

    public void setToolbarEnabled(boolean z) {
        if (this.map != null) {
            if (hasPermissions() || !z) {
                this.map.getUiSettings().setMapToolbarEnabled(z);
            }
        }
    }

    public void setMapType(int i) {
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setMapType(i);
        }
    }

    public void setCacheEnabled(boolean z) {
        this.cacheEnabled = z;
        cacheView();
    }

    public void setPoiClickEnabled(boolean z) {
        this.poiClickEnabled = z;
    }

    public void setLoadingEnabled(boolean z) {
        if (!z || this.isMapLoaded.booleanValue()) {
            return;
        }
        getMapLoadingLayoutView().setVisibility(0);
    }

    public void setMoveOnMarkerPress(boolean z) {
        this.moveOnMarkerPress = z;
    }

    public void setMaxZoomLevel(float f) {
        this.maxZoomLevel = Float.valueOf(f);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setMaxZoomPreference(f);
        }
    }

    public void setMinZoomLevel(float f) {
        this.minZoomLevel = Float.valueOf(f);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setMinZoomPreference(f);
        }
    }

    public void setPitchEnabled(boolean z) {
        this.pitchEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setTiltGesturesEnabled(z);
        }
    }

    public void setShowsCompass(boolean z) {
        this.showsCompass = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setCompassEnabled(z);
        }
    }

    public void setRotateEnabled(boolean z) {
        this.rotateEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setRotateGesturesEnabled(z);
        }
    }

    public void setZoomEnabled(boolean z) {
        this.zoomEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setZoomGesturesEnabled(z);
        }
    }

    public void setZoomControlEnabled(boolean z) {
        this.zoomControlEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(z);
        }
    }

    public void setScrollDuringRotateOrZoomEnabled(boolean z) {
        this.scrollDuringRotateOrZoomEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(z);
        }
    }

    public void setScrollEnabled(boolean z) {
        this.scrollEnabled = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setScrollGesturesEnabled(z);
        }
    }

    public void setShowIndoors(boolean z) {
        this.showIndoors = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setIndoorEnabled(z);
        }
    }

    public void setShowsIndoorLevelPicker(boolean z) {
        this.showsIndoorLevelPicker = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.getUiSettings().setIndoorLevelPickerEnabled(z);
        }
    }

    public void setShowBuildings(boolean z) {
        this.setShowBuildings = Boolean.valueOf(z);
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            googleMap.setBuildingsEnabled(z);
        }
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.loadingBackgroundColor = num;
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout != null) {
            if (num == null) {
                relativeLayout.setBackgroundColor(-1);
            } else {
                relativeLayout.setBackgroundColor(num.intValue());
            }
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.loadingIndicatorColor = num;
        if (this.mapLoadingProgressBar != null) {
            if (num == null) {
                Color.parseColor("#606060");
            }
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(num.intValue());
            ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(num.intValue());
            ColorStateList colorStateListValueOf3 = ColorStateList.valueOf(num.intValue());
            this.mapLoadingProgressBar.setProgressTintList(colorStateListValueOf);
            this.mapLoadingProgressBar.setSecondaryProgressTintList(colorStateListValueOf2);
            this.mapLoadingProgressBar.setIndeterminateTintList(colorStateListValueOf3);
        }
    }

    public void setHandlePanDrag(boolean z) {
        this.handlePanDrag = z;
    }

    public void addFeature(View view, int i) {
        if (view instanceof MapMarker) {
            MapMarker mapMarker = (MapMarker) view;
            mapMarker.addToMap(this.markerCollection);
            this.features.add(i, mapMarker);
            int visibility = mapMarker.getVisibility();
            mapMarker.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) mapMarker.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mapMarker);
            }
            this.attacherGroup.addView(mapMarker);
            mapMarker.setVisibility(visibility);
            this.markerMap.put((Marker) mapMarker.getFeature(), mapMarker);
            return;
        }
        if (view instanceof MapPolyline) {
            MapPolyline mapPolyline = (MapPolyline) view;
            mapPolyline.addToMap(this.polylineCollection);
            this.features.add(i, mapPolyline);
            this.polylineMap.put((Polyline) mapPolyline.getFeature(), mapPolyline);
            return;
        }
        if (view instanceof MapGradientPolyline) {
            MapGradientPolyline mapGradientPolyline = (MapGradientPolyline) view;
            mapGradientPolyline.addToMap(this.map);
            this.features.add(i, mapGradientPolyline);
            this.gradientPolylineMap.put((TileOverlay) mapGradientPolyline.getFeature(), mapGradientPolyline);
            return;
        }
        if (view instanceof MapPolygon) {
            MapPolygon mapPolygon = (MapPolygon) view;
            mapPolygon.addToMap(this.polygonCollection);
            this.features.add(i, mapPolygon);
            this.polygonMap.put((Polygon) mapPolygon.getFeature(), mapPolygon);
            return;
        }
        if (view instanceof MapCircle) {
            MapCircle mapCircle = (MapCircle) view;
            mapCircle.addToMap(this.circleCollection);
            this.features.add(i, mapCircle);
            return;
        }
        if (view instanceof MapUrlTile) {
            MapUrlTile mapUrlTile = (MapUrlTile) view;
            mapUrlTile.addToMap(this.map);
            this.features.add(i, mapUrlTile);
            return;
        }
        if (view instanceof MapWMSTile) {
            MapWMSTile mapWMSTile = (MapWMSTile) view;
            mapWMSTile.addToMap(this.map);
            this.features.add(i, mapWMSTile);
            return;
        }
        if (view instanceof MapLocalTile) {
            MapLocalTile mapLocalTile = (MapLocalTile) view;
            mapLocalTile.addToMap(this.map);
            this.features.add(i, mapLocalTile);
            return;
        }
        if (view instanceof MapOverlay) {
            MapOverlay mapOverlay = (MapOverlay) view;
            mapOverlay.addToMap(this.groundOverlayCollection);
            this.features.add(i, mapOverlay);
            this.overlayMap.put((GroundOverlay) mapOverlay.getFeature(), mapOverlay);
            return;
        }
        if (view instanceof MapHeatmap) {
            MapHeatmap mapHeatmap = (MapHeatmap) view;
            mapHeatmap.addToMap(this.map);
            this.features.add(i, mapHeatmap);
            this.heatmapMap.put((TileOverlay) mapHeatmap.getFeature(), mapHeatmap);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                addFeature(viewGroup2.getChildAt(i2), i);
            }
            return;
        }
        addView(view, i);
    }

    public int getFeatureCount() {
        return this.features.size();
    }

    public View getFeatureAt(int i) {
        return (View) this.features.get(i);
    }

    public void removeFeatureAt(int i) {
        MapFeature mapFeature = (MapFeature) this.features.remove(i);
        if (mapFeature instanceof MapMarker) {
            this.markerMap.remove(mapFeature.getFeature());
            mapFeature.removeFromMap(this.markerCollection);
            this.attacherGroup.removeView(mapFeature);
            return;
        }
        if (mapFeature instanceof MapHeatmap) {
            this.heatmapMap.remove(mapFeature.getFeature());
            mapFeature.removeFromMap(this.map);
            return;
        }
        if (mapFeature instanceof MapCircle) {
            mapFeature.removeFromMap(this.circleCollection);
            return;
        }
        if (mapFeature instanceof MapOverlay) {
            mapFeature.removeFromMap(this.groundOverlayCollection);
            return;
        }
        if (mapFeature instanceof MapPolygon) {
            mapFeature.removeFromMap(this.polygonCollection);
        } else if (mapFeature instanceof MapPolyline) {
            mapFeature.removeFromMap(this.polylineCollection);
        } else {
            mapFeature.removeFromMap(this.map);
        }
    }

    public WritableMap makeClickEventData(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.latitude);
        writableNativeMap2.putDouble("longitude", latLng.longitude);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        Point screenLocation = this.map.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap3.putDouble("x", screenLocation.x);
        writableNativeMap3.putDouble("y", screenLocation.y);
        writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap3);
        return writableNativeMap;
    }

    public void updateExtraData(Object obj) {
        if (this.setPaddingDeferred && super.getHeight() > 0 && super.getWidth() > 0) {
            CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(this.map.getCameraPosition());
            this.map.setPadding(this.edgeLeftPadding + this.baseLeftMapPadding, this.edgeTopPadding + this.baseTopMapPadding, this.edgeRightPadding + this.baseRightMapPadding, this.edgeBottomPadding + this.baseBottomMapPadding);
            this.map.moveCamera(cameraUpdateNewCameraPosition);
            this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
            this.setPaddingDeferred = false;
        }
        if (this.boundsToMove != null) {
            HashMap map = (HashMap) obj;
            int iIntValue = map.get("width") == null ? 0 : ((Float) map.get("width")).intValue();
            int iIntValue2 = map.get("height") == null ? 0 : ((Float) map.get("height")).intValue();
            if (iIntValue <= 0 || iIntValue2 <= 0) {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, 0));
            } else {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, iIntValue, iIntValue2, 0));
            }
            this.boundsToMove = null;
            this.cameraToSet = null;
            return;
        }
        CameraUpdate cameraUpdate = this.cameraToSet;
        if (cameraUpdate != null) {
            this.map.moveCamera(cameraUpdate);
            this.cameraToSet = null;
        }
    }

    public void animateToCamera(CameraPosition cameraPosition, int i) {
        if (this.map == null) {
            return;
        }
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(cameraPosition);
        if (i <= 0) {
            this.map.moveCamera(cameraUpdateNewCameraPosition);
        } else {
            this.map.animateCamera(cameraUpdateNewCameraPosition, i, null);
        }
    }

    public void animateToCamera(ReadableMap readableMap, int i) {
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            return;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder(googleMap.getCameraPosition());
        if (readableMap.hasKey("zoom")) {
            builder.zoom((float) readableMap.getDouble("zoom"));
        }
        if (readableMap.hasKey("heading")) {
            builder.bearing((float) readableMap.getDouble("heading"));
        }
        if (readableMap.hasKey("pitch")) {
            builder.tilt((float) readableMap.getDouble("pitch"));
        }
        if (readableMap.hasKey("center")) {
            ReadableMap map = readableMap.getMap("center");
            builder.target(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        animateToCamera(builder.build(), i);
    }

    public void animateToRegion(LatLngBounds latLngBounds, int i) {
        GoogleMap googleMap = this.map;
        if (googleMap == null) {
            return;
        }
        if (i <= 0) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } else {
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0), i, null);
        }
    }

    public void fitToElements(ReadableMap readableMap, boolean z) {
        boolean z2;
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        if (this.features.size() > 0) {
            z2 = false;
            for (MapFeature mapFeature : this.features) {
                if (mapFeature instanceof MapMarker) {
                    builder.include(((Marker) mapFeature.getFeature()).getPosition());
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        if (z2) {
            CameraUpdate cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 0);
            if (readableMap != null) {
                appendMapPadding(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.animateCamera(cameraUpdateNewLatLngBounds);
            } else {
                this.map.moveCamera(cameraUpdateNewLatLngBounds);
            }
            this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
        }
    }

    public void fitToSuppliedMarkers(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        String[] strArr = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            strArr[i] = readableArray.getString(i);
        }
        List listAsList = Arrays.asList(strArr);
        boolean z2 = false;
        for (MapFeature mapFeature : this.features) {
            if (mapFeature instanceof MapMarker) {
                String identifier = ((MapMarker) mapFeature).getIdentifier();
                Marker marker = (Marker) mapFeature.getFeature();
                if (listAsList.contains(identifier)) {
                    builder.include(marker.getPosition());
                    z2 = true;
                }
            }
        }
        if (z2) {
            CameraUpdate cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 0);
            if (readableMap != null) {
                appendMapPadding(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.animateCamera(cameraUpdateNewLatLngBounds);
            } else {
                this.map.moveCamera(cameraUpdateNewLatLngBounds);
            }
            this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
        }
    }

    public void applyBaseMapPadding(int i, int i2, int i3, int i4) {
        if (super.getHeight() <= 0 || super.getWidth() <= 0) {
            this.baseLeftMapPadding = i;
            this.baseRightMapPadding = i3;
            this.baseTopMapPadding = i2;
            this.baseBottomMapPadding = i4;
            this.setPaddingDeferred = true;
            return;
        }
        this.map.setPadding(this.edgeLeftPadding + this.baseLeftMapPadding, this.edgeTopPadding + this.baseTopMapPadding, this.edgeRightPadding + this.baseRightMapPadding, this.edgeBottomPadding + this.baseBottomMapPadding);
        CameraUpdate cameraUpdateNewCameraPosition = CameraUpdateFactory.newCameraPosition(this.map.getCameraPosition());
        this.baseLeftMapPadding = i;
        this.baseRightMapPadding = i3;
        this.baseTopMapPadding = i2;
        this.baseBottomMapPadding = i4;
        this.map.setPadding(this.edgeLeftPadding + i, this.edgeTopPadding + i2, this.edgeRightPadding + i3, this.edgeBottomPadding + i4);
        this.map.moveCamera(cameraUpdateNewCameraPosition);
        this.map.setPadding(i, i2, i3, i4);
        this.setPaddingDeferred = false;
    }

    public void fitToCoordinates(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            builder.include(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        CameraUpdate cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 0);
        if (readableMap != null) {
            appendMapPadding(readableMap.getInt(ViewProps.LEFT), readableMap.getInt(ViewProps.TOP), readableMap.getInt(ViewProps.RIGHT), readableMap.getInt(ViewProps.BOTTOM));
        }
        if (z) {
            this.map.animateCamera(cameraUpdateNewLatLngBounds);
        } else {
            this.map.moveCamera(cameraUpdateNewLatLngBounds);
        }
        this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
    }

    private void appendMapPadding(int i, int i2, int i3, int i4) {
        double d = getResources().getDisplayMetrics().density;
        int i5 = (int) (i * d);
        this.edgeLeftPadding = i5;
        int i6 = (int) (i2 * d);
        this.edgeTopPadding = i6;
        int i7 = (int) (i3 * d);
        this.edgeRightPadding = i7;
        int i8 = (int) (i4 * d);
        this.edgeBottomPadding = i8;
        this.map.setPadding(i5 + this.baseLeftMapPadding, i6 + this.baseTopMapPadding, i7 + this.baseRightMapPadding, i8 + this.baseBottomMapPadding);
    }

    public double[][] getMapBoundaries() {
        LatLngBounds latLngBounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        return new double[][]{new double[]{latLng.longitude, latLng.latitude}, new double[]{latLng2.longitude, latLng2.latitude}};
    }

    public void setMapBoundaries(ReadableMap readableMap, ReadableMap readableMap2) {
        if (this.map == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
        builder.include(new LatLng(readableMap2.getDouble("latitude"), readableMap2.getDouble("longitude")));
        this.map.setLatLngBoundsForCameraTarget(builder.build());
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return getMarkerMap(marker).getCallout();
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        return getMarkerMap(marker).getInfoContents();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tapLocation = googleMap.getProjection().fromScreenLocation(new Point(x, y));
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            GoogleMap googleMap2 = this.map;
            if (googleMap2 != null && googleMap2.getUiSettings().isScrollGesturesEnabled()) {
                z = true;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda10
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnMarkerDragStartEvent(i, i2, writableMap);
            }
        });
        getMarkerMap(marker).dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda11
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnDragStartEvent(i, i2, writableMap);
            }
        });
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda15
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnMarkerDragEvent(i, i2, writableMap);
            }
        });
        getMarkerMap(marker).dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda16
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnDragEvent(i, i2, writableMap);
            }
        });
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda12
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnMarkerDragEndEvent(i, i2, writableMap);
            }
        });
        getMarkerMap(marker).dispatchEvent(makeClickEventData(marker.getPosition()), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda13
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnDragEndEvent(i, i2, writableMap);
            }
        });
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPoiClickListener
    public void onPoiClick(PointOfInterest pointOfInterest) {
        WritableMap writableMapMakeClickEventData = makeClickEventData(pointOfInterest.latLng);
        writableMapMakeClickEventData.putString("placeId", pointOfInterest.placeId);
        writableMapMakeClickEventData.putString("name", pointOfInterest.name);
        dispatchEvent(writableMapMakeClickEventData, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda9
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnPoiClickEvent(i, i2, writableMap);
            }
        });
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.mapLoadingProgressBar == null) {
            ProgressBar progressBar = new ProgressBar(getContext());
            this.mapLoadingProgressBar = progressBar;
            progressBar.setIndeterminate(true);
        }
        Integer num = this.loadingIndicatorColor;
        if (num != null) {
            setLoadingIndicatorColor(num);
        }
        return this.mapLoadingProgressBar;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.mapLoadingLayout == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.mapLoadingLayout = relativeLayout;
            relativeLayout.setBackgroundColor(-3355444);
            addView(this.mapLoadingLayout, new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mapLoadingLayout.addView(getMapLoadingProgressBar(), layoutParams);
            this.mapLoadingLayout.setVisibility(4);
        }
        setLoadingBackgroundColor(this.loadingBackgroundColor);
        return this.mapLoadingLayout;
    }

    private ImageView getCacheImageView() {
        if (this.cacheImageView == null) {
            ImageView imageView = new ImageView(getContext());
            this.cacheImageView = imageView;
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            this.cacheImageView.setVisibility(4);
        }
        return this.cacheImageView;
    }

    private void removeCacheImageView() {
        ImageView imageView = this.cacheImageView;
        if (imageView != null) {
            ((ViewGroup) imageView.getParent()).removeView(this.cacheImageView);
            this.cacheImageView = null;
        }
    }

    private void removeMapLoadingProgressBar() {
        ProgressBar progressBar = this.mapLoadingProgressBar;
        if (progressBar != null) {
            ((ViewGroup) progressBar.getParent()).removeView(this.mapLoadingProgressBar);
            this.mapLoadingProgressBar = null;
        }
    }

    private void removeMapLoadingLayoutView() {
        removeMapLoadingProgressBar();
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout != null) {
            ((ViewGroup) relativeLayout.getParent()).removeView(this.mapLoadingLayout);
            this.mapLoadingLayout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheView() {
        if (this.cacheEnabled) {
            final ImageView cacheImageView = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.isMapLoaded.booleanValue()) {
                this.map.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.maps.MapView.10
                    @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                    public void onSnapshotReady(Bitmap bitmap) {
                        cacheImageView.setImageBitmap(bitmap);
                        cacheImageView.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        removeCacheImageView();
        if (this.isMapLoaded.booleanValue()) {
            removeMapLoadingLayoutView();
        }
    }

    public void onPanDrag(MotionEvent motionEvent) {
        dispatchEvent(makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda0
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnPanDragEvent(i, i2, writableMap);
            }
        });
    }

    public void onDoublePress(MotionEvent motionEvent) {
        if (this.map == null) {
            return;
        }
        dispatchEvent(makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda14
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i, int i2, WritableMap writableMap) {
                return new OnDoublePressEvent(i, i2, writableMap);
            }
        });
    }

    public void setKmlSrc(String str) throws ExecutionException, InterruptedException {
        if (this.isMapReady.booleanValue()) {
            try {
                InputStream inputStream = new FileUtil(this.context).execute(str).get();
                if (inputStream == null) {
                    return;
                }
                KmlLayer kmlLayer = new KmlLayer(this.map, inputStream, this.context, this.markerManager, this.polygonManager, this.polylineManager, this.groundOverlayManager, (Renderer.ImagesCache) null);
                kmlLayer.addLayerToMap();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                if (kmlLayer.getContainers() == null) {
                    dispatchEvent(writableNativeMap, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda19
                        @Override // com.rnmaps.maps.MapView.EventCreator
                        public final Event create(int i, int i2, WritableMap writableMap) {
                            return new OnKmlReadyEvent(i, i2, writableMap);
                        }
                    });
                    return;
                }
                KmlContainer next = kmlLayer.getContainers().iterator().next();
                if (next != null && next.getContainers() != null) {
                    if (next.getContainers().iterator().hasNext()) {
                        next = next.getContainers().iterator().next();
                    }
                    for (KmlPlacemark kmlPlacemark : next.getPlacemarks()) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        if (kmlPlacemark.getInlineStyle() != null) {
                            markerOptions = kmlPlacemark.getMarkerOptions();
                        } else {
                            markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
                        }
                        LatLng latLng = (LatLng) kmlPlacemark.getGeometry().getGeometryObject();
                        String property = "";
                        String property2 = kmlPlacemark.hasProperty("name") ? kmlPlacemark.getProperty("name") : "";
                        if (kmlPlacemark.hasProperty("description")) {
                            property = kmlPlacemark.getProperty("description");
                        }
                        markerOptions.position(latLng);
                        markerOptions.title(property2);
                        markerOptions.snippet(property);
                    }
                    writableNativeMap.putArray("markers", writableNativeArray);
                    dispatchEvent(new WritableNativeMap(), new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda19
                        @Override // com.rnmaps.maps.MapView.EventCreator
                        public final Event create(int i, int i2, WritableMap writableMap) {
                            return new OnKmlReadyEvent(i, i2, writableMap);
                        }
                    });
                    return;
                }
                dispatchEvent(writableNativeMap, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda19
                    @Override // com.rnmaps.maps.MapView.EventCreator
                    public final Event create(int i, int i2, WritableMap writableMap) {
                        return new OnKmlReadyEvent(i, i2, writableMap);
                    }
                });
                return;
            } catch (IOException | InterruptedException | ExecutionException | XmlPullParserException e) {
                e.printStackTrace();
                return;
            }
        }
        this.kmlSrc = str;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
    public void onIndoorBuildingFocused() {
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        int i = 0;
        if (focusedBuilding != null) {
            List<IndoorLevel> levels = focusedBuilding.getLevels();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (IndoorLevel indoorLevel : levels) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("index", i);
                writableMapCreateMap.putString("name", indoorLevel.getName());
                writableMapCreateMap.putString("shortName", indoorLevel.getShortName());
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i++;
            }
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putArray("levels", writableArrayCreateArray);
            writableMapCreateMap2.putInt("activeLevelIndex", focusedBuilding.getActiveLevelIndex());
            writableMapCreateMap2.putBoolean("underground", focusedBuilding.isUnderground());
            dispatchEvent(writableMapCreateMap2, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda18
                @Override // com.rnmaps.maps.MapView.EventCreator
                public final Event create(int i2, int i3, WritableMap writableMap) {
                    return new OnIndoorBuildingFocusedEvent(i2, i3, writableMap);
                }
            });
            return;
        }
        ReadableArray readableArrayCreateArray = Arguments.createArray();
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putArray("levels", readableArrayCreateArray);
        writableMapCreateMap3.putInt("activeLevelIndex", 0);
        writableMapCreateMap3.putBoolean("underground", false);
        dispatchEvent(writableMapCreateMap3, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda18
            @Override // com.rnmaps.maps.MapView.EventCreator
            public final Event create(int i2, int i3, WritableMap writableMap) {
                return new OnIndoorBuildingFocusedEvent(i2, i3, writableMap);
            }
        });
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener
    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        int activeLevelIndex;
        if (indoorBuilding != null && (activeLevelIndex = indoorBuilding.getActiveLevelIndex()) >= 0 && activeLevelIndex < indoorBuilding.getLevels().size()) {
            IndoorLevel indoorLevel = indoorBuilding.getLevels().get(activeLevelIndex);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("activeLevelIndex", activeLevelIndex);
            writableMapCreateMap.putString("name", indoorLevel.getName());
            writableMapCreateMap.putString("shortName", indoorLevel.getShortName());
            dispatchEvent(writableMapCreateMap, new EventCreator() { // from class: com.rnmaps.maps.MapView$$ExternalSyntheticLambda17
                @Override // com.rnmaps.maps.MapView.EventCreator
                public final Event create(int i, int i2, WritableMap writableMap) {
                    return new OnIndoorLevelActivatedEvent(i, i2, writableMap);
                }
            });
        }
    }

    public void setIndoorActiveLevelIndex(int i) {
        IndoorLevel indoorLevel;
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        if (focusedBuilding == null || i < 0 || i >= focusedBuilding.getLevels().size() || (indoorLevel = focusedBuilding.getLevels().get(i)) == null) {
            return;
        }
        indoorLevel.activate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapMarker getMarkerMap(Marker marker) {
        MapMarker mapMarker = (MapMarker) this.markerMap.get(marker);
        if (mapMarker != null) {
            return mapMarker;
        }
        for (Map.Entry entry : this.markerMap.entrySet()) {
            if (((Marker) entry.getKey()).getPosition().equals(marker.getPosition()) && ((Marker) entry.getKey()).getTitle().equals(marker.getTitle())) {
                return (MapMarker) entry.getValue();
            }
        }
        return mapMarker;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }
}
