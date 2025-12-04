package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.localdata.LocalStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideLocalStorageFactory implements Factory<LocalStorage> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideLocalStorageFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public LocalStorage get2() {
        return provideLocalStorage(this.module, (Context) this.appContextProvider.get2());
    }

    public static OneIDModule_ProvideLocalStorageFactory create(OneIDModule oneIDModule, Provider<Context> provider) {
        return new OneIDModule_ProvideLocalStorageFactory(oneIDModule, provider);
    }

    public static LocalStorage provideLocalStorage(OneIDModule oneIDModule, Context context) {
        return (LocalStorage) Preconditions.checkNotNullFromProvides(oneIDModule.provideLocalStorage(context));
    }
}
