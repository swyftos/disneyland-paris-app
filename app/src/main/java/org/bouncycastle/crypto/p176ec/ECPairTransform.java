package org.bouncycastle.crypto.p176ec;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes6.dex */
public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    ECPair transform(ECPair eCPair);
}
