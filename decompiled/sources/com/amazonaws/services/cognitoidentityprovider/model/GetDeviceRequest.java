package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String deviceKey;

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public GetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public GetDeviceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getDeviceKey() == null ? 0 : getDeviceKey().hashCode()) + 31) * 31) + (getAccessToken() != null ? getAccessToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetDeviceRequest)) {
            return false;
        }
        GetDeviceRequest getDeviceRequest = (GetDeviceRequest) obj;
        if ((getDeviceRequest.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (getDeviceRequest.getDeviceKey() != null && !getDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((getDeviceRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        return getDeviceRequest.getAccessToken() == null || getDeviceRequest.getAccessToken().equals(getAccessToken());
    }
}
