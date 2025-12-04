package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile Object object = NO_INIT;

    protected abstract T initialize() throws ConcurrentException;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T tInitialize = (T) this.object;
        Object obj = NO_INIT;
        if (tInitialize == obj) {
            synchronized (this) {
                try {
                    tInitialize = (T) this.object;
                    if (tInitialize == obj) {
                        tInitialize = initialize();
                        this.object = tInitialize;
                    }
                } finally {
                }
            }
        }
        return tInitialize;
    }
}
