package com.allegion.accessnfccredential.communication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.allegion.accessnfccredential.enums.AlAPDUInstruction;
import com.allegion.accessnfccredential.enums.AlAPDUParameterKey;
import com.allegion.accessnfccredential.enums.AlAPDUVerifyResponse;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlSchlageAccessMediator;", "Lcom/allegion/accessnfccredential/communication/AlSessionMediator;", "config", "Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;", "(Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;)V", "unlockTime", "", "getUnlockTime", "()J", "setUnlockTime", "(J)V", "processMessage", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlSchlageAccessMediator extends AlSessionMediator {
    private long unlockTime;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlAPDUVerifyResponse.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlAPDUVerifyResponse.ACCESS_UNKNOWN.ordinal()] = 1;
            iArr[AlAPDUVerifyResponse.ACCESS_GRANTED.ordinal()] = 2;
            iArr[AlAPDUVerifyResponse.ACCESS_DENIED.ordinal()] = 3;
            iArr[AlAPDUVerifyResponse.ERROR.ordinal()] = 4;
            iArr[AlAPDUVerifyResponse.NONE.ordinal()] = 5;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlSchlageAccessMediator(@NotNull IAlNFCConfig config, @NotNull IAlOnNFCPeripheralInteractionListener listener) {
        super(config, listener);
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
    }

    public final long getUnlockTime() {
        return this.unlockTime;
    }

    public final void setUnlockTime(long j) {
        this.unlockTime = j;
    }

    @Override // com.allegion.accessnfccredential.communication.AlSessionMediator
    public void processMessage(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual(action, AlAPDUInstruction.GET_DATA.toString())) {
            AlLog.d("GET_DATA", new Object[0]);
            IAlOnNFCPeripheralInteractionListener interactionListener = getInteractionListener();
            if (interactionListener != null) {
                interactionListener.onSendingCredential();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, AlAPDUInstruction.VERIFY.toString())) {
            AlAPDUVerifyResponse.Companion companion = AlAPDUVerifyResponse.INSTANCE;
            Bundle extras = intent.getExtras();
            if (extras == null) {
                Intrinsics.throwNpe();
            }
            AlAPDUParameterKey alAPDUParameterKey = AlAPDUParameterKey.VERIFY_STATUS;
            byte[] byteArray = extras.getByteArray(alAPDUParameterKey.toString());
            if (byteArray == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(byteArray, "intent.extras!!.getByteA…RIFY_STATUS.toString())!!");
            AlAPDUVerifyResponse alAPDUVerifyResponseFromByteArray = companion.fromByteArray(byteArray);
            StringBuilder sb = new StringBuilder();
            sb.append("VERIFY (");
            sb.append(alAPDUParameterKey.toString());
            sb.append("): ");
            sb.append(String.valueOf(alAPDUVerifyResponseFromByteArray));
            sb.append(" = ");
            sb.append(Hex.toHexString(alAPDUVerifyResponseFromByteArray != null ? alAPDUVerifyResponseFromByteArray.getBytes() : null));
            AlLog.d(sb.toString(), new Object[0]);
            if (alAPDUVerifyResponseFromByteArray == null) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[alAPDUVerifyResponseFromByteArray.ordinal()];
            if (i == 1 || i == 2) {
                this.unlockTime = System.currentTimeMillis() - getStartTime();
                AlLog.d("TIMING (Connection Time, Unlock Time): " + getConnectionTime() + ", " + this.unlockTime, new Object[0]);
                IAlOnNFCPeripheralInteractionListener interactionListener2 = getInteractionListener();
                if (interactionListener2 != null) {
                    interactionListener2.onDoorUnlocked(getConnectionTime(), this.unlockTime);
                    return;
                }
                return;
            }
            if (i == 3) {
                IAlOnNFCPeripheralInteractionListener interactionListener3 = getInteractionListener();
                if (interactionListener3 != null) {
                    interactionListener3.onDoorUnlockFailed();
                    return;
                }
                return;
            }
            if (i == 4 || i == 5) {
                AlNFCComponentException alNFCComponentException = new AlNFCComponentException("ERROR");
                Bundle extras2 = intent.getExtras();
                String string = extras2 != null ? extras2.getString("message") : null;
                if (string != null) {
                    alNFCComponentException = new AlNFCComponentException("ERROR: " + string);
                }
                AlLog.e(String.valueOf(alNFCComponentException.getErrorMessage()), new Object[0]);
                IAlOnNFCPeripheralInteractionListener interactionListener4 = getInteractionListener();
                if (interactionListener4 != null) {
                    interactionListener4.onError(alNFCComponentException);
                }
            }
        }
    }
}
