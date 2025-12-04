package com.disney.id.android.dagger;

import com.disney.id.android.SCALPConfigHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideSCALPConfigHandlerFactory implements Factory<SCALPConfigHandler> {
    private final OneIDModule module;

    public OneIDModule_ProvideSCALPConfigHandlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public SCALPConfigHandler get2() {
        return provideSCALPConfigHandler(this.module);
    }

    public static OneIDModule_ProvideSCALPConfigHandlerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSCALPConfigHandlerFactory(oneIDModule);
    }

    public static SCALPConfigHandler provideSCALPConfigHandler(OneIDModule oneIDModule) {
        return (SCALPConfigHandler) Preconditions.checkNotNullFromProvides(oneIDModule.provideSCALPConfigHandler());
    }
}
