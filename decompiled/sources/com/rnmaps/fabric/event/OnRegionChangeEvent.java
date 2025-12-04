package com.rnmaps.fabric.event;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public class OnRegionChangeEvent extends Event<OnRegionChangeEvent> {
    public static final String EVENT_NAME = "topRegionChange";
    private final WritableMap payload;

    public OnRegionChangeEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.payload = writableMap;
    }

    public static WritableMap payLoadFor(LatLngBounds latLngBounds, boolean z, boolean z2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", z);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        LatLng center = latLngBounds.getCenter();
        writableNativeMap2.putDouble("latitude", center.latitude);
        writableNativeMap2.putDouble("longitude", center.longitude);
        writableNativeMap2.putDouble("latitudeDelta", latLngBounds.northeast.latitude - latLngBounds.southwest.latitude);
        writableNativeMap2.putDouble("longitudeDelta", latLngBounds.northeast.longitude - latLngBounds.southwest.longitude);
        writableNativeMap.putMap("region", writableNativeMap2);
        writableNativeMap.putBoolean("isGesture", z2);
        return writableNativeMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    @NonNull
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        return this.payload;
    }
}
