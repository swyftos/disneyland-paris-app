package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* JADX INFO: renamed from: dP */
    private BigInteger f4584dP;

    /* JADX INFO: renamed from: dQ */
    private BigInteger f4585dQ;

    /* JADX INFO: renamed from: e */
    private BigInteger f4586e;

    /* JADX INFO: renamed from: p */
    private BigInteger f4587p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4588q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f4586e = bigInteger2;
        this.f4587p = bigInteger4;
        this.f4588q = bigInteger5;
        this.f4584dP = bigInteger6;
        this.f4585dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.f4584dP;
    }

    public BigInteger getDQ() {
        return this.f4585dQ;
    }

    public BigInteger getP() {
        return this.f4587p;
    }

    public BigInteger getPublicExponent() {
        return this.f4586e;
    }

    public BigInteger getQ() {
        return this.f4588q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
