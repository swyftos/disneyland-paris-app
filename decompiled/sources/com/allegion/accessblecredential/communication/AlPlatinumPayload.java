package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.AlEcc;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\t\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlPlatinumPayload;", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", "cloudBlob", AlCBORMessage.NONCE, "generateEncryptedCredPayload", "([B[B)[B", "getCbor", "()[B", "cbor", AlCBORMessage.SESSION_NONCE, "[B", "Lcom/allegion/alsecurity/AlEcc;", "alEcc", "Lcom/allegion/alsecurity/AlEcc;", "credPayload", "Ljavax/crypto/SecretKey;", "sessionKey", "Ljavax/crypto/SecretKey;", "<init>", "([B[BLjavax/crypto/SecretKey;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlPlatinumPayload extends AlCBORMessage {
    private final AlEcc alEcc;
    private final byte[] credPayload;
    private final byte[] sNonce;
    private final SecretKey sessionKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlPlatinumPayload(@NotNull byte[] credPayload, @NotNull byte[] sNonce, @NotNull SecretKey sessionKey) throws AlBleComponentException {
        super(null, 1, null);
        Intrinsics.checkParameterIsNotNull(credPayload, "credPayload");
        Intrinsics.checkParameterIsNotNull(sNonce, "sNonce");
        Intrinsics.checkParameterIsNotNull(sessionKey, "sessionKey");
        this.credPayload = credPayload;
        this.sNonce = sNonce;
        this.sessionKey = sessionKey;
        this.alEcc = new AlEcc();
    }

    private final byte[] generateEncryptedCredPayload(byte[] cloudBlob, byte[] nonce) throws AlTranslationComponentException, AlSecurityException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CBORGenerator cborGenerator = getCborUtility().getCborGenerator(byteArrayOutputStream);
        cborGenerator.writeStartObject(2);
        cborGenerator.writeBinaryField(AlCBORMessage.SESSION_NONCE, nonce);
        cborGenerator.writeBinaryField(AlCBORMessage.CRED_BLOB, cloudBlob);
        cborGenerator.writeEndObject();
        cborGenerator.close();
        byte[] payload = byteArrayOutputStream.toByteArray();
        AlAes alAes = new AlAes();
        SecretKey secretKey = this.sessionKey;
        Intrinsics.checkExpressionValueIsNotNull(payload, "payload");
        return alAes.encrypt(secretKey, payload, AlPaddingType.PKCS7_PADDING, null);
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartObject(3);
            getGenerator().writeStringField(AlCBORMessage.GEN_MSG_TYPE, AlCBORMessage.SIGNED_CMD);
            byte[] bArrGenerateEncryptedCredPayload = generateEncryptedCredPayload(this.credPayload, this.sNonce);
            getGenerator().writeBinaryField(AlCBORMessage.ENC_PAYLOAD, bArrGenerateEncryptedCredPayload);
            getGenerator().writeFieldName(AlCBORMessage.SIGNATURES);
            getGenerator().writeStartArray(1);
            getGenerator().writeStartObject(2);
            getGenerator().writeStringField(AlCBORMessage.KEY_ID, AlCBORMessage.MOBILE_SIG);
            AlEcc alEcc = this.alEcc;
            PrivateKey privateKey = AlBLEConfigUtility.INSTANCE.getDeviceKey().getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey, "AlBLEConfigUtility.deviceKey.private");
            getGenerator().writeBinaryField(AlCBORMessage.SIGNATURE, alEcc.sign(privateKey, bArrGenerateEncryptedCredPayload));
            getGenerator().writeEndObject();
            getGenerator().writeEndArray();
            getGenerator().writeEndObject();
            getGenerator().close();
            byte[] byteArray = getStream().toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "stream.toByteArray()");
            return byteArray;
        } catch (AlSecurityException e) {
            throw new AlBleComponentException(e);
        } catch (AlTranslationComponentException e2) {
            throw new AlBleComponentException(e2);
        } catch (IOException e3) {
            throw new AlBleComponentException(e3);
        }
    }
}
