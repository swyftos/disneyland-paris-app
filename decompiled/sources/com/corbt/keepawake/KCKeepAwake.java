package com.corbt.keepawake;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes3.dex */
public class KCKeepAwake extends ReactContextBaseJavaModule {
    public KCKeepAwake(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "KCKeepAwake";
    }

    @ReactMethod
    public void activate() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.corbt.keepawake.KCKeepAwake.1
                @Override // java.lang.Runnable
                public void run() {
                    currentActivity.getWindow().addFlags(128);
                }
            });
        }
    }

    @ReactMethod
    public void deactivate() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.corbt.keepawake.KCKeepAwake.2
                @Override // java.lang.Runnable
                public void run() {
                    currentActivity.getWindow().clearFlags(128);
                }
            });
        }
    }
}
