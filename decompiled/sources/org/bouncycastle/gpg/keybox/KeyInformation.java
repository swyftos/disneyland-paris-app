package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class KeyInformation {
    private final byte[] filler;
    private final byte[] fingerprint;
    private final int keyFlags;
    private final byte[] keyID;
    private final long offsetToKeyID;

    KeyInformation(byte[] bArr, long j, int i, byte[] bArr2, byte[] bArr3) {
        this.fingerprint = Arrays.clone(bArr);
        this.offsetToKeyID = j;
        this.keyFlags = i;
        this.filler = Arrays.clone(bArr2);
        this.keyID = Arrays.clone(bArr3);
    }

    static KeyInformation getInstance(Object obj, int i, int i2) throws IOException {
        byte[] bArrRangeOf;
        if (obj instanceof KeyInformation) {
            return (KeyInformation) obj;
        }
        KeyBoxByteBuffer keyBoxByteBufferWrap = KeyBoxByteBuffer.wrap(obj);
        int iPosition = keyBoxByteBufferWrap.position();
        byte[] bArrBN = keyBoxByteBufferWrap.bN(20);
        long jU32 = keyBoxByteBufferWrap.u32();
        if (jU32 > 0) {
            long j = i2 + jU32;
            bArrRangeOf = keyBoxByteBufferWrap.rangeOf((int) j, (int) (j + 8));
        } else {
            bArrRangeOf = null;
        }
        byte[] bArr = bArrRangeOf;
        int iU16 = keyBoxByteBufferWrap.u16();
        keyBoxByteBufferWrap.u16();
        return new KeyInformation(bArrBN, jU32, iU16, keyBoxByteBufferWrap.bN(i - (keyBoxByteBufferWrap.position() - iPosition)), bArr);
    }

    public byte[] getFiller() {
        return Arrays.clone(this.filler);
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public int getKeyFlags() {
        return this.keyFlags;
    }

    public byte[] getKeyID() {
        return Arrays.clone(this.keyID);
    }
}
