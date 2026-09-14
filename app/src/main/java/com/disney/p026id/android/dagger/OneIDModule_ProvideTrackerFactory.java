package com.disney.p026id.android.dagger;

import android.content.Context;
import com.disney.p026id.android.tracker.Tracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes3.dex */
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class OneIDModule_ProvideTrackerFactory implements Factory<Tracker> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideTrackerFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Tracker get2() {
        return provideTracker(this.module, (Context) this.appContextProvider.get2());
    }

    public static OneIDModule_ProvideTrackerFactory create(OneIDModule oneIDModule, Provider<Context> provider) {
        return new OneIDModule_ProvideTrackerFactory(oneIDModule, provider);
    }

    public static Tracker provideTracker(OneIDModule oneIDModule, Context context) {
        return (Tracker) Preconditions.checkNotNullFromProvides(oneIDModule.provideTracker(context));
    }
}
