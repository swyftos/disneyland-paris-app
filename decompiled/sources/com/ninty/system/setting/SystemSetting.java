package com.ninty.system.setting;

import android.app.Activity;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes4.dex */
public class SystemSetting extends ReactContextBaseJavaModule implements ActivityEventListener, LifecycleEventListener {
    private static final String VOL_ALARM = "alarm";
    private static final String VOL_MUSIC = "music";
    private static final String VOL_NOTIFICATION = "notification";
    private static final String VOL_RING = "ring";
    private static final String VOL_SYSTEM = "system";
    private static final String VOL_VOICE_CALL = "call";
    private String TAG;
    private volatile BroadcastReceiver airplaneBR;
    private AudioManager am;
    private volatile BroadcastReceiver bluetoothBR;
    private LocationManager lm;
    private volatile BroadcastReceiver locationBR;
    private volatile BroadcastReceiver locationModeBR;
    private ReactApplicationContext mContext;
    private VolumeBroadcastReceiver volumeBR;
    private volatile BroadcastReceiver wifiBR;
    private WifiManager wm;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public SystemSetting(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.TAG = SystemSetting.class.getSimpleName();
        this.mContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.am = (AudioManager) this.mContext.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.wm = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        this.lm = (LocationManager) this.mContext.getApplicationContext().getSystemService("location");
        this.volumeBR = new VolumeBroadcastReceiver();
    }

