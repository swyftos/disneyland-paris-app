package com.allegion.accesssdk.actions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Pair;
import com.allegion.accessnfccredential.communication.AlSchlageAccessMediator;
import com.allegion.accessnfccredential.communication.IAlNFCConfig;
import com.allegion.accessnfccredential.enums.AlAPDUInstruction;
import com.allegion.accessnfccredential.enums.AlAPDUParameterKey;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener;
import com.allegion.accessnfccredential.services.AlAPDUService;
import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.enums.AlPayloadState;
import com.allegion.accesssdk.exceptions.AlDeviceCommunicationException;
import com.allegion.accesssdk.exceptions.AlDeviceException;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlAccessDevice;
import com.allegion.accesssdk.listeners.IAlAccessDeviceListener;
import com.allegion.accesssdk.models.AlAccessRequest;
import com.allegion.accesssdk.models.AlAccessResponse;
import com.allegion.accesssdk.models.AlPayload;
import com.allegion.logging.AlLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u001b\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010G\u001a\u00020\u000f¢\u0006\u0004\bH\u0010IJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u000eJ\u001b\u0010%\u001a\u00020\n2\n\u0010$\u001a\u00060\"j\u0002`#H\u0016¢\u0006\u0004\b%\u0010&R2\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020(0'j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020(`)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010;\u001a\n :*\u0004\u0018\u000109098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010\u0019R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/allegion/accesssdk/actions/AlNFCDevice;", "Lcom/allegion/accesssdk/interfaces/IAlAccessDevice;", "Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;", "", "label", "", "getAnalyticsTimeValue", "(Ljava/lang/String;)J", "Lcom/allegion/accesssdk/listeners/IAlAccessDeviceListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setAccessDeviceListener", "(Lcom/allegion/accesssdk/listeners/IAlAccessDeviceListener;)V", "cleanup", "()V", "Lcom/allegion/accesssdk/models/AlAccessRequest;", "requestPayload", "sendPayload", "(Lcom/allegion/accesssdk/models/AlAccessRequest;)V", "Lcom/allegion/accesssdk/enums/AlDeviceType;", "getDeviceType", "()Lcom/allegion/accesssdk/enums/AlDeviceType;", "", "isTimedOut", "resetState", "(Z)V", "connectionTime", "unlockTime", "onDoorUnlocked", "(JJ)V", "onDoorUnlockFailed", "onConnectPeripheral", "onSendingCredential", "onDisconnectPeripheral", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", PDFView.EVENT_ON_ERROR, "(Ljava/lang/Exception;)V", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "analyticsValues", "Ljava/util/HashMap;", "Landroid/content/Intent;", "intent", "Landroid/content/Intent;", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "setServiceConnection", "(Landroid/content/ServiceConnection;)V", "Lcom/allegion/accesssdk/enums/AlPayloadState;", "currentPayloadState", "Lcom/allegion/accesssdk/enums/AlPayloadState;", "Lcom/allegion/accesssdk/actions/AlAnalyticsService;", "kotlin.jvm.PlatformType", "analyticsService", "Lcom/allegion/accesssdk/actions/AlAnalyticsService;", "isServiceConnected", "Z", "()Z", "setServiceConnected", "noOpListener", "Lcom/allegion/accesssdk/listeners/IAlAccessDeviceListener;", "iAlAccessDeviceListener", "Lcom/allegion/accessnfccredential/communication/AlSchlageAccessMediator;", "schlageAccessMediator", "Lcom/allegion/accessnfccredential/communication/AlSchlageAccessMediator;", "accessRequest", "<init>", "(Lcom/allegion/accesssdk/listeners/IAlAccessDeviceListener;Lcom/allegion/accesssdk/models/AlAccessRequest;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlNFCDevice implements IAlAccessDevice, IAlOnNFCPeripheralInteractionListener {
    private AlAnalyticsService analyticsService;
    private final HashMap<String, Serializable> analyticsValues;
    private AlPayloadState currentPayloadState;
    private IAlAccessDeviceListener iAlAccessDeviceListener;
    private Intent intent;
    private boolean isServiceConnected;
    private final IAlAccessDeviceListener noOpListener;
    private final AlSchlageAccessMediator schlageAccessMediator;

    @NotNull
    private ServiceConnection serviceConnection;

    public AlNFCDevice(@Nullable IAlAccessDeviceListener iAlAccessDeviceListener, @NotNull AlAccessRequest accessRequest) throws AlDeviceException {
        Intrinsics.checkParameterIsNotNull(accessRequest, "accessRequest");
        this.analyticsService = (AlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class);
        this.analyticsValues = new HashMap<>();
        this.currentPayloadState = AlPayloadState.IDLE;
        IAlAccessDeviceListener iAlAccessDeviceListener2 = new IAlAccessDeviceListener() { // from class: com.allegion.accesssdk.actions.AlNFCDevice$noOpListener$1
            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadError(@NotNull Throwable error) {
                Intrinsics.checkParameterIsNotNull(error, "error");
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadStateChange(@NotNull AlAccessResponse response) {
                Intrinsics.checkParameterIsNotNull(response, "response");
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadTimeout(@NotNull AlAccessResponse response) {
                Intrinsics.checkParameterIsNotNull(response, "response");
            }
        };
        this.noOpListener = iAlAccessDeviceListener2;
        this.iAlAccessDeviceListener = iAlAccessDeviceListener2;
        this.serviceConnection = new ServiceConnection() { // from class: com.allegion.accesssdk.actions.AlNFCDevice$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(@NotNull ComponentName name, @NotNull IBinder binder) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                Intrinsics.checkParameterIsNotNull(binder, "binder");
                AlLog.d("APDU Service Connected", new Object[0]);
                this.this$0.setServiceConnected(true);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(@NotNull ComponentName name) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                AlLog.d("APDU Service Disconnected", new Object[0]);
                AlSdkConfiguration.getConfig().getContext().unbindService(this);
                this.this$0.setServiceConnected(false);
            }
        };
        AlImmutableDeviceAccessRequest immutableDeviceAccessRequest = AlImmutableProvider.build((AlAccessRequest) AlObjects.requireNonNull(accessRequest, "Payload invalid", AlErrorCode.DEVICE_INVALID_REQUEST));
        Context context = AlSdkConfiguration.getConfig().getContext();
        setAccessDeviceListener(iAlAccessDeviceListener);
        try {
            AlSchlageAccessMediator alSchlageAccessMediator = new AlSchlageAccessMediator((IAlNFCConfig) AlSdkConfiguration.getConfig(), this);
            this.schlageAccessMediator = alSchlageAccessMediator;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AlAPDUInstruction.SELECT.toString());
            intentFilter.addAction(AlAPDUInstruction.GET_CHALLENGE.toString());
            intentFilter.addAction(AlAPDUInstruction.MUTUAL_AUTHENTICATE.toString());
            intentFilter.addAction(AlAPDUInstruction.GET_DATA.toString());
            intentFilter.addAction(AlAPDUInstruction.VERIFY.toString());
            intentFilter.addAction(AlAPDUInstruction.TERMINATE_CARD_USAGE.toString());
            context.registerReceiver(alSchlageAccessMediator, intentFilter);
            Intent intent = new Intent(context, (Class<?>) AlAPDUService.class);
            this.intent = intent;
            String kind = AlAPDUParameterKey.PAYLOAD.getKind();
            Intrinsics.checkExpressionValueIsNotNull(immutableDeviceAccessRequest, "immutableDeviceAccessRequest");
            AlPayload payload = immutableDeviceAccessRequest.getPayload();
            Intrinsics.checkExpressionValueIsNotNull(payload, "immutableDeviceAccessRequest.payload");
            intent.putExtra(kind, payload.getCredential());
            context.bindService(this.intent, this.serviceConnection, 4);
            context.startService(this.intent);
        } catch (AlNFCComponentException e) {
            String errorMessage = e.getErrorMessage();
            if (errorMessage == null) {
                Intrinsics.throwNpe();
            }
            throw new AlDeviceException(errorMessage);
        }
    }

    private final long getAnalyticsTimeValue(String label) {
        if (this.analyticsValues.isEmpty() || !this.analyticsValues.containsKey(label) || !(this.analyticsValues.get(label) instanceof Long)) {
            return 0L;
        }
        Serializable serializable = this.analyticsValues.get(label);
        if (serializable != null) {
            return ((Long) serializable).longValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void cleanup() {
        if (this.isServiceConnected) {
            AlSdkConfiguration.getConfig().getContext().stopService(this.intent);
            setAccessDeviceListener(null);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    @NotNull
    public AlDeviceType getDeviceType() {
        return AlDeviceType.Nfc;
    }

    @NotNull
    protected final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    /* renamed from: isServiceConnected, reason: from getter */
    public final boolean getIsServiceConnected() {
        return this.isServiceConnected;
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onConnectPeripheral() {
        AlLog.d("onConnectPeripheral: Method Called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.CONNECTED;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Connected", Long.valueOf(System.currentTimeMillis()));
        AlAnalyticsService alAnalyticsService = this.analyticsService;
        if (alAnalyticsService == null) {
            Intrinsics.throwNpe();
        }
        alAnalyticsService.trackSuccess("NFC Device ", "Connect", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Connected") - getAnalyticsTimeValue("Device Connecting"))));
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onDisconnectPeripheral() {
        AlLog.d("onDisconnectPeripheral: Method Called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.IDLE;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        resetState(false);
        AlAnalyticsService alAnalyticsService = this.analyticsService;
        if (alAnalyticsService == null) {
            Intrinsics.throwNpe();
        }
        long analyticsTimeValue = getAnalyticsTimeValue("Device Connected") - getAnalyticsTimeValue("Device Connecting");
        long analyticsTimeValue2 = getAnalyticsTimeValue("Device Result") - getAnalyticsTimeValue("Device Sending");
        this.analyticsValues.put("Connect Time", Long.valueOf(analyticsTimeValue));
        this.analyticsValues.put("Credential Time", Long.valueOf(analyticsTimeValue2));
        alAnalyticsService.trackEvent("NFC Device ", "Send Payload", new Pair("Device Analytics", this.analyticsValues));
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onDoorUnlockFailed() {
        AlLog.d("onDoorUnlockFailed: Method Called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.ACCESS_FAIL;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
        AlAnalyticsService alAnalyticsService = this.analyticsService;
        if (alAnalyticsService == null) {
            Intrinsics.throwNpe();
        }
        alAnalyticsService.trackFail("NFC Device ", "Send Payload", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Result") - getAnalyticsTimeValue("Device Sending"))));
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onDoorUnlocked(long connectionTime, long unlockTime) {
        AlLog.d("onDoorUnlocked: Method Called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.ACCESS_SUCCESS;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
        AlAnalyticsService alAnalyticsService = this.analyticsService;
        if (alAnalyticsService == null) {
            Intrinsics.throwNpe();
        }
        alAnalyticsService.trackSuccess("NFC Device ", "Send Payload", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Result") - getAnalyticsTimeValue("Device Sending"))));
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onError(@NotNull Exception exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        AlLog.d("onError: Method Called - " + exception.getMessage(), new Object[0]);
        this.iAlAccessDeviceListener.onPayloadError(new AlDeviceCommunicationException());
    }

    @Override // com.allegion.accessnfccredential.listeners.IAlOnNFCPeripheralInteractionListener
    public void onSendingCredential() {
        AlLog.d("onSendingCredential: Method Called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.SENDING;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Sending", Long.valueOf(System.currentTimeMillis()));
    }

    protected final void resetState(boolean isTimedOut) {
        if (isTimedOut) {
            this.iAlAccessDeviceListener.onPayloadTimeout(new AlAccessResponse(this.currentPayloadState));
            AlPayloadState alPayloadState = AlPayloadState.ACCESS_FAIL;
            this.currentPayloadState = alPayloadState;
            this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
            this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
            AlAnalyticsService alAnalyticsService = this.analyticsService;
            if (alAnalyticsService == null) {
                Intrinsics.throwNpe();
            }
            alAnalyticsService.trackFail("NFC Device ", "Send Payload", new Pair("Timeout State", this.currentPayloadState.toString()));
        }
        this.analyticsValues.clear();
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    public void sendPayload(@NotNull AlAccessRequest requestPayload) throws AlException {
        Intrinsics.checkParameterIsNotNull(requestPayload, "requestPayload");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    public void setAccessDeviceListener(@Nullable IAlAccessDeviceListener listener) {
        if (listener == null) {
            this.iAlAccessDeviceListener = this.noOpListener;
        } else {
            this.iAlAccessDeviceListener = listener;
        }
    }

    public final void setServiceConnected(boolean z) {
        this.isServiceConnected = z;
    }

    protected final void setServiceConnection(@NotNull ServiceConnection serviceConnection) {
        Intrinsics.checkParameterIsNotNull(serviceConnection, "<set-?>");
        this.serviceConnection = serviceConnection;
    }
}
