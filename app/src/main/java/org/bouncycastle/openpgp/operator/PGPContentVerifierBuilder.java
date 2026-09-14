package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;

/* JADX INFO: loaded from: classes6.dex */
public interface PGPContentVerifierBuilder {
    PGPContentVerifier build(PGPPublicKey pGPPublicKey) throws PGPException;
}
