package com.dlp;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BluetoothManager extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static final String BLE_STATE_CHANGED_EVENT = "BLE_STATE_CHANGED";
    public static final String BLE_STATUS_OFF = "off";
    public static final String BLE_STATUS_ON = "on";
    public static final String BLE_STATUS_PARAM = "state";
    public static final String BLE_STATUS_UNKNOWN = "unknown";
    private static final int REQUEST_ENABLE_BT = 1;
    private final BroadcastReceiver bluetoothStateReceiver;
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public BluetoothManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.bluetoothStateReceiver = new BroadcastReceiver() { // from class: com.dlp.BluetoothManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                    BluetoothManager.this.sendBluetoothStatusEvent(BluetoothManager.this.mapBluetoothStateToString(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)));
                }
            }
        };
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        registerBroadcastReceiver();
    }

    private BluetoothAdapter getBluetoothAdapter() {
        return ((android.bluetooth.BluetoothManager) this.reactContext.getSystemService("bluetooth")).getAdapter();
    }

    private void registerBroadcastReceiver() {
        this.reactContext.registerReceiver(this.bluetoothStateReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBluetoothStatusEvent(String str) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(BLE_STATUS_PARAM, str);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(BLE_STATE_CHANGED_EVENT, writableMapCreateMap);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BluetoothManager";
    }

    @ReactMethod
    public void isEnabled(Promise promise) {
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        promise.resolve(Boolean.valueOf(bluetoothAdapter != null && bluetoothAdapter.isEnabled()));
    }

    @ReactMethod
    public void enable() {
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (bluetoothAdapter == null || bluetoothAdapter.isEnabled()) {
            return;
        }
        getReactApplicationContext().startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mapBluetoothStateToString(int i) {
        if (i == 10) {
            return "off";
        }
        if (i == 12) {
            return "on";
        }
        return "unknown";
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        registerBroadcastReceiver();
        sendBluetoothStatusEvent(mapBluetoothStateToString(bluetoothAdapter != null ? bluetoothAdapter.getState() : 0));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        try {
            this.reactContext.unregisterReceiver(this.bluetoothStateReceiver);
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        try {
            this.reactContext.unregisterReceiver(this.bluetoothStateReceiver);
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("BLE_STATE_CHANGED_EVENT", BLE_STATE_CHANGED_EVENT);
        return map;
    }
}
