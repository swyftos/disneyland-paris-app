package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* loaded from: classes6.dex */
public class SymmAlgorithm extends ASN1Object {
    public static SymmAlgorithm aes128Ccm = new SymmAlgorithm(new ASN1Enumerated(0));
    private ASN1Enumerated symmAlgorithm;

    public SymmAlgorithm(int i) {
        this.symmAlgorithm = new ASN1Enumerated(i);
    }

    private SymmAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this.symmAlgorithm = aSN1Enumerated;
    }

    public SymmAlgorithm getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof SymmAlgorithm ? (SymmAlgorithm) obj : new SymmAlgorithm(ASN1Enumerated.getInstance(obj));
    }

    public ASN1Enumerated getSymmAlgorithm() {
        return this.symmAlgorithm;
    }

    public void setSymmAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this.symmAlgorithm = aSN1Enumerated;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.symmAlgorithm.toASN1Primitive();
    }
}
