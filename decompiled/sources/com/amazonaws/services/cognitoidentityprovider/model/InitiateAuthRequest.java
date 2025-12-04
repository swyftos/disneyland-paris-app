package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class InitiateAuthRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String authFlow;
    private Map authParameters;
    private String clientId;
    private Map clientMetadata;
    private UserContextDataType userContextData;

    public String getAuthFlow() {
        return this.authFlow;
    }

    public void setAuthFlow(String str) {
        this.authFlow = str;
    }

    public InitiateAuthRequest withAuthFlow(String str) {
        this.authFlow = str;
        return this;
    }

    public void setAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
    }

    public InitiateAuthRequest withAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
        return this;
    }

    public Map<String, String> getAuthParameters() {
        return this.authParameters;
    }

    public void setAuthParameters(Map<String, String> map) {
        this.authParameters = map;
    }

    public InitiateAuthRequest withAuthParameters(Map<String, String> map) {
        this.authParameters = map;
        return this;
    }

    public InitiateAuthRequest addAuthParametersEntry(String str, String str2) {
        if (this.authParameters == null) {
            this.authParameters = new HashMap();
        }
        if (this.authParameters.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.authParameters.put(str, str2);
        return this;
    }

    public InitiateAuthRequest clearAuthParametersEntries() {
        this.authParameters = null;
        return this;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public InitiateAuthRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public InitiateAuthRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (this.clientMetadata.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.clientMetadata.put(str, str2);
        return this;
    }

    public InitiateAuthRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public InitiateAuthRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public InitiateAuthRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public InitiateAuthRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAuthFlow() != null) {
            sb.append("AuthFlow: " + getAuthFlow() + ",");
        }
        if (getAuthParameters() != null) {
            sb.append("AuthParameters: " + getAuthParameters() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getAuthFlow() == null ? 0 : getAuthFlow().hashCode()) + 31) * 31) + (getAuthParameters() == null ? 0 : getAuthParameters().hashCode())) * 31) + (getClientMetadata() == null ? 0 : getClientMetadata().hashCode())) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getAnalyticsMetadata() == null ? 0 : getAnalyticsMetadata().hashCode())) * 31) + (getUserContextData() != null ? getUserContextData().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InitiateAuthRequest)) {
            return false;
        }
        InitiateAuthRequest initiateAuthRequest = (InitiateAuthRequest) obj;
        if ((initiateAuthRequest.getAuthFlow() == null) ^ (getAuthFlow() == null)) {
            return false;
        }
        if (initiateAuthRequest.getAuthFlow() != null && !initiateAuthRequest.getAuthFlow().equals(getAuthFlow())) {
            return false;
        }
        if ((initiateAuthRequest.getAuthParameters() == null) ^ (getAuthParameters() == null)) {
            return false;
        }
        if (initiateAuthRequest.getAuthParameters() != null && !initiateAuthRequest.getAuthParameters().equals(getAuthParameters())) {
            return false;
        }
        if ((initiateAuthRequest.getClientMetadata() == null) ^ (getClientMetadata() == null)) {
            return false;
        }
        if (initiateAuthRequest.getClientMetadata() != null && !initiateAuthRequest.getClientMetadata().equals(getClientMetadata())) {
            return false;
        }
        if ((initiateAuthRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (initiateAuthRequest.getClientId() != null && !initiateAuthRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((initiateAuthRequest.getAnalyticsMetadata() == null) ^ (getAnalyticsMetadata() == null)) {
            return false;
        }
        if (initiateAuthRequest.getAnalyticsMetadata() != null && !initiateAuthRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if ((initiateAuthRequest.getUserContextData() == null) ^ (getUserContextData() == null)) {
            return false;
        }
        return initiateAuthRequest.getUserContextData() == null || initiateAuthRequest.getUserContextData().equals(getUserContextData());
    }
}
