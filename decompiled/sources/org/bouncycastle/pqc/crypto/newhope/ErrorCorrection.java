package org.bouncycastle.pqc.crypto.newhope;

import com.google.android.material.internal.ViewUtils;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
abstract class ErrorCorrection {
    static short LDDecode(int i, int i2, int i3, int i4) {
        return (short) (((((g(i) + g(i2)) + g(i3)) + g(i4)) - 98312) >>> 31);
    }

    static int abs(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    static int f(int[] iArr, int i, int i2, int i3) {
        int i4 = (i3 * 2730) >> 25;
        int i5 = i4 - ((12288 - (i3 - (i4 * 12289))) >> 31);
        iArr[i] = (i5 >> 1) + (i5 & 1);
        int i6 = i5 - 1;
        iArr[i2] = (i6 >> 1) + (i6 & 1);
        return abs(i3 - (iArr[i] * 24578));
    }

    static int g(int i) {
        int i2 = (i * 2730) >> 27;
        int i3 = i2 - ((49155 - (i - (49156 * i2))) >> 31);
        return abs((((i3 >> 1) + (i3 & 1)) * 98312) - i);
    }

    static void helpRec(short[] sArr, short[] sArr2, byte[] bArr, byte b) {
        short s = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[32];
        ChaCha20.process(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int i = 0;
        while (i < 256) {
            int i2 = ((bArr3[i >>> 3] >>> (i & 7)) & 1) * 4;
            int i3 = i + 256;
            int i4 = i + 512;
            int iF = f(iArr, 0, 4, (sArr2[i] * s) + i2) + f(iArr, 1, 5, (sArr2[i3] * s) + i2) + f(iArr, 2, 6, (sArr2[i4] * s) + i2);
            int i5 = i + ViewUtils.EDGE_TO_EDGE_FLAGS;
            int iF2 = (24577 - (iF + f(iArr, 3, 7, (sArr2[i5] * s) + i2))) >> 31;
            int i6 = ~iF2;
            int[] iArr2 = {(i6 & iArr[0]) ^ (iArr[4] & iF2), (i6 & iArr[1]) ^ (iArr[5] & iF2), (i6 & iArr[2]) ^ (iArr[6] & iF2), (iArr[7] & iF2) ^ (i6 & iArr[3])};
            int i7 = iArr2[0];
            int i8 = iArr2[3];
            sArr[i] = (short) ((i7 - i8) & 3);
            sArr[i3] = (short) ((iArr2[1] - i8) & 3);
            sArr[i4] = (short) ((iArr2[2] - i8) & 3);
            sArr[i5] = (short) (((-iF2) + (i8 * 2)) & 3);
            i++;
            s = 8;
        }
    }

    static void rec(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.fill(bArr, (byte) 0);
        for (int i = 0; i < 256; i++) {
            int i2 = (sArr[i] * 8) + 196624;
            int i3 = sArr2[i] * 2;
            int i4 = i + ViewUtils.EDGE_TO_EDGE_FLAGS;
            short s = sArr2[i4];
            int i5 = i2 - ((i3 + s) * 12289);
            int i6 = i + 256;
            int i7 = ((sArr[i6] * 8) + 196624) - (((sArr2[i6] * 2) + s) * 12289);
            int i8 = i + 512;
            int[] iArr = {i5, i7, ((sArr[i8] * 8) + 196624) - (((sArr2[i8] * 2) + s) * 12289), ((sArr[i4] * 8) + 196624) - (s * 12289)};
            int i9 = i >>> 3;
            bArr[i9] = (byte) ((LDDecode(iArr[0], iArr[1], iArr[2], iArr[3]) << (i & 7)) | bArr[i9]);
        }
    }
}
