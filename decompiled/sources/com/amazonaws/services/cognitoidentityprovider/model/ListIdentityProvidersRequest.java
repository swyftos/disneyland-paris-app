package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListIdentityProvidersRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ListIdentityProvidersRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public ListIdentityProvidersRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListIdentityProvidersRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getMaxResults() == null ? 0 : getMaxResults().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentityProvidersRequest)) {
            return false;
        }
        ListIdentityProvidersRequest listIdentityProvidersRequest = (ListIdentityProvidersRequest) obj;
        if ((listIdentityProvidersRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listIdentityProvidersRequest.getUserPoolId() != null && !listIdentityProvidersRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listIdentityProvidersRequest.getMaxResults() == null) ^ (getMaxResults() == null)) {
            return false;
        }
        if (listIdentityProvidersRequest.getMaxResults() != null && !listIdentityProvidersRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if ((listIdentityProvidersRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listIdentityProvidersRequest.getNextToken() == null || listIdentityProvidersRequest.getNextToken().equals(getNextToken());
    }
}
