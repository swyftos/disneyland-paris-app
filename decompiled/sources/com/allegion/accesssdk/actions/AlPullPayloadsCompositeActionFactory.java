package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.actions.factories.interfaces.Factory;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Bg\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\b0\u0001\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b0\u0001\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\b0\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR.\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR.\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\b0\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/allegion/accesssdk/actions/AlPullPayloadsCompositeActionFactory;", "Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;", "Lcom/allegion/accesssdk/models/AlPullPayloadsRequest;", "Lcom/allegion/accesssdk/actions/AlPullAccessPayloadsCompositeAction;", "request", "create", "(Lcom/allegion/accesssdk/models/AlPullPayloadsRequest;)Lcom/allegion/accesssdk/actions/AlPullAccessPayloadsCompositeAction;", "Lcom/allegion/accesssdk/actions/AlImmutableEnrollmentRegisterDeviceRequest;", "Lcom/allegion/accesssdk/actions/IAlActionSingleExecution;", "Lcom/allegion/accesshub/models/RegisterDeviceMAHResponse;", "enrollmentRegisterDeviceActionFactory", "Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;", "Lcom/allegion/accesssdk/actions/AlImmutableEnrollmentCreateAccountRequest;", "Lcom/allegion/accesshub/models/CreateAccountMAHResponse;", "createAccountActionFactory", "Lcom/allegion/accesssdk/actions/AlImmutablePayloadsPullRequest;", "Lcom/allegion/accesssdk/models/AlPullPayloadsResponse;", "payloadsPullActionFactory", "<init>", "(Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlPullPayloadsCompositeActionFactory implements Factory<AlPullPayloadsRequest, AlPullAccessPayloadsCompositeAction> {
    private final Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> createAccountActionFactory;
    private final Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> enrollmentRegisterDeviceActionFactory;
    private final Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> payloadsPullActionFactory;

    public AlPullPayloadsCompositeActionFactory(@NotNull Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> enrollmentRegisterDeviceActionFactory, @NotNull Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> createAccountActionFactory, @NotNull Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> payloadsPullActionFactory) {
        Intrinsics.checkParameterIsNotNull(enrollmentRegisterDeviceActionFactory, "enrollmentRegisterDeviceActionFactory");
        Intrinsics.checkParameterIsNotNull(createAccountActionFactory, "createAccountActionFactory");
        Intrinsics.checkParameterIsNotNull(payloadsPullActionFactory, "payloadsPullActionFactory");
        this.enrollmentRegisterDeviceActionFactory = enrollmentRegisterDeviceActionFactory;
        this.createAccountActionFactory = createAccountActionFactory;
        this.payloadsPullActionFactory = payloadsPullActionFactory;
    }

    @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
    @NotNull
    public AlPullAccessPayloadsCompositeAction create(@NotNull AlPullPayloadsRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return new AlPullAccessPayloadsCompositeAction(this.enrollmentRegisterDeviceActionFactory, this.createAccountActionFactory, this.payloadsPullActionFactory);
    }
}
