package com.disney.id.android.crypto;

import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BasicCrypto_MembersInjector implements MembersInjector<BasicCrypto> {
    private final Provider loggerProvider;

    public BasicCrypto_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<BasicCrypto> create(Provider<Logger> provider) {
        return new BasicCrypto_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BasicCrypto basicCrypto) {
        injectLogger(basicCrypto, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.crypto.BasicCrypto.logger")
    public static void injectLogger(BasicCrypto basicCrypto, Logger logger) {
        basicCrypto.logger = logger;
    }
}
