package org.bouncycastle.bcpg.sig;

import java.util.Date;
import org.bouncycastle.bcpg.SignatureSubpacket;

/* JADX INFO: loaded from: classes6.dex */
public class SignatureCreationTime extends SignatureSubpacket {
    public SignatureCreationTime(boolean z, Date date) {
        super(2, z, false, timeToBytes(date));
    }

    public SignatureCreationTime(boolean z, boolean z2, byte[] bArr) {
        super(2, z, z2, bArr);
    }

    protected static byte[] timeToBytes(Date date) {
        long time = date.getTime() / 1000;
        return new byte[]{(byte) (time >> 24), (byte) (time >> 16), (byte) (time >> 8), (byte) time};
    }

    public Date getTime() {
        byte[] bArr = this.data;
        return new Date(((((long) (bArr[0] & 255)) << 24) | ((long) ((bArr[1] & 255) << 16)) | ((long) ((bArr[2] & 255) << 8)) | ((long) (bArr[3] & 255))) * 1000);
    }
}
