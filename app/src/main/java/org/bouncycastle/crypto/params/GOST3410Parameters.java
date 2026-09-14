package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes6.dex */
public class GOST3410Parameters implements CipherParameters {

    /* JADX INFO: renamed from: a */
    private BigInteger f4564a;

    /* JADX INFO: renamed from: p */
    private BigInteger f4565p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4566q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4565p = bigInteger;
        this.f4566q = bigInteger2;
        this.f4564a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f4564a = bigInteger3;
        this.f4565p = bigInteger;
        this.f4566q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f4565p) && gOST3410Parameters.getQ().equals(this.f4566q) && gOST3410Parameters.getA().equals(this.f4564a);
    }

    public BigInteger getA() {
        return this.f4564a;
    }

    public BigInteger getP() {
        return this.f4565p;
    }

    public BigInteger getQ() {
        return this.f4566q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return this.f4564a.hashCode() ^ (this.f4565p.hashCode() ^ this.f4566q.hashCode());
    }
}
