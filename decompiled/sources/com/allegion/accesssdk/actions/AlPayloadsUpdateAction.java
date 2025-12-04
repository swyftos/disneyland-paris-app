package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import io.reactivex.Single;

/* loaded from: classes2.dex */
final class AlPayloadsUpdateAction implements IAlActionSingleExecution<AlImmutablePayloadsUpdateRequest, AlPullPayloadsResponse> {
    private final IAlRightsService rightsService = (IAlRightsService) AlObjects.requireNonNull((IAlRightsService) AlSdkConfiguration.getServiceProvider().locateService(IAlRightsService.class), "Rights service must not be null");

    AlPayloadsUpdateAction() throws AlException {
    }

    @Override // com.allegion.accesssdk.actions.IAlActionSingleExecution, com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single run(Object obj) {
        return this.rightsService.updatePayloads((AlImmutablePayloadsUpdateRequest) obj);
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Object run(Object obj) throws AlException {
        return this.rightsService.updatePayloads((AlImmutablePayloadsUpdateRequest) obj);
    }

    public Single<AlPullPayloadsResponse> run(AlImmutablePayloadsUpdateRequest alImmutablePayloadsUpdateRequest) {
        return this.rightsService.updatePayloads(alImmutablePayloadsUpdateRequest);
    }
}
