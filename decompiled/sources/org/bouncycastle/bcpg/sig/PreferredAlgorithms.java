package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class PreferredAlgorithms extends SignatureSubpacket {
    public PreferredAlgorithms(int i, boolean z, boolean z2, byte[] bArr) {
        super(i, z, z2, bArr);
    }

    public PreferredAlgorithms(int i, boolean z, int[] iArr) {
        super(i, z, false, intToByteArray(iArr));
    }

    private static byte[] intToByteArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i != iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public int[] getPreferences() {
        int length = this.data.length;
        int[] iArr = new int[length];
        for (int i = 0; i != length; i++) {
            iArr[i] = this.data[i] & 255;
        }
        return iArr;
    }
}
