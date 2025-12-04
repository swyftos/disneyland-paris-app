package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlEnrollDeviceRequest;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface IAlEnrollmentManager {
    void enrollDevice(AlEnrollDeviceRequest alEnrollDeviceRequest);

    void setEnrollDeviceListener(@Nullable IAlListener.Success<AlEnrollDeviceResponse> success, @Nullable IAlListener.Error<Throwable> error);

    void setEnrollDeviceListener(@Nullable IAlListener<AlEnrollDeviceResponse> iAlListener);
}
