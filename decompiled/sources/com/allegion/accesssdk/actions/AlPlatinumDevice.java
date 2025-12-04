package com.allegion.accesssdk.actions;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.allegion.accessblecredential.ble.CredentialBLEDevice;
import com.allegion.accessblecredential.ble.CredentialBLEPeripheral;
import com.allegion.accessblecredential.communication.AlPlatinumMediator;
import com.allegion.accessblecredential.communication.IAlBLEConfig;
import com.allegion.accessblecredential.enums.AlProtocolVersion;
import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener;
import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.enums.AlPayloadState;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlDeviceBusyException;
import com.allegion.accesssdk.exceptions.AlDeviceCommunicationException;
import com.allegion.accesssdk.exceptions.AlDeviceException;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlAccessDevice;
import com.allegion.accesssdk.listeners.IAlAccessDeviceListener;
import com.allegion.accesssdk.models.AlAccessRequest;
import com.allegion.accesssdk.models.AlAccessResponse;
import com.allegion.accesssdk.models.AlPayload;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.utilities.Constants;
import com.allegion.core.exception.BleException;
import com.allegion.logging.AlLog;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.Nullable;
import kotlin.Deprecated;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public class AlPlatinumDevice implements IAlAccessDevice, IOnPeripheralInteractionListener {
    private int NO_TOUR_PAYLOAD_INDEX = 0;
    private IAlAnalyticsService analyticsService;
    private HashMap<String, Serializable> analyticsValues;
    private CredentialBLEDevice bleDevice;
    private boolean clearToSendPayload;
    protected Handler credentialTimeoutHandler;
    private Runnable credentialTimeoutRunnable;
    private CredentialBLEPeripheral currentDevice;
    private AlPayloadState currentPayloadState;
    private IAlAccessDeviceListener iAlAccessDeviceListener;
    private IAlAccessDeviceListener noOpListener;
    private Queue<byte[]> out;
    private AlPlatinumMediator platinumMediator;
    private AlImmutableDeviceAccessRequest request;
    private String rightId;

    public AlPlatinumDevice(CredentialBLEDevice credentialBLEDevice) throws AlDeviceException {
        IAlAccessDeviceListener iAlAccessDeviceListener = new IAlAccessDeviceListener(this) { // from class: com.allegion.accesssdk.actions.AlPlatinumDevice.1
            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadError(Throwable th) {
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadStateChange(AlAccessResponse alAccessResponse) {
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadTimeout(AlAccessResponse alAccessResponse) {
            }
        };
        this.noOpListener = iAlAccessDeviceListener;
        this.currentDevice = null;
        this.iAlAccessDeviceListener = iAlAccessDeviceListener;
        this.currentPayloadState = AlPayloadState.IDLE;
        this.credentialTimeoutRunnable = new Runnable() { // from class: com.allegion.accesssdk.actions.AlPlatinumDevice$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.analyticsValues = new HashMap<>();
        this.out = new LinkedBlockingQueue();
        this.clearToSendPayload = true;
        this.credentialTimeoutHandler = new Handler(Looper.getMainLooper());
        this.bleDevice = credentialBLEDevice;
        try {
            CredentialBLEPeripheral credentialBLEPeripheral = getCredentialBLEPeripheral(credentialBLEDevice);
            this.currentDevice = credentialBLEPeripheral;
            this.platinumMediator = new AlPlatinumMediator(credentialBLEPeripheral, (IAlBLEConfig) AlSdkConfiguration.getConfig(), this);
            this.analyticsService = (IAlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class);
        } catch (AlBleComponentException e) {
            throw new AlDeviceException(e);
        }
    }

    private Long getAnalyticsTimeValue(String str) {
        HashMap<String, Serializable> map = this.analyticsValues;
        if (map == null || map.isEmpty() || !this.analyticsValues.containsKey(str) || !(this.analyticsValues.get(str) instanceof Long)) {
            return 0L;
        }
        return (Long) this.analyticsValues.get(str);
    }

    static CredentialBLEPeripheral getCredentialBLEPeripheral(CredentialBLEDevice credentialBLEDevice) throws AlBleComponentException {
        return new CredentialBLEPeripheral(credentialBLEDevice.getBluetoothDevice(), credentialBLEDevice.getSerialNumber(), credentialBLEDevice.getDeviceProtocolVersion(), AlSdkConfiguration.getConfig().getContext());
    }

    private List<AlPayload> getNoTourPayloads(AlPayload[] alPayloadArr) {
        AlLog.d("getNoTourPayloads: method called", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (AlPayload alPayload : alPayloadArr) {
            AlLog.d("Device serial number: " + this.bleDevice.getSerialNumber(), new Object[0]);
            AlLog.d("payload device ID: " + alPayload.getDeviceId(), new Object[0]);
            if (alPayload.getType() == AlPayloadType.BLE_Platinum_NoTour && this.bleDevice.getSerialNumber().equals(alPayload.getDeviceId())) {
                arrayList.add(alPayload);
            }
        }
        AlLog.d(arrayList.size() + " no tour payload(s) found", new Object[0]);
        return arrayList;
    }

    private String getPayloadsCacheKey() {
        String string = "";
        if (this.rightId == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("access.payloads.");
        IAlStorageService iAlStorageService = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
        sb.append(iAlStorageService.contains(Constants.URI_ACCOUNT_ID) ? ((CreateAccountMAHResponse) iAlStorageService.retrieve(Constants.URI_ACCOUNT_ID, CreateAccountMAHResponse.class)).getId().toString() : "");
        sb.append(InstructionFileId.DOT);
        sb.append(this.rightId);
        sb.append(InstructionFileId.DOT);
        IAlStorageService iAlStorageService2 = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
        if (iAlStorageService2.contains(Constants.URI_DEVICE_ID)) {
            RegisterDeviceMAHResponse registerDeviceMAHResponse = (RegisterDeviceMAHResponse) iAlStorageService2.retrieve(Constants.URI_DEVICE_ID, RegisterDeviceMAHResponse.class);
            AlLog.d("Cached device id: " + registerDeviceMAHResponse.getId().toString(), new Object[0]);
            string = registerDeviceMAHResponse.getId().toString();
        }
        sb.append(string);
        return sb.toString();
    }

    private AlPullPayloadsResponse getPullPayloadsResponse() {
        IAlStorageService iAlStorageService = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
        if (iAlStorageService.contains(getPayloadsCacheKey())) {
            return (AlPullPayloadsResponse) iAlStorageService.retrieve(getPayloadsCacheKey(), AlPullPayloadsResponse.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        resetState(true);
    }

    private void processOutQueue() {
        AlLog.d("processOutQueue: method called", new Object[0]);
        try {
            if (this.platinumMediator == null || this.out.isEmpty()) {
                return;
            }
            AlLog.d("Sending payload...", new Object[0]);
            this.platinumMediator.sendPayload(this.out.poll());
            this.credentialTimeoutHandler.postDelayed(this.credentialTimeoutRunnable, 20000L);
        } catch (AlBleComponentException e) {
            AlLog.d(e);
        }
    }

    public void clearDeviceCache() {
        this.platinumMediator.clearDeviceCache();
    }

    public void connect() {
        AlLog.d("connect: method called", new Object[0]);
        AlObjects.requireNonNull(this.bleDevice.getBluetoothDevice(), "CredentialBleDevice not initialized", AlErrorCode.DEVICE_NULL_ERROR);
        if (this.currentDevice.isConnected()) {
            return;
        }
        new AlDeviceSearchUtility().cancelSearch(new AlDeviceType[]{AlDeviceType.BLE_Platinum});
        this.currentDevice.connect();
        AlPayloadState alPayloadState = AlPayloadState.CONNECTING;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Connecting", Long.valueOf(System.currentTimeMillis()));
    }

    public void disconnect() {
        AlLog.d("disconnect: method called", new Object[0]);
        CredentialBLEPeripheral credentialBLEPeripheral = this.currentDevice;
        if (credentialBLEPeripheral != null) {
            credentialBLEPeripheral.disconnect(false);
        }
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bleDevice.getBluetoothDevice();
    }

    @Deprecated(message = "Future versions will remove direct access to the device. Appropriate access methods / properties should be used instead.")
    public CredentialBLEDevice getCurrentDevice() {
        return this.bleDevice;
    }

    public AlPayloadState getCurrentPayloadState() {
        return this.currentPayloadState;
    }

    public AlProtocolVersion getDeviceProtocolVersion() {
        return this.bleDevice.getDeviceProtocolVersion();
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    public AlDeviceType getDeviceType() {
        return AlDeviceType.BLE_Platinum;
    }

    public String getName() {
        return this.bleDevice.getName();
    }

    public int getRssiSearchValue() {
        return this.bleDevice.getRssiSearchValue();
    }

    public String getSerialNumber() {
        return this.bleDevice.getSerialNumber();
    }

    public String getUuid() {
        return this.bleDevice.getUuid();
    }

    public boolean isShortRange() {
        return this.bleDevice.getIsShortRange();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onConnectPeripheral() {
        AlLog.d("onConnectPeripheral: method called", new Object[0]);
        AlPayloadState alPayloadState = AlPayloadState.CONNECTED;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Connected", Long.valueOf(System.currentTimeMillis()));
        this.analyticsService.trackSuccess("Platinum Device ", "Connect", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Connected").longValue() - getAnalyticsTimeValue("Device Connecting").longValue())));
        if (this.request == null || !this.currentDevice.isConnected()) {
            return;
        }
        this.out.add(this.request.getPayload().getCredential());
        processOutQueue();
        this.request = null;
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onDataFailure() {
        AlLog.d("onDataFailure: method called", new Object[0]);
        this.analyticsService.trackFail("Platinum Device ", "Send No Tour Payload", Pair.create("key", null));
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        AlPayloadState alPayloadState = AlPayloadState.DATA_FAIL;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.NO_TOUR_PAYLOAD_INDEX++;
        processOutQueue();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onDataSuccess() {
        AlLog.d("onDataSuccess: method called", new Object[0]);
        this.analyticsService.trackSuccess("Platinum Device ", "Send No Tour Payload", Pair.create("key", null));
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        AlPayloadState alPayloadState = AlPayloadState.DATA_SUCCESS;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        AlPullPayloadsResponse pullPayloadsResponse = getPullPayloadsResponse();
        if (pullPayloadsResponse != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(pullPayloadsResponse.getPayloads()));
            arrayList.remove(((ArrayList) getNoTourPayloads(pullPayloadsResponse.getPayloads())).get(this.NO_TOUR_PAYLOAD_INDEX));
            AlPullPayloadsResponse alPullPayloadsResponse = new AlPullPayloadsResponse((AlPayload[]) arrayList.toArray(new AlPayload[0]));
            IAlStorageService iAlStorageService = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
            if (StringUtils.isNotEmpty(getPayloadsCacheKey())) {
                iAlStorageService.store(getPayloadsCacheKey(), alPullPayloadsResponse);
            }
        }
        processOutQueue();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onDisconnectPeripheral() {
        AlLog.d("onDisconnectPeripheral: method called", new Object[0]);
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        AlPayloadState alPayloadState = AlPayloadState.IDLE;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        IAlAnalyticsService iAlAnalyticsService = this.analyticsService;
        long jLongValue = getAnalyticsTimeValue("Device Connected").longValue() - getAnalyticsTimeValue("Device Connecting").longValue();
        long jLongValue2 = getAnalyticsTimeValue("Device Result").longValue() - getAnalyticsTimeValue("Device Sending").longValue();
        this.analyticsValues.put("Connect Time", Long.valueOf(jLongValue));
        this.analyticsValues.put("Credential Time", Long.valueOf(jLongValue2));
        this.analyticsValues.put("Device Model", this.bleDevice.getDeviceType() != null ? this.bleDevice.getDeviceType().toString() : "Unknown");
        this.analyticsValues.put("Device RSSI", this.bleDevice.getRssiSearchValue() != 0 ? Integer.toString(this.bleDevice.getRssiSearchValue()) : "Unknown");
        iAlAnalyticsService.trackEvent("Platinum Device ", "Send Payload", new Pair("Device Analytics", this.analyticsValues));
        resetState(false);
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onDoorUnlockFailed() {
        AlLog.d("onDoorUnlockFailed: method called", new Object[0]);
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        AlPayloadState alPayloadState = AlPayloadState.ACCESS_FAIL;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
        this.analyticsService.trackFail("Platinum Device ", "Send Payload", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Result").longValue() - getAnalyticsTimeValue("Device Sending").longValue())));
        this.clearToSendPayload = true;
        processOutQueue();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onDoorUnlocked(long j, long j2) {
        AlLog.d("onDoorUnlocked: method called", new Object[0]);
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        AlPayloadState alPayloadState = AlPayloadState.ACCESS_SUCCESS;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
        this.analyticsService.trackSuccess("Platinum Device ", "Send Payload", new Pair("Time [ms]", Long.valueOf(getAnalyticsTimeValue("Device Result").longValue() - getAnalyticsTimeValue("Device Sending").longValue())));
        this.clearToSendPayload = true;
        processOutQueue();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onError(@NotNull Exception exc) {
        AlLog.d("onError: method called", new Object[0]);
        if (exc instanceof BleException) {
            this.analyticsService.trackEvent("Platinum Device ", "Send Payload", new Pair("Error", new AlException(AlErrorCode.DEVICE_CONNECTION_FAIL.getValue())));
        } else if (exc instanceof AlBleComponentException) {
            exc = new AlDeviceCommunicationException();
        }
        this.iAlAccessDeviceListener.onPayloadError(exc);
        this.clearToSendPayload = true;
        processOutQueue();
    }

    @Override // com.allegion.accessblecredential.listeners.IOnPeripheralInteractionListener
    public void onSendingCredential() {
        AlLog.d("onSendingCredential: method called", new Object[0]);
        this.credentialTimeoutHandler.removeCallbacks(this.credentialTimeoutRunnable);
        this.credentialTimeoutHandler.postDelayed(this.credentialTimeoutRunnable, 20000L);
        this.analyticsValues.put("Device Sending", Long.valueOf(System.currentTimeMillis()));
        AlPayloadState alPayloadState = AlPayloadState.SENDING;
        this.currentPayloadState = alPayloadState;
        this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
    }

    protected void resetState(boolean z) {
        if (z) {
            this.iAlAccessDeviceListener.onPayloadTimeout(new AlAccessResponse(this.currentPayloadState));
            this.analyticsValues.put("Device Result", Long.valueOf(System.currentTimeMillis()));
            this.analyticsService.trackFail("Platinum Device ", "Send Payload", new Pair("Timeout State", this.currentPayloadState.toString()));
            AlPayloadState alPayloadState = AlPayloadState.ACCESS_FAIL;
            this.currentPayloadState = alPayloadState;
            this.iAlAccessDeviceListener.onPayloadStateChange(new AlAccessResponse(alPayloadState));
        }
        CredentialBLEPeripheral credentialBLEPeripheral = this.currentDevice;
        if (credentialBLEPeripheral != null && credentialBLEPeripheral.isConnected()) {
            this.currentDevice.disconnect(false);
        }
        this.analyticsValues.clear();
        this.out.clear();
        this.NO_TOUR_PAYLOAD_INDEX = 0;
        this.clearToSendPayload = true;
        this.rightId = null;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    public void sendPayload(AlAccessRequest alAccessRequest) throws AlDeviceBusyException {
        AlLog.d("sendPayload: method called", new Object[0]);
        AlImmutableDeviceAccessRequest alImmutableDeviceAccessRequest = new AlImmutableDeviceAccessRequest((AlAccessRequest) AlObjects.requireNonNull(alAccessRequest, "Payload invalid", AlErrorCode.DEVICE_INVALID_REQUEST));
        AlObjects.requireNonNull(this.bleDevice.getBluetoothDevice(), "CredentialBleDevice not initialized", AlErrorCode.DEVICE_NULL_ERROR);
        this.rightId = alAccessRequest.getPayload().getRightId().toString();
        if (!this.clearToSendPayload) {
            throw new AlDeviceBusyException();
        }
        this.clearToSendPayload = false;
        int iOrdinal = this.currentPayloadState.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                if (this.bleDevice.getDeviceProtocolVersion() == AlProtocolVersion.PLATINUM_V3) {
                    AlLog.d("Attempting to send no tour payloads", new Object[0]);
                    AlLog.d("sendNoTourPayloads: method called", new Object[0]);
                    AlPullPayloadsResponse pullPayloadsResponse = getPullPayloadsResponse();
                    if (pullPayloadsResponse != null) {
                        Iterator it = ((ArrayList) getNoTourPayloads(pullPayloadsResponse.getPayloads())).iterator();
                        while (it.hasNext()) {
                            AlPayload alPayload = (AlPayload) it.next();
                            this.out.add(alPayload.getCredential());
                            AlLog.d("Adding payload to send with PayloadType: " + alPayload.getType() + " Right ID: " + alPayload.getRightId() + " Device ID: " + alPayload.getDeviceId(), new Object[0]);
                        }
                    }
                }
                this.out.add(alImmutableDeviceAccessRequest.getPayload().getCredential());
                processOutQueue();
                return;
            }
            if (iOrdinal != 6 && iOrdinal != 7) {
                return;
            }
        }
        connect();
        this.request = alImmutableDeviceAccessRequest;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAccessDevice
    public void setAccessDeviceListener(@Nullable IAlAccessDeviceListener iAlAccessDeviceListener) {
        if (iAlAccessDeviceListener == null) {
            this.iAlAccessDeviceListener = this.noOpListener;
        } else {
            this.iAlAccessDeviceListener = iAlAccessDeviceListener;
        }
    }
}
