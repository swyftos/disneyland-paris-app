package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlDeviceSearchResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
interface IAlDeviceSearchService {
    Observable<AlDeviceSearchResponse> startScanner(int i);

    void stopScanner();
}
