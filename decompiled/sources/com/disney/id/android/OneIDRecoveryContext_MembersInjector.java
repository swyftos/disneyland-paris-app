package com.disney.id.android;

import com.disney.id.android.localdata.LocalStorage;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDRecoveryContext_MembersInjector implements MembersInjector<OneIDRecoveryContext> {
    private final Provider storageProvider;

    public OneIDRecoveryContext_MembersInjector(Provider<LocalStorage> provider) {
        this.storageProvider = provider;
    }

    public static MembersInjector<OneIDRecoveryContext> create(Provider<LocalStorage> provider) {
        return new OneIDRecoveryContext_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(OneIDRecoveryContext oneIDRecoveryContext) {
        injectStorage(oneIDRecoveryContext, (LocalStorage) this.storageProvider.get2());
    }

    @InjectedFieldSignature("com.disney.id.android.OneIDRecoveryContext.storage")
    public static void injectStorage(OneIDRecoveryContext oneIDRecoveryContext, LocalStorage localStorage) {
        oneIDRecoveryContext.storage = localStorage;
    }
}
