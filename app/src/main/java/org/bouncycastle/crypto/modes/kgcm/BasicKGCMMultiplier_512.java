package org.bouncycastle.crypto.modes.kgcm;

/* JADX INFO: loaded from: classes6.dex */
public class BasicKGCMMultiplier_512 implements KGCMMultiplier {

    /* JADX INFO: renamed from: H */
    private final long[] f4522H = new long[8];

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void init(long[] jArr) {
        KGCMUtil_512.copy(jArr, this.f4522H);
    }

    @Override // org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier
    public void multiplyH(long[] jArr) {
        KGCMUtil_512.multiply(jArr, this.f4522H, jArr);
    }
}
