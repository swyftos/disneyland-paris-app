package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes6.dex */
public class KDFParameters implements DerivationParameters {

    /* JADX INFO: renamed from: iv */
    byte[] f4579iv;
    byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f4579iv = bArr2;
    }

    public byte[] getIV() {
        return this.f4579iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}
