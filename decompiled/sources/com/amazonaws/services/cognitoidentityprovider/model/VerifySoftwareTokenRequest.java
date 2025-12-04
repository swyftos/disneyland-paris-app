package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class VerifySoftwareTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String friendlyDeviceName;
    private String session;
    private String userCode;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public VerifySoftwareTokenRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public VerifySoftwareTokenRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public VerifySoftwareTokenRequest withUserCode(String str) {
        this.userCode = str;
        return this;
    }

    public String getFriendlyDeviceName() {
        return this.friendlyDeviceName;
    }

    public void setFriendlyDeviceName(String str) {
        this.friendlyDeviceName = str;
    }

    public VerifySoftwareTokenRequest withFriendlyDeviceName(String str) {
        this.friendlyDeviceName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getUserCode() != null) {
            sb.append("UserCode: " + getUserCode() + ",");
        }
        if (getFriendlyDeviceName() != null) {
            sb.append("FriendlyDeviceName: " + getFriendlyDeviceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getSession() == null ? 0 : getSession().hashCode())) * 31) + (getUserCode() == null ? 0 : getUserCode().hashCode())) * 31) + (getFriendlyDeviceName() != null ? getFriendlyDeviceName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifySoftwareTokenRequest)) {
            return false;
        }
        VerifySoftwareTokenRequest verifySoftwareTokenRequest = (VerifySoftwareTokenRequest) obj;
        if ((verifySoftwareTokenRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (verifySoftwareTokenRequest.getAccessToken() != null && !verifySoftwareTokenRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((verifySoftwareTokenRequest.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        if (verifySoftwareTokenRequest.getSession() != null && !verifySoftwareTokenRequest.getSession().equals(getSession())) {
            return false;
        }
        if ((verifySoftwareTokenRequest.getUserCode() == null) ^ (getUserCode() == null)) {
            return false;
        }
        if (verifySoftwareTokenRequest.getUserCode() != null && !verifySoftwareTokenRequest.getUserCode().equals(getUserCode())) {
            return false;
        }
        if ((verifySoftwareTokenRequest.getFriendlyDeviceName() == null) ^ (getFriendlyDeviceName() == null)) {
            return false;
        }
        return verifySoftwareTokenRequest.getFriendlyDeviceName() == null || verifySoftwareTokenRequest.getFriendlyDeviceName().equals(getFriendlyDeviceName());
    }
}
