package com.allegion.alsecurity;

import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlAes;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¨\u0006\u0017"}, d2 = {"Lcom/allegion/alsecurity/AlAes;", "Lcom/allegion/alsecurity/interfaces/IAlAes;", "()V", "decrypt", "", "secretKey", "Ljavax/crypto/SecretKey;", "data", "paddingType", "Lcom/allegion/alsecurity/enums/AlPaddingType;", "iv", "decryptCbcAes", "key", "encryptedData", "Ljavax/crypto/spec/IvParameterSpec;", "decryptPKCS7PaddingAes", "encrypt", "encryptCbcAes", "input", "encryptPKCS7PaddingAes", "initializePaddedCipher", "Lorg/bouncycastle/crypto/paddings/PaddedBufferedBlockCipher;", "manualPadding", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAes implements IAlAes {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AlPaddingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            AlPaddingType alPaddingType = AlPaddingType.NO_PADDING;
            iArr[alPaddingType.ordinal()] = 1;
            AlPaddingType alPaddingType2 = AlPaddingType.PKCS7_PADDING;
            iArr[alPaddingType2.ordinal()] = 2;
            int[] iArr2 = new int[AlPaddingType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[alPaddingType.ordinal()] = 1;
            iArr2[alPaddingType2.ordinal()] = 2;
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlAes
    @NotNull
    public byte[] decrypt(@NotNull SecretKey secretKey, @NotNull byte[] data, @NotNull AlPaddingType paddingType, @Nullable byte[] iv) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(secretKey, "secretKey");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(paddingType, "paddingType");
        if (data.length == 0) {
            throw new AlSecurityException("Null parameters or incorrect data length");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[paddingType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                try {
                    return decryptPKCS7PaddingAes(secretKey, data);
                } catch (InvalidCipherTextException e) {
                    throw new AlSecurityException(e);
                }
            }
            throw new AlSecurityException("Invalid padding type");
        }
        if (iv == null) {
            throw new AlSecurityException("IV value is required");
        }
        try {
            return decryptCbcAes(secretKey, data, new IvParameterSpec(iv));
        } catch (InvalidAlgorithmParameterException e2) {
            throw new AlSecurityException("Unable to to decrypt", e2);
        } catch (InvalidKeyException e3) {
            throw new AlSecurityException("Unable to to decrypt", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new AlSecurityException("Unable to to decrypt", e4);
        } catch (BadPaddingException e5) {
            throw new AlSecurityException("Unable to to decrypt", e5);
        } catch (IllegalBlockSizeException e6) {
            throw new AlSecurityException("Unable to to decrypt", e6);
        } catch (NoSuchPaddingException e7) {
            throw new AlSecurityException("Unable to to decrypt", e7);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlAes
    @NotNull
    public byte[] encrypt(@NotNull SecretKey secretKey, @NotNull byte[] data, @NotNull AlPaddingType paddingType, @Nullable byte[] iv) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(secretKey, "secretKey");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(paddingType, "paddingType");
        if (data.length == 0) {
            throw new AlSecurityException("Null parameters or incorrect data length");
        }
        int i = WhenMappings.$EnumSwitchMapping$1[paddingType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                try {
                    return encryptPKCS7PaddingAes(secretKey, data);
                } catch (InvalidCipherTextException e) {
                    throw new AlSecurityException(e);
                }
            }
            throw new AlSecurityException("Invalid padding type");
        }
        if (iv == null) {
            throw new AlSecurityException("IV value is required");
        }
        try {
            return encryptCbcAes(secretKey, data, new IvParameterSpec(iv));
        } catch (InvalidAlgorithmParameterException e2) {
            throw new AlSecurityException("Unable to to encrypt", e2);
        } catch (InvalidKeyException e3) {
            throw new AlSecurityException("Unable to to encrypt", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new AlSecurityException("Unable to to encrypt", e4);
        } catch (BadPaddingException e5) {
            throw new AlSecurityException("Unable to to encrypt", e5);
        } catch (IllegalBlockSizeException e6) {
            throw new AlSecurityException("Unable to to encrypt", e6);
        } catch (NoSuchPaddingException e7) {
            throw new AlSecurityException("Unable to to encrypt", e7);
        }
    }

    private final byte[] decryptPKCS7PaddingAes(SecretKey key, byte[] encryptedData) throws InvalidCipherTextException, IllegalStateException, DataLengthException, IllegalArgumentException {
        PaddedBufferedBlockCipher paddedBufferedBlockCipherInitializePaddedCipher = initializePaddedCipher();
        paddedBufferedBlockCipherInitializePaddedCipher.init(false, new KeyParameter(key.getEncoded()));
        byte[] bArr = new byte[paddedBufferedBlockCipherInitializePaddedCipher.getOutputSize(encryptedData.length)];
        paddedBufferedBlockCipherInitializePaddedCipher.doFinal(bArr, paddedBufferedBlockCipherInitializePaddedCipher.processBytes(encryptedData, 0, encryptedData.length, bArr, 0));
        return bArr;
    }

    private final byte[] encryptPKCS7PaddingAes(SecretKey key, byte[] input) throws InvalidCipherTextException, IllegalStateException, DataLengthException, IllegalArgumentException {
        PaddedBufferedBlockCipher paddedBufferedBlockCipherInitializePaddedCipher = initializePaddedCipher();
        paddedBufferedBlockCipherInitializePaddedCipher.init(true, new KeyParameter(key.getEncoded()));
        byte[] bArr = new byte[paddedBufferedBlockCipherInitializePaddedCipher.getOutputSize(input.length)];
        paddedBufferedBlockCipherInitializePaddedCipher.doFinal(bArr, paddedBufferedBlockCipherInitializePaddedCipher.processBytes(input, 0, input.length, bArr, 0));
        return bArr;
    }

    private final byte[] decryptCbcAes(SecretKey key, byte[] encryptedData, IvParameterSpec iv) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(AlKeyType.AES_CBC_256_NO_PADDING.getValue());
        cipher.init(2, key, iv);
        byte[] bArrDoFinal = cipher.doFinal(encryptedData);
        Intrinsics.checkExpressionValueIsNotNull(bArrDoFinal, "cipher.doFinal(encryptedData)");
        return bArrDoFinal;
    }

    private final byte[] encryptCbcAes(SecretKey key, byte[] input, IvParameterSpec iv) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(AlKeyType.AES_CBC_256_NO_PADDING.getValue());
        cipher.init(1, key, iv);
        byte[] bArrDoFinal = cipher.doFinal(manualPadding(input));
        Intrinsics.checkExpressionValueIsNotNull(bArrDoFinal, "cipher.doFinal(input)");
        return bArrDoFinal;
    }

    private final PaddedBufferedBlockCipher initializePaddedCipher() {
        return new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), new PKCS7Padding());
    }

    private final byte[] manualPadding(byte[] input) {
        if (input.length % 16 == 0) {
            return input;
        }
        int length = 16 - (input.length % 16);
        byte[] bArr = new byte[input.length + length];
        System.arraycopy(input, 0, bArr, 0, input.length);
        System.arraycopy(new byte[length], 0, bArr, input.length, length);
        return bArr;
    }
}
