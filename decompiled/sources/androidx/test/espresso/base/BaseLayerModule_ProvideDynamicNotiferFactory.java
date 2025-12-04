package androidx.test.espresso.base;

import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideDynamicNotiferFactory implements Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> {
    private final Provider dynamicRegistryProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideDynamicNotiferFactory(BaseLayerModule baseLayerModule, Provider<IdlingResourceRegistry> provider) {
        this.module = baseLayerModule;
        this.dynamicRegistryProvider = provider;
    }

    public static BaseLayerModule_ProvideDynamicNotiferFactory create(BaseLayerModule baseLayerModule, Provider<IdlingResourceRegistry> provider) {
        return new BaseLayerModule_ProvideDynamicNotiferFactory(baseLayerModule, provider);
    }

    public static IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> provideDynamicNotifer(BaseLayerModule baseLayerModule, IdlingResourceRegistry idlingResourceRegistry) {
        return (IdleNotifier) Preconditions.checkNotNullFromProvides(baseLayerModule.provideDynamicNotifer(idlingResourceRegistry));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> get2() {
        return provideDynamicNotifer(this.module, (IdlingResourceRegistry) this.dynamicRegistryProvider.get2());
    }
}
