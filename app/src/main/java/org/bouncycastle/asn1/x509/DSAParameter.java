package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes6.dex */
public class DSAParameter extends ASN1Object {

    /* JADX INFO: renamed from: g */
    ASN1Integer f4058g;

    /* JADX INFO: renamed from: p */
    ASN1Integer f4059p;

    /* JADX INFO: renamed from: q */
    ASN1Integer f4060q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4059p = new ASN1Integer(bigInteger);
        this.f4060q = new ASN1Integer(bigInteger2);
        this.f4058g = new ASN1Integer(bigInteger3);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4059p = ASN1Integer.getInstance(objects.nextElement());
        this.f4060q = ASN1Integer.getInstance(objects.nextElement());
        this.f4058g = ASN1Integer.getInstance(objects.nextElement());
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getG() {
        return this.f4058g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4059p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f4060q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f4059p);
        aSN1EncodableVector.add(this.f4060q);
        aSN1EncodableVector.add(this.f4058g);
        return new DERSequence(aSN1EncodableVector);
    }
}
