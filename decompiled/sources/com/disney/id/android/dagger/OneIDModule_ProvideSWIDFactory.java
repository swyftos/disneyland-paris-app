package com.disney.id.android.dagger;

import com.disney.id.android.SWID;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideSWIDFactory implements Factory<SWID> {
    private final OneIDModule module;

    public OneIDModule_ProvideSWIDFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
