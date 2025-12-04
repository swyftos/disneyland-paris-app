package org.bouncycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPRuntimeOperationException;
import org.bouncycastle.openpgp.operator.PGPContentVerifier;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilder;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
public class JcaPGPContentVerifierBuilderProvider implements PGPContentVerifierBuilderProvider {
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private JcaPGPDigestCalculatorProviderBuilder digestCalculatorProviderBuilder = new JcaPGPDigestCalculatorProviderBuilder();
    private JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();

    private class JcaPGPContentVerifierBuilder implements PGPContentVerifierBuilder {
        private int hashAlgorithm;
        private int keyAlgorithm;

        public JcaPGPContentVerifierBuilder(int i, int i2) {
            this.keyAlgorithm = i;
            this.hashAlgorithm = i2;
        }

        @Override // org.bouncycastle.openpgp.operator.PGPContentVerifierBuilder
        public PGPContentVerifier build(final PGPPublicKey pGPPublicKey) throws InvalidKeyException, PGPException {
            final Signature signatureCreateSignature = JcaPGPContentVerifierBuilderProvider.this.helper.createSignature(this.keyAlgorithm, this.hashAlgorithm);
            final PGPDigestCalculator pGPDigestCalculator = JcaPGPContentVerifierBuilderProvider.this.digestCalculatorProviderBuilder.build().get(this.hashAlgorithm);
            final PublicKey publicKey = JcaPGPContentVerifierBuilderProvider.this.keyConverter.getPublicKey(pGPPublicKey);
            try {
                signatureCreateSignature.initVerify(publicKey);
                return new PGPContentVerifier() { // from class: org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider.JcaPGPContentVerifierBuilder.1
                    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                    public int getHashAlgorithm() {
                        return JcaPGPContentVerifierBuilder.this.hashAlgorithm;
                    }

                    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                    public int getKeyAlgorithm() {
                        return JcaPGPContentVerifierBuilder.this.keyAlgorithm;
                    }

                    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                    public long getKeyID() {
                        return pGPPublicKey.getKeyID();
                    }

                    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                    public OutputStream getOutputStream() {
                        return JcaPGPContentVerifierBuilder.this.keyAlgorithm == 22 ? pGPDigestCalculator.getOutputStream() : OutputStreamFactory.createStream(signatureCreateSignature);
                    }

                    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifier
                    public boolean verify(byte[] bArr) throws SignatureException {
                        int iBitLength;
                        try {
                            PublicKey publicKey2 = publicKey;
                            if ((publicKey2 instanceof RSAPublicKey) && bArr.length < (iBitLength = (((RSAPublicKey) publicKey2).getModulus().bitLength() + 7) / 8)) {
                                byte[] bArr2 = new byte[iBitLength];
                                System.arraycopy(bArr, 0, bArr2, iBitLength - bArr.length, bArr.length);
                                return signatureCreateSignature.verify(bArr2);
                            }
                            if (JcaPGPContentVerifierBuilder.this.keyAlgorithm != 22) {
                                return signatureCreateSignature.verify(bArr);
                            }
                            signatureCreateSignature.update(pGPDigestCalculator.getDigest());
                            return signatureCreateSignature.verify(bArr);
                        } catch (SignatureException e) {
                            throw new PGPRuntimeOperationException("unable to verify signature: " + e.getMessage(), e);
                        }
                    }
                };
            } catch (InvalidKeyException e) {
                throw new PGPException("invalid key.", e);
            }
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider
    public PGPContentVerifierBuilder get(int i, int i2) throws PGPException {
        return new JcaPGPContentVerifierBuilder(i, i2);
    }

    public JcaPGPContentVerifierBuilderProvider setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public JcaPGPContentVerifierBuilderProvider setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }
}
