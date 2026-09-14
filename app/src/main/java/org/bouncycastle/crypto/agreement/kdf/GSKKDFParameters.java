package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes6.dex */
public class GSKKDFParameters implements DerivationParameters {
    private final byte[] nonce;
    private final int startCounter;

    /* JADX INFO: renamed from: z */
    private final byte[] f4143z;

    public GSKKDFParameters(byte[] bArr, int i) {
        this(bArr, i, null);
    }

    public GSKKDFParameters(byte[] bArr, int i, byte[] bArr2) {
        this.f4143z = bArr;
        this.startCounter = i;
        this.nonce = bArr2;
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public byte[] getZ() {
        return this.f4143z;
    }
}
