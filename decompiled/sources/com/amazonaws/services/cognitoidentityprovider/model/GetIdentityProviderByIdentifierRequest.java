package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetIdentityProviderByIdentifierRequest extends AmazonWebServiceRequest implements Serializable {
    private String idpIdentifier;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetIdentityProviderByIdentifierRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getIdpIdentifier() {
        return this.idpIdentifier;
    }

    public void setIdpIdentifier(String str) {
        this.idpIdentifier = str;
    }

    public GetIdentityProviderByIdentifierRequest withIdpIdentifier(String str) {
        this.idpIdentifier = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getIdpIdentifier() != null) {
            sb.append("IdpIdentifier: " + getIdpIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getIdpIdentifier() != null ? getIdpIdentifier().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityProviderByIdentifierRequest)) {
            return false;
        }
        GetIdentityProviderByIdentifierRequest getIdentityProviderByIdentifierRequest = (GetIdentityProviderByIdentifierRequest) obj;
        if ((getIdentityProviderByIdentifierRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (getIdentityProviderByIdentifierRequest.getUserPoolId() != null && !getIdentityProviderByIdentifierRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null) ^ (getIdpIdentifier() == null)) {
            return false;
        }
        return getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null || getIdentityProviderByIdentifierRequest.getIdpIdentifier().equals(getIdpIdentifier());
    }
}
