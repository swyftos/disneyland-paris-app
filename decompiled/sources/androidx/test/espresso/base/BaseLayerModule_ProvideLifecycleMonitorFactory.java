package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideLifecycleMonitorFactory implements Provider<ActivityLifecycleMonitor> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideLifecycleMonitorFactory(BaseLayerModule baseLayerModule) {
        this.module = baseLayerModule;
    }

    public static BaseLayerModule_ProvideLifecycleMonitorFactory create(BaseLayerModule baseLayerModule) {
        return new BaseLayerModule_ProvideLifecycleMonitorFactory(baseLayerModule);
    }

    public static ActivityLifecycleMonitor provideLifecycleMonitor(BaseLayerModule baseLayerModule) {
        return (ActivityLifecycleMonitor) Preconditions.checkNotNullFromProvides(baseLayerModule.provideLifecycleMonitor());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public ActivityLifecycleMonitor get2() {
        return provideLifecycleMonitor(this.module);
    }
}
