package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class ElGamalPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: g */
    MPInteger f4100g;

    /* JADX INFO: renamed from: p */
    MPInteger f4101p;

    /* JADX INFO: renamed from: y */
    MPInteger f4102y;

    public ElGamalPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4101p = new MPInteger(bigInteger);
        this.f4100g = new MPInteger(bigInteger2);
        this.f4102y = new MPInteger(bigInteger3);
    }

    public ElGamalPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4101p = new MPInteger(bCPGInputStream);
        this.f4100g = new MPInteger(bCPGInputStream);
        this.f4102y = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4101p);
        bCPGOutputStream.writeObject(this.f4100g);
        bCPGOutputStream.writeObject(this.f4102y);
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
        return this.f4100g.getValue();
    }

    public BigInteger getP() {
        return this.f4101p.getValue();
    }

    public BigInteger getY() {
        return this.f4102y.getValue();
    }
}
