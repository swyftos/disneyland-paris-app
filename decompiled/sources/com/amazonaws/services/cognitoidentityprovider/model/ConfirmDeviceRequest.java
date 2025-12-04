package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ConfirmDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String deviceKey;
    private String deviceName;
    private DeviceSecretVerifierConfigType deviceSecretVerifierConfig;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public ConfirmDeviceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public ConfirmDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public DeviceSecretVerifierConfigType getDeviceSecretVerifierConfig() {
        return this.deviceSecretVerifierConfig;
    }

    public void setDeviceSecretVerifierConfig(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType) {
        this.deviceSecretVerifierConfig = deviceSecretVerifierConfigType;
    }

    public ConfirmDeviceRequest withDeviceSecretVerifierConfig(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType) {
        this.deviceSecretVerifierConfig = deviceSecretVerifierConfigType;
        return this;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public ConfirmDeviceRequest withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceSecretVerifierConfig() != null) {
            sb.append("DeviceSecretVerifierConfig: " + getDeviceSecretVerifierConfig() + ",");
        }
        if (getDeviceName() != null) {
            sb.append("DeviceName: " + getDeviceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getDeviceKey() == null ? 0 : getDeviceKey().hashCode())) * 31) + (getDeviceSecretVerifierConfig() == null ? 0 : getDeviceSecretVerifierConfig().hashCode())) * 31) + (getDeviceName() != null ? getDeviceName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmDeviceRequest)) {
            return false;
        }
        ConfirmDeviceRequest confirmDeviceRequest = (ConfirmDeviceRequest) obj;
        if ((confirmDeviceRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (confirmDeviceRequest.getAccessToken() != null && !confirmDeviceRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((confirmDeviceRequest.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceKey() != null && !confirmDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((confirmDeviceRequest.getDeviceSecretVerifierConfig() == null) ^ (getDeviceSecretVerifierConfig() == null)) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceSecretVerifierConfig() != null && !confirmDeviceRequest.getDeviceSecretVerifierConfig().equals(getDeviceSecretVerifierConfig())) {
            return false;
        }
        if ((confirmDeviceRequest.getDeviceName() == null) ^ (getDeviceName() == null)) {
            return false;
        }
        return confirmDeviceRequest.getDeviceName() == null || confirmDeviceRequest.getDeviceName().equals(getDeviceName());
    }
}
