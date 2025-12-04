package org.bouncycastle.openpgp.operator.jcajce;

import java.security.PrivateKey;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;

/* loaded from: classes6.dex */
public class JcaPGPPrivateKey extends PGPPrivateKey {
    private final PrivateKey privateKey;

    public JcaPGPPrivateKey(long j, PrivateKey privateKey) {
        super(j, null, null);
        this.privateKey = privateKey;
    }

    public JcaPGPPrivateKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey) {
        super(pGPPublicKey.getKeyID(), pGPPublicKey.getPublicKeyPacket(), null);
        this.privateKey = privateKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }
}
