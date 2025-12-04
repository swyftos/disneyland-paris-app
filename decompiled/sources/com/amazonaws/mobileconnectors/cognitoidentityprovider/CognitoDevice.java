package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import java.util.Date;

/* loaded from: classes2.dex */
public class CognitoDevice {
    private final Context context;
    private final Date createDate;
    private CognitoUserAttributes deviceAttributes;
    private final String deviceKey;
    private Date lastAccessedDate;
    private Date lastModifiedDate;
    private final CognitoUser user;

    public CognitoDevice(String str, CognitoUserAttributes cognitoUserAttributes, Date date, Date date2, Date date3, CognitoUser cognitoUser, Context context) {
        this.deviceKey = str;
        this.deviceAttributes = cognitoUserAttributes;
        this.createDate = date;
        this.lastModifiedDate = date2;
        this.lastAccessedDate = date3;
        this.user = cognitoUser;
        this.context = context;
    }

    public CognitoDevice(DeviceType deviceType, CognitoUser cognitoUser, Context context) {
        this.deviceKey = deviceType.getDeviceKey();
        this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
        this.createDate = deviceType.getDeviceCreateDate();
        this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
        this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
        this.user = cognitoUser;
        this.context = context;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public CognitoUserAttributes getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public String getDeviceAttribute(String str) {
        try {
            return this.deviceAttributes.getAttributes().get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getDeviceName() {
        return getDeviceAttribute("device_name");
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public Date getLastAccessedDate() {
        return this.lastAccessedDate;
    }

    public void getDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                try {
                    CognitoDevice cognitoDevice = CognitoDevice.this;
                    CognitoDevice.this.updateThis(cognitoDevice.getDeviceInternal(cognitoDevice.user.getCachedSession()).getDevice());
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onSuccess();
                        }
                    };
                } catch (Exception e) {
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onFailure(e);
                        }
                    };
                }
                handler.post(runnable);
            }
        }).start();
    }

    public void getDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateThis(getDeviceInternal(this.user.getCachedSession()).getDevice());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void forgetDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.2
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                try {
                    CognitoDevice cognitoDevice = CognitoDevice.this;
                    cognitoDevice.forgetDeviceInternal(cognitoDevice.user.getCachedSession());
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onSuccess();
                        }
                    };
                } catch (Exception e) {
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onFailure(e);
                        }
                    };
                }
                handler.post(runnable);
            }
        }).start();
    }

    public void forgetDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            forgetDeviceInternal(this.user.getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void rememberThisDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.3
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                try {
                    CognitoDevice cognitoDevice = CognitoDevice.this;
                    cognitoDevice.updateDeviceStatusInternal(cognitoDevice.user.getCachedSession(), "remembered");
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onSuccess();
                        }
                    };
                } catch (Exception e) {
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onFailure(e);
                        }
                    };
                }
                handler.post(runnable);
            }
        }).start();
    }

    public void rememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateDeviceStatusInternal(this.user.getCachedSession(), "remembered");
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void doNotRememberThisDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.4
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                try {
                    CognitoDevice cognitoDevice = CognitoDevice.this;
                    cognitoDevice.updateDeviceStatusInternal(cognitoDevice.user.getCachedSession(), "not_remembered");
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onSuccess();
                        }
                    };
                } catch (Exception e) {
                    runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            genericHandler.onFailure(e);
                        }
                    };
                }
                handler.post(runnable);
            }
        }).start();
    }

    public void doNotRememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateDeviceStatusInternal(this.user.getCachedSession(), "not_remembered");
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forgetDeviceInternal(CognitoUserSession cognitoUserSession) throws AmazonClientException {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (this.deviceKey != null) {
                ForgetDeviceRequest forgetDeviceRequest = new ForgetDeviceRequest();
                forgetDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                forgetDeviceRequest.setDeviceKey(this.deviceKey);
                this.user.getCognitoIdentityProviderClient().forgetDevice(forgetDeviceRequest);
                return;
            }
            throw new CognitoParameterInvalidException("Device key is null");
        }
        throw new CognitoNotAuthorizedException("User is not authorized");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetDeviceResult getDeviceInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (this.deviceKey != null) {
                GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
                getDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                getDeviceRequest.setDeviceKey(this.deviceKey);
                return this.user.getCognitoIdentityProviderClient().getDevice(getDeviceRequest);
            }
            throw new CognitoParameterInvalidException("Device key is null");
        }
        throw new CognitoNotAuthorizedException("User is not authorized");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateDeviceStatusResult updateDeviceStatusInternal(CognitoUserSession cognitoUserSession, String str) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (this.deviceKey != null) {
                UpdateDeviceStatusRequest updateDeviceStatusRequest = new UpdateDeviceStatusRequest();
                updateDeviceStatusRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                updateDeviceStatusRequest.setDeviceKey(this.deviceKey);
                updateDeviceStatusRequest.setDeviceRememberedStatus(str);
                return this.user.getCognitoIdentityProviderClient().updateDeviceStatus(updateDeviceStatusRequest);
            }
            throw new CognitoParameterInvalidException("Device key is invalid");
        }
        throw new CognitoNotAuthorizedException("User is not authorized");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateThis(DeviceType deviceType) {
        if (deviceType == null) {
            throw new CognitoInternalErrorException("Service returned null object, this object was not updated");
        }
        if (!deviceType.getDeviceKey().equals(this.deviceKey)) {
            throw new CognitoInternalErrorException("Service error, this object was not updated");
        }
        this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
        this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
        this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
    }
}
