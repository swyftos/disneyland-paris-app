package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes6.dex */
class SeedDerive {

    /* JADX INFO: renamed from: I */
    private final byte[] f4858I;
    private final Digest digest;

    /* JADX INFO: renamed from: j */
    private int f4859j;
    private final byte[] masterSeed;

    /* JADX INFO: renamed from: q */
    private int f4860q;

    public SeedDerive(byte[] bArr, byte[] bArr2, Digest digest) {
        this.f4858I = bArr;
        this.masterSeed = bArr2;
        this.digest = digest;
    }

    public void deriveSeed(byte[] bArr, boolean z) {
        deriveSeed(bArr, z, 0);
    }

    public void deriveSeed(byte[] bArr, boolean z, int i) {
        deriveSeed(bArr, i);
        if (z) {
            this.f4859j++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i) {
        if (bArr.length < this.digest.getDigestSize()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        Digest digest = this.digest;
        byte[] bArr2 = this.f4858I;
        digest.update(bArr2, 0, bArr2.length);
        this.digest.update((byte) (this.f4860q >>> 24));
        this.digest.update((byte) (this.f4860q >>> 16));
        this.digest.update((byte) (this.f4860q >>> 8));
        this.digest.update((byte) this.f4860q);
        this.digest.update((byte) (this.f4859j >>> 8));
        this.digest.update((byte) this.f4859j);
        this.digest.update((byte) -1);
        Digest digest2 = this.digest;
        byte[] bArr3 = this.masterSeed;
        digest2.update(bArr3, 0, bArr3.length);
        this.digest.doFinal(bArr, i);
        return bArr;
    }

    public void setJ(int i) {
        this.f4859j = i;
    }

    public void setQ(int i) {
        this.f4860q = i;
    }
}
