package org.bouncycastle.openpgp.operator.bc;

import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

/* loaded from: classes6.dex */
class SignerOutputStream extends OutputStream {
    private Signer sig;

    SignerOutputStream(Signer signer) {
        this.sig = signer;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.sig.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.sig.update(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.sig.update(bArr, i, i2);
    }
}
