package com.github.doomsower;

import android.app.Activity;
import android.os.SystemClock;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNStartupTimeModule.NAME)
/* loaded from: classes3.dex */
public class RNStartupTimeModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNStartupTime";
    private boolean alreadyInvoked;
    private final boolean enforceSingleInvocation;
    private final long startMark;

    public RNStartupTimeModule(ReactApplicationContext reactApplicationContext, long j, boolean z) {
        super(reactApplicationContext);
        this.startMark = j;
        this.enforceSingleInvocation = z;
        this.alreadyInvoked = false;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getTimeSinceStartup(Promise promise) {
        try {
            if (this.enforceSingleInvocation && this.alreadyInvoked) {
                throw new IllegalStateException("Redundant invocation of `getTimeSinceStartup`. To prevent adulteration of your analytics data, this request was aborted");
            }
            this.alreadyInvoked = true;
            int iUptimeMillis = (int) (SystemClock.uptimeMillis() - this.startMark);
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.reportFullyDrawn();
            }
            promise.resolve(Integer.valueOf(iUptimeMillis));
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
