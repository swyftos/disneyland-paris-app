package com.allegion.core.operations.gatt;

/* loaded from: classes2.dex */
public class DeviceService {
    private DeviceCharacteristic[] characteristic;
    private String name;
    private String uuid;

    public String getName() {
        return this.name;
    }

    public String getUuid() {
        return this.uuid;
    }

    public DeviceCharacteristic[] getCharacteristic() {
        return this.characteristic;
    }
}
