package com.disney.p026id.android.dagger;

import com.disney.p026id.android.ConfigHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class OneIDModule_ProvideGCURLFactory implements Factory<String> {
    private final Provider configHandlerProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideGCURLFactory(OneIDModule oneIDModule, Provider<ConfigHandler> provider) {
        this.module = oneIDModule;
        this.configHandlerProvider = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public String get2() {
        return provideGCURL(this.module, (ConfigHandler) this.configHandlerProvider.get2());
    }

    public static OneIDModule_ProvideGCURLFactory create(OneIDModule oneIDModule, Provider<ConfigHandler> provider) {
        return new OneIDModule_ProvideGCURLFactory(oneIDModule, provider);
    }

    public static String provideGCURL(OneIDModule oneIDModule, ConfigHandler configHandler) {
        return (String) Preconditions.checkNotNullFromProvides(oneIDModule.provideGCURL(configHandler));
    }
}
