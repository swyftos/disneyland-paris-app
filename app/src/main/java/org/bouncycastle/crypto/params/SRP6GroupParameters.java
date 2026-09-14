package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class SRP6GroupParameters {

    /* JADX INFO: renamed from: N */
    private BigInteger f4589N;

    /* JADX INFO: renamed from: g */
    private BigInteger f4590g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f4589N = bigInteger;
        this.f4590g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f4590g;
    }

    public BigInteger getN() {
        return this.f4589N;
    }
}
