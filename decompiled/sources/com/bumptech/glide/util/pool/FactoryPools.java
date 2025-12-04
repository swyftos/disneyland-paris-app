package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class FactoryPools {
    private static final Resetter EMPTY_RESETTER = new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };

    public interface Factory<T> {
        T create();
    }

    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    public interface Resetter<T> {
        void reset(@NonNull T t);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i, @NonNull Factory<T> factory) {
        return build(new Pools.SimplePool(i), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, @NonNull Factory<T> factory) {
        return build(new Pools.SynchronizedPool(i), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return build(new Pools.SynchronizedPool(i), factory, resetter);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i) {
        return build(new Pools.SynchronizedPool(i), new Factory() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List create() {
                return new ArrayList();
            }
        }, new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(List list) {
                list.clear();
            }
        });
    }

    private static Pools.Pool build(Pools.Pool pool, Factory factory) {
        return build(pool, factory, emptyResetter());
    }

    private static Pools.Pool build(Pools.Pool pool, Factory factory, Resetter resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    private static Resetter emptyResetter() {
        return EMPTY_RESETTER;
    }

    private static final class FactoryPool implements Pools.Pool {
        private final Factory factory;
        private final Pools.Pool pool;
        private final Resetter resetter;

        FactoryPool(Pools.Pool pool, Factory factory, Resetter resetter) {
            this.pool = pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object acquire() {
            Object objAcquire = this.pool.acquire();
            if (objAcquire == null) {
                objAcquire = this.factory.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objAcquire.getClass());
                }
            }
            if (objAcquire instanceof Poolable) {
                ((Poolable) objAcquire).getVerifier().setRecycled(false);
            }
            return objAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(Object obj) {
            if (obj instanceof Poolable) {
                ((Poolable) obj).getVerifier().setRecycled(true);
            }
            this.resetter.reset(obj);
            return this.pool.release(obj);
        }
    }
}
