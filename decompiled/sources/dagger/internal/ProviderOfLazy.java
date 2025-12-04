package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    private final Provider provider;

    private ProviderOfLazy(Provider provider) {
        this.provider = provider;
    }

    @Override // javax.inject.Provider
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }

    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }
}
