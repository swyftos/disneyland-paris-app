package com.allegion.accesssdk.actions;

import android.app.Application;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesssdk.actions.AlActionProvider;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.allegion.accesssdk.models.AlConfig;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class AlSdkConfiguration {
    private static AlSdkConfiguration instance;
    private static ReentrantLock lock = new ReentrantLock();
    private final AlActionProvider actionProvider;
    private final AlMutableSdkConfiguration config;
    private final AlServiceProvider serviceProvider;

    @FunctionalInterface
    interface UpdateWorkingConfig {
        void update(AlMutableSdkConfiguration alMutableSdkConfiguration);
    }

    AlSdkConfiguration(AlMutableSdkConfiguration alMutableSdkConfiguration, AlServiceProvider alServiceProvider, AlActionProvider alActionProvider) {
        this.config = alMutableSdkConfiguration;
        this.serviceProvider = alServiceProvider;
        this.actionProvider = alActionProvider;
        registerActionFactories(alActionProvider);
    }

    static AlActionProvider getActionProvider() {
        return getInstance().actionProvider;
    }

    static IAlSdkConfiguration getConfig() {
        lock.lock();
        try {
            return getInstance().config.build();
        } finally {
            lock.unlock();
        }
    }

    private static AlSdkConfiguration getInstance() {
        if (instance == null) {
            instance = new AlSdkConfiguration(new AlMutableSdkConfiguration(), new AlServiceProvider(), new AlActionProvider());
        }
        return instance;
    }

    static AlServiceProvider getServiceProvider() {
        return getInstance().serviceProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$registerActionFactories$0(AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest) throws AlException {
        return new AlEnrollmentConnectedAccountAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$registerActionFactories$1(AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) throws AlException {
        return new AlEnrollmentAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlActionSingleExecution lambda$registerActionFactories$2(AlImmutableRightsPullRequest alImmutableRightsPullRequest) throws AlException {
        return new AlRightsPullAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IAlActionSingleExecution lambda$registerActionFactories$3(AlImmutableAuthenticationRequest alImmutableAuthenticationRequest) throws AlException {
        return new AlAuthenticationAction((AlAuthenticationService) getInstance().serviceProvider.locateService(IAlAuthenticationService.class));
    }

    static void registerActionFactories(AlActionProvider alActionProvider) {
        alActionProvider.setEnrollmentRegisterDeviceActionFactory(new EnrollmentRegisterDeviceActionFactory());
        alActionProvider.setEnrollmentCreateAccountActionFactory(new EnrollmentCreateAccountActionFactory());
        alActionProvider.setEnrollmentConnectedAccountActionFactory(new AlActionProvider.EnrollmentConnectedAccountActionFactory() { // from class: com.allegion.accesssdk.actions.AlSdkConfiguration$$ExternalSyntheticLambda0
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableEnrollmentConnectedAccountRequest, CreateConnectedAccountMAHResponse> create(AlImmutableEnrollmentConnectedAccountRequest alImmutableEnrollmentConnectedAccountRequest) {
                return AlSdkConfiguration.lambda$registerActionFactories$0(alImmutableEnrollmentConnectedAccountRequest);
            }
        });
        alActionProvider.setEnrollmentActionFactory(new AlActionProvider.EnrollmentActionFactory() { // from class: com.allegion.accesssdk.actions.AlSdkConfiguration$$ExternalSyntheticLambda1
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableEnrollmentRequest, AlEnrollDeviceResponse> create(AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) {
                return AlSdkConfiguration.lambda$registerActionFactories$1(alImmutableEnrollmentRequest);
            }
        });
        alActionProvider.setRightsPullActionFactory(new AlActionProvider.RightsPullActionFactory() { // from class: com.allegion.accesssdk.actions.AlSdkConfiguration$$ExternalSyntheticLambda2
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableRightsPullRequest, AlPullRightsResponse> create(AlImmutableRightsPullRequest alImmutableRightsPullRequest) {
                return AlSdkConfiguration.lambda$registerActionFactories$2(alImmutableRightsPullRequest);
            }
        });
        alActionProvider.setPayloadsPullActionFactory(new PayloadsPullActionFactory());
        alActionProvider.setAuthenticationActionFactory(new AlActionProvider.AuthenticationActionFactory() { // from class: com.allegion.accesssdk.actions.AlSdkConfiguration$$ExternalSyntheticLambda3
            @Override // com.allegion.accesssdk.actions.factories.interfaces.Factory
            public final IAlActionSingleExecution<AlImmutableAuthenticationRequest, AlAuthenticationResponse> create(AlImmutableAuthenticationRequest alImmutableAuthenticationRequest) {
                return AlSdkConfiguration.lambda$registerActionFactories$3(alImmutableAuthenticationRequest);
            }
        });
    }

    public static void setConfig(AlConfig alConfig) {
        AlConfig alConfig2 = (AlConfig) AlObjects.requireNonNull(alConfig, "Config must not be null", AlErrorCode.SDK_CONFIG_INVALID_CONFIG);
        final AlImmutableConfig alImmutableConfig = alConfig2.getPinSet() == null ? new AlImmutableConfig(alConfig2.getSubscriptionKey(), alConfig2.getApplication(), new HashMap()) : new AlImmutableConfig(alConfig2.getSubscriptionKey(), alConfig2.getApplication(), alConfig2.getPinSet());
        updateConfig(new UpdateWorkingConfig() { // from class: com.allegion.accesssdk.actions.AlSdkConfiguration$$ExternalSyntheticLambda4
            @Override // com.allegion.accesssdk.actions.AlSdkConfiguration.UpdateWorkingConfig
            public final void update(AlMutableSdkConfiguration alMutableSdkConfiguration) {
                alMutableSdkConfiguration.setUserConfig(alImmutableConfig);
            }
        });
    }

    static void updateConfig(UpdateWorkingConfig updateWorkingConfig) {
        lock.lock();
        try {
            updateWorkingConfig.update(getInstance().config);
            if (!getInstance().serviceProvider.containsService(IAlAnalyticsService.class)) {
                Application application = (Application) AlObjects.requireNonNull(getInstance().config.getUserConfig().getApplication(), "Application must not be null", AlErrorCode.SDK_CONFIG_INVALID_APPLICATION);
                if (application != null) {
                    getInstance().serviceProvider.registerService(new AlAnalyticsService(application), IAlAnalyticsService.class);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
