package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.listeners.IAlDeviceSearchListener;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface IAlDeviceSearchUtility {
    void cancelSearch(AlDeviceType[] alDeviceTypeArr);

    void searchForDevices(AlDeviceType[] alDeviceTypeArr, int i);

    void setDeviceSearchListener(@Nullable IAlDeviceSearchListener iAlDeviceSearchListener);
}
