package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class GroupType implements Serializable {
    private Date creationDate;
    private String description;
    private String groupName;
    private Date lastModifiedDate;
    private Integer precedence;
    private String roleArn;
    private String userPoolId;

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public GroupType withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GroupType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public GroupType withDescription(String str) {
        this.description = str;
        return this;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public GroupType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public Integer getPrecedence() {
        return this.precedence;
    }

    public void setPrecedence(Integer num) {
        this.precedence = num;
    }

    public GroupType withPrecedence(Integer num) {
        this.precedence = num;
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public GroupType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public GroupType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroupName() != null) {
            sb.append("GroupName: " + getGroupName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + ",");
        }
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getPrecedence() != null) {
            sb.append("Precedence: " + getPrecedence() + ",");
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
        return (((((((((((((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31) + (getRoleArn() == null ? 0 : getRoleArn().hashCode())) * 31) + (getPrecedence() == null ? 0 : getPrecedence().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() != null ? getCreationDate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupType)) {
            return false;
        }
        GroupType groupType = (GroupType) obj;
        if ((groupType.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        if (groupType.getGroupName() != null && !groupType.getGroupName().equals(getGroupName())) {
            return false;
        }
        if ((groupType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (groupType.getUserPoolId() != null && !groupType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((groupType.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (groupType.getDescription() != null && !groupType.getDescription().equals(getDescription())) {
            return false;
        }
        if ((groupType.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (groupType.getRoleArn() != null && !groupType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((groupType.getPrecedence() == null) ^ (getPrecedence() == null)) {
            return false;
        }
        if (groupType.getPrecedence() != null && !groupType.getPrecedence().equals(getPrecedence())) {
            return false;
        }
        if ((groupType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (groupType.getLastModifiedDate() != null && !groupType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((groupType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        return groupType.getCreationDate() == null || groupType.getCreationDate().equals(getCreationDate());
    }
}
