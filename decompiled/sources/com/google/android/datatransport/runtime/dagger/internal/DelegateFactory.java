package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private Provider delegate;

    @Override // javax.inject.Provider
    public T get() {
        Provider provider = this.delegate;
        if (provider == null) {
            throw new IllegalStateException();
        }
        return (T) provider.get();
    }

    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }

    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = provider2;
    }

    Provider getDelegate() {
        return (Provider) Preconditions.checkNotNull(this.delegate);
    }
}
