package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.ble.CredentialBLEPeripheral;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.altranslation.AlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010(R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010)R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0018\u0010+\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001f¨\u00063"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlCBORRead;", "", "", "resetPacketStates", "()V", "", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "transmissionPackets", "", "constructCBORRawMessage", "([Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;)[B", "rawBytes", "processTransportLayer", "([B)V", "Lcom/allegion/accessblecredential/communication/IAlCBORMessageListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/allegion/accessblecredential/communication/IAlCBORMessageListener;)V", "Ljavax/crypto/SecretKey;", "key", "setSessionKey", "(Ljavax/crypto/SecretKey;)V", "", "serialNumber", "setSerialNumber", "(Ljava/lang/String;)V", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "processMessageLayer", "([B)Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "", "currentGroupNumber", "I", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "protocolVersion", "Lcom/allegion/accessblecredential/enums/AlProtocolVersion;", "packets", "[Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "Lcom/allegion/altranslation/AlCborUtility;", "utility", "Lcom/allegion/altranslation/AlCborUtility;", "Lcom/allegion/accessblecredential/communication/IAlCBORMessageListener;", "Ljava/lang/String;", "currentPayloadCounter", "sessionKey", "Ljavax/crypto/SecretKey;", "currentCBORMessageLength", "Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;", "peripheral", "<init>", "(Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;)V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlCBORRead {
    private int currentCBORMessageLength;
    private int currentGroupNumber;
    private int currentPayloadCounter;
    private IAlCBORMessageListener listener;
    private AlCBORTransmissionMessage[] packets;
    private AlProtocolVersion protocolVersion;
    private String serialNumber;
    private SecretKey sessionKey;
    private final AlCborUtility utility;

    public AlCBORRead(@NotNull CredentialBLEPeripheral peripheral) {
        Intrinsics.checkParameterIsNotNull(peripheral, "peripheral");
        this.utility = new AlCborUtility();
        this.currentGroupNumber = -1;
        this.currentPayloadCounter = -1;
        this.currentCBORMessageLength = -1;
        this.serialNumber = peripheral.getSerialNumber();
        this.protocolVersion = peripheral.getProtocolVersion();
    }

    private final byte[] constructCBORRawMessage(AlCBORTransmissionMessage[] transmissionPackets) {
        byte[] bArrArray = new byte[0];
        int length = transmissionPackets.length;
        for (int i = 0; i < length; i++) {
            AlCBORTransmissionMessage alCBORTransmissionMessage = transmissionPackets[i];
            byte[] cborData = ((alCBORTransmissionMessage instanceof AlTransmissionIntermediatePacket) || (alCBORTransmissionMessage instanceof AlTransmissionFinalPacket)) ? alCBORTransmissionMessage.getCborData() : null;
            if (cborData != null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrArray.length + cborData.length);
                byteBufferAllocate.put(bArrArray);
                byteBufferAllocate.put(cborData);
                bArrArray = byteBufferAllocate.array();
                Intrinsics.checkExpressionValueIsNotNull(bArrArray, "bb.array()");
            }
        }
        return bArrArray;
    }

    private final void resetPacketStates() {
        this.currentPayloadCounter = -1;
        this.currentGroupNumber = -1;
        this.packets = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NotNull
    public final AlCBORMessage processMessageLayer(@NotNull byte[] rawBytes) throws AlBleComponentException {
        AlCBORMessage alCredentialChallenge;
        Intrinsics.checkParameterIsNotNull(rawBytes, "rawBytes");
        AlLog.d("processMessageLayer: CBOR Message - " + Hex.toHexString(rawBytes), new Object[0]);
        try {
            try {
                try {
                    HashMap map = (HashMap) this.utility.fromCbor(rawBytes, HashMap.class);
                    if (map == null) {
                        Intrinsics.throwNpe();
                    }
                    Object obj = map.get(AlCBORMessage.GEN_MSG_TYPE);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    int i = this.currentCBORMessageLength;
                    if (i != 0 && rawBytes.length != i) {
                        AlLog.d("CBOR Calculated Message Length: " + this.currentCBORMessageLength, new Object[0]);
                        AlLog.d("CBOR Built Message Length: " + rawBytes.length, new Object[0]);
                        throw new AlBleComponentException("CBOR Chunk Size Invalid or Missing");
                    }
                    AlLog.d("CBOR Built Message Type: " + str, new Object[0]);
                    switch (str.hashCode()) {
                        case -697335956:
                            if (str.equals(AlCBORMessage.SESSION_START)) {
                                Object objFromCbor = this.utility.fromCbor(rawBytes, AlStartSession.class);
                                if (objFromCbor == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessblecredential.communication.AlCBORMessage");
                                }
                                alCredentialChallenge = (AlCBORMessage) objFromCbor;
                                resetPacketStates();
                                return alCredentialChallenge;
                            }
                            throw new AlBleComponentException("Invalid Message Type");
                        case 108401386:
                            if (str.equals(AlCBORMessage.REPLY_MSG)) {
                                Object objFromCbor2 = this.utility.fromCbor(rawBytes, AlReplyCred.class);
                                if (objFromCbor2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessblecredential.communication.AlCBORMessage");
                                }
                                alCredentialChallenge = (AlCBORMessage) objFromCbor2;
                                resetPacketStates();
                                return alCredentialChallenge;
                            }
                            throw new AlBleComponentException("Invalid Message Type");
                        case 1076753534:
                            if (str.equals(AlCBORMessage.SIGNED_CMD)) {
                                Object objFromCbor3 = this.utility.fromCbor(rawBytes, AlPlatinumPayload.class);
                                if (objFromCbor3 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessblecredential.communication.AlCBORMessage");
                                }
                                alCredentialChallenge = (AlCBORMessage) objFromCbor3;
                                resetPacketStates();
                                return alCredentialChallenge;
                            }
                            throw new AlBleComponentException("Invalid Message Type");
                        case 1402633315:
                            if (str.equals(AlCBORMessage.CHALLENGE_MSG)) {
                                SecretKey secretKey = this.sessionKey;
                                if (secretKey == null) {
                                    Intrinsics.throwNpe();
                                }
                                alCredentialChallenge = new AlCredentialChallenge(rawBytes, secretKey, this.protocolVersion, this.serialNumber);
                                resetPacketStates();
                                return alCredentialChallenge;
                            }
                            throw new AlBleComponentException("Invalid Message Type");
                        case 1661828709:
                            if (str.equals(AlCBORMessage.SESSION_END)) {
                                Object objFromCbor4 = this.utility.fromCbor(rawBytes, AlEndSession.class);
                                if (objFromCbor4 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.allegion.accessblecredential.communication.AlCBORMessage");
                                }
                                alCredentialChallenge = (AlCBORMessage) objFromCbor4;
                                resetPacketStates();
                                return alCredentialChallenge;
                            }
                            throw new AlBleComponentException("Invalid Message Type");
                        default:
                            throw new AlBleComponentException("Invalid Message Type");
                    }
                } catch (AlTranslationComponentException e) {
                    throw new AlBleComponentException(e);
                }
            } catch (AlBleComponentException e2) {
                throw new AlBleComponentException(e2);
            }
        } catch (Throwable th) {
            resetPacketStates();
            throw th;
        }
    }

    public final void setListener(@NotNull IAlCBORMessageListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listener = listener;
    }

    public final void setSerialNumber(@NotNull String serialNumber) {
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        this.serialNumber = serialNumber;
    }

    public final void setSessionKey(@NotNull SecretKey key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.sessionKey = key;
    }

    public final void processTransportLayer(@NotNull byte[] rawBytes) throws AlBleComponentException {
        int totalCborLength;
        byte b;
        Intrinsics.checkParameterIsNotNull(rawBytes, "rawBytes");
        String simpleName = Reflection.getOrCreateKotlinClass(AlCBORTransmissionMessage.class).getSimpleName();
        if (simpleName == null) {
            Intrinsics.throwNpe();
        }
        AlLog.d("%s: Transmission Message: ", simpleName, Hex.toHexString(rawBytes));
        byte b2 = rawBytes[2];
        int i = this.currentGroupNumber;
        if (i != -1 && i != b2) {
            throw new AlBleComponentException("Group numbers mismatch send error");
        }
        if (i == -1 && ((b = rawBytes[1]) == 0 || b == 1)) {
            this.currentGroupNumber = b2;
            this.currentPayloadCounter = 0;
            this.packets = new AlCBORTransmissionMessage[rawBytes[4]];
        }
        byte b3 = rawBytes[1];
        if (b3 == 0) {
            AlLog.d("%s: Transmission Intermediate: ", Integer.valueOf(this.currentPayloadCounter));
            AlTransmissionIntermediatePacket alTransmissionIntermediatePacket = new AlTransmissionIntermediatePacket(rawBytes);
            AlCBORTransmissionMessage[] alCBORTransmissionMessageArr = this.packets;
            if (alCBORTransmissionMessageArr != null) {
                alCBORTransmissionMessageArr[alTransmissionIntermediatePacket.getPacketNumber() - 1] = alTransmissionIntermediatePacket;
            }
            this.currentPayloadCounter++;
        } else if (b3 == 1) {
            AlLog.d("%s: Transmission Final: ", Integer.valueOf(this.currentPayloadCounter));
            AlTransmissionFinalPacket alTransmissionFinalPacket = new AlTransmissionFinalPacket(rawBytes);
            AlCBORTransmissionMessage[] alCBORTransmissionMessageArr2 = this.packets;
            if (alCBORTransmissionMessageArr2 != null) {
                alCBORTransmissionMessageArr2[alTransmissionFinalPacket.getPacketNumber() - 1] = alTransmissionFinalPacket;
            }
            if (this.currentPayloadCounter != 1 || alTransmissionFinalPacket.getLastPacketNumber() == 1) {
                totalCborLength = alTransmissionFinalPacket.getTotalCborLength();
            } else {
                int totalCborLength2 = alTransmissionFinalPacket.getTotalCborLength() * this.currentPayloadCounter;
                byte[] cborData = alTransmissionFinalPacket.getCborData();
                if (cborData == null) {
                    Intrinsics.throwNpe();
                }
                totalCborLength = totalCborLength2 + cborData.length;
            }
            this.currentCBORMessageLength = totalCborLength;
            if (alTransmissionFinalPacket.getLastPacketNumber() != 1 || this.listener == null) {
                this.currentPayloadCounter++;
            } else {
                AlCBORTransmissionMessage[] alCBORTransmissionMessageArr3 = this.packets;
                if (alCBORTransmissionMessageArr3 == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bArrConstructCBORRawMessage = constructCBORRawMessage(alCBORTransmissionMessageArr3);
                IAlCBORMessageListener iAlCBORMessageListener = this.listener;
                if (iAlCBORMessageListener == null) {
                    Intrinsics.throwNpe();
                }
                iAlCBORMessageListener.onCBORMessageReceived(processMessageLayer(bArrConstructCBORRawMessage));
                resetPacketStates();
            }
        } else if (b3 == 2) {
            IAlCBORMessageListener iAlCBORMessageListener2 = this.listener;
            if (iAlCBORMessageListener2 != null) {
                iAlCBORMessageListener2.onTransmissionMessageReceived(new AlTransmissionErrorHandling(rawBytes));
            }
            resetPacketStates();
        } else {
            if (b3 != 3) {
                throw new AlBleComponentException("Unrecognized message format");
            }
            AlLog.d("%s: Transmission Flow Control: ", Integer.valueOf(this.currentPayloadCounter));
            IAlCBORMessageListener iAlCBORMessageListener3 = this.listener;
            if (iAlCBORMessageListener3 != null) {
                iAlCBORMessageListener3.onTransmissionMessageReceived(new AlTransmissionFlowControl(rawBytes));
            }
            resetPacketStates();
        }
        AlCBORTransmissionMessage[] alCBORTransmissionMessageArr4 = this.packets;
        if (alCBORTransmissionMessageArr4 == null || this.currentPayloadCounter != alCBORTransmissionMessageArr4.length) {
            return;
        }
        IAlCBORMessageListener iAlCBORMessageListener4 = this.listener;
        if (iAlCBORMessageListener4 != null) {
            if (alCBORTransmissionMessageArr4 == null) {
                Intrinsics.throwNpe();
            }
            iAlCBORMessageListener4.onCBORMessageReceived(processMessageLayer(constructCBORRawMessage(alCBORTransmissionMessageArr4)));
        }
        resetPacketStates();
    }
}
