package com.disney.id.android;

import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PasswordScore_MembersInjector implements MembersInjector<PasswordScore> {
    private final Provider loggerProvider;

    public PasswordScore_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<PasswordScore> create(Provider<Logger> provider) {
        return new PasswordScore_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PasswordScore passwordScore) {
        injectLogger(passwordScore, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.PasswordScore.logger")
    public static void injectLogger(PasswordScore passwordScore, Logger logger) {
        passwordScore.logger = logger;
    }
}
