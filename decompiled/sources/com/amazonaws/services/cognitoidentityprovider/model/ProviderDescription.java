package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class ProviderDescription implements Serializable {
    private Date creationDate;
    private Date lastModifiedDate;
    private String providerName;
    private String providerType;

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public ProviderDescription withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public String getProviderType() {
        return this.providerType;
    }

    public void setProviderType(String str) {
        this.providerType = str;
    }

    public ProviderDescription withProviderType(String str) {
        this.providerType = str;
        return this;
    }

    public void setProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
    }

    public ProviderDescription withProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public ProviderDescription withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public ProviderDescription withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderType() != null) {
            sb.append("ProviderType: " + getProviderType() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getProviderName() == null ? 0 : getProviderName().hashCode()) + 31) * 31) + (getProviderType() == null ? 0 : getProviderType().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() != null ? getCreationDate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProviderDescription)) {
            return false;
        }
        ProviderDescription providerDescription = (ProviderDescription) obj;
        if ((providerDescription.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        if (providerDescription.getProviderName() != null && !providerDescription.getProviderName().equals(getProviderName())) {
            return false;
        }
        if ((providerDescription.getProviderType() == null) ^ (getProviderType() == null)) {
            return false;
        }
        if (providerDescription.getProviderType() != null && !providerDescription.getProviderType().equals(getProviderType())) {
            return false;
        }
        if ((providerDescription.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (providerDescription.getLastModifiedDate() != null && !providerDescription.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((providerDescription.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        return providerDescription.getCreationDate() == null || providerDescription.getCreationDate().equals(getCreationDate());
    }
}
