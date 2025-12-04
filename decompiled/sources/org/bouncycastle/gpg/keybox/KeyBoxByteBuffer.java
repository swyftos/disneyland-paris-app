package org.bouncycastle.gpg.keybox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
class KeyBoxByteBuffer {
    private final ByteBuffer buffer;

    public KeyBoxByteBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    static KeyBoxByteBuffer wrap(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof KeyBoxByteBuffer) {
            return (KeyBoxByteBuffer) obj;
        }
        if (obj instanceof ByteBuffer) {
            return new KeyBoxByteBuffer((ByteBuffer) obj);
        }
        if (obj instanceof byte[]) {
            return wrap(ByteBuffer.wrap((byte[]) obj));
        }
        if (obj instanceof ByteArrayOutputStream) {
            return wrap(((ByteArrayOutputStream) obj).toByteArray());
        }
        if (!(obj instanceof InputStream)) {
            throw new IllegalStateException("Could not convert " + obj.getClass().getCanonicalName() + " to KeyBoxByteBuffer");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = ((InputStream) obj).read(bArr);
            if (i < 0) {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return wrap(byteArrayOutputStream);
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public byte[] bN(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size less than 0");
        }
        if (i > remaining()) {
            throw new IllegalArgumentException("size exceeds buffer remaining");
        }
        byte[] bArr = new byte[i];
        this.buffer.get(bArr);
        return bArr;
    }

    public void consume(int i) {
        if (i > remaining()) {
            throw new IllegalArgumentException("size exceeds buffer remaining");
        }
        while (true) {
            i--;
            if (i < 0) {
                return;
            } else {
                this.buffer.get();
            }
        }
    }

    public boolean hasRemaining() {
        return this.buffer.hasRemaining();
    }

    public int position() {
        return this.buffer.position();
    }

    public byte[] rangeOf(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0 || i < 0) {
            throw new IllegalArgumentException("invalid range " + i + ":" + i2);
        }
        if (i2 > this.buffer.limit()) {
            throw new IllegalArgumentException("range exceeds buffer remaining");
        }
        int iPosition = this.buffer.position();
        this.buffer.position(i);
        byte[] bArr = new byte[i3];
        this.buffer.get(bArr);
        this.buffer.position(iPosition);
        return bArr;
    }

    public int remaining() {
        return this.buffer.remaining();
    }

    public int u16() {
        return u8() | (u8() << 8);
    }

    public long u32() {
        return u8() | (u8() << 24) | (u8() << 16) | (u8() << 8);
    }

    public int u8() {
        return this.buffer.get() & 255;
    }
}
