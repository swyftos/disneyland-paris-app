package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public abstract class PBEDataDecryptorFactory implements PGPDataDecryptorFactory {
    private PGPDigestCalculatorProvider calculatorProvider;
    private char[] passPhrase;

    protected PBEDataDecryptorFactory(char[] cArr, PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.passPhrase = cArr;
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    public byte[] makeKeyFromPassPhrase(int i, S2K s2k) throws PGPException {
        return PGPUtil.makeKeyFromPassPhrase(this.calculatorProvider, i, s2k, this.passPhrase);
    }

    public abstract byte[] recoverSessionData(int i, byte[] bArr, byte[] bArr2) throws PGPException;
}
