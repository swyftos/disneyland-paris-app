package org.apache.commons.lang3.concurrent;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {
    private final Callable callable;

    public CallableBackgroundInitializer(Callable<T> callable) {
        checkCallable(callable);
        this.callable = callable;
    }

    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        checkCallable(callable);
        this.callable = callable;
    }

    private void checkCallable(Callable callable) {
        Objects.requireNonNull(callable, "callable");
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer, org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    protected Exception getTypedException(Exception exc) {
        return new Exception(exc);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    protected T initialize() throws Exception {
        return (T) this.callable.call();
    }
}
