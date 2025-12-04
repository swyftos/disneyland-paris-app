package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: classes2.dex */
final class MultipartUploadCbcContext extends MultipartUploadCryptoContext {
    private byte[] nextIV;

    MultipartUploadCbcContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2, contentCryptoMaterial);
    }

    public void setNextInitializationVector(byte[] bArr) {
        this.nextIV = bArr;
    }

    public byte[] getNextInitializationVector() {
        return this.nextIV;
    }
}
