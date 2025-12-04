package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import io.reactivex.Single;
import java.util.UUID;

/* loaded from: classes2.dex */
interface IAlEnrollmentProvidable {
    Single<CreateConnectedAccountMAHResponse> connectedAccount(UUID uuid, AlImmutableEnrollmentRequest alImmutableEnrollmentRequest);

    Single<CreateAccountMAHResponse> createAccount(AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest);

    Single<RegisterDeviceMAHResponse> registerDevice(AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest);
}
