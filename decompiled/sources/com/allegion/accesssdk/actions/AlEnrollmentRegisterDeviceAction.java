package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.actions.AlSdkConfiguration;
import com.allegion.accesssdk.exceptions.AlObjects;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final class AlEnrollmentRegisterDeviceAction implements IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse> {
    private final IAlEnrollmentProvidable enrollmentService = (IAlEnrollmentProvidable) AlObjects.requireNonNull((IAlEnrollmentProvidable) AlSdkConfiguration.getServiceProvider().locateService(IAlEnrollmentProvidable.class), "Enrollment service must not be null");

    AlEnrollmentRegisterDeviceAction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$0(RegisterDeviceMAHResponse registerDeviceMAHResponse, AlMutableSdkConfiguration alMutableSdkConfiguration) {
        alMutableSdkConfiguration.setDeviceId(registerDeviceMAHResponse.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$1(final RegisterDeviceMAHResponse registerDeviceMAHResponse) throws Exception {
        AlSdkConfiguration.updateConfig(new AlSdkConfiguration.UpdateWorkingConfig() { // from class: com.allegion.accesssdk.actions.AlEnrollmentRegisterDeviceAction$$ExternalSyntheticLambda1
            @Override // com.allegion.accesssdk.actions.AlSdkConfiguration.UpdateWorkingConfig
            public final void update(AlMutableSdkConfiguration alMutableSdkConfiguration) {
                AlEnrollmentRegisterDeviceAction.lambda$run$0(registerDeviceMAHResponse, alMutableSdkConfiguration);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single<RegisterDeviceMAHResponse> run(AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest) {
        return this.enrollmentService.registerDevice(alImmutableEnrollmentRegisterDeviceRequest).doOnSuccess(new Consumer() { // from class: com.allegion.accesssdk.actions.AlEnrollmentRegisterDeviceAction$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                AlEnrollmentRegisterDeviceAction.lambda$run$1((RegisterDeviceMAHResponse) obj);
            }
        });
    }
}
