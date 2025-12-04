package com.urbanairship;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class CancelableOperation implements Cancelable, Runnable {
    private final List cancelables;
    private final Handler handler;
    private final Runnable internalRunnable;
    private boolean isCanceled;
    private boolean isFinished;
    private boolean isRunning;
    private final List runnables;

    protected void onCancel() {
    }

    protected void onRun() {
    }

    public CancelableOperation() {
        this(null);
    }

    public CancelableOperation(@Nullable Looper looper) {
        this.isFinished = false;
        this.isRunning = false;
        this.isCanceled = false;
        this.cancelables = new ArrayList();
        this.runnables = new ArrayList();
        if (looper != null) {
            this.handler = new Handler(looper);
        } else {
            Looper looperMyLooper = Looper.myLooper();
            this.handler = looperMyLooper != null ? new Handler(looperMyLooper) : new Handler(Looper.getMainLooper());
        }
        this.internalRunnable = new Runnable() { // from class: com.urbanairship.CancelableOperation.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CancelableOperation.this) {
                    try {
                        if (CancelableOperation.this.isDone()) {
                            return;
                        }
                        CancelableOperation.this.onRun();
                        CancelableOperation.this.isFinished = true;
                        Iterator it = CancelableOperation.this.runnables.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        CancelableOperation.this.cancelables.clear();
                        CancelableOperation.this.runnables.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    @Override // com.urbanairship.Cancelable
    public final boolean cancel() {
        return cancel(false);
    }

    @Override // com.urbanairship.Cancelable
    public final boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.isCanceled = true;
                this.handler.removeCallbacks(this.internalRunnable);
                this.handler.post(new Runnable() { // from class: com.urbanairship.CancelableOperation.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CancelableOperation.this.onCancel();
                    }
                });
                Iterator it = this.cancelables.iterator();
                while (it.hasNext()) {
                    ((Cancelable) it.next()).cancel(z);
                }
                this.cancelables.clear();
                this.runnables.clear();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this) {
            try {
                if (!isDone() && !this.isRunning) {
                    this.isRunning = true;
                    this.handler.post(this.internalRunnable);
                }
            } finally {
            }
        }
    }

    @Override // com.urbanairship.Cancelable
    public final boolean isDone() {
        boolean z;
        synchronized (this) {
            try {
                z = this.isFinished || this.isCanceled;
            } finally {
            }
        }
        return z;
    }

    @Override // com.urbanairship.Cancelable
    public final boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.isCanceled;
        }
        return z;
    }

    @NonNull
    public CancelableOperation addOnRun(@NonNull Runnable runnable) {
        synchronized (this) {
            try {
                if (this.isFinished) {
                    runnable.run();
                } else {
                    this.runnables.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @NonNull
    public CancelableOperation addOnCancel(@NonNull Cancelable cancelable) {
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
    public Handler getHandler() {
        return this.handler;
    }
}
