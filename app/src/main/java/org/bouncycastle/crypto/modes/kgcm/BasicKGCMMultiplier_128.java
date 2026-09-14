package org.bouncycastle.crypto.modes.kgcm;

/* JADX INFO: loaded from: classes6.dex */
public class BasicKGCMMultiplier_128 implements KGCMMultiplier {

    /* JADX INFO: renamed from: H */
    private final long[] f4520H = new long[2];

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void init(long[] jArr) {
        KGCMUtil_128.copy(jArr, this.f4520H);
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        KGCMUtil_128.multiply(jArr, this.f4520H, jArr);
    }
}
