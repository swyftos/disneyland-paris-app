package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class VerifyUserAttributeRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String attributeName;
    private String code;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public VerifyUserAttributeRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public VerifyUserAttributeRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public VerifyUserAttributeRequest withCode(String str) {
        this.code = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName() + ",");
        }
        if (getCode() != null) {
            sb.append("Code: " + getCode());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getAttributeName() == null ? 0 : getAttributeName().hashCode())) * 31) + (getCode() != null ? getCode().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyUserAttributeRequest)) {
            return false;
        }
        VerifyUserAttributeRequest verifyUserAttributeRequest = (VerifyUserAttributeRequest) obj;
        if ((verifyUserAttributeRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (verifyUserAttributeRequest.getAccessToken() != null && !verifyUserAttributeRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((verifyUserAttributeRequest.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        if (verifyUserAttributeRequest.getAttributeName() != null && !verifyUserAttributeRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if ((verifyUserAttributeRequest.getCode() == null) ^ (getCode() == null)) {
            return false;
        }
        return verifyUserAttributeRequest.getCode() == null || verifyUserAttributeRequest.getCode().equals(getCode());
    }
}
