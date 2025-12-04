package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Primitive;

/* loaded from: classes6.dex */
public class CertificateType {
    public static final CertificateType Explicit = new CertificateType(0);
    public static final CertificateType Implicit = new CertificateType(1);
    private final ASN1Enumerated enumerated;

    protected CertificateType(int i) {
        this.enumerated = new ASN1Enumerated(i);
    }

    private CertificateType(ASN1Enumerated aSN1Enumerated) {
        this.enumerated = aSN1Enumerated;
    }

    public CertificateType getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof CertificateType ? (CertificateType) obj : new CertificateType(ASN1Enumerated.getInstance(obj));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.enumerated;
    }
}
