package androidx.test.espresso.base;

import android.os.Looper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RootsOracle_Factory implements Provider<RootsOracle> {
    private final Provider mainLooperProvider;

    public RootsOracle_Factory(Provider<Looper> provider) {
        this.mainLooperProvider = provider;
    }

    public static RootsOracle_Factory create(Provider<Looper> provider) {
        return new RootsOracle_Factory(provider);
    }

    public static RootsOracle newInstance(Looper looper) {
        return new RootsOracle(looper);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    public RootsOracle get() {
        return newInstance((Looper) this.mainLooperProvider.get());
    }
}
