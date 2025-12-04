package org.bouncycastle.openpgp.operator.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.operator.PGPContentSigner;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.util.io.TeeOutputStream;

/* loaded from: classes6.dex */
public class BcPGPContentSignerBuilder implements PGPContentSignerBuilder {
    private int hashAlgorithm;
    private int keyAlgorithm;
    private SecureRandom random;
    private BcPGPDigestCalculatorProvider digestCalculatorProvider = new BcPGPDigestCalculatorProvider();
    private BcPGPKeyConverter keyConverter = new BcPGPKeyConverter();

    public BcPGPContentSignerBuilder(int i, int i2) {
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
    }

    @Override // org.bouncycastle.openpgp.operator.PGPContentSignerBuilder
    public PGPContentSigner build(final int i, final PGPPrivateKey pGPPrivateKey) throws PGPException {
        final PGPDigestCalculator pGPDigestCalculator = this.digestCalculatorProvider.get(this.hashAlgorithm);
        final Signer signerCreateSigner = BcImplProvider.createSigner(this.keyAlgorithm, this.hashAlgorithm);
        signerCreateSigner.init(true, this.random != null ? new ParametersWithRandom(this.keyConverter.getPrivateKey(pGPPrivateKey), this.random) : this.keyConverter.getPrivateKey(pGPPrivateKey));
        return new PGPContentSigner() { // from class: org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder.1
            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public byte[] getDigest() {
                return pGPDigestCalculator.getDigest();
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public int getHashAlgorithm() {
                return BcPGPContentSignerBuilder.this.hashAlgorithm;
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public int getKeyAlgorithm() {
                return BcPGPContentSignerBuilder.this.keyAlgorithm;
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public long getKeyID() {
                return pGPPrivateKey.getKeyID();
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public OutputStream getOutputStream() {
                return new TeeOutputStream(new SignerOutputStream(signerCreateSigner), pGPDigestCalculator.getOutputStream());
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public byte[] getSignature() {
                try {
                    return signerCreateSigner.generateSignature();
                } catch (CryptoException unused) {
                    throw new IllegalStateException("unable to create signature");
                }
            }

            @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
            public int getType() {
                return i;
            }
        };
    }

    public BcPGPContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
