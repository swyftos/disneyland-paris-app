package org.bouncycastle.openpgp.operator;

import java.security.SecureRandom;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public abstract class PBESecretKeyEncryptor {
    protected int encAlgorithm;
    protected char[] passPhrase;
    protected SecureRandom random;
    protected S2K s2k;
    protected int s2kCount;
    protected PGPDigestCalculator s2kDigestCalculator;

    protected PBESecretKeyEncryptor(int i, PGPDigestCalculator pGPDigestCalculator, int i2, SecureRandom secureRandom, char[] cArr) {
        this.encAlgorithm = i;
        this.passPhrase = cArr;
        this.random = secureRandom;
        this.s2kDigestCalculator = pGPDigestCalculator;
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("s2kCount value outside of range 0 to 255.");
        }
        this.s2kCount = i2;
    }

    protected PBESecretKeyEncryptor(int i, PGPDigestCalculator pGPDigestCalculator, SecureRandom secureRandom, char[] cArr) {
        this(i, pGPDigestCalculator, 96, secureRandom, cArr);
    }

    public byte[] encryptKeyData(byte[] bArr, int i, int i2) throws PGPException {
        if (this.s2k == null) {
            byte[] bArr2 = new byte[8];
            this.random.nextBytes(bArr2);
            this.s2k = new S2K(this.s2kDigestCalculator.getAlgorithm(), bArr2, this.s2kCount);
        }
        return encryptKeyData(getKey(), bArr, i, i2);
    }

    public abstract byte[] encryptKeyData(byte[] bArr, byte[] bArr2, int i, int i2) throws PGPException;

    public byte[] encryptKeyData(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) throws PGPException {
        throw new PGPException("encryption of version 3 keys not supported.");
    }

    public int getAlgorithm() {
        return this.encAlgorithm;
    }

    public abstract byte[] getCipherIV();

    public int getHashAlgorithm() {
        PGPDigestCalculator pGPDigestCalculator = this.s2kDigestCalculator;
        if (pGPDigestCalculator != null) {
            return pGPDigestCalculator.getAlgorithm();
        }
        return -1;
    }

    public byte[] getKey() throws PGPException {
        return PGPUtil.makeKeyFromPassPhrase(this.s2kDigestCalculator, this.encAlgorithm, this.s2k, this.passPhrase);
    }

    public S2K getS2K() {
        return this.s2k;
    }
}
