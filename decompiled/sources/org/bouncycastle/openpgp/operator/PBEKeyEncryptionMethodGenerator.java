package org.bouncycastle.openpgp.operator;

import java.security.SecureRandom;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public abstract class PBEKeyEncryptionMethodGenerator extends PGPKeyEncryptionMethodGenerator {
    private char[] passPhrase;
    private SecureRandom random;
    private S2K s2k;
    private int s2kCount;
    private PGPDigestCalculator s2kDigestCalculator;

    protected PBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator) {
        this(cArr, pGPDigestCalculator, 96);
    }

    protected PBEKeyEncryptionMethodGenerator(char[] cArr, PGPDigestCalculator pGPDigestCalculator, int i) {
        this.passPhrase = cArr;
        this.s2kDigestCalculator = pGPDigestCalculator;
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("s2kCount value outside of range 0 to 255.");
        }
        this.s2kCount = i;
    }

    protected abstract byte[] encryptSessionInfo(int i, byte[] bArr, byte[] bArr2) throws PGPException;

    @Override // org.bouncycastle.openpgp.operator.PGPKeyEncryptionMethodGenerator
    public ContainedPacket generate(int i, byte[] bArr) throws PGPException {
        byte[] key = getKey(i);
        if (bArr == null) {
            return new SymmetricKeyEncSessionPacket(i, this.s2k, null);
        }
        int length = bArr.length - 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return new SymmetricKeyEncSessionPacket(i, this.s2k, encryptSessionInfo(i, key, bArr2));
    }

    public byte[] getKey(int i) throws PGPException {
        if (this.s2k == null) {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            this.s2k = new S2K(this.s2kDigestCalculator.getAlgorithm(), bArr, this.s2kCount);
        }
        return PGPUtil.makeKeyFromPassPhrase(this.s2kDigestCalculator, i, this.s2k, this.passPhrase);
    }

    public PBEKeyEncryptionMethodGenerator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
