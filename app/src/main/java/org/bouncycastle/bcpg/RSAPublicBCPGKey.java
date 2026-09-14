package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class RSAPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: e */
    MPInteger f4106e;

    /* JADX INFO: renamed from: n */
    MPInteger f4107n;

    public RSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f4107n = new MPInteger(bigInteger);
        this.f4106e = new MPInteger(bigInteger2);
    }

    public RSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.f4107n = new MPInteger(bCPGInputStream);
        this.f4106e = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.f4107n);
        bCPGOutputStream.writeObject(this.f4106e);
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
        return this.f4107n.getValue();
    }

    public BigInteger getPublicExponent() {
        return this.f4106e.getValue();
    }
}
