package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AuthenticationResultType implements Serializable {
    private String accessToken;
    private Integer expiresIn;
    private String idToken;
    private NewDeviceMetadataType newDeviceMetadata;
    private String refreshToken;
    private String tokenType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public AuthenticationResultType withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public Integer getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(Integer num) {
        this.expiresIn = num;
    }

    public AuthenticationResultType withExpiresIn(Integer num) {
        this.expiresIn = num;
        return this;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public AuthenticationResultType withTokenType(String str) {
        this.tokenType = str;
        return this;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public AuthenticationResultType withRefreshToken(String str) {
        this.refreshToken = str;
        return this;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public void setIdToken(String str) {
        this.idToken = str;
    }

    public AuthenticationResultType withIdToken(String str) {
        this.idToken = str;
        return this;
    }

    public NewDeviceMetadataType getNewDeviceMetadata() {
        return this.newDeviceMetadata;
    }

    public void setNewDeviceMetadata(NewDeviceMetadataType newDeviceMetadataType) {
        this.newDeviceMetadata = newDeviceMetadataType;
    }

    public AuthenticationResultType withNewDeviceMetadata(NewDeviceMetadataType newDeviceMetadataType) {
        this.newDeviceMetadata = newDeviceMetadataType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getExpiresIn() != null) {
            sb.append("ExpiresIn: " + getExpiresIn() + ",");
        }
        if (getTokenType() != null) {
            sb.append("TokenType: " + getTokenType() + ",");
        }
        if (getRefreshToken() != null) {
            sb.append("RefreshToken: " + getRefreshToken() + ",");
        }
        if (getIdToken() != null) {
            sb.append("IdToken: " + getIdToken() + ",");
        }
        if (getNewDeviceMetadata() != null) {
            sb.append("NewDeviceMetadata: " + getNewDeviceMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getExpiresIn() == null ? 0 : getExpiresIn().hashCode())) * 31) + (getTokenType() == null ? 0 : getTokenType().hashCode())) * 31) + (getRefreshToken() == null ? 0 : getRefreshToken().hashCode())) * 31) + (getIdToken() == null ? 0 : getIdToken().hashCode())) * 31) + (getNewDeviceMetadata() != null ? getNewDeviceMetadata().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthenticationResultType)) {
            return false;
        }
        AuthenticationResultType authenticationResultType = (AuthenticationResultType) obj;
        if ((authenticationResultType.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (authenticationResultType.getAccessToken() != null && !authenticationResultType.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((authenticationResultType.getExpiresIn() == null) ^ (getExpiresIn() == null)) {
            return false;
        }
        if (authenticationResultType.getExpiresIn() != null && !authenticationResultType.getExpiresIn().equals(getExpiresIn())) {
            return false;
        }
        if ((authenticationResultType.getTokenType() == null) ^ (getTokenType() == null)) {
            return false;
        }
        if (authenticationResultType.getTokenType() != null && !authenticationResultType.getTokenType().equals(getTokenType())) {
            return false;
        }
        if ((authenticationResultType.getRefreshToken() == null) ^ (getRefreshToken() == null)) {
            return false;
        }
        if (authenticationResultType.getRefreshToken() != null && !authenticationResultType.getRefreshToken().equals(getRefreshToken())) {
            return false;
        }
        if ((authenticationResultType.getIdToken() == null) ^ (getIdToken() == null)) {
            return false;
        }
        if (authenticationResultType.getIdToken() != null && !authenticationResultType.getIdToken().equals(getIdToken())) {
            return false;
        }
        if ((authenticationResultType.getNewDeviceMetadata() == null) ^ (getNewDeviceMetadata() == null)) {
            return false;
        }
        return authenticationResultType.getNewDeviceMetadata() == null || authenticationResultType.getNewDeviceMetadata().equals(getNewDeviceMetadata());
    }
}
