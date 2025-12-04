package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class SerialExecutor implements Executor {
    private final Executor executor;
    private final ArrayDeque runnables = new ArrayDeque();
    private boolean isExecuting = false;

    public SerialExecutor(@NonNull Executor executor) {
        this.executor = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@Nullable final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.urbanairship.util.SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.next();
                }
            }
        };
        synchronized (this.runnables) {
            try {
                this.runnables.offer(runnable2);
                if (!this.isExecuting) {
                    next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        synchronized (this.runnables) {
            try {
                Runnable runnable = (Runnable) this.runnables.pollFirst();
                if (runnable != null) {
                    this.isExecuting = true;
                    this.executor.execute(runnable);
                } else {
                    this.isExecuting = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
