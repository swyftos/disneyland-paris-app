package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListeningExecutorService;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideRemoteExecutorFactory implements Provider<ListeningExecutorService> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideRemoteExecutorFactory(BaseLayerModule baseLayerModule) {
        this.module = baseLayerModule;
    }

    public static BaseLayerModule_ProvideRemoteExecutorFactory create(BaseLayerModule baseLayerModule) {
        return new BaseLayerModule_ProvideRemoteExecutorFactory(baseLayerModule);
    }

    public static ListeningExecutorService provideRemoteExecutor(BaseLayerModule baseLayerModule) {
        return (ListeningExecutorService) Preconditions.checkNotNullFromProvides(baseLayerModule.provideRemoteExecutor());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public ListeningExecutorService get2() {
        return provideRemoteExecutor(this.module);
    }
}
