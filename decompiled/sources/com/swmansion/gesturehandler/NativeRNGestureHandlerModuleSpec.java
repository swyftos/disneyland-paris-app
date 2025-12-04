package com.swmansion.gesturehandler;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
public abstract class NativeRNGestureHandlerModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGestureHandlerModule";

    @DoNotStrip
    @ReactMethod
    public abstract void attachGestureHandler(double d, double d2, double d3);

    @DoNotStrip
    @ReactMethod
    public abstract void createGestureHandler(String str, double d, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void dropGestureHandler(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void flushOperations();

    @DoNotStrip
    @ReactMethod
    public abstract void handleClearJSResponder();

    @DoNotStrip
    @ReactMethod
    public abstract void handleSetJSResponder(double d, boolean z);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean install();

    @DoNotStrip
    @ReactMethod
    public abstract void updateGestureHandler(double d, ReadableMap readableMap);

    public NativeRNGestureHandlerModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNGestureHandlerModule";
    }
}
