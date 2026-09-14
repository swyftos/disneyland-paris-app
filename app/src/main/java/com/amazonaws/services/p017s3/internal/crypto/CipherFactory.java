package com.amazonaws.services.p017s3.internal.crypto;

import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class CipherFactory {
    private final int cipherMode;
    private final Provider cryptoProvider;
    private byte[] initVectorBytes;
    private final SecretKey symmetricKey;

    public CipherFactory(SecretKey secretKey, int i, byte[] bArr, Provider provider) {
        this.symmetricKey = secretKey;
        this.cipherMode = i;
        this.initVectorBytes = bArr;
        this.cryptoProvider = provider;
    }

    public Cipher createCipher() {
        Cipher cipherCreateSymmetricCipher = EncryptionUtils.createSymmetricCipher(this.symmetricKey, this.cipherMode, this.cryptoProvider, this.initVectorBytes);
        if (this.initVectorBytes == null) {
            this.initVectorBytes = cipherCreateSymmetricCipher.getIV();
        }
        return cipherCreateSymmetricCipher;
    }

    public Provider getCryptoProvider() {
        return this.cryptoProvider;
    }

    public int getCipherMode() {
        return this.cipherMode;
    }

    public byte[] getIV() {
        byte[] bArr = this.initVectorBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }
}
