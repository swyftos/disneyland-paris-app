package org.bouncycastle.bcpg.sig;

import java.util.Date;
import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class SignatureCreationTime extends SignatureSubpacket {
    public SignatureCreationTime(boolean z, Date date) {
        super(2, z, false, timeToBytes(date));
    }

    public SignatureCreationTime(boolean z, boolean z2, byte[] bArr) {
        super(2, z, z2, bArr);
    }

    protected static byte[] timeToBytes(Date date) {
        return new byte[]{(byte) (r0 >> 24), (byte) (r0 >> 16), (byte) (r0 >> 8), (byte) (date.getTime() / 1000)};
    }

    public Date getTime() {
        byte[] bArr = this.data;
        return new Date((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) * 1000);
    }
}
