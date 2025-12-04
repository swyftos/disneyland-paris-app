package com.allegion.accessnfccredential.communication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.allegion.accessnfccredential.enums.AlAPDUInstruction;
import com.allegion.accessnfccredential.enums.AlAPDUParameterKey;
import com.allegion.accessnfccredential.enums.AlAPDUProtocolVersion;
import com.allegion.accessnfccredential.enums.AlAPDUVerifyResponse;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener;
import com.allegion.accessnfccredential.utility.AlAPDUUtilities;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0015\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\""}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlSessionMediator;", "Landroid/content/BroadcastReceiver;", "config", "Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;", "(Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;)V", "aid", "", "connectionTime", "", "getConnectionTime", "()J", "setConnectionTime", "(J)V", "interactionListener", "getInteractionListener", "()Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;", "setInteractionListener", "(Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;)V", "noOpListener", "com/allegion/accessnfccredential/communication/AlSessionMediator$noOpListener$1", "Lcom/allegion/accessnfccredential/communication/AlSessionMediator$noOpListener$1;", "startTime", "getStartTime", "setStartTime", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "processMessage", "setPeripheralDeviceListener", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class AlSessionMediator extends BroadcastReceiver {
    private byte[] aid;
    private long connectionTime;

    @Nullable
    private IAlOnNFCPeripheralInteractionListener interactionListener;
    private final AlSessionMediator$noOpListener$1 noOpListener;
    private long startTime;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlAPDUVerifyResponse.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlAPDUVerifyResponse.ERROR.ordinal()] = 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.allegion.accessnfccredential.communication.AlSessionMediator$noOpListener$1] */
    public AlSessionMediator(@NotNull IAlNFCConfig config, @NotNull IAlOnNFCPeripheralInteractionListener listener) throws AlNFCComponentException {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.noOpListener = new IAlOnNFCPeripheralInteractionListener() { // from class: com.allegion.accessnfccredential.communication.AlSessionMediator$noOpListener$1
            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onConnectPeripheral() {
            }

            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onDisconnectPeripheral() {
            }

            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onDoorUnlockFailed() {
            }

            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onDoorUnlocked(long connectionTime, long unlockTime) {
            }

            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onError(@NotNull Exception exception) {
                Intrinsics.checkParameterIsNotNull(exception, "exception");
            }

            @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
            public void onSendingCredential() {
            }
        };
        AlAPDUUtilities.Companion companion = AlAPDUUtilities.INSTANCE;
        if (companion.hasHCESupport(config.getContext())) {
            if (companion.hasNFCTurnedOn(config.getContext())) {
                AlNFCConfigUtility.INSTANCE.setConfig(config);
                setPeripheralDeviceListener(listener);
                return;
            }
            throw new AlNFCComponentException("NFC communication disabled.");
        }
        throw new AlNFCComponentException("Device does not support NFC communication.");
    }

    public final long getConnectionTime() {
        return this.connectionTime;
    }

    public final void setConnectionTime(long j) {
        this.connectionTime = j;
    }

    @Nullable
    public final IAlOnNFCPeripheralInteractionListener getInteractionListener() {
        return this.interactionListener;
    }

    public final void setInteractionListener(@Nullable IAlOnNFCPeripheralInteractionListener iAlOnNFCPeripheralInteractionListener) {
        this.interactionListener = iAlOnNFCPeripheralInteractionListener;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual(action, AlAPDUInstruction.SELECT.toString())) {
            this.startTime = System.currentTimeMillis();
            Bundle extras = intent.getExtras();
            if (extras == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey = AlAPDUParameterKey.APPLICATION_ID;
            this.aid = extras.getByteArray(alAPDUParameterKey.toString());
            AlLog.d("SELECT (" + alAPDUParameterKey + "): " + Hex.toHexString(this.aid), new Object[0]);
            return;
        }
        if (Intrinsics.areEqual(action, AlAPDUInstruction.GET_CHALLENGE.toString())) {
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey2 = AlAPDUParameterKey.LOCATION_ID;
            byte[] byteArray = extras2.getByteArray(alAPDUParameterKey2.toString());
            AlAPDUProtocolVersion.Companion companion = AlAPDUProtocolVersion.INSTANCE;
            Bundle extras3 = intent.getExtras();
            if (extras3 == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey3 = AlAPDUParameterKey.PROTOCOL_VERSION;
            AlLog.d("GET_CHALLENGE (" + alAPDUParameterKey2 + ", " + alAPDUParameterKey3 + "): " + Hex.toHexString(byteArray) + ", " + String.valueOf(companion.fromInt(extras3.getInt(alAPDUParameterKey3.toString()))), new Object[0]);
            return;
        }
        if (Intrinsics.areEqual(action, AlAPDUInstruction.MUTUAL_AUTHENTICATE.toString())) {
            this.connectionTime = System.currentTimeMillis() - this.startTime;
            this.startTime = System.currentTimeMillis();
            AlLog.d("MUTUAL_AUTHENTICATE", new Object[0]);
            IAlOnNFCPeripheralInteractionListener iAlOnNFCPeripheralInteractionListener = this.interactionListener;
            if (iAlOnNFCPeripheralInteractionListener != null) {
                iAlOnNFCPeripheralInteractionListener.onConnectPeripheral();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, AlAPDUInstruction.TERMINATE_CARD_USAGE.toString())) {
            Bundle extras4 = intent.getExtras();
            if (extras4 == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey4 = AlAPDUParameterKey.DEACTIVATION_REASON;
            int i = extras4.getInt(alAPDUParameterKey4.toString());
            if (i == 0) {
                AlLog.d("TERMINATE_CARD_USAGE (" + alAPDUParameterKey4 + "): 0", new Object[0]);
            } else if (i == 1) {
                AlLog.d("TERMINATE_CARD_USAGE (" + alAPDUParameterKey4 + "): 1", new Object[0]);
            } else {
                AlLog.d("TERMINATE_CARD_USAGE (" + alAPDUParameterKey4 + "): " + i, new Object[0]);
            }
            IAlOnNFCPeripheralInteractionListener iAlOnNFCPeripheralInteractionListener2 = this.interactionListener;
            if (iAlOnNFCPeripheralInteractionListener2 != null) {
                iAlOnNFCPeripheralInteractionListener2.onDisconnectPeripheral();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, AlAPDUInstruction.VERIFY.toString())) {
            AlAPDUVerifyResponse.Companion companion2 = AlAPDUVerifyResponse.INSTANCE;
            Bundle extras5 = intent.getExtras();
            if (extras5 == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey5 = AlAPDUParameterKey.VERIFY_STATUS;
            byte[] byteArray2 = extras5.getByteArray(alAPDUParameterKey5.toString());
            if (byteArray2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(byteArray2, "intent.extras!!.getByteA…RIFY_STATUS.toString())!!");
            AlAPDUVerifyResponse alAPDUVerifyResponseFromByteArray = companion2.fromByteArray(byteArray2);
            StringBuilder sb = new StringBuilder();
            sb.append("VERIFY (");
            sb.append(alAPDUParameterKey5.toString());
            sb.append("): ");
            sb.append(String.valueOf(alAPDUVerifyResponseFromByteArray));
            sb.append(" = ");
            sb.append(Hex.toHexString(alAPDUVerifyResponseFromByteArray != null ? alAPDUVerifyResponseFromByteArray.getBytes() : null));
            AlLog.d(sb.toString(), new Object[0]);
            if (alAPDUVerifyResponseFromByteArray != null && WhenMappings.$EnumSwitchMapping$0[alAPDUVerifyResponseFromByteArray.ordinal()] == 1) {
                AlNFCComponentException alNFCComponentException = new AlNFCComponentException("ERROR");
                Bundle extras6 = intent.getExtras();
                String string = extras6 != null ? extras6.getString("message") : null;
                if (string != null) {
                    alNFCComponentException = new AlNFCComponentException("ERROR: " + string);
                }
                AlLog.e(String.valueOf(alNFCComponentException.getErrorMessage()), new Object[0]);
                IAlOnNFCPeripheralInteractionListener iAlOnNFCPeripheralInteractionListener3 = this.interactionListener;
                if (iAlOnNFCPeripheralInteractionListener3 != null) {
                    iAlOnNFCPeripheralInteractionListener3.onError(alNFCComponentException);
                    return;
                }
                return;
            }
            processMessage(context, intent);
            return;
        }
        processMessage(context, intent);
    }

    public void processMessage(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        intent.getAction();
        String str = "Process Message Not Implemented: " + String.valueOf(intent.getAction());
        AlLog.d(str, new Object[0]);
        IAlOnNFCPeripheralInteractionListener iAlOnNFCPeripheralInteractionListener = this.interactionListener;
        if (iAlOnNFCPeripheralInteractionListener != null) {
            iAlOnNFCPeripheralInteractionListener.onError(new AlNFCComponentException("ERROR: " + str));
        }
    }

    public final void setPeripheralDeviceListener(@Nullable IAlOnNFCPeripheralInteractionListener listener) {
        if (listener == null) {
            this.interactionListener = this.noOpListener;
        } else {
            this.interactionListener = listener;
        }
    }
}
