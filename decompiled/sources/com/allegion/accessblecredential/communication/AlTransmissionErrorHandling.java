package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlTransmissionErrorHandling;", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "", "getCbor", "()[B", "cbor", "<init>", "()V", "rawMessage", "([B)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlTransmissionErrorHandling extends AlCBORTransmissionMessage {
    public AlTransmissionErrorHandling() throws AlBleComponentException {
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartArray(4);
            getGenerator().writeNumber(2);
            getGenerator().writeNumber(getGroupNumber());
            getGenerator().writeNumber(getPacketNumber());
            getGenerator().writeNumber(65535);
            getGenerator().writeEndArray();
            getGenerator().close();
            byte[] byteArray = getStream().toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "stream.toByteArray()");
            return appendCrc(byteArray);
        } catch (IOException e) {
            throw new AlBleComponentException(e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlTransmissionErrorHandling(@NotNull byte[] rawMessage) throws AlBleComponentException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
    }
}
