package com.disney.p026id.android.dagger;

import com.disney.p026id.android.ConfigHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideConfigHandlerFactory implements Factory<ConfigHandler> {
    private final OneIDModule module;

    public OneIDModule_ProvideConfigHandlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ConfigHandler get2() {
        return provideConfigHandler(this.module);
    }

    public static OneIDModule_ProvideConfigHandlerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideConfigHandlerFactory(oneIDModule);
    }

    public static ConfigHandler provideConfigHandler(OneIDModule oneIDModule) {
        return (ConfigHandler) Preconditions.checkNotNullFromProvides(oneIDModule.provideConfigHandler());
    }
}
