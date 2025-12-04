package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import io.reactivex.Single;

/* loaded from: classes2.dex */
final class AlPayloadsPullAction implements IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse> {
    private final IAlRightsService rightsService = (IAlRightsService) AlObjects.requireNonNull((IAlRightsService) AlSdkConfiguration.getServiceProvider().locateService(IAlRightsService.class), "Rights service must not be null");

    AlPayloadsPullAction() {
    }

    @Override // com.allegion.accesssdk.actions.IAlActionSingleExecution, com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single run(Object obj) {
        return this.rightsService.pullPayloads((AlImmutablePayloadsPullRequest) obj);
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Object run(Object obj) throws AlException {
        return this.rightsService.pullPayloads((AlImmutablePayloadsPullRequest) obj);
    }
}
