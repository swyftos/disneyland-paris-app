package org.bouncycastle.math.p183ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class GLVTypeAParameters {

    /* JADX INFO: renamed from: i */
    protected final BigInteger f4770i;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeAParameters(BigInteger bigInteger, BigInteger bigInteger2, ScalarSplitParameters scalarSplitParameters) {
        this.f4770i = bigInteger;
        this.lambda = bigInteger2;
        this.splitParams = scalarSplitParameters;
    }

    public BigInteger getI() {
        return this.f4770i;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
