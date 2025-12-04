package com.allegion.accesssdk.actions;

import android.content.Context;
import com.allegion.accesssdk.BuildConfig;
import com.allegion.accesssdk.enums.AlSdkEnvironment;
import com.allegion.accesssdk.exceptions.AlRuntimeException;
import com.allegion.alsecurity.AlKeyManagement;
import com.allegion.alsecurity.AlSecureStorage;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import com.allegion.logging.AlLog;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class AlMutableSdkConfiguration {
    private static final UUID DEFAULT_DEVICE_ID = UUID.fromString("88888888-4444-4444-4444-CCCCCCCCCCCC");
    private UUID deviceId;
    private AlImmutableConfig userConfig;

    @FunctionalInterface
    interface KeyManagementFactory {
        IAlKeyManagement create(Context context, boolean z);
    }

    @FunctionalInterface
    interface SecureStorageFactory {
        IAlSecureStorage create(Context context);
    }

    AlMutableSdkConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlKeyManagement lambda$getKeyManagement$0(Context context, boolean z) {
        try {
            return new AlKeyManagement(context, z);
        } catch (AlSecurityException e) {
            AlLog.e(e);
            throw new AlRuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IAlSecureStorage lambda$getStorage$1(Context context) {
        try {
            return new AlSecureStorage(context);
        } catch (AlSecurityException e) {
            AlLog.e(e);
            throw new AlRuntimeException(e);
        }
    }

    AlImmutableSdkConfiguration build() {
        UUID uuid = this.deviceId;
        if (uuid == null) {
            uuid = DEFAULT_DEVICE_ID;
        }
        return new AlImmutableSdkConfiguration("device", BuildConfig.SESSION_KEY_REFERENCE, BuildConfig.DIVERSIFIED_KEY_REFERENCE, BuildConfig.DIVERSIFIED_KEY_INPUT_REFERENCE, uuid, getKeyManagement(), getStorage(), AlSdkEnvironment.getCurrent(), this.userConfig, (IAlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class));
    }

    @Nonnull
    final KeyManagementFactory getKeyManagement() {
        return new KeyManagementFactory() { // from class: com.allegion.accesssdk.actions.AlMutableSdkConfiguration$$ExternalSyntheticLambda0
            @Override // com.allegion.accesssdk.actions.AlMutableSdkConfiguration.KeyManagementFactory
            public final IAlKeyManagement create(Context context, boolean z) {
                return AlMutableSdkConfiguration.lambda$getKeyManagement$0(context, z);
            }
        };
    }

    @Nonnull
    final SecureStorageFactory getStorage() {
        return new SecureStorageFactory() { // from class: com.allegion.accesssdk.actions.AlMutableSdkConfiguration$$ExternalSyntheticLambda1
            @Override // com.allegion.accesssdk.actions.AlMutableSdkConfiguration.SecureStorageFactory
            public final IAlSecureStorage create(Context context) {
                return AlMutableSdkConfiguration.lambda$getStorage$1(context);
            }
        };
    }

    @Nullable
    final AlImmutableConfig getUserConfig() {
        return this.userConfig;
    }

    AlMutableSdkConfiguration setDeviceId(UUID uuid) {
        this.deviceId = uuid;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlMutableSdkConfiguration setUserConfig(AlImmutableConfig alImmutableConfig) {
        this.userConfig = alImmutableConfig;
        return this;
    }
}
