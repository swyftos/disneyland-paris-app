package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class Features extends SignatureSubpacket {
    public static final byte FEATURE_MODIFICATION_DETECTION = 1;

    public Features(boolean z, byte b) {
        super(30, z, false, featureToByteArray(b));
    }

    public Features(boolean z, boolean z2, byte[] bArr) {
        super(30, z, z2, bArr);
    }

    private static final byte[] featureToByteArray(byte b) {
        return new byte[]{b};
    }

    public boolean supportsFeature(byte b) {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return false;
            }
            if (bArr[i] == b) {
                return true;
            }
            i++;
        }
    }

    public boolean supportsModificationDetection() {
        return supportsFeature((byte) 1);
    }
}
