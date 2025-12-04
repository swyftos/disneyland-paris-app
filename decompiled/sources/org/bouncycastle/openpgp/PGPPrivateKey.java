package org.bouncycastle.openpgp;

import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;

/* loaded from: classes6.dex */
public class PGPPrivateKey {
    private long keyID;
    private BCPGKey privateKeyDataPacket;
    private PublicKeyPacket publicKeyPacket;

    public PGPPrivateKey(long j, PublicKeyPacket publicKeyPacket, BCPGKey bCPGKey) {
        this.keyID = j;
        this.publicKeyPacket = publicKeyPacket;
        this.privateKeyDataPacket = bCPGKey;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public BCPGKey getPrivateKeyDataPacket() {
        return this.privateKeyDataPacket;
    }

    public PublicKeyPacket getPublicKeyPacket() {
        return this.publicKeyPacket;
    }
}
