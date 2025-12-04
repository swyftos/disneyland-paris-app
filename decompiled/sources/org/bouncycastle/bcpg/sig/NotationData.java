package org.bouncycastle.bcpg.sig;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class NotationData extends SignatureSubpacket {
    public static final int HEADER_FLAG_LENGTH = 4;
    public static final int HEADER_NAME_LENGTH = 2;
    public static final int HEADER_VALUE_LENGTH = 2;

    public NotationData(boolean z, boolean z2, String str, String str2) {
        super(20, z, false, createData(z2, str, str2));
    }

    public NotationData(boolean z, boolean z2, byte[] bArr) {
        super(20, z, z2, bArr);
    }

    private static byte[] createData(boolean z, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(z ? 128 : 0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        int iMin = Math.min(uTF8ByteArray.length, 65535);
        if (iMin != uTF8ByteArray.length) {
            throw new IllegalArgumentException("notationName exceeds maximum length.");
        }
        byte[] uTF8ByteArray2 = Strings.toUTF8ByteArray(str2);
        int iMin2 = Math.min(uTF8ByteArray2.length, 65535);
        if (iMin2 != uTF8ByteArray2.length) {
            throw new IllegalArgumentException("notationValue exceeds maximum length.");
        }
        byteArrayOutputStream.write((iMin >>> 8) & 255);
        byteArrayOutputStream.write(iMin & 255);
        byteArrayOutputStream.write((iMin2 >>> 8) & 255);
        byteArrayOutputStream.write(iMin2 & 255);
        byteArrayOutputStream.write(uTF8ByteArray, 0, iMin);
        byteArrayOutputStream.write(uTF8ByteArray2, 0, iMin2);
        return byteArrayOutputStream.toByteArray();
    }

    public String getNotationName() {
        byte[] bArr = this.data;
        int i = ((bArr[4] & 255) << 8) + (bArr[5] & 255);
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 8, bArr2, 0, i);
        return Strings.fromUTF8ByteArray(bArr2);
    }

    public String getNotationValue() {
        return Strings.fromUTF8ByteArray(getNotationValueBytes());
    }

    public byte[] getNotationValueBytes() {
        byte[] bArr = this.data;
        int i = ((bArr[4] & 255) << 8) + (bArr[5] & 255);
        int i2 = ((bArr[6] & 255) << 8) + (bArr[7] & 255);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i + 8, bArr2, 0, i2);
        return bArr2;
    }

    public boolean isHumanReadable() {
        return this.data[0] == -128;
    }
}
