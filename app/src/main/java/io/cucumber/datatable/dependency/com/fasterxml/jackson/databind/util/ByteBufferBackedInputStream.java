package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ByteBufferBackedInputStream extends InputStream {

    /* JADX INFO: renamed from: _b */
    protected final ByteBuffer f3825_b;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.f3825_b = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3825_b.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f3825_b.hasRemaining()) {
            return this.f3825_b.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f3825_b.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, this.f3825_b.remaining());
        this.f3825_b.get(bArr, i, iMin);
        return iMin;
    }
}
