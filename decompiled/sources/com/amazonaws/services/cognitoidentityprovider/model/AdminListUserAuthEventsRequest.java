package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminListUserAuthEventsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminListUserAuthEventsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminListUserAuthEventsRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public AdminListUserAuthEventsRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public AdminListUserAuthEventsRequest withNextToken(String str) {
        this.nextToken = str;
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
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getMaxResults() == null ? 0 : getMaxResults().hashCode())) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListUserAuthEventsRequest)) {
            return false;
        }
        AdminListUserAuthEventsRequest adminListUserAuthEventsRequest = (AdminListUserAuthEventsRequest) obj;
        if ((adminListUserAuthEventsRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminListUserAuthEventsRequest.getUserPoolId() != null && !adminListUserAuthEventsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminListUserAuthEventsRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminListUserAuthEventsRequest.getUsername() != null && !adminListUserAuthEventsRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminListUserAuthEventsRequest.getMaxResults() == null) ^ (getMaxResults() == null)) {
            return false;
        }
        if (adminListUserAuthEventsRequest.getMaxResults() != null && !adminListUserAuthEventsRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if ((adminListUserAuthEventsRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return adminListUserAuthEventsRequest.getNextToken() == null || adminListUserAuthEventsRequest.getNextToken().equals(getNextToken());
    }
}
