package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeleteGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String groupName;
    private String userPoolId;

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public DeleteGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DeleteGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroupName() != null) {
            sb.append("GroupName: " + getGroupName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31) + (getUserPoolId() != null ? getUserPoolId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteGroupRequest)) {
            return false;
        }
        DeleteGroupRequest deleteGroupRequest = (DeleteGroupRequest) obj;
        if ((deleteGroupRequest.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        if (deleteGroupRequest.getGroupName() != null && !deleteGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if ((deleteGroupRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return deleteGroupRequest.getUserPoolId() == null || deleteGroupRequest.getUserPoolId().equals(getUserPoolId());
    }
}
