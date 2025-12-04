package com.allegion.accesssdk.models;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlAccessDevice;

/* loaded from: classes2.dex */
public final class AlDeviceSearchResponse {
    private final IAlAccessDevice accessDevice;

    public AlDeviceSearchResponse(IAlAccessDevice iAlAccessDevice) {
        this.accessDevice = (IAlAccessDevice) AlObjects.requireNonNull(iAlAccessDevice, "AccessDevice must not be null", AlErrorCode.SDK_NULL_VALUE_ERROR);
    }

    public final IAlAccessDevice getAccessDevice() {
        return this.accessDevice;
    }
}
