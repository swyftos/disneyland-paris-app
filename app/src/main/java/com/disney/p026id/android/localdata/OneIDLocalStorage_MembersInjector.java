package com.disney.p026id.android.localdata;

import com.disney.p026id.android.logging.Logger;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes3.dex */
@DaggerGenerated
@QualifierMetadata
public final class OneIDLocalStorage_MembersInjector implements MembersInjector<OneIDLocalStorage> {
    private final Provider loggerProvider;

    public OneIDLocalStorage_MembersInjector(Provider<Logger> provider) {
        this.loggerProvider = provider;
    }

    public static MembersInjector<OneIDLocalStorage> create(Provider<Logger> provider) {
        return new OneIDLocalStorage_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDLocalStorage oneIDLocalStorage) {
        injectLogger(oneIDLocalStorage, (Logger) this.loggerProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.localdata.OneIDLocalStorage.logger")
    public static void injectLogger(OneIDLocalStorage oneIDLocalStorage, Logger logger) {
        oneIDLocalStorage.logger = logger;
    }
}
