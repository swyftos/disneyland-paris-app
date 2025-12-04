package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.Validate;

/* loaded from: classes6.dex */
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

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    protected T initialize() throws Exception {
        return (T) this.callable.call();
    }

    private void checkCallable(Callable callable) {
        Validate.isTrue(callable != null, "Callable must not be null!", new Object[0]);
    }
}
