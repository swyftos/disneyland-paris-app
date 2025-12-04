package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class RevocationKey extends SignatureSubpacket {
    public RevocationKey(boolean z, byte b, int i, byte[] bArr) {
        super(12, z, false, createData(b, (byte) (i & 255), bArr));
    }

    public RevocationKey(boolean z, boolean z2, byte[] bArr) {
        super(12, z, z2, bArr);
    }

    private static byte[] createData(byte b, byte b2, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = b;
        bArr2[1] = b2;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public int getAlgorithm() {
        return getData()[1];
    }

    public byte[] getFingerprint() {
        byte[] data = getData();
        int length = data.length - 2;
        byte[] bArr = new byte[length];
        System.arraycopy(data, 2, bArr, 0, length);
        return bArr;
    }

    public byte getSignatureClass() {
        return getData()[0];
    }
}
