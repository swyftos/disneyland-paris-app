package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetSigningCertificateResult implements Serializable {
    private String certificate;

    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public GetSigningCertificateResult withCertificate(String str) {
        this.certificate = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificate() != null) {
            sb.append("Certificate: " + getCertificate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCertificate() == null ? 0 : getCertificate().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateResult)) {
            return false;
        }
        GetSigningCertificateResult getSigningCertificateResult = (GetSigningCertificateResult) obj;
        if ((getSigningCertificateResult.getCertificate() == null) ^ (getCertificate() == null)) {
            return false;
        }
        return getSigningCertificateResult.getCertificate() == null || getSigningCertificateResult.getCertificate().equals(getCertificate());
    }
}
