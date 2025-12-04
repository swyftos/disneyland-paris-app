package com.amazonaws.services.s3.internal.crypto;

import java.security.Key;
import java.security.Provider;

@Deprecated
/* loaded from: classes2.dex */
class S3KeyWrapScheme {
    static final S3KeyWrapScheme NONE = new S3KeyWrapScheme() { // from class: com.amazonaws.services.s3.internal.crypto.S3KeyWrapScheme.1
        @Override // com.amazonaws.services.s3.internal.crypto.S3KeyWrapScheme
        String getKeyWrapAlgorithm(Key key, Provider provider) {
            return null;
        }

        @Override // com.amazonaws.services.s3.internal.crypto.S3KeyWrapScheme
        public String toString() {
            return "NONE";
        }
    };

    S3KeyWrapScheme() {
    }

    String getKeyWrapAlgorithm(Key key, Provider provider) {
        String algorithm = key.getAlgorithm();
        if (JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM.equals(algorithm)) {
            return "AESWrap";
        }
        if ("RSA".equals(algorithm) && CryptoRuntime.isRsaKeyWrapAvailable(provider)) {
            return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
        }
        return null;
    }

    public String toString() {
        return "S3KeyWrapScheme";
    }
}
