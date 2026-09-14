package org.bouncycastle.crypto.modes.gcm;

/* JADX INFO: loaded from: classes6.dex */
public interface GCMExponentiator {
    void exponentiateX(long j, byte[] bArr);

    void init(byte[] bArr);
}
