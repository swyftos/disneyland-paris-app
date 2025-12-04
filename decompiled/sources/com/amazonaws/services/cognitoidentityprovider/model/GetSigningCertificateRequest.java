package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetSigningCertificateRequest extends AmazonWebServiceRequest implements Serializable {
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetSigningCertificateRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateRequest)) {
            return false;
        }
        GetSigningCertificateRequest getSigningCertificateRequest = (GetSigningCertificateRequest) obj;
        if ((getSigningCertificateRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return getSigningCertificateRequest.getUserPoolId() == null || getSigningCertificateRequest.getUserPoolId().equals(getUserPoolId());
    }
}
