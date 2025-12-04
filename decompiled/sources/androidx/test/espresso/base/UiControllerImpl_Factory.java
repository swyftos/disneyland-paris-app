package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.base.IdlingResourceRegistry;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UiControllerImpl_Factory implements Provider<UiControllerImpl> {
    private final Provider asyncIdleProvider;
    private final Provider compatIdleProvider;
    private final Provider dynamicIdleProvider;
    private final Provider eventInjectorProvider;
    private final Provider idlingResourceRegistryProvider;
    private final Provider mainLooperProvider;

    public UiControllerImpl_Factory(Provider<EventInjector> provider, Provider<IdleNotifier<Runnable>> provider2, Provider<IdleNotifier<Runnable>> provider3, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> provider4, Provider<Looper> provider5, Provider<IdlingResourceRegistry> provider6) {
        this.eventInjectorProvider = provider;
        this.asyncIdleProvider = provider2;
        this.compatIdleProvider = provider3;
        this.dynamicIdleProvider = provider4;
        this.mainLooperProvider = provider5;
        this.idlingResourceRegistryProvider = provider6;
    }

    public static UiControllerImpl_Factory create(Provider<EventInjector> provider, Provider<IdleNotifier<Runnable>> provider2, Provider<IdleNotifier<Runnable>> provider3, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> provider4, Provider<Looper> provider5, Provider<IdlingResourceRegistry> provider6) {
        return new UiControllerImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static UiControllerImpl newInstance(Object obj, Object obj2, Object obj3, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> provider, Looper looper, IdlingResourceRegistry idlingResourceRegistry) {
        return new UiControllerImpl((EventInjector) obj, (IdleNotifier) obj2, (IdleNotifier) obj3, provider, looper, idlingResourceRegistry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public UiControllerImpl get2() {
        return newInstance(this.eventInjectorProvider.get2(), this.asyncIdleProvider.get2(), this.compatIdleProvider.get2(), this.dynamicIdleProvider, (Looper) this.mainLooperProvider.get2(), (IdlingResourceRegistry) this.idlingResourceRegistryProvider.get2());
    }
}
