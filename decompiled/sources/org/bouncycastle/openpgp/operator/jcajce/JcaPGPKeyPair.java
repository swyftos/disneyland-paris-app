package org.bouncycastle.openpgp.operator.jcajce;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import org.bouncycastle.openpgp.PGPAlgorithmParameters;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;

/* loaded from: classes6.dex */
public class JcaPGPKeyPair extends PGPKeyPair {
    public JcaPGPKeyPair(int i, KeyPair keyPair, Date date) throws PGPException {
        PGPPublicKey publicKey = getPublicKey(i, keyPair.getPublic(), date);
        this.pub = publicKey;
        this.priv = getPrivateKey(publicKey, keyPair.getPrivate());
    }

    public JcaPGPKeyPair(int i, PGPAlgorithmParameters pGPAlgorithmParameters, KeyPair keyPair, Date date) throws PGPException {
        PGPPublicKey publicKey = getPublicKey(i, pGPAlgorithmParameters, keyPair.getPublic(), date);
        this.pub = publicKey;
        this.priv = getPrivateKey(publicKey, keyPair.getPrivate());
    }

    private static PGPPrivateKey getPrivateKey(PGPPublicKey pGPPublicKey, PrivateKey privateKey) {
        return new JcaPGPKeyConverter().getPGPPrivateKey(pGPPublicKey, privateKey);
    }

    private static PGPPublicKey getPublicKey(int i, PublicKey publicKey, Date date) {
        return new JcaPGPKeyConverter().getPGPPublicKey(i, publicKey, date);
    }

    private static PGPPublicKey getPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, PublicKey publicKey, Date date) {
        return new JcaPGPKeyConverter().getPGPPublicKey(i, pGPAlgorithmParameters, publicKey, date);
    }
}
