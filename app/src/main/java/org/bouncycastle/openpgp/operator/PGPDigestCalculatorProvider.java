package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes6.dex */
public interface PGPDigestCalculatorProvider {
    PGPDigestCalculator get(int i) throws PGPException;
}
