package com.amazonaws.services.p017s3.internal.crypto;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
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
