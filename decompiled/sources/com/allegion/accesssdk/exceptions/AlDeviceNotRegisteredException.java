package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceNotRegisteredException extends AlException {
    public AlDeviceNotRegisteredException() {
        super(AlErrorCode.SDK_DEVICE_NOT_REGISTERED, "Device is not registered, please perform enrollment before continuing.", "403");
    }

    public AlDeviceNotRegisteredException(String str) {
        super(AlErrorCode.SDK_DEVICE_NOT_REGISTERED, str, "403");
    }

    public AlDeviceNotRegisteredException(String str, Throwable th) {
        super(AlErrorCode.SDK_DEVICE_NOT_REGISTERED, str, "403", th);
    }

    public AlDeviceNotRegisteredException(Throwable th) {
        super(AlErrorCode.SDK_DEVICE_NOT_REGISTERED, "Device is not registered, please perform enrollment before continuing.", "403", th);
    }
}
