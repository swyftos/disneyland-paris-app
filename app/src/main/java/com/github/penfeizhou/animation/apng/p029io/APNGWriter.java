package com.github.penfeizhou.animation.apng.p029io;

import com.github.penfeizhou.animation.p032io.ByteBufferWriter;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class APNGWriter extends ByteBufferWriter {
    public void writeFourCC(int i) {
        putByte((byte) (i & 255));
        putByte((byte) ((i >> 8) & 255));
        putByte((byte) ((i >> 16) & 255));
        putByte((byte) ((i >> 24) & 255));
    }

    public void writeInt(int i) {
        putByte((byte) ((i >> 24) & 255));
        putByte((byte) ((i >> 16) & 255));
        putByte((byte) ((i >> 8) & 255));
        putByte((byte) (i & 255));
    }

    @Override // com.github.penfeizhou.animation.p032io.ByteBufferWriter, com.github.penfeizhou.animation.p032io.Writer
    public void reset(int i) {
        super.reset(i);
        this.byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
}
