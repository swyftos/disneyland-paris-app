package com.disney.p026id.android.dagger;

import com.disney.p026id.android.RecoveryContext;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideRecoveryContextFactory implements Factory<RecoveryContext> {
    private final OneIDModule module;

    public OneIDModule_ProvideRecoveryContextFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public RecoveryContext get2() {
        return provideRecoveryContext(this.module);
    }

    public static OneIDModule_ProvideRecoveryContextFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideRecoveryContextFactory(oneIDModule);
    }

    public static RecoveryContext provideRecoveryContext(OneIDModule oneIDModule) {
        return (RecoveryContext) Preconditions.checkNotNullFromProvides(oneIDModule.provideRecoveryContext());
    }
}
