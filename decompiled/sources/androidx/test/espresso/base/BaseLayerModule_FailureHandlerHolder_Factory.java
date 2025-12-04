package androidx.test.espresso.base;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.base.BaseLayerModule;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_FailureHandlerHolder_Factory implements Provider<BaseLayerModule.FailureHandlerHolder> {
    private final Provider defaultHandlerProvider;

    public BaseLayerModule_FailureHandlerHolder_Factory(Provider<FailureHandler> provider) {
        this.defaultHandlerProvider = provider;
    }

    public static BaseLayerModule_FailureHandlerHolder_Factory create(Provider<FailureHandler> provider) {
        return new BaseLayerModule_FailureHandlerHolder_Factory(provider);
    }

    public static BaseLayerModule.FailureHandlerHolder newInstance(FailureHandler failureHandler) {
        return new BaseLayerModule.FailureHandlerHolder(failureHandler);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public BaseLayerModule.FailureHandlerHolder get2() {
        return newInstance((FailureHandler) this.defaultHandlerProvider.get2());
    }
}
