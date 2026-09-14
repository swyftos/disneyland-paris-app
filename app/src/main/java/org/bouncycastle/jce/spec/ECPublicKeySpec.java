package org.bouncycastle.jce.spec;

import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public class ECPublicKeySpec extends ECKeySpec {

    /* JADX INFO: renamed from: q */
    private ECPoint f4672q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f4672q = eCPoint.getCurve() != null ? eCPoint.normalize() : eCPoint;
    }

    public ECPoint getQ() {
        return this.f4672q;
    }
}
