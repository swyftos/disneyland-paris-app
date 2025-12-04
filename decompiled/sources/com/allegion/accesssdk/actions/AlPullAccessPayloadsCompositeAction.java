package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.actions.AlSdkConfiguration;
import com.allegion.accesssdk.actions.factories.interfaces.Factory;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Bi\b\u0000\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00010\b\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00010\b\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR.\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR.\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/allegion/accesssdk/actions/AlPullAccessPayloadsCompositeAction;", "Lcom/allegion/accesssdk/actions/IAlActionSingleExecution;", "Lcom/allegion/accesssdk/models/AlPullPayloadsRequest;", "Lcom/allegion/accesssdk/models/AlPullPayloadsResponse;", "request", "Lio/reactivex/Single;", "run", "(Lcom/allegion/accesssdk/models/AlPullPayloadsRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;", "Lcom/allegion/accesssdk/actions/AlImmutablePayloadsPullRequest;", "payloadsPullActionFactory", "Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;", "Lcom/allegion/accesssdk/actions/AlImmutableEnrollmentCreateAccountRequest;", "Lcom/allegion/accesshub/models/CreateAccountMAHResponse;", "createAccountActionFactory", "Lcom/allegion/accesssdk/actions/AlImmutableEnrollmentRegisterDeviceRequest;", "Lcom/allegion/accesshub/models/RegisterDeviceMAHResponse;", "registerDeviceActionFactory", "<init>", "(Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlPullAccessPayloadsCompositeAction implements IAlActionSingleExecution<AlPullPayloadsRequest, AlPullPayloadsResponse> {
    private final Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> createAccountActionFactory;
    private final Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> payloadsPullActionFactory;
    private final Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> registerDeviceActionFactory;

    public AlPullAccessPayloadsCompositeAction(@NotNull Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> registerDeviceActionFactory, @NotNull Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> createAccountActionFactory, @NotNull Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> payloadsPullActionFactory) {
        Intrinsics.checkParameterIsNotNull(registerDeviceActionFactory, "registerDeviceActionFactory");
        Intrinsics.checkParameterIsNotNull(createAccountActionFactory, "createAccountActionFactory");
        Intrinsics.checkParameterIsNotNull(payloadsPullActionFactory, "payloadsPullActionFactory");
        this.registerDeviceActionFactory = registerDeviceActionFactory;
        this.createAccountActionFactory = createAccountActionFactory;
        this.payloadsPullActionFactory = payloadsPullActionFactory;
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    @NotNull
    public Single<AlPullPayloadsResponse> run(@NotNull final AlPullPayloadsRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Single<AlPullPayloadsResponse> singleFlatMap = Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlPullAccessPayloadsCompositeAction.run.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest = new AlImmutableEnrollmentRegisterDeviceRequest(false, true);
                return ((IAlActionSingleExecution) AlPullAccessPayloadsCompositeAction.this.registerDeviceActionFactory.create(alImmutableEnrollmentRegisterDeviceRequest)).run((IAlActionSingleExecution) alImmutableEnrollmentRegisterDeviceRequest);
            }
        }).flatMap(new Function<T, SingleSource<? extends R>>() { // from class: com.allegion.accesssdk.actions.AlPullAccessPayloadsCompositeAction.run.2
            @Override // io.reactivex.functions.Function
            public Object apply(Object obj) {
                final RegisterDeviceMAHResponse registerDeviceResponse = (RegisterDeviceMAHResponse) obj;
                Intrinsics.checkParameterIsNotNull(registerDeviceResponse, "registerDeviceResponse");
                AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest = new AlImmutableEnrollmentCreateAccountRequest(registerDeviceResponse.getId(), false, true);
                AlSdkConfiguration.updateConfig(new AlSdkConfiguration.UpdateWorkingConfig() { // from class: com.allegion.accesssdk.actions.AlPullAccessPayloadsCompositeAction.run.2.1
                    @Override // com.allegion.accesssdk.actions.AlSdkConfiguration.UpdateWorkingConfig
                    public final void update(@NotNull AlMutableSdkConfiguration workingConfig) {
                        Intrinsics.checkParameterIsNotNull(workingConfig, "workingConfig");
                        workingConfig.setDeviceId(registerDeviceResponse.getId());
                    }
                });
                return ((IAlActionSingleExecution) AlPullAccessPayloadsCompositeAction.this.createAccountActionFactory.create(alImmutableEnrollmentCreateAccountRequest)).run((IAlActionSingleExecution) alImmutableEnrollmentCreateAccountRequest);
            }
        }).flatMap(new Function<T, SingleSource<? extends R>>() { // from class: com.allegion.accesssdk.actions.AlPullAccessPayloadsCompositeAction.run.3
            @Override // io.reactivex.functions.Function
            public Object apply(Object obj) {
                CreateAccountMAHResponse createAccountMahResponse = (CreateAccountMAHResponse) obj;
                Intrinsics.checkParameterIsNotNull(createAccountMahResponse, "createAccountMahResponse");
                AlImmutablePayloadsPullRequest alImmutablePayloadsPullRequest = new AlImmutablePayloadsPullRequest(request, AlSdkConfiguration.getConfig().getDeviceId(), createAccountMahResponse.getId());
                return ((IAlActionSingleExecution) AlPullAccessPayloadsCompositeAction.this.payloadsPullActionFactory.create(alImmutablePayloadsPullRequest)).run((IAlActionSingleExecution) alImmutablePayloadsPullRequest);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(singleFlatMap, "Single.defer {\n         …adsPullRequest)\n        }");
        return singleFlatMap;
    }
}
