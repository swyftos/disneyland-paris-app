package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UpdateIdentityProviderResult implements Serializable {
    private IdentityProviderType identityProvider;

    public IdentityProviderType getIdentityProvider() {
        return this.identityProvider;
    }

    public void setIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
    }

    public UpdateIdentityProviderResult withIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityProvider() != null) {
            sb.append("IdentityProvider: " + getIdentityProvider());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getIdentityProvider() == null ? 0 : getIdentityProvider().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateIdentityProviderResult)) {
            return false;
        }
        UpdateIdentityProviderResult updateIdentityProviderResult = (UpdateIdentityProviderResult) obj;
        if ((updateIdentityProviderResult.getIdentityProvider() == null) ^ (getIdentityProvider() == null)) {
            return false;
        }
        return updateIdentityProviderResult.getIdentityProvider() == null || updateIdentityProviderResult.getIdentityProvider().equals(getIdentityProvider());
    }
}
