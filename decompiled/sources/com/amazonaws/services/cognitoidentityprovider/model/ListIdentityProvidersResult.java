package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListIdentityProvidersResult implements Serializable {
    private String nextToken;
    private List providers;

    public List<ProviderDescription> getProviders() {
        return this.providers;
    }

    public void setProviders(Collection<ProviderDescription> collection) {
        if (collection == null) {
            this.providers = null;
        } else {
            this.providers = new ArrayList(collection);
        }
    }

    public ListIdentityProvidersResult withProviders(ProviderDescription... providerDescriptionArr) {
        if (getProviders() == null) {
            this.providers = new ArrayList(providerDescriptionArr.length);
        }
        for (ProviderDescription providerDescription : providerDescriptionArr) {
            this.providers.add(providerDescription);
        }
        return this;
    }

    public ListIdentityProvidersResult withProviders(Collection<ProviderDescription> collection) {
        setProviders(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListIdentityProvidersResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviders() != null) {
            sb.append("Providers: " + getProviders() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getProviders() == null ? 0 : getProviders().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentityProvidersResult)) {
            return false;
        }
        ListIdentityProvidersResult listIdentityProvidersResult = (ListIdentityProvidersResult) obj;
        if ((listIdentityProvidersResult.getProviders() == null) ^ (getProviders() == null)) {
            return false;
        }
        if (listIdentityProvidersResult.getProviders() != null && !listIdentityProvidersResult.getProviders().equals(getProviders())) {
            return false;
        }
        if ((listIdentityProvidersResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listIdentityProvidersResult.getNextToken() == null || listIdentityProvidersResult.getNextToken().equals(getNextToken());
    }
}
