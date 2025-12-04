package org.bouncycastle.crypto;

import java.math.BigInteger;

/* loaded from: classes6.dex */
public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters cipherParameters);

    int getFieldSize();

    void init(CipherParameters cipherParameters);
}
