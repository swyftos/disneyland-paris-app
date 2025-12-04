package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeviceSecretVerifierConfigType implements Serializable {
    private String passwordVerifier;
    private String salt;

    public String getPasswordVerifier() {
        return this.passwordVerifier;
    }

    public void setPasswordVerifier(String str) {
        this.passwordVerifier = str;
    }

    public DeviceSecretVerifierConfigType withPasswordVerifier(String str) {
        this.passwordVerifier = str;
        return this;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String str) {
        this.salt = str;
    }

    public DeviceSecretVerifierConfigType withSalt(String str) {
        this.salt = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPasswordVerifier() != null) {
            sb.append("PasswordVerifier: " + getPasswordVerifier() + ",");
        }
        if (getSalt() != null) {
            sb.append("Salt: " + getSalt());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getPasswordVerifier() == null ? 0 : getPasswordVerifier().hashCode()) + 31) * 31) + (getSalt() != null ? getSalt().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceSecretVerifierConfigType)) {
            return false;
        }
        DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = (DeviceSecretVerifierConfigType) obj;
        if ((deviceSecretVerifierConfigType.getPasswordVerifier() == null) ^ (getPasswordVerifier() == null)) {
            return false;
        }
        if (deviceSecretVerifierConfigType.getPasswordVerifier() != null && !deviceSecretVerifierConfigType.getPasswordVerifier().equals(getPasswordVerifier())) {
            return false;
        }
        if ((deviceSecretVerifierConfigType.getSalt() == null) ^ (getSalt() == null)) {
            return false;
        }
        return deviceSecretVerifierConfigType.getSalt() == null || deviceSecretVerifierConfigType.getSalt().equals(getSalt());
    }
}
