package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlAuthenticationResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/allegion/accesssdk/actions/IAlAuthenticationService;", "", "Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;", "request", "Lio/reactivex/Single;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "validateSecret", "(Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;)Lio/reactivex/Single;", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlAuthenticationService {
    @NotNull
    Single<AlAuthenticationResponse> validateSecret(@NotNull AlImmutableAuthenticationRequest request);
}
