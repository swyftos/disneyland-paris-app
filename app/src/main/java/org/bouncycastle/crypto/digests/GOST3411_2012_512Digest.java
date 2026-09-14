package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes6.dex */
public class GOST3411_2012_512Digest extends GOST3411_2012Digest {

    /* JADX INFO: renamed from: IV */
    private static final byte[] f4199IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GOST3411_2012_512Digest() {
        super(f4199IV);
    }

    public GOST3411_2012_512Digest(GOST3411_2012_512Digest gOST3411_2012_512Digest) {
        super(f4199IV);
        reset(gOST3411_2012_512Digest);
    }

    @Override // org.bouncycastle.crypto.digests.GOST3411_2012Digest, org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new GOST3411_2012_512Digest(this);
    }

    @Override // org.bouncycastle.crypto.digests.GOST3411_2012Digest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "GOST3411-2012-512";
    }

    @Override // org.bouncycastle.crypto.digests.GOST3411_2012Digest, org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }
}
