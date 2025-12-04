package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.listeners.IAlAccessDeviceListener;
import com.allegion.accesssdk.models.AlAccessRequest;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface IAlAccessDevice {
    AlDeviceType getDeviceType();

    void sendPayload(AlAccessRequest alAccessRequest) throws AlException;

    void setAccessDeviceListener(@Nullable IAlAccessDeviceListener iAlAccessDeviceListener);
}
