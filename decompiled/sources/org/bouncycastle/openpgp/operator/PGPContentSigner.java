package org.bouncycastle.openpgp.operator;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public interface PGPContentSigner {
    byte[] getDigest();

    int getHashAlgorithm();

    int getKeyAlgorithm();

    long getKeyID();

    OutputStream getOutputStream();

    byte[] getSignature();

    int getType();
}
