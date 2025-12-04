package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class EventContextDataType implements Serializable {
    private String city;
    private String country;
    private String deviceName;
    private String ipAddress;
    private String timezone;

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public EventContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public EventContextDataType withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public EventContextDataType withTimezone(String str) {
        this.timezone = str;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public EventContextDataType withCity(String str) {
        this.city = str;
        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public EventContextDataType withCountry(String str) {
        this.country = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getDeviceName() != null) {
            sb.append("DeviceName: " + getDeviceName() + ",");
        }
        if (getTimezone() != null) {
            sb.append("Timezone: " + getTimezone() + ",");
        }
        if (getCity() != null) {
            sb.append("City: " + getCity() + ",");
        }
        if (getCountry() != null) {
            sb.append("Country: " + getCountry());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getIpAddress() == null ? 0 : getIpAddress().hashCode()) + 31) * 31) + (getDeviceName() == null ? 0 : getDeviceName().hashCode())) * 31) + (getTimezone() == null ? 0 : getTimezone().hashCode())) * 31) + (getCity() == null ? 0 : getCity().hashCode())) * 31) + (getCountry() != null ? getCountry().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventContextDataType)) {
            return false;
        }
        EventContextDataType eventContextDataType = (EventContextDataType) obj;
        if ((eventContextDataType.getIpAddress() == null) ^ (getIpAddress() == null)) {
            return false;
        }
        if (eventContextDataType.getIpAddress() != null && !eventContextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if ((eventContextDataType.getDeviceName() == null) ^ (getDeviceName() == null)) {
            return false;
        }
        if (eventContextDataType.getDeviceName() != null && !eventContextDataType.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        if ((eventContextDataType.getTimezone() == null) ^ (getTimezone() == null)) {
            return false;
        }
        if (eventContextDataType.getTimezone() != null && !eventContextDataType.getTimezone().equals(getTimezone())) {
            return false;
        }
        if ((eventContextDataType.getCity() == null) ^ (getCity() == null)) {
            return false;
        }
        if (eventContextDataType.getCity() != null && !eventContextDataType.getCity().equals(getCity())) {
            return false;
        }
        if ((eventContextDataType.getCountry() == null) ^ (getCountry() == null)) {
            return false;
        }
        return eventContextDataType.getCountry() == null || eventContextDataType.getCountry().equals(getCountry());
    }
}
