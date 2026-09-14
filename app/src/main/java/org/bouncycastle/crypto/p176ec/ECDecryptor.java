package org.bouncycastle.crypto.p176ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public interface ECDecryptor {
    ECPoint decrypt(ECPair eCPair);

    void init(CipherParameters cipherParameters);
}
