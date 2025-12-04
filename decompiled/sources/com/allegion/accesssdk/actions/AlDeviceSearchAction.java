package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.actions.interfaces.IAlAction;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlDeviceSearchResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
final class AlDeviceSearchAction implements IAlAction {
    private final IAlDeviceSearchService deviceSearchService = (IAlDeviceSearchService) AlObjects.requireNonNull((IAlDeviceSearchService) AlSdkConfiguration.getServiceProvider().locateService(IAlDeviceSearchService.class), "Device search service must not be null");

    AlDeviceSearchAction() {
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Object run(Object obj) throws AlException {
        return this.deviceSearchService.startScanner((int) ((AlImmutableDeviceSearchRequest) obj).getSearchTime());
    }

    public Observable<AlDeviceSearchResponse> run(AlImmutableDeviceSearchRequest alImmutableDeviceSearchRequest) {
        return this.deviceSearchService.startScanner((int) alImmutableDeviceSearchRequest.getSearchTime());
    }
}
