package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public abstract class PBESecretKeyDecryptor {
    private PGPDigestCalculatorProvider calculatorProvider;
    private char[] passPhrase;

    protected PBESecretKeyDecryptor(char[] cArr, PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.passPhrase = cArr;
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    public PGPDigestCalculator getChecksumCalculator(int i) throws PGPException {
        return this.calculatorProvider.get(i);
    }

    public byte[] makeKeyFromPassPhrase(int i, S2K s2k) throws PGPException {
        return PGPUtil.makeKeyFromPassPhrase(this.calculatorProvider, i, s2k, this.passPhrase);
    }

    public abstract byte[] recoverKeyData(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3) throws PGPException;
}
