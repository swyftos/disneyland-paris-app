package com.github.penfeizhou.animation.p032io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferReader implements Reader {
    protected final ByteBuffer byteBuffer;

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public void close() throws IOException {
    }

    public ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public long skip(long j) throws IOException {
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public byte peek() throws IOException {
        return this.byteBuffer.get();
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public void reset() throws IOException {
        this.byteBuffer.position(0);
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public int position() {
        return this.byteBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.byteBuffer.get(bArr, i, i2);
        return i2;
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public int available() throws IOException {
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.p032io.Reader
    public InputStream toInputStream() throws IOException {
        return new ByteArrayInputStream(this.byteBuffer.array());
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
}
