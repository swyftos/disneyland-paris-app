package dagger.internal;

import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SingleCheck<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider provider;

    private SingleCheck(Provider provider) {
        this.provider = provider;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.instance;
        if (t != UNINITIALIZED) {
            return t;
        }
        Provider provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t2 = (T) provider.get();
        this.instance = t2;
        this.provider = null;
        return t2;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((Provider) Preconditions.checkNotNull(p));
    }
}
