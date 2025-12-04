package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminResetUserPasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private Map clientMetadata;
    private String userPoolId;
    private String username;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public AdminResetUserPasswordRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public AdminResetUserPasswordRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public AdminResetUserPasswordRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminResetUserPasswordRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public AdminResetUserPasswordRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
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
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminResetUserPasswordRequest)) {
            return false;
        }
        AdminResetUserPasswordRequest adminResetUserPasswordRequest = (AdminResetUserPasswordRequest) obj;
        if ((adminResetUserPasswordRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminResetUserPasswordRequest.getUserPoolId() != null && !adminResetUserPasswordRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminResetUserPasswordRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminResetUserPasswordRequest.getUsername() != null && !adminResetUserPasswordRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminResetUserPasswordRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return adminResetUserPasswordRequest.getClientMetadata() == null || adminResetUserPasswordRequest.getClientMetadata().equals(getClientMetadata());
    }
}
