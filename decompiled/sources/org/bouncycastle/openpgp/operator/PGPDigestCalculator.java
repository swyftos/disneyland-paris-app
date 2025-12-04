package org.bouncycastle.openpgp.operator;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public interface PGPDigestCalculator {
    int getAlgorithm();

    byte[] getDigest();

    OutputStream getOutputStream();

    void reset();
}
