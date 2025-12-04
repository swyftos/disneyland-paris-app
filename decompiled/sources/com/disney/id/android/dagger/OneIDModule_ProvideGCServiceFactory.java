package com.disney.id.android.dagger;

import com.disney.id.android.ConfigHandler;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.GCService;
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
public final class OneIDModule_ProvideGCServiceFactory implements Factory<GCService> {
    private final Provider baseUrlProvider;
    private final Provider configHandlerProvider;
    private final Provider loggerProvider;
    private final OneIDModule module;
    private final Provider okHttpClientProvider;

    public OneIDModule_ProvideGCServiceFactory(OneIDModule oneIDModule, Provider<OkHttpClient> provider, Provider<ConfigHandler> provider2, Provider<String> provider3, Provider<Logger> provider4) {
        this.module = oneIDModule;
        this.okHttpClientProvider = provider;
        this.configHandlerProvider = provider2;
        this.baseUrlProvider = provider3;
        this.loggerProvider = provider4;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public GCService get2() {
        return provideGCService(this.module, (OkHttpClient) this.okHttpClientProvider.get2(), (ConfigHandler) this.configHandlerProvider.get2(), (String) this.baseUrlProvider.get2(), (Logger) this.loggerProvider.get2());
    }

    public static OneIDModule_ProvideGCServiceFactory create(OneIDModule oneIDModule, Provider<OkHttpClient> provider, Provider<ConfigHandler> provider2, Provider<String> provider3, Provider<Logger> provider4) {
        return new OneIDModule_ProvideGCServiceFactory(oneIDModule, provider, provider2, provider3, provider4);
    }

    public static GCService provideGCService(OneIDModule oneIDModule, OkHttpClient okHttpClient, ConfigHandler configHandler, String str, Logger logger) {
        return (GCService) Preconditions.checkNotNullFromProvides(oneIDModule.provideGCService(okHttpClient, configHandler, str, logger));
    }
}
