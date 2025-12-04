package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlTransmissionIntermediatePacket;", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "", "getCbor", "()[B", "cbor", "<init>", "()V", "rawMessage", "([B)V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlTransmissionIntermediatePacket extends AlCBORTransmissionMessage {
    public AlTransmissionIntermediatePacket() throws AlBleComponentException {
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartArray(6);
            getGenerator().writeNumber(0);
            getGenerator().writeNumber(getGroupNumber());
            getGenerator().writeNumber(getPacketNumber());
            getGenerator().writeNumber(getLastPacketNumber());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getCborData());
            CBORGenerator generator = getGenerator();
            byte[] cborData = getCborData();
            if (cborData == null) {
                Intrinsics.throwNpe();
            }
            generator.writeBinary(byteArrayInputStream, cborData.length);
            getGenerator().writeNumber(65535);
            getGenerator().writeEndArray();
            getGenerator().close();
            byte[] byteArray = getStream().toByteArray();
            if (byteArray == null) {
                Intrinsics.throwNpe();
            }
            return appendCrc(byteArray);
        } catch (IOException e) {
            throw new AlBleComponentException(e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlTransmissionIntermediatePacket(@NotNull byte[] rawMessage) throws AlBleComponentException {
        super(rawMessage);
        Intrinsics.checkParameterIsNotNull(rawMessage, "rawMessage");
        ArrayList<?> arrayListPacketsToArrayList = packetsToArrayList(rawMessage);
        Object obj = arrayListPacketsToArrayList.get(1);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        setGroupNumber(((Integer) obj).intValue());
        Object obj2 = arrayListPacketsToArrayList.get(2);
        if (obj2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        setPacketNumber(((Integer) obj2).intValue());
        Object obj3 = arrayListPacketsToArrayList.get(3);
        if (obj3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        setLastPacketNumber(((Integer) obj3).intValue());
        Object obj4 = arrayListPacketsToArrayList.get(4);
        if (obj4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
        setCborData((byte[]) obj4);
    }
}
