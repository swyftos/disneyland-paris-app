package com.disney.p026id.android.dagger;

import com.disney.p026id.android.MigrationHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideMigrationHandlerFactory implements Factory<MigrationHandler> {
    private final OneIDModule module;

    public OneIDModule_ProvideMigrationHandlerFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
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
