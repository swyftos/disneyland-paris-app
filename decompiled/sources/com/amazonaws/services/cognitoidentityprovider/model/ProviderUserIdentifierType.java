package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class ProviderUserIdentifierType implements Serializable {
    private String providerAttributeName;
    private String providerAttributeValue;
    private String providerName;

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public ProviderUserIdentifierType withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public String getProviderAttributeName() {
        return this.providerAttributeName;
    }

    public void setProviderAttributeName(String str) {
        this.providerAttributeName = str;
    }

    public ProviderUserIdentifierType withProviderAttributeName(String str) {
        this.providerAttributeName = str;
        return this;
    }

    public String getProviderAttributeValue() {
        return this.providerAttributeValue;
    }

    public void setProviderAttributeValue(String str) {
        this.providerAttributeValue = str;
    }

    public ProviderUserIdentifierType withProviderAttributeValue(String str) {
        this.providerAttributeValue = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderAttributeName() != null) {
            sb.append("ProviderAttributeName: " + getProviderAttributeName() + ",");
        }
        if (getProviderAttributeValue() != null) {
            sb.append("ProviderAttributeValue: " + getProviderAttributeValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getProviderName() == null ? 0 : getProviderName().hashCode()) + 31) * 31) + (getProviderAttributeName() == null ? 0 : getProviderAttributeName().hashCode())) * 31) + (getProviderAttributeValue() != null ? getProviderAttributeValue().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProviderUserIdentifierType)) {
            return false;
        }
        ProviderUserIdentifierType providerUserIdentifierType = (ProviderUserIdentifierType) obj;
        if ((providerUserIdentifierType.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        if (providerUserIdentifierType.getProviderName() != null && !providerUserIdentifierType.getProviderName().equals(getProviderName())) {
            return false;
        }
        if ((providerUserIdentifierType.getProviderAttributeName() == null) ^ (getProviderAttributeName() == null)) {
            return false;
        }
        if (providerUserIdentifierType.getProviderAttributeName() != null && !providerUserIdentifierType.getProviderAttributeName().equals(getProviderAttributeName())) {
            return false;
        }
        if ((providerUserIdentifierType.getProviderAttributeValue() == null) ^ (getProviderAttributeValue() == null)) {
            return false;
        }
        return providerUserIdentifierType.getProviderAttributeValue() == null || providerUserIdentifierType.getProviderAttributeValue().equals(getProviderAttributeValue());
    }
}
