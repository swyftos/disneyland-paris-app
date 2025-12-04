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
public final class OptionalConfigs_MembersInjector implements MembersInjector<OptionalConfigs> {
    private final Provider loggerProvider;

    public OptionalConfigs_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<OptionalConfigs> create(Provider<Logger> provider) {
        return new OptionalConfigs_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OptionalConfigs optionalConfigs) {
        injectLogger(optionalConfigs, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OptionalConfigs.logger")
    public static void injectLogger(OptionalConfigs optionalConfigs, Logger logger) {
        optionalConfigs.logger = logger;
    }
}
