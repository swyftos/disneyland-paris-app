package com.disney.id.android.dagger;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideGCOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideGCOkHttpClientFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public OkHttpClient get2() {
        return provideGCOkHttpClient(this.module, (Context) this.appContextProvider.get2());
    }

    public static OneIDModule_ProvideGCOkHttpClientFactory create(OneIDModule oneIDModule, Provider<Context> provider) {
        return new OneIDModule_ProvideGCOkHttpClientFactory(oneIDModule, provider);
    }

    public static OkHttpClient provideGCOkHttpClient(OneIDModule oneIDModule, Context context) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(oneIDModule.provideGCOkHttpClient(context));
    }
}
