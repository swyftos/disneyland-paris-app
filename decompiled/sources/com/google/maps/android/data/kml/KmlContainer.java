package com.google.maps.android.data.kml;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class KmlContainer {
    private String mContainerId;
    private final ArrayList mContainers;
    private final HashMap mGroundOverlays;
    private final HashMap mPlacemarks;
    private final HashMap mProperties;
    private final HashMap mStyleMap;
    private HashMap mStyles;

    KmlContainer(HashMap map, HashMap map2, HashMap map3, HashMap map4, ArrayList arrayList, HashMap map5, String str) {
        this.mProperties = map;
        this.mPlacemarks = map3;
        this.mStyles = map2;
        this.mStyleMap = map4;
        this.mContainers = arrayList;
        this.mGroundOverlays = map5;
        this.mContainerId = str;
    }

    HashMap getStyles() {
        return this.mStyles;
    }

    void setPlacemark(KmlPlacemark kmlPlacemark, Object obj) {
        this.mPlacemarks.put(kmlPlacemark, obj);
    }

    HashMap getStyleMap() {
        return this.mStyleMap;
    }

    HashMap getGroundOverlayHashMap() {
        return this.mGroundOverlays;
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    public KmlStyle getStyle(String str) {
        return (KmlStyle) this.mStyles.get(str);
    }

    public String getStyleIdFromMap(String str) {
        return (String) this.mStyleMap.get(str);
    }

    HashMap getPlacemarksHashMap() {
        return this.mPlacemarks;
    }

    public String getProperty(String str) {
        return (String) this.mProperties.get(str);
    }

    public boolean hasProperties() {
        return this.mProperties.size() > 0;
    }

    public boolean hasProperty(String str) {
        return this.mProperties.containsKey(str);
    }

    public boolean hasContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.mContainers;
    }

    public Iterable<String> getProperties() {
        return this.mProperties.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.mPlacemarks.keySet();
    }

    public boolean hasPlacemarks() {
        return this.mPlacemarks.size() > 0;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.mGroundOverlays.keySet();
    }

    @NonNull
    public String toString() {
        return "Container{\n properties=" + this.mProperties + ",\n placemarks=" + this.mPlacemarks + ",\n containers=" + this.mContainers + ",\n ground overlays=" + this.mGroundOverlays + ",\n style maps=" + this.mStyleMap + ",\n styles=" + this.mStyles + "\n}\n";
    }
}
