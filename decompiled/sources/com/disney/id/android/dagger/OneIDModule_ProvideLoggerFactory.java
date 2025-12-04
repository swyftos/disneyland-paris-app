package com.disney.id.android.dagger;

import com.disney.id.android.logging.Logger;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideLoggerFactory implements Factory<Logger> {
    private final OneIDModule module;

    public OneIDModule_ProvideLoggerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
