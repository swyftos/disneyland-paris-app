package com.disney.id.android.dagger;

import com.disney.id.android.MigrationHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideMigrationHandlerFactory implements Factory<MigrationHandler> {
    private final OneIDModule module;

    public OneIDModule_ProvideMigrationHandlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public MigrationHandler get2() {
        return provideMigrationHandler(this.module);
    }

    public static OneIDModule_ProvideMigrationHandlerFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideMigrationHandlerFactory(oneIDModule);
    }

    public static MigrationHandler provideMigrationHandler(OneIDModule oneIDModule) {
        return (MigrationHandler) Preconditions.checkNotNullFromProvides(oneIDModule.provideMigrationHandler());
    }
}
