package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListGroupsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String nextToken;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ListGroupsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListGroupsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListGroupsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
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
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGroupsRequest)) {
            return false;
        }
        ListGroupsRequest listGroupsRequest = (ListGroupsRequest) obj;
        if ((listGroupsRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listGroupsRequest.getUserPoolId() != null && !listGroupsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listGroupsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listGroupsRequest.getLimit() != null && !listGroupsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listGroupsRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listGroupsRequest.getNextToken() == null || listGroupsRequest.getNextToken().equals(getNextToken());
    }
}
