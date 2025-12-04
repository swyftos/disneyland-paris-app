package com.disney.id.android.lightbox;

import com.disney.id.android.BiometricSupport;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LightboxConfig_MembersInjector implements MembersInjector<LightboxConfig> {
    private final Provider biometricSupportProvider;
    private final Provider guestHandlerProvider;
    private final Provider loggerProvider;
    private final Provider oneIdStorageProvider;

    public LightboxConfig_MembersInjector(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<GuestHandler> provider3, Provider<BiometricSupport> provider4) {
        this.oneIdStorageProvider = provider;
        this.loggerProvider = provider2;
        this.guestHandlerProvider = provider3;
        this.biometricSupportProvider = provider4;
    }

    public static MembersInjector<LightboxConfig> create(Provider<ExposedStorage> provider, Provider<Logger> provider2, Provider<GuestHandler> provider3, Provider<BiometricSupport> provider4) {
        return new LightboxConfig_MembersInjector(provider, provider2, provider3, provider4);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LightboxConfig lightboxConfig) {
        injectOneIdStorage(lightboxConfig, (ExposedStorage) this.oneIdStorageProvider.get2());
        injectLogger(lightboxConfig, (Logger) this.loggerProvider.get2());
        injectGuestHandler(lightboxConfig, (GuestHandler) this.guestHandlerProvider.get2());
        injectBiometricSupport(lightboxConfig, (BiometricSupport) this.biometricSupportProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxConfig.oneIdStorage")
    public static void injectOneIdStorage(LightboxConfig lightboxConfig, ExposedStorage exposedStorage) {
        lightboxConfig.oneIdStorage = exposedStorage;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxConfig.logger")
    public static void injectLogger(LightboxConfig lightboxConfig, Logger logger) {
        lightboxConfig.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxConfig.guestHandler")
    public static void injectGuestHandler(LightboxConfig lightboxConfig, GuestHandler guestHandler) {
        lightboxConfig.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.lightbox.LightboxConfig.biometricSupport")
    public static void injectBiometricSupport(LightboxConfig lightboxConfig, BiometricSupport biometricSupport) {
        lightboxConfig.biometricSupport = biometricSupport;
    }
}
