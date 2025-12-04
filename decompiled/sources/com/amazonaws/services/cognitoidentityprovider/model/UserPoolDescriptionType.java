package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class UserPoolDescriptionType implements Serializable {
    private Date creationDate;
    private String id;
    private LambdaConfigType lambdaConfig;
    private Date lastModifiedDate;
    private String name;
    private String status;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public UserPoolDescriptionType withId(String str) {
        this.id = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public UserPoolDescriptionType withName(String str) {
        this.name = str;
        return this;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public UserPoolDescriptionType withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public UserPoolDescriptionType withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(StatusType statusType) {
        this.status = statusType.toString();
    }

    public UserPoolDescriptionType withStatus(StatusType statusType) {
        this.status = statusType.toString();
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public UserPoolDescriptionType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public UserPoolDescriptionType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getId() != null) {
            sb.append("Id: " + getId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
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
        return (((((((((((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getLambdaConfig() == null ? 0 : getLambdaConfig().hashCode())) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() != null ? getCreationDate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolDescriptionType)) {
            return false;
        }
        UserPoolDescriptionType userPoolDescriptionType = (UserPoolDescriptionType) obj;
        if ((userPoolDescriptionType.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (userPoolDescriptionType.getId() != null && !userPoolDescriptionType.getId().equals(getId())) {
            return false;
        }
        if ((userPoolDescriptionType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (userPoolDescriptionType.getName() != null && !userPoolDescriptionType.getName().equals(getName())) {
            return false;
        }
        if ((userPoolDescriptionType.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (userPoolDescriptionType.getLambdaConfig() != null && !userPoolDescriptionType.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((userPoolDescriptionType.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (userPoolDescriptionType.getStatus() != null && !userPoolDescriptionType.getStatus().equals(getStatus())) {
            return false;
        }
        if ((userPoolDescriptionType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (userPoolDescriptionType.getLastModifiedDate() != null && !userPoolDescriptionType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((userPoolDescriptionType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        return userPoolDescriptionType.getCreationDate() == null || userPoolDescriptionType.getCreationDate().equals(getCreationDate());
    }
}
