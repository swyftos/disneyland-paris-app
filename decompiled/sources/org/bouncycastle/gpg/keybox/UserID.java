package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class UserID {
    private final long lengthOfUserId;
    private final long offsetToUserId;
    private final int reserved;
    private final byte[] userID;
    private final int userIdFlags;
    private final int validity;

    private UserID(long j, long j2, int i, int i2, int i3, byte[] bArr) {
        this.offsetToUserId = j;
        this.lengthOfUserId = j2;
        this.userIdFlags = i;
        this.validity = i2;
        this.reserved = i3;
        this.userID = bArr;
    }

    static UserID getInstance(Object obj, int i) throws IOException {
        if (obj instanceof UserID) {
            return (UserID) obj;
        }
        KeyBoxByteBuffer keyBoxByteBufferWrap = KeyBoxByteBuffer.wrap(obj);
        long jU32 = keyBoxByteBufferWrap.u32();
        long jU322 = keyBoxByteBufferWrap.u32();
        long j = i + jU32;
        return new UserID(jU32, jU322, keyBoxByteBufferWrap.u16(), keyBoxByteBufferWrap.u8(), keyBoxByteBufferWrap.u8(), keyBoxByteBufferWrap.rangeOf((int) j, (int) (j + jU322)));
    }

    public long getLengthOfUserId() {
        return this.lengthOfUserId;
    }

    public long getOffsetToUserId() {
        return this.offsetToUserId;
    }

    public int getReserved() {
        return this.reserved;
    }

    public byte[] getUserID() {
        return Arrays.clone(this.userID);
    }

    public String getUserIDAsString() {
        return Strings.fromUTF8ByteArray(this.userID);
    }

    public long getUserIdFlags() {
        return this.userIdFlags;
    }

    public int getValidity() {
        return this.validity;
    }
}
