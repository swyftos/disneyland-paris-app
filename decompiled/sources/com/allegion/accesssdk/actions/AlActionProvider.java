package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.actions.factories.interfaces.Factory;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsResponse;

/* loaded from: classes2.dex */
class AlActionProvider {
    private AuthenticationActionFactory authenticationActionFactory;
    private EnrollmentActionFactory enrollmentActionFactory;
    private EnrollmentConnectedAccountActionFactory enrollmentConnectedAccountActionFactory;
    private EnrollmentCreateAccountActionFactory enrollmentCreateAccountActionFactory;
    private EnrollmentRegisterDeviceActionFactory enrollmentRegisterDeviceActionFactory;
    private PayloadsPullActionFactory payloadsPullActionFactory;
    private RightsPullActionFactory rightsPullActionFactory;

    interface AuthenticationActionFactory extends Factory<AlImmutableAuthenticationRequest, IAlActionSingleExecution<AlImmutableAuthenticationRequest, AlAuthenticationResponse>> {
    }

    interface EnrollmentActionFactory extends Factory<AlImmutableEnrollmentRequest, IAlActionSingleExecution<AlImmutableEnrollmentRequest, AlEnrollDeviceResponse>> {
    }

    interface EnrollmentConnectedAccountActionFactory extends Factory<AlImmutableEnrollmentConnectedAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse>> {
    }

    interface RightsPullActionFactory extends Factory<AlImmutableRightsPullRequest, IAlActionSingleExecution<AlImmutableRightsPullRequest, AlPullRightsResponse>> {
    }

    AlActionProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getAuthenticationActionFactory$0(AuthenticationActionFactory authenticationActionFactory, AlImmutableAuthenticationRequest alImmutableAuthenticationRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(new AlAnalyticsDecorator(authenticationActionFactory.create(alImmutableAuthenticationRequest))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getEnrollmentActionFactory$4(EnrollmentActionFactory enrollmentActionFactory, AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(new AlAnalyticsDecorator(enrollmentActionFactory.create(alImmutableEnrollmentRequest))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getEnrollmentConnectedAccountActionFactory$3(EnrollmentConnectedAccountActionFactory enrollmentConnectedAccountActionFactory, AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(enrollmentConnectedAccountActionFactory.create(alImmutableEnrollmentConnectedAccountRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getEnrollmentCreateAccountActionFactory$2(EnrollmentCreateAccountActionFactory enrollmentCreateAccountActionFactory, AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(enrollmentCreateAccountActionFactory.create(alImmutableEnrollmentCreateAccountRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getEnrollmentRegisterDeviceActionFactory$1(EnrollmentRegisterDeviceActionFactory enrollmentRegisterDeviceActionFactory, AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(enrollmentRegisterDeviceActionFactory.create(alImmutableEnrollmentRegisterDeviceRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getPayloadsPullActionFactory$6(PayloadsPullActionFactory payloadsPullActionFactory, AlImmutablePayloadsPullRequest alImmutablePayloadsPullRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(new AlAnalyticsDecorator(payloadsPullActionFactory.create(alImmutablePayloadsPullRequest))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$getRightsPullActionFactory$5(RightsPullActionFactory rightsPullActionFactory, AlImmutableRightsPullRequest alImmutableRightsPullRequest) throws AlException {
        return new AlCacheMemoryDecorator(new AlCacheStorageDecorator(new AlAnalyticsDecorator(rightsPullActionFactory.create(alImmutableRightsPullRequest))));
    }

    AuthenticationActionFactory getAuthenticationActionFactory() {
        return getAuthenticationActionFactory(this.authenticationActionFactory);
    }

    EnrollmentActionFactory getEnrollmentActionFactory() {
        return getEnrollmentActionFactory(this.enrollmentActionFactory);
    }

    EnrollmentConnectedAccountActionFactory getEnrollmentConnectedAccountActionFactory() {
        return getEnrollmentConnectedAccountActionFactory(this.enrollmentConnectedAccountActionFactory);
    }

    Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> getEnrollmentCreateAccountActionFactory() {
        return getEnrollmentCreateAccountActionFactory(this.enrollmentCreateAccountActionFactory);
    }

    Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> getEnrollmentRegisterDeviceActionFactory() {
        return getEnrollmentRegisterDeviceActionFactory(this.enrollmentRegisterDeviceActionFactory);
    }

    Factory<AlImmutablePayloadsPullRequest, IAlActionSingleExecution<AlImmutablePayloadsPullRequest, AlPullPayloadsResponse>> getPayloadsPullActionFactory(final PayloadsPullActionFactory payloadsPullActionFactory) {
        return new Factory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda1
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final Object create(Object obj) {
                return AlActionProvider.lambda$getPayloadsPullActionFactory$6(payloadsPullActionFactory, (AlImmutablePayloadsPullRequest) obj);
            }
        };
    }

    Factory<AlPullPayloadsRequest, AlPullAccessPayloadsCompositeAction> getPullPayloadsCompositeActionFactory() {
        return new AlPullPayloadsCompositeActionFactory(getEnrollmentRegisterDeviceActionFactory(this.enrollmentRegisterDeviceActionFactory), getEnrollmentCreateAccountActionFactory(this.enrollmentCreateAccountActionFactory), getPayloadsPullActionFactory(this.payloadsPullActionFactory));
    }

    RightsPullActionFactory getRightsPullActionFactory() {
        return getRightsPullActionFactory(this.rightsPullActionFactory);
    }

    void setAuthenticationActionFactory(AuthenticationActionFactory authenticationActionFactory) {
        this.authenticationActionFactory = authenticationActionFactory;
    }

    void setEnrollmentActionFactory(EnrollmentActionFactory enrollmentActionFactory) {
        this.enrollmentActionFactory = enrollmentActionFactory;
    }

    void setEnrollmentConnectedAccountActionFactory(EnrollmentConnectedAccountActionFactory enrollmentConnectedAccountActionFactory) {
        this.enrollmentConnectedAccountActionFactory = enrollmentConnectedAccountActionFactory;
    }

    void setEnrollmentCreateAccountActionFactory(EnrollmentCreateAccountActionFactory enrollmentCreateAccountActionFactory) {
        this.enrollmentCreateAccountActionFactory = enrollmentCreateAccountActionFactory;
    }

    void setEnrollmentRegisterDeviceActionFactory(EnrollmentRegisterDeviceActionFactory enrollmentRegisterDeviceActionFactory) {
        this.enrollmentRegisterDeviceActionFactory = enrollmentRegisterDeviceActionFactory;
    }

    void setPayloadsPullActionFactory(PayloadsPullActionFactory payloadsPullActionFactory) {
        this.payloadsPullActionFactory = payloadsPullActionFactory;
    }

    void setRightsPullActionFactory(RightsPullActionFactory rightsPullActionFactory) {
        this.rightsPullActionFactory = rightsPullActionFactory;
    }

    AuthenticationActionFactory getAuthenticationActionFactory(final AuthenticationActionFactory authenticationActionFactory) {
        return new AuthenticationActionFactory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda3
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableAuthenticationRequest, AlAuthenticationResponse> create(AlImmutableAuthenticationRequest alImmutableAuthenticationRequest) {
                return AlActionProvider.lambda$getAuthenticationActionFactory$0(authenticationActionFactory, alImmutableAuthenticationRequest);
            }
        };
    }

    EnrollmentActionFactory getEnrollmentActionFactory(final EnrollmentActionFactory enrollmentActionFactory) {
        return new EnrollmentActionFactory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda4
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableEnrollmentRequest, AlEnrollDeviceResponse> create(AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) {
                return AlActionProvider.lambda$getEnrollmentActionFactory$4(enrollmentActionFactory, alImmutableEnrollmentRequest);
            }
        };
    }

    EnrollmentConnectedAccountActionFactory getEnrollmentConnectedAccountActionFactory(final EnrollmentConnectedAccountActionFactory enrollmentConnectedAccountActionFactory) {
        return new EnrollmentConnectedAccountActionFactory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda2
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse> create(AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest) {
                return AlActionProvider.lambda$getEnrollmentConnectedAccountActionFactory$3(enrollmentConnectedAccountActionFactory, alImmutableEnrollmentConnectedAccountRequest);
            }
        };
    }

    Factory<AlImmutableEnrollmentCreateAccountRequest, IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>> getEnrollmentCreateAccountActionFactory(final EnrollmentCreateAccountActionFactory enrollmentCreateAccountActionFactory) {
        return new Factory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda6
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final Object create(Object obj) {
                return AlActionProvider.lambda$getEnrollmentCreateAccountActionFactory$2(enrollmentCreateAccountActionFactory, (AlImmutableEnrollmentCreateAccountRequest) obj);
            }
        };
    }

    Factory<AlImmutableEnrollmentRegisterDeviceRequest, IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>> getEnrollmentRegisterDeviceActionFactory(final EnrollmentRegisterDeviceActionFactory enrollmentRegisterDeviceActionFactory) {
        return new Factory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda0
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final Object create(Object obj) {
                return AlActionProvider.lambda$getEnrollmentRegisterDeviceActionFactory$1(enrollmentRegisterDeviceActionFactory, (AlImmutableEnrollmentRegisterDeviceRequest) obj);
            }
        };
    }

    RightsPullActionFactory getRightsPullActionFactory(final RightsPullActionFactory rightsPullActionFactory) {
        return new RightsPullActionFactory() { // from class: com.allegion.accesssdk.actions.AlActionProvider$$ExternalSyntheticLambda5
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableRightsPullRequest, AlPullRightsResponse> create(AlImmutableRightsPullRequest alImmutableRightsPullRequest) {
                return AlActionProvider.lambda$getRightsPullActionFactory$5(rightsPullActionFactory, alImmutableRightsPullRequest);
            }
        };
    }
}
