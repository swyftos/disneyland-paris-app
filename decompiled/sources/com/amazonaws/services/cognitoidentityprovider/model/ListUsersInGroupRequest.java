package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListUsersInGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String groupName;
    private Integer limit;
    private String nextToken;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ListUsersInGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public ListUsersInGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListUsersInGroupRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListUsersInGroupRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getGroupName() != null) {
            sb.append("GroupName: " + getGroupName() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getGroupName() == null ? 0 : getGroupName().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersInGroupRequest)) {
            return false;
        }
        ListUsersInGroupRequest listUsersInGroupRequest = (ListUsersInGroupRequest) obj;
        if ((listUsersInGroupRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listUsersInGroupRequest.getUserPoolId() != null && !listUsersInGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listUsersInGroupRequest.getGroupName() == null) ^ (getGroupName() == null)) {
            return false;
        }
        if (listUsersInGroupRequest.getGroupName() != null && !listUsersInGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if ((listUsersInGroupRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listUsersInGroupRequest.getLimit() != null && !listUsersInGroupRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listUsersInGroupRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listUsersInGroupRequest.getNextToken() == null || listUsersInGroupRequest.getNextToken().equals(getNextToken());
    }
}
