package com.amazonaws.services.s3.internal.crypto;

import javax.crypto.SecretKey;

@Deprecated
/* loaded from: classes2.dex */
public class EncryptedUploadContext extends MultipartUploadContext {
    private final SecretKey envelopeEncryptionKey;
    private byte[] firstIV;
    private byte[] nextIV;

    public EncryptedUploadContext(String str, String str2, SecretKey secretKey) {
        super(str, str2);
        this.envelopeEncryptionKey = secretKey;
    }

    public SecretKey getEnvelopeEncryptionKey() {
        return this.envelopeEncryptionKey;
    }

    public void setNextInitializationVector(byte[] bArr) {
        this.nextIV = bArr;
    }

    public byte[] getNextInitializationVector() {
        return this.nextIV;
    }

    public void setFirstInitializationVector(byte[] bArr) {
        this.firstIV = bArr;
    }

    public byte[] getFirstInitializationVector() {
        return this.firstIV;
    }
}
