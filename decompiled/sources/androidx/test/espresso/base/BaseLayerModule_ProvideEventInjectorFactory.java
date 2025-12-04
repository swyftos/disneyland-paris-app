package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideEventInjectorFactory implements Provider<EventInjector> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideEventInjectorFactory(BaseLayerModule baseLayerModule) {
        this.module = baseLayerModule;
    }

    public static BaseLayerModule_ProvideEventInjectorFactory create(BaseLayerModule baseLayerModule) {
        return new BaseLayerModule_ProvideEventInjectorFactory(baseLayerModule);
    }

    public static EventInjector provideEventInjector(BaseLayerModule baseLayerModule) {
        return (EventInjector) Preconditions.checkNotNullFromProvides(baseLayerModule.provideEventInjector());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public EventInjector get2() {
        return provideEventInjector(this.module);
    }
}
