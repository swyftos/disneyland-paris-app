package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

/* loaded from: classes6.dex */
public class EmbeddedSignature extends SignatureSubpacket {
    public EmbeddedSignature(boolean z, boolean z2, byte[] bArr) {
        super(32, z, z2, bArr);
    }
}
