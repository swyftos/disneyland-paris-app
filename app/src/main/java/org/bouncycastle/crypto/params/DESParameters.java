package org.bouncycastle.crypto.params;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes6.dex */
public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = {1, 1, 1, 1, 1, 1, 1, 1, Ascii.f3534US, Ascii.f3534US, Ascii.f3534US, Ascii.f3534US, Ascii.f3532SO, Ascii.f3532SO, Ascii.f3532SO, Ascii.f3532SO, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, Ascii.f3534US, -32, Ascii.f3534US, -32, Ascii.f3532SO, -15, Ascii.f3532SO, -15, 1, -32, 1, -32, 1, -15, 1, -15, Ascii.f3534US, -2, Ascii.f3534US, -2, Ascii.f3532SO, -2, Ascii.f3532SO, -2, 1, Ascii.f3534US, 1, Ascii.f3534US, 1, Ascii.f3532SO, 1, Ascii.f3532SO, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, Ascii.f3534US, -32, Ascii.f3534US, -15, Ascii.f3532SO, -15, Ascii.f3532SO, -32, 1, -32, 1, -15, 1, -15, 1, -2, Ascii.f3534US, -2, Ascii.f3534US, -2, Ascii.f3532SO, -2, Ascii.f3532SO, Ascii.f3534US, 1, Ascii.f3534US, 1, Ascii.f3532SO, 1, Ascii.f3532SO, 1, -2, -32, -2, -32, -2, -15, -2, -15};

    public DESParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    public static boolean isWeakKey(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            throw new IllegalArgumentException("key material too short.");
        }
        for (int i2 = 0; i2 < 16; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                if (bArr[i3 + i] != DES_weak_keys[(i2 * 8) + i3]) {
                }
            }
            return true;
        }
        return false;
    }

    public static void setOddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
