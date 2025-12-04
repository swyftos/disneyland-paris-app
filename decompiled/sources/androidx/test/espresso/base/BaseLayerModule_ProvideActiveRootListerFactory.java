package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideActiveRootListerFactory implements Provider<ActiveRootLister> {
    private final BaseLayerModule module;
    private final Provider rootsOracleProvider;

    public BaseLayerModule_ProvideActiveRootListerFactory(BaseLayerModule baseLayerModule, Provider<RootsOracle> provider) {
        this.module = baseLayerModule;
        this.rootsOracleProvider = provider;
    }

    public static BaseLayerModule_ProvideActiveRootListerFactory create(BaseLayerModule baseLayerModule, Provider<RootsOracle> provider) {
        return new BaseLayerModule_ProvideActiveRootListerFactory(baseLayerModule, provider);
    }

    public static ActiveRootLister provideActiveRootLister(BaseLayerModule baseLayerModule, Object obj) {
        return (ActiveRootLister) Preconditions.checkNotNullFromProvides(baseLayerModule.provideActiveRootLister((RootsOracle) obj));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public ActiveRootLister get2() {
        return provideActiveRootLister(this.module, this.rootsOracleProvider.get2());
    }
}
