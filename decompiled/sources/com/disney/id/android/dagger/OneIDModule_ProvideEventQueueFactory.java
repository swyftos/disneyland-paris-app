package com.disney.id.android.dagger;

import android.content.Context;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.tracker.EventQueue;
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
public final class OneIDModule_ProvideEventQueueFactory implements Factory<EventQueue> {
    private final Provider appContextProvider;
    private final Provider configHandlerProvider;
    private final OneIDModule module;

    public OneIDModule_ProvideEventQueueFactory(OneIDModule oneIDModule, Provider<Context> provider, Provider<ConfigHandler> provider2) {
        this.module = oneIDModule;
        this.appContextProvider = provider;
        this.configHandlerProvider = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: get */
    public EventQueue get2() {
        return provideEventQueue(this.module, (Context) this.appContextProvider.get2(), (ConfigHandler) this.configHandlerProvider.get2());
    }

    public static OneIDModule_ProvideEventQueueFactory create(OneIDModule oneIDModule, Provider<Context> provider, Provider<ConfigHandler> provider2) {
        return new OneIDModule_ProvideEventQueueFactory(oneIDModule, provider, provider2);
    }

    public static EventQueue provideEventQueue(OneIDModule oneIDModule, Context context, ConfigHandler configHandler) {
        return (EventQueue) Preconditions.checkNotNullFromProvides(oneIDModule.provideEventQueue(context, configHandler));
    }
}
