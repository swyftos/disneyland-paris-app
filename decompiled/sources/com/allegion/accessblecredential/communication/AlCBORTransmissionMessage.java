package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.allegion.core.operations.support.CRC16;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 :2\u00020\u0001:\u0001:B\t\b\u0016¢\u0006\u0004\b7\u00108B\u0013\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b7\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\"\u00101\u001a\u0002008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "", "", "number", "", "intToBytes", "(I)[B", "packet", "Ljava/util/ArrayList;", "packetsToArrayList", "([B)Ljava/util/ArrayList;", "cborArray", "appendCrc", "([B)[B", "crc", "data", "", "validate", "([B[B)Z", "crcArray", "groupNumber", "I", "getGroupNumber", "()I", "setGroupNumber", "(I)V", "cborData", "[B", "getCborData", "()[B", "setCborData", "([B)V", "Ljava/io/ByteArrayOutputStream;", "stream", "Ljava/io/ByteArrayOutputStream;", "getStream", "()Ljava/io/ByteArrayOutputStream;", "setStream", "(Ljava/io/ByteArrayOutputStream;)V", "Lcom/allegion/altranslation/AlCborUtility;", "cborUtility", "Lcom/allegion/altranslation/AlCborUtility;", "lastPacketNumber", "getLastPacketNumber", "setLastPacketNumber", "packetNumber", "getPacketNumber", "setPacketNumber", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "generator", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "getGenerator", "()Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "setGenerator", "(Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;)V", "<init>", "()V", "rawMessage", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public abstract class AlCBORTransmissionMessage {
    public static final int DATA_TRANSMISSION_ERROR_MESSAGE = 2;
    public static final int DATA_TRANSMISSION_FINAL_PACKET_MESSAGE = 1;
    public static final int DATA_TRANSMISSION_FLOW_CONTROL_MESSAGE = 3;
    public static final int DATA_TRANSMISSION_INTERMEDIATE_PACKET_MESSAGE = 0;

    @Nullable
    private byte[] cborData;
    private final AlCborUtility cborUtility;

    @NotNull
    private CBORGenerator generator;
    private int groupNumber;
    private int lastPacketNumber;
    private int packetNumber;

    @NotNull
    private ByteArrayOutputStream stream;

    public AlCBORTransmissionMessage() throws AlBleComponentException {
        AlCborUtility alCborUtility = new AlCborUtility();
        this.cborUtility = alCborUtility;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.stream = byteArrayOutputStream;
        try {
            this.generator = alCborUtility.getCborGenerator(byteArrayOutputStream);
        } catch (AlTranslationComponentException e) {
            throw new AlBleComponentException(e);
        }
    }

    private final byte[] intToBytes(int number) {
        byte[] bArrArray = ByteBuffer.allocate(4).putInt(number).array();
        if (bArrArray[2] == 0) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrArray, 3, 4);
            Intrinsics.checkExpressionValueIsNotNull(bArrCopyOfRange, "Arrays.copyOfRange(temp, 3, 4)");
            return bArrCopyOfRange;
        }
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrArray, 2, 4);
        Intrinsics.checkExpressionValueIsNotNull(bArrCopyOfRange2, "Arrays.copyOfRange(temp, 2, 4)");
        return bArrCopyOfRange2;
    }

    @NotNull
    public final byte[] appendCrc(@NotNull byte[] cborArray) {
        Intrinsics.checkParameterIsNotNull(cborArray, "cborArray");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(cborArray, 0, cborArray.length - 3);
        Intrinsics.checkExpressionValueIsNotNull(bArrCopyOfRange, "Arrays.copyOfRange(cborA…y, 0, cborArray.size - 3)");
        byte[] bArrCrcArray = crcArray(bArrCopyOfRange);
        if (bArrCrcArray.length != 1) {
            cborArray[cborArray.length - 2] = bArrCrcArray[0];
            cborArray[cborArray.length - 1] = bArrCrcArray[1];
            return cborArray;
        }
        byte[] temp = Arrays.copyOfRange(cborArray, 0, cborArray.length - 1);
        temp[temp.length - 2] = (byte) 24;
        temp[temp.length - 1] = bArrCrcArray[0];
        Intrinsics.checkExpressionValueIsNotNull(temp, "temp");
        return temp;
    }

    @NotNull
    public final byte[] crcArray(@NotNull byte[] data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        return intToBytes(CRC16.crc(data));
    }

    @Nullable
    public final byte[] getCborData() {
        return this.cborData;
    }

    @NotNull
    protected final CBORGenerator getGenerator() {
        return this.generator;
    }

    public final int getGroupNumber() {
        return this.groupNumber;
    }

    public final int getLastPacketNumber() {
        return this.lastPacketNumber;
    }

    public final int getPacketNumber() {
        return this.packetNumber;
    }

    @NotNull
    protected final ByteArrayOutputStream getStream() {
        return this.stream;
    }

    @NotNull
    public final ArrayList<?> packetsToArrayList(@NotNull byte[] packet) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(packet, "packet");
        try {
            Object objFromCbor = this.cborUtility.fromCbor(packet, ArrayList.class);
            if (objFromCbor != null) {
                return (ArrayList) objFromCbor;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<*>");
        } catch (AlTranslationComponentException e) {
            throw new AlBleComponentException(e);
        }
    }

    public final void setCborData(@Nullable byte[] bArr) {
        this.cborData = bArr;
    }

    protected final void setGenerator(@NotNull CBORGenerator cBORGenerator) {
        Intrinsics.checkParameterIsNotNull(cBORGenerator, "<set-?>");
        this.generator = cBORGenerator;
    }

    public final void setGroupNumber(int i) {
        this.groupNumber = i;
    }

    public final void setLastPacketNumber(int i) {
        this.lastPacketNumber = i;
    }

    public final void setPacketNumber(int i) {
        this.packetNumber = i;
    }

    protected final void setStream(@NotNull ByteArrayOutputStream byteArrayOutputStream) {
        Intrinsics.checkParameterIsNotNull(byteArrayOutputStream, "<set-?>");
        this.stream = byteArrayOutputStream;
    }

    public final boolean validate(@Nullable byte[] crc, @Nullable byte[] data) {
        return Arrays.equals(crc, (crc == null || data == null) ? null : crcArray(data));
    }

    public AlCBORTransmissionMessage(@Nullable byte[] bArr) throws AlBleComponentException {
        AlCborUtility alCborUtility = new AlCborUtility();
        this.cborUtility = alCborUtility;
        this.stream = new ByteArrayOutputStream();
        if (bArr != null) {
            ArrayList<?> arrayListPacketsToArrayList = packetsToArrayList(bArr);
            Object obj = arrayListPacketsToArrayList.get(arrayListPacketsToArrayList.size() - 1);
            if (obj != null) {
                byte[] bArrIntToBytes = intToBytes(((Integer) obj).intValue());
                if (validate(bArrIntToBytes, Arrays.copyOfRange(bArr, 0, bArr.length - (bArrIntToBytes.length == 1 ? 2 : 3)))) {
                    try {
                        this.generator = alCborUtility.getCborGenerator(this.stream);
                        return;
                    } catch (AlTranslationComponentException e) {
                        throw new AlBleComponentException(e);
                    }
                }
                throw new AlBleComponentException("CRC Validation failed on Transport Layer Message");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new IllegalArgumentException("Data cannot be null");
    }
}
