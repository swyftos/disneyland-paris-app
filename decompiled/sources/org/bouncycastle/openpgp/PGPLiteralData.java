package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.LiteralDataPacket;
import org.bouncycastle.bcpg.Packet;

/* loaded from: classes6.dex */
public class PGPLiteralData {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = new Date(0);
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    LiteralDataPacket data;

    public PGPLiteralData(InputStream inputStream) throws IOException {
        this(Util.createBCPGInputStream(inputStream, 11));
    }

    public PGPLiteralData(BCPGInputStream bCPGInputStream) throws IOException {
        Packet packet = bCPGInputStream.readPacket();
        if (packet instanceof LiteralDataPacket) {
            this.data = (LiteralDataPacket) packet;
            return;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }

    public PGPLiteralData(byte[] bArr) throws IOException {
        this(Util.createBCPGInputStream(new ByteArrayInputStream(bArr), 11));
    }

    public InputStream getDataStream() {
        return getInputStream();
    }

    public String getFileName() {
        return this.data.getFileName();
    }

    public int getFormat() {
        return this.data.getFormat();
    }

    public InputStream getInputStream() {
        return this.data.getInputStream();
    }

    public Date getModificationTime() {
        return new Date(this.data.getModificationTime());
    }

    public byte[] getRawFileName() {
        return this.data.getRawFileName();
    }
}
