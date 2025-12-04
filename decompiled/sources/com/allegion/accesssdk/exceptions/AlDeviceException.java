package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceException extends AlException {
    public AlDeviceException() {
        super(AlErrorCode.DEVICE_UNKNOWN_ERROR, "An unknown error occurred while attempting to access the device.", "");
    }

    public AlDeviceException(String str) {
        super(AlErrorCode.DEVICE_UNKNOWN_ERROR, str, "");
    }

    public AlDeviceException(String str, Throwable th) {
        super(AlErrorCode.DEVICE_UNKNOWN_ERROR, str, "", th);
    }

    public AlDeviceException(Throwable th) {
        super(AlErrorCode.DEVICE_UNKNOWN_ERROR, "An unknown error occurred while attempting to access the device.", "", th);
    }
}
