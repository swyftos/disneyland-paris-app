package org.bouncycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPRuntimeOperationException;
import org.bouncycastle.openpgp.operator.PGPContentSigner;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.util.io.TeeOutputStream;

/* loaded from: classes6.dex */
public class JcaPGPContentSignerBuilder implements PGPContentSignerBuilder {
    private int hashAlgorithm;
    private int keyAlgorithm;
    private SecureRandom random;
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private JcaPGPDigestCalculatorProviderBuilder digestCalculatorProviderBuilder = new JcaPGPDigestCalculatorProviderBuilder();
    private JcaPGPKeyConverter keyConverter = new JcaPGPKeyConverter();

    public JcaPGPContentSignerBuilder(int i, int i2) {
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
    }

    public PGPContentSigner build(final int i, final long j, PrivateKey privateKey) throws InvalidKeyException, PGPException {
        final PGPDigestCalculator pGPDigestCalculator = this.digestCalculatorProviderBuilder.build().get(this.hashAlgorithm);
        final PGPDigestCalculator pGPDigestCalculator2 = this.digestCalculatorProviderBuilder.build().get(this.hashAlgorithm);
        final Signature signatureCreateSignature = this.helper.createSignature(this.keyAlgorithm, this.hashAlgorithm);
        try {
            SecureRandom secureRandom = this.random;
            if (secureRandom != null) {
                signatureCreateSignature.initSign(privateKey, secureRandom);
            } else {
                signatureCreateSignature.initSign(privateKey);
            }
            return new PGPContentSigner() { // from class: org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder.1
                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public byte[] getDigest() {
                    return pGPDigestCalculator.getDigest();
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public int getHashAlgorithm() {
                    return JcaPGPContentSignerBuilder.this.hashAlgorithm;
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public int getKeyAlgorithm() {
                    return JcaPGPContentSignerBuilder.this.keyAlgorithm;
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public long getKeyID() {
                    return j;
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public OutputStream getOutputStream() {
                    return JcaPGPContentSignerBuilder.this.keyAlgorithm == 22 ? new TeeOutputStream(pGPDigestCalculator2.getOutputStream(), pGPDigestCalculator.getOutputStream()) : new TeeOutputStream(OutputStreamFactory.createStream(signatureCreateSignature), pGPDigestCalculator.getOutputStream());
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public byte[] getSignature() throws SignatureException {
                    try {
                        if (JcaPGPContentSignerBuilder.this.keyAlgorithm == 22) {
                            signatureCreateSignature.update(pGPDigestCalculator2.getDigest());
                        }
                        return signatureCreateSignature.sign();
                    } catch (SignatureException e) {
                        throw new PGPRuntimeOperationException("Unable to create signature: " + e.getMessage(), e);
                    }
                }

                @Override // org.bouncycastle.openpgp.operator.PGPContentSigner
                public int getType() {
                    return i;
                }
            };
        } catch (InvalidKeyException e) {
            throw new PGPException("invalid key.", e);
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PGPContentSignerBuilder
    public PGPContentSigner build(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        long keyID;
        PrivateKey privateKey;
        if (pGPPrivateKey instanceof JcaPGPPrivateKey) {
            keyID = pGPPrivateKey.getKeyID();
            privateKey = ((JcaPGPPrivateKey) pGPPrivateKey).getPrivateKey();
        } else {
            keyID = pGPPrivateKey.getKeyID();
            privateKey = this.keyConverter.getPrivateKey(pGPPrivateKey);
        }
        return build(i, keyID, privateKey);
    }

    public JcaPGPContentSignerBuilder setDigestProvider(String str) {
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public JcaPGPContentSignerBuilder setDigestProvider(Provider provider) {
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }

    public JcaPGPContentSignerBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        this.keyConverter.setProvider(str);
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public JcaPGPContentSignerBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        this.keyConverter.setProvider(provider);
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }

    public JcaPGPContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
