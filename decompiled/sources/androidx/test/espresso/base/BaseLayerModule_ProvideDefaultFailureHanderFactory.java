package androidx.test.espresso.base;

import android.content.Context;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideDefaultFailureHanderFactory implements Provider<DefaultFailureHandler> {
    private final Provider contextProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideDefaultFailureHanderFactory(BaseLayerModule baseLayerModule, Provider<Context> provider) {
        this.module = baseLayerModule;
        this.contextProvider = provider;
    }

    public static BaseLayerModule_ProvideDefaultFailureHanderFactory create(BaseLayerModule baseLayerModule, Provider<Context> provider) {
        return new BaseLayerModule_ProvideDefaultFailureHanderFactory(baseLayerModule, provider);
    }

    public static DefaultFailureHandler provideDefaultFailureHander(BaseLayerModule baseLayerModule, Context context) {
        return (DefaultFailureHandler) Preconditions.checkNotNullFromProvides(baseLayerModule.provideDefaultFailureHander(context));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public DefaultFailureHandler get2() {
        return provideDefaultFailureHander(this.module, (Context) this.contextProvider.get2());
    }
}
