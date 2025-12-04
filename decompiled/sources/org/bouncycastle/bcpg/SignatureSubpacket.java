package org.bouncycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class SignatureSubpacket {
    boolean critical;
    protected byte[] data;
    boolean isLongLength;
    int type;

    protected SignatureSubpacket(int i, boolean z, boolean z2, byte[] bArr) {
        this.type = i;
        this.critical = z;
        this.isLongLength = z2;
        this.data = bArr;
    }

    public void encode(OutputStream outputStream) throws IOException {
        byte b;
        int length = this.data.length;
        int i = length + 1;
        if (this.isLongLength) {
            outputStream.write(255);
            outputStream.write((byte) (i >> 24));
            outputStream.write((byte) (i >> 16));
            outputStream.write((byte) (i >> 8));
            b = (byte) i;
        } else if (i >= 192) {
            if (i <= 8383) {
                int i2 = length - 191;
                outputStream.write((byte) (((i2 >> 8) & 255) + 192));
                b = (byte) i2;
            }
            outputStream.write(255);
            outputStream.write((byte) (i >> 24));
            outputStream.write((byte) (i >> 16));
            outputStream.write((byte) (i >> 8));
            b = (byte) i;
        } else {
            b = (byte) i;
        }
        outputStream.write(b);
        outputStream.write(this.critical ? this.type | 128 : this.type);
        outputStream.write(this.data);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignatureSubpacket)) {
            return false;
        }
        SignatureSubpacket signatureSubpacket = (SignatureSubpacket) obj;
        if (this.type == signatureSubpacket.type && this.critical == signatureSubpacket.critical) {
            return Arrays.areEqual(this.data, signatureSubpacket.data);
        }
        return false;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        boolean z = this.critical;
        return (z ? 1 : 0) + (this.type * 7) + (Arrays.hashCode(this.data) * 49);
    }

    public boolean isCritical() {
        return this.critical;
    }

    public boolean isLongLength() {
        return this.isLongLength;
    }
}
