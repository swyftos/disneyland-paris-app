package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;

/* loaded from: classes6.dex */
public interface PGPContentSignerBuilder {
    PGPContentSigner build(int i, PGPPrivateKey pGPPrivateKey) throws PGPException;
}
