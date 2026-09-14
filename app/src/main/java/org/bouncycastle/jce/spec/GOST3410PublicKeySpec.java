package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class GOST3410PublicKeySpec implements KeySpec {

    /* JADX INFO: renamed from: a */
    private BigInteger f4684a;

    /* JADX INFO: renamed from: p */
    private BigInteger f4685p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4686q;

    /* JADX INFO: renamed from: y */
    private BigInteger f4687y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f4687y = bigInteger;
        this.f4685p = bigInteger2;
        this.f4686q = bigInteger3;
        this.f4684a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f4684a;
    }

    public BigInteger getP() {
        return this.f4685p;
    }

    public BigInteger getQ() {
        return this.f4686q;
    }

    public BigInteger getY() {
        return this.f4687y;
    }
}
