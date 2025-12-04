package org.bouncycastle.openpgp.operator;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public interface PGPContentVerifier {
    int getHashAlgorithm();

    int getKeyAlgorithm();

    long getKeyID();

    OutputStream getOutputStream();

    boolean verify(byte[] bArr);
}
