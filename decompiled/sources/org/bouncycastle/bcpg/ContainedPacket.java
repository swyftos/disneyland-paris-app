package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Encodable;

/* loaded from: classes6.dex */
public abstract class ContainedPacket extends Packet implements Encodable {
    public abstract void encode(BCPGOutputStream bCPGOutputStream) throws IOException;

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.writePacket(this);
        bCPGOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
