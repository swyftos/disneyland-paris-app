package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class DSAPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: g */
    MPInteger f4093g;

    /* JADX INFO: renamed from: p */
    MPInteger f4094p;

    /* JADX INFO: renamed from: q */
    MPInteger f4095q;

    /* JADX INFO: renamed from: y */
    MPInteger f4096y;

    public DSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f4094p = new MPInteger(bigInteger);
        this.f4095q = new MPInteger(bigInteger2);
        this.f4093g = new MPInteger(bigInteger3);
        this.f4096y = new MPInteger(bigInteger4);
    }

    public DSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4094p = new MPInteger(bCPGInputStream);
        this.f4095q = new MPInteger(bCPGInputStream);
        this.f4093g = new MPInteger(bCPGInputStream);
        this.f4096y = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4094p);
        bCPGOutputStream.writeObject(this.f4095q);
        bCPGOutputStream.writeObject(this.f4093g);
        bCPGOutputStream.writeObject(this.f4096y);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.bcpg.BCPGKey
    public String getFormat() {
        return "PGP";
    }

    public BigInteger getG() {
        return this.f4093g.getValue();
    }

    public BigInteger getP() {
        return this.f4094p.getValue();
    }

    public BigInteger getQ() {
        return this.f4095q.getValue();
    }

    public BigInteger getY() {
        return this.f4096y.getValue();
    }
}
