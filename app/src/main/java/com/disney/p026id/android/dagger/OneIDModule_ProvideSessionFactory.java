package com.disney.p026id.android.dagger;

import com.disney.p026id.android.Session;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideSessionFactory implements Factory<Session> {
    private final OneIDModule module;

    public OneIDModule_ProvideSessionFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Session get2() {
        return provideSession(this.module);
    }

    public static OneIDModule_ProvideSessionFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSessionFactory(oneIDModule);
    }

    public static Session provideSession(OneIDModule oneIDModule) {
        return (Session) Preconditions.checkNotNullFromProvides(oneIDModule.provideSession());
    }
}
