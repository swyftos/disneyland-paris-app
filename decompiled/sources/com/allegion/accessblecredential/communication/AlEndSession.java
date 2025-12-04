package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\f\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlEndSession;", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", AlCBORMessage.GEN_MSG_TYPE, "Ljava/lang/String;", "getGenMsgType", "()Ljava/lang/String;", "setGenMsgType", "(Ljava/lang/String;)V", "", "getCbor", "()[B", "cbor", "<init>", "()V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlEndSession extends AlCBORMessage {

    @JsonProperty
    @Nullable
    private String genMsgType;

    public AlEndSession() throws AlBleComponentException {
        super(null, 1, null);
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartObject(1);
            getGenerator().writeStringField(AlCBORMessage.GEN_MSG_TYPE, AlCBORMessage.SESSION_END);
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

    public final void setGenMsgType(@Nullable String str) {
        this.genMsgType = str;
    }
}
