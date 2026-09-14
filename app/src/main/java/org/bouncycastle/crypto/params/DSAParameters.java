package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes6.dex */
public class DSAParameters implements CipherParameters {

    /* JADX INFO: renamed from: g */
    private BigInteger f4549g;

    /* JADX INFO: renamed from: p */
    private BigInteger f4550p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4551q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4549g = bigInteger3;
        this.f4550p = bigInteger;
        this.f4551q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f4549g = bigInteger3;
        this.f4550p = bigInteger;
        this.f4551q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f4550p) && dSAParameters.getQ().equals(this.f4551q) && dSAParameters.getG().equals(this.f4549g);
    }

    public BigInteger getG() {
        return this.f4549g;
    }

    public BigInteger getP() {
        return this.f4550p;
    }

    public BigInteger getQ() {
        return this.f4551q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return getG().hashCode() ^ (getP().hashCode() ^ getQ().hashCode());
    }
}
