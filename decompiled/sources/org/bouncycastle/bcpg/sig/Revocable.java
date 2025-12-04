package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class Revocable extends SignatureSubpacket {
    public Revocable(boolean z, boolean z2) {
        super(7, z, false, booleanToByteArray(z2));
    }

    public Revocable(boolean z, boolean z2, byte[] bArr) {
        super(7, z, z2, bArr);
    }

    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public boolean isRevocable() {
        return this.data[0] != 0;
    }
}
