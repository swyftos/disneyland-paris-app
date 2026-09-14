package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes6.dex */
public class ParametersWithID implements CipherParameters {

    /* JADX INFO: renamed from: id */
    private byte[] f4582id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f4582id = bArr;
    }

    public byte[] getID() {
        return this.f4582id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
