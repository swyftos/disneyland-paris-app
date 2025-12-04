package com.cisa;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.allegion.accesssdk.actions.AlDeviceSearchUtility;
import com.allegion.accesssdk.actions.AlEnrollmentManager;
import com.allegion.accesssdk.actions.AlPlatinumDevice;
import com.allegion.accesssdk.actions.AlRightsManager;
import com.allegion.accesssdk.actions.AlSdkConfiguration;
import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.enums.AlPayloadState;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.interfaces.IAlAccessDevice;
import com.allegion.accesssdk.listeners.IAlAccessDeviceListener;
import com.allegion.accesssdk.listeners.IAlDeviceSearchListener;
import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlAccessRequest;
import com.allegion.accesssdk.models.AlAccessResponse;
import com.allegion.accesssdk.models.AlConfig;
import com.allegion.accesssdk.models.AlEnrollDeviceRequest;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.models.AlPayload;
import com.allegion.accesssdk.models.AlPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsRequest;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import com.allegion.accesssdk.models.AlRight;
import com.allegion.accesssdk.utilities.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class RNCisaModule extends ReactContextBaseJavaModule {
    private static final String E_ALLEGION_ENROLL = "E_ALLEGION_ENROLL";
    private static final String E_ALLEGION_FETCH_PAYLOADS = "E_ALLEGION_FETCH_PAYLOADS";
    private static final String E_ALLEGION_FETCH_RIGHTS = "E_ALLEGION_FETCH_RIGHTS";
    private static final String E_ALLEGION_INIT = "E_ALLEGION_INIT";
    private static final String E_ALLEGION_SEARCH_FOR_DEVICES = "E_ALLEGION_SEARCH_FOR_DEVICES";
    private static final String E_ALLEGION_SEND_PAYLOAD = "E_ALLEGION_SEND_PAYLOAD";
    private static final String E_ALLEGION_SUBSCRIPTION_KEY = "E_ALLEGION_SUBSCRIPTION_KEY";
    private static final String E_APPLICATION = "E_APPLICATION";
    private static final String E_ARGS_INVALID = "E_ARGS_INVALID";
    private static final String E_ARG_EMPTY = "E_ARG_EMPTY";
    private AlPlatinumDevice accessDevice;
    private AlPayload accessPayload;
    private AlRight accessRight;
    private AlDeviceSearchUtility deviceSearchUtility;
    private final ReactApplicationContext reactContext;

    public RNCisaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public static void logMessages(Object... objArr) {
        for (Object obj : objArr) {
            Log.d("[RNCisa] > ", obj.toString());
        }
    }

    public static void log(String str, String str2) {
        Log.d("[RNCisa] [" + str + "]", str2.toString());
    }

    public Application getApplication() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            new IOException("Activity not exists");
        }
        return currentActivity.getApplication();
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNCisa";
    }

    public void removeEnrollmentData() {
        removeData(Constants.URI_ENROLL + ".length");
        removeData(Constants.URI_ENROLL);
    }

    private void removeData(String str) {
        SharedPreferences sharedPreferences = this.reactContext.getSharedPreferences("com.allegion.storage.secure", 0);
        if (sharedPreferences.contains(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.apply();
        }
    }

    @ReactMethod
    public void initialize(String str, Promise promise) throws IOException {
        log("initialize", "#1 Start initialize");
        try {
            if (str.isEmpty()) {
                throw new IOException("subscriptionKey seems to be empty");
            }
            AlSdkConfiguration.setConfig(new AlConfig().setSubscriptionKey(UUID.fromString(str)).setApplication(getApplication()));
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            log("initialize", "Error : " + e.getMessage());
            promise.reject(E_ALLEGION_INIT, e.getMessage());
        }
    }

    @ReactMethod
    public void enroll(String str, String str2, final Promise promise) {
        log("enroll", "#2 Start enroll");
        AlEnrollmentManager alEnrollmentManager = new AlEnrollmentManager();
        final boolean zBooleanValue = alEnrollmentManager.isEnrolled().booleanValue();
        if (zBooleanValue) {
            log("enroll", "Device already enrolled, clean enrollment data");
            removeEnrollmentData();
        }
        AlEnrollDeviceRequest integrationId = new AlEnrollDeviceRequest().setIdToken(str).setIntegrationId(UUID.fromString(str2));
        alEnrollmentManager.setEnrollDeviceListener(new IAlListener() { // from class: com.cisa.RNCisaModule.1
            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onSuccess(AlEnrollDeviceResponse alEnrollDeviceResponse) {
                RNCisaModule.log("enroll:onSuccess", "Enroll success");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("accountId", alEnrollDeviceResponse.getAccountId().toString());
                writableMapCreateMap.putString("connectedAccountId", alEnrollDeviceResponse.getConnectedAccountId().toString());
                writableMapCreateMap.putString("deviceId", alEnrollDeviceResponse.getDeviceId().toString());
                writableMapCreateMap.putBoolean("wasAlreadyEnrolled", zBooleanValue);
                promise.resolve(writableMapCreateMap);
            }

            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onError(Throwable th) {
                RNCisaModule.log("enroll:onError", "Error : " + th.getMessage());
                promise.reject(RNCisaModule.E_ALLEGION_ENROLL, th);
            }
        });
        alEnrollmentManager.enrollDevice(integrationId);
    }

    @ReactMethod
    public void fetchRights(Boolean bool, final Promise promise) {
        log("fetchRights", "#3 Start fetching access rights");
        AlRightsManager alRightsManager = new AlRightsManager();
        AlPullRightsRequest ignoreCache = new AlPullRightsRequest().setIgnoreCache(bool.booleanValue());
        log("fetchRights", "with cache ignore set to" + bool);
        alRightsManager.setPullAccessRightsListener(new IAlListener() { // from class: com.cisa.RNCisaModule.2
            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onSuccess(AlPullRightsResponse alPullRightsResponse) throws IOException {
                RNCisaModule.log("fetchRights:onSuccess", "fetchRights call succeed");
                RNCisaModule.log("fetchRights:onSuccess", "fetchRights length : " + alPullRightsResponse.getRights().length);
                try {
                    if (alPullRightsResponse.getRights().length < 1) {
                        throw new IOException("No rights for these tokens");
                    }
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    RNCisaModule.log("fetchRights:onSuccess", "Return ONLY the first one");
                    this.accessRight = alPullRightsResponse.getRights()[0];
                    writableMapCreateMap.putString("accessRightId", this.accessRight.getId().toString());
                    writableMapCreateMap.putString("payloadType", this.accessRight.getPayloadTypes()[0].toString());
                    promise.resolve(writableMapCreateMap);
                } catch (Exception e) {
                    RNCisaModule.log("fetchRights:onSuccess", "Error : " + e.getMessage());
                    promise.reject(RNCisaModule.E_ALLEGION_FETCH_RIGHTS, e.getMessage());
                }
            }

            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onError(Throwable th) {
                RNCisaModule.log("fetchRights:onError", "Error : " + th.getMessage());
                promise.reject(RNCisaModule.E_ALLEGION_FETCH_RIGHTS, th);
            }
        });
        alRightsManager.pullAccessRights(ignoreCache);
    }

    @ReactMethod
    public void fetchPayloads(Boolean bool, String str, String str2, String str3, Promise promise) throws IOException {
        log("fetchPayloads", "#4 Start fetching access paylods");
        AlRightsManager alRightsManager = new AlRightsManager();
        try {
        } catch (IOException e) {
            log("fetchPayloads", "Error : " + e.getMessage());
            promise.reject(E_ARG_EMPTY, e);
        }
        if (str.isEmpty()) {
            throw new IOException("accessToken seems to be empty");
        }
        if (str2.isEmpty()) {
            throw new IOException("accessRightId seems to be empty");
        }
        if (str3.isEmpty()) {
            throw new IOException("payloadType seems to be empty");
        }
        log("fetchPayloads", "with cache ignore set to " + bool);
        AlPullPayloadsRequest alPullPayloadsRequestAddPayloadRequests = new AlPullPayloadsRequest().setAccessToken(str).setRightId(UUID.fromString(str2)).setIgnoreCache(bool.booleanValue()).addPayloadRequests(new AlPayloadsRequest().setPayloadType(AlPayloadType.valueOf(str3)).setPropertyBag(""));
        alRightsManager.setPullAccessPayloadsListener(new IAlListener(this, promise) { // from class: com.cisa.RNCisaModule.1FetchAccessPayloadsListener
            private RNCisaModule instance;
            final /* synthetic */ Promise val$promise;

            {
                this.val$promise = promise;
                this.instance = this;
            }

            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onSuccess(AlPullPayloadsResponse alPullPayloadsResponse) {
                RNCisaModule.log("fetchPayloads:onSuccess", "fetchPayloads success");
                this.instance.accessPayload = alPullPayloadsResponse.getPayloads()[0];
                WritableMap writableMapCreateMap = Arguments.createMap();
                String strEncodeToString = Base64.getEncoder().encodeToString(this.instance.accessPayload.getCredential());
                RNCisaModule.log("fetchPayloads:onSuccess", "accessPayload : " + strEncodeToString);
                writableMapCreateMap.putString("accessPayload", strEncodeToString);
                this.val$promise.resolve(writableMapCreateMap);
            }

            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onError(Throwable th) {
                RNCisaModule.log("fetchPayloads:onError", "Error : " + th.getMessage());
                this.val$promise.reject(RNCisaModule.E_ALLEGION_FETCH_PAYLOADS, th);
            }
        });
        alRightsManager.pullAccessPayloads(alPullPayloadsRequestAddPayloadRequests);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String isLockIdsMatchDevice(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return str2;
            }
        }
        return null;
    }

    @ReactMethod
    public void searchForDevices(ReadableArray readableArray, double d, final Promise promise) throws IOException {
        log("searchForDevices", "#5 Start searching for devices");
        this.deviceSearchUtility = new AlDeviceSearchUtility();
        final String[] lockIdsArray = BridgeUtilities.toLockIdsArray(readableArray);
        try {
        } catch (IOException e) {
            log("searchForDevices", "Error : " + e.getMessage());
            promise.reject(E_ARGS_INVALID, e);
        }
        if (lockIdsArray.length == 0) {
            throw new IOException("Lock ids array is empty !");
        }
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            throw new IOException("Search timeout is equal to 0 !");
        }
        log("searchForDevices", "with devices list : " + String.join(", ", lockIdsArray));
        this.deviceSearchUtility.setDeviceSearchListener(new IAlDeviceSearchListener() { // from class: com.cisa.RNCisaModule.3
            @Override // com.allegion.accesssdk.listeners.IAlDeviceSearchListener
            public void onAccessDeviceFound(IAlAccessDevice iAlAccessDevice) {
                if (!(iAlAccessDevice instanceof AlPlatinumDevice)) {
                    RNCisaModule.log("searchForDevices:onAccessDeviceFound", "Current device found is not an eligible Lock Id => scan continue");
                    return;
                }
                AlPlatinumDevice alPlatinumDevice = (AlPlatinumDevice) iAlAccessDevice;
                String name = alPlatinumDevice.getCurrentDevice().getName();
                RNCisaModule.log("searchForDevices:onAccessDeviceFound", "Device Found : " + name);
                String strIsLockIdsMatchDevice = RNCisaModule.this.isLockIdsMatchDevice(name, lockIdsArray);
                if (strIsLockIdsMatchDevice != null) {
                    RNCisaModule.log("searchForDevices:onAccessDeviceFound", "Wanted Device " + strIsLockIdsMatchDevice + " found !!!");
                    this.accessDevice = alPlatinumDevice;
                    RNCisaModule.log("searchForDevices:onAccessDeviceFound", "Cancel Search with device found");
                    this.deviceSearchUtility.cancelSearch(new AlDeviceType[]{AlDeviceType.BLE_Platinum});
                    this.deviceSearchUtility = null;
                }
            }

            @Override // com.allegion.accesssdk.listeners.IAlDeviceSearchListener
            public void onError(Throwable th) {
                RNCisaModule.log("searchForDevices:onError", "Error : " + th.getMessage());
                promise.reject(RNCisaModule.E_ALLEGION_SEARCH_FOR_DEVICES, th);
                this.deviceSearchUtility = null;
            }

            @Override // com.allegion.accesssdk.listeners.IAlDeviceSearchListener
            public void onScanStateChange(Boolean bool) throws IOException {
                if (bool.booleanValue()) {
                    RNCisaModule.log("searchForDevices:onScanStateChange", "Scan Starts");
                }
                if (bool.booleanValue()) {
                    return;
                }
                RNCisaModule.log("searchForDevices:onScanStateChange", "Scan Finished");
                try {
                    if (this.accessDevice != null) {
                        RNCisaModule.log("searchForDevices:onScanStateChange", "Search finished with device exists, resolve true");
                        promise.resolve(Boolean.TRUE);
                    } else {
                        RNCisaModule.log("searchForDevices:onScanStateChange", "Search finished without find any access device");
                        throw new IOException("Timeout finished without find any access device");
                    }
                } catch (IOException e2) {
                    promise.reject(RNCisaModule.E_ALLEGION_SEARCH_FOR_DEVICES, e2);
                    this.deviceSearchUtility = null;
                }
            }
        });
        this.deviceSearchUtility.searchForDevices(new AlDeviceType[]{AlDeviceType.BLE_Platinum}, (int) d);
    }

    @ReactMethod
    public void cancelSearch(Promise promise) throws IOException {
        log("cancelSearch", "#5.1 Start cancel search");
        try {
            AlDeviceSearchUtility alDeviceSearchUtility = this.deviceSearchUtility;
            if (alDeviceSearchUtility != null) {
                alDeviceSearchUtility.cancelSearch(new AlDeviceType[]{AlDeviceType.BLE_Platinum});
                log("cancelSearch", "Cancel search");
                promise.resolve(Boolean.TRUE);
                this.deviceSearchUtility = null;
                this.accessDevice = null;
                return;
            }
            throw new IOException("Trying to cancel device search, but is not currently launched...");
        } catch (IOException e) {
            log("cancelSearch", "Warning : " + e.getMessage());
            this.deviceSearchUtility = null;
            this.accessDevice = null;
        }
    }

    @ReactMethod
    public void sendPayload(final Promise promise) {
        log("sendPayload", "#6 Start sending payload");
        AlAccessRequest payload = new AlAccessRequest().setPayload(this.accessPayload);
        this.accessDevice.setAccessDeviceListener(new IAlAccessDeviceListener() { // from class: com.cisa.RNCisaModule.4
            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadStateChange(AlAccessResponse alAccessResponse) {
                if (alAccessResponse.getState() == AlPayloadState.ACCESS_SUCCESS) {
                    RNCisaModule.log("sendPayload:onPayloadStateChange", "ACCESS SUCCESS - Door opened !!!");
                    promise.resolve(Boolean.TRUE);
                    this.accessDevice = null;
                    this.deviceSearchUtility = null;
                }
                if (alAccessResponse.getState() == AlPayloadState.ACCESS_FAIL) {
                    RNCisaModule.log("sendPayload:onPayloadStateChange", "ACCESS FAILS");
                    promise.reject(RNCisaModule.E_ALLEGION_SEND_PAYLOAD, "Access fails");
                    this.accessDevice = null;
                    this.deviceSearchUtility = null;
                }
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadError(Throwable th) {
                RNCisaModule.log("sendPayload:onPayloadError", "Error : " + th.getMessage());
                promise.reject(RNCisaModule.E_ALLEGION_SEND_PAYLOAD, th);
                this.accessDevice = null;
                this.deviceSearchUtility = null;
            }

            @Override // com.allegion.accesssdk.listeners.IAlAccessDeviceListener
            public void onPayloadTimeout(AlAccessResponse alAccessResponse) {
                RNCisaModule.log("sendPayload:onPayloadTimeout", "Error : Send payload timed out ...");
                promise.reject(RNCisaModule.E_ALLEGION_SEND_PAYLOAD, "Send payload timed out ...");
                this.accessDevice = null;
                this.deviceSearchUtility = null;
            }
        });
        try {
            this.accessDevice.sendPayload(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
