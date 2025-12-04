package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes3.dex */
public abstract class NativeAirMapsModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNMapsAirModule";

    @DoNotStrip
    @ReactMethod
    public abstract void getAddressFromCoordinates(double d, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getCamera(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getCoordinateForPoint(double d, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getMapBoundaries(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getMarkersFrames(double d, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getPointForCoordinate(double d, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void takeSnapshot(double d, String str, Promise promise);

    public NativeAirMapsModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
