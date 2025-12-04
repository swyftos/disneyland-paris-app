package com.allegion.core.exception;

/* loaded from: classes2.dex */
public class BleException extends Exception {
    public static final String BLE_FAILED_TO_CONNECT = "ble_failed_to_connect";
    public static final String BLE_NOT_COMPATIBLE_KEY = "ble_not_compatible";
    public static final String BLUETOOTH_DISABLED_KEY = "bluetooth_disabled";
    public static final String LOCATION_SERVICES_DISABLED_KEY = "location_services_disabled";
    private static final long serialVersionUID = 1;
    private final boolean disconnected;
    private final String key;

    public BleException() {
        super("Unable to communicate with device.");
        this.key = "";
        this.disconnected = false;
    }

    public BleException(boolean z, String str) {
        super(str);
        this.key = "";
        this.disconnected = z;
    }

    public BleException(String str) {
        super(str);
        this.key = "";
        this.disconnected = false;
    }

    public BleException(String str, String str2) {
        super(str2);
        this.key = str;
        this.disconnected = false;
    }

    public boolean isDisconnected() {
        return this.disconnected;
    }

    public String getKey() {
        return this.key;
    }
}
