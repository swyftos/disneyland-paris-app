package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.localdata.ExposedStorage;
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
public final class OneIDModule_ProvideOneIDSharedPreferencesFactory implements Factory<ExposedStorage> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideOneIDSharedPreferencesFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public ExposedStorage get2() {
        return provideOneIDSharedPreferences(this.module, (Context) this.appContextProvider.get2());
    }

    public static OneIDModule_ProvideOneIDSharedPreferencesFactory create(OneIDModule oneIDModule, Provider<Context> provider) {
        return new OneIDModule_ProvideOneIDSharedPreferencesFactory(oneIDModule, provider);
    }

    public static ExposedStorage provideOneIDSharedPreferences(OneIDModule oneIDModule, Context context) {
        return (ExposedStorage) Preconditions.checkNotNullFromProvides(oneIDModule.provideOneIDSharedPreferences(context));
    }
}
