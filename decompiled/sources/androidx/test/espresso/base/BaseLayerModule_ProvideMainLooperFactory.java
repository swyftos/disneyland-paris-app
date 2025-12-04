package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BaseLayerModule_ProvideMainLooperFactory implements Provider<Looper> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideMainLooperFactory(BaseLayerModule baseLayerModule) {
        this.module = baseLayerModule;
    }

    public static BaseLayerModule_ProvideMainLooperFactory create(BaseLayerModule baseLayerModule) {
        return new BaseLayerModule_ProvideMainLooperFactory(baseLayerModule);
    }

    public static Looper provideMainLooper(BaseLayerModule baseLayerModule) {
        return (Looper) Preconditions.checkNotNullFromProvides(baseLayerModule.provideMainLooper());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public Looper get2() {
        return provideMainLooper(this.module);
    }
}
