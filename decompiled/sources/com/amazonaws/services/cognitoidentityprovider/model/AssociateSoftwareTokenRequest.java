package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AssociateSoftwareTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String session;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public AssociateSoftwareTokenRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public AssociateSoftwareTokenRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getSession() != null ? getSession().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateSoftwareTokenRequest)) {
            return false;
        }
        AssociateSoftwareTokenRequest associateSoftwareTokenRequest = (AssociateSoftwareTokenRequest) obj;
        if ((associateSoftwareTokenRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (associateSoftwareTokenRequest.getAccessToken() != null && !associateSoftwareTokenRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((associateSoftwareTokenRequest.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        return associateSoftwareTokenRequest.getSession() == null || associateSoftwareTokenRequest.getSession().equals(getSession());
    }
}
