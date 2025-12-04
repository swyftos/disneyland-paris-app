package org.bouncycastle.bcpg;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class ExperimentalPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private byte[] contents;
    private int tag;

    ExperimentalPacket(int i, BCPGInputStream bCPGInputStream) {
        this.tag = i;
        this.contents = bCPGInputStream.readAll();
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(this.tag, this.contents, true);
    }

    public byte[] getContents() {
        return Arrays.clone(this.contents);
    }

    public int getTag() {
        return this.tag;
    }
}
