package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class AdminDeleteUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private List userAttributeNames;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminDeleteUserAttributesRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminDeleteUserAttributesRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public List<String> getUserAttributeNames() {
        return this.userAttributeNames;
    }

    public void setUserAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.userAttributeNames = null;
        } else {
            this.userAttributeNames = new ArrayList(collection);
        }
    }

    public AdminDeleteUserAttributesRequest withUserAttributeNames(String... strArr) {
        if (getUserAttributeNames() == null) {
            this.userAttributeNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userAttributeNames.add(str);
        }
        return this;
    }

    public AdminDeleteUserAttributesRequest withUserAttributeNames(Collection<String> collection) {
        setUserAttributeNames(collection);
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
        if (getUserAttributeNames() != null) {
            sb.append("UserAttributeNames: " + getUserAttributeNames());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getUserAttributeNames() != null ? getUserAttributeNames().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminDeleteUserAttributesRequest)) {
            return false;
        }
        AdminDeleteUserAttributesRequest adminDeleteUserAttributesRequest = (AdminDeleteUserAttributesRequest) obj;
        if ((adminDeleteUserAttributesRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUserPoolId() != null && !adminDeleteUserAttributesRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminDeleteUserAttributesRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUsername() != null && !adminDeleteUserAttributesRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminDeleteUserAttributesRequest.getUserAttributeNames() == null) ^ (getUserAttributeNames() == null)) {
            return false;
        }
        return adminDeleteUserAttributesRequest.getUserAttributeNames() == null || adminDeleteUserAttributesRequest.getUserAttributeNames().equals(getUserAttributeNames());
    }
}
