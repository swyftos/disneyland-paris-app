package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory implements Provider<IdleNotifier<Runnable>> {
    private final Provider extractorProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory(BaseLayerModule baseLayerModule, Provider<ThreadPoolExecutorExtractor> provider) {
        this.module = baseLayerModule;
        this.extractorProvider = provider;
    }

    public static BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory create(BaseLayerModule baseLayerModule, Provider<ThreadPoolExecutorExtractor> provider) {
        return new BaseLayerModule_ProvideCompatAsyncTaskMonitorFactory(baseLayerModule, provider);
    }

    public static IdleNotifier<Runnable> provideCompatAsyncTaskMonitor(BaseLayerModule baseLayerModule, Object obj) {
        return (IdleNotifier) Preconditions.checkNotNullFromProvides(baseLayerModule.provideCompatAsyncTaskMonitor((ThreadPoolExecutorExtractor) obj));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public IdleNotifier<Runnable> get2() {
        return provideCompatAsyncTaskMonitor(this.module, this.extractorProvider.get2());
    }
}
