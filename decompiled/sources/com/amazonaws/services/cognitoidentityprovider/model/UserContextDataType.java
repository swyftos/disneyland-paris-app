package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UserContextDataType implements Serializable {
    private String encodedData;

    public String getEncodedData() {
        return this.encodedData;
    }

    public void setEncodedData(String str) {
        this.encodedData = str;
    }

    public UserContextDataType withEncodedData(String str) {
        this.encodedData = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEncodedData() != null) {
            sb.append("EncodedData: " + getEncodedData());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getEncodedData() == null ? 0 : getEncodedData().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserContextDataType)) {
            return false;
        }
        UserContextDataType userContextDataType = (UserContextDataType) obj;
        if ((userContextDataType.getEncodedData() == null) ^ (getEncodedData() == null)) {
            return false;
        }
        return userContextDataType.getEncodedData() == null || userContextDataType.getEncodedData().equals(getEncodedData());
    }
}
