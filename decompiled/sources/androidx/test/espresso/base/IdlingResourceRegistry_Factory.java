package androidx.test.espresso.base;

import android.os.Looper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class IdlingResourceRegistry_Factory implements Provider<IdlingResourceRegistry> {
    private final Provider looperProvider;

    public IdlingResourceRegistry_Factory(Provider<Looper> provider) {
        this.looperProvider = provider;
    }

    public static IdlingResourceRegistry_Factory create(Provider<Looper> provider) {
        return new IdlingResourceRegistry_Factory(provider);
    }

    public static IdlingResourceRegistry newInstance(Looper looper) {
        return new IdlingResourceRegistry(looper);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    public IdlingResourceRegistry get() {
        return newInstance((Looper) this.looperProvider.get());
    }
}
