package org.bouncycastle.gpg.keybox;

/* loaded from: classes6.dex */
public enum BlobType {
    EMPTY_BLOB(0),
    FIRST_BLOB(1),
    OPEN_PGP_BLOB(2),
    X509_BLOB(3);

    private final int byteValue;

    BlobType(int i) {
        this.byteValue = i;
    }

    public static BlobType fromByte(int i) {
        for (BlobType blobType : values()) {
            if (blobType.byteValue == i) {
                return blobType;
            }
        }
        throw new IllegalArgumentException("Unknown blob type " + Integer.toHexString(i));
    }

    public int getByteValue() {
        return this.byteValue;
    }
}
