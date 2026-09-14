package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class GOST3410PrivateKeySpec implements KeySpec {

    /* JADX INFO: renamed from: a */
    private BigInteger f4677a;

    /* JADX INFO: renamed from: p */
    private BigInteger f4678p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4679q;

    /* JADX INFO: renamed from: x */
    private BigInteger f4680x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f4680x = bigInteger;
        this.f4678p = bigInteger2;
        this.f4679q = bigInteger3;
        this.f4677a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f4677a;
    }

    public BigInteger getP() {
        return this.f4678p;
    }

    public BigInteger getQ() {
        return this.f4679q;
    }

    public BigInteger getX() {
        return this.f4680x;
    }
}
