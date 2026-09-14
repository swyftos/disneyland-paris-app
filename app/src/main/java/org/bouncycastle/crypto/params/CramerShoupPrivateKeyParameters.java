package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* JADX INFO: renamed from: pk */
    private CramerShoupPublicKeyParameters f4530pk;

    /* JADX INFO: renamed from: x1 */
    private BigInteger f4531x1;

    /* JADX INFO: renamed from: x2 */
    private BigInteger f4532x2;

    /* JADX INFO: renamed from: y1 */
    private BigInteger f4533y1;

    /* JADX INFO: renamed from: y2 */
    private BigInteger f4534y2;

    /* JADX INFO: renamed from: z */
    private BigInteger f4535z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f4531x1 = bigInteger;
        this.f4532x2 = bigInteger2;
        this.f4533y1 = bigInteger3;
        this.f4534y2 = bigInteger4;
        this.f4535z = bigInteger5;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f4531x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f4532x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f4533y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f4534y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f4535z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f4530pk;
    }

    public BigInteger getX1() {
        return this.f4531x1;
    }

    public BigInteger getX2() {
        return this.f4532x2;
    }

    public BigInteger getY1() {
        return this.f4533y1;
    }

    public BigInteger getY2() {
        return this.f4534y2;
    }

    public BigInteger getZ() {
        return this.f4535z;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((((this.f4531x1.hashCode() ^ this.f4532x2.hashCode()) ^ this.f4533y1.hashCode()) ^ this.f4534y2.hashCode()) ^ this.f4535z.hashCode());
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f4530pk = cramerShoupPublicKeyParameters;
    }
}
