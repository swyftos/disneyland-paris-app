package com.reactnativecommunity.geolocation;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes4.dex */
public class RNCGeolocationModule extends NativeRNCGeolocationSpec {
    public static final String NAME = "RNCGeolocation";
    GeolocationModule mImpl;

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    public void addListener(String str) {
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    public void removeListeners(double d) {
    }

    RNCGeolocationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mImpl = new GeolocationModule(reactApplicationContext);
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "RNCGeolocation";
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    @ReactMethod
    public void setConfiguration(ReadableMap readableMap) {
        this.mImpl.setConfiguration(readableMap);
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    @ReactMethod
    public void requestAuthorization(Callback callback, Callback callback2) {
        this.mImpl.requestAuthorization(callback, callback2);
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    @ReactMethod
    public void getCurrentPosition(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mImpl.getCurrentPosition(readableMap, callback, callback2);
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    @ReactMethod
    public void startObserving(ReadableMap readableMap) {
        this.mImpl.startObserving(readableMap);
    }

    @Override // com.reactnativecommunity.geolocation.NativeRNCGeolocationSpec
    @ReactMethod
    public void stopObserving() {
        this.mImpl.stopObserving();
    }
}
