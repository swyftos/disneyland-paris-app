package com.dlp;

import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Version extends ReactContextBaseJavaModule {
    private static final String APP_VERSION = "appVersion";
    private static final String BRAND = "brand";
    private static final String DEVICE_TYPE = "deviceType";
    private static final String MODEL = "model";
    private final String deviceType;
    private final ReactApplicationContext reactContext;

    public Version(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.deviceType = getDeviceType(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Version";
    }

    private static String getDeviceType(ReactApplicationContext reactApplicationContext) {
        WindowManager windowManager = (WindowManager) reactApplicationContext.getSystemService("window");
        if (windowManager == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        float f = displayMetrics.heightPixels / displayMetrics.ydpi;
        float f2 = displayMetrics.widthPixels / displayMetrics.xdpi;
        if (Math.sqrt((f2 * f2) + (f * f)) >= 6.9d) {
            return "tablet";
        }
        return "mobile";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        try {
            map.put(APP_VERSION, this.reactContext.getPackageManager().getPackageInfo(this.reactContext.getPackageName(), 0).versionName);
            map.put(DEVICE_TYPE, this.deviceType);
            map.put("model", Build.MODEL);
            map.put("brand", Build.BRAND);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}
