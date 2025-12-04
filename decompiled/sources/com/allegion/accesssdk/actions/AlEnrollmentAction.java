package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class AlEnrollmentAction implements IAlActionSingleExecution<AlImmutableEnrollmentRequest, AlEnrollDeviceResponse> {
    AlEnrollmentAction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$run$0(AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) throws Exception {
        AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest = new AlImmutableEnrollmentRegisterDeviceRequest(alImmutableEnrollmentRequest.getIgnoreCache());
        return AlSdkConfiguration.getActionProvider().getEnrollmentRegisterDeviceActionFactory().create(alImmutableEnrollmentRegisterDeviceRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>) alImmutableEnrollmentRegisterDeviceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AlImmutableEnrollmentConnectedAccountRequest lambda$run$1(RegisterDeviceMAHResponse registerDeviceMAHResponse, AlImmutableEnrollmentRequest alImmutableEnrollmentRequest, CreateAccountMAHResponse createAccountMAHResponse) throws Exception {
        return new AlImmutableEnrollmentConnectedAccountRequest(registerDeviceMAHResponse.getId(), createAccountMAHResponse.getId(), alImmutableEnrollmentRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$run$2(final AlImmutableEnrollmentRequest alImmutableEnrollmentRequest, final RegisterDeviceMAHResponse registerDeviceMAHResponse) throws Exception {
        AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest = new AlImmutableEnrollmentCreateAccountRequest(registerDeviceMAHResponse.getId(), alImmutableEnrollmentRequest.getIgnoreCache());
        return AlSdkConfiguration.getActionProvider().getEnrollmentCreateAccountActionFactory().create(alImmutableEnrollmentCreateAccountRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>) alImmutableEnrollmentCreateAccountRequest).map(new Function() { // from class: com.allegion.accesssdk.actions.AlEnrollmentAction$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlEnrollmentAction.lambda$run$1(registerDeviceMAHResponse, alImmutableEnrollmentRequest, (CreateAccountMAHResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AlEnrollDeviceResponse lambda$run$3(AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse createConnectedAccountMAHResponse) throws Exception {
        return new AlEnrollDeviceResponse(alImmutableEnrollmentConnectedAccountRequest.deviceId, alImmutableEnrollmentConnectedAccountRequest.accountId, createConnectedAccountMAHResponse.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$run$4(final AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest) throws Exception {
        return AlSdkConfiguration.getActionProvider().getEnrollmentConnectedAccountActionFactory().create(alImmutableEnrollmentConnectedAccountRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse>) alImmutableEnrollmentConnectedAccountRequest).map(new Function() { // from class: com.allegion.accesssdk.actions.AlEnrollmentAction$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlEnrollmentAction.lambda$run$3(alImmutableEnrollmentConnectedAccountRequest, (CreateConnectedAccountMAHResponse) obj);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single<AlEnrollDeviceResponse> run(final AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) {
        return Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlEnrollmentAction$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AlEnrollmentAction.lambda$run$0(alImmutableEnrollmentRequest);
            }
        }).flatMap(new Function() { // from class: com.allegion.accesssdk.actions.AlEnrollmentAction$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlEnrollmentAction.lambda$run$2(alImmutableEnrollmentRequest, (RegisterDeviceMAHResponse) obj);
            }
        }).flatMap(new Function() { // from class: com.allegion.accesssdk.actions.AlEnrollmentAction$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlEnrollmentAction.lambda$run$4((AlImmutableEnrollmentConnectedAccountRequest) obj);
            }
        });
    }
}
