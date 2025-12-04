package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class UserPoolClientType implements Serializable {
    private List allowedOAuthFlows;
    private Boolean allowedOAuthFlowsUserPoolClient;
    private List allowedOAuthScopes;
    private AnalyticsConfigurationType analyticsConfiguration;
    private List callbackURLs;
    private String clientId;
    private String clientName;
    private String clientSecret;
    private Date creationDate;
    private String defaultRedirectURI;
    private List explicitAuthFlows;
    private Date lastModifiedDate;
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

    public UserPoolClientType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public UserPoolClientType withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public UserPoolClientType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setClientSecret(String str) {
        this.clientSecret = str;
    }

    public UserPoolClientType withClientSecret(String str) {
        this.clientSecret = str;
        return this;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public UserPoolClientType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public UserPoolClientType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
    }

    public UserPoolClientType withRefreshTokenValidity(Integer num) {
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

    public UserPoolClientType withReadAttributes(String... strArr) {
        if (getReadAttributes() == null) {
            this.readAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.readAttributes.add(str);
        }
        return this;
    }

    public UserPoolClientType withReadAttributes(Collection<String> collection) {
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

    public UserPoolClientType withWriteAttributes(String... strArr) {
        if (getWriteAttributes() == null) {
            this.writeAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.writeAttributes.add(str);
        }
        return this;
    }

    public UserPoolClientType withWriteAttributes(Collection<String> collection) {
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

    public UserPoolClientType withExplicitAuthFlows(String... strArr) {
        if (getExplicitAuthFlows() == null) {
            this.explicitAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.explicitAuthFlows.add(str);
        }
        return this;
    }

    public UserPoolClientType withExplicitAuthFlows(Collection<String> collection) {
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

    public UserPoolClientType withSupportedIdentityProviders(String... strArr) {
        if (getSupportedIdentityProviders() == null) {
            this.supportedIdentityProviders = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.supportedIdentityProviders.add(str);
        }
        return this;
    }

    public UserPoolClientType withSupportedIdentityProviders(Collection<String> collection) {
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

    public UserPoolClientType withCallbackURLs(String... strArr) {
        if (getCallbackURLs() == null) {
            this.callbackURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.callbackURLs.add(str);
        }
        return this;
    }

    public UserPoolClientType withCallbackURLs(Collection<String> collection) {
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

    public UserPoolClientType withLogoutURLs(String... strArr) {
        if (getLogoutURLs() == null) {
            this.logoutURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logoutURLs.add(str);
        }
        return this;
    }

    public UserPoolClientType withLogoutURLs(Collection<String> collection) {
        setLogoutURLs(collection);
        return this;
    }

    public String getDefaultRedirectURI() {
        return this.defaultRedirectURI;
    }

    public void setDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
    }

    public UserPoolClientType withDefaultRedirectURI(String str) {
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

    public UserPoolClientType withAllowedOAuthFlows(String... strArr) {
        if (getAllowedOAuthFlows() == null) {
            this.allowedOAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthFlows.add(str);
        }
        return this;
    }

    public UserPoolClientType withAllowedOAuthFlows(Collection<String> collection) {
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

    public UserPoolClientType withAllowedOAuthScopes(String... strArr) {
        if (getAllowedOAuthScopes() == null) {
            this.allowedOAuthScopes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthScopes.add(str);
        }
        return this;
    }

    public UserPoolClientType withAllowedOAuthScopes(Collection<String> collection) {
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

    public UserPoolClientType withAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
        return this;
    }

    public AnalyticsConfigurationType getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public void setAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
    }

    public UserPoolClientType withAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
        return this;
    }

    public String getPreventUserExistenceErrors() {
        return this.preventUserExistenceErrors;
    }

    public void setPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
    }

    public UserPoolClientType withPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
        return this;
    }

    public void setPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
    }

    public UserPoolClientType withPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
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
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getClientSecret() != null) {
            sb.append("ClientSecret: " + getClientSecret() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
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
        return (((((((((((((((((((((((((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientName() == null ? 0 : getClientName().hashCode())) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getClientSecret() == null ? 0 : getClientSecret().hashCode())) * 31) + (getLastModifiedDate() == null ? 0 : getLastModifiedDate().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getRefreshTokenValidity() == null ? 0 : getRefreshTokenValidity().hashCode())) * 31) + (getReadAttributes() == null ? 0 : getReadAttributes().hashCode())) * 31) + (getWriteAttributes() == null ? 0 : getWriteAttributes().hashCode())) * 31) + (getExplicitAuthFlows() == null ? 0 : getExplicitAuthFlows().hashCode())) * 31) + (getSupportedIdentityProviders() == null ? 0 : getSupportedIdentityProviders().hashCode())) * 31) + (getCallbackURLs() == null ? 0 : getCallbackURLs().hashCode())) * 31) + (getLogoutURLs() == null ? 0 : getLogoutURLs().hashCode())) * 31) + (getDefaultRedirectURI() == null ? 0 : getDefaultRedirectURI().hashCode())) * 31) + (getAllowedOAuthFlows() == null ? 0 : getAllowedOAuthFlows().hashCode())) * 31) + (getAllowedOAuthScopes() == null ? 0 : getAllowedOAuthScopes().hashCode())) * 31) + (getAllowedOAuthFlowsUserPoolClient() == null ? 0 : getAllowedOAuthFlowsUserPoolClient().hashCode())) * 31) + (getAnalyticsConfiguration() == null ? 0 : getAnalyticsConfiguration().hashCode())) * 31) + (getPreventUserExistenceErrors() != null ? getPreventUserExistenceErrors().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolClientType)) {
            return false;
        }
        UserPoolClientType userPoolClientType = (UserPoolClientType) obj;
        if ((userPoolClientType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (userPoolClientType.getUserPoolId() != null && !userPoolClientType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((userPoolClientType.getClientName() == null) ^ (getClientName() == null)) {
            return false;
        }
        if (userPoolClientType.getClientName() != null && !userPoolClientType.getClientName().equals(getClientName())) {
            return false;
        }
        if ((userPoolClientType.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (userPoolClientType.getClientId() != null && !userPoolClientType.getClientId().equals(getClientId())) {
            return false;
        }
        if ((userPoolClientType.getClientSecret() == null) ^ (getClientSecret() == null)) {
            return false;
        }
        if (userPoolClientType.getClientSecret() != null && !userPoolClientType.getClientSecret().equals(getClientSecret())) {
            return false;
        }
        if ((userPoolClientType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (userPoolClientType.getLastModifiedDate() != null && !userPoolClientType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((userPoolClientType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (userPoolClientType.getCreationDate() != null && !userPoolClientType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((userPoolClientType.getRefreshTokenValidity() == null) ^ (getRefreshTokenValidity() == null)) {
            return false;
        }
        if (userPoolClientType.getRefreshTokenValidity() != null && !userPoolClientType.getRefreshTokenValidity().equals(getRefreshTokenValidity())) {
            return false;
        }
        if ((userPoolClientType.getReadAttributes() == null) ^ (getReadAttributes() == null)) {
            return false;
        }
        if (userPoolClientType.getReadAttributes() != null && !userPoolClientType.getReadAttributes().equals(getReadAttributes())) {
            return false;
        }
        if ((userPoolClientType.getWriteAttributes() == null) ^ (getWriteAttributes() == null)) {
            return false;
        }
        if (userPoolClientType.getWriteAttributes() != null && !userPoolClientType.getWriteAttributes().equals(getWriteAttributes())) {
            return false;
        }
        if ((userPoolClientType.getExplicitAuthFlows() == null) ^ (getExplicitAuthFlows() == null)) {
            return false;
        }
        if (userPoolClientType.getExplicitAuthFlows() != null && !userPoolClientType.getExplicitAuthFlows().equals(getExplicitAuthFlows())) {
            return false;
        }
        if ((userPoolClientType.getSupportedIdentityProviders() == null) ^ (getSupportedIdentityProviders() == null)) {
            return false;
        }
        if (userPoolClientType.getSupportedIdentityProviders() != null && !userPoolClientType.getSupportedIdentityProviders().equals(getSupportedIdentityProviders())) {
            return false;
        }
        if ((userPoolClientType.getCallbackURLs() == null) ^ (getCallbackURLs() == null)) {
            return false;
        }
        if (userPoolClientType.getCallbackURLs() != null && !userPoolClientType.getCallbackURLs().equals(getCallbackURLs())) {
            return false;
        }
        if ((userPoolClientType.getLogoutURLs() == null) ^ (getLogoutURLs() == null)) {
            return false;
        }
        if (userPoolClientType.getLogoutURLs() != null && !userPoolClientType.getLogoutURLs().equals(getLogoutURLs())) {
            return false;
        }
        if ((userPoolClientType.getDefaultRedirectURI() == null) ^ (getDefaultRedirectURI() == null)) {
            return false;
        }
        if (userPoolClientType.getDefaultRedirectURI() != null && !userPoolClientType.getDefaultRedirectURI().equals(getDefaultRedirectURI())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthFlows() == null) ^ (getAllowedOAuthFlows() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthFlows() != null && !userPoolClientType.getAllowedOAuthFlows().equals(getAllowedOAuthFlows())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthScopes() == null) ^ (getAllowedOAuthScopes() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthScopes() != null && !userPoolClientType.getAllowedOAuthScopes().equals(getAllowedOAuthScopes())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthFlowsUserPoolClient() == null) ^ (getAllowedOAuthFlowsUserPoolClient() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthFlowsUserPoolClient() != null && !userPoolClientType.getAllowedOAuthFlowsUserPoolClient().equals(getAllowedOAuthFlowsUserPoolClient())) {
            return false;
        }
        if ((userPoolClientType.getAnalyticsConfiguration() == null) ^ (getAnalyticsConfiguration() == null)) {
            return false;
        }
        if (userPoolClientType.getAnalyticsConfiguration() != null && !userPoolClientType.getAnalyticsConfiguration().equals(getAnalyticsConfiguration())) {
            return false;
        }
        if ((userPoolClientType.getPreventUserExistenceErrors() == null) ^ (getPreventUserExistenceErrors() == null)) {
            return false;
        }
        return userPoolClientType.getPreventUserExistenceErrors() == null || userPoolClientType.getPreventUserExistenceErrors().equals(getPreventUserExistenceErrors());
    }
}
