package com.dlp;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;

/* loaded from: classes3.dex */
public class OpenSettings extends ReactContextBaseJavaModule {
    private ReactApplicationContext reactContext;

    public OpenSettings(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "OpenSettings";
    }

    @ReactMethod
    public void openSettings(String str) {
        if ("general".equals(str)) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.reactContext.getPackageName(), null));
            intent.addFlags(268435456);
            this.reactContext.startActivity(intent);
            return;
        }
        if ("location".equals(str)) {
            Intent intent2 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent2.addFlags(268435456);
            this.reactContext.startActivity(intent2);
            return;
        }
        if (TCEventPropertiesNames.TCN_NETWORK.equals(str)) {
            Intent intent3 = new Intent("android.settings.WIRELESS_SETTINGS");
            intent3.addFlags(268435456);
            this.reactContext.startActivity(intent3);
            return;
        }
        if ("security".equals(str)) {
            Intent intent4 = new Intent("android.settings.SECURITY_SETTINGS");
            intent4.addFlags(268435456);
            this.reactContext.startActivity(intent4);
            return;
        }
        if ("deviceinfo".equals(str)) {
            Intent intent5 = new Intent("android.settings.DEVICE_INFO_SETTINGS");
            intent5.addFlags(268435456);
            this.reactContext.startActivity(intent5);
            return;
        }
        if ("backup".equals(str)) {
            Intent intent6 = new Intent("android.settings.PRIVACY_SETTINGS");
            intent6.addFlags(268435456);
            this.reactContext.startActivity(intent6);
            return;
        }
        if (TCVideoEventPropertiesNames.TCV_SOUND.equals(str)) {
            Intent intent7 = new Intent("android.settings.SOUND_SETTINGS");
            intent7.addFlags(268435456);
            this.reactContext.startActivity(intent7);
            return;
        }
        if ("home".equals(str)) {
            Intent intent8 = new Intent("android.settings.HOME_SETTINGS");
            intent8.addFlags(268435456);
            this.reactContext.startActivity(intent8);
            return;
        }
        if ("date".equals(str)) {
            Intent intent9 = new Intent("android.settings.DATE_SETTINGS");
            intent9.addFlags(268435456);
            this.reactContext.startActivity(intent9);
        } else if ("applications".equals(str)) {
            Intent intent10 = new Intent("android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS");
            intent10.addFlags(268435456);
            this.reactContext.startActivity(intent10);
        } else if ("wifi".equals(str)) {
            Intent intent11 = new Intent("android.settings.WIFI_SETTINGS");
            intent11.addFlags(268435456);
            this.reactContext.startActivity(intent11);
        }
    }

    @ReactMethod
    public void locationSettings() {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }
}
