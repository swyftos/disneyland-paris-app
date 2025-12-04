package com.allegion.accessnfccredential.services;

import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.allegion.accessnfccredential.communication.AlGetChallenge;
import com.allegion.accessnfccredential.communication.AlGetData;
import com.allegion.accessnfccredential.communication.AlMutualAuthentication;
import com.allegion.accessnfccredential.communication.AlNFCPayload;
import com.allegion.accessnfccredential.communication.AlSelectApplication;
import com.allegion.accessnfccredential.communication.AlVerify;
import com.allegion.accessnfccredential.enums.AlAPDUInstruction;
import com.allegion.accessnfccredential.enums.AlAPDUParameterKey;
import com.allegion.accessnfccredential.enums.AlAPDUProtocolVersion;
import com.allegion.accessnfccredential.enums.AlAPDUVerifyResponse;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.utility.AlAPDUParser;
import com.allegion.accessnfccredential.utility.AlAPDUResponse;
import com.allegion.logging.AlLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/allegion/accessnfccredential/services/AlAPDUService;", "Landroid/nfc/cardemulation/HostApduService;", "()V", AlCBORMessage.NONCE, "", "payload", "Lcom/allegion/accessnfccredential/communication/AlNFCPayload;", "protocolVersion", "Lcom/allegion/accessnfccredential/enums/AlAPDUProtocolVersion;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "onDeactivated", "", "reason", "", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "processCommandApdu", "apdu", "extras", "Landroid/os/Bundle;", "sendNotification", "Companion", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAPDUService extends HostApduService {
    public static final byte CLASS = 0;
    private byte[] nonce;
    private AlNFCPayload payload;
    private AlAPDUProtocolVersion protocolVersion = AlAPDUProtocolVersion.SCHLAGE_ACCESS;

    @RestrictTo({RestrictTo.Scope.TESTS})
    private boolean started;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AlAPDUProtocolVersion.values().length];
            $EnumSwitchMapping$0 = iArr;
            AlAPDUProtocolVersion alAPDUProtocolVersion = AlAPDUProtocolVersion.SCHLAGE_ACCESS;
            iArr[alAPDUProtocolVersion.ordinal()] = 1;
            int[] iArr2 = new int[AlAPDUProtocolVersion.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[alAPDUProtocolVersion.ordinal()] = 1;
            int[] iArr3 = new int[AlAPDUProtocolVersion.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[alAPDUProtocolVersion.ordinal()] = 1;
        }
    }

    public final boolean getStarted() {
        return this.started;
    }

    public final void setStarted(boolean z) {
        this.started = z;
    }

    @Override // android.app.Service
    public int onStartCommand(@NotNull Intent intent, int flags, int startId) {
        byte[] it;
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        AlLog.v("onStartCommand: " + intent + ", " + flags + ", " + startId, new Object[0]);
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && (it = extras.getByteArray(AlAPDUParameterKey.PAYLOAD.getKind())) != null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                this.payload = new AlNFCPayload(it);
            }
        } catch (AlNFCComponentException e) {
            Intent intent2 = new Intent();
            intent2.setAction(AlAPDUInstruction.VERIFY.toString());
            intent2.putExtra(AlAPDUParameterKey.VERIFY_STATUS.toString(), AlAPDUVerifyResponse.ERROR.toByteArray());
            intent2.putExtra("message", e.getErrorMessage());
            sendNotification(intent2);
        } catch (Exception e2) {
            Intent intent3 = new Intent();
            intent3.setAction(AlAPDUInstruction.VERIFY.toString());
            intent3.putExtra(AlAPDUParameterKey.VERIFY_STATUS.toString(), AlAPDUVerifyResponse.ERROR.toByteArray());
            intent3.putExtra("message", e2.getMessage());
            sendNotification(intent3);
        }
        this.started = true;
        return 1;
    }

    @Override // android.nfc.cardemulation.HostApduService
    @Nullable
    public byte[] processCommandApdu(@Nullable byte[] apdu, @Nullable Bundle extras) throws AlNFCComponentException {
        AlNFCComponentException alNFCComponentException = new AlNFCComponentException("Protocol not implemented.");
        byte[] response = null;
        if (apdu != null) {
            AlAPDUParser alAPDUParser = new AlAPDUParser(apdu);
            if (alAPDUParser.getCla() == 0) {
                Intent intent = new Intent();
                try {
                    byte ins = alAPDUParser.getIns();
                    AlAPDUInstruction alAPDUInstruction = AlAPDUInstruction.SELECT;
                    if (ins == alAPDUInstruction.toByte()) {
                        AlSelectApplication alSelectApplication = new AlSelectApplication(apdu);
                        AlLog.d("Received Select Application Message: " + Hex.toHexString(apdu), new Object[0]);
                        response = AlAPDUResponse.INSTANCE.getSuccess();
                        intent.setAction(alAPDUInstruction.toString());
                        Intrinsics.checkExpressionValueIsNotNull(intent.putExtra(AlAPDUParameterKey.APPLICATION_ID.toString(), alSelectApplication.getApplicationID()), "intent.putExtra(AlAPDUPa…pplication.applicationID)");
                    } else {
                        AlAPDUInstruction alAPDUInstruction2 = AlAPDUInstruction.GET_CHALLENGE;
                        if (ins == alAPDUInstruction2.toByte()) {
                            AlGetChallenge alGetChallenge = new AlGetChallenge(apdu);
                            AlLog.d("Received Get Challenge Message: " + Hex.toHexString(apdu), new Object[0]);
                            response = alGetChallenge.getResponse();
                            if (response == null) {
                                throw new AlNFCComponentException("Get Challenge Message Response Failed.");
                            }
                            this.nonce = alGetChallenge.getNonce();
                            this.protocolVersion = alGetChallenge.getProtocolVersion();
                            intent.setAction(alAPDUInstruction2.toString());
                            intent.putExtra(AlAPDUParameterKey.LOCATION_ID.toString(), alGetChallenge.getLocationID());
                            Intrinsics.checkExpressionValueIsNotNull(intent.putExtra(AlAPDUParameterKey.PROTOCOL_VERSION.toString(), this.protocolVersion.toInt()), "intent.putExtra(AlAPDUPa… protocolVersion.toInt())");
                        } else {
                            AlAPDUInstruction alAPDUInstruction3 = AlAPDUInstruction.MUTUAL_AUTHENTICATE;
                            if (ins == alAPDUInstruction3.toByte()) {
                                if (WhenMappings.$EnumSwitchMapping$0[this.protocolVersion.ordinal()] == 1) {
                                    byte[] bArr = this.nonce;
                                    if (bArr == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    AlMutualAuthentication alMutualAuthentication = new AlMutualAuthentication(apdu, bArr);
                                    AlLog.d("Received Mutual Authentication Message: " + Hex.toHexString(apdu), new Object[0]);
                                    response = alMutualAuthentication.getResponse();
                                    intent.setAction(alAPDUInstruction3.toString());
                                } else {
                                    throw alNFCComponentException;
                                }
                            } else {
                                AlAPDUInstruction alAPDUInstruction4 = AlAPDUInstruction.GET_DATA;
                                if (ins == alAPDUInstruction4.toByte()) {
                                    AlNFCPayload alNFCPayload = this.payload;
                                    if (alNFCPayload != null) {
                                        if (WhenMappings.$EnumSwitchMapping$1[this.protocolVersion.ordinal()] == 1) {
                                            AlGetData alGetData = new AlGetData(apdu, alNFCPayload);
                                            AlLog.d("Received Get Data Message: " + Hex.toHexString(apdu), new Object[0]);
                                            response = alGetData.getResponse();
                                            intent.setAction(alAPDUInstruction4.toString());
                                        } else {
                                            throw alNFCComponentException;
                                        }
                                    } else {
                                        throw new AlNFCComponentException("Payload is invalid or missing.");
                                    }
                                } else {
                                    AlAPDUInstruction alAPDUInstruction5 = AlAPDUInstruction.VERIFY;
                                    if (ins == alAPDUInstruction5.toByte()) {
                                        if (WhenMappings.$EnumSwitchMapping$2[this.protocolVersion.ordinal()] == 1) {
                                            AlVerify alVerify = new AlVerify(apdu);
                                            AlLog.d("Received Verify Message: " + Hex.toHexString(apdu), new Object[0]);
                                            response = alVerify.getResponse();
                                            intent.setAction(alAPDUInstruction5.toString());
                                            intent.putExtra(AlAPDUParameterKey.VERIFY_STATUS.toString(), alVerify.getStatus().toByteArray());
                                        } else {
                                            throw alNFCComponentException;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (AlNFCComponentException e) {
                    intent.setAction(AlAPDUInstruction.VERIFY.toString());
                    intent.putExtra(AlAPDUParameterKey.VERIFY_STATUS.toString(), AlAPDUVerifyResponse.ERROR.toByteArray());
                    intent.putExtra("message", e.getErrorMessage());
                } catch (Exception e2) {
                    intent.setAction(AlAPDUInstruction.VERIFY.toString());
                    intent.putExtra(AlAPDUParameterKey.VERIFY_STATUS.toString(), AlAPDUVerifyResponse.ERROR.toByteArray());
                    intent.putExtra("message", e2.getMessage());
                }
                sendNotification(intent);
            }
        }
        if (response == null) {
            String hexString = Hex.toHexString(apdu);
            Intrinsics.checkExpressionValueIsNotNull(hexString, "Hex.toHexString(apdu)");
            AlLog.d(hexString, new Object[0]);
        } else {
            AlLog.d("Response Message: " + Hex.toHexString(response), new Object[0]);
        }
        return response;
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int reason) {
        AlLog.v("onDeactivated(" + reason + CoreConstants.RIGHT_PARENTHESIS_CHAR, new Object[0]);
        if (reason == 0) {
            AlLog.i("Deactivated: NFC link lost", new Object[0]);
        } else if (reason == 1) {
            AlLog.i("Deactivated: Different Application ID was selected", new Object[0]);
        } else {
            AlLog.i("Deactivated: " + reason, new Object[0]);
        }
        Intent intent = new Intent();
        intent.setAction(AlAPDUInstruction.TERMINATE_CARD_USAGE.toString());
        intent.putExtra(AlAPDUParameterKey.DEACTIVATION_REASON.toString(), reason);
        try {
            sendBroadcast(intent);
        } catch (Exception unused) {
            AlLog.d("No BroadcastReceiver registered.", new Object[0]);
        }
    }

    private final void sendNotification(Intent intent) {
        try {
            sendBroadcast(intent);
        } catch (Exception unused) {
            AlLog.d("No BroadcastReceiver registered.", new Object[0]);
        }
    }
}
