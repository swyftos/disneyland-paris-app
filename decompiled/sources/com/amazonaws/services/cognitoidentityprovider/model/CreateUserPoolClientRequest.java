package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateUserPoolClientRequest extends AmazonWebServiceRequest implements Serializable {
    private List allowedOAuthFlows;
    private Boolean allowedOAuthFlowsUserPoolClient;
    private List allowedOAuthScopes;
    private AnalyticsConfigurationType analyticsConfiguration;
    private List callbackURLs;
    private String clientName;
    private String defaultRedirectURI;
    private List explicitAuthFlows;
    private Boolean generateSecret;
    private List logoutURLs;
    private String preventUserExistenceErrors;
    private List readAttributes;
    private Integer refreshTokenValidity;
    private List supportedIdentityProviders;
    private String userPoolId;
    private List writeAttributes;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public CreateUserPoolClientRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public CreateUserPoolClientRequest withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public Boolean isGenerateSecret() {
        return this.generateSecret;
    }

    public Boolean getGenerateSecret() {
        return this.generateSecret;
    }

    public void setGenerateSecret(Boolean bool) {
        this.generateSecret = bool;
    }

    public CreateUserPoolClientRequest withGenerateSecret(Boolean bool) {
        this.generateSecret = bool;
        return this;
    }

    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
    }

    public CreateUserPoolClientRequest withRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
        return this;
    }

    public List<String> getReadAttributes() {
        return this.readAttributes;
    }

    public void setReadAttributes(Collection<String> collection) {
        if (collection == null) {
            this.readAttributes = null;
        } else {
            this.readAttributes = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withReadAttributes(String... strArr) {
        if (getReadAttributes() == null) {
            this.readAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.readAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withReadAttributes(Collection<String> collection) {
        setReadAttributes(collection);
        return this;
    }

    public List<String> getWriteAttributes() {
        return this.writeAttributes;
    }

    public void setWriteAttributes(Collection<String> collection) {
        if (collection == null) {
            this.writeAttributes = null;
        } else {
            this.writeAttributes = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withWriteAttributes(String... strArr) {
        if (getWriteAttributes() == null) {
            this.writeAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.writeAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withWriteAttributes(Collection<String> collection) {
        setWriteAttributes(collection);
        return this;
    }

    public List<String> getExplicitAuthFlows() {
        return this.explicitAuthFlows;
    }

    public void setExplicitAuthFlows(Collection<String> collection) {
        if (collection == null) {
            this.explicitAuthFlows = null;
        } else {
            this.explicitAuthFlows = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withExplicitAuthFlows(String... strArr) {
        if (getExplicitAuthFlows() == null) {
            this.explicitAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.explicitAuthFlows.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withExplicitAuthFlows(Collection<String> collection) {
        setExplicitAuthFlows(collection);
        return this;
    }

    public List<String> getSupportedIdentityProviders() {
        return this.supportedIdentityProviders;
    }

    public void setSupportedIdentityProviders(Collection<String> collection) {
        if (collection == null) {
            this.supportedIdentityProviders = null;
        } else {
            this.supportedIdentityProviders = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withSupportedIdentityProviders(String... strArr) {
        if (getSupportedIdentityProviders() == null) {
            this.supportedIdentityProviders = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.supportedIdentityProviders.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withSupportedIdentityProviders(Collection<String> collection) {
        setSupportedIdentityProviders(collection);
        return this;
    }

    public List<String> getCallbackURLs() {
        return this.callbackURLs;
    }

    public void setCallbackURLs(Collection<String> collection) {
        if (collection == null) {
            this.callbackURLs = null;
        } else {
            this.callbackURLs = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withCallbackURLs(String... strArr) {
        if (getCallbackURLs() == null) {
            this.callbackURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.callbackURLs.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withCallbackURLs(Collection<String> collection) {
        setCallbackURLs(collection);
        return this;
    }

    public List<String> getLogoutURLs() {
        return this.logoutURLs;
    }

    public void setLogoutURLs(Collection<String> collection) {
        if (collection == null) {
            this.logoutURLs = null;
        } else {
            this.logoutURLs = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withLogoutURLs(String... strArr) {
        if (getLogoutURLs() == null) {
            this.logoutURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logoutURLs.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withLogoutURLs(Collection<String> collection) {
        setLogoutURLs(collection);
        return this;
    }

    public String getDefaultRedirectURI() {
        return this.defaultRedirectURI;
    }

    public void setDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
    }

    public CreateUserPoolClientRequest withDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
        return this;
    }

    public List<String> getAllowedOAuthFlows() {
        return this.allowedOAuthFlows;
    }

    public void setAllowedOAuthFlows(Collection<String> collection) {
        if (collection == null) {
            this.allowedOAuthFlows = null;
        } else {
            this.allowedOAuthFlows = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withAllowedOAuthFlows(String... strArr) {
        if (getAllowedOAuthFlows() == null) {
            this.allowedOAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthFlows.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withAllowedOAuthFlows(Collection<String> collection) {
        setAllowedOAuthFlows(collection);
        return this;
    }

    public List<String> getAllowedOAuthScopes() {
        return this.allowedOAuthScopes;
    }

    public void setAllowedOAuthScopes(Collection<String> collection) {
        if (collection == null) {
            this.allowedOAuthScopes = null;
        } else {
            this.allowedOAuthScopes = new ArrayList(collection);
        }
    }

    public CreateUserPoolClientRequest withAllowedOAuthScopes(String... strArr) {
        if (getAllowedOAuthScopes() == null) {
            this.allowedOAuthScopes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthScopes.add(str);
        }
        return this;
    }

    public CreateUserPoolClientRequest withAllowedOAuthScopes(Collection<String> collection) {
        setAllowedOAuthScopes(collection);
        return this;
    }

    public Boolean isAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public Boolean getAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public void setAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
    }

    public CreateUserPoolClientRequest withAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
        return this;
    }

    public AnalyticsConfigurationType getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public void setAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
    }

    public CreateUserPoolClientRequest withAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
        return this;
    }

    public String getPreventUserExistenceErrors() {
        return this.preventUserExistenceErrors;
    }

    public void setPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
    }

    public CreateUserPoolClientRequest withPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
        return this;
    }

    public void setPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
    }

    public CreateUserPoolClientRequest withPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName() + ",");
        }
        if (getGenerateSecret() != null) {
            sb.append("GenerateSecret: " + getGenerateSecret() + ",");
        }
        if (getRefreshTokenValidity() != null) {
            sb.append("RefreshTokenValidity: " + getRefreshTokenValidity() + ",");
        }
        if (getReadAttributes() != null) {
            sb.append("ReadAttributes: " + getReadAttributes() + ",");
        }
        if (getWriteAttributes() != null) {
            sb.append("WriteAttributes: " + getWriteAttributes() + ",");
        }
        if (getExplicitAuthFlows() != null) {
            sb.append("ExplicitAuthFlows: " + getExplicitAuthFlows() + ",");
        }
        if (getSupportedIdentityProviders() != null) {
            sb.append("SupportedIdentityProviders: " + getSupportedIdentityProviders() + ",");
        }
        if (getCallbackURLs() != null) {
            sb.append("CallbackURLs: " + getCallbackURLs() + ",");
        }
        if (getLogoutURLs() != null) {
            sb.append("LogoutURLs: " + getLogoutURLs() + ",");
        }
        if (getDefaultRedirectURI() != null) {
            sb.append("DefaultRedirectURI: " + getDefaultRedirectURI() + ",");
        }
        if (getAllowedOAuthFlows() != null) {
            sb.append("AllowedOAuthFlows: " + getAllowedOAuthFlows() + ",");
        }
        if (getAllowedOAuthScopes() != null) {
            sb.append("AllowedOAuthScopes: " + getAllowedOAuthScopes() + ",");
        }
        if (getAllowedOAuthFlowsUserPoolClient() != null) {
            sb.append("AllowedOAuthFlowsUserPoolClient: " + getAllowedOAuthFlowsUserPoolClient() + ",");
        }
        if (getAnalyticsConfiguration() != null) {
            sb.append("AnalyticsConfiguration: " + getAnalyticsConfiguration() + ",");
        }
        if (getPreventUserExistenceErrors() != null) {
            sb.append("PreventUserExistenceErrors: " + getPreventUserExistenceErrors());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientName() == null ? 0 : getClientName().hashCode())) * 31) + (getGenerateSecret() == null ? 0 : getGenerateSecret().hashCode())) * 31) + (getRefreshTokenValidity() == null ? 0 : getRefreshTokenValidity().hashCode())) * 31) + (getReadAttributes() == null ? 0 : getReadAttributes().hashCode())) * 31) + (getWriteAttributes() == null ? 0 : getWriteAttributes().hashCode())) * 31) + (getExplicitAuthFlows() == null ? 0 : getExplicitAuthFlows().hashCode())) * 31) + (getSupportedIdentityProviders() == null ? 0 : getSupportedIdentityProviders().hashCode())) * 31) + (getCallbackURLs() == null ? 0 : getCallbackURLs().hashCode())) * 31) + (getLogoutURLs() == null ? 0 : getLogoutURLs().hashCode())) * 31) + (getDefaultRedirectURI() == null ? 0 : getDefaultRedirectURI().hashCode())) * 31) + (getAllowedOAuthFlows() == null ? 0 : getAllowedOAuthFlows().hashCode())) * 31) + (getAllowedOAuthScopes() == null ? 0 : getAllowedOAuthScopes().hashCode())) * 31) + (getAllowedOAuthFlowsUserPoolClient() == null ? 0 : getAllowedOAuthFlowsUserPoolClient().hashCode())) * 31) + (getAnalyticsConfiguration() == null ? 0 : getAnalyticsConfiguration().hashCode())) * 31) + (getPreventUserExistenceErrors() != null ? getPreventUserExistenceErrors().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolClientRequest)) {
            return false;
        }
        CreateUserPoolClientRequest createUserPoolClientRequest = (CreateUserPoolClientRequest) obj;
        if ((createUserPoolClientRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getUserPoolId() != null && !createUserPoolClientRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createUserPoolClientRequest.getClientName() == null) ^ (getClientName() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getClientName() != null && !createUserPoolClientRequest.getClientName().equals(getClientName())) {
            return false;
        }
        if ((createUserPoolClientRequest.getGenerateSecret() == null) ^ (getGenerateSecret() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getGenerateSecret() != null && !createUserPoolClientRequest.getGenerateSecret().equals(getGenerateSecret())) {
            return false;
        }
        if ((createUserPoolClientRequest.getRefreshTokenValidity() == null) ^ (getRefreshTokenValidity() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getRefreshTokenValidity() != null && !createUserPoolClientRequest.getRefreshTokenValidity().equals(getRefreshTokenValidity())) {
            return false;
        }
        if ((createUserPoolClientRequest.getReadAttributes() == null) ^ (getReadAttributes() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getReadAttributes() != null && !createUserPoolClientRequest.getReadAttributes().equals(getReadAttributes())) {
            return false;
        }
        if ((createUserPoolClientRequest.getWriteAttributes() == null) ^ (getWriteAttributes() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getWriteAttributes() != null && !createUserPoolClientRequest.getWriteAttributes().equals(getWriteAttributes())) {
            return false;
        }
        if ((createUserPoolClientRequest.getExplicitAuthFlows() == null) ^ (getExplicitAuthFlows() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getExplicitAuthFlows() != null && !createUserPoolClientRequest.getExplicitAuthFlows().equals(getExplicitAuthFlows())) {
            return false;
        }
        if ((createUserPoolClientRequest.getSupportedIdentityProviders() == null) ^ (getSupportedIdentityProviders() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getSupportedIdentityProviders() != null && !createUserPoolClientRequest.getSupportedIdentityProviders().equals(getSupportedIdentityProviders())) {
            return false;
        }
        if ((createUserPoolClientRequest.getCallbackURLs() == null) ^ (getCallbackURLs() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getCallbackURLs() != null && !createUserPoolClientRequest.getCallbackURLs().equals(getCallbackURLs())) {
            return false;
        }
        if ((createUserPoolClientRequest.getLogoutURLs() == null) ^ (getLogoutURLs() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getLogoutURLs() != null && !createUserPoolClientRequest.getLogoutURLs().equals(getLogoutURLs())) {
            return false;
        }
        if ((createUserPoolClientRequest.getDefaultRedirectURI() == null) ^ (getDefaultRedirectURI() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getDefaultRedirectURI() != null && !createUserPoolClientRequest.getDefaultRedirectURI().equals(getDefaultRedirectURI())) {
            return false;
        }
        if ((createUserPoolClientRequest.getAllowedOAuthFlows() == null) ^ (getAllowedOAuthFlows() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getAllowedOAuthFlows() != null && !createUserPoolClientRequest.getAllowedOAuthFlows().equals(getAllowedOAuthFlows())) {
            return false;
        }
        if ((createUserPoolClientRequest.getAllowedOAuthScopes() == null) ^ (getAllowedOAuthScopes() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getAllowedOAuthScopes() != null && !createUserPoolClientRequest.getAllowedOAuthScopes().equals(getAllowedOAuthScopes())) {
            return false;
        }
        if ((createUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() == null) ^ (getAllowedOAuthFlowsUserPoolClient() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() != null && !createUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient().equals(getAllowedOAuthFlowsUserPoolClient())) {
            return false;
        }
        if ((createUserPoolClientRequest.getAnalyticsConfiguration() == null) ^ (getAnalyticsConfiguration() == null)) {
            return false;
        }
        if (createUserPoolClientRequest.getAnalyticsConfiguration() != null && !createUserPoolClientRequest.getAnalyticsConfiguration().equals(getAnalyticsConfiguration())) {
            return false;
        }
        if ((createUserPoolClientRequest.getPreventUserExistenceErrors() == null) ^ (getPreventUserExistenceErrors() == null)) {
            return false;
        }
        return createUserPoolClientRequest.getPreventUserExistenceErrors() == null || createUserPoolClientRequest.getPreventUserExistenceErrors().equals(getPreventUserExistenceErrors());
    }
}
