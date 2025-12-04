package org.bouncycastle.bcpg;

import java.io.IOException;

/* loaded from: classes6.dex */
public abstract class OutputStreamPacket {
    protected BCPGOutputStream out;

    public OutputStreamPacket(BCPGOutputStream bCPGOutputStream) {
        this.out = bCPGOutputStream;
    }

    public abstract void close() throws IOException;

    public abstract BCPGOutputStream open() throws IOException;
}
