package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminUpdateDeviceStatusRequest extends AmazonWebServiceRequest implements Serializable {
    private String deviceKey;
    private String deviceRememberedStatus;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminUpdateDeviceStatusRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminUpdateDeviceStatusRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public AdminUpdateDeviceStatusRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public String getDeviceRememberedStatus() {
        return this.deviceRememberedStatus;
    }

    public void setDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
    }

    public AdminUpdateDeviceStatusRequest withDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
        return this;
    }

    public void setDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
    }

    public AdminUpdateDeviceStatusRequest withDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceRememberedStatus() != null) {
            sb.append("DeviceRememberedStatus: " + getDeviceRememberedStatus());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getDeviceKey() == null ? 0 : getDeviceKey().hashCode())) * 31) + (getDeviceRememberedStatus() != null ? getDeviceRememberedStatus().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminUpdateDeviceStatusRequest)) {
            return false;
        }
        AdminUpdateDeviceStatusRequest adminUpdateDeviceStatusRequest = (AdminUpdateDeviceStatusRequest) obj;
        if ((adminUpdateDeviceStatusRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getUserPoolId() != null && !adminUpdateDeviceStatusRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminUpdateDeviceStatusRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getUsername() != null && !adminUpdateDeviceStatusRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminUpdateDeviceStatusRequest.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getDeviceKey() != null && !adminUpdateDeviceStatusRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((adminUpdateDeviceStatusRequest.getDeviceRememberedStatus() == null) ^ (getDeviceRememberedStatus() == null)) {
            return false;
        }
        return adminUpdateDeviceStatusRequest.getDeviceRememberedStatus() == null || adminUpdateDeviceStatusRequest.getDeviceRememberedStatus().equals(getDeviceRememberedStatus());
    }
}
