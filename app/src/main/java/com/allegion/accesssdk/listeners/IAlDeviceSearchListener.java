package com.allegion.accesssdk.listeners;

import com.allegion.accesssdk.interfaces.IAlAccessDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface IAlDeviceSearchListener {
    void onAccessDeviceFound(IAlAccessDevice iAlAccessDevice);

    void onError(Throwable th);

    void onScanStateChange(Boolean bool);
}
