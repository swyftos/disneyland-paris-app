package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* JADX INFO: renamed from: c */
    private BigInteger f4536c;

    /* JADX INFO: renamed from: d */
    private BigInteger f4537d;

    /* JADX INFO: renamed from: h */
    private BigInteger f4538h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f4536c = bigInteger;
        this.f4537d = bigInteger2;
        this.f4538h = bigInteger3;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f4536c) && cramerShoupPublicKeyParameters.getD().equals(this.f4537d) && cramerShoupPublicKeyParameters.getH().equals(this.f4538h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f4536c;
    }

    public BigInteger getD() {
        return this.f4537d;
    }

    public BigInteger getH() {
        return this.f4538h;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((this.f4536c.hashCode() ^ this.f4537d.hashCode()) ^ this.f4538h.hashCode());
    }
}
