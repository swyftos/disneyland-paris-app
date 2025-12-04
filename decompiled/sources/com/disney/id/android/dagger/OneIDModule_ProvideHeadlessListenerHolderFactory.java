package com.disney.id.android.dagger;

import com.disney.id.android.HeadlessListenerHolder;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideHeadlessListenerHolderFactory implements Factory<HeadlessListenerHolder> {
    private final OneIDModule module;

    public OneIDModule_ProvideHeadlessListenerHolderFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public HeadlessListenerHolder get2() {
        return provideHeadlessListenerHolder(this.module);
    }

    public static OneIDModule_ProvideHeadlessListenerHolderFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideHeadlessListenerHolderFactory(oneIDModule);
    }

    public static HeadlessListenerHolder provideHeadlessListenerHolder(OneIDModule oneIDModule) {
        return (HeadlessListenerHolder) Preconditions.checkNotNullFromProvides(oneIDModule.provideHeadlessListenerHolder());
    }
}
