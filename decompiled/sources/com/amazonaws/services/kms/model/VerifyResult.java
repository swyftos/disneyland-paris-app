package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class VerifyResult implements Serializable {
    private String keyId;
    private Boolean signatureValid;
    private String signingAlgorithm;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public VerifyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Boolean isSignatureValid() {
        return this.signatureValid;
    }

    public Boolean getSignatureValid() {
        return this.signatureValid;
    }

    public void setSignatureValid(Boolean bool) {
        this.signatureValid = bool;
    }

    public VerifyResult withSignatureValid(Boolean bool) {
        this.signatureValid = bool;
        return this;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public VerifyResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSignatureValid() != null) {
            sb.append("SignatureValid: " + getSignatureValid() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getSignatureValid() == null ? 0 : getSignatureValid().hashCode())) * 31) + (getSigningAlgorithm() != null ? getSigningAlgorithm().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyResult)) {
            return false;
        }
        VerifyResult verifyResult = (VerifyResult) obj;
        if ((verifyResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (verifyResult.getKeyId() != null && !verifyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((verifyResult.getSignatureValid() == null) ^ (getSignatureValid() == null)) {
            return false;
        }
        if (verifyResult.getSignatureValid() != null && !verifyResult.getSignatureValid().equals(getSignatureValid())) {
            return false;
        }
        if ((verifyResult.getSigningAlgorithm() == null) ^ (getSigningAlgorithm() == null)) {
            return false;
        }
        return verifyResult.getSigningAlgorithm() == null || verifyResult.getSigningAlgorithm().equals(getSigningAlgorithm());
    }
}
