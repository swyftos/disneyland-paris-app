package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class MultiFactorAuthentication {
    private String deviceSerialNumber;
    private String token;

    public MultiFactorAuthentication(String str, String str2) {
        this.deviceSerialNumber = str;
        this.token = str2;
    }

    public String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String str) {
        this.deviceSerialNumber = str;
    }

    public MultiFactorAuthentication withDeviceSerialNumber(String str) {
        setDeviceSerialNumber(str);
        return this;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public MultiFactorAuthentication withToken(String str) {
        setToken(str);
        return this;
    }
}
