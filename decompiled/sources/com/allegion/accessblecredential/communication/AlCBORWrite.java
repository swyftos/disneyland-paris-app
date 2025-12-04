package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlCBORWrite;", "", "", "cborData", "", "messageCount", "Ljava/util/ArrayList;", "buildTransportPackets", "([BI)Ljava/util/ArrayList;", "groupNumber", "packetNumber", "buildTransportError", "(II)[B", "buildFlowControl", "(I)[B", "mtuSize", "I", "<init>", "(I)V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlCBORWrite {
    private final int mtuSize;
    private static final int CBOR_HEADER_SIZE = 20;

    public AlCBORWrite(int i) {
        this.mtuSize = i - CBOR_HEADER_SIZE;
    }

    @NotNull
    public final byte[] buildFlowControl(int messageCount) throws AlBleComponentException {
        if (messageCount < 0) {
            throw new IllegalArgumentException("Message count cannot be less than 0");
        }
        AlTransmissionFlowControl alTransmissionFlowControl = new AlTransmissionFlowControl();
        alTransmissionFlowControl.setGroupNumber(messageCount);
        return alTransmissionFlowControl.getCbor();
    }

    @NotNull
    public final byte[] buildTransportError(int groupNumber, int packetNumber) throws AlBleComponentException {
        if (groupNumber < 0 && packetNumber < 1) {
            throw new IllegalArgumentException("Message count cannot be less than 0");
        }
        AlTransmissionErrorHandling alTransmissionErrorHandling = new AlTransmissionErrorHandling();
        alTransmissionErrorHandling.setGroupNumber(groupNumber);
        alTransmissionErrorHandling.setPacketNumber(packetNumber);
        return alTransmissionErrorHandling.getCbor();
    }

    @NotNull
    public final ArrayList<byte[]> buildTransportPackets(@Nullable byte[] cborData, int messageCount) throws AlBleComponentException {
        if (cborData == null || messageCount < 0) {
            throw new IllegalArgumentException("Input parameters cannot be null or less than 0");
        }
        int i = this.mtuSize;
        ArrayList arrayList = new ArrayList();
        if (cborData.length <= i) {
            arrayList.add(cborData);
        } else {
            int length = cborData.length % i;
            int length2 = cborData.length / i;
            if (length != 0) {
                length2++;
            }
            int i2 = 0;
            while (i2 < length2) {
                int i3 = i2 * i;
                i2++;
                int i4 = i2 * i;
                if (i4 > cborData.length) {
                    i4 = length + i3;
                }
                arrayList.add(Arrays.copyOfRange(cborData, i3, i4));
            }
        }
        ArrayList<byte[]> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        int i5 = 1;
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            if (i5 != arrayList.size()) {
                AlTransmissionIntermediatePacket alTransmissionIntermediatePacket = new AlTransmissionIntermediatePacket();
                alTransmissionIntermediatePacket.setGroupNumber(messageCount);
                alTransmissionIntermediatePacket.setPacketNumber(i5);
                alTransmissionIntermediatePacket.setCborData(bArr);
                alTransmissionIntermediatePacket.setLastPacketNumber(arrayList.size());
                arrayList2.add(alTransmissionIntermediatePacket.getCbor());
            } else {
                AlTransmissionFinalPacket alTransmissionFinalPacket = new AlTransmissionFinalPacket();
                alTransmissionFinalPacket.setGroupNumber(messageCount);
                alTransmissionFinalPacket.setPacketNumber(i5);
                alTransmissionFinalPacket.setCborData(bArr);
                alTransmissionFinalPacket.setLastPacketNumber(arrayList.size());
                alTransmissionFinalPacket.setTotalCborLength(arrayList.size() == 1 ? 0 : ((byte[]) arrayList.get(0)).length);
                arrayList2.add(alTransmissionFinalPacket.getCbor());
            }
            i5++;
        }
        return arrayList2;
    }
}
