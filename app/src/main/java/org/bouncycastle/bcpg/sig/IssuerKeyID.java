package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* JADX INFO: loaded from: classes6.dex */
public class IssuerKeyID extends SignatureSubpacket {
    public IssuerKeyID(boolean z, long j) {
        super(16, z, false, keyIDToBytes(j));
    }

    public IssuerKeyID(boolean z, boolean z2, byte[] bArr) {
        super(16, z, z2, bArr);
    }

    protected static byte[] keyIDToBytes(long j) {
        return new byte[]{(byte) (j >> 56), (byte) (j >> 48), (byte) (j >> 40), (byte) (j >> 32), (byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j};
    }

    public long getKeyID() {
        byte[] bArr = this.data;
        return (((long) (bArr[0] & 255)) << 56) | (((long) (bArr[1] & 255)) << 48) | (((long) (bArr[2] & 255)) << 40) | (((long) (bArr[3] & 255)) << 32) | (((long) (bArr[4] & 255)) << 24) | ((long) ((bArr[5] & 255) << 16)) | ((long) ((bArr[6] & 255) << 8)) | ((long) (bArr[7] & 255));
    }
}
