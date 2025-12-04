package androidx.test.espresso.core.internal.deps.guava.cache;

/* loaded from: classes2.dex */
public interface Cache<K, V> {
    V getIfPresent(Object obj);

    void invalidateAll();

    void put(K k, V v);
}
