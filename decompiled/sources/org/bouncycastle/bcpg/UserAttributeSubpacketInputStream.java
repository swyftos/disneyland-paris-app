package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.attr.ImageAttribute;

/* loaded from: classes6.dex */
public class UserAttributeSubpacketInputStream extends InputStream implements UserAttributeSubpacketTags {
    InputStream in;

    public UserAttributeSubpacketInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    private void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            int i3 = read();
            if (i3 < 0) {
                throw new EOFException();
            }
            bArr[i] = (byte) i3;
            i++;
            i2--;
        }
        while (i2 > 0) {
            int i4 = this.in.read(bArr, i, i2);
            if (i4 < 0) {
                throw new EOFException();
            }
            i += i4;
            i2 -= i4;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    public UserAttributeSubpacket readPacket() throws IOException {
        boolean z;
        int i = read();
        if (i < 0) {
            return null;
        }
        if (i < 192) {
            z = false;
        } else if (i <= 223) {
            i = ((i - 192) << 8) + this.in.read() + 192;
            z = false;
        } else {
            if (i != 255) {
                throw new IOException("unrecognised length reading user attribute sub packet");
            }
            i = (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read();
            z = true;
        }
        int i2 = this.in.read();
        if (i2 < 0) {
            throw new EOFException("unexpected EOF reading user attribute sub packet");
        }
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        readFully(bArr, 0, i3);
        return i2 != 1 ? new UserAttributeSubpacket(i2, z, bArr) : new ImageAttribute(z, bArr);
    }
}
