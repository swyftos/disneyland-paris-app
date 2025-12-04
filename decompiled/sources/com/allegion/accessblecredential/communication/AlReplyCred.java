package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.enums.AlReply;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.alsecurity.AlAes;
import com.allegion.alsecurity.enums.AlPaddingType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlAes;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.interfaces.IAlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.allegion.logging.AlLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlReplyCred;", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "Ljavax/crypto/SecretKey;", "sessionKey", "Lcom/allegion/accessblecredential/enums/AlReply;", "getResult", "(Ljavax/crypto/SecretKey;)Lcom/allegion/accessblecredential/enums/AlReply;", "Lcom/allegion/alsecurity/interfaces/IAlAes;", "alaes", "Lcom/allegion/alsecurity/interfaces/IAlAes;", "", "encryptionPayloadNonNull", "Ljava/lang/String;", AlCBORMessage.GEN_MSG_TYPE, "getGenMsgType", "()Ljava/lang/String;", "setGenMsgType", "(Ljava/lang/String;)V", "", AlCBORMessage.ENC_PAYLOAD, "[B", "getEncPayload", "()[B", "setEncPayload", "([B)V", "Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "cborUtility", "<init>", "(Lcom/allegion/altranslation/interfaces/IAlCborUtility;Lcom/allegion/alsecurity/interfaces/IAlAes;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlReplyCred extends AlCBORMessage {
    private final IAlAes alaes;

    @JsonProperty
    @Nullable
    private byte[] encPayload;
    private final String encryptionPayloadNonNull;

    @JsonProperty
    @Nullable
    private String genMsgType;

    @JvmOverloads
    public AlReplyCred() throws AlBleComponentException {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public AlReplyCred(@NotNull IAlCborUtility iAlCborUtility) throws AlBleComponentException {
        this(iAlCborUtility, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlReplyCred(@NotNull IAlCborUtility cborUtility, @NotNull IAlAes alaes) throws AlBleComponentException {
        super(cborUtility);
        Intrinsics.checkParameterIsNotNull(cborUtility, "cborUtility");
        Intrinsics.checkParameterIsNotNull(alaes, "alaes");
        this.alaes = alaes;
        this.encryptionPayloadNonNull = "Encryption payload should not be null";
    }

    @Nullable
    public final byte[] getEncPayload() {
        return this.encPayload;
    }

    @Nullable
    public final String getGenMsgType() {
        return this.genMsgType;
    }

    @NotNull
    public final AlReply getResult(@NotNull SecretKey sessionKey) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(sessionKey, "sessionKey");
        Objects.requireNonNull(this.encPayload, this.encryptionPayloadNonNull);
        try {
            IAlAes iAlAes = this.alaes;
            byte[] bArr = this.encPayload;
            if (bArr == null) {
                Intrinsics.throwNpe();
            }
            AlReplyResultPayload alReplyResultPayload = (AlReplyResultPayload) getCborUtility().fromCbor(iAlAes.decrypt(sessionKey, bArr, AlPaddingType.PKCS7_PADDING, null), AlReplyResultPayload.class);
            if (alReplyResultPayload == null) {
                Intrinsics.throwNpe();
            }
            AlLog.d("Payload result %s", alReplyResultPayload.getResult());
            String result = alReplyResultPayload.getResult();
            if (result == null) {
                Intrinsics.throwNpe();
            }
            AlReply alReply = AlReply.DATA_SUCCESS;
            if (!Intrinsics.areEqual(result, alReply.getLockReplyValue())) {
                alReply = AlReply.DATA_FAILURE;
                if (!Intrinsics.areEqual(result, alReply.getLockReplyValue())) {
                    alReply = AlReply.FAIL;
                    if (!Intrinsics.areEqual(result, alReply.getLockReplyValue())) {
                        alReply = AlReply.SUCCESS;
                        if (!Intrinsics.areEqual(result, alReply.getLockReplyValue())) {
                            alReply = AlReply.UNKNOWN;
                            if (!Intrinsics.areEqual(result, alReply.getLockReplyValue())) {
                                throw new AlBleComponentException("Unknown reply from lock");
                            }
                        }
                    }
                }
            }
            return alReply;
        } catch (AlSecurityException e) {
            throw new AlBleComponentException(e);
        } catch (AlTranslationComponentException e2) {
            throw new AlBleComponentException(e2);
        } catch (IllegalArgumentException e3) {
            throw new AlBleComponentException(e3);
        }
    }

    public final void setEncPayload(@Nullable byte[] bArr) {
        this.encPayload = bArr;
    }

    public final void setGenMsgType(@Nullable String str) {
        this.genMsgType = str;
    }

    public /* synthetic */ AlReplyCred(IAlCborUtility iAlCborUtility, IAlAes iAlAes, int i, DefaultConstructorMarker defaultConstructorMarker) throws AlBleComponentException {
        this((i & 1) != 0 ? new AlCborUtility() : iAlCborUtility, (i & 2) != 0 ? new AlAes() : iAlAes);
    }
}
