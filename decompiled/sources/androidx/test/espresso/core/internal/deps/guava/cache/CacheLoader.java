package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;

/* loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public abstract V load(K k) throws Exception;

    public ListenableFuture<V> reload(K k, V v) throws Exception {
        throw null;
    }
}
