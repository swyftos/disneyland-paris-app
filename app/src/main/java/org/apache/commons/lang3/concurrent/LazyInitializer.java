package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: loaded from: classes6.dex */
public class LazyInitializer<T> extends AbstractConcurrentInitializer<T, ConcurrentException> {
    private static final Object NO_INIT = new Object();
    private volatile Object object;

    public static class Builder<I extends LazyInitializer<T>, T> extends AbstractConcurrentInitializer.AbstractBuilder<I, T, Builder<I, T>, ConcurrentException> {
        @Override // org.apache.commons.lang3.function.FailableSupplier
        public I get() {
            return (I) new LazyInitializer(getInitializer(), getCloser());
        }
    }

    public static <T> Builder<LazyInitializer<T>, T> builder() {
        return new Builder<>();
    }

    public LazyInitializer() {
        this.object = NO_INIT;
    }

    private LazyInitializer(FailableSupplier failableSupplier, FailableConsumer failableConsumer) {
        super(failableSupplier, failableConsumer);
        this.object = NO_INIT;
    }

    @Override // org.apache.commons.lang3.function.FailableSupplier
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
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return tInitialize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public ConcurrentException getTypedException(Exception exc) {
        return new ConcurrentException(exc);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        return this.object != NO_INIT;
    }
}
