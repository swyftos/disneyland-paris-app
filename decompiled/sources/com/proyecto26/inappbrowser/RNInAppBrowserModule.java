package com.proyecto26.inappbrowser;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNInAppBrowserModule.NAME)
/* loaded from: classes4.dex */
public class RNInAppBrowserModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNInAppBrowser";
    private final ReactApplicationContext reactContext;

    public RNInAppBrowserModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) throws SecurityException {
        RNInAppBrowser.getInstance().open(this.reactContext, readableMap, promise, getCurrentActivity());
    }

    @ReactMethod
    public void close() {
        RNInAppBrowser.getInstance().close();
    }

    @ReactMethod
    public void isAvailable(Promise promise) {
        RNInAppBrowser.getInstance().isAvailable(this.reactContext, promise);
    }

    public static void onStart(Activity activity) {
        RNInAppBrowser.getInstance().onStart(activity);
    }

    @ReactMethod
    public void warmup(Promise promise) {
        RNInAppBrowser.getInstance().warmup(promise);
    }

    @ReactMethod
    public void mayLaunchUrl(String str, ReadableArray readableArray) {
        RNInAppBrowser.getInstance().mayLaunchUrl(str, readableArray);
    }
}
