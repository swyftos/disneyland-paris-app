package com.disney.id.android;

import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OptionalConfigs_OptionalConfigsBuilder_MembersInjector implements MembersInjector<OptionalConfigs.OptionalConfigsBuilder> {
    private final Provider loggerProvider;

    public OptionalConfigs_OptionalConfigsBuilder_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<OptionalConfigs.OptionalConfigsBuilder> create(Provider<Logger> provider) {
        return new OptionalConfigs_OptionalConfigsBuilder_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OptionalConfigs.OptionalConfigsBuilder optionalConfigsBuilder) {
        injectLogger(optionalConfigsBuilder, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OptionalConfigs.OptionalConfigsBuilder.logger")
    public static void injectLogger(OptionalConfigs.OptionalConfigsBuilder optionalConfigsBuilder, Logger logger) {
        optionalConfigsBuilder.logger = logger;
    }
}
