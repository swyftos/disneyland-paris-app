package com.disney.p026id.android.dagger;

import android.content.Context;
import com.disney.p026id.android.localdata.ExposedStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class OneIDModule_ProvideBundlerOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider appContextProvider;
    private final Provider exposedStorageProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideBundlerOkHttpClientFactory(OneIDModule oneIDModule, Provider<Context> provider, Provider<ExposedStorage> provider2) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
        this.exposedStorageProvider = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public OkHttpClient get2() {
        return provideBundlerOkHttpClient(this.module, (Context) this.appContextProvider.get2(), (ExposedStorage) this.exposedStorageProvider.get2());
    }

    public static OneIDModule_ProvideBundlerOkHttpClientFactory create(OneIDModule oneIDModule, Provider<Context> provider, Provider<ExposedStorage> provider2) {
        return new OneIDModule_ProvideBundlerOkHttpClientFactory(oneIDModule, provider, provider2);
    }

    public static OkHttpClient provideBundlerOkHttpClient(OneIDModule oneIDModule, Context context, ExposedStorage exposedStorage) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(oneIDModule.provideBundlerOkHttpClient(context, exposedStorage));
    }
}
