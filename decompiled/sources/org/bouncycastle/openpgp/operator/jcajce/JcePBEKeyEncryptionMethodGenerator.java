package org.bouncycastle.openpgp.operator.jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
public class JcePBEKeyEncryptionMethodGenerator extends PBEKeyEncryptionMethodGenerator {
    private OperatorHelper helper;

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr) {
        this(cArr, new SHA1PGPDigestCalculator());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, int i) {
        super(cArr, new SHA1PGPDigestCalculator(), i);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator) {
        super(cArr, pGPDigestCalculator);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    public JcePBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator, int i) {
        super(cArr, pGPDigestCalculator, i);
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
    }

    @Override // org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator
    protected byte[] encryptSessionInfo(int i, byte[] bArr, byte[] bArr2) throws InvalidKeyException, PGPException, InvalidAlgorithmParameterException {
        try {
            String symmetricCipherName = PGPUtil.getSymmetricCipherName(i);
            Cipher cipherCreateCipher = this.helper.createCipher(symmetricCipherName + "/CFB/NoPadding");
            cipherCreateCipher.init(1, new SecretKeySpec(bArr, PGPUtil.getSymmetricCipherName(i)), new IvParameterSpec(new byte[cipherCreateCipher.getBlockSize()]));
            return cipherCreateCipher.doFinal(bArr2, 0, bArr2.length);
        } catch (InvalidAlgorithmParameterException e) {
            throw new PGPException("IV invalid: " + e.getMessage(), e);
        } catch (InvalidKeyException e2) {
            throw new PGPException("key invalid: " + e2.getMessage(), e2);
        } catch (BadPaddingException e3) {
            throw new PGPException("bad padding: " + e3.getMessage(), e3);
        } catch (IllegalBlockSizeException e4) {
            throw new PGPException("illegal block size: " + e4.getMessage(), e4);
        }
    }

    public JcePBEKeyEncryptionMethodGenerator setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcePBEKeyEncryptionMethodGenerator setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    @Override // org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator
    public PBEKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        super.setSecureRandom(secureRandom);
        return this;
    }
}
