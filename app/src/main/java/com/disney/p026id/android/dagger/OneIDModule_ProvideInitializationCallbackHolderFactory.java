package com.disney.p026id.android.dagger;

import com.disney.p026id.android.InitializationCallbackHolder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideInitializationCallbackHolderFactory implements Factory<InitializationCallbackHolder> {
    private final OneIDModule module;

    public OneIDModule_ProvideInitializationCallbackHolderFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public InitializationCallbackHolder get2() {
        return provideInitializationCallbackHolder(this.module);
    }

    public static OneIDModule_ProvideInitializationCallbackHolderFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideInitializationCallbackHolderFactory(oneIDModule);
    }

    public static InitializationCallbackHolder provideInitializationCallbackHolder(OneIDModule oneIDModule) {
        return (InitializationCallbackHolder) Preconditions.checkNotNullFromProvides(oneIDModule.provideInitializationCallbackHolder());
    }
}
