package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ResourceServerType implements Serializable {
    private String identifier;
    private String name;
    private List scopes;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ResourceServerType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public ResourceServerType withIdentifier(String str) {
        this.identifier = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ResourceServerType withName(String str) {
        this.name = str;
        return this;
    }

    public List<ResourceServerScopeType> getScopes() {
        return this.scopes;
    }

    public void setScopes(Collection<ResourceServerScopeType> collection) {
        if (collection == null) {
            this.scopes = null;
        } else {
            this.scopes = new ArrayList(collection);
        }
    }

    public ResourceServerType withScopes(ResourceServerScopeType... resourceServerScopeTypeArr) {
        if (getScopes() == null) {
            this.scopes = new ArrayList(resourceServerScopeTypeArr.length);
        }
        for (ResourceServerScopeType resourceServerScopeType : resourceServerScopeTypeArr) {
            this.scopes.add(resourceServerScopeType);
        }
        return this;
    }

    public ResourceServerType withScopes(Collection<ResourceServerScopeType> collection) {
        setScopes(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getIdentifier() != null) {
            sb.append("Identifier: " + getIdentifier() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getScopes() != null) {
            sb.append("Scopes: " + getScopes());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getIdentifier() == null ? 0 : getIdentifier().hashCode())) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getScopes() != null ? getScopes().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResourceServerType)) {
            return false;
        }
        ResourceServerType resourceServerType = (ResourceServerType) obj;
        if ((resourceServerType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (resourceServerType.getUserPoolId() != null && !resourceServerType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((resourceServerType.getIdentifier() == null) ^ (getIdentifier() == null)) {
            return false;
        }
        if (resourceServerType.getIdentifier() != null && !resourceServerType.getIdentifier().equals(getIdentifier())) {
            return false;
        }
        if ((resourceServerType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (resourceServerType.getName() != null && !resourceServerType.getName().equals(getName())) {
            return false;
        }
        if ((resourceServerType.getScopes() == null) ^ (getScopes() == null)) {
            return false;
        }
        return resourceServerType.getScopes() == null || resourceServerType.getScopes().equals(getScopes());
    }
}
