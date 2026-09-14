package com.amazonaws.services.p017s3.internal.crypto;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class AesCbc extends ContentCryptoScheme {
    @Override // com.amazonaws.services.p017s3.internal.crypto.ContentCryptoScheme
    int getBlockSizeInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.p017s3.internal.crypto.ContentCryptoScheme
    int getIVLengthInBytes() {
        return 16;
    }

    @Override // com.amazonaws.services.p017s3.internal.crypto.ContentCryptoScheme
    int getKeyLengthInBits() {
        return 256;
    }

    AesCbc() {
    }

    @Override // com.amazonaws.services.p017s3.internal.crypto.ContentCryptoScheme
    String getKeyGeneratorAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
    }

    @Override // com.amazonaws.services.p017s3.internal.crypto.ContentCryptoScheme
    String getCipherAlgorithm() {
        return JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD;
    }
}
