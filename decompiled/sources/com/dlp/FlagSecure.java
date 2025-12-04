package com.dlp;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes3.dex */
public class FlagSecure extends ReactContextBaseJavaModule {
    static final String TAG = "FlagSecure";

    public FlagSecure(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return TAG;
    }

    private void setFlagSecure(boolean z) {
        try {
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                if (z) {
                    currentActivity.runOnUiThread(new Runnable() { // from class: com.dlp.FlagSecure$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlagSecure.lambda$setFlagSecure$0(currentActivity);
                        }
                    });
                } else {
                    currentActivity.runOnUiThread(new Runnable() { // from class: com.dlp.FlagSecure$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlagSecure.lambda$setFlagSecure$1(currentActivity);
                        }
                    });
                }
                Log.i(TAG, "FLAG_SECURE set");
                return;
            }
            Log.w(TAG, "No activity found to set FLAG_SECURE flag on");
        } catch (Exception e) {
            Log.e(TAG, "Error setting FLAG_SECURE", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setFlagSecure$0(Activity activity) {
        activity.getWindow().addFlags(8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setFlagSecure$1(Activity activity) {
        activity.getWindow().clearFlags(8192);
    }

    @ReactMethod
    public void activate() {
        setFlagSecure(true);
    }

    @ReactMethod
    public void deactivate() {
        setFlagSecure(false);
    }

    @ReactMethod
    public void isActive(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            promise.resolve(Boolean.valueOf((currentActivity.getWindow().getAttributes().flags & 8192) != 0));
        }
        promise.resolve(Boolean.FALSE);
    }
}
