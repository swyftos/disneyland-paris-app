package org.bouncycastle.crypto.params;

import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* JADX INFO: renamed from: q */
    private final ECPoint f4558q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f4558q = eCDomainParameters.validatePublicPoint(eCPoint);
    }

    public ECPoint getQ() {
        return this.f4558q;
    }
}
