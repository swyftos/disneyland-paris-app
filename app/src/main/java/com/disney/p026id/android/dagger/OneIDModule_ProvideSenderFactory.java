package com.disney.p026id.android.dagger;

import com.disney.p026id.android.tracker.Sender;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideSenderFactory implements Factory<Sender> {
    private final OneIDModule module;

    public OneIDModule_ProvideSenderFactory(OneIDModule oneIDModule) {
        this.module = oneIDModule;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
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
