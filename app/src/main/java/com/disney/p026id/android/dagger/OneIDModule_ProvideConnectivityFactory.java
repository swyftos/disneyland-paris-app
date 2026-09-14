package com.disney.p026id.android.dagger;

import com.disney.p026id.android.Connectivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideConnectivityFactory implements Factory<Connectivity> {
    private final OneIDModule module;

    public OneIDModule_ProvideConnectivityFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
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
