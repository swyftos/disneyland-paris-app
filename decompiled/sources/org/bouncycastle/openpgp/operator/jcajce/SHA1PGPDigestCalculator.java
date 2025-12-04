package org.bouncycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* loaded from: classes6.dex */
class SHA1PGPDigestCalculator implements PGPDigestCalculator {
    private MessageDigest digest;

    SHA1PGPDigestCalculator() {
        try {
            this.digest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("cannot find SHA-1: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
    public int getAlgorithm() {
        return 2;
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
    public byte[] getDigest() {
        return this.digest.digest();
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
    public OutputStream getOutputStream() {
        return OutputStreamFactory.createStream(this.digest);
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDigestCalculator
    public void reset() {
        this.digest.reset();
    }
}
