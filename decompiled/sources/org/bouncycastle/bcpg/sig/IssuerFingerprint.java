package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class IssuerFingerprint extends SignatureSubpacket {
    public IssuerFingerprint(boolean z, int i, byte[] bArr) {
        super(33, z, false, Arrays.concatenate(new byte[]{(byte) i}, bArr));
    }

    public IssuerFingerprint(boolean z, boolean z2, byte[] bArr) {
        super(33, z, z2, bArr);
    }

    public byte[] getFingerprint() {
        byte[] bArr = this.data;
        return Arrays.copyOfRange(bArr, 1, bArr.length);
    }

    public int getKeyVersion() {
        return this.data[0] & 255;
    }
}
