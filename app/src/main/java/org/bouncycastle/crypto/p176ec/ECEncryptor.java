package org.bouncycastle.crypto.p176ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.p183ec.ECPoint;

/* JADX INFO: loaded from: classes6.dex */
public interface ECEncryptor {
    ECPair encrypt(ECPoint eCPoint);

    void init(CipherParameters cipherParameters);
}
