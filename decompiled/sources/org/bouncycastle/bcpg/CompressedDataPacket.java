package org.bouncycastle.bcpg;

/* loaded from: classes6.dex */
public class CompressedDataPacket extends InputStreamPacket {
    int algorithm;

    CompressedDataPacket(BCPGInputStream bCPGInputStream) {
        super(bCPGInputStream);
        this.algorithm = bCPGInputStream.read();
    }

    public int getAlgorithm() {
        return this.algorithm;
    }
}
