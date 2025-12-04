package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.apache.bzip2.CBZip2InputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.CompressedDataPacket;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.Packet;

/* loaded from: classes6.dex */
public class PGPCompressedData implements CompressionAlgorithmTags {
    CompressedDataPacket data;

    public PGPCompressedData(InputStream inputStream) throws IOException {
        this(Util.createBCPGInputStream(inputStream, 8));
    }

    public PGPCompressedData(BCPGInputStream bCPGInputStream) throws IOException {
        Packet packet = bCPGInputStream.readPacket();
        if (packet instanceof CompressedDataPacket) {
            this.data = (CompressedDataPacket) packet;
            return;
        }
        throw new IOException("unexpected packet in stream: " + packet);
    }

    public PGPCompressedData(byte[] bArr) throws IOException {
        this(Util.createBCPGInputStream(new ByteArrayInputStream(bArr), 8));
    }

    public int getAlgorithm() {
        return this.data.getAlgorithm();
    }

    public InputStream getDataStream() throws PGPException {
        if (getAlgorithm() == 0) {
            return getInputStream();
        }
        if (getAlgorithm() == 1) {
            return new InflaterInputStream(getInputStream(), new Inflater(true)) { // from class: org.bouncycastle.openpgp.PGPCompressedData.1
                private boolean eof = false;

                @Override // java.util.zip.InflaterInputStream
                protected void fill() throws IOException {
                    if (this.eof) {
                        throw new EOFException("Unexpected end of ZIP input stream");
                    }
                    InputStream inputStream = ((InflaterInputStream) this).in;
                    byte[] bArr = ((InflaterInputStream) this).buf;
                    int i = inputStream.read(bArr, 0, bArr.length);
                    ((InflaterInputStream) this).len = i;
                    if (i == -1) {
                        ((InflaterInputStream) this).buf[0] = 0;
                        ((InflaterInputStream) this).len = 1;
                        this.eof = true;
                    }
                    ((InflaterInputStream) this).inf.setInput(((InflaterInputStream) this).buf, 0, ((InflaterInputStream) this).len);
                }
            };
        }
        if (getAlgorithm() == 2) {
            return new InflaterInputStream(getInputStream()) { // from class: org.bouncycastle.openpgp.PGPCompressedData.2
                private boolean eof = false;

                @Override // java.util.zip.InflaterInputStream
                protected void fill() throws IOException {
                    if (this.eof) {
                        throw new EOFException("Unexpected end of ZIP input stream");
                    }
                    InputStream inputStream = ((InflaterInputStream) this).in;
                    byte[] bArr = ((InflaterInputStream) this).buf;
                    int i = inputStream.read(bArr, 0, bArr.length);
                    ((InflaterInputStream) this).len = i;
                    if (i == -1) {
                        ((InflaterInputStream) this).buf[0] = 0;
                        ((InflaterInputStream) this).len = 1;
                        this.eof = true;
                    }
                    ((InflaterInputStream) this).inf.setInput(((InflaterInputStream) this).buf, 0, ((InflaterInputStream) this).len);
                }
            };
        }
        if (getAlgorithm() != 3) {
            throw new PGPException("can't recognise compression algorithm: " + getAlgorithm());
        }
        try {
            return new CBZip2InputStream(getInputStream());
        } catch (IOException e) {
            throw new PGPException("I/O problem with stream: " + e, e);
        }
    }

    public InputStream getInputStream() {
        return this.data.getInputStream();
    }
}
