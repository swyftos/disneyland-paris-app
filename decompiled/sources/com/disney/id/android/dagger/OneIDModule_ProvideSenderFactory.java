package com.disney.id.android.dagger;

import com.disney.id.android.tracker.Sender;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideSenderFactory implements Factory<Sender> {
    private final OneIDModule module;

    public OneIDModule_ProvideSenderFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public Sender get2() {
        return provideSender(this.module);
    }

    public static OneIDModule_ProvideSenderFactory create(OneIDModule oneIDModule) {
        return new OneIDModule_ProvideSenderFactory(oneIDModule);
    }

    public static Sender provideSender(OneIDModule oneIDModule) {
        return (Sender) Preconditions.checkNotNullFromProvides(oneIDModule.provideSender());
    }
}
