package com.dlp;

import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.core.location.LocationManagerCompat;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes3.dex */
public class DLPModule extends ReactContextBaseJavaModule {
    public DLPModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "DLPModule";
    }

    @ReactMethod
    public void isLocationEnabled(Promise promise) {
        promise.resolve(Boolean.valueOf(LocationManagerCompat.isLocationEnabled((LocationManager) getReactApplicationContext().getSystemService("location"))));
    }
}
