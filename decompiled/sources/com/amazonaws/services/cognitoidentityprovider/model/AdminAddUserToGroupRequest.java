package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminAddUserToGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String groupName;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminAddUserToGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminAddUserToGroupRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public AdminAddUserToGroupRequest withGroupName(String str) {
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
        if (obj == null || !(obj instanceof AdminAddUserToGroupRequest)) {
            return false;
        }
        AdminAddUserToGroupRequest adminAddUserToGroupRequest = (AdminAddUserToGroupRequest) obj;
        if ((adminAddUserToGroupRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminAddUserToGroupRequest.getUserPoolId() != null && !adminAddUserToGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminAddUserToGroupRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminAddUserToGroupRequest.getUsername() != null && !adminAddUserToGroupRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminAddUserToGroupRequest.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        return adminAddUserToGroupRequest.getGroupName() == null || adminAddUserToGroupRequest.getGroupName().equals(getGroupName());
    }
}
