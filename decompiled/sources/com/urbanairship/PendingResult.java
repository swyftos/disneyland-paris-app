package com.urbanairship;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public class PendingResult<T> implements Cancelable, Future<T> {
    private boolean isCanceled;
    private Object result;
    private boolean resultSet;
    private boolean runCallbacks = true;
    private final List cancelables = new ArrayList();
    private final List resultCallbacks = new ArrayList();

    @Override // com.urbanairship.Cancelable
    public final boolean cancel() {
        return cancel(false);
    }

    @Override // com.urbanairship.Cancelable
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isCancelled()) {
                    return true;
                }
                this.runCallbacks = false;
                Iterator it = this.resultCallbacks.iterator();
                while (it.hasNext()) {
                    ((Cancelable) it.next()).cancel(z);
                }
                this.resultCallbacks.clear();
                if (isDone()) {
                    return false;
                }
                this.isCanceled = true;
                notifyAll();
                Iterator it2 = this.cancelables.iterator();
                while (it2.hasNext()) {
                    ((Cancelable) it2.next()).cancel(z);
                }
                this.cancelables.clear();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setResult(@Nullable T t) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return;
                }
                this.result = t;
                this.resultSet = true;
                this.cancelables.clear();
                notifyAll();
                Iterator it = this.resultCallbacks.iterator();
                while (it.hasNext()) {
                    ((CancelableOperation) it.next()).run();
                }
                this.resultCallbacks.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public T getResult() {
        T t;
        synchronized (this) {
            t = (T) this.result;
        }
        return t;
    }

    @Override // com.urbanairship.Cancelable
    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.isCanceled;
        }
        return z;
    }

    @Override // com.urbanairship.Cancelable
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            try {
                z = this.isCanceled || this.resultSet;
            } finally {
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get() throws ExecutionException, InterruptedException {
        synchronized (this) {
            try {
                if (isDone()) {
                    return (T) this.result;
                }
                wait();
                return (T) this.result;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get(long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            try {
                if (isDone()) {
                    return (T) this.result;
                }
                wait(timeUnit.toMillis(j));
                return (T) this.result;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public PendingResult<T> addCancelable(@NonNull Cancelable cancelable) {
        synchronized (this) {
            try {
                if (isCancelled()) {
                    cancelable.cancel();
                }
                if (!isDone()) {
                    this.cancelables.add(cancelable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @NonNull
    public PendingResult<T> addResultCallback(@NonNull ResultCallback<T> resultCallback) {
        return addResultCallback(Looper.myLooper(), resultCallback);
    }

    @NonNull
    public PendingResult<T> addResultCallback(@Nullable Looper looper, @NonNull final ResultCallback<T> resultCallback) {
        synchronized (this) {
            try {
                if (!isCancelled() && this.runCallbacks) {
                    CancelableOperation cancelableOperation = new CancelableOperation(looper) { // from class: com.urbanairship.PendingResult.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.urbanairship.CancelableOperation
                        protected void onRun() {
                            synchronized (PendingResult.this) {
                                try {
                                    if (PendingResult.this.runCallbacks) {
                                        resultCallback.onResult(PendingResult.this.result);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    };
                    if (isDone()) {
                        cancelableOperation.run();
                    }
                    this.resultCallbacks.add(cancelableOperation);
                    return this;
                }
                return this;
            } finally {
            }
        }
    }
}
