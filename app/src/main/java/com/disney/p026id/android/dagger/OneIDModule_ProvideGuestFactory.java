package com.disney.p026id.android.dagger;

import com.disney.p026id.android.GuestHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideGuestFactory implements Factory<GuestHandler> {
    private final OneIDModule module;

    public OneIDModule_ProvideGuestFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public GuestHandler get2() {
        return provideGuest(this.module);
    }

    public static OneIDModule_ProvideGuestFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideGuestFactory(oneIDModule);
    }

    public static GuestHandler provideGuest(OneIDModule oneIDModule) {
        return (GuestHandler) Preconditions.checkNotNullFromProvides(oneIDModule.provideGuest());
    }
}
