package com.disney.id.android.dagger;

import com.disney.id.android.bundler.Bundler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideBundlerFactory implements Factory<Bundler> {
    private final OneIDModule module;

    public OneIDModule_ProvideBundlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
