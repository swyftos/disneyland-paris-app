package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceType implements Serializable {
    private List deviceAttributes;
    private Date deviceCreateDate;
    private String deviceKey;
    private Date deviceLastAuthenticatedDate;
    private Date deviceLastModifiedDate;

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public DeviceType withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public List<AttributeType> getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public void setDeviceAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.deviceAttributes = null;
        } else {
            this.deviceAttributes = new ArrayList(collection);
        }
    }

    public DeviceType withDeviceAttributes(AttributeType... attributeTypeArr) {
        if (getDeviceAttributes() == null) {
            this.deviceAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.deviceAttributes.add(attributeType);
        }
        return this;
    }

    public DeviceType withDeviceAttributes(Collection<AttributeType> collection) {
        setDeviceAttributes(collection);
        return this;
    }

    public Date getDeviceCreateDate() {
        return this.deviceCreateDate;
    }

    public void setDeviceCreateDate(Date date) {
        this.deviceCreateDate = date;
    }

    public DeviceType withDeviceCreateDate(Date date) {
        this.deviceCreateDate = date;
        return this;
    }

    public Date getDeviceLastModifiedDate() {
        return this.deviceLastModifiedDate;
    }

    public void setDeviceLastModifiedDate(Date date) {
        this.deviceLastModifiedDate = date;
    }

    public DeviceType withDeviceLastModifiedDate(Date date) {
        this.deviceLastModifiedDate = date;
        return this;
    }

    public Date getDeviceLastAuthenticatedDate() {
        return this.deviceLastAuthenticatedDate;
    }

    public void setDeviceLastAuthenticatedDate(Date date) {
        this.deviceLastAuthenticatedDate = date;
    }

    public DeviceType withDeviceLastAuthenticatedDate(Date date) {
        this.deviceLastAuthenticatedDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceAttributes() != null) {
            sb.append("DeviceAttributes: " + getDeviceAttributes() + ",");
        }
        if (getDeviceCreateDate() != null) {
            sb.append("DeviceCreateDate: " + getDeviceCreateDate() + ",");
        }
        if (getDeviceLastModifiedDate() != null) {
            sb.append("DeviceLastModifiedDate: " + getDeviceLastModifiedDate() + ",");
        }
        if (getDeviceLastAuthenticatedDate() != null) {
            sb.append("DeviceLastAuthenticatedDate: " + getDeviceLastAuthenticatedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getDeviceKey() == null ? 0 : getDeviceKey().hashCode()) + 31) * 31) + (getDeviceAttributes() == null ? 0 : getDeviceAttributes().hashCode())) * 31) + (getDeviceCreateDate() == null ? 0 : getDeviceCreateDate().hashCode())) * 31) + (getDeviceLastModifiedDate() == null ? 0 : getDeviceLastModifiedDate().hashCode())) * 31) + (getDeviceLastAuthenticatedDate() != null ? getDeviceLastAuthenticatedDate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceType)) {
            return false;
        }
        DeviceType deviceType = (DeviceType) obj;
        if ((deviceType.getDeviceKey() == null) ^ (getDeviceKey() == null)) {
            return false;
        }
        if (deviceType.getDeviceKey() != null && !deviceType.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if ((deviceType.getDeviceAttributes() == null) ^ (getDeviceAttributes() == null)) {
            return false;
        }
        if (deviceType.getDeviceAttributes() != null && !deviceType.getDeviceAttributes().equals(getDeviceAttributes())) {
            return false;
        }
        if ((deviceType.getDeviceCreateDate() == null) ^ (getDeviceCreateDate() == null)) {
            return false;
        }
        if (deviceType.getDeviceCreateDate() != null && !deviceType.getDeviceCreateDate().equals(getDeviceCreateDate())) {
            return false;
        }
        if ((deviceType.getDeviceLastModifiedDate() == null) ^ (getDeviceLastModifiedDate() == null)) {
            return false;
        }
        if (deviceType.getDeviceLastModifiedDate() != null && !deviceType.getDeviceLastModifiedDate().equals(getDeviceLastModifiedDate())) {
            return false;
        }
        if ((deviceType.getDeviceLastAuthenticatedDate() == null) ^ (getDeviceLastAuthenticatedDate() == null)) {
            return false;
        }
        return deviceType.getDeviceLastAuthenticatedDate() == null || deviceType.getDeviceLastAuthenticatedDate().equals(getDeviceLastAuthenticatedDate());
    }
}
