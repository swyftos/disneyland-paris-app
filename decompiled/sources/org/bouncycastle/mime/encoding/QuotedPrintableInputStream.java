package org.bouncycastle.mime.encoding;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class QuotedPrintableInputStream extends FilterInputStream {
    public QuotedPrintableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2;
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 == -1) {
            return -1;
        }
        while (i3 == 61) {
            int i4 = ((FilterInputStream) this).in.read();
            if (i4 == -1) {
                throw new IllegalStateException("Quoted '=' at end of stream");
            }
            if (i4 == 13) {
                i3 = ((FilterInputStream) this).in.read();
                if (i3 == 10) {
                }
            } else if (i4 != 10) {
                if (i4 >= 48 && i4 <= 57) {
                    i = i4 - 48;
                } else {
                    if (i4 < 65 || i4 > 70) {
                        throw new IllegalStateException("Expecting '0123456789ABCDEF after quote that was not immediately followed by LF or CRLF");
                    }
                    i = i4 - 55;
                }
                int i5 = i << 4;
                int i6 = ((FilterInputStream) this).in.read();
                if (i6 >= 48 && i6 <= 57) {
                    i2 = i6 - 48;
                } else {
                    if (i6 < 65 || i6 > 70) {
                        throw new IllegalStateException("Expecting second '0123456789ABCDEF after quote that was not immediately followed by LF or CRLF");
                    }
                    i2 = i6 - 55;
                }
                return i2 | i5;
            }
            i3 = ((FilterInputStream) this).in.read();
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 != i2) {
            int i4 = read();
            if (i4 < 0) {
                break;
            }
            bArr[i3 + i] = (byte) i4;
            i3++;
        }
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }
}
