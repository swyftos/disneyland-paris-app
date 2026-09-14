package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes6.dex */
public class ElGamalParameter extends ASN1Object {

    /* JADX INFO: renamed from: g */
    ASN1Integer f4022g;

    /* JADX INFO: renamed from: p */
    ASN1Integer f4023p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f4023p = new ASN1Integer(bigInteger);
        this.f4022g = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4023p = (ASN1Integer) objects.nextElement();
        this.f4022g = (ASN1Integer) objects.nextElement();
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f4022g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4023p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.f4023p);
        aSN1EncodableVector.add(this.f4022g);
        return new DERSequence(aSN1EncodableVector);
    }
}
