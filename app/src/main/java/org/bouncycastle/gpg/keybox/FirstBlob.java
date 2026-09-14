package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class FirstBlob extends Blob {
    private final long fileCreatedAt;
    private final int headerFlags;
    private final long lastMaintenanceRun;

    private FirstBlob(int i, long j, BlobType blobType, int i2, int i3, long j2, long j3) {
        super(i, j, blobType, i2);
        this.headerFlags = i3;
        this.fileCreatedAt = j2;
        this.lastMaintenanceRun = j3;
    }

    static FirstBlob parseContent(int i, long j, BlobType blobType, int i2, KeyBoxByteBuffer keyBoxByteBuffer) throws IOException {
        int iU16 = keyBoxByteBuffer.u16();
        byte[] bArrM2094bN = keyBoxByteBuffer.m2094bN(4);
        byte[] bArr = Blob.magicBytes;
        if (Arrays.areEqual(bArrM2094bN, bArr)) {
            keyBoxByteBuffer.u32();
            long jU32 = keyBoxByteBuffer.u32();
            long jU33 = keyBoxByteBuffer.u32();
            keyBoxByteBuffer.u32();
            keyBoxByteBuffer.u32();
            return new FirstBlob(i, j, blobType, i2, iU16, jU32, jU33);
        }
        throw new IOException("Incorrect magic expecting " + Hex.toHexString(bArr) + " but got " + Hex.toHexString(bArrM2094bN));
    }

    public long getFileCreatedAt() {
        return this.fileCreatedAt;
    }

    public int getHeaderFlags() {
        return this.headerFlags;
    }

    public long getLastMaintenanceRun() {
        return this.lastMaintenanceRun;
    }
}
