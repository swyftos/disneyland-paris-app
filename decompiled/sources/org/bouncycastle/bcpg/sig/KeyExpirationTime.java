package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class KeyExpirationTime extends SignatureSubpacket {
    public KeyExpirationTime(boolean z, long j) {
        super(9, z, false, timeToBytes(j));
    }

    public KeyExpirationTime(boolean z, boolean z2, byte[] bArr) {
        super(9, z, z2, bArr);
    }

    protected static byte[] timeToBytes(long j) {
        return new byte[]{(byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j};
    }

    public long getTime() {
        byte[] bArr = this.data;
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }
}
