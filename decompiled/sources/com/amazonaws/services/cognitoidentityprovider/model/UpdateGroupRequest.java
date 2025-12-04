package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class UpdateGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String description;
    private String groupName;
    private Integer precedence;
    private String roleArn;
    private String userPoolId;

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public UpdateGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public UpdateGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public UpdateGroupRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public UpdateGroupRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public Integer getPrecedence() {
        return this.precedence;
    }

    public void setPrecedence(Integer num) {
        this.precedence = num;
    }

    public UpdateGroupRequest withPrecedence(Integer num) {
        this.precedence = num;
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
            sb.append("Precedence: " + getPrecedence());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31) + (getRoleArn() == null ? 0 : getRoleArn().hashCode())) * 31) + (getPrecedence() != null ? getPrecedence().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGroupRequest)) {
            return false;
        }
        UpdateGroupRequest updateGroupRequest = (UpdateGroupRequest) obj;
        if ((updateGroupRequest.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        if (updateGroupRequest.getGroupName() != null && !updateGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if ((updateGroupRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (updateGroupRequest.getUserPoolId() != null && !updateGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((updateGroupRequest.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (updateGroupRequest.getDescription() != null && !updateGroupRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if ((updateGroupRequest.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (updateGroupRequest.getRoleArn() != null && !updateGroupRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((updateGroupRequest.getPrecedence() == null) ^ (getPrecedence() == null)) {
            return false;
        }
        return updateGroupRequest.getPrecedence() == null || updateGroupRequest.getPrecedence().equals(getPrecedence());
    }
}
