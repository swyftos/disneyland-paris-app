package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;

/* loaded from: classes2.dex */
public class AlDeviceBusyException extends AlException {
    public AlDeviceBusyException() {
        super(AlErrorCode.DEVICE_BUSY, "Device busy with previous payload", "");
    }

    public AlDeviceBusyException(String str) {
        super(AlErrorCode.DEVICE_BUSY, str, "");
    }

    public AlDeviceBusyException(String str, Throwable th) {
        super(AlErrorCode.DEVICE_BUSY, str, "", th);
    }

    public AlDeviceBusyException(Throwable th) {
        super(AlErrorCode.DEVICE_BUSY, "Device busy with previous payload", "", th);
    }
}
