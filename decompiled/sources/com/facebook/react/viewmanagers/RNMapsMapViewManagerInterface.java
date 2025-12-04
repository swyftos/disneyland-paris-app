package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
public interface RNMapsMapViewManagerInterface<T extends View> {
    void animateCamera(T t, String str, int i);

    void animateToRegion(T t, String str, int i);

    void fitToCoordinates(T t, String str, String str2, boolean z);

    void fitToElements(T t, String str, boolean z);

    void fitToSuppliedMarkers(T t, String str, String str2, boolean z);

    void setCacheEnabled(T t, boolean z);

    void setCamera(T t, @Nullable ReadableMap readableMap);

    void setCamera(T t, String str);

    void setCameraZoomRange(T t, @Nullable ReadableMap readableMap);

    void setCompassOffset(T t, @Nullable ReadableMap readableMap);

    void setCustomMapStyleString(T t, @Nullable String str);

    void setFollowsUserLocation(T t, boolean z);

    void setGoogleMapId(T t, @Nullable String str);

    void setGoogleRenderer(T t, @Nullable String str);

    void setHandlePanDrag(T t, boolean z);

    void setIndoorActiveLevelIndex(T t, int i);

    void setInitialCamera(T t, @Nullable ReadableMap readableMap);

    void setInitialRegion(T t, @Nullable ReadableMap readableMap);

    void setKmlSrc(T t, @Nullable String str);

    void setLegalLabelInsets(T t, @Nullable ReadableMap readableMap);

    void setLiteMode(T t, boolean z);

    void setLoadingBackgroundColor(T t, @Nullable Integer num);

    void setLoadingEnabled(T t, boolean z);

    void setLoadingIndicatorColor(T t, @Nullable Integer num);

    void setMapPadding(T t, @Nullable ReadableMap readableMap);

    void setMapType(T t, @Nullable String str);

    void setMaxDelta(T t, double d);

    void setMaxZoom(T t, float f);

    void setMinDelta(T t, double d);

    void setMinZoom(T t, float f);

    void setMoveOnMarkerPress(T t, boolean z);

    void setPaddingAdjustmentBehavior(T t, @Nullable String str);

    void setPitchEnabled(T t, boolean z);

    void setPoiClickEnabled(T t, boolean z);

    void setRegion(T t, @Nullable ReadableMap readableMap);

    void setRotateEnabled(T t, boolean z);

    void setScrollDuringRotateOrZoomEnabled(T t, boolean z);

    void setScrollEnabled(T t, boolean z);

    void setShowsBuildings(T t, boolean z);

    void setShowsCompass(T t, boolean z);

    void setShowsIndoorLevelPicker(T t, boolean z);

    void setShowsIndoors(T t, boolean z);

    void setShowsMyLocationButton(T t, boolean z);

    void setShowsScale(T t, boolean z);

    void setShowsTraffic(T t, boolean z);

    void setShowsUserLocation(T t, boolean z);

    void setTintColor(T t, @Nullable Integer num);

    void setToolbarEnabled(T t, boolean z);

    void setUserInterfaceStyle(T t, @Nullable String str);

    void setUserLocationAnnotationTitle(T t, @Nullable String str);

    void setUserLocationCalloutEnabled(T t, boolean z);

    void setUserLocationFastestInterval(T t, int i);

    void setUserLocationPriority(T t, @Nullable String str);

    void setUserLocationUpdateInterval(T t, int i);

    void setZoomControlEnabled(T t, boolean z);

    void setZoomEnabled(T t, boolean z);

    void setZoomTapEnabled(T t, boolean z);
}
