package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes6.dex */
public interface KeyFingerPrintCalculator {
    byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException;
}
