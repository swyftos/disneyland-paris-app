package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject;

/* loaded from: classes2.dex */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    protected ForwardingCache() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    protected abstract Cache<K, V> delegate();

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        throw null;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public void invalidateAll() {
        delegate().invalidateAll();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public void put(K k, V v) {
        delegate().put(k, v);
    }
}
