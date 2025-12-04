package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CreateUserPoolDomainResult implements Serializable {
    private String cloudFrontDomain;

    public String getCloudFrontDomain() {
        return this.cloudFrontDomain;
    }

    public void setCloudFrontDomain(String str) {
        this.cloudFrontDomain = str;
    }

    public CreateUserPoolDomainResult withCloudFrontDomain(String str) {
        this.cloudFrontDomain = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCloudFrontDomain() != null) {
            sb.append("CloudFrontDomain: " + getCloudFrontDomain());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCloudFrontDomain() == null ? 0 : getCloudFrontDomain().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolDomainResult)) {
            return false;
        }
        CreateUserPoolDomainResult createUserPoolDomainResult = (CreateUserPoolDomainResult) obj;
        if ((createUserPoolDomainResult.getCloudFrontDomain() == null) ^ (getCloudFrontDomain() == null)) {
            return false;
        }
        return createUserPoolDomainResult.getCloudFrontDomain() == null || createUserPoolDomainResult.getCloudFrontDomain().equals(getCloudFrontDomain());
    }
}
