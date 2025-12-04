package com.allegion.alsecurity;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlEcc;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001f"}, d2 = {"Lcom/allegion/alsecurity/AlEcc;", "Lcom/allegion/alsecurity/interfaces/IAlEcc;", "()V", "decrypt", "", "publicKey", "Ljava/security/PublicKey;", "privateKey", "Ljava/security/PrivateKey;", "data", "encodeEccPublicKey", "Ljava/security/interfaces/ECPublicKey;", "eccPublicKey", "encrypt", "generateAesKeyFromEcdh", "Ljavax/crypto/SecretKey;", "publicKeyReceived", "privateKeyLocal", "otherInfo", "sign", "key", "signPayload", "payload", "signatureType", "", "verify", "", AlCBORMessage.SIGNATURE, "verifyPayload", "signedData", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlEcc implements IAlEcc {
    private static final String ECDSA_256_SIG = "SHA256withECDSA";
    private static final String INVALID_PARAMS = "Invalid input parameters";
    private static final String INVALID_KEY_TYPE = "Invalid key type, only EC supported.";
    private static final String EC_ALGORITHM = "EC";

    @Override // com.allegion.alsecurity.interfaces.IAlEcc
    @NotNull
    public byte[] decrypt(@NotNull PublicKey publicKey, @NotNull PrivateKey privateKey, @NotNull byte[] data) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
        Intrinsics.checkParameterIsNotNull(privateKey, "privateKey");
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (publicKey.getAlgorithm() == null) {
            throw new AlSecurityException(INVALID_PARAMS);
        }
        if (!Intrinsics.areEqual(publicKey.getAlgorithm(), EC_ALGORITHM)) {
            throw new AlSecurityException(INVALID_KEY_TYPE);
        }
        return new AlAes().decrypt(generateAesKeyFromEcdh(publicKey, privateKey), data, AlPaddingType.PKCS7_PADDING, null);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlEcc
    @NotNull
    public byte[] encrypt(@NotNull PublicKey publicKey, @NotNull PrivateKey privateKey, @NotNull byte[] data) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
        Intrinsics.checkParameterIsNotNull(privateKey, "privateKey");
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (publicKey.getAlgorithm() == null) {
            throw new AlSecurityException(INVALID_PARAMS);
        }
        if (!Intrinsics.areEqual(publicKey.getAlgorithm(), EC_ALGORITHM)) {
            throw new AlSecurityException(INVALID_KEY_TYPE);
        }
        return new AlAes().encrypt(generateAesKeyFromEcdh(publicKey, privateKey), data, AlPaddingType.PKCS7_PADDING, null);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlEcc
    @NotNull
    public byte[] sign(@NotNull PrivateKey key, @NotNull byte[] data) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (key.getAlgorithm() == null) {
            throw new AlSecurityException(INVALID_PARAMS);
        }
        if (Intrinsics.areEqual(key.getAlgorithm(), EC_ALGORITHM)) {
            try {
                return signPayload(data, key, ECDSA_256_SIG);
            } catch (Exception e) {
                throw new AlSecurityException(e);
            }
        }
        throw new AlSecurityException(INVALID_KEY_TYPE);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlEcc
    public boolean verify(@NotNull PublicKey key, @NotNull byte[] data, @NotNull byte[] signature) throws AlSecurityException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        if (key.getAlgorithm() == null) {
            throw new AlSecurityException(INVALID_PARAMS);
        }
        if (Intrinsics.areEqual(key.getAlgorithm(), EC_ALGORITHM)) {
            try {
                return verifyPayload(data, signature, key, ECDSA_256_SIG);
            } catch (Exception e) {
                throw new AlSecurityException(e);
            }
        }
        throw new AlSecurityException(INVALID_KEY_TYPE);
    }

    @Override // com.allegion.alsecurity.interfaces.IAlEcc
    @NotNull
    public ECPublicKey encodeEccPublicKey(@NotNull byte[] eccPublicKey) throws AlSecurityException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(eccPublicKey, "eccPublicKey");
        try {
            byte[] bArrCopyOf = Arrays.copyOf(eccPublicKey, 65);
            Intrinsics.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            Intrinsics.checkExpressionValueIsNotNull(keyPairGenerateKeyPair, "kg.generateKeyPair()");
            PublicKey publicKey = keyPairGenerateKeyPair.getPublic();
            if (publicKey == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
            }
            ECParameterSpec ecParameterSpec = ((ECPublicKey) publicKey).getParams();
            Intrinsics.checkExpressionValueIsNotNull(ecParameterSpec, "ecParameterSpec");
            PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new ECPublicKeySpec(ECPointUtil.decodePoint(ecParameterSpec.getCurve(), bArrCopyOf), ecParameterSpec));
            if (publicKeyGeneratePublic != null) {
                return (ECPublicKey) publicKeyGeneratePublic;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        } catch (Exception e) {
            throw new AlSecurityException(e);
        }
    }

    private final byte[] signPayload(byte[] payload, PrivateKey key, String signatureType) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(signatureType);
        signature.initSign(key);
        signature.update(payload);
        byte[] bArrSign = signature.sign();
        Intrinsics.checkExpressionValueIsNotNull(bArrSign, "signature.sign()");
        return bArrSign;
    }

    private final boolean verifyPayload(byte[] data, byte[] signedData, PublicKey key, String signatureType) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(signatureType);
        signature.initVerify(key);
        signature.update(data);
        return signature.verify(signedData);
    }

    @NotNull
    public final SecretKey generateAesKeyFromEcdh(@NotNull PublicKey publicKeyReceived, @NotNull PrivateKey privateKeyLocal) throws IllegalStateException, AlSecurityException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkParameterIsNotNull(publicKeyReceived, "publicKeyReceived");
        Intrinsics.checkParameterIsNotNull(privateKeyLocal, "privateKeyLocal");
        try {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
            Intrinsics.checkExpressionValueIsNotNull(keyAgreement, "KeyAgreement.getInstance(\"ECDH\")");
            keyAgreement.init(privateKeyLocal);
            keyAgreement.doPhase(publicKeyReceived, true);
            byte[] bArrGenerateSecret = keyAgreement.generateSecret();
            Intrinsics.checkExpressionValueIsNotNull(bArrGenerateSecret, "keyAgreement.generateSecret()");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArrGenerateSecret);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkExpressionValueIsNotNull(bArrDigest, "hash.digest()");
            return new SecretKeySpec(bArrDigest, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (Exception e) {
            throw new AlSecurityException(e);
        }
    }

    @NotNull
    public final SecretKey generateAesKeyFromEcdh(@NotNull PublicKey publicKeyReceived, @NotNull PrivateKey privateKeyLocal, @NotNull byte[] otherInfo) throws IllegalStateException, AlSecurityException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkParameterIsNotNull(publicKeyReceived, "publicKeyReceived");
        Intrinsics.checkParameterIsNotNull(privateKeyLocal, "privateKeyLocal");
        Intrinsics.checkParameterIsNotNull(otherInfo, "otherInfo");
        byte[] counter = Hex.decode("00000001");
        try {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
            Intrinsics.checkExpressionValueIsNotNull(keyAgreement, "KeyAgreement.getInstance(\"ECDH\")");
            keyAgreement.init(privateKeyLocal);
            keyAgreement.doPhase(publicKeyReceived, true);
            byte[] bArrGenerateSecret = keyAgreement.generateSecret();
            Intrinsics.checkExpressionValueIsNotNull(bArrGenerateSecret, "keyAgreement.generateSecret()");
            Intrinsics.checkExpressionValueIsNotNull(counter, "counter");
            byte[] bArrPlus = ArraysKt.plus(ArraysKt.plus(counter, bArrGenerateSecret), otherInfo);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArrPlus);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkExpressionValueIsNotNull(bArrDigest, "hash.digest()");
            return new SecretKeySpec(bArrDigest, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (Exception e) {
            throw new AlSecurityException(e);
        }
    }
}
