package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DescribeUserPoolDomainResult implements Serializable {
    private DomainDescriptionType domainDescription;

    public DomainDescriptionType getDomainDescription() {
        return this.domainDescription;
    }

    public void setDomainDescription(DomainDescriptionType domainDescriptionType) {
        this.domainDescription = domainDescriptionType;
    }

    public DescribeUserPoolDomainResult withDomainDescription(DomainDescriptionType domainDescriptionType) {
        this.domainDescription = domainDescriptionType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomainDescription() != null) {
            sb.append("DomainDescription: " + getDomainDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getDomainDescription() == null ? 0 : getDomainDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolDomainResult)) {
            return false;
        }
        DescribeUserPoolDomainResult describeUserPoolDomainResult = (DescribeUserPoolDomainResult) obj;
        if ((describeUserPoolDomainResult.getDomainDescription() == null) ^ (getDomainDescription() == null)) {
            return false;
        }
        return describeUserPoolDomainResult.getDomainDescription() == null || describeUserPoolDomainResult.getDomainDescription().equals(getDomainDescription());
    }
}
