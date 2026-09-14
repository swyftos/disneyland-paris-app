package org.bouncycastle.openpgp.operator;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public interface PGPDataEncryptor {
    int getBlockSize();

    PGPDigestCalculator getIntegrityCalculator();

    OutputStream getOutputStream(OutputStream outputStream);
}
