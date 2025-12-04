package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.openpgp.PGPException;

/* loaded from: classes6.dex */
public abstract class PGPKeyEncryptionMethodGenerator {
    public abstract ContainedPacket generate(int i, byte[] bArr) throws PGPException;
}
