package com.disney.id.android.dagger;

import com.disney.id.android.services.BundlerService;
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
public final class OneIDModule_ProvideBundlerServiceFactory implements Factory<BundlerService> {
    private final OneIDModule module;
    private final Provider okHttpClientProvider;

    public OneIDModule_ProvideBundlerServiceFactory(OneIDModule oneIDModule, Provider<OkHttpClient> provider) {
        this.module = oneIDModule;
        this.okHttpClientProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public BundlerService get2() {
        return provideBundlerService(this.module, (OkHttpClient) this.okHttpClientProvider.get2());
    }

    public static OneIDModule_ProvideBundlerServiceFactory create(OneIDModule oneIDModule, Provider<OkHttpClient> provider) {
        return new OneIDModule_ProvideBundlerServiceFactory(oneIDModule, provider);
    }

    public static BundlerService provideBundlerService(OneIDModule oneIDModule, OkHttpClient okHttpClient) {
        return (BundlerService) Preconditions.checkNotNullFromProvides(oneIDModule.provideBundlerService(okHttpClient));
    }
}
