package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeleteUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private String domain;
    private String userPoolId;

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public DeleteUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DeleteUserPoolDomainRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getDomain() == null ? 0 : getDomain().hashCode()) + 31) * 31) + (getUserPoolId() != null ? getUserPoolId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserPoolDomainRequest)) {
            return false;
        }
        DeleteUserPoolDomainRequest deleteUserPoolDomainRequest = (DeleteUserPoolDomainRequest) obj;
        if ((deleteUserPoolDomainRequest.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (deleteUserPoolDomainRequest.getDomain() != null && !deleteUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return false;
        }
        if ((deleteUserPoolDomainRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return deleteUserPoolDomainRequest.getUserPoolId() == null || deleteUserPoolDomainRequest.getUserPoolId().equals(getUserPoolId());
    }
}
