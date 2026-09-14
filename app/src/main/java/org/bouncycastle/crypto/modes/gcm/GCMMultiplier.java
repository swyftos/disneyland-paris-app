package org.bouncycastle.crypto.modes.gcm;

/* JADX INFO: loaded from: classes6.dex */
public interface GCMMultiplier {
    void init(byte[] bArr);

    void multiplyH(byte[] bArr);
}
