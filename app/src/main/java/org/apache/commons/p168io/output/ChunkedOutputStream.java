package org.apache.commons.p168io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class ChunkedOutputStream extends FilterOutputStream {
    private final int chunkSize;

    public ChunkedOutputStream(OutputStream outputStream, int i) {
        super(outputStream);
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.chunkSize = i;
    }

    public ChunkedOutputStream(OutputStream outputStream) {
        this(outputStream, 4096);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int iMin = Math.min(i2, this.chunkSize);
            ((FilterOutputStream) this).out.write(bArr, i, iMin);
            i2 -= iMin;
            i += iMin;
        }
    }
}
