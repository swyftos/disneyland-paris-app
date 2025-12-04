package com.amazonaws.services.s3.model;

import com.amazonaws.util.Base64;
import javax.crypto.SecretKey;

/* loaded from: classes2.dex */
public class SSECustomerKey {
    private String algorithm;
    private final String base64EncodedKey;
    private String base64EncodedMd5;

    public SSECustomerKey(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Encryption key must be specified");
        }
        this.algorithm = SSEAlgorithm.AES256.getAlgorithm();
        this.base64EncodedKey = str;
    }

    public SSECustomerKey(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Encryption key must be specified");
        }
        this.algorithm = SSEAlgorithm.AES256.getAlgorithm();
        this.base64EncodedKey = Base64.encodeAsString(bArr);
    }

    public SSECustomerKey(SecretKey secretKey) {
        if (secretKey == null) {
            throw new IllegalArgumentException("Encryption key must be specified");
        }
        this.algorithm = SSEAlgorithm.AES256.getAlgorithm();
        this.base64EncodedKey = Base64.encodeAsString(secretKey.getEncoded());
    }

    private SSECustomerKey() {
        this.base64EncodedKey = null;
    }

    public String getKey() {
        return this.base64EncodedKey;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public SSECustomerKey withAlgorithm(String str) {
        setAlgorithm(str);
        return this;
    }

    public String getMd5() {
        return this.base64EncodedMd5;
    }

    public void setMd5(String str) {
        this.base64EncodedMd5 = str;
    }

    public SSECustomerKey withMd5(String str) {
        setMd5(str);
        return this;
    }

    public static SSECustomerKey generateSSECustomerKeyForPresignUrl(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        return new SSECustomerKey().withAlgorithm(str);
    }
}
