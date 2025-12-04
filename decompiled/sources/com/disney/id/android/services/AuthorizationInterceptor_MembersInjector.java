package com.disney.id.android.services;

import com.disney.id.android.GuestHandler;
import com.disney.id.android.RecoveryContext;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorizationInterceptor_MembersInjector implements MembersInjector<AuthorizationInterceptor> {
    private final Provider guestHandlerProvider;
    private final Provider loggerProvider;
    private final Provider recoveryContextProvider;

    public AuthorizationInterceptor_MembersInjector(Provider<Logger> provider, Provider<GuestHandler> provider2, Provider<RecoveryContext> provider3) {
        this.loggerProvider = provider;
        this.guestHandlerProvider = provider2;
        this.recoveryContextProvider = provider3;
    }

    public static MembersInjector<AuthorizationInterceptor> create(Provider<Logger> provider, Provider<GuestHandler> provider2, Provider<RecoveryContext> provider3) {
        return new AuthorizationInterceptor_MembersInjector(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AuthorizationInterceptor authorizationInterceptor) {
        injectLogger(authorizationInterceptor, (Logger) this.loggerProvider.get2());
        injectGuestHandler(authorizationInterceptor, (GuestHandler) this.guestHandlerProvider.get2());
        injectRecoveryContext(authorizationInterceptor, (RecoveryContext) this.recoveryContextProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.services.AuthorizationInterceptor.logger")
    public static void injectLogger(AuthorizationInterceptor authorizationInterceptor, Logger logger) {
        authorizationInterceptor.logger = logger;
    }

    @InjectedFieldSignature("com.disney.id.android.services.AuthorizationInterceptor.guestHandler")
    public static void injectGuestHandler(AuthorizationInterceptor authorizationInterceptor, GuestHandler guestHandler) {
        authorizationInterceptor.guestHandler = guestHandler;
    }

    @InjectedFieldSignature("com.disney.id.android.services.AuthorizationInterceptor.recoveryContext")
    public static void injectRecoveryContext(AuthorizationInterceptor authorizationInterceptor, RecoveryContext recoveryContext) {
        authorizationInterceptor.recoveryContext = recoveryContext;
    }
}
