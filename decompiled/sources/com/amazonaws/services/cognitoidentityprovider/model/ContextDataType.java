package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ContextDataType implements Serializable {
    private String encodedData;
    private List httpHeaders;
    private String ipAddress;
    private String serverName;
    private String serverPath;

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public ContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public ContextDataType withServerName(String str) {
        this.serverName = str;
        return this;
    }

    public String getServerPath() {
        return this.serverPath;
    }

    public void setServerPath(String str) {
        this.serverPath = str;
    }

    public ContextDataType withServerPath(String str) {
        this.serverPath = str;
        return this;
    }

    public List<HttpHeader> getHttpHeaders() {
        return this.httpHeaders;
    }

    public void setHttpHeaders(Collection<HttpHeader> collection) {
        if (collection == null) {
            this.httpHeaders = null;
        } else {
            this.httpHeaders = new ArrayList(collection);
        }
    }

    public ContextDataType withHttpHeaders(HttpHeader... httpHeaderArr) {
        if (getHttpHeaders() == null) {
            this.httpHeaders = new ArrayList(httpHeaderArr.length);
        }
        for (HttpHeader httpHeader : httpHeaderArr) {
            this.httpHeaders.add(httpHeader);
        }
        return this;
    }

    public ContextDataType withHttpHeaders(Collection<HttpHeader> collection) {
        setHttpHeaders(collection);
        return this;
    }

    public String getEncodedData() {
        return this.encodedData;
    }

    public void setEncodedData(String str) {
        this.encodedData = str;
    }

    public ContextDataType withEncodedData(String str) {
        this.encodedData = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getServerName() != null) {
            sb.append("ServerName: " + getServerName() + ",");
        }
        if (getServerPath() != null) {
            sb.append("ServerPath: " + getServerPath() + ",");
        }
        if (getHttpHeaders() != null) {
            sb.append("HttpHeaders: " + getHttpHeaders() + ",");
        }
        if (getEncodedData() != null) {
            sb.append("EncodedData: " + getEncodedData());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getIpAddress() == null ? 0 : getIpAddress().hashCode()) + 31) * 31) + (getServerName() == null ? 0 : getServerName().hashCode())) * 31) + (getServerPath() == null ? 0 : getServerPath().hashCode())) * 31) + (getHttpHeaders() == null ? 0 : getHttpHeaders().hashCode())) * 31) + (getEncodedData() != null ? getEncodedData().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextDataType)) {
            return false;
        }
        ContextDataType contextDataType = (ContextDataType) obj;
        if ((contextDataType.getIpAddress() == null) ^ (getIpAddress() == null)) {
            return false;
        }
        if (contextDataType.getIpAddress() != null && !contextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if ((contextDataType.getServerName() == null) ^ (getServerName() == null)) {
            return false;
        }
        if (contextDataType.getServerName() != null && !contextDataType.getServerName().equals(getServerName())) {
            return false;
        }
        if ((contextDataType.getServerPath() == null) ^ (getServerPath() == null)) {
            return false;
        }
        if (contextDataType.getServerPath() != null && !contextDataType.getServerPath().equals(getServerPath())) {
            return false;
        }
        if ((contextDataType.getHttpHeaders() == null) ^ (getHttpHeaders() == null)) {
            return false;
        }
        if (contextDataType.getHttpHeaders() != null && !contextDataType.getHttpHeaders().equals(getHttpHeaders())) {
            return false;
        }
        if ((contextDataType.getEncodedData() == null) ^ (getEncodedData() == null)) {
            return false;
        }
        return contextDataType.getEncodedData() == null || contextDataType.getEncodedData().equals(getEncodedData());
    }
}
