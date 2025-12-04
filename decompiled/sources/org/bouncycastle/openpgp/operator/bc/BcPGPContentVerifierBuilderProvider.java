package org.bouncycastle.openpgp.operator.bc;

import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.operator.PGPContentVerifier;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilder;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;

/* loaded from: classes6.dex */
public class BcPGPContentVerifierBuilderProvider implements PGPContentVerifierBuilderProvider {
    private BcPGPKeyConverter keyConverter = new BcPGPKeyConverter();

    private class BcPGPContentVerifierBuilder implements PGPContentVerifierBuilder {
        private int hashAlgorithm;
        private int keyAlgorithm;

        public BcPGPContentVerifierBuilder(int i, int i2) {
            this.keyAlgorithm = i;
            this.hashAlgorithm = i2;
        }

        @Override // org.bouncycastle.openpgp.operator.PGPContentVerifierBuilder
        public PGPContentVerifier build(final PGPPublicKey pGPPublicKey) throws PGPException {
            final Signer signerCreateSigner = BcImplProvider.createSigner(this.keyAlgorithm, this.hashAlgorithm);
            signerCreateSigner.init(false, BcPGPContentVerifierBuilderProvider.this.keyConverter.getPublicKey(pGPPublicKey));
            return new PGPContentVerifier() { // from class: org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider.BcPGPContentVerifierBuilder.1
                @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                public int getHashAlgorithm() {
                    return BcPGPContentVerifierBuilder.this.hashAlgorithm;
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                public int getKeyAlgorithm() {
                    return BcPGPContentVerifierBuilder.this.keyAlgorithm;
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                public long getKeyID() {
                    return pGPPublicKey.getKeyID();
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                public OutputStream getOutputStream() {
                    return new SignerOutputStream(signerCreateSigner);
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                public boolean verify(byte[] bArr) {
                    return signerCreateSigner.verifySignature(bArr);
                }
            };
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider
    public PGPContentVerifierBuilder get(int i, int i2) throws PGPException {
        return new BcPGPContentVerifierBuilder(i, i2);
    }
}
