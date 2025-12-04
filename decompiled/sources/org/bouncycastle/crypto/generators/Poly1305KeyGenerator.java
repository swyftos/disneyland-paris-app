package org.bouncycastle.crypto.generators;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* loaded from: classes6.dex */
public class Poly1305KeyGenerator extends CipherKeyGenerator {
    public static void checkKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        checkMask(bArr[3], Ascii.SI);
        checkMask(bArr[7], Ascii.SI);
        checkMask(bArr[11], Ascii.SI);
        checkMask(bArr[15], Ascii.SI);
        checkMask(bArr[4], (byte) -4);
        checkMask(bArr[8], (byte) -4);
        checkMask(bArr[12], (byte) -4);
    }

    private static void checkMask(byte b, byte b2) {
        if ((b & (~b2)) != 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }

    public static void clamp(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        bArr[3] = (byte) (bArr[3] & Ascii.SI);
        bArr[7] = (byte) (bArr[7] & Ascii.SI);
        bArr[11] = (byte) (bArr[11] & Ascii.SI);
        bArr[15] = (byte) (bArr[15] & Ascii.SI);
        bArr[4] = (byte) (bArr[4] & (-4));
        bArr[8] = (byte) (bArr[8] & (-4));
        bArr[12] = (byte) (bArr[12] & (-4));
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] bArrGenerateKey = super.generateKey();
        clamp(bArrGenerateKey);
        return bArrGenerateKey;
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        super.init(new KeyGenerationParameters(keyGenerationParameters.getRandom(), 256));
    }
}
