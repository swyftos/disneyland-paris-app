package org.bouncycastle.asn1.cryptopro;

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
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* JADX INFO: renamed from: a */
    ASN1Integer f4007a;

    /* JADX INFO: renamed from: b */
    ASN1Integer f4008b;

    /* JADX INFO: renamed from: p */
    ASN1Integer f4009p;

    /* JADX INFO: renamed from: q */
    ASN1Integer f4010q;

    /* JADX INFO: renamed from: x */
    ASN1Integer f4011x;

    /* JADX INFO: renamed from: y */
    ASN1Integer f4012y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f4007a = new ASN1Integer(bigInteger);
        this.f4008b = new ASN1Integer(bigInteger2);
        this.f4009p = new ASN1Integer(bigInteger3);
        this.f4010q = new ASN1Integer(bigInteger4);
        this.f4011x = new ASN1Integer(i);
        this.f4012y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4007a = (ASN1Integer) objects.nextElement();
        this.f4008b = (ASN1Integer) objects.nextElement();
        this.f4009p = (ASN1Integer) objects.nextElement();
        this.f4010q = (ASN1Integer) objects.nextElement();
        this.f4011x = (ASN1Integer) objects.nextElement();
        this.f4012y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f4007a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4009p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f4010q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f4007a);
        aSN1EncodableVector.add(this.f4008b);
        aSN1EncodableVector.add(this.f4009p);
        aSN1EncodableVector.add(this.f4010q);
        aSN1EncodableVector.add(this.f4011x);
        aSN1EncodableVector.add(this.f4012y);
        return new DERSequence(aSN1EncodableVector);
    }
}
