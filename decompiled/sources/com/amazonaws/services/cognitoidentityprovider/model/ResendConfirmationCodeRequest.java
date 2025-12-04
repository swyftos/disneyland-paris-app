package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ResendConfirmationCodeRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map clientMetadata;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public ResendConfirmationCodeRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getSecretHash() {
        return this.secretHash;
    }

    public void setSecretHash(String str) {
        this.secretHash = str;
    }

    public ResendConfirmationCodeRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public ResendConfirmationCodeRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public ResendConfirmationCodeRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public ResendConfirmationCodeRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public ResendConfirmationCodeRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public ResendConfirmationCodeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public ResendConfirmationCodeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getSecretHash() != null) {
            sb.append("SecretHash: " + getSecretHash() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getSecretHash() == null ? 0 : getSecretHash().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResendConfirmationCodeRequest)) {
            return false;
        }
        ResendConfirmationCodeRequest resendConfirmationCodeRequest = (ResendConfirmationCodeRequest) obj;
        if ((resendConfirmationCodeRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (resendConfirmationCodeRequest.getClientId() != null && !resendConfirmationCodeRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((resendConfirmationCodeRequest.getSecretHash() == null) ^ (getSecretHash() == null)) {
            return false;
        }
        if (resendConfirmationCodeRequest.getSecretHash() != null && !resendConfirmationCodeRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if ((resendConfirmationCodeRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (resendConfirmationCodeRequest.getUserContextData() != null && !resendConfirmationCodeRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((resendConfirmationCodeRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (resendConfirmationCodeRequest.getUsername() != null && !resendConfirmationCodeRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((resendConfirmationCodeRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (resendConfirmationCodeRequest.getAnalyticsMetadata() != null && !resendConfirmationCodeRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((resendConfirmationCodeRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return resendConfirmationCodeRequest.getClientMetadata() == null || resendConfirmationCodeRequest.getClientMetadata().equals(getClientMetadata());
    }
}
