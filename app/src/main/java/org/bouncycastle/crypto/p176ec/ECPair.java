package org.bouncycastle.crypto.p176ec;

import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public class ECPair {

    /* JADX INFO: renamed from: x */
    private final ECPoint f4306x;

    /* JADX INFO: renamed from: y */
    private final ECPoint f4307y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f4306x = eCPoint;
        this.f4307y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f4306x;
    }

    public ECPoint getY() {
        return this.f4307y;
    }

    public int hashCode() {
        return this.f4306x.hashCode() + (this.f4307y.hashCode() * 37);
    }
}
