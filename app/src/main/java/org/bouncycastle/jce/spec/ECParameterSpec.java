package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.math.p183ec.ECCurve;
import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: G */
    private ECPoint f4668G;
    private ECCurve curve;

    /* JADX INFO: renamed from: h */
    private BigInteger f4669h;

    /* JADX INFO: renamed from: n */
    private BigInteger f4670n;
    private byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f4668G = eCPoint.normalize();
        this.f4670n = bigInteger;
        this.f4669h = BigInteger.valueOf(1L);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f4668G = eCPoint.normalize();
        this.f4670n = bigInteger;
        this.f4669h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f4668G = eCPoint.normalize();
        this.f4670n = bigInteger;
        this.f4669h = bigInteger2;
        this.seed = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        return getCurve().equals(eCParameterSpec.getCurve()) && getG().equals(eCParameterSpec.getG());
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f4668G;
    }

    public BigInteger getH() {
        return this.f4669h;
    }

    public BigInteger getN() {
        return this.f4670n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return getG().hashCode() ^ getCurve().hashCode();
    }
}
