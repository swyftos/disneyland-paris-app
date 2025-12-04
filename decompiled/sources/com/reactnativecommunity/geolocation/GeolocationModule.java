package com.reactnativecommunity.geolocation;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SystemClock;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import javax.annotation.Nullable;

@ReactModule(name = GeolocationModule.NAME)
@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
public class GeolocationModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNCGeolocation";
    private static final float RCT_DEFAULT_LOCATION_ACCURACY = 100.0f;
    private final LocationListener mLocationListener;

    @Nullable
    private String mWatchedProvider;

    public GeolocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mLocationListener = new LocationListener() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.1
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) GeolocationModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", GeolocationModule.locationToMap(location));
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
                if (i == 0) {
                    GeolocationModule.this.emitError(PositionError.POSITION_UNAVAILABLE, "Provider " + str + " is out of service.");
                    return;
                }
                if (i == 1) {
                    GeolocationModule.this.emitError(PositionError.TIMEOUT, "Provider " + str + " is temporarily unavailable.");
                }
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private static class LocationOptions {
        private final float distanceFilter;
        private final boolean highAccuracy;
        private final double maximumAge;
        private final long timeout;

        private LocationOptions(long j, double d, boolean z, float f) {
            this.timeout = j;
            this.maximumAge = d;
            this.highAccuracy = z;
            this.distanceFilter = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LocationOptions fromReactMap(ReadableMap readableMap) {
            return new LocationOptions(readableMap.hasKey("timeout") ? (long) readableMap.getDouble("timeout") : Long.MAX_VALUE, readableMap.hasKey("maximumAge") ? readableMap.getDouble("maximumAge") : Double.POSITIVE_INFINITY, readableMap.hasKey("enableHighAccuracy") && readableMap.getBoolean("enableHighAccuracy"), readableMap.hasKey("distanceFilter") ? (float) readableMap.getDouble("distanceFilter") : GeolocationModule.RCT_DEFAULT_LOCATION_ACCURACY);
        }
    }

    @ReactMethod
    public void getCurrentPosition(final ReadableMap readableMap, final Callback callback, final Callback callback2) {
        final PermissionsModule permissionsModule = (PermissionsModule) getReactApplicationContext().getNativeModule(PermissionsModule.class);
        final Callback callback3 = new Callback() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.2
            @Override // com.facebook.react.bridge.Callback
            public void invoke(Object... objArr) {
                if (((String) objArr[0]) == "granted") {
                    GeolocationModule.this.getCurrentLocationData(readableMap, callback, callback2);
                } else {
                    callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Location permission was not granted."));
                }
            }
        };
        final Callback callback4 = new Callback() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.3
            @Override // com.facebook.react.bridge.Callback
            public void invoke(Object... objArr) {
                callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Failed to request location permission."));
            }
        };
        permissionsModule.checkPermission("android.permission.ACCESS_FINE_LOCATION", new PromiseImpl(new Callback() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.5
            @Override // com.facebook.react.bridge.Callback
            public void invoke(Object... objArr) {
                if (!((Boolean) objArr[0]).booleanValue()) {
                    permissionsModule.requestPermission("android.permission.ACCESS_FINE_LOCATION", new PromiseImpl(callback3, callback4));
                } else {
                    GeolocationModule.this.getCurrentLocationData(readableMap, callback, callback2);
                }
            }
        }, new Callback() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.4
            @Override // com.facebook.react.bridge.Callback
            public void invoke(Object... objArr) {
                callback2.invoke(PositionError.buildError(PositionError.PERMISSION_DENIED, "Failed to check location permission."));
            }
        }));
    }

    public void getCurrentLocationData(ReadableMap readableMap, Callback callback, Callback callback2) {
        LocationOptions locationOptionsFromReactMap = LocationOptions.fromReactMap(readableMap);
        try {
            LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService("location");
            String validProvider = getValidProvider(locationManager, locationOptionsFromReactMap.highAccuracy);
            if (validProvider == null) {
                callback2.invoke(PositionError.buildError(PositionError.POSITION_UNAVAILABLE, "No location provider available."));
                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(validProvider);
            if (lastKnownLocation != null && SystemClock.currentTimeMillis() - lastKnownLocation.getTime() < locationOptionsFromReactMap.maximumAge) {
                callback.invoke(locationToMap(lastKnownLocation));
            } else {
                new SingleUpdateRequest(locationManager, validProvider, locationOptionsFromReactMap.timeout, callback, callback2).invoke(lastKnownLocation);
            }
        } catch (SecurityException e) {
            throwLocationPermissionMissing(e);
        }
    }

    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        if ("gps".equals(this.mWatchedProvider)) {
            return;
        }
        LocationOptions locationOptionsFromReactMap = LocationOptions.fromReactMap(readableMap);
        try {
            LocationManager locationManager = (LocationManager) getReactApplicationContext().getSystemService("location");
            String validProvider = getValidProvider(locationManager, locationOptionsFromReactMap.highAccuracy);
            if (validProvider == null) {
                emitError(PositionError.POSITION_UNAVAILABLE, "No location provider available.");
                return;
            }
            if (!validProvider.equals(this.mWatchedProvider)) {
                locationManager.removeUpdates(this.mLocationListener);
                locationManager.requestLocationUpdates(validProvider, 1000L, locationOptionsFromReactMap.distanceFilter, this.mLocationListener);
            }
            this.mWatchedProvider = validProvider;
        } catch (SecurityException e) {
            throwLocationPermissionMissing(e);
        }
    }

    @ReactMethod
    public void stopObserving() {
        ((LocationManager) getReactApplicationContext().getSystemService("location")).removeUpdates(this.mLocationListener);
        this.mWatchedProvider = null;
    }

    @Nullable
    private String getValidProvider(LocationManager locationManager, boolean z) {
        String str = TCEventPropertiesNames.TCN_NETWORK;
        String str2 = z ? "gps" : TCEventPropertiesNames.TCN_NETWORK;
        if (!locationManager.isProviderEnabled(str2)) {
            if (!str2.equals("gps")) {
                str = "gps";
            }
            if (!locationManager.isProviderEnabled(str)) {
                return null;
            }
            str2 = str;
        }
        int iCheckSelfPermission = ContextCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
        if (!str2.equals("gps") || iCheckSelfPermission == 0) {
            return str2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WritableMap locationToMap(Location location) {
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
        writableMapCreateMap.putBoolean("mocked", location.isFromMockProvider());
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(int i, String str) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(i, str));
    }

    private static void throwLocationPermissionMissing(SecurityException securityException) {
        throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", securityException);
    }

    private static class SingleUpdateRequest {
        private final Callback mError;
        private final Handler mHandler;
        private final LocationListener mLocationListener;
        private final LocationManager mLocationManager;
        private Location mOldLocation;
        private final String mProvider;
        private final Callback mSuccess;
        private final long mTimeout;
        private final Runnable mTimeoutRunnable;
        private boolean mTriggered;

        private SingleUpdateRequest(LocationManager locationManager, String str, long j, Callback callback, Callback callback2) {
            this.mHandler = new Handler();
            this.mTimeoutRunnable = new Runnable() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.SingleUpdateRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (SingleUpdateRequest.this) {
                        try {
                            if (!SingleUpdateRequest.this.mTriggered) {
                                SingleUpdateRequest.this.mError.invoke(PositionError.buildError(PositionError.TIMEOUT, "Location request timed out"));
                                SingleUpdateRequest.this.mLocationManager.removeUpdates(SingleUpdateRequest.this.mLocationListener);
                                FLog.i(ReactConstants.TAG, "LocationModule: Location request timed out");
                                SingleUpdateRequest.this.mTriggered = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            this.mLocationListener = new LocationListener() { // from class: com.reactnativecommunity.geolocation.GeolocationModule.SingleUpdateRequest.2
                @Override // android.location.LocationListener
                public void onProviderDisabled(String str2) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str2) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str2, int i, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    synchronized (SingleUpdateRequest.this) {
                        try {
                            if (!SingleUpdateRequest.this.mTriggered) {
                                SingleUpdateRequest singleUpdateRequest = SingleUpdateRequest.this;
                                if (singleUpdateRequest.isBetterLocation(location, singleUpdateRequest.mOldLocation)) {
                                    SingleUpdateRequest.this.mSuccess.invoke(GeolocationModule.locationToMap(location));
                                    SingleUpdateRequest.this.mHandler.removeCallbacks(SingleUpdateRequest.this.mTimeoutRunnable);
                                    SingleUpdateRequest.this.mTriggered = true;
                                    SingleUpdateRequest.this.mLocationManager.removeUpdates(SingleUpdateRequest.this.mLocationListener);
                                }
                            }
                            SingleUpdateRequest.this.mOldLocation = location;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            this.mLocationManager = locationManager;
            this.mProvider = str;
            this.mTimeout = j;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public void invoke(Location location) {
            this.mOldLocation = location;
            this.mLocationManager.requestLocationUpdates(this.mProvider, 100L, 1.0f, this.mLocationListener);
            this.mHandler.postDelayed(this.mTimeoutRunnable, this.mTimeout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isBetterLocation(Location location, Location location2) {
            if (location2 == null) {
                return true;
            }
            long time = location.getTime() - location2.getTime();
            boolean z = time > 120000;
            boolean z2 = time < -120000;
            boolean z3 = time > 0;
            if (z) {
                return true;
            }
            if (z2) {
                return false;
            }
            int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
            boolean z4 = accuracy > 0;
            boolean z5 = accuracy < 0;
            boolean z6 = accuracy > 200;
            boolean zIsSameProvider = isSameProvider(location.getProvider(), location2.getProvider());
            if (z5) {
                return true;
            }
            if (!z3 || z4) {
                return z3 && !z6 && zIsSameProvider;
            }
            return true;
        }

        private boolean isSameProvider(String str, String str2) {
            if (str == null) {
                return str2 == null;
            }
            return str.equals(str2);
        }
    }
}
