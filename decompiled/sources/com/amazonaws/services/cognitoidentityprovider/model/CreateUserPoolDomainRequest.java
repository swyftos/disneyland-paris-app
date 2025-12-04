package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class CreateUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private CustomDomainConfigType customDomainConfig;
    private String domain;
    private String userPoolId;

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public CreateUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public CreateUserPoolDomainRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public CustomDomainConfigType getCustomDomainConfig() {
        return this.customDomainConfig;
    }

    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
    }

    public CreateUserPoolDomainRequest withCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCustomDomainConfig() != null) {
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getDomain() == null ? 0 : getDomain().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getCustomDomainConfig() != null ? getCustomDomainConfig().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolDomainRequest)) {
            return false;
        }
        CreateUserPoolDomainRequest createUserPoolDomainRequest = (CreateUserPoolDomainRequest) obj;
        if ((createUserPoolDomainRequest.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (createUserPoolDomainRequest.getDomain() != null && !createUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return false;
        }
        if ((createUserPoolDomainRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createUserPoolDomainRequest.getUserPoolId() != null && !createUserPoolDomainRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createUserPoolDomainRequest.getCustomDomainConfig() == null) ^ (getCustomDomainConfig() == null)) {
            return false;
        }
        return createUserPoolDomainRequest.getCustomDomainConfig() == null || createUserPoolDomainRequest.getCustomDomainConfig().equals(getCustomDomainConfig());
    }
}
