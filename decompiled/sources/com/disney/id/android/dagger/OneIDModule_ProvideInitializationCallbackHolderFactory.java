package com.disney.id.android.dagger;

import com.disney.id.android.InitializationCallbackHolder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideInitializationCallbackHolderFactory implements Factory<InitializationCallbackHolder> {
    private final OneIDModule module;

    public OneIDModule_ProvideInitializationCallbackHolderFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
