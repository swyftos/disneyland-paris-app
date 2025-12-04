package com.allegion.accesssdk.listeners;

import com.allegion.accesssdk.models.AlAccessResponse;

/* loaded from: classes2.dex */
public interface IAlAccessDeviceListener {
    void onPayloadError(Throwable th);

    void onPayloadStateChange(AlAccessResponse alAccessResponse);

    void onPayloadTimeout(AlAccessResponse alAccessResponse);
}
