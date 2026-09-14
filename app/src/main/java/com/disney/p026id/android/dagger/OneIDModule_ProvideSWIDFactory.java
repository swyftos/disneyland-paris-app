package com.disney.p026id.android.dagger;

import com.disney.p026id.android.SWID;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideSWIDFactory implements Factory<SWID> {
    private final OneIDModule module;

    public OneIDModule_ProvideSWIDFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public SWID get2() {
        return provideSWID(this.module);
    }

    public static OneIDModule_ProvideSWIDFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSWIDFactory(oneIDModule);
    }

    public static SWID provideSWID(OneIDModule oneIDModule) {
        return (SWID) Preconditions.checkNotNullFromProvides(oneIDModule.provideSWID());
    }
}
