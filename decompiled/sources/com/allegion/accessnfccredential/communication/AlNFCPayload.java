package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.AlEcc;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0003X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0004R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlNFCPayload;", "Ljava/io/Serializable;", "rawPayload", "", "([B)V", "algorithmName", "cborUtility", "Lcom/allegion/altranslation/AlCborUtility;", "cloudPartyName", "cloudPublicKey", "Ljava/security/interfaces/ECPublicKey;", "credential", "getCredential$AccessNFCCredential_release", "()[B", "setCredential$AccessNFCCredential_release", "credentialCMAC", "getCredentialCMAC$AccessNFCCredential_release", "setCredentialCMAC$AccessNFCCredential_release", "value", AlCBORMessage.ENC_PAYLOAD, "setEncPayload", "payload", "getPayload$AccessNFCCredential_release", "sdkPartyName", "sessionKey", "Ljavax/crypto/SecretKey;", "Companion", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlNFCPayload implements Serializable {

    @NotNull
    public static final String CRED_CMAC = "nfcCredCmac";
    private final byte[] algorithmName;
    private final AlCborUtility cborUtility;
    private final byte[] cloudPartyName;
    private final ECPublicKey cloudPublicKey;

    @NotNull
    public byte[] credential;

    @NotNull
    public byte[] credentialCMAC;
    private byte[] encPayload;

    @NotNull
    private final byte[] payload;
    private final byte[] sdkPartyName;
    private final SecretKey sessionKey;

    public AlNFCPayload(@NotNull byte[] rawPayload) throws AlNFCComponentException, AlSecurityException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(rawPayload, "rawPayload");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "aes128-cbc".getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        this.algorithmName = bytes;
        AlCborUtility alCborUtility = new AlCborUtility();
        this.cborUtility = alCborUtility;
        byte[] bytes2 = "Allegion.KeyManagement".getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
        this.cloudPartyName = bytes2;
        byte[] bytes3 = "MobileApp".getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes3, "(this as java.lang.String).getBytes(charset)");
        this.sdkPartyName = bytes3;
        this.payload = rawPayload;
        try {
            Object objFromCbor = alCborUtility.fromCbor(rawPayload, AlNFCPayloadMap.class);
            if (objFromCbor == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessnfccredential.communication.AlNFCPayloadMap");
            }
            AlNFCPayloadMap alNFCPayloadMap = (AlNFCPayloadMap) objFromCbor;
            if (alNFCPayloadMap.isInitialized()) {
                ECPublicKey eCPublicKeyEncodeEccPublicKey = new AlEcc().encodeEccPublicKey(alNFCPayloadMap.getTmpKey());
                this.cloudPublicKey = eCPublicKeyEncodeEccPublicKey;
                SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(eCPublicKeyEncodeEccPublicKey.getEncoded());
                Intrinsics.checkExpressionValueIsNotNull(subjectPublicKeyInfo, "SubjectPublicKeyInfo.get…e(cloudPublicKey.encoded)");
                DERBitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
                Intrinsics.checkExpressionValueIsNotNull(publicKeyData, "SubjectPublicKeyInfo.get…ey.encoded).publicKeyData");
                byte[] cloudPublicKeyByteArray = publicKeyData.getBytes();
                AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
                PublicKey publicKey = alNFCConfigUtility.getDeviceKey().getPublic();
                Intrinsics.checkExpressionValueIsNotNull(publicKey, "AlNFCConfigUtility.deviceKey.public");
                SubjectPublicKeyInfo subjectPublicKeyInfo2 = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
                Intrinsics.checkExpressionValueIsNotNull(subjectPublicKeyInfo2, "SubjectPublicKeyInfo.get…deviceKey.public.encoded)");
                DERBitString publicKeyData2 = subjectPublicKeyInfo2.getPublicKeyData();
                Intrinsics.checkExpressionValueIsNotNull(publicKeyData2, "SubjectPublicKeyInfo.get…ic.encoded).publicKeyData");
                byte[] devicePublicKeyByteArray = publicKeyData2.getBytes();
                AlEcc alEcc = new AlEcc();
                PrivateKey privateKey = alNFCConfigUtility.getDeviceKey().getPrivate();
                Intrinsics.checkExpressionValueIsNotNull(privateKey, "AlNFCConfigUtility.deviceKey.private");
                byte[] bArrPlus = ArraysKt.plus(ArraysKt.plus(bytes2, bytes3), bytes);
                Intrinsics.checkExpressionValueIsNotNull(cloudPublicKeyByteArray, "cloudPublicKeyByteArray");
                byte[] bArrPlus2 = ArraysKt.plus(bArrPlus, cloudPublicKeyByteArray);
                Intrinsics.checkExpressionValueIsNotNull(devicePublicKeyByteArray, "devicePublicKeyByteArray");
                this.sessionKey = alEcc.generateAesKeyFromEcdh(eCPublicKeyEncodeEccPublicKey, privateKey, ArraysKt.plus(bArrPlus2, devicePublicKeyByteArray));
                setEncPayload(alNFCPayloadMap.getEncPayload());
                return;
            }
            throw new AlNFCComponentException("Invalid payload");
        } catch (AlTranslationComponentException e) {
            throw new AlNFCComponentException(e);
        }
    }

    private final void setEncPayload(byte[] bArr) throws AlNFCComponentException {
        byte[] bArrDecrypt;
        if (bArr != null) {
            try {
                bArrDecrypt = new AlAes().decrypt(this.sessionKey, bArr, AlPaddingType.PKCS7_PADDING, null);
            } catch (AlSecurityException e) {
                throw new AlNFCComponentException(e);
            } catch (AlTranslationComponentException e2) {
                throw new AlNFCComponentException(e2);
            }
        } else {
            bArrDecrypt = null;
        }
        Object objFromCbor = bArrDecrypt != null ? this.cborUtility.fromCbor(bArrDecrypt, AlNFCInnerPayloadMap.class) : null;
        if (objFromCbor == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessnfccredential.communication.AlNFCInnerPayloadMap");
        }
        AlNFCInnerPayloadMap alNFCInnerPayloadMap = (AlNFCInnerPayloadMap) objFromCbor;
        AlNFCConfigUtility alNFCConfigUtility = AlNFCConfigUtility.INSTANCE;
        alNFCConfigUtility.setKd(alNFCInnerPayloadMap.getDiversifiedKey());
        alNFCConfigUtility.setKd_div(alNFCInnerPayloadMap.getDiversifiedKeyInput());
        this.credential = alNFCInnerPayloadMap.getEncCardData();
        for (AlSignatureMap alSignatureMap : alNFCInnerPayloadMap.getSignatures()) {
            if (Intrinsics.areEqual(alSignatureMap.getKeyId(), CRED_CMAC)) {
                this.credentialCMAC = alSignatureMap.getSignature();
            }
        }
        this.encPayload = bArr;
    }

    @NotNull
    public final byte[] getCredential$AccessNFCCredential_release() {
        byte[] bArr = this.credential;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credential");
        }
        return bArr;
    }

    public final void setCredential$AccessNFCCredential_release(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.credential = bArr;
    }

    @NotNull
    public final byte[] getCredentialCMAC$AccessNFCCredential_release() {
        byte[] bArr = this.credentialCMAC;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credentialCMAC");
        }
        return bArr;
    }

    public final void setCredentialCMAC$AccessNFCCredential_release(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.credentialCMAC = bArr;
    }

    @NotNull
    /* renamed from: getPayload$AccessNFCCredential_release, reason: from getter */
    public final byte[] getPayload() {
        return this.payload;
    }
}
