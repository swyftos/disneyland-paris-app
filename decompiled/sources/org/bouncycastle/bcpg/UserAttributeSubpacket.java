package org.bouncycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class UserAttributeSubpacket {
    protected byte[] data;
    private boolean forceLongLength;
    int type;

    protected UserAttributeSubpacket(int i, boolean z, byte[] bArr) {
        this.type = i;
        this.forceLongLength = z;
        this.data = bArr;
    }

    protected UserAttributeSubpacket(int i, byte[] bArr) {
        this(i, false, bArr);
    }

    public void encode(OutputStream outputStream) throws IOException {
        byte b;
        int length = this.data.length;
        int i = length + 1;
        if (i < 192 && !this.forceLongLength) {
            b = (byte) i;
        } else if (i > 8383 || this.forceLongLength) {
            outputStream.write(255);
            outputStream.write((byte) (i >> 24));
            outputStream.write((byte) (i >> 16));
            outputStream.write((byte) (i >> 8));
            b = (byte) i;
        } else {
            int i2 = length - 191;
            outputStream.write((byte) (((i2 >> 8) & 255) + 192));
            b = (byte) i2;
        }
        outputStream.write(b);
        outputStream.write(this.type);
        outputStream.write(this.data);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAttributeSubpacket)) {
            return false;
        }
        UserAttributeSubpacket userAttributeSubpacket = (UserAttributeSubpacket) obj;
        return this.type == userAttributeSubpacket.type && Arrays.areEqual(this.data, userAttributeSubpacket.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) ^ this.type;
    }
}
