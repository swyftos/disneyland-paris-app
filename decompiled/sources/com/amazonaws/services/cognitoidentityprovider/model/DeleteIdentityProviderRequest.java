package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeleteIdentityProviderRequest extends AmazonWebServiceRequest implements Serializable {
    private String providerName;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DeleteIdentityProviderRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public DeleteIdentityProviderRequest withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getProviderName() != null ? getProviderName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentityProviderRequest)) {
            return false;
        }
        DeleteIdentityProviderRequest deleteIdentityProviderRequest = (DeleteIdentityProviderRequest) obj;
        if ((deleteIdentityProviderRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (deleteIdentityProviderRequest.getUserPoolId() != null && !deleteIdentityProviderRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((deleteIdentityProviderRequest.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        return deleteIdentityProviderRequest.getProviderName() == null || deleteIdentityProviderRequest.getProviderName().equals(getProviderName());
    }
}
