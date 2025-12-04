package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetDeviceResult implements Serializable {
    private DeviceType device;

    public DeviceType getDevice() {
        return this.device;
    }

    public void setDevice(DeviceType deviceType) {
        this.device = deviceType;
    }

    public GetDeviceResult withDevice(DeviceType deviceType) {
        this.device = deviceType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevice() != null) {
            sb.append("Device: " + getDevice());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getDevice() == null ? 0 : getDevice().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetDeviceResult)) {
            return false;
        }
        GetDeviceResult getDeviceResult = (GetDeviceResult) obj;
        if ((getDeviceResult.getDevice() == null) ^ (getDevice() == null)) {
            return false;
        }
        return getDeviceResult.getDevice() == null || getDeviceResult.getDevice().equals(getDevice());
    }
}
