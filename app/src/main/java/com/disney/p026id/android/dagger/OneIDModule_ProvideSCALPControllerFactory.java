package com.disney.p026id.android.dagger;

import com.disney.p026id.android.SCALPController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideSCALPControllerFactory implements Factory<SCALPController> {
    private final OneIDModule module;

    public OneIDModule_ProvideSCALPControllerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public SCALPController get2() {
        return provideSCALPController(this.module);
    }

    public static OneIDModule_ProvideSCALPControllerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSCALPControllerFactory(oneIDModule);
    }

    public static SCALPController provideSCALPController(OneIDModule oneIDModule) {
        return (SCALPController) Preconditions.checkNotNullFromProvides(oneIDModule.provideSCALPController());
    }
}
