package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundInitializer<T> extends AbstractConcurrentInitializer<T, Exception> {
    private ExecutorService executor;
    private ExecutorService externalExecutor;
    private Future future;

    protected int getTaskCount() {
        return 1;
    }

    public static class Builder<I extends BackgroundInitializer<T>, T> extends AbstractConcurrentInitializer.AbstractBuilder<I, T, Builder<I, T>, Exception> {
        private ExecutorService externalExecutor;

        @Override // org.apache.commons.lang3.function.FailableSupplier
        public I get() {
            return (I) new BackgroundInitializer(getInitializer(), getCloser(), this.externalExecutor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<I, T> setExternalExecutor(ExecutorService executorService) {
            this.externalExecutor = executorService;
            return (Builder) asThis();
        }
    }

    private final class InitializationTask implements Callable {
        private final ExecutorService execFinally;

        InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            try {
                return BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    public static <T> Builder<BackgroundInitializer<T>, T> builder() {
        return new Builder<>();
    }

    protected BackgroundInitializer() {
        this(null);
    }

    protected BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }

    private BackgroundInitializer(FailableSupplier failableSupplier, FailableConsumer failableConsumer, ExecutorService executorService) {
        super(failableSupplier, failableConsumer);
        setExternalExecutor(executorService);
    }

    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    private Callable createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    @Override // org.apache.commons.lang3.function.FailableSupplier
    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e);
        } catch (ExecutionException e2) {
            ConcurrentUtils.handleCause(e2);
            return null;
        }
    }

    protected final synchronized ExecutorService getActiveExecutor() {
        return this.executor;
    }

    public final synchronized ExecutorService getExternalExecutor() {
        return this.externalExecutor;
    }

    public synchronized Future<T> getFuture() {
        Future<T> future;
        future = this.future;
        if (future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    protected Exception getTypedException(Exception exc) {
        return new Exception(exc);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public synchronized boolean isInitialized() {
        Future future = this.future;
        if (future == null || !future.isDone()) {
            return false;
        }
        try {
            this.future.get();
            return true;
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            return false;
        }
    }

    public synchronized boolean isStarted() {
        return this.future != null;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (isStarted()) {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
        this.externalExecutor = executorService;
    }

    public synchronized boolean start() {
        ExecutorService executorServiceCreateExecutor;
        try {
            if (isStarted()) {
                return false;
            }
            ExecutorService externalExecutor = getExternalExecutor();
            this.executor = externalExecutor;
            if (externalExecutor == null) {
                executorServiceCreateExecutor = createExecutor();
                this.executor = executorServiceCreateExecutor;
            } else {
                executorServiceCreateExecutor = null;
            }
            this.future = this.executor.submit(createTask(executorServiceCreateExecutor));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
