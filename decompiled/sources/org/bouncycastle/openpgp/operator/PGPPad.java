package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public class PGPPad {
    public static byte[] padSessionData(byte[] bArr) {
        return padSessionData(bArr, true);
    }

    public static byte[] padSessionData(byte[] bArr, boolean z) {
        int length = bArr.length;
        int iMax = ((length >>> 3) + 1) << 3;
        if (z) {
            iMax = Math.max(40, iMax);
        }
        byte b = (byte) (iMax - length);
        byte[] bArr2 = new byte[iMax];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        while (length < iMax) {
            bArr2[length] = b;
            length++;
        }
        return bArr2;
    }

    public static byte[] unpadSessionData(byte[] bArr) throws PGPException {
        int length = bArr.length;
        int i = bArr[length - 1];
        int i2 = length - (i & 255);
        int i3 = i2 - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            i4 |= ((i3 - i5) >> 31) & (bArr[i5] ^ i);
        }
        if ((((40 - length) >> 31) | (length & 7) | i4) != 0) {
            throw new PGPException("bad padding found in session data");
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }
}