    private void registerVolumeReceiver() {
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.volumeBR;
        if (volumeBroadcastReceiver == null || volumeBroadcastReceiver.isRegistered()) {
            return;
        }
        this.mContext.registerReceiver(this.volumeBR, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        this.volumeBR.setRegistered(true);
    }

    private void unregisterVolumeReceiver() {
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.volumeBR;
        if (volumeBroadcastReceiver == null || !volumeBroadcastReceiver.isRegistered()) {
            return;
        }
        this.mContext.unregisterReceiver(this.volumeBR);
        this.volumeBR.setRegistered(false);
    }

    private void listenWifiState() {
        if (this.wifiBR == null) {
            synchronized (this) {
                try {
                    if (this.wifiBR == null) {
                        this.wifiBR = new BroadcastReceiver() { // from class: com.ninty.system.setting.SystemSetting.1
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                                    int intExtra = intent.getIntExtra("wifi_state", 0);
                                    if (intExtra == 3 || intExtra == 1) {
                                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventWifiChange", Boolean.valueOf(intExtra == 3));
                                    }
                                }
                            }
                        };
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                        this.mContext.registerReceiver(this.wifiBR, intentFilter);
                    }
                } finally {
                }
            }
        }
    }

    private void listenBluetoothState() {
        if (this.bluetoothBR == null) {
            synchronized (this) {
                try {
                    if (this.bluetoothBR == null) {
                        this.bluetoothBR = new BroadcastReceiver() { // from class: com.ninty.system.setting.SystemSetting.2
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                                    if (intExtra == 12 || intExtra == 10) {
                                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventBluetoothChange", Boolean.valueOf(intExtra == 12));
                                    }
                                }
                            }
                        };
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                        this.mContext.registerReceiver(this.bluetoothBR, intentFilter);
                    }
                } finally {
                }
            }
        }
    }

    private void listenLocationState() {
        if (this.locationBR == null) {
            synchronized (this) {
                try {
                    if (this.locationBR == null) {
                        this.locationBR = new BroadcastReceiver() { // from class: com.ninty.system.setting.SystemSetting.3
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
                                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventLocationChange", Boolean.valueOf(SystemSetting.this.isLocationEnable()));
                                }
                            }
                        };
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
                        this.mContext.registerReceiver(this.locationBR, intentFilter);
                    }
                } finally {
                }
            }
        }
    }

    private void listenLocationModeState() {
        if (this.locationModeBR == null) {
            synchronized (this) {
                try {
                    if (this.locationModeBR == null) {
                        this.locationModeBR = new BroadcastReceiver() { // from class: com.ninty.system.setting.SystemSetting.4
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent.getAction().equals("android.location.MODE_CHANGED")) {
                                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventLocationModeChange", Integer.valueOf(SystemSetting.this.getLocationMode()));
                                }
                            }
                        };
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.location.MODE_CHANGED");
                        this.mContext.registerReceiver(this.locationModeBR, intentFilter);
                    }
                } finally {
                }
            }
        }
    }

    private void listenAirplaneState() {
        if (this.airplaneBR == null) {
            synchronized (this) {
                try {
                    if (this.airplaneBR == null) {
                        this.airplaneBR = new BroadcastReceiver() { // from class: com.ninty.system.setting.SystemSetting.5
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) throws Settings.SettingNotFoundException {
                                try {
                                    int i = Settings.System.getInt(SystemSetting.this.mContext.getContentResolver(), "airplane_mode_on");
                                    DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                                    boolean z = true;
                                    if (i != 1) {
                                        z = false;
                                    }
                                    rCTDeviceEventEmitter.emit("EventAirplaneChange", Boolean.valueOf(z));
                                } catch (Settings.SettingNotFoundException e) {
                                    Log.e(SystemSetting.this.TAG, NotificationCompat.CATEGORY_ERROR, e);
                                }
                            }
                        };
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
                        this.mContext.registerReceiver(this.airplaneBR, intentFilter);
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return SystemSetting.class.getSimpleName();
    }

    @ReactMethod
    public void setScreenMode(int i, Promise promise) {
        if (i != 0) {
            i = 1;
        }
        checkAndSet("screen_brightness_mode", i, promise);
    }

    @ReactMethod
    public void getScreenMode(Promise promise) {
        try {
            promise.resolve(Integer.valueOf(Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness_mode")));
        } catch (Settings.SettingNotFoundException e) {
            Log.e(this.TAG, NotificationCompat.CATEGORY_ERROR, e);
            promise.reject("-1", "get screen mode fail", e);
        }
    }

    @ReactMethod
    public void setBrightness(float f, Promise promise) {
        checkAndSet("screen_brightness", (int) (f * 255.0f), promise);
    }

    @ReactMethod
    public void setAppBrightness(float f) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        final WindowManager.LayoutParams attributes = currentActivity.getWindow().getAttributes();
        attributes.screenBrightness = f;
        currentActivity.runOnUiThread(new Runnable() { // from class: com.ninty.system.setting.SystemSetting.6
            @Override // java.lang.Runnable
            public void run() {
                currentActivity.getWindow().setAttributes(attributes);
            }
        });
    }

    @ReactMethod
    public void getAppBrightness(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        try {
            float f = currentActivity.getWindow().getAttributes().screenBrightness;
            if (f < BitmapDescriptorFactory.HUE_RED) {
                promise.resolve(Float.valueOf((Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness") * 1.0f) / 255.0f));
            } else {
                promise.resolve(Float.valueOf(f));
            }
        } catch (Exception e) {
            Log.e(this.TAG, NotificationCompat.CATEGORY_ERROR, e);
            promise.reject("-1", "get app's brightness fail", e);
        }
    }

    @ReactMethod
    public void openWriteSetting() {
        this.mContext.getCurrentActivity().startActivity(new Intent(SysSettings.WRITESETTINGS.action, Uri.parse("package:" + this.mContext.getPackageName())));
    }

    @ReactMethod
    public void getBrightness(Promise promise) {
        try {
            promise.resolve(Float.valueOf((Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness") * 1.0f) / 255.0f));
        } catch (Settings.SettingNotFoundException e) {
            Log.e(this.TAG, NotificationCompat.CATEGORY_ERROR, e);
            promise.reject("-1", "get brightness fail", e);
        }
    }

    @ReactMethod
    public void setVolume(float f, ReadableMap readableMap) {
        unregisterVolumeReceiver();
        String string = readableMap.getString("type");
        boolean z = readableMap.getBoolean("playSound");
        boolean z2 = readableMap.getBoolean("showUI");
        int volType = getVolType(string);
        int i = z ? 4 : 0;
        if (z2) {
            i |= 1;
        }
        try {
            this.am.setStreamVolume(volType, (int) (r5.getStreamMaxVolume(volType) * f), i);
        } catch (SecurityException e) {
            if (f == BitmapDescriptorFactory.HUE_RED) {
                Log.w(this.TAG, "setVolume(0) failed. See https://github.com/c19354837/react-native-system-setting/issues/48");
                if (!((NotificationManager) this.mContext.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
                    this.mContext.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
                }
            }
            Log.e(this.TAG, NotificationCompat.CATEGORY_ERROR, e);
        }
        registerVolumeReceiver();
    }

    @ReactMethod
    public void getVolume(String str, Promise promise) {
        promise.resolve(Float.valueOf(getNormalizationVolume(str)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (android.provider.Settings.System.getInt(r2.mContext.getContentResolver(), r3) != r4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkAndSet(java.lang.String r3, int r4, com.facebook.react.bridge.Promise r5) {
        /*
            r2 = this;
            java.lang.String r0 = "err"
            com.facebook.react.bridge.ReactApplicationContext r1 = r2.mContext
            boolean r1 = android.provider.Settings.System.canWrite(r1)
            if (r1 != 0) goto Lb
            goto L2a
        Lb:
            com.facebook.react.bridge.ReactApplicationContext r1 = r2.mContext     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            android.provider.Settings.System.putInt(r1, r3, r4)     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            com.facebook.react.bridge.ReactApplicationContext r1 = r2.mContext     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            int r2 = android.provider.Settings.System.getInt(r1, r3)     // Catch: java.lang.SecurityException -> L21 android.provider.Settings.SettingNotFoundException -> L23
            if (r2 == r4) goto L37
            goto L2a
        L21:
            r3 = move-exception
            goto L25
        L23:
            r3 = move-exception
            goto L32
        L25:
            java.lang.String r2 = r2.TAG
            android.util.Log.e(r2, r0, r3)
        L2a:
            java.lang.String r2 = "-1"
            java.lang.String r3 = "write_settings permission is blocked by system"
            r5.reject(r2, r3)
            goto L3c
        L32:
            java.lang.String r2 = r2.TAG
            android.util.Log.e(r2, r0, r3)
        L37:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r5.resolve(r2)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ninty.system.setting.SystemSetting.checkAndSet(java.lang.String, int, com.facebook.react.bridge.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getNormalizationVolume(String str) {
        int volType = getVolType(str);
        return (this.am.getStreamVolume(volType) * 1.0f) / this.am.getStreamMaxVolume(volType);
    }

    private int getVolType(String str) {
        str.hashCode();
        switch (str) {
            case "system":
                return 1;
            case "call":
                return 0;
            case "ring":
                return 2;
            case "alarm":
                return 4;
            case "notification":
                return 5;
            default:
                return 3;
        }
    }

    @ReactMethod
    public void isWifiEnabled(Promise promise) {
        WifiManager wifiManager = this.wm;
        if (wifiManager != null) {
            promise.resolve(Boolean.valueOf(wifiManager.isWifiEnabled()));
        } else {
            promise.reject("-1", "get wifi manager fail");
        }
    }

    @ReactMethod
    public void switchWifiSilence() {
        if (this.wm != null) {
            listenWifiState();
            this.wm.setWifiEnabled(!r1.isWifiEnabled());
            return;
        }
        Log.w(this.TAG, "Cannot get wifi manager, switchWifi will be ignored");
    }

    @ReactMethod
    public void switchWifi() {
        switchSetting(SysSettings.WIFI);
    }

    @ReactMethod
    public void isLocationEnabled(Promise promise) {
        if (this.lm != null) {
            promise.resolve(Boolean.valueOf(isLocationEnable()));
        } else {
            promise.reject("-1", "get location manager fail");
        }
    }

    @ReactMethod
    public void getLocationMode(Promise promise) {
        if (this.lm != null) {
            promise.resolve(Integer.valueOf(getLocationMode()));
        } else {
            promise.reject("-1", "get location manager fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLocationMode() {
        boolean zIsProviderEnabled = this.lm.isProviderEnabled("gps");
        return this.lm.isProviderEnabled(TCEventPropertiesNames.TCN_NETWORK) ? (zIsProviderEnabled ? 1 : 0) | 2 : zIsProviderEnabled ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocationEnable() {
        return this.lm.isProviderEnabled("gps") || this.lm.isProviderEnabled(TCEventPropertiesNames.TCN_NETWORK);
    }

    @ReactMethod
    public void switchLocation() {
        switchSetting(SysSettings.LOCATION);
    }

    @ReactMethod
    public void isBluetoothEnabled(Promise promise) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        promise.resolve(Boolean.valueOf(defaultAdapter != null && defaultAdapter.isEnabled()));
    }

    @ReactMethod
    public void switchBluetooth() {
        switchSetting(SysSettings.BLUETOOTH);
    }

    @ReactMethod
    public void switchBluetoothSilence() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            listenBluetoothState();
            if (defaultAdapter.isEnabled()) {
                defaultAdapter.disable();
            } else {
                defaultAdapter.enable();
            }
        }
    }

    @ReactMethod
    public void activeListener(String str, Promise promise) {
        str.hashCode();
        switch (str) {
            case "airplane":
                listenAirplaneState();
                promise.resolve(null);
                break;
            case "locationMode":
                listenLocationModeState();
                promise.resolve(null);
                break;
            case "wifi":
                listenWifiState();
                promise.resolve(null);
                break;
            case "location":
                listenLocationState();
                promise.resolve(null);
                break;
            case "bluetooth":
                listenBluetoothState();
                promise.resolve(null);
                break;
            default:
                promise.reject("-1", "unsupported listener type: " + str);
                break;
        }
    }

    @ReactMethod
    public void isAirplaneEnabled(Promise promise) {
        try {
            boolean z = true;
            if (Settings.System.getInt(this.mContext.getContentResolver(), "airplane_mode_on") != 1) {
                z = false;
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Settings.SettingNotFoundException e) {
            Log.e(this.TAG, NotificationCompat.CATEGORY_ERROR, e);
            promise.reject("-1", "get airplane mode fail", e);
        }
    }

    @ReactMethod
    public void switchAirplane() {
        switchSetting(SysSettings.AIRPLANE);
    }

    private void switchSetting(SysSettings sysSettings) {
        if (this.mContext.getCurrentActivity() != null) {
            this.mContext.addActivityEventListener(this);
            this.mContext.getCurrentActivity().startActivityForResult(new Intent(sysSettings.action), sysSettings.requestCode);
            return;
        }
        Log.w(this.TAG, "getCurrentActivity() return null, switch will be ignore");
    }

    @ReactMethod
    public void openAppSystemSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.setData(Uri.parse("package:" + this.mContext.getPackageName()));
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (SysSettings.get(i) != SysSettings.UNKNOW) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventEnterForeground", null);
            this.mContext.removeActivityEventListener(this);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        registerVolumeReceiver();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        unregisterVolumeReceiver();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        if (this.wifiBR != null) {
            this.mContext.unregisterReceiver(this.wifiBR);
            this.wifiBR = null;
        }
        if (this.bluetoothBR != null) {
            this.mContext.unregisterReceiver(this.bluetoothBR);
            this.bluetoothBR = null;
        }
        if (this.locationBR != null) {
            this.mContext.unregisterReceiver(this.locationBR);
            this.locationBR = null;
        }
        if (this.locationModeBR != null) {
            this.mContext.unregisterReceiver(this.locationModeBR);
            this.locationBR = null;
        }
        if (this.airplaneBR != null) {
            this.mContext.unregisterReceiver(this.airplaneBR);
            this.airplaneBR = null;
        }
    }

    private class VolumeBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private VolumeBroadcastReceiver() {
            this.isRegistered = false;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public boolean isRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putDouble("value", SystemSetting.this.getNormalizationVolume(SystemSetting.VOL_MUSIC));
                writableMapCreateMap.putDouble("call", SystemSetting.this.getNormalizationVolume("call"));
                writableMapCreateMap.putDouble(SystemSetting.VOL_SYSTEM, SystemSetting.this.getNormalizationVolume(SystemSetting.VOL_SYSTEM));
                writableMapCreateMap.putDouble(SystemSetting.VOL_RING, SystemSetting.this.getNormalizationVolume(SystemSetting.VOL_RING));
                writableMapCreateMap.putDouble(SystemSetting.VOL_MUSIC, SystemSetting.this.getNormalizationVolume(SystemSetting.VOL_MUSIC));
                writableMapCreateMap.putDouble("alarm", SystemSetting.this.getNormalizationVolume("alarm"));
                writableMapCreateMap.putDouble("notification", SystemSetting.this.getNormalizationVolume("notification"));
                try {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) SystemSetting.this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("EventVolume", writableMapCreateMap);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
