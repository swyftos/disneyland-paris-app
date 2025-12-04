package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CustomDomainConfigType implements Serializable {
    private String certificateArn;

    public String getCertificateArn() {
        return this.certificateArn;
    }

    public void setCertificateArn(String str) {
        this.certificateArn = str;
    }

    public CustomDomainConfigType withCertificateArn(String str) {
        this.certificateArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificateArn() != null) {
            sb.append("CertificateArn: " + getCertificateArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCertificateArn() == null ? 0 : getCertificateArn().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CustomDomainConfigType)) {
            return false;
        }
        CustomDomainConfigType customDomainConfigType = (CustomDomainConfigType) obj;
        if ((customDomainConfigType.getCertificateArn() == null) ^ (getCertificateArn() == null)) {
            return false;
        }
        return customDomainConfigType.getCertificateArn() == null || customDomainConfigType.getCertificateArn().equals(getCertificateArn());
    }
}
