package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import io.reactivex.Single;

/* loaded from: classes2.dex */
final class AlEnrollmentCreateAccountAction implements IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse> {
    private final IAlEnrollmentProvidable enrollmentService = (IAlEnrollmentProvidable) AlObjects.requireNonNull((IAlEnrollmentProvidable) AlSdkConfiguration.getServiceProvider().locateService(IAlEnrollmentProvidable.class), "Enrollment service must not be null");

    AlEnrollmentCreateAccountAction() {
    }

    @Override // com.allegion.accesssdk.actions.IAlActionSingleExecution, com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single run(Object obj) {
        return this.enrollmentService.createAccount((AlImmutableEnrollmentCreateAccountRequest) obj);
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Object run(Object obj) throws AlException {
        return this.enrollmentService.createAccount((AlImmutableEnrollmentCreateAccountRequest) obj);
    }
}
