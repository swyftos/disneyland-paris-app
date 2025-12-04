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
public final class Config_MembersInjector implements MembersInjector<Config> {
    private final Provider loggerProvider;

    public Config_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<Config> create(Provider<Logger> provider) {
        return new Config_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(Config config) {
        injectLogger(config, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.Config.logger")
    public static void injectLogger(Config config, Logger logger) {
        config.logger = logger;
    }
}
