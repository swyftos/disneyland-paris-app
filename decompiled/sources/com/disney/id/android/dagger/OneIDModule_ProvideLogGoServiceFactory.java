package com.disney.id.android.dagger;

import com.disney.id.android.services.LogGoService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideLogGoServiceFactory implements Factory<LogGoService> {
    private final Provider httpUrlProvider;
    private final OneIDModule module;
    private final Provider okHttpClientProvider;

    public OneIDModule_ProvideLogGoServiceFactory(OneIDModule oneIDModule, Provider<OkHttpClient> provider, Provider<HttpUrl> provider2) {
        this.module = oneIDModule;
        this.okHttpClientProvider = provider;
        this.httpUrlProvider = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public LogGoService get2() {
        return provideLogGoService(this.module, (OkHttpClient) this.okHttpClientProvider.get2(), (HttpUrl) this.httpUrlProvider.get2());
    }

    public static OneIDModule_ProvideLogGoServiceFactory create(OneIDModule oneIDModule, Provider<OkHttpClient> provider, Provider<HttpUrl> provider2) {
        return new OneIDModule_ProvideLogGoServiceFactory(oneIDModule, provider, provider2);
    }

    public static LogGoService provideLogGoService(OneIDModule oneIDModule, OkHttpClient okHttpClient, HttpUrl httpUrl) {
        return (LogGoService) Preconditions.checkNotNullFromProvides(oneIDModule.provideLogGoService(okHttpClient, httpUrl));
    }
}
