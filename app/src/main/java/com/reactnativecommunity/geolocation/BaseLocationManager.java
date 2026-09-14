package com.reactnativecommunity.geolocation;

import android.location.Location;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.urbanairship.audience.AudienceOverridesProvider;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseLocationManager {
    protected static final float RCT_DEFAULT_LOCATION_ACCURACY = 100.0f;
    public ReactApplicationContext mReactContext;

    public abstract void getCurrentLocationData(ReadableMap readableMap, Callback callback, Callback callback2);

    public abstract void startObserving(ReadableMap readableMap);

    public abstract void stopObserving();

    protected BaseLocationManager(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    protected static WritableMap locationToMap(Location location) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("latitude", location.getLatitude());
        writableMapCreateMap2.putDouble("longitude", location.getLongitude());
        writableMapCreateMap2.putDouble("altitude", location.getAltitude());
        writableMapCreateMap2.putDouble("accuracy", location.getAccuracy());
        writableMapCreateMap2.putDouble("heading", location.getBearing());
        writableMapCreateMap2.putDouble("speed", location.getSpeed());
        writableMapCreateMap.putMap("coords", writableMapCreateMap2);
        writableMapCreateMap.putDouble("timestamp", location.getTime());
        Bundle extras = location.getExtras();
        if (extras != null) {
            WritableMap writableMapCreateMap3 = Arguments.createMap();
            for (String str : extras.keySet()) {
                putIntoMap(writableMapCreateMap3, str, extras.get(str));
            }
            writableMapCreateMap.putMap("extras", writableMapCreateMap3);
        }
        writableMapCreateMap.putBoolean("mocked", location.isFromMockProvider());
        return writableMapCreateMap;
    }

    protected static void putIntoMap(WritableMap writableMap, String str, Object obj) {
        if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            writableMap.putInt(str, ((Long) obj).intValue());
            return;
        }
        if (obj instanceof Float) {
            writableMap.putDouble(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if ((obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof double[]) || (obj instanceof String[]) || (obj instanceof boolean[])) {
            writableMap.putArray(str, Arguments.fromArray(obj));
        }
    }

    protected void emitError(int i, String str) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(i, str));
    }

    protected static class LocationOptions {
        protected final float distanceFilter;
        protected final int fastestInterval;
        protected final boolean highAccuracy;
        protected final int interval;
        protected final double maximumAge;
        protected final long timeout;

        private LocationOptions(int i, int i2, long j, double d, boolean z, float f) {
            this.interval = i;
            this.fastestInterval = i2;
            this.timeout = j;
            this.maximumAge = d;
            this.highAccuracy = z;
            this.distanceFilter = f;
        }

        protected static LocationOptions fromReactMap(ReadableMap readableMap) {
            return new LocationOptions(readableMap.hasKey("interval") ? readableMap.getInt("interval") : 10000, readableMap.hasKey("fastestInterval") ? readableMap.getInt("fastestInterval") : -1, readableMap.hasKey("timeout") ? (long) readableMap.getDouble("timeout") : AudienceOverridesProvider.EXPIRY_MS, readableMap.hasKey("maximumAge") ? readableMap.getDouble("maximumAge") : Double.POSITIVE_INFINITY, readableMap.hasKey("enableHighAccuracy") && readableMap.getBoolean("enableHighAccuracy"), readableMap.hasKey("distanceFilter") ? (float) readableMap.getDouble("distanceFilter") : BaseLocationManager.RCT_DEFAULT_LOCATION_ACCURACY);
        }
    }
}
