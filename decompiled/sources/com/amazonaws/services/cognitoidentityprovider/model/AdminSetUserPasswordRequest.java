package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminSetUserPasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private String password;
    private Boolean permanent;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminSetUserPasswordRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminSetUserPasswordRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public AdminSetUserPasswordRequest withPassword(String str) {
        this.password = str;
        return this;
    }

    public Boolean isPermanent() {
        return this.permanent;
    }

    public Boolean getPermanent() {
        return this.permanent;
    }

    public void setPermanent(Boolean bool) {
        this.permanent = bool;
    }

    public AdminSetUserPasswordRequest withPermanent(Boolean bool) {
        this.permanent = bool;
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
        if (getPassword() != null) {
            sb.append("Password: " + getPassword() + ",");
        }
        if (getPermanent() != null) {
            sb.append("Permanent: " + getPermanent());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getPassword() == null ? 0 : getPassword().hashCode())) * 31) + (getPermanent() != null ? getPermanent().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminSetUserPasswordRequest)) {
            return false;
        }
        AdminSetUserPasswordRequest adminSetUserPasswordRequest = (AdminSetUserPasswordRequest) obj;
        if ((adminSetUserPasswordRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminSetUserPasswordRequest.getUserPoolId() != null && !adminSetUserPasswordRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminSetUserPasswordRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminSetUserPasswordRequest.getUsername() != null && !adminSetUserPasswordRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminSetUserPasswordRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (adminSetUserPasswordRequest.getPassword() != null && !adminSetUserPasswordRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((adminSetUserPasswordRequest.getPermanent() == null) ^ (getPermanent() == null)) {
            return false;
        }
        return adminSetUserPasswordRequest.getPermanent() == null || adminSetUserPasswordRequest.getPermanent().equals(getPermanent());
    }
}
