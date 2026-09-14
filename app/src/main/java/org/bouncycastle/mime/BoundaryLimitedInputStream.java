package org.bouncycastle.mime;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
public class BoundaryLimitedInputStream extends InputStream {
    private final byte[] boundary;
    private final byte[] buf;
    private int bufOff;
    private int lastI;
    private final InputStream src;
    private int index = 0;
    private boolean ended = false;

    public BoundaryLimitedInputStream(InputStream inputStream, String str) {
        this.bufOff = 0;
        this.src = inputStream;
        this.boundary = Strings.toByteArray(str);
        this.buf = new byte[str.length() + 3];
        this.bufOff = 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2;
        int i3;
        if (this.ended) {
            return -1;
        }
        int i4 = this.index;
        int i5 = this.bufOff;
        if (i4 < i5) {
            byte[] bArr = this.buf;
            int i6 = i4 + 1;
            this.index = i6;
            i = bArr[i4] & 255;
            if (i6 < i5) {
                return i;
            }
            this.bufOff = 0;
            this.index = 0;
        } else {
            i = this.src.read();
        }
        this.lastI = i;
        if (i < 0) {
            return -1;
        }
        if (i == 13 || i == 10) {
            this.index = 0;
            if (i != 13) {
                i2 = this.src.read();
            } else {
                i2 = this.src.read();
                if (i2 == 10) {
                    byte[] bArr2 = this.buf;
                    int i7 = this.bufOff;
                    this.bufOff = i7 + 1;
                    bArr2[i7] = 10;
                    i2 = this.src.read();
                }
            }
            if (i2 == 45) {
                byte[] bArr3 = this.buf;
                int i8 = this.bufOff;
                this.bufOff = i8 + 1;
                bArr3[i8] = 45;
                i2 = this.src.read();
            }
            if (i2 == 45) {
                byte[] bArr4 = this.buf;
                int i9 = this.bufOff;
                int i10 = i9 + 1;
                this.bufOff = i10;
                bArr4[i9] = 45;
                while (this.bufOff - i10 != this.boundary.length && (i3 = this.src.read()) >= 0) {
                    byte[] bArr5 = this.buf;
                    int i11 = this.bufOff;
                    byte b = (byte) i3;
                    bArr5[i11] = b;
                    if (b != this.boundary[i11 - i10]) {
                        this.bufOff = i11 + 1;
                        break;
                    }
                    this.bufOff = i11 + 1;
                }
                if (this.bufOff - i10 == this.boundary.length) {
                    this.ended = true;
                    return -1;
                }
            } else if (i2 >= 0) {
                byte[] bArr6 = this.buf;
                int i12 = this.bufOff;
                this.bufOff = i12 + 1;
                bArr6[i12] = (byte) i2;
            }
        }
        return i;
    }
}
