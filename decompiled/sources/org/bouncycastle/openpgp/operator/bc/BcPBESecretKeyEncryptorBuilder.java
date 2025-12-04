package org.bouncycastle.openpgp.operator.bc;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
public class BcPBESecretKeyEncryptorBuilder {
    private int encAlgorithm;
    private SecureRandom random;
    private int s2kCount;
    private PGPDigestCalculator s2kDigestCalculator;

    public BcPBESecretKeyEncryptorBuilder(int i) {
        this(i, new SHA1PGPDigestCalculator());
    }

    public BcPBESecretKeyEncryptorBuilder(int i, int i2) {
        this(i, new SHA1PGPDigestCalculator(), i2);
    }

    public BcPBESecretKeyEncryptorBuilder(int i, PGPDigestCalculator pGPDigestCalculator) {
        this(i, pGPDigestCalculator, 96);
    }

    public BcPBESecretKeyEncryptorBuilder(int i, PGPDigestCalculator pGPDigestCalculator, int i2) {
        this.s2kCount = 96;
        this.encAlgorithm = i;
        this.s2kDigestCalculator = pGPDigestCalculator;
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("s2KCount value outside of range 0 to 255.");
        }
        this.s2kCount = i2;
    }

    public PBESecretKeyEncryptor build(char[] cArr) {
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        return new PBESecretKeyEncryptor(this.encAlgorithm, this.s2kDigestCalculator, this.s2kCount, this.random, cArr) { // from class: org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder.1
            private byte[] iv;

            @Override // org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor
            public byte[] encryptKeyData(byte[] bArr, byte[] bArr2, int i, int i2) {
                return encryptKeyData(bArr, null, bArr2, i, i2);
            }

            @Override // org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor
            public byte[] encryptKeyData(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) throws IllegalStateException, DataLengthException, IllegalArgumentException, PGPException {
                try {
                    BlockCipher blockCipherCreateBlockCipher = BcImplProvider.createBlockCipher(this.encAlgorithm);
                    if (bArr2 != null) {
                        this.iv = bArr2;
                    } else {
                        if (this.random == null) {
                            this.random = new SecureRandom();
                        }
                        bArr2 = new byte[blockCipherCreateBlockCipher.getBlockSize()];
                        this.iv = bArr2;
                        this.random.nextBytes(bArr2);
                    }
                    BufferedBlockCipher bufferedBlockCipherCreateSymmetricKeyWrapper = BcUtil.createSymmetricKeyWrapper(true, blockCipherCreateBlockCipher, bArr, bArr2);
                    byte[] bArr4 = new byte[i2];
                    bufferedBlockCipherCreateSymmetricKeyWrapper.doFinal(bArr4, bufferedBlockCipherCreateSymmetricKeyWrapper.processBytes(bArr3, i, i2, bArr4, 0));
                    return bArr4;
                } catch (InvalidCipherTextException e) {
                    throw new PGPException("decryption failed: " + e.getMessage(), e);
                }
            }

            @Override // org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor
            public byte[] getCipherIV() {
                return this.iv;
            }
        };
    }

    public BcPBESecretKeyEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
