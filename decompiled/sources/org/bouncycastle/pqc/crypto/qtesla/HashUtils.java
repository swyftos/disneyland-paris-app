package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* loaded from: classes6.dex */
abstract class HashUtils {
    static void customizableSecureHashAlgorithmKECCAK128Simple(byte[] bArr, int i, int i2, short s, byte[] bArr2, int i3, int i4) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(128, null, new byte[]{(byte) s, (byte) (s >> 8)});
        cSHAKEDigest.update(bArr2, i3, i4);
        cSHAKEDigest.doFinal(bArr, i, i2);
    }

    static void customizableSecureHashAlgorithmKECCAK256Simple(byte[] bArr, int i, int i2, short s, byte[] bArr2, int i3, int i4) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(256, null, new byte[]{(byte) s, (byte) (s >> 8)});
        cSHAKEDigest.update(bArr2, i3, i4);
        cSHAKEDigest.doFinal(bArr, i, i2);
    }

    static void secureHashAlgorithmKECCAK128(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr2, i3, i4);
        sHAKEDigest.doFinal(bArr, i, i2);
    }

    static void secureHashAlgorithmKECCAK256(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(bArr2, i3, i4);
        sHAKEDigest.doFinal(bArr, i, i2);
    }
}
