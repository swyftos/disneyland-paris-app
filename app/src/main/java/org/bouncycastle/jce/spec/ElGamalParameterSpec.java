package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: g */
    private BigInteger f4673g;

    /* JADX INFO: renamed from: p */
    private BigInteger f4674p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f4674p = bigInteger;
        this.f4673g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f4673g;
    }

    public BigInteger getP() {
        return this.f4674p;
    }
}
