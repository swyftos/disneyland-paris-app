package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes6.dex */
public class DHParameter extends ASN1Object {

    /* JADX INFO: renamed from: g */
    ASN1Integer f4024g;

    /* JADX INFO: renamed from: l */
    ASN1Integer f4025l;

    /* JADX INFO: renamed from: p */
    ASN1Integer f4026p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f4026p = new ASN1Integer(bigInteger);
        this.f4024g = new ASN1Integer(bigInteger2);
        this.f4025l = i != 0 ? new ASN1Integer(i) : null;
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f4026p = ASN1Integer.getInstance(objects.nextElement());
        this.f4024g = ASN1Integer.getInstance(objects.nextElement());
        this.f4025l = objects.hasMoreElements() ? (ASN1Integer) objects.nextElement() : null;
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f4024g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f4025l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f4026p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f4026p);
        aSN1EncodableVector.add(this.f4024g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f4025l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
