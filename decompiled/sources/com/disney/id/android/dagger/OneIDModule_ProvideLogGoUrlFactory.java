package com.disney.id.android.dagger;

import com.disney.id.android.ConfigHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.HttpUrl;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideLogGoUrlFactory implements Factory<HttpUrl> {
    private final Provider configHandlerProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideLogGoUrlFactory(OneIDModule oneIDModule, Provider<ConfigHandler> provider) {
        this.module = oneIDModule;
        this.configHandlerProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public HttpUrl get2() {
        return provideLogGoUrl(this.module, (ConfigHandler) this.configHandlerProvider.get2());
    }

    public static OneIDModule_ProvideLogGoUrlFactory create(OneIDModule oneIDModule, Provider<ConfigHandler> provider) {
        return new OneIDModule_ProvideLogGoUrlFactory(oneIDModule, provider);
    }

    public static HttpUrl provideLogGoUrl(OneIDModule oneIDModule, ConfigHandler configHandler) {
        return (HttpUrl) Preconditions.checkNotNullFromProvides(oneIDModule.provideLogGoUrl(configHandler));
    }
}
