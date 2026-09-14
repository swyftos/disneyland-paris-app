package com.reactnativecommunity.geolocation;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNCGeolocationSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNCGeolocation";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentPosition(ReadableMap readableMap, Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void requestAuthorization(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void setConfiguration(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void startObserving(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void stopObserving();

    public NativeRNCGeolocationSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNCGeolocation";
    }
}
