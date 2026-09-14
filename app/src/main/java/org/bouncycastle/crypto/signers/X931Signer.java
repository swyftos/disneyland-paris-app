package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes6.dex */
public class X931Signer implements Signer {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private RSAKeyParameters kParam;
    private int keyBits;
    private int trailer;

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        int iIntValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest;
        if (z) {
            iIntValue = 188;
        } else {
            Integer trailer = ISOTrailers.getTrailer(digest);
            if (trailer == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + digest.getAlgorithmName());
            }
            iIntValue = trailer.intValue();
        }
        this.trailer = iIntValue;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private void createSignatureBlock(int i) {
        int length;
        int digestSize = this.digest.getDigestSize();
        if (i == 188) {
            byte[] bArr = this.block;
            length = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, length);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr3 = this.block;
            int length2 = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length2);
            byte[] bArr4 = this.block;
            bArr4[bArr4.length - 2] = (byte) (i >>> 8);
            bArr4[bArr4.length - 1] = (byte) i;
            length = length2;
        }
        this.block[0] = 107;
        for (int i2 = length - 2; i2 != 0; i2--) {
            this.block[i2] = -69;
        }
        this.block[length - 1] = -70;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        createSignatureBlock(this.trailer);
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr = this.block;
        BigInteger bigInteger = new BigInteger(1, asymmetricBlockCipher.processBlock(bArr, 0, bArr.length));
        clearBlock(this.block);
        return BigIntegers.asUnsignedByteArray(BigIntegers.getUnsignedByteLength(this.kParam.getModulus()), bigInteger.min(this.kParam.getModulus().subtract(bigInteger)));
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.kParam = rSAKeyParameters;
        this.cipher.init(z, rSAKeyParameters);
        int iBitLength = this.kParam.getModulus().bitLength();
        this.keyBits = iBitLength;
        this.block = new byte[(iBitLength + 7) / 8];
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002f A[PHI: r4
  0x002f: PHI (r4v3 java.math.BigInteger) = (r4v2 java.math.BigInteger), (r4v5 java.math.BigInteger) binds: [B:5:0x001a, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrAsUnsignedByteArray;
        boolean zConstantTimeAreEqual = false;
        try {
            this.block = this.cipher.processBlock(bArr, 0, bArr.length);
            BigInteger bigInteger = new BigInteger(1, this.block);
            if ((bigInteger.intValue() & 15) == 12) {
                createSignatureBlock(this.trailer);
                bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.block.length, bigInteger);
                zConstantTimeAreEqual = Arrays.constantTimeAreEqual(this.block, bArrAsUnsignedByteArray);
                if (this.trailer == 15052 && !zConstantTimeAreEqual) {
                    byte[] bArr2 = this.block;
                    bArr2[bArr2.length - 2] = 64;
                    zConstantTimeAreEqual = Arrays.constantTimeAreEqual(bArr2, bArrAsUnsignedByteArray);
                }
                clearBlock(this.block);
                clearBlock(bArrAsUnsignedByteArray);
            } else {
                bigInteger = this.kParam.getModulus().subtract(bigInteger);
                if ((bigInteger.intValue() & 15) == 12) {
                    createSignatureBlock(this.trailer);
                    bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.block.length, bigInteger);
                    zConstantTimeAreEqual = Arrays.constantTimeAreEqual(this.block, bArrAsUnsignedByteArray);
                    if (this.trailer == 15052) {
                        byte[] bArr3 = this.block;
                        bArr3[bArr3.length - 2] = 64;
                        zConstantTimeAreEqual = Arrays.constantTimeAreEqual(bArr3, bArrAsUnsignedByteArray);
                    }
                    clearBlock(this.block);
                    clearBlock(bArrAsUnsignedByteArray);
                }
            }
        } catch (Exception unused) {
        }
        return zConstantTimeAreEqual;
    }
}
