package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes6.dex */
public class CramerShoupParameters implements CipherParameters {

    /* JADX INFO: renamed from: H */
    private Digest f4526H;

    /* JADX INFO: renamed from: g1 */
    private BigInteger f4527g1;

    /* JADX INFO: renamed from: g2 */
    private BigInteger f4528g2;

    /* JADX INFO: renamed from: p */
    private BigInteger f4529p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.f4529p = bigInteger;
        this.f4527g1 = bigInteger2;
        this.f4528g2 = bigInteger3;
        Digest digest2 = (Digest) ((Memoable) digest).copy();
        this.f4526H = digest2;
        digest2.reset();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        return cramerShoupParameters.getP().equals(this.f4529p) && cramerShoupParameters.getG1().equals(this.f4527g1) && cramerShoupParameters.getG2().equals(this.f4528g2);
    }

    public BigInteger getG1() {
        return this.f4527g1;
    }

    public BigInteger getG2() {
        return this.f4528g2;
    }

    public Digest getH() {
        return (Digest) ((Memoable) this.f4526H).copy();
    }

    public BigInteger getP() {
        return this.f4529p;
    }

    public int hashCode() {
        return getG2().hashCode() ^ (getP().hashCode() ^ getG1().hashCode());
    }
}
