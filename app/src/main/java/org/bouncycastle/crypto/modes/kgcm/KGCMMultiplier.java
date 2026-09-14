package org.bouncycastle.crypto.modes.kgcm;

/* JADX INFO: loaded from: classes6.dex */
public interface KGCMMultiplier {
    void init(long[] jArr);

    void multiplyH(long[] jArr);
}
