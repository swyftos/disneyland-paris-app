package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import io.reactivex.Single;

/* loaded from: classes2.dex */
final class AlEnrollmentConnectedAccountAction implements IAlActionSingleExecution<AlImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse> {
    private final IAlEnrollmentProvidable enrollmentService = (IAlEnrollmentProvidable) AlObjects.requireNonNull((IAlEnrollmentProvidable) AlSdkConfiguration.getServiceProvider().locateService(IAlEnrollmentProvidable.class), "Enrollment service must not be null");

    AlEnrollmentConnectedAccountAction() throws AlException {
    }

    @Override // com.allegion.accesssdk.actions.IAlActionSingleExecution, com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single run(Object obj) {
        AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest = (AlImmutableEnrollmentConnectedAccountRequest) obj;
        return this.enrollmentService.connectedAccount(alImmutableEnrollmentConnectedAccountRequest.accountId, alImmutableEnrollmentConnectedAccountRequest.getEnrollmentRequest());
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Object run(Object obj) throws AlException {
        AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest = (AlImmutableEnrollmentConnectedAccountRequest) obj;
        return this.enrollmentService.connectedAccount(alImmutableEnrollmentConnectedAccountRequest.accountId, alImmutableEnrollmentConnectedAccountRequest.getEnrollmentRequest());
    }
}
