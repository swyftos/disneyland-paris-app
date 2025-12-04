package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminRemoveUserFromGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String groupName;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminRemoveUserFromGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminRemoveUserFromGroupRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public AdminRemoveUserFromGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getGroupName() != null) {
            sb.append("GroupName: " + getGroupName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getGroupName() != null ? getGroupName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminRemoveUserFromGroupRequest)) {
            return false;
        }
        AdminRemoveUserFromGroupRequest adminRemoveUserFromGroupRequest = (AdminRemoveUserFromGroupRequest) obj;
        if ((adminRemoveUserFromGroupRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminRemoveUserFromGroupRequest.getUserPoolId() != null && !adminRemoveUserFromGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminRemoveUserFromGroupRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminRemoveUserFromGroupRequest.getUsername() != null && !adminRemoveUserFromGroupRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminRemoveUserFromGroupRequest.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        return adminRemoveUserFromGroupRequest.getGroupName() == null || adminRemoveUserFromGroupRequest.getGroupName().equals(getGroupName());
    }
}
