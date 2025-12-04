package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class Hkdf {
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private final String algorithm;
    private SecretKey prk = null;

    public static Hkdf getInstance(String str) throws NoSuchAlgorithmException {
        Mac.getInstance(str);
        return new Hkdf(str);
    }

    public void init(byte[] bArr) {
        init(bArr, null);
    }

    public void init(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr2 == null ? EMPTY_ARRAY : (byte[]) bArr2.clone();
        byte[] bArrDoFinal = EMPTY_ARRAY;
        try {
            try {
                Mac mac = Mac.getInstance(this.algorithm);
                if (bArr3.length == 0) {
                    bArr3 = new byte[mac.getMacLength()];
                    Arrays.fill(bArr3, (byte) 0);
                }
                mac.init(new SecretKeySpec(bArr3, this.algorithm));
                bArrDoFinal = mac.doFinal(bArr);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDoFinal, this.algorithm);
                Arrays.fill(bArrDoFinal, (byte) 0);
                unsafeInitWithoutKeyExtraction(secretKeySpec);
                Arrays.fill(bArrDoFinal, (byte) 0);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException("Unexpected exception", e);
            }
        } catch (Throwable th) {
            Arrays.fill(bArrDoFinal, (byte) 0);
            throw th;
        }
    }

    public void unsafeInitWithoutKeyExtraction(SecretKey secretKey) throws InvalidKeyException {
        if (!secretKey.getAlgorithm().equals(this.algorithm)) {
            throw new InvalidKeyException("Algorithm for the provided key must match the algorithm for this Hkdf. Expected " + this.algorithm + " but found " + secretKey.getAlgorithm());
        }
        this.prk = secretKey;
    }

    private Hkdf(String str) {
        if (!str.startsWith("Hmac")) {
            throw new IllegalArgumentException("Invalid algorithm " + str + ". Hkdf may only be used with Hmac algorithms.");
        }
        this.algorithm = str;
    }

    public byte[] deriveKey(String str, int i) {
        return deriveKey(str != null ? str.getBytes(StringUtils.UTF8) : null, i);
    }

    public byte[] deriveKey(byte[] bArr, int i) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArr2 = new byte[i];
        try {
            deriveKey(bArr, i, bArr2, 0);
            return bArr2;
        } catch (ShortBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public void deriveKey(byte[] bArr, int i, byte[] bArr2, int i2) throws NoSuchAlgorithmException, InvalidKeyException, ShortBufferException {
        assertInitialized();
        if (i < 0) {
            throw new IllegalArgumentException("Length must be a non-negative value.");
        }
        if (bArr2.length < i2 + i) {
            throw new ShortBufferException();
        }
        Mac macCreateMac = createMac();
        if (i > macCreateMac.getMacLength() * 255) {
            throw new IllegalArgumentException("Requested keys may not be longer than 255 times the underlying HMAC length.");
        }
        byte[] bArrDoFinal = EMPTY_ARRAY;
        byte b = 1;
        int i3 = 0;
        while (i3 < i) {
            try {
                macCreateMac.update(bArrDoFinal);
                macCreateMac.update(bArr);
                macCreateMac.update(b);
                bArrDoFinal = macCreateMac.doFinal();
                int i4 = 0;
                while (i4 < bArrDoFinal.length && i3 < i) {
                    bArr2[i3] = bArrDoFinal[i4];
                    i4++;
                    i3++;
                }
                b = (byte) (b + 1);
            } finally {
                Arrays.fill(bArrDoFinal, (byte) 0);
            }
        }
    }

    private Mac createMac() throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(this.algorithm);
            mac.init(this.prk);
            return mac;
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void assertInitialized() {
        if (this.prk == null) {
            throw new IllegalStateException("Hkdf has not been initialized");
        }
    }
}
