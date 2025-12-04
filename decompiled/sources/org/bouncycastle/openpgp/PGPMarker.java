package org.bouncycastle.openpgp;

import java.io.IOException;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.MarkerPacket;
import org.bouncycastle.bcpg.Packet;

/* loaded from: classes6.dex */
public class PGPMarker {
    private MarkerPacket p;

    public PGPMarker(BCPGInputStream bCPGInputStream) throws IOException {
        Packet packet = bCPGInputStream.readPacket();
        if (packet instanceof MarkerPacket) {
            this.p = (MarkerPacket) packet;
            return;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }
}
