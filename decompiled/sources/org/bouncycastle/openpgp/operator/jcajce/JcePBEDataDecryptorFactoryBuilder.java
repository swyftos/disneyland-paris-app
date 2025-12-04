package org.bouncycastle.openpgp.operator.jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PBEDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.PGPDataDecryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider;

/* loaded from: classes6.dex */
public class JcePBEDataDecryptorFactoryBuilder {
    private PGPDigestCalculatorProvider calculatorProvider;
    private OperatorHelper helper;

    public JcePBEDataDecryptorFactoryBuilder() {
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.calculatorProvider = null;
    }

    public JcePBEDataDecryptorFactoryBuilder(PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    public PBEDataDecryptorFactory build(char[] cArr) {
        if (this.calculatorProvider == null) {
            try {
                this.calculatorProvider = new JcaPGPDigestCalculatorProviderBuilder(this.helper).build();
            } catch (PGPException e) {
                throw new IllegalStateException("digest calculator provider cannot be built with current helper: " + e.getMessage());
            }
        }
        return new PBEDataDecryptorFactory(cArr, this.calculatorProvider) { // from class: org.bouncycastle.openpgp.operator.jcajce.JcePBEDataDecryptorFactoryBuilder.1
            @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptorFactory
            public PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) {
                return JcePBEDataDecryptorFactoryBuilder.this.helper.createDataDecryptor(z, i, bArr);
            }

            @Override // org.bouncycastle.openpgp.operator.PBEDataDecryptorFactory
            public byte[] recoverSessionData(int i, byte[] bArr, byte[] bArr2) throws InvalidKeyException, PGPException, InvalidAlgorithmParameterException {
                if (bArr2 != null) {
                    try {
                        if (bArr2.length > 0) {
                            String symmetricCipherName = PGPUtil.getSymmetricCipherName(i);
                            Cipher cipherCreateCipher = JcePBEDataDecryptorFactoryBuilder.this.helper.createCipher(symmetricCipherName + "/CFB/NoPadding");
                            cipherCreateCipher.init(2, new SecretKeySpec(bArr, symmetricCipherName), new IvParameterSpec(new byte[cipherCreateCipher.getBlockSize()]));
                            return cipherCreateCipher.doFinal(bArr2);
                        }
                    } catch (Exception e2) {
                        throw new PGPException("Exception recovering session info", e2);
                    }
                }
                byte[] bArr3 = new byte[bArr.length + 1];
                bArr3[0] = (byte) i;
                System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
                return bArr3;
            }
        };
    }

    public JcePBEDataDecryptorFactoryBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcePBEDataDecryptorFactoryBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
