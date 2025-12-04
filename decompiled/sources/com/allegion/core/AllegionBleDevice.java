package com.allegion.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.allegion.core.enums.AlBLEDeviceType;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class AllegionBleDevice implements Parcelable {
    protected AlBLEDeviceType deviceType;
    protected String name;
    protected byte[] serial;
    protected String uuid;

    public AllegionBleDevice(String str, String str2, byte[] bArr, AlBLEDeviceType alBLEDeviceType) {
        this.name = str;
        this.uuid = str2;
        this.deviceType = alBLEDeviceType;
        this.serial = bArr;
    }

    public AllegionBleDevice(String str, String str2) {
        this.name = str;
        this.uuid = str2;
    }

    protected AllegionBleDevice(Parcel parcel) {
        this.name = parcel.readString();
        this.uuid = parcel.readString();
        this.deviceType = AlBLEDeviceType.fromString(parcel.readString());
        this.serial = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.uuid);
        parcel.writeString(this.deviceType.toString());
        parcel.writeByteArray(this.serial);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUuid() {
        String str = this.uuid;
        if (str != null) {
            return str.toUpperCase();
        }
        return null;
    }

    public String getSerialNumber() {
        if (this.serial == null) {
            return "";
        }
        byte[] bArr = new byte[16];
        Arrays.fill(bArr, (byte) 0);
        if (this.serial.length >= 8) {
            for (int i = 8; i < 16; i++) {
                bArr[i] = this.serial[i - 8];
            }
        }
        return Base64.encodeToString(bArr, 2);
    }

    public boolean isSerialNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String serialNumber = getSerialNumber();
        if (TextUtils.isEmpty(serialNumber)) {
            return false;
        }
        return serialNumber.equalsIgnoreCase(str);
    }

    public AlBLEDeviceType getDeviceType() {
        return this.deviceType;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AllegionBleDevice)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return ((AllegionBleDevice) obj).uuid.equals(this.uuid);
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }
}
