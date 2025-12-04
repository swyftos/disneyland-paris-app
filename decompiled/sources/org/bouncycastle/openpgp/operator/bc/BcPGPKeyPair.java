package org.bouncycastle.openpgp.operator.bc;

import java.util.Date;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.openpgp.PGPAlgorithmParameters;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;

/* loaded from: classes6.dex */
public class BcPGPKeyPair extends PGPKeyPair {
    public BcPGPKeyPair(int i, AsymmetricCipherKeyPair asymmetricCipherKeyPair, Date date) throws PGPException {
        PGPPublicKey publicKey = getPublicKey(i, null, asymmetricCipherKeyPair.getPublic(), date);
        this.pub = publicKey;
        this.priv = getPrivateKey(publicKey, asymmetricCipherKeyPair.getPrivate());
    }

    public BcPGPKeyPair(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricCipherKeyPair asymmetricCipherKeyPair, Date date) throws PGPException {
        PGPPublicKey publicKey = getPublicKey(i, pGPAlgorithmParameters, asymmetricCipherKeyPair.getPublic(), date);
        this.pub = publicKey;
        this.priv = getPrivateKey(publicKey, asymmetricCipherKeyPair.getPrivate());
    }

    private static PGPPrivateKey getPrivateKey(PGPPublicKey pGPPublicKey, AsymmetricKeyParameter asymmetricKeyParameter) {
        return new BcPGPKeyConverter().getPGPPrivateKey(pGPPublicKey, asymmetricKeyParameter);
    }

    private static PGPPublicKey getPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricKeyParameter asymmetricKeyParameter, Date date) {
        return new BcPGPKeyConverter().getPGPPublicKey(i, pGPAlgorithmParameters, asymmetricKeyParameter, date);
    }
}
