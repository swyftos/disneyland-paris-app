package org.bouncycastle.crypto.modes.gcm;

/* loaded from: classes6.dex */
public class BasicGCMMultiplier implements GCMMultiplier {
    private long[] H;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        this.H = GCMUtil.asLongs(bArr);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[] jArrAsLongs = GCMUtil.asLongs(bArr);
        GCMUtil.multiply(jArrAsLongs, this.H);
        GCMUtil.asBytes(jArrAsLongs, bArr);
    }
}
