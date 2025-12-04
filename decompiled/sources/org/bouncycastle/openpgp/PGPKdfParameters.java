package org.bouncycastle.openpgp;

/* loaded from: classes6.dex */
public class PGPKdfParameters implements PGPAlgorithmParameters {
    private final int hashAlgorithm;
    private final int symmetricWrapAlgorithm;

    public PGPKdfParameters(int i, int i2) {
        this.hashAlgorithm = i;
        this.symmetricWrapAlgorithm = i2;
    }

    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public int getSymmetricWrapAlgorithm() {
        return this.symmetricWrapAlgorithm;
    }
}
