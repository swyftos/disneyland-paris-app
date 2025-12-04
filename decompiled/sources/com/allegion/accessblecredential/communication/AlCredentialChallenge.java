package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.accessblecredential.utility.AlDeviceStorage;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.AlEcc;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b)\u0010*B)\b\u0016\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010 \u001a\u00020\u0016¢\u0006\u0004\b)\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b)\u0010/J)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0015R\u0016\u0010 \u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010#R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlCredentialChallenge;", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", AlCBORMessage.NONCE, AlCBORMessage.DEVICE_AUTH_KEY, "Ljavax/crypto/SecretKey;", "sessionKey", "encryptedPayload", "([B[BLjavax/crypto/SecretKey;)[B", "", "Lcom/allegion/accessblecredential/communication/AlSignatures;", AlCBORMessage.SIGNATURES, "", "validatePinnedDevices", "([B[Lcom/allegion/accessblecredential/communication/AlSignatures;)Z", "getCbor", "(Ljavax/crypto/SecretKey;)[B", "value", AlCBORMessage.ENC_PAYLOAD, "[B", "setEncPayload", "([B)V", "", AlCBORMessage.GEN_MSG_TYPE, "Ljava/lang/String;", "getGenMsgType$AccessBleCredential_release", "()Ljava/lang/String;", "setGenMsgType$AccessBleCredential_release", "(Ljava/lang/String;)V", "getNonce$AccessBleCredential_release", "()[B", "setNonce$AccessBleCredential_release", "serialNumber", "getDevAuthKey$AccessBleCredential_release", "setDevAuthKey$AccessBleCredential_release", "Ljavax/crypto/SecretKey;", "[Lcom/allegion/accessblecredential/communication/AlSignatures;", "getSignatures$AccessBleCredential_release", "()[Lcom/allegion/accessblecredential/communication/AlSignatures;", "setSignatures$AccessBleCredential_release", "([Lcom/allegion/accessblecredential/communication/AlSignatures;)V", "<init>", "()V", "cbor", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "version", "([BLjavax/crypto/SecretKey;Lcom/allegion/accessblecredential/enums/AlProtocolVersion;Ljava/lang/String;)V", "([B[B)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlCredentialChallenge extends AlCBORMessage {

    @Nullable
    private byte[] devAuthKey;
    private byte[] encPayload;

    @NotNull
    public String genMsgType;

    @NotNull
    public byte[] nonce;
    private String serialNumber;
    private SecretKey sessionKey;

    @Nullable
    private AlSignatures[] signatures;

    public AlCredentialChallenge() throws AlBleComponentException {
        super(null, 1, null);
    }

    private final byte[] encryptedPayload(byte[] nonce, byte[] devAuthKey, SecretKey sessionKey) throws AlBleComponentException {
        AlCborUtility alCborUtility = new AlCborUtility();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            CBORGenerator cborGenerator = alCborUtility.getCborGenerator(byteArrayOutputStream);
            if (devAuthKey != null) {
                cborGenerator.writeStartObject(3);
                cborGenerator.writeBinaryField(AlCBORMessage.SESSION_NONCE, nonce);
                cborGenerator.writeBinaryField(AlCBORMessage.DEVICE_AUTH_KEY, devAuthKey);
            } else {
                cborGenerator.writeStartObject(2);
                cborGenerator.writeBinaryField(AlCBORMessage.SESSION_NONCE, nonce);
            }
            cborGenerator.writeFieldName(AlCBORMessage.MAX_SIZE);
            cborGenerator.writeNumber(1024);
            cborGenerator.writeEndObject();
            cborGenerator.close();
            byte[] unencryptedCBOR = byteArrayOutputStream.toByteArray();
            try {
                AlAes alAes = new AlAes();
                Intrinsics.checkExpressionValueIsNotNull(unencryptedCBOR, "unencryptedCBOR");
                return alAes.encrypt(sessionKey, unencryptedCBOR, AlPaddingType.PKCS7_PADDING, null);
            } catch (AlSecurityException e) {
                throw new AlBleComponentException(e);
            }
        } catch (AlTranslationComponentException e2) {
            throw new AlBleComponentException(e2);
        } catch (IOException e3) {
            throw new AlBleComponentException(e3);
        }
    }

    private final void setEncPayload(byte[] bArr) throws AlBleComponentException {
        byte[] bArrDecrypt;
        if (bArr != null) {
            try {
                AlAes alAes = new AlAes();
                SecretKey secretKey = this.sessionKey;
                if (secretKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionKey");
                }
                bArrDecrypt = alAes.decrypt(secretKey, bArr, AlPaddingType.PKCS7_PADDING, null);
            } catch (AlSecurityException e) {
                throw new AlBleComponentException(e);
            } catch (AlTranslationComponentException e2) {
                throw new AlBleComponentException(e2);
            }
        } else {
            bArrDecrypt = null;
        }
        AlCredentialChallengeResultPayload alCredentialChallengeResultPayload = (AlCredentialChallengeResultPayload) (bArrDecrypt != null ? getCborUtility().fromCbor(bArrDecrypt, AlCredentialChallengeResultPayload.class) : null);
        if (alCredentialChallengeResultPayload == null) {
            Intrinsics.throwNpe();
        }
        byte[] bArr2 = alCredentialChallengeResultPayload.sNonce;
        Intrinsics.checkExpressionValueIsNotNull(bArr2, "resultPayload!!.sNonce");
        this.nonce = bArr2;
        this.devAuthKey = alCredentialChallengeResultPayload.devAuthKey;
        this.encPayload = bArr;
    }

    private final boolean validatePinnedDevices(byte[] devAuthKey, AlSignatures[] signatures) throws AlBleComponentException, AlSecurityException, AlTranslationComponentException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (getProtocolVersion() == AlProtocolVersion.PLATINUM_V1) {
            return true;
        }
        if (devAuthKey != null && signatures != null) {
            if (!(signatures.length == 0)) {
                byte[] signature = null;
                for (AlSignatures alSignatures : signatures) {
                    if (Intrinsics.areEqual(alSignatures.getKeyId(), AlCBORMessage.DEVICE_AUTH_SIG)) {
                        signature = alSignatures.getSignature();
                    }
                }
                ECPublicKey eCPublicKeyEncodeEccPublicKey = new AlEcc().encodeEccPublicKey(devAuthKey);
                if (signature == null || eCPublicKeyEncodeEccPublicKey == null) {
                    throw new AlBleComponentException("Invalid data for protocol version");
                }
                Pair pair = new Pair(signature, eCPublicKeyEncodeEccPublicKey);
                byte[] bArr = this.encPayload;
                if (bArr != null) {
                    AlBLEConfigUtility alBLEConfigUtility = AlBLEConfigUtility.INSTANCE;
                    AlDeviceStorage deviceStorage = alBLEConfigUtility.getDeviceStorage();
                    String str = this.serialNumber;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serialNumber");
                    }
                    Pair<String, String> pairRetrieveDeviceBySerial = deviceStorage.retrieveDeviceBySerial(str);
                    if (!new AlEcc().verify((PublicKey) pair.getSecond(), bArr, (byte[]) pair.getFirst())) {
                        return false;
                    }
                    if (pairRetrieveDeviceBySerial != null) {
                        return Intrinsics.areEqual(Hex.toHexString(devAuthKey), pairRetrieveDeviceBySerial.getSecond());
                    }
                    if (alBLEConfigUtility.getDeviceStorage().retrieveDeviceByPin(devAuthKey) != null) {
                        return false;
                    }
                    AlDeviceStorage deviceStorage2 = alBLEConfigUtility.getDeviceStorage();
                    String str2 = this.serialNumber;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serialNumber");
                    }
                    return deviceStorage2.storeDevicePin(str2, devAuthKey);
                }
            }
        }
        return false;
    }

    @NotNull
    public final byte[] getCbor(@NotNull SecretKey sessionKey) throws AlBleComponentException, AlSecurityException {
        Intrinsics.checkParameterIsNotNull(sessionKey, "sessionKey");
        try {
            if (this.devAuthKey != null) {
                getGenerator().writeStartObject(3);
                getGenerator().writeStringField(AlCBORMessage.GEN_MSG_TYPE, AlCBORMessage.CHALLENGE_MSG);
                byte[] bArr = this.nonce;
                if (bArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.NONCE);
                }
                byte[] bArrEncryptedPayload = bArr != null ? encryptedPayload(bArr, this.devAuthKey, sessionKey) : null;
                getGenerator().writeBinaryField(AlCBORMessage.ENC_PAYLOAD, bArrEncryptedPayload);
                getGenerator().writeFieldName(AlCBORMessage.SIGNATURES);
                getGenerator().writeStartArray(1);
                getGenerator().writeStartObject(2);
                getGenerator().writeStringField(AlCBORMessage.KEY_ID, AlCBORMessage.DEVICE_AUTH_SIG);
                if (bArrEncryptedPayload != null) {
                    AlEcc alEcc = new AlEcc();
                    PrivateKey privateKey = AlBLEConfigUtility.INSTANCE.getDeviceKey().getPrivate();
                    Intrinsics.checkExpressionValueIsNotNull(privateKey, "AlBLEConfigUtility.deviceKey.private");
                    bArrSign = alEcc.sign(privateKey, bArrEncryptedPayload);
                }
                getGenerator().writeBinaryField(AlCBORMessage.SIGNATURE, bArrSign);
                getGenerator().writeEndObject();
                getGenerator().writeEndArray();
            } else {
                getGenerator().writeStartObject(2);
                getGenerator().writeStringField(AlCBORMessage.GEN_MSG_TYPE, AlCBORMessage.CHALLENGE_MSG);
                byte[] bArr2 = this.nonce;
                if (bArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.NONCE);
                }
                getGenerator().writeBinaryField(AlCBORMessage.ENC_PAYLOAD, bArr2 != null ? encryptedPayload(bArr2, this.devAuthKey, sessionKey) : null);
            }
            getGenerator().writeEndObject();
            getGenerator().close();
            byte[] byteArray = getStream().toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "stream.toByteArray()");
            return byteArray;
        } catch (IOException e) {
            throw new AlBleComponentException(e);
        }
    }

    @Nullable
    /* renamed from: getDevAuthKey$AccessBleCredential_release, reason: from getter */
    public final byte[] getDevAuthKey() {
        return this.devAuthKey;
    }

    @NotNull
    public final String getGenMsgType$AccessBleCredential_release() {
        String str = this.genMsgType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.GEN_MSG_TYPE);
        }
        return str;
    }

    @NotNull
    public final byte[] getNonce$AccessBleCredential_release() {
        byte[] bArr = this.nonce;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.NONCE);
        }
        return bArr;
    }

    @Nullable
    /* renamed from: getSignatures$AccessBleCredential_release, reason: from getter */
    public final AlSignatures[] getSignatures() {
        return this.signatures;
    }

    public final void setDevAuthKey$AccessBleCredential_release(@Nullable byte[] bArr) {
        this.devAuthKey = bArr;
    }

    public final void setGenMsgType$AccessBleCredential_release(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.genMsgType = str;
    }

    public final void setNonce$AccessBleCredential_release(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.nonce = bArr;
    }

    public final void setSignatures$AccessBleCredential_release(@Nullable AlSignatures[] alSignaturesArr) {
        this.signatures = alSignaturesArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlCredentialChallenge(@NotNull byte[] cbor, @NotNull SecretKey sessionKey, @NotNull AlProtocolVersion version, @NotNull String serialNumber) throws AlBleComponentException, AlTranslationComponentException {
        super(null, 1, null);
        Intrinsics.checkParameterIsNotNull(cbor, "cbor");
        Intrinsics.checkParameterIsNotNull(sessionKey, "sessionKey");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        this.sessionKey = sessionKey;
        this.serialNumber = serialNumber;
        Object objFromCbor = getCborUtility().fromCbor(cbor, AlCredentialChallengeResult.class);
        if (objFromCbor == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessblecredential.communication.AlCredentialChallengeResult");
        }
        AlCredentialChallengeResult alCredentialChallengeResult = (AlCredentialChallengeResult) objFromCbor;
        String str = alCredentialChallengeResult.genMsgType;
        Intrinsics.checkExpressionValueIsNotNull(str, "challengeObj.genMsgType");
        this.genMsgType = str;
        setEncPayload(alCredentialChallengeResult.encPayload);
        this.signatures = alCredentialChallengeResult.signatures;
        setProtocolVersion$AccessBleCredential_release(version);
        if (!validatePinnedDevices(this.devAuthKey, this.signatures)) {
            throw new AlBleComponentException("Validation failed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlCredentialChallenge(@NotNull byte[] nonce) throws AlBleComponentException {
        super(null, 1, null);
        Intrinsics.checkParameterIsNotNull(nonce, "nonce");
        if (nonce.length == 12) {
            this.nonce = nonce;
            return;
        }
        throw new IllegalArgumentException("Null session key or invalid nonce length of should be 12.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlCredentialChallenge(@NotNull byte[] nonce, @NotNull byte[] devAuthKey) throws AlBleComponentException {
        super(null, 1, null);
        Intrinsics.checkParameterIsNotNull(nonce, "nonce");
        Intrinsics.checkParameterIsNotNull(devAuthKey, "devAuthKey");
        if (nonce.length == 12) {
            this.nonce = nonce;
            this.devAuthKey = devAuthKey;
            return;
        }
        throw new IllegalArgumentException("Null session key or invalid nonce length of should be 12.");
    }
}
