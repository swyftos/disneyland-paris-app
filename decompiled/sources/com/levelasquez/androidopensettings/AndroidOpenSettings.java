package com.levelasquez.androidopensettings;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes4.dex */
public class AndroidOpenSettings extends ReactContextBaseJavaModule {
    private ReactContext reactContext;

    public AndroidOpenSettings(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNAndroidOpenSettings";
    }

    @ReactMethod
    public void generalSettings() {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void homeSettings() {
        Intent intent = new Intent("android.settings.HOME_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void appDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.setData(Uri.parse("package:" + this.reactContext.getPackageName()));
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void wifiSettings() {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void locationSourceSettings() {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void wirelessSettings() {
        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void airplaneModeSettings() {
        Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void apnSettings() {
        Intent intent = new Intent("android.settings.APN_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void bluetoothSettings() {
        Intent intent = new Intent("android.settings.BLUETOOTH_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void dateSettings() {
        Intent intent = new Intent("android.settings.DATE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void localeSettings() {
        Intent intent = new Intent("android.settings.LOCALE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void inputMethodSettings() {
        Intent intent = new Intent("android.settings.INPUT_METHOD_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void displaySettings() {
        Intent intent = new Intent("android.settings.DISPLAY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void securitySettings() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void internalStorageSettings() {
        Intent intent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void memoryCardSettings() {
        Intent intent = new Intent("android.settings.MEMORY_CARD_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void accessibilitySettings() {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void applicationSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void deviceInfoSettings() {
        Intent intent = new Intent("android.settings.DEVICE_INFO_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }

    @ReactMethod
    public void appNotificationSettings() {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.putExtra("app_package", this.reactContext.getPackageName());
        intent.putExtra("app_uid", this.reactContext.getApplicationInfo().uid);
        intent.putExtra("android.provider.extra.APP_PACKAGE", this.reactContext.getPackageName());
        if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(intent);
        }
    }
}
