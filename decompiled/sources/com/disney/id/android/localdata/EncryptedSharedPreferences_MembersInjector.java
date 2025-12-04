package com.disney.id.android.localdata;

import com.disney.id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EncryptedSharedPreferences_MembersInjector implements MembersInjector<EncryptedSharedPreferences> {
    private final Provider loggerProvider;

    public EncryptedSharedPreferences_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<EncryptedSharedPreferences> create(Provider<Logger> provider) {
        return new EncryptedSharedPreferences_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(EncryptedSharedPreferences encryptedSharedPreferences) {
        injectLogger(encryptedSharedPreferences, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.localdata.EncryptedSharedPreferences.logger")
    public static void injectLogger(EncryptedSharedPreferences encryptedSharedPreferences, Logger logger) {
        encryptedSharedPreferences.logger = logger;
    }
}
