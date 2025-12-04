package org.bouncycastle.openpgp.operator.bc;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
public class BcPBEKeyEncryptionMethodGenerator extends PBEKeyEncryptionMethodGenerator {
    public BcPBEKeyEncryptionMethodGenerator(char[] cArr) {
        this(cArr, new SHA1PGPDigestCalculator());
    }

    public BcPBEKeyEncryptionMethodGenerator(char[] cArr, int i) {
        super(cArr, new SHA1PGPDigestCalculator(), i);
    }

    public BcPBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator) {
        super(cArr, pGPDigestCalculator);
    }

    public BcPBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator, int i) {
        super(cArr, pGPDigestCalculator, i);
    }

    @Override // org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator
    protected byte[] encryptSessionInfo(int i, byte[] bArr, byte[] bArr2) throws IllegalStateException, DataLengthException, IllegalArgumentException, PGPException {
        try {
            BlockCipher blockCipherCreateBlockCipher = BcImplProvider.createBlockCipher(i);
            BufferedBlockCipher bufferedBlockCipherCreateSymmetricKeyWrapper = BcUtil.createSymmetricKeyWrapper(true, blockCipherCreateBlockCipher, bArr, new byte[blockCipherCreateBlockCipher.getBlockSize()]);
            byte[] bArr3 = new byte[bArr2.length];
            bufferedBlockCipherCreateSymmetricKeyWrapper.doFinal(bArr3, bufferedBlockCipherCreateSymmetricKeyWrapper.processBytes(bArr2, 0, bArr2.length, bArr3, 0));
            return bArr3;
        } catch (InvalidCipherTextException e) {
            throw new PGPException("encryption failed: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PBEKeyEncryptionMethodGenerator
    public PBEKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        super.setSecureRandom(secureRandom);
        return this;
    }
}
