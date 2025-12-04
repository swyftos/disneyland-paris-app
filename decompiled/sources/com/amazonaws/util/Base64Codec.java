package com.amazonaws.util;

import com.google.common.base.Ascii;
import okio.Utf8;

/* loaded from: classes2.dex */
class Base64Codec {
    private final byte[] alpahbets = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    private static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private static byte[] decodeTable() {
            byte[] bArr = new byte[123];
            for (int i = 0; i <= 122; i++) {
                if (i >= 65 && i <= 90) {
                    bArr[i] = (byte) (i - 65);
                } else if (i >= 48 && i <= 57) {
                    bArr[i] = (byte) (i + 4);
                } else if (i == 43) {
                    bArr[i] = (byte) (i + 19);
                } else if (i == 47) {
                    bArr[i] = (byte) (i + 16);
                } else if (i >= 97 && i <= 122) {
                    bArr[i] = (byte) (i - 71);
                } else {
                    bArr[i] = -1;
                }
            }
            return bArr;
        }
    }

    Base64Codec() {
    }

    public byte[] encode(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int i2 = 0;
            while (i < bArr.length) {
                encode3bytes(bArr, i, bArr2, i2);
                i += 3;
                i2 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int i3 = 0;
        while (i < bArr.length - length2) {
            encode3bytes(bArr, i, bArr3, i3);
            i += 3;
            i3 += 4;
        }
        if (length2 == 1) {
            encode1byte(bArr, i, bArr3, i3);
        } else if (length2 == 2) {
            encode2bytes(bArr, i, bArr3, i3);
        }
        return bArr3;
    }

    void encode3bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        int i3 = (b2 & Ascii.SI) << 2;
        byte b3 = bArr[i + 2];
        bArr2[i2 + 2] = bArr3[((b3 >>> 6) & 3) | i3];
        bArr2[i2 + 3] = bArr3[b3 & Utf8.REPLACEMENT_BYTE];
    }

    void encode2bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        int i3 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        byte b2 = bArr[i3];
        bArr2[i2 + 1] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[i2 + 2] = bArr3[(b2 & Ascii.SI) << 2];
        bArr2[i2 + 3] = kotlin.io.encoding.Base64.padSymbol;
    }

    void encode1byte(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        bArr2[i2 + 1] = bArr3[(b & 3) << 4];
        bArr2[i2 + 2] = kotlin.io.encoding.Base64.padSymbol;
        bArr2[i2 + 3] = kotlin.io.encoding.Base64.padSymbol;
    }

    void decode4bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iPos = pos(bArr[i]) << 2;
        int iPos2 = pos(bArr[i + 1]);
        bArr2[i2] = (byte) (iPos | ((iPos2 >>> 4) & 3));
        int iPos3 = pos(bArr[i + 2]);
        bArr2[i2 + 1] = (byte) (((iPos2 & 15) << 4) | ((iPos3 >>> 2) & 15));
        bArr2[i2 + 2] = (byte) (pos(bArr[i + 3]) | ((iPos3 & 3) << 6));
    }

    void decode1to3bytes(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i3 + 1;
        int iPos = pos(bArr[i2]) << 2;
        int i5 = i2 + 2;
        int iPos2 = pos(bArr[i2 + 1]);
        bArr2[i3] = (byte) (iPos | ((iPos2 >>> 4) & 3));
        if (i == 1) {
            CodecUtils.sanityCheckLastPos(iPos2, 15);
            return;
        }
        int i6 = i3 + 2;
        int i7 = i2 + 3;
        int iPos3 = pos(bArr[i5]);
        bArr2[i4] = (byte) (((iPos2 & 15) << 4) | (15 & (iPos3 >>> 2)));
        if (i == 2) {
            CodecUtils.sanityCheckLastPos(iPos3, 3);
        } else {
            bArr2[i6] = (byte) (pos(bArr[i7]) | ((iPos3 & 3) << 6));
        }
    }

    public byte[] decode(byte[] bArr, int i) {
        int i2;
        if (i % 4 != 0) {
            throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + i);
        }
        int i3 = i - 1;
        int i4 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= 2 || i3 <= -1 || bArr[i3] != 61) {
                break;
            }
            i3--;
            i4++;
        }
        if (i4 == 0) {
            i2 = 3;
        } else if (i4 != 1) {
            if (i4 != 2) {
                throw new Error("Impossible");
            }
            i2 = 1;
        }
        int i5 = ((i / 4) * 3) - (3 - i2);
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i7 < i5 - (i2 % 3)) {
            decode4bytes(bArr, i6, bArr2, i7);
            i6 += 4;
            i7 += 3;
        }
        if (i2 < 3) {
            decode1to3bytes(i2, bArr, i6, bArr2, i7);
        }
        return bArr2;
    }

    protected int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b) + "'");
    }
}
