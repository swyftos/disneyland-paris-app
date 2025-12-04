package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Pack;

/* loaded from: classes6.dex */
class Permute {
    Permute() {
    }

    public static void permute(int i, int[] iArr) {
        int i2 = 16;
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        char c = 0;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = 7;
        int i11 = iArr[7];
        int i12 = 8;
        int i13 = iArr[8];
        int i14 = iArr[9];
        int i15 = iArr[10];
        int i16 = iArr[11];
        int i17 = iArr[12];
        int i18 = iArr[13];
        int i19 = iArr[14];
        int iRotl = iArr[15];
        int iRotl2 = i19;
        int iRotl3 = i18;
        int iRotl4 = i17;
        int i20 = i16;
        int i21 = i15;
        int i22 = i14;
        int i23 = i13;
        int iRotl5 = i11;
        int iRotl6 = i9;
        int iRotl7 = i8;
        int iRotl8 = i7;
        int i24 = i6;
        int i25 = i5;
        int i26 = i4;
        int i27 = i3;
        int i28 = i;
        while (i28 > 0) {
            int i29 = i27 + iRotl8;
            int iRotl9 = rotl(iRotl4 ^ i29, i2);
            int i30 = i23 + iRotl9;
            int iRotl10 = rotl(iRotl8 ^ i30, 12);
            int i31 = i29 + iRotl10;
            int iRotl11 = rotl(iRotl9 ^ i31, i12);
            int i32 = i30 + iRotl11;
            int iRotl12 = rotl(iRotl10 ^ i32, i10);
            int i33 = i26 + iRotl7;
            int iRotl13 = rotl(iRotl3 ^ i33, i2);
            int i34 = i22 + iRotl13;
            int iRotl14 = rotl(iRotl7 ^ i34, 12);
            int i35 = i33 + iRotl14;
            int iRotl15 = rotl(iRotl13 ^ i35, i12);
            int i36 = i34 + iRotl15;
            int iRotl16 = rotl(iRotl14 ^ i36, i10);
            int i37 = i25 + iRotl6;
            int iRotl17 = rotl(iRotl2 ^ i37, i2);
            int i38 = i21 + iRotl17;
            int iRotl18 = rotl(iRotl6 ^ i38, 12);
            int i39 = i37 + iRotl18;
            int iRotl19 = rotl(iRotl17 ^ i39, i12);
            int i40 = i38 + iRotl19;
            int iRotl20 = rotl(iRotl18 ^ i40, i10);
            int i41 = i24 + iRotl5;
            int iRotl21 = rotl(iRotl ^ i41, i2);
            int i42 = i20 + iRotl21;
            int iRotl22 = rotl(iRotl5 ^ i42, 12);
            int i43 = i41 + iRotl22;
            int iRotl23 = rotl(iRotl21 ^ i43, i12);
            int i44 = i42 + iRotl23;
            int iRotl24 = rotl(iRotl22 ^ i44, 7);
            int i45 = i31 + iRotl16;
            int iRotl25 = rotl(iRotl23 ^ i45, 16);
            int i46 = i40 + iRotl25;
            int iRotl26 = rotl(iRotl16 ^ i46, 12);
            i27 = i45 + iRotl26;
            iRotl = rotl(iRotl25 ^ i27, 8);
            i21 = i46 + iRotl;
            iRotl7 = rotl(iRotl26 ^ i21, 7);
            int i47 = i35 + iRotl20;
            int iRotl27 = rotl(iRotl11 ^ i47, 16);
            int i48 = i44 + iRotl27;
            int iRotl28 = rotl(iRotl20 ^ i48, 12);
            i26 = i47 + iRotl28;
            iRotl4 = rotl(iRotl27 ^ i26, 8);
            i20 = i48 + iRotl4;
            iRotl6 = rotl(iRotl28 ^ i20, 7);
            int i49 = i39 + iRotl24;
            int iRotl29 = rotl(iRotl15 ^ i49, 16);
            int i50 = i32 + iRotl29;
            int iRotl30 = rotl(iRotl24 ^ i50, 12);
            i25 = i49 + iRotl30;
            iRotl3 = rotl(iRotl29 ^ i25, 8);
            i23 = i50 + iRotl3;
            iRotl5 = rotl(iRotl30 ^ i23, 7);
            int i51 = i43 + iRotl12;
            i2 = 16;
            int iRotl31 = rotl(iRotl19 ^ i51, 16);
            int i52 = i36 + iRotl31;
            int iRotl32 = rotl(iRotl12 ^ i52, 12);
            i24 = i51 + iRotl32;
            iRotl2 = rotl(iRotl31 ^ i24, 8);
            i22 = i52 + iRotl2;
            iRotl8 = rotl(iRotl32 ^ i22, 7);
            i28 -= 2;
            i10 = 7;
            c = 0;
            i12 = 8;
        }
        iArr[c] = i27;
        iArr[1] = i26;
        iArr[2] = i25;
        iArr[3] = i24;
        iArr[4] = iRotl8;
        iArr[5] = iRotl7;
        iArr[6] = iRotl6;
        iArr[i10] = iRotl5;
        iArr[8] = i23;
        iArr[9] = i22;
        iArr[10] = i21;
        iArr[11] = i20;
        iArr[12] = iRotl4;
        iArr[13] = iRotl3;
        iArr[14] = iRotl2;
        iArr[15] = iRotl;
    }

    protected static int rotl(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    void chacha_permute(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[16];
        for (int i = 0; i < 16; i++) {
            iArr[i] = Pack.littleEndianToInt(bArr2, i * 4);
        }
        permute(12, iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            Pack.intToLittleEndian(iArr[i2], bArr, i2 * 4);
        }
    }
}
