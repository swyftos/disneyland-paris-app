package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes6.dex */
public class RSAPublicBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger e;
    MPInteger n;

    public RSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.n = new MPInteger(bigInteger);
        this.e = new MPInteger(bigInteger2);
    }

    public RSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.n = new MPInteger(bCPGInputStream);
        this.e = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.n);
        bCPGOutputStream.writeObject(this.e);
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

    public BigInteger getModulus() {
        return this.n.getValue();
    }

    public BigInteger getPublicExponent() {
        return this.e.getValue();
    }
}
