package com.disney.p026id.android.dagger;

import com.disney.p026id.android.logging.Logger;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideLoggerFactory implements Factory<Logger> {
    private final OneIDModule module;

    public OneIDModule_ProvideLoggerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Logger get2() {
        return provideLogger(this.module);
    }

    public static OneIDModule_ProvideLoggerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideLoggerFactory(oneIDModule);
    }

    public static Logger provideLogger(OneIDModule oneIDModule) {
        return (Logger) Preconditions.checkNotNullFromProvides(oneIDModule.provideLogger());
    }
}
