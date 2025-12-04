package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class AdminListDevicesResult implements Serializable {
    private List devices;
    private String paginationToken;

    public List<DeviceType> getDevices() {
        return this.devices;
    }

    public void setDevices(Collection<DeviceType> collection) {
        if (collection == null) {
            this.devices = null;
        } else {
            this.devices = new ArrayList(collection);
        }
    }

    public AdminListDevicesResult withDevices(DeviceType... deviceTypeArr) {
        if (getDevices() == null) {
            this.devices = new ArrayList(deviceTypeArr.length);
        }
        for (DeviceType deviceType : deviceTypeArr) {
            this.devices.add(deviceType);
        }
        return this;
    }

    public AdminListDevicesResult withDevices(Collection<DeviceType> collection) {
        setDevices(collection);
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public AdminListDevicesResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevices() != null) {
            sb.append("Devices: " + getDevices() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getDevices() == null ? 0 : getDevices().hashCode()) + 31) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListDevicesResult)) {
            return false;
        }
        AdminListDevicesResult adminListDevicesResult = (AdminListDevicesResult) obj;
        if ((adminListDevicesResult.getDevices() == null) ^ (getDevices() == null)) {
            return false;
        }
        if (adminListDevicesResult.getDevices() != null && !adminListDevicesResult.getDevices().equals(getDevices())) {
            return false;
        }
        if ((adminListDevicesResult.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return adminListDevicesResult.getPaginationToken() == null || adminListDevicesResult.getPaginationToken().equals(getPaginationToken());
    }
}
