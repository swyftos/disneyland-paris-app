package com.allegion.core.exception;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import com.allegion.core.utility.SystemUtility;
import com.allegion.logging.AlLog;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes2.dex */
public class BleExceptionHandler {
    private static final String BLE_ERROR_BLE_NOT_SUPPORTED = "This device does not support Bluetooth low energy (LE).";
    private static final String BLE_ERROR_BLUETOOTH_DISABLED = "Bluetooth is currently disabled.";
    private static final String BLE_ERROR_LOCATION_SERVICES_DISABLED = "Location services is required to scan Bluetooth devices.";
    private static final String BLE_LOCATION_SERVICES_DISABLED = "Location Services is disabled. It is required to scan for Bluetooth devices prior to Android 12.";

    private BleExceptionHandler() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    private static boolean isBleSupported(Context context) {
        return context.getPackageManager() != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static BleException checkBluetoothExceptions(Context context, boolean z) {
        if (!isBleSupported(context)) {
            return new BleException(BleException.BLE_NOT_COMPATIBLE_KEY, BLE_ERROR_BLE_NOT_SUPPORTED);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && !defaultAdapter.isEnabled()) {
            return new BleException(BleException.BLUETOOTH_DISABLED_KEY, BLE_ERROR_BLUETOOTH_DISABLED);
        }
        if (!z) {
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(TCEventPropertiesNames.TCN_NETWORK)) {
            return null;
        }
        if (SystemUtility.INSTANCE.getSDKVersion() >= 31) {
            AlLog.w(BLE_LOCATION_SERVICES_DISABLED, new Object[0]);
            return null;
        }
        return new BleException(BleException.LOCATION_SERVICES_DISABLED_KEY, BLE_ERROR_LOCATION_SERVICES_DISABLED);
    }
}
