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
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\nR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlTransmissionFinalPacket;", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "", "getCbor", "()[B", "cbor", "rawMessage", "[B", "getRawMessage", "setRawMessage", "([B)V", "", "totalCborLength", "I", "getTotalCborLength", "()I", "setTotalCborLength", "(I)V", "<init>", "()V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlTransmissionFinalPacket extends AlCBORTransmissionMessage {

    @Nullable
    private byte[] rawMessage;
    private int totalCborLength;

    public AlTransmissionFinalPacket() throws AlBleComponentException {
    }

    @NotNull
    public final byte[] getCbor() throws AlBleComponentException {
        try {
            getGenerator().writeStartArray(7);
            getGenerator().writeNumber(1);
            getGenerator().writeNumber(getGroupNumber());
            getGenerator().writeNumber(getPacketNumber());
            getGenerator().writeNumber(getLastPacketNumber());
            getGenerator().writeNumber(this.totalCborLength);
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
            byte[] cborArray = getStream().toByteArray();
            Intrinsics.checkExpressionValueIsNotNull(cborArray, "cborArray");
            return appendCrc(cborArray);
        } catch (IOException e) {
            throw new AlBleComponentException(e);
        }
    }

    @Nullable
    public final byte[] getRawMessage() {
        return this.rawMessage;
    }

    public final int getTotalCborLength() {
        return this.totalCborLength;
    }

    public final void setRawMessage(@Nullable byte[] bArr) {
        this.rawMessage = bArr;
    }

    public final void setTotalCborLength(int i) {
        this.totalCborLength = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlTransmissionFinalPacket(@NotNull byte[] rawMessage) throws AlBleComponentException {
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
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        this.totalCborLength = ((Integer) obj4).intValue();
        Object obj5 = arrayListPacketsToArrayList.get(5);
        if (obj5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
        setCborData((byte[]) obj5);
        this.rawMessage = rawMessage;
    }
}
