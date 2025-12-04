package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DomainDescriptionType implements Serializable {
    private String aWSAccountId;
    private String cloudFrontDistribution;
    private CustomDomainConfigType customDomainConfig;
    private String domain;
    private String s3Bucket;
    private String status;
    private String userPoolId;
    private String version;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DomainDescriptionType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getAWSAccountId() {
        return this.aWSAccountId;
    }

    public void setAWSAccountId(String str) {
        this.aWSAccountId = str;
    }

    public DomainDescriptionType withAWSAccountId(String str) {
        this.aWSAccountId = str;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public DomainDescriptionType withDomain(String str) {
        this.domain = str;
        return this;
    }

    public String getS3Bucket() {
        return this.s3Bucket;
    }

    public void setS3Bucket(String str) {
        this.s3Bucket = str;
    }

    public DomainDescriptionType withS3Bucket(String str) {
        this.s3Bucket = str;
        return this;
    }

    public String getCloudFrontDistribution() {
        return this.cloudFrontDistribution;
    }

    public void setCloudFrontDistribution(String str) {
        this.cloudFrontDistribution = str;
    }

    public DomainDescriptionType withCloudFrontDistribution(String str) {
        this.cloudFrontDistribution = str;
        return this;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public DomainDescriptionType withVersion(String str) {
        this.version = str;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public DomainDescriptionType withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(DomainStatusType domainStatusType) {
        this.status = domainStatusType.toString();
    }

    public DomainDescriptionType withStatus(DomainStatusType domainStatusType) {
        this.status = domainStatusType.toString();
        return this;
    }

    public CustomDomainConfigType getCustomDomainConfig() {
        return this.customDomainConfig;
    }

    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
    }

    public DomainDescriptionType withCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getAWSAccountId() != null) {
            sb.append("AWSAccountId: " + getAWSAccountId() + ",");
        }
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getS3Bucket() != null) {
            sb.append("S3Bucket: " + getS3Bucket() + ",");
        }
        if (getCloudFrontDistribution() != null) {
            sb.append("CloudFrontDistribution: " + getCloudFrontDistribution() + ",");
        }
        if (getVersion() != null) {
            sb.append("Version: " + getVersion() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getCustomDomainConfig() != null) {
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getAWSAccountId() == null ? 0 : getAWSAccountId().hashCode())) * 31) + (getDomain() == null ? 0 : getDomain().hashCode())) * 31) + (getS3Bucket() == null ? 0 : getS3Bucket().hashCode())) * 31) + (getCloudFrontDistribution() == null ? 0 : getCloudFrontDistribution().hashCode())) * 31) + (getVersion() == null ? 0 : getVersion().hashCode())) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31) + (getCustomDomainConfig() != null ? getCustomDomainConfig().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DomainDescriptionType)) {
            return false;
        }
        DomainDescriptionType domainDescriptionType = (DomainDescriptionType) obj;
        if ((domainDescriptionType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (domainDescriptionType.getUserPoolId() != null && !domainDescriptionType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((domainDescriptionType.getAWSAccountId() == null) ^ (getAWSAccountId() == null)) {
            return false;
        }
        if (domainDescriptionType.getAWSAccountId() != null && !domainDescriptionType.getAWSAccountId().equals(getAWSAccountId())) {
            return false;
        }
        if ((domainDescriptionType.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (domainDescriptionType.getDomain() != null && !domainDescriptionType.getDomain().equals(getDomain())) {
            return false;
        }
        if ((domainDescriptionType.getS3Bucket() == null) ^ (getS3Bucket() == null)) {
            return false;
        }
        if (domainDescriptionType.getS3Bucket() != null && !domainDescriptionType.getS3Bucket().equals(getS3Bucket())) {
            return false;
        }
        if ((domainDescriptionType.getCloudFrontDistribution() == null) ^ (getCloudFrontDistribution() == null)) {
            return false;
        }
        if (domainDescriptionType.getCloudFrontDistribution() != null && !domainDescriptionType.getCloudFrontDistribution().equals(getCloudFrontDistribution())) {
            return false;
        }
        if ((domainDescriptionType.getVersion() == null) ^ (getVersion() == null)) {
            return false;
        }
        if (domainDescriptionType.getVersion() != null && !domainDescriptionType.getVersion().equals(getVersion())) {
            return false;
        }
        if ((domainDescriptionType.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (domainDescriptionType.getStatus() != null && !domainDescriptionType.getStatus().equals(getStatus())) {
            return false;
        }
        if ((domainDescriptionType.getCustomDomainConfig() == null) ^ (getCustomDomainConfig() == null)) {
            return false;
        }
        return domainDescriptionType.getCustomDomainConfig() == null || domainDescriptionType.getCustomDomainConfig().equals(getCustomDomainConfig());
    }
}
