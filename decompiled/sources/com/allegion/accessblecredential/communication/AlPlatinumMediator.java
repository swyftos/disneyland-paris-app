package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.ble.CredentialBLEPeripheral;
import com.allegion.accessblecredential.enums.AlPlatinumState;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.enums.AlReply;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener;
import com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener;
import com.allegion.alsecurity.AlEcc;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.logging.AlLog;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001;\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u001f\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bL\u0010MJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u001c\u001a\u00020\u00032\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010\u0005R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00103\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010:R\u0018\u0010F\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00101R\u0016\u0010I\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010C¨\u0006O"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlPlatinumMediator;", "Lcom/allegion/accessblecredential/listeners/IAlBlePeripheralTransportListener;", "Lcom/allegion/accessblecredential/communication/IAlCBORMessageListener;", "", "sendMessage", "()V", "sendStartSession", "sendEndSession", "", AlCBORMessage.NONCE, "sendPlatinumPayload", "([B)V", "sendAck", "resetMediatorState", "Lcom/allegion/accessblecredential/listeners/IOnPeripheralInteractionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPeripheralDeviceListener", "(Lcom/allegion/accessblecredential/listeners/IOnPeripheralInteractionListener;)V", "payloadValue", "sendPayload", "data", "onDataReceived", "onConnection", "onConnectionFailed", "onDisconnection", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onException", "(Ljava/lang/Exception;)V", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "message", "onCBORMessageReceived", "(Lcom/allegion/accessblecredential/communication/AlCBORMessage;)V", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "onTransmissionMessageReceived", "(Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;)V", "clearDeviceCache", "Lcom/allegion/accessblecredential/communication/AlCBORWrite;", "cborWrite", "Lcom/allegion/accessblecredential/communication/AlCBORWrite;", "Lcom/allegion/accessblecredential/communication/AlCBORRead;", "cborRead", "Lcom/allegion/accessblecredential/communication/AlCBORRead;", "Ljavax/crypto/SecretKey;", "sessionKey", "Ljavax/crypto/SecretKey;", "", "connectionTime", "J", "credentialTime", "stopTime", "Ljava/security/KeyPair;", "eccSessionKeyPair", "Ljava/security/KeyPair;", "Lcom/allegion/accessblecredential/enums/AlPlatinumState;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/allegion/accessblecredential/enums/AlPlatinumState;", "[B", "com/allegion/accessblecredential/communication/AlPlatinumMediator$noOpListener$1", "noOpListener", "Lcom/allegion/accessblecredential/communication/AlPlatinumMediator$noOpListener$1;", "Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;", "peripheral", "Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;", "", "messageCount", "I", "receiveMessageErrorCount", "sessionNonce", "interactionListener", "Lcom/allegion/accessblecredential/listeners/IOnPeripheralInteractionListener;", "startTime", "sentMessageErrorCount", "Lcom/allegion/accessblecredential/communication/IAlBLEConfig;", "config", "<init>", "(Lcom/allegion/accessblecredential/ble/CredentialBLEPeripheral;Lcom/allegion/accessblecredential/communication/IAlBLEConfig;Lcom/allegion/accessblecredential/listeners/IOnPeripheralInteractionListener;)V", "Companion", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlPlatinumMediator implements IAlBlePeripheralTransportListener, IAlCBORMessageListener {
    private final AlCBORRead cborRead;
    private AlCBORWrite cborWrite;
    private long connectionTime;
    private long credentialTime;
    private KeyPair eccSessionKeyPair;
    private IOnPeripheralInteractionListener interactionListener;
    private int messageCount;
    private final AlPlatinumMediator$noOpListener$1 noOpListener;
    private byte[] payloadValue;
    private final CredentialBLEPeripheral peripheral;
    private int receiveMessageErrorCount;
    private int sentMessageErrorCount;
    private SecretKey sessionKey;
    private byte[] sessionNonce;
    private long startTime;
    private AlPlatinumState state;
    private long stopTime;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            AlPlatinumState.values();
            $EnumSwitchMapping$0 = new int[]{1, 0, 0, 2};
            AlPlatinumState.values();
            $EnumSwitchMapping$1 = new int[]{0, 1, 2, 3};
            AlReply.values();
            $EnumSwitchMapping$2 = new int[]{1, 2, 5, 3, 4};
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.allegion.accessblecredential.communication.AlPlatinumMediator$noOpListener$1] */
    public AlPlatinumMediator(@NotNull CredentialBLEPeripheral peripheral, @NotNull IAlBLEConfig config, @NotNull IOnPeripheralInteractionListener listener) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(peripheral, "peripheral");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.peripheral = peripheral;
        this.state = AlPlatinumState.IDLE;
        this.noOpListener = new IOnPeripheralInteractionListener() { // from class: com.allegion.accessblecredential.communication.AlPlatinumMediator$noOpListener$1
            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onConnectPeripheral() {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onDataFailure() {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onDataSuccess() {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onDisconnectPeripheral() {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onDoorUnlockFailed() {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onDoorUnlocked(long connectionTime, long unlockTime) {
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onError(@NotNull Exception exception) {
                Intrinsics.checkParameterIsNotNull(exception, "exception");
            }

            @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
            public void onSendingCredential() {
            }
        };
        AlBLEConfigUtility.INSTANCE.setConfig(config);
        setPeripheralDeviceListener(listener);
        this.messageCount = 0;
        this.sentMessageErrorCount = 0;
        this.receiveMessageErrorCount = 0;
        peripheral.setPeripheralTransportListener(this);
        this.cborWrite = new AlCBORWrite(peripheral.getMtuSize());
        AlCBORRead alCBORRead = new AlCBORRead(peripheral);
        this.cborRead = alCBORRead;
        alCBORRead.setListener(this);
        this.startTime = System.currentTimeMillis();
    }

    private final void resetMediatorState() {
        this.state = AlPlatinumState.IDLE;
        this.sessionNonce = null;
        this.messageCount = 0;
        this.sentMessageErrorCount = 0;
        this.receiveMessageErrorCount = 0;
        this.eccSessionKeyPair = null;
        this.sessionKey = null;
    }

    private final void sendAck() throws AlBleComponentException {
        AlLog.d("Sending ACK", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.cborWrite.buildFlowControl(this.messageCount));
        this.peripheral.writeCharacteristic$AccessBleCredential_release("BleCredentialData", arrayList);
    }

    private final void sendEndSession() throws AlBleComponentException {
        AlLog.d("Sending End Session", new Object[0]);
        this.peripheral.writeCharacteristic$AccessBleCredential_release("BleCredentialData", this.cborWrite.buildTransportPackets(new AlEndSession().getCbor(), this.messageCount));
        this.state = AlPlatinumState.END_SESSION;
    }

    private final void sendMessage() throws AlBleComponentException {
        AlLog.d("Current state is " + this.state.name(), new Object[0]);
        int iOrdinal = this.state.ordinal();
        if (iOrdinal == 1) {
            sendStartSession();
        } else if (iOrdinal == 2) {
            sendPlatinumPayload(this.sessionNonce);
        } else {
            if (iOrdinal != 3) {
                throw new AlBleComponentException("Invalid state");
            }
            sendEndSession();
        }
    }

    private final void sendPlatinumPayload(byte[] nonce) throws AlBleComponentException {
        if (nonce != null) {
            AlLog.d("Sending Payload", new Object[0]);
            byte[] bArr = this.payloadValue;
            if (bArr == null) {
                Intrinsics.throwNpe();
            }
            SecretKey secretKey = this.sessionKey;
            if (secretKey == null) {
                Intrinsics.throwNpe();
            }
            this.peripheral.writeCharacteristic$AccessBleCredential_release("BleCredentialData", this.cborWrite.buildTransportPackets(new AlPlatinumPayload(bArr, nonce, secretKey).getCbor(), this.messageCount));
            this.state = AlPlatinumState.PLATINUM_PAYLOAD;
        }
    }

    private final void sendStartSession() throws AlBleComponentException {
        AlLog.d("Sending Start Session", new Object[0]);
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
        if (iOnPeripheralInteractionListener == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener.onSendingCredential();
        try {
            AlBLEConfigUtility alBLEConfigUtility = AlBLEConfigUtility.INSTANCE;
            KeyPair keyPair = this.eccSessionKeyPair;
            if (keyPair == null) {
                Intrinsics.throwNpe();
            }
            PublicKey publicKey = keyPair.getPublic();
            if (publicKey == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
            }
            this.peripheral.writeCharacteristic$AccessBleCredential_release("BleCredentialData", this.cborWrite.buildTransportPackets(new AlStartSession(alBLEConfigUtility.exportEccPublicKey((ECPublicKey) publicKey)).getCbor(), this.messageCount));
            this.state = AlPlatinumState.START_SESSION;
        } catch (AlBleComponentException e) {
            throw new AlBleComponentException("Unable to export ECC Key", e);
        }
    }

    public final void clearDeviceCache() {
        AlBLEConfigUtility.INSTANCE.getDeviceStorage().clearAllDevicePins();
    }

    @Override // com.allegion.accessblecredential.communication.IAlCBORMessageListener
    public void onCBORMessageReceived(@NotNull AlCBORMessage message) throws AlBleComponentException, IllegalStateException, AlSecurityException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(message, "message");
        AlProtocolVersion protocolVersion = message.getProtocolVersion();
        AlLog.d("Method called using protocol version %s", protocolVersion != null ? protocolVersion.name() : null);
        if (message instanceof AlStartSession) {
            AlEcc alEcc = new AlEcc();
            byte[] tmpKey = ((AlStartSession) message).getTmpKey();
            if (tmpKey == null) {
                Intrinsics.throwNpe();
            }
            ECPublicKey eCPublicKeyEncodeEccPublicKey = alEcc.encodeEccPublicKey(tmpKey);
            AlEcc alEcc2 = new AlEcc();
            KeyPair keyPair = this.eccSessionKeyPair;
            if (keyPair == null) {
                Intrinsics.throwNpe();
            }
            PrivateKey privateKey = keyPair.getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey, "eccSessionKeyPair!!.private");
            SecretKey secretKeyGenerateAesKeyFromEcdh = alEcc2.generateAesKeyFromEcdh(eCPublicKeyEncodeEccPublicKey, privateKey);
            this.sessionKey = secretKeyGenerateAesKeyFromEcdh;
            AlCBORRead alCBORRead = this.cborRead;
            if (secretKeyGenerateAesKeyFromEcdh == null) {
                Intrinsics.throwNpe();
            }
            alCBORRead.setSessionKey(secretKeyGenerateAesKeyFromEcdh);
            sendAck();
            return;
        }
        if (message instanceof AlCredentialChallenge) {
            sendAck();
            byte[] nonce$AccessBleCredential_release = ((AlCredentialChallenge) message).getNonce$AccessBleCredential_release();
            this.sessionNonce = nonce$AccessBleCredential_release;
            sendPlatinumPayload(nonce$AccessBleCredential_release);
            return;
        }
        if (message instanceof AlPlatinumPayload) {
            resetMediatorState();
            throw new AlBleComponentException("Invalid message received");
        }
        if (message instanceof AlReplyCred) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.stopTime = jCurrentTimeMillis;
            this.credentialTime = jCurrentTimeMillis - this.startTime;
            sendAck();
            AlReplyCred alReplyCred = (AlReplyCred) message;
            long j = this.connectionTime;
            long j2 = this.credentialTime;
            SecretKey secretKey = this.sessionKey;
            if (secretKey == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.crypto.SecretKey");
            }
            int iOrdinal = alReplyCred.getResult(secretKey).ordinal();
            if (iOrdinal == 0) {
                IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
                if (iOnPeripheralInteractionListener != null) {
                    iOnPeripheralInteractionListener.onDataSuccess();
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                IOnPeripheralInteractionListener iOnPeripheralInteractionListener2 = this.interactionListener;
                if (iOnPeripheralInteractionListener2 != null) {
                    iOnPeripheralInteractionListener2.onDataFailure();
                    return;
                }
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    sendEndSession();
                    IOnPeripheralInteractionListener iOnPeripheralInteractionListener3 = this.interactionListener;
                    if (iOnPeripheralInteractionListener3 != null) {
                        iOnPeripheralInteractionListener3.onDoorUnlockFailed();
                        return;
                    }
                    return;
                }
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            sendEndSession();
            IOnPeripheralInteractionListener iOnPeripheralInteractionListener4 = this.interactionListener;
            if (iOnPeripheralInteractionListener4 != null) {
                iOnPeripheralInteractionListener4.onDoorUnlocked(j, j2);
            }
        }
    }

    @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
    public void onConnection() {
        this.cborWrite = new AlCBORWrite(this.peripheral.getMtuSize());
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
        if (iOnPeripheralInteractionListener == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener.onConnectPeripheral();
    }

    @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
    public void onConnectionFailed() {
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
        if (iOnPeripheralInteractionListener == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener.onDoorUnlockFailed();
    }

    @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
    public void onDataReceived(@NotNull byte[] data) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(data, "data");
        AlLog.d("onDataReceived: %s", Hex.toHexString(data));
        if (data.length == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.stopTime = jCurrentTimeMillis;
            this.connectionTime = jCurrentTimeMillis - this.startTime;
            this.startTime = System.currentTimeMillis();
            this.cborWrite = new AlCBORWrite(this.peripheral.getMtuSize());
            this.eccSessionKeyPair = AlBLEConfigUtility.INSTANCE.getSessionKey();
            sendStartSession();
            return;
        }
        try {
            this.cborRead.processTransportLayer(data);
        } catch (AlBleComponentException e) {
            AlLog.e(e);
            AlLog.d("onDataReceived: Message Error Count - %s", Integer.valueOf(this.receiveMessageErrorCount));
            if (this.receiveMessageErrorCount < 3) {
                AlLog.d("onDataReceived: Sending NAK", new Object[0]);
                byte b = data[2];
                AlLog.d("Sending NAK", new Object[0]);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.cborWrite.buildTransportError(this.messageCount, b));
                this.peripheral.writeCharacteristic$AccessBleCredential_release("BleCredentialData", arrayList);
                this.receiveMessageErrorCount++;
                return;
            }
            AlLog.d("onDataReceived: Ending Session", new Object[0]);
            IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
            if (iOnPeripheralInteractionListener == null) {
                Intrinsics.throwNpe();
            }
            iOnPeripheralInteractionListener.onDoorUnlockFailed();
            IOnPeripheralInteractionListener iOnPeripheralInteractionListener2 = this.interactionListener;
            if (iOnPeripheralInteractionListener2 == null) {
                Intrinsics.throwNpe();
            }
            iOnPeripheralInteractionListener2.onError(e);
            resetMediatorState();
            this.peripheral.disconnect(false);
        }
    }

    @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
    public void onDisconnection() {
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
        if (iOnPeripheralInteractionListener == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener.onDisconnectPeripheral();
        resetMediatorState();
    }

    @Override // com.allegion.accessblecredential.listeners.IAlBlePeripheralTransportListener
    public void onException(@NotNull Exception e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
        if (iOnPeripheralInteractionListener == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener.onDoorUnlockFailed();
        IOnPeripheralInteractionListener iOnPeripheralInteractionListener2 = this.interactionListener;
        if (iOnPeripheralInteractionListener2 == null) {
            Intrinsics.throwNpe();
        }
        iOnPeripheralInteractionListener2.onError(e);
        resetMediatorState();
    }

    @Override // com.allegion.accessblecredential.communication.IAlCBORMessageListener
    public void onTransmissionMessageReceived(@NotNull AlCBORTransmissionMessage message) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(message, "message");
        AlLog.d("Method called with data %s", message.getCborData());
        if (message instanceof AlTransmissionErrorHandling) {
            AlLog.d("Error message received.", new Object[0]);
            int i = this.sentMessageErrorCount + 1;
            this.sentMessageErrorCount = i;
            if (i < 3) {
                sendMessage();
                return;
            }
            IOnPeripheralInteractionListener iOnPeripheralInteractionListener = this.interactionListener;
            if (iOnPeripheralInteractionListener == null) {
                Intrinsics.throwNpe();
            }
            iOnPeripheralInteractionListener.onDoorUnlockFailed();
            resetMediatorState();
            this.peripheral.disconnect(false);
            return;
        }
        if (message instanceof AlTransmissionFlowControl) {
            this.messageCount++;
            this.sentMessageErrorCount = 0;
            AlLog.d("Flow control message received. Current state is " + this.state.name(), new Object[0]);
            int iOrdinal = this.state.ordinal();
            if (iOrdinal == 0) {
                throw new AlBleComponentException("Ack should not be received");
            }
            if (iOrdinal != 3) {
                return;
            }
            resetMediatorState();
            this.peripheral.disconnect(false);
        }
    }

    public final void sendPayload(@NotNull byte[] payloadValue) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(payloadValue, "payloadValue");
        if (!this.peripheral.isConnected()) {
            throw new AlBleComponentException("Device is not connected");
        }
        this.payloadValue = payloadValue;
        if (this.state == AlPlatinumState.IDLE) {
            this.peripheral.writeNotificationDescriptorToLock$AccessBleCredential_release("BleCredentialData");
        } else {
            sendMessage();
        }
    }

    public final void setPeripheralDeviceListener(@Nullable IOnPeripheralInteractionListener listener) {
        if (listener == null) {
            this.interactionListener = this.noOpListener;
        } else {
            this.interactionListener = listener;
        }
    }
}
