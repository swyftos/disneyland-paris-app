package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfirmForgotPasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map clientMetadata;
    private String confirmationCode;
    private String password;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public ConfirmForgotPasswordRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getSecretHash() {
        return this.secretHash;
    }

    public void setSecretHash(String str) {
        this.secretHash = str;
    }

    public ConfirmForgotPasswordRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public ConfirmForgotPasswordRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public String getConfirmationCode() {
        return this.confirmationCode;
    }

    public void setConfirmationCode(String str) {
        this.confirmationCode = str;
    }

    public ConfirmForgotPasswordRequest withConfirmationCode(String str) {
        this.confirmationCode = str;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public ConfirmForgotPasswordRequest withPassword(String str) {
        this.password = str;
        return this;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public ConfirmForgotPasswordRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public ConfirmForgotPasswordRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public ConfirmForgotPasswordRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public ConfirmForgotPasswordRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public ConfirmForgotPasswordRequest clearClientMetadataEntries() {
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
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getConfirmationCode() != null) {
            sb.append("ConfirmationCode: " + getConfirmationCode() + ",");
        }
        if (getPassword() != null) {
            sb.append("Password: " + getPassword() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((getClientId() == null ? 0 : getClientId().hashCode()) + 31) * 31) + (getSecretHash() == null ? 0 : getSecretHash().hashCode())) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getConfirmationCode() == null ? 0 : getConfirmationCode().hashCode())) * 31) + (getPassword() == null ? 0 : getPassword().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getUserContextData() == null ? 0 : getUserContextData().hashCode())) * 31) + (getClientMetadata() != null ? getClientMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmForgotPasswordRequest)) {
            return false;
        }
        ConfirmForgotPasswordRequest confirmForgotPasswordRequest = (ConfirmForgotPasswordRequest) obj;
        if ((confirmForgotPasswordRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getClientId() != null && !confirmForgotPasswordRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getSecretHash() == null) ^ (getSecretHash() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getSecretHash() != null && !confirmForgotPasswordRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getUsername() != null && !confirmForgotPasswordRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getConfirmationCode() == null) ^ (getConfirmationCode() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getConfirmationCode() != null && !confirmForgotPasswordRequest.getConfirmationCode().equals(getConfirmationCode())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getPassword() == null) ^ (getPassword() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getPassword() != null && !confirmForgotPasswordRequest.getPassword().equals(getPassword())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getAnalyticsMetadata() != null && !confirmForgotPasswordRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        if (confirmForgotPasswordRequest.getUserContextData() != null && !confirmForgotPasswordRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if ((confirmForgotPasswordRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        return confirmForgotPasswordRequest.getClientMetadata() == null || confirmForgotPasswordRequest.getClientMetadata().equals(getClientMetadata());
    }
}
