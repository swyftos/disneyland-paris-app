package com.disney.id.android.dagger;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideContextFactory implements Factory<Context> {
    private final OneIDModule module;

    public OneIDModule_ProvideContextFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public Context get2() {
        return provideContext(this.module);
    }

    public static OneIDModule_ProvideContextFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideContextFactory(oneIDModule);
    }

    public static Context provideContext(OneIDModule oneIDModule) {
        return (Context) Preconditions.checkNotNullFromProvides(oneIDModule.provideContext());
    }
}
