package com.disney.p026id.android.dagger;

import com.disney.p026id.android.SCALPBundle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideSCALPBundleFactory implements Factory<SCALPBundle> {
    private final OneIDModule module;

    public OneIDModule_ProvideSCALPBundleFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public SCALPBundle get2() {
        return provideSCALPBundle(this.module);
    }

    public static OneIDModule_ProvideSCALPBundleFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSCALPBundleFactory(oneIDModule);
    }

    public static SCALPBundle provideSCALPBundle(OneIDModule oneIDModule) {
        return (SCALPBundle) Preconditions.checkNotNullFromProvides(oneIDModule.provideSCALPBundle());
    }
}
