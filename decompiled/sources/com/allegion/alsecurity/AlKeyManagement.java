package com.allegion.alsecurity;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.logging.AlLog;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jce.ECPointUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u00015B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J$\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010J \u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J \u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0018\u00103\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u00104\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/allegion/alsecurity/AlKeyManagement;", "Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "context", "Landroid/content/Context;", "requireAuthentication", "", "keyProp", "", "(Landroid/content/Context;ZLjava/lang/String;)V", "keyStore", "Ljava/security/KeyStore;", "sharedPreferences", "Lcom/allegion/alsecurity/AlSharedPreferences;", "containsKeySecureReference", "keyReference", "decryptData", "", "data", "reference", "alKeyType", "encryptData", "exportPublicKeyX963Uncompressed", "key", "Ljava/security/interfaces/ECPublicKey;", "generateAesKeystore", "", "aesReference", "generateAesSoftware", "referenceId", "generateEcKeyPair", "Ljava/security/KeyPair;", "publicKey", "privateKey", "generateEccKeystore", "eccReference", "curve", "generateEccSoftware", "generateKey", "type", "Lcom/allegion/alsecurity/enums/AlKeyType;", "generateKeySecure", "requireAuth", "getKey", "Ljavax/crypto/SecretKey;", "getKeyPair", "getKeyPairSecureReference", "getKeySecureReference", "manualPadding", "input", "removeKey", "removeKeyReference", "storeKey", "storeKeyPair", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlKeyManagement implements IAlKeyManagement {
    private static final String ALGORITHM = "algorithm";
    private static final String ANDROID_KEYSTORE_NAME = "AndroidKeyStore";
    private static final String EXCEPTION_CONTEXT_NULL = "Context is null";
    private static final String EXCEPTION_KEY_NULL = "Key is null";
    private static final String EXCEPTION_REFERENCE_NULL = "Reference is null";
    private static final String FORMAT = "format";
    private static final String IV = "iv";
    private static final String PRIVATE = "private";
    private static final String PUBLIC = "public";
    private static final String STORE_ALIAS = "StoreAlias";
    private final KeyStore keyStore;
    private final AlSharedPreferences sharedPreferences;

    @JvmOverloads
    public AlKeyManagement(@NotNull Context context) throws AlSecurityException {
        this(context, false, null, 6, null);
    }

    @JvmOverloads
    public AlKeyManagement(@NotNull Context context, boolean z) throws AlSecurityException {
        this(context, z, null, 4, null);
    }

    @JvmOverloads
    public AlKeyManagement(@NotNull Context context, boolean z, @NotNull String keyProp) throws AlSecurityException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(keyProp, "keyProp");
        Objects.requireNonNull(context, EXCEPTION_CONTEXT_NULL);
        Intrinsics.checkExpressionValueIsNotNull(context, "Objects.requireNonNull(c…, EXCEPTION_CONTEXT_NULL)");
        this.sharedPreferences = new AlSharedPreferences(context);
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE_NAME);
            Intrinsics.checkExpressionValueIsNotNull(keyStore, "KeyStore.getInstance(ANDROID_KEYSTORE_NAME)");
            this.keyStore = keyStore;
            keyStore.load(null);
            generateAesKeystore(STORE_ALIAS, z, keyProp);
        } catch (IOException e) {
            throw new AlSecurityException(e);
        } catch (KeyStoreException e2) {
            throw new AlSecurityException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AlSecurityException(e3);
        } catch (CertificateException e4) {
            throw new AlSecurityException(e4);
        }
    }

    public /* synthetic */ AlKeyManagement(Context context, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) throws AlSecurityException {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? "NoPadding" : str);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean generateKeySecure(@NotNull AlKeyType type, @NotNull String keyReference, boolean requireAuth) throws AlSecurityException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        if (AlKeyType.AES_CBC_256_NO_PADDING == type) {
            generateAesKeystore$default(this, keyReference, requireAuth, null, 4, null);
            return true;
        }
        if (AlKeyType.ECC_ECDH_SPEC256R1 == type) {
            throw new AlSecurityException("Unsupported key type in trusted execution environment");
        }
        AlKeyType alKeyType = AlKeyType.ECC_ECDSA_SPEC256R1;
        if (alKeyType == type) {
            return generateEccKeystore(keyReference, requireAuth, alKeyType.getValue());
        }
        return false;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean generateKey(@NotNull AlKeyType type, @NotNull String keyReference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        if (AlKeyType.AES_CBC_256_NO_PADDING == type) {
            return generateAesSoftware(keyReference);
        }
        AlKeyType alKeyType = AlKeyType.ECC_ECDH_SPEC256R1;
        if (alKeyType == type) {
            return generateEccSoftware(keyReference, alKeyType.getValue());
        }
        AlKeyType alKeyType2 = AlKeyType.ECC_ECDSA_SPEC256R1;
        if (alKeyType2 == type) {
            return generateEccSoftware(keyReference, alKeyType2.getValue());
        }
        return false;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean removeKey(@NotNull String keyReference) throws AlSecurityException, KeyStoreException {
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        removeKeyReference(keyReference);
        return true;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean storeKey(@NotNull byte[] key, @NotNull String reference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        return this.sharedPreferences.storeByteArray(encryptData(key, reference), reference);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean storeKeyPair(@NotNull KeyPair key, @NotNull String reference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        PrivateKey privateKey = key.getPrivate();
        if (privateKey == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
        }
        byte[] byteArray = ((ECPrivateKey) privateKey).getS().toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "(key.private as ECPrivateKey).s.toByteArray()");
        storeKey(byteArray, reference + PRIVATE);
        PublicKey publicKey = key.getPublic();
        if (publicKey == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        }
        storeKey(exportPublicKeyX963Uncompressed((ECPublicKey) publicKey), reference + PUBLIC);
        AlSharedPreferences alSharedPreferences = this.sharedPreferences;
        PublicKey publicKey2 = key.getPublic();
        Intrinsics.checkExpressionValueIsNotNull(publicKey2, "key.public");
        String format = publicKey2.getFormat();
        Intrinsics.checkExpressionValueIsNotNull(format, "key.public.format");
        return alSharedPreferences.storeString(format, reference + FORMAT);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @Nullable
    public SecretKey getKey(@NotNull String reference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        byte[] bArrRetrieveByteArray = this.sharedPreferences.retrieveByteArray(reference);
        if (bArrRetrieveByteArray != null) {
            return new SecretKeySpec(decryptData(bArrRetrieveByteArray, reference), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        }
        return null;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @Nullable
    public SecretKey getKeySecureReference(@NotNull String reference) throws AlSecurityException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        try {
            if (!this.keyStore.isKeyEntry(reference)) {
                return null;
            }
            KeyStore.Entry entry = this.keyStore.getEntry(reference, null);
            if (entry == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.KeyStore.SecretKeyEntry");
            }
            return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        } catch (KeyStoreException e) {
            throw new AlSecurityException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AlSecurityException(e2);
        } catch (UnrecoverableEntryException e3) {
            throw new AlSecurityException(e3);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public KeyPair getKeyPair(@NotNull String keyReference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        byte[] bArrDecryptData = decryptData(this.sharedPreferences.retrieveByteArray(keyReference + PUBLIC), keyReference + PUBLIC);
        byte[] bArrDecryptData2 = decryptData(this.sharedPreferences.retrieveByteArray(keyReference + PRIVATE), keyReference + PRIVATE);
        String strRetrieveString = this.sharedPreferences.retrieveString(keyReference + FORMAT);
        if (bArrDecryptData2 == null || bArrDecryptData == null || strRetrieveString == null) {
            throw new AlSecurityException("Key retrieval failed empty/null: private, public, format or algorithm");
        }
        return generateEcKeyPair(bArrDecryptData, bArrDecryptData2);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @Nullable
    public KeyPair getKeyPairSecureReference(@NotNull String keyReference) throws AlSecurityException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        try {
            if (!this.keyStore.isKeyEntry(keyReference)) {
                return null;
            }
            Certificate certificate = this.keyStore.getCertificate(keyReference);
            Intrinsics.checkExpressionValueIsNotNull(certificate, "this.keyStore.getCertificate(keyReference)");
            PublicKey publicKey = certificate.getPublicKey();
            Key key = this.keyStore.getKey(keyReference, null);
            if (key != null) {
                return new KeyPair(publicKey, (PrivateKey) key);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.PrivateKey");
        } catch (KeyStoreException e) {
            throw new AlSecurityException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AlSecurityException(e2);
        } catch (UnrecoverableEntryException e3) {
            throw new AlSecurityException(e3);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public byte[] exportPublicKeyX963Uncompressed(@NotNull ECPublicKey key) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        ECParameterSpec params = key.getParams();
        Intrinsics.checkExpressionValueIsNotNull(params, "key.params");
        int iBitLength = (params.getOrder().bitLength() + 7) / 8;
        byte[] bArr = new byte[(iBitLength * 2) + 1];
        bArr[0] = 4;
        ECPoint w = key.getW();
        Intrinsics.checkExpressionValueIsNotNull(w, "key.w");
        byte[] byteArray = w.getAffineX().toByteArray();
        if (byteArray.length <= iBitLength) {
            System.arraycopy(byteArray, 0, bArr, (1 + iBitLength) - byteArray.length, byteArray.length);
        } else if (byteArray.length == iBitLength + 1 && byteArray[0] == 0) {
            System.arraycopy(byteArray, 1, bArr, 1, iBitLength);
        } else {
            throw new IllegalStateException("x value is not the correct size");
        }
        int i = 1 + iBitLength;
        ECPoint w2 = key.getW();
        Intrinsics.checkExpressionValueIsNotNull(w2, "key.w");
        byte[] byteArray2 = w2.getAffineY().toByteArray();
        if (byteArray2.length <= iBitLength) {
            System.arraycopy(byteArray2, 0, bArr, (i + iBitLength) - byteArray2.length, byteArray2.length);
        } else if (byteArray2.length == iBitLength + 1 && byteArray2[0] == 0) {
            System.arraycopy(byteArray2, 1, bArr, i, iBitLength);
        } else {
            throw new IllegalStateException("y value is not the correct size");
        }
        return bArr;
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    public boolean containsKeySecureReference(@NotNull String keyReference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(keyReference, "keyReference");
        try {
            return this.keyStore.isKeyEntry(keyReference);
        } catch (KeyStoreException e) {
            throw new AlSecurityException(e);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public byte[] decryptData(@NotNull byte[] data, @NotNull String reference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        return decryptData(data, reference, AlKeyType.AES_CBC_256_NO_PADDING.getValue());
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public byte[] decryptData(@Nullable byte[] data, @Nullable String reference, @NotNull String alKeyType) throws AlSecurityException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, KeyStoreException, UnrecoverableEntryException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(alKeyType, "alKeyType");
        if (data == null || reference == null) {
            throw new AlSecurityException(EXCEPTION_REFERENCE_NULL);
        }
        SecretKey keySecureReference = getKeySecureReference(STORE_ALIAS);
        try {
            Cipher cipher = Cipher.getInstance(alKeyType);
            Intrinsics.checkExpressionValueIsNotNull(cipher, "Cipher.getInstance(alKeyType)");
            cipher.init(2, keySecureReference, new IvParameterSpec(this.sharedPreferences.retrieveByteArray(reference + IV)));
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkExpressionValueIsNotNull(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (InvalidAlgorithmParameterException e) {
            throw new AlSecurityException(e);
        } catch (InvalidKeyException e2) {
            throw new AlSecurityException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AlSecurityException(e3);
        } catch (BadPaddingException e4) {
            throw new AlSecurityException(e4);
        } catch (IllegalBlockSizeException e5) {
            throw new AlSecurityException(e5);
        } catch (NoSuchPaddingException e6) {
            throw new AlSecurityException(e6);
        }
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public byte[] encryptData(@NotNull byte[] data, @NotNull String reference) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        if (data.length % 16 != 0) {
            data = manualPadding(data);
        }
        return encryptData(data, reference, AlKeyType.AES_CBC_256_NO_PADDING.getValue());
    }

    @Override // com.allegion.alsecurity.interfaces.IAlKeyManagement
    @NotNull
    public byte[] encryptData(@Nullable byte[] data, @Nullable String reference, @NotNull String alKeyType) throws AlSecurityException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, KeyStoreException, UnrecoverableEntryException {
        Intrinsics.checkParameterIsNotNull(alKeyType, "alKeyType");
        if (data == null || reference == null) {
            throw new AlSecurityException(EXCEPTION_REFERENCE_NULL);
        }
        SecretKey keySecureReference = getKeySecureReference(STORE_ALIAS);
        try {
            Cipher cipher = Cipher.getInstance(alKeyType);
            cipher.init(1, keySecureReference);
            AlSharedPreferences alSharedPreferences = this.sharedPreferences;
            Intrinsics.checkExpressionValueIsNotNull(cipher, "cipher");
            byte[] iv = cipher.getIV();
            Intrinsics.checkExpressionValueIsNotNull(iv, "cipher.iv");
            alSharedPreferences.storeByteArray(iv, reference + IV);
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkExpressionValueIsNotNull(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        } catch (InvalidKeyException e) {
            throw new AlSecurityException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AlSecurityException(e2);
        } catch (BadPaddingException e3) {
            throw new AlSecurityException(e3);
        } catch (IllegalBlockSizeException e4) {
            throw new AlSecurityException(e4);
        } catch (NoSuchPaddingException e5) {
            throw new AlSecurityException(e5);
        }
    }

    static /* synthetic */ void generateAesKeystore$default(AlKeyManagement alKeyManagement, String str, boolean z, String str2, int i, Object obj) throws AlSecurityException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if ((i & 4) != 0) {
            str2 = "NoPadding";
        }
        alKeyManagement.generateAesKeystore(str, z, str2);
    }

    private final void generateAesKeystore(String aesReference, boolean requireAuthentication, String keyProp) throws AlSecurityException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            if (this.keyStore.containsAlias(aesReference)) {
                return;
            }
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, ANDROID_KEYSTORE_NAME);
                Intrinsics.checkExpressionValueIsNotNull(keyGenerator, "KeyGenerator.getInstance…AME\n                    )");
                try {
                    keyGenerator.init(new KeyGenParameterSpec.Builder(aesReference, 3).setBlockModes("CBC").setUserAuthenticationRequired(requireAuthentication).setEncryptionPaddings(keyProp).build());
                    keyGenerator.generateKey();
                    AlLog.i("AES key generated successfully and loaded into keystore", new Object[0]);
                } catch (InvalidAlgorithmParameterException e) {
                    throw new AlSecurityException(e);
                }
            } catch (NoSuchAlgorithmException e2) {
                throw new AlSecurityException("Failed to get instance of KeyGenerator", e2);
            } catch (NoSuchProviderException e3) {
                throw new AlSecurityException("Failed to get instance of KeyGenerator", e3);
            }
        } catch (KeyStoreException e4) {
            throw new AlSecurityException(e4);
        }
    }

    private final boolean generateAesSoftware(String referenceId) throws AlSecurityException, NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            Intrinsics.checkExpressionValueIsNotNull(secretKey, "secretKey");
            byte[] encoded = secretKey.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(encoded, "secretKey.encoded");
            storeKey(encoded, referenceId);
            return true;
        } catch (NoSuchAlgorithmException e) {
            throw new AlSecurityException(e);
        }
    }

    private final boolean generateEccKeystore(String eccReference, boolean requireAuthentication, String curve) throws AlSecurityException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            if (this.keyStore.containsAlias(eccReference)) {
                return false;
            }
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", ANDROID_KEYSTORE_NAME);
            Intrinsics.checkExpressionValueIsNotNull(keyPairGenerator, "KeyPairGenerator.getInst…RE_NAME\n                )");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(eccReference, 4).setAlgorithmParameterSpec(new ECGenParameterSpec(curve)).setDigests("SHA-256", "SHA-384", "SHA-512").setUserAuthenticationRequired(requireAuthentication).setUserAuthenticationValidityDurationSeconds(Integer.MAX_VALUE).build());
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (InvalidAlgorithmParameterException e) {
            throw new AlSecurityException(e);
        } catch (KeyStoreException e2) {
            throw new AlSecurityException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AlSecurityException(e3);
        } catch (NoSuchProviderException e4) {
            throw new AlSecurityException(e4);
        }
    }

    private final boolean generateEccSoftware(String eccReference, String curve) throws AlSecurityException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ECGenParameterSpec eCGenParameterSpec = new ECGenParameterSpec(curve);
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            Intrinsics.checkExpressionValueIsNotNull(keyPairGenerator, "KeyPairGenerator.getInstance(\"EC\")");
            keyPairGenerator.initialize(eCGenParameterSpec);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            Intrinsics.checkExpressionValueIsNotNull(keyPair, "keyPair");
            storeKeyPair(keyPair, eccReference);
            return true;
        } catch (InvalidAlgorithmParameterException e) {
            throw new AlSecurityException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AlSecurityException(e2);
        }
    }

    private final void removeKeyReference(String reference) throws AlSecurityException, KeyStoreException {
        try {
            if (this.keyStore.isKeyEntry(reference)) {
                this.keyStore.deleteEntry(reference);
                return;
            }
            this.sharedPreferences.removeData(reference + PUBLIC);
            this.sharedPreferences.removeData(reference + PRIVATE);
            this.sharedPreferences.removeData(reference + PUBLIC + IV);
            this.sharedPreferences.removeData(reference + PRIVATE + IV);
            this.sharedPreferences.removeData(reference + FORMAT);
            this.sharedPreferences.removeData(reference + ALGORITHM);
            this.sharedPreferences.removeData(reference);
            this.sharedPreferences.removeData(reference + IV);
        } catch (KeyStoreException e) {
            throw new AlSecurityException(e);
        }
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

    @NotNull
    public final KeyPair generateEcKeyPair(@NotNull byte[] publicKey, @NotNull byte[] privateKey) throws AlSecurityException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
        Intrinsics.checkParameterIsNotNull(privateKey, "privateKey");
        if (publicKey.length == 0 || privateKey.length == 0) {
            throw new AlSecurityException("Null keys or invalid length");
        }
        byte[] bArrCopyOf = Arrays.copyOf(publicKey, 65);
        Intrinsics.checkExpressionValueIsNotNull(bArrCopyOf, "Arrays.copyOf(publicKey, 65)");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(privateKey, 0, Math.min(33, privateKey.length));
        Intrinsics.checkExpressionValueIsNotNull(bArrCopyOfRange, "Arrays.copyOfRange(priva…min(33, privateKey.size))");
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            Intrinsics.checkExpressionValueIsNotNull(keyPairGenerateKeyPair, "kg.generateKeyPair()");
            PublicKey publicKey2 = keyPairGenerateKeyPair.getPublic();
            if (publicKey2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
            }
            ECParameterSpec ecParameterSpec = ((ECPublicKey) publicKey2).getParams();
            Intrinsics.checkExpressionValueIsNotNull(ecParameterSpec, "ecParameterSpec");
            ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(ECPointUtil.decodePoint(ecParameterSpec.getCurve(), bArrCopyOf), ecParameterSpec);
            ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(new BigInteger(bArrCopyOfRange), ecParameterSpec);
            PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(eCPublicKeySpec);
            if (publicKeyGeneratePublic == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
            }
            ECPublicKey eCPublicKey = (ECPublicKey) publicKeyGeneratePublic;
            PrivateKey privateKeyGeneratePrivate = keyFactory.generatePrivate(eCPrivateKeySpec);
            if (privateKeyGeneratePrivate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
            }
            return new KeyPair(eCPublicKey, (ECPrivateKey) privateKeyGeneratePrivate);
        } catch (NoSuchAlgorithmException e) {
            throw new AlSecurityException(e);
        } catch (InvalidKeySpecException e2) {
            throw new AlSecurityException(e2);
        } catch (InvalidParameterSpecException e3) {
            throw new AlSecurityException(e3);
        }
    }
}
