package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class ElGamalSecretBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: x */
    MPInteger f4103x;

    public ElGamalSecretBCPGKey(BigInteger bigInteger) {
        this.f4103x = new MPInteger(bigInteger);
    }

    public ElGamalSecretBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4103x = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4103x);
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

    public BigInteger getX() {
        return this.f4103x.getValue();
    }
}
