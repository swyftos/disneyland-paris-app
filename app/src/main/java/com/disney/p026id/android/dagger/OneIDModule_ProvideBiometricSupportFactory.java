package com.disney.p026id.android.dagger;

import com.disney.p026id.android.BiometricSupport;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideBiometricSupportFactory implements Factory<BiometricSupport> {
    private final OneIDModule module;

    public OneIDModule_ProvideBiometricSupportFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public BiometricSupport get2() {
        return provideBiometricSupport(this.module);
    }

    public static OneIDModule_ProvideBiometricSupportFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideBiometricSupportFactory(oneIDModule);
    }

    public static BiometricSupport provideBiometricSupport(OneIDModule oneIDModule) {
        return (BiometricSupport) Preconditions.checkNotNullFromProvides(oneIDModule.provideBiometricSupport());
    }
}
