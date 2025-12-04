package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DescribeUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private String domain;

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public DescribeUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getDomain() == null ? 0 : getDomain().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolDomainRequest)) {
            return false;
        }
        DescribeUserPoolDomainRequest describeUserPoolDomainRequest = (DescribeUserPoolDomainRequest) obj;
        if ((describeUserPoolDomainRequest.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        return describeUserPoolDomainRequest.getDomain() == null || describeUserPoolDomainRequest.getDomain().equals(getDomain());
    }
}
