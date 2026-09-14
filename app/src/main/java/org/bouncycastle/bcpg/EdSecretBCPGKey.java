package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class EdSecretBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: x */
    MPInteger f4099x;

    public EdSecretBCPGKey(BigInteger bigInteger) {
        this.f4099x = new MPInteger(bigInteger);
    }

    public EdSecretBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4099x = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4099x);
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
        return this.f4099x.getValue();
    }
}
