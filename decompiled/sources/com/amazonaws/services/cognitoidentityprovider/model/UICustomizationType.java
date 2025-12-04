package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class UICustomizationType implements Serializable {
    private String cSS;
    private String cSSVersion;
    private String clientId;
    private Date creationDate;
    private String imageUrl;
    private Date lastModifiedDate;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public UICustomizationType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public UICustomizationType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public UICustomizationType withImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public String getCSS() {
        return this.cSS;
    }

    public void setCSS(String str) {
        this.cSS = str;
    }

    public UICustomizationType withCSS(String str) {
        this.cSS = str;
        return this;
    }

    public String getCSSVersion() {
        return this.cSSVersion;
    }

    public void setCSSVersion(String str) {
        this.cSSVersion = str;
    }

    public UICustomizationType withCSSVersion(String str) {
        this.cSSVersion = str;
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public UICustomizationType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public UICustomizationType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getImageUrl() != null) {
            sb.append("ImageUrl: " + getImageUrl() + ",");
        }
        if (getCSS() != null) {
            sb.append("CSS: " + getCSS() + ",");
        }
        if (getCSSVersion() != null) {
            sb.append("CSSVersion: " + getCSSVersion() + ",");
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
        return (((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getImageUrl() == null ? 0 : getImageUrl().hashCode())) * 31) + (getCSS() == null ? 0 : getCSS().hashCode())) * 31) + (getCSSVersion() == null ? 0 : getCSSVersion().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() != null ? getCreationDate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UICustomizationType)) {
            return false;
        }
        UICustomizationType uICustomizationType = (UICustomizationType) obj;
        if ((uICustomizationType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (uICustomizationType.getUserPoolId() != null && !uICustomizationType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((uICustomizationType.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (uICustomizationType.getClientId() != null && !uICustomizationType.getClientId().equals(getClientId())) {
            return false;
        }
        if ((uICustomizationType.getImageUrl() == null) ^ (getImageUrl() == null)) {
            return false;
        }
        if (uICustomizationType.getImageUrl() != null && !uICustomizationType.getImageUrl().equals(getImageUrl())) {
            return false;
        }
        if ((uICustomizationType.getCSS() == null) ^ (getCSS() == null)) {
            return false;
        }
        if (uICustomizationType.getCSS() != null && !uICustomizationType.getCSS().equals(getCSS())) {
            return false;
        }
        if ((uICustomizationType.getCSSVersion() == null) ^ (getCSSVersion() == null)) {
            return false;
        }
        if (uICustomizationType.getCSSVersion() != null && !uICustomizationType.getCSSVersion().equals(getCSSVersion())) {
            return false;
        }
        if ((uICustomizationType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (uICustomizationType.getLastModifiedDate() != null && !uICustomizationType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((uICustomizationType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        return uICustomizationType.getCreationDate() == null || uICustomizationType.getCreationDate().equals(getCreationDate());
    }
}
