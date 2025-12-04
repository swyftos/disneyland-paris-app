package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import java.util.List;

/* loaded from: classes6.dex */
public class KeyBlob extends Blob {
    private final int allValidity;
    private final int assignedOwnerTrust;
    private final long blobCreatedAt;
    private final int blobFlags;
    private final byte[] checksum;
    private final List expirationTime;
    private final byte[] keyBytes;
    private final List keyInformation;
    private final int keyNumber;
    private final long newestTimestamp;
    private final int numberOfSignatures;
    private final int numberOfUserIDs;
    private final long recheckAfter;
    private final byte[] reserveBytes;
    private final byte[] serialNumber;
    private final List userIds;

    protected KeyBlob(int i, long j, BlobType blobType, int i2, int i3, int i4, List<KeyInformation> list, byte[] bArr, int i5, List<UserID> list2, int i6, List<Long> list3, int i7, int i8, long j2, long j3, long j4, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(i, j, blobType, i2);
        this.blobFlags = i3;
        this.keyNumber = i4;
        this.keyInformation = list;
        this.serialNumber = bArr;
        this.numberOfUserIDs = i5;
        this.userIds = list2;
        this.numberOfSignatures = i6;
        this.expirationTime = list3;
        this.assignedOwnerTrust = i7;
        this.allValidity = i8;
        this.recheckAfter = j2;
        this.newestTimestamp = j3;
        this.blobCreatedAt = j4;
        this.keyBytes = bArr2;
        this.reserveBytes = bArr3;
        this.checksum = bArr4;
    }

    static void verifyDigest(int i, long j, KeyBoxByteBuffer keyBoxByteBuffer, BlobVerifier blobVerifier) throws IOException {
        long j2 = i + j;
        int i2 = (int) (j2 - 20);
        if (blobVerifier.isMatched(keyBoxByteBuffer.rangeOf(i, i2), keyBoxByteBuffer.rangeOf(i2, (int) j2))) {
            return;
        }
        throw new IOException("Blob with base offset of " + i + " has incorrect digest.");
    }

    public int getAllValidity() {
        return this.allValidity;
    }

    public int getAssignedOwnerTrust() {
        return this.assignedOwnerTrust;
    }

    public long getBlobCreatedAt() {
        return this.blobCreatedAt;
    }

    public int getBlobFlags() {
        return this.blobFlags;
    }

    public byte[] getChecksum() {
        return this.checksum;
    }

    public List<Long> getExpirationTime() {
        return this.expirationTime;
    }

    public byte[] getKeyBytes() {
        return this.keyBytes;
    }

    public List<KeyInformation> getKeyInformation() {
        return this.keyInformation;
    }

    public int getKeyNumber() {
        return this.keyNumber;
    }

    public long getNewestTimestamp() {
        return this.newestTimestamp;
    }

    public int getNumberOfSignatures() {
        return this.numberOfSignatures;
    }

    public int getNumberOfUserIDs() {
        return this.numberOfUserIDs;
    }

    public long getRecheckAfter() {
        return this.recheckAfter;
    }

    public byte[] getReserveBytes() {
        return this.reserveBytes;
    }

    public byte[] getSerialNumber() {
        return this.serialNumber;
    }

    public List<UserID> getUserIds() {
        return this.userIds;
    }
}
