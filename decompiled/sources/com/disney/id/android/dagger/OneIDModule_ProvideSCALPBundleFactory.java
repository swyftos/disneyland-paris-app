package com.disney.id.android.dagger;

import com.disney.id.android.SCALPBundle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideSCALPBundleFactory implements Factory<SCALPBundle> {
    private final OneIDModule module;

    public OneIDModule_ProvideSCALPBundleFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
