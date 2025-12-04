package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlAuthenticationResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/allegion/accesssdk/actions/AlAuthenticationAction;", "Lcom/allegion/accesssdk/actions/IAlActionSingleExecution;", "Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "request", "Lio/reactivex/Single;", "run", "(Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesssdk/actions/AlAuthenticationService;", "authenticationService", "Lcom/allegion/accesssdk/actions/AlAuthenticationService;", "<init>", "(Lcom/allegion/accesssdk/actions/AlAuthenticationService;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlAuthenticationAction implements IAlActionSingleExecution<AlImmutableAuthenticationRequest, AlAuthenticationResponse> {

    @NotNull
    public static final String URI_AUTHENTICATE = "enroll.authenticate";
    private final AlAuthenticationService authenticationService;

    public AlAuthenticationAction(@NotNull AlAuthenticationService authenticationService) {
        Intrinsics.checkParameterIsNotNull(authenticationService, "authenticationService");
        this.authenticationService = authenticationService;
    }

    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    @NotNull
    public Single<AlAuthenticationResponse> run(@NotNull AlImmutableAuthenticationRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        return this.authenticationService.validateSecret(request);
    }
}
