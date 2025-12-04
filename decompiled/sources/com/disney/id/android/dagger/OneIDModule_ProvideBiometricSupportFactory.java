package com.disney.id.android.dagger;

import com.disney.id.android.BiometricSupport;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideBiometricSupportFactory implements Factory<BiometricSupport> {
    private final OneIDModule module;

    public OneIDModule_ProvideBiometricSupportFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
