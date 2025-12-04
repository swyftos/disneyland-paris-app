package com.contentsquare.rn.erroranalysis;

import android.util.Log;
import com.contentsquare.android.api.bridge.reactnative.ReactNativeBridge;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.contentsquare.rn.utils.ReactNativeTypesConverter;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ErrorAnalysisModule extends ReactContextBaseJavaModule {
    private static final String NAME = "ErrorAnalysisModule";

    public ErrorAnalysisModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setURLMaskingPatterns(ReadableArray readableArray) {
        ErrorAnalysis.setUrlMaskingPatterns(ReactNativeTypesConverter.readableArrayToStringList(readableArray));
    }

    @ReactMethod
    public void triggerNativeCrash() {
        throw new RuntimeException("This is purposely triggered native crash");
    }

    @ReactMethod
    public void reportJavascriptError(ReadableMap readableMap, Promise promise) {
        try {
            ReactNativeBridge.sendError(ReactNativeTypesConverter.readableMapToMap(readableMap, Arrays.asList("timestamp"), Arrays.asList("lineNumber", "frameId", "column")));
            promise.resolve("Reported javascript error to native module");
        } catch (Exception e) {
            Log.e("CSLIB", "Exception failure while calling sendReactNativeError", e);
            promise.reject("Failed to report javascript error to native module", e.getMessage());
        }
    }
}
