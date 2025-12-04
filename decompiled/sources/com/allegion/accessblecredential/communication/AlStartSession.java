package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlStartSession;", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", AlCBORMessage.TEMP_KEY, "[B", "getTmpKey", "()[B", "setTmpKey", "([B)V", "", AlCBORMessage.GEN_MSG_TYPE, "Ljava/lang/String;", "getGenMsgType", "()Ljava/lang/String;", "setGenMsgType", "(Ljava/lang/String;)V", "getCbor", "cbor", "<init>", "()V", "uncompressedPublicKey", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlStartSession extends AlCBORMessage {

    @JsonProperty
    @Nullable
    private String genMsgType;

    @JsonProperty
    @Nullable
    private byte[] tmpKey;

    public AlStartSession() throws AlBleComponentException {
        super(null, 1, null);
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartObject(2);
            getGenerator().writeStringField(AlCBORMessage.GEN_MSG_TYPE, AlCBORMessage.SESSION_START);
            getGenerator().writeBinaryField(AlCBORMessage.TEMP_KEY, this.tmpKey);
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
    public final String getGenMsgType() {
        return this.genMsgType;
    }

    @Nullable
    public final byte[] getTmpKey() {
        return this.tmpKey;
    }

    public final void setGenMsgType(@Nullable String str) {
        this.genMsgType = str;
    }

    public final void setTmpKey(@Nullable byte[] bArr) {
        this.tmpKey = bArr;
    }

    public AlStartSession(@Nullable byte[] bArr) throws AlBleComponentException {
        super(null, 1, null);
        if (bArr == null || bArr.length != 65) {
            throw new IllegalArgumentException("Invalid public key length, should be 65.");
        }
        this.tmpKey = bArr;
    }
}
