package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceRegistrationException extends AlException {
    public AlDeviceRegistrationException() {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to register the device.", "");
    }

    public AlDeviceRegistrationException(String str) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "");
    }

    public AlDeviceRegistrationException(String str, Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, str, "", th);
    }

    public AlDeviceRegistrationException(Throwable th) {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to register the device.", "", th);
    }
}
