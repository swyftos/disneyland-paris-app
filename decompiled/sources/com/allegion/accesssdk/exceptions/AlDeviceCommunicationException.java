package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceCommunicationException extends AlException {
    public AlDeviceCommunicationException() {
        super(AlErrorCode.DEVICE_COMMUNICATION_FAIL, "Device communication failed", "");
    }

    public AlDeviceCommunicationException(String str) {
        super(AlErrorCode.DEVICE_COMMUNICATION_FAIL, str, "");
    }

    public AlDeviceCommunicationException(String str, Throwable th) {
        super(AlErrorCode.DEVICE_COMMUNICATION_FAIL, str, "", th);
    }

    public AlDeviceCommunicationException(Throwable th) {
        super(AlErrorCode.DEVICE_COMMUNICATION_FAIL, "Device communication failed", "", th);
    }
}
