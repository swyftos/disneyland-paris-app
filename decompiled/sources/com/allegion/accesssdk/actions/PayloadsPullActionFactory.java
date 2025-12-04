package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.actions.factories.interfaces.Factory;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/actions/PayloadsPullActionFactory;", "Lcom/allegion/accesssdk/actions/factories/interfaces/Factory;", "Lcom/allegion/accesssdk/actions/AlImmutablePayloadsPullRequest;", "Lcom/allegion/accesssdk/actions/IAlActionSingleExecution;", "Lcom/allegion/accesssdk/models/AlPullPayloadsResponse;", "request", "create", "(Lcom/allegion/accesssdk/actions/AlImmutablePayloadsPullRequest;)Lcom/allegion/accesssdk/actions/IAlActionSingleExecution;", "<init>", "()V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class PayloadsPullActionFactory implements Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> {
    @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
    @NotNull
    public IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse> create(@NotNull AlImmutablePayloadsPullRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return new AlPayloadsPullAction();
    }
}
