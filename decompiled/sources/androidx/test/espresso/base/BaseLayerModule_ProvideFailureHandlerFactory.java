package androidx.test.espresso.base;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideFailureHandlerFactory implements Provider<FailureHandler> {
    private final Provider holderProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideFailureHandlerFactory(BaseLayerModule baseLayerModule, Provider<BaseLayerModule.FailureHandlerHolder> provider) {
        this.module = baseLayerModule;
        this.holderProvider = provider;
    }

    public static BaseLayerModule_ProvideFailureHandlerFactory create(BaseLayerModule baseLayerModule, Provider<BaseLayerModule.FailureHandlerHolder> provider) {
        return new BaseLayerModule_ProvideFailureHandlerFactory(baseLayerModule, provider);
    }

    public static FailureHandler provideFailureHandler(BaseLayerModule baseLayerModule, BaseLayerModule.FailureHandlerHolder failureHandlerHolder) {
        return (FailureHandler) Preconditions.checkNotNullFromProvides(baseLayerModule.provideFailureHandler(failureHandlerHolder));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public FailureHandler get2() {
        return provideFailureHandler(this.module, (BaseLayerModule.FailureHandlerHolder) this.holderProvider.get2());
    }
}
