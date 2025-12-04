package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.tracker.Tracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OneIDModule_ProvideTrackerFactory implements Factory<Tracker> {
    private final Provider appContextProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideTrackerFactory(OneIDModule oneIDModule, Provider<Context> provider) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
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
