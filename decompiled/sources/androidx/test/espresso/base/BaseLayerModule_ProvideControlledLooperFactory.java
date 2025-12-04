package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.internal.platform.os.ControlledLooper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideControlledLooperFactory implements Provider<ControlledLooper> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideControlledLooperFactory(BaseLayerModule baseLayerModule) {
        this.module = baseLayerModule;
    }

    public static BaseLayerModule_ProvideControlledLooperFactory create(BaseLayerModule baseLayerModule) {
        return new BaseLayerModule_ProvideControlledLooperFactory(baseLayerModule);
    }

    public static ControlledLooper provideControlledLooper(BaseLayerModule baseLayerModule) {
        return (ControlledLooper) Preconditions.checkNotNullFromProvides(baseLayerModule.provideControlledLooper());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public ControlledLooper get2() {
        return provideControlledLooper(this.module);
    }
}
