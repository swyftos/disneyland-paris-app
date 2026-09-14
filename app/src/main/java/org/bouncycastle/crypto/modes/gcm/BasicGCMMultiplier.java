package org.bouncycastle.crypto.modes.gcm;

/* JADX INFO: loaded from: classes6.dex */
public class BasicGCMMultiplier implements GCMMultiplier {

    /* JADX INFO: renamed from: H */
    private long[] f4513H;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        this.f4513H = GCMUtil.asLongs(bArr);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[] jArrAsLongs = GCMUtil.asLongs(bArr);
        GCMUtil.multiply(jArrAsLongs, this.f4513H);
        GCMUtil.asBytes(jArrAsLongs, bArr);
    }
}
