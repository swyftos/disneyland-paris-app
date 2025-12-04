package org.bouncycastle.bcpg;

/* loaded from: classes6.dex */
public class SymmetricEncIntegrityPacket extends InputStreamPacket {
    int version;

    SymmetricEncIntegrityPacket(BCPGInputStream bCPGInputStream) {
        super(bCPGInputStream);
        this.version = bCPGInputStream.read();
    }
}
