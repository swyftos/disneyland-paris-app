package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminDisableProviderForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private ProviderUserIdentifierType user;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminDisableProviderForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public ProviderUserIdentifierType getUser() {
        return this.user;
    }

    public void setUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.user = providerUserIdentifierType;
    }

    public AdminDisableProviderForUserRequest withUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.user = providerUserIdentifierType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUser() != null) {
            sb.append("User: " + getUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUser() != null ? getUser().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminDisableProviderForUserRequest)) {
            return false;
        }
        AdminDisableProviderForUserRequest adminDisableProviderForUserRequest = (AdminDisableProviderForUserRequest) obj;
        if ((adminDisableProviderForUserRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminDisableProviderForUserRequest.getUserPoolId() != null && !adminDisableProviderForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminDisableProviderForUserRequest.getUser() == null) ^ (getUser() == null)) {
            return false;
        }
        return adminDisableProviderForUserRequest.getUser() == null || adminDisableProviderForUserRequest.getUser().equals(getUser());
    }
}
