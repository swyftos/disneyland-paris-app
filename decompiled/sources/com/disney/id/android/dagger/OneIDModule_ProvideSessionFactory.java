package com.disney.id.android.dagger;

import com.disney.id.android.Session;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideSessionFactory implements Factory<Session> {
    private final OneIDModule module;

    public OneIDModule_ProvideSessionFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
