package com.github.penfeizhou.animation.gif.p031io;

import androidx.work.Data;
import com.github.penfeizhou.animation.p032io.Writer;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class GifWriter implements Writer {
    protected IntBuffer intBuffer;

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void close() {
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void putByte(byte b) {
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void putBytes(byte[] bArr) {
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public byte[] toByteArray() {
        return null;
    }

    public GifWriter() {
        reset(Data.MAX_DATA_BYTES);
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public int position() {
        return this.intBuffer.position();
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void skip(int i) {
        this.intBuffer.position(i + position());
    }

    @Override // com.github.penfeizhou.animation.p032io.Writer
    public void reset(int i) {
        IntBuffer intBuffer = this.intBuffer;
        if (intBuffer == null || i > intBuffer.capacity()) {
            this.intBuffer = IntBuffer.allocate(i);
        }
        this.intBuffer.clear();
        this.intBuffer.limit(i);
        this.intBuffer.position(0);
    }

    public int[] asIntArray() {
        return this.intBuffer.array();
    }

    public IntBuffer asBuffer() {
        return this.intBuffer;
    }
}
