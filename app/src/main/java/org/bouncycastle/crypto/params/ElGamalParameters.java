package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes6.dex */
public class ElGamalParameters implements CipherParameters {

    /* JADX INFO: renamed from: g */
    private BigInteger f4559g;

    /* JADX INFO: renamed from: l */
    private int f4560l;

    /* JADX INFO: renamed from: p */
    private BigInteger f4561p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f4559g = bigInteger2;
        this.f4561p = bigInteger;
        this.f4560l = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f4561p) && elGamalParameters.getG().equals(this.f4559g) && elGamalParameters.getL() == this.f4560l;
    }

    public BigInteger getG() {
        return this.f4559g;
    }

    public int getL() {
        return this.f4560l;
    }

    public BigInteger getP() {
        return this.f4561p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f4560l;
    }
}
