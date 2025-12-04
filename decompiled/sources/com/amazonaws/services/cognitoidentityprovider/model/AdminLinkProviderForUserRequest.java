package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminLinkProviderForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private ProviderUserIdentifierType destinationUser;
    private ProviderUserIdentifierType sourceUser;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminLinkProviderForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public ProviderUserIdentifierType getDestinationUser() {
        return this.destinationUser;
    }

    public void setDestinationUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.destinationUser = providerUserIdentifierType;
    }

    public AdminLinkProviderForUserRequest withDestinationUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.destinationUser = providerUserIdentifierType;
        return this;
    }

    public ProviderUserIdentifierType getSourceUser() {
        return this.sourceUser;
    }

    public void setSourceUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.sourceUser = providerUserIdentifierType;
    }

    public AdminLinkProviderForUserRequest withSourceUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.sourceUser = providerUserIdentifierType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getDestinationUser() != null) {
            sb.append("DestinationUser: " + getDestinationUser() + ",");
        }
        if (getSourceUser() != null) {
            sb.append("SourceUser: " + getSourceUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getDestinationUser() == null ? 0 : getDestinationUser().hashCode())) * 31) + (getSourceUser() != null ? getSourceUser().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminLinkProviderForUserRequest)) {
            return false;
        }
        AdminLinkProviderForUserRequest adminLinkProviderForUserRequest = (AdminLinkProviderForUserRequest) obj;
        if ((adminLinkProviderForUserRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getUserPoolId() != null && !adminLinkProviderForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminLinkProviderForUserRequest.getDestinationUser() == null) ^ (getDestinationUser() == null)) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getDestinationUser() != null && !adminLinkProviderForUserRequest.getDestinationUser().equals(getDestinationUser())) {
            return false;
        }
        if ((adminLinkProviderForUserRequest.getSourceUser() == null) ^ (getSourceUser() == null)) {
            return false;
        }
        return adminLinkProviderForUserRequest.getSourceUser() == null || adminLinkProviderForUserRequest.getSourceUser().equals(getSourceUser());
    }
}
