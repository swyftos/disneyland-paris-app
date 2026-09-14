package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class GOST3410PublicKeyParameterSetSpec {

    /* JADX INFO: renamed from: a */
    private BigInteger f4681a;

    /* JADX INFO: renamed from: p */
    private BigInteger f4682p;

    /* JADX INFO: renamed from: q */
    private BigInteger f4683q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4682p = bigInteger;
        this.f4683q = bigInteger2;
        this.f4681a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f4681a.equals(gOST3410PublicKeyParameterSetSpec.f4681a) && this.f4682p.equals(gOST3410PublicKeyParameterSetSpec.f4682p) && this.f4683q.equals(gOST3410PublicKeyParameterSetSpec.f4683q);
    }

    public BigInteger getA() {
        return this.f4681a;
    }

    public BigInteger getP() {
        return this.f4682p;
    }

    public BigInteger getQ() {
        return this.f4683q;
    }

    public int hashCode() {
        return this.f4683q.hashCode() ^ (this.f4681a.hashCode() ^ this.f4682p.hashCode());
    }
}
