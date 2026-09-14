package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public interface DSA {
    BigInteger[] generateSignature(byte[] bArr);

    void init(boolean z, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2);
}
