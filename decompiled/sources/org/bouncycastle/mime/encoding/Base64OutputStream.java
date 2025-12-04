package org.bouncycastle.mime.encoding;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Base64Encoder;

/* loaded from: classes6.dex */
public class Base64OutputStream extends FilterOutputStream {
    private static final Base64Encoder ENCODER = new Base64Encoder();
    private final byte[] inBuf;
    private int inPos;
    private final byte[] outBuf;

    public Base64OutputStream(OutputStream outputStream) {
        super(outputStream);
        this.inBuf = new byte[54];
        byte[] bArr = new byte[74];
        this.outBuf = bArr;
        this.inPos = 0;
        bArr[72] = Ascii.CR;
        bArr[73] = 10;
    }

    private void encodeBlock(byte[] bArr, int i) throws IOException {
        ENCODER.encode(bArr, i, 54, this.outBuf, 0);
        ((FilterOutputStream) this).out.write(this.outBuf, 0, 74);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = this.inPos;
        if (i > 0) {
            int iEncode = ENCODER.encode(this.inBuf, 0, i, this.outBuf, 0);
            this.inPos = 0;
            byte[] bArr = this.outBuf;
            bArr[iEncode] = Ascii.CR;
            bArr[iEncode + 1] = 10;
            ((FilterOutputStream) this).out.write(bArr, 0, iEncode + 2);
        }
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.inBuf;
        int i2 = this.inPos;
        int i3 = i2 + 1;
        this.inPos = i3;
        bArr[i2] = (byte) i;
        if (i3 == 54) {
            encodeBlock(bArr, 0);
            this.inPos = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.inPos;
        int i4 = 54 - i3;
        if (i2 < i4) {
            System.arraycopy(bArr, i, this.inBuf, i3, i2);
            this.inPos += i2;
            return;
        }
        if (i3 > 0) {
            System.arraycopy(bArr, i, this.inBuf, i3, i4);
            encodeBlock(this.inBuf, 0);
        } else {
            i4 = 0;
        }
        while (true) {
            int i5 = i2 - i4;
            if (i5 < 54) {
                System.arraycopy(bArr, i + i4, this.inBuf, 0, i5);
                this.inPos = i5;
                return;
            } else {
                encodeBlock(bArr, i + i4);
                i4 += 54;
            }
        }
    }
}
