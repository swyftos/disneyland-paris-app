package com.github.penfeizhou.animation.p032io;

import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferWriter implements Writer {
    protected ByteBuffer byteBuffer;

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void close() {
    }

    public ByteBufferWriter() {
        reset(Data.MAX_DATA_BYTES);
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void putByte(byte b) {
        this.byteBuffer.put(b);
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void putBytes(byte[] bArr) {
        this.byteBuffer.put(bArr);
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public int position() {
        return this.byteBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void skip(int i) {
        this.byteBuffer.position(i + position());
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public byte[] toByteArray() {
        return this.byteBuffer.array();
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void reset(int i) {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.byteBuffer = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.byteBuffer.clear();
    }
}
