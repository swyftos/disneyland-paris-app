package com.disney.p026id.android.dagger;

import com.disney.p026id.android.bundler.Bundler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideBundlerFactory implements Factory<Bundler> {
    private final OneIDModule module;

    public OneIDModule_ProvideBundlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Bundler get2() {
        return provideBundler(this.module);
    }

    public static OneIDModule_ProvideBundlerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideBundlerFactory(oneIDModule);
    }

    public static Bundler provideBundler(OneIDModule oneIDModule) {
        return (Bundler) Preconditions.checkNotNullFromProvides(oneIDModule.provideBundler());
    }
}
