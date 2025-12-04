package com.disney.id.android.dagger;

import com.disney.id.android.Connectivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideConnectivityFactory implements Factory<Connectivity> {
    private final OneIDModule module;

    public OneIDModule_ProvideConnectivityFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public Connectivity get2() {
        return provideConnectivity(this.module);
    }

    public static OneIDModule_ProvideConnectivityFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideConnectivityFactory(oneIDModule);
    }

    public static Connectivity provideConnectivity(OneIDModule oneIDModule) {
        return (Connectivity) Preconditions.checkNotNullFromProvides(oneIDModule.provideConnectivity());
    }
}
