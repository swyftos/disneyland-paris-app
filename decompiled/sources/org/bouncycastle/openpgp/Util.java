package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.BCPGInputStream;

/* loaded from: classes6.dex */
abstract class Util {
    static BCPGInputStream createBCPGInputStream(InputStream inputStream, int i) throws IOException {
        BCPGInputStream bCPGInputStream = new BCPGInputStream(inputStream);
        if (bCPGInputStream.nextPacketTag() == i) {
            return bCPGInputStream;
        }
        throw new IOException("unexpected tag " + bCPGInputStream.nextPacketTag() + " encountered");
    }

    static BCPGInputStream createBCPGInputStream(InputStream inputStream, int i, int i2) throws IOException {
        BCPGInputStream bCPGInputStream = new BCPGInputStream(inputStream);
        if (bCPGInputStream.nextPacketTag() == i || bCPGInputStream.nextPacketTag() == i2) {
            return bCPGInputStream;
        }
        throw new IOException("unexpected tag " + bCPGInputStream.nextPacketTag() + " encountered");
    }
}
