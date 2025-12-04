package com.urbanairship.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.util.RetryingExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RetryingExecutor implements Executor {
    private static final Result CANCEL_RESULT;
    private static final Result FINISHED_RESULT;
    public static final long INITIAL_BACKOFF_MILLIS = 30000;
    private final Executor executor;
    private boolean isPaused = false;
    private final List pendingRunnables = new ArrayList();
    private final Handler scheduler;

    public interface Operation {
        @NonNull
        Result run();
    }

    public enum Status {
        FINISHED,
        RETRY,
        CANCEL
    }

    static {
        long j = -1;
        AnonymousClass1 anonymousClass1 = null;
        FINISHED_RESULT = new Result(Status.FINISHED, j, anonymousClass1);
        CANCEL_RESULT = new Result(Status.CANCEL, j, anonymousClass1);
    }

    public RetryingExecutor(@NonNull Handler handler, @NonNull Executor executor) {
        this.scheduler = handler;
        this.executor = executor;
    }

    public static RetryingExecutor newSerialExecutor(Looper looper) {
        return new RetryingExecutor(new Handler(looper), AirshipExecutors.newSerialExecutor());
    }

    public static Result retryResult() {
        return new Result(Status.RETRY, -1L, null);
    }

    public static Result retryResult(long j) {
        return new Result(Status.RETRY, j, null);
    }

    public static Result finishedResult() {
        return FINISHED_RESULT;
    }

    public static Result cancelResult() {
        return CANCEL_RESULT;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull final Runnable runnable) {
        execute(new Operation() { // from class: com.urbanairship.util.RetryingExecutor$$ExternalSyntheticLambda0
            @Override // com.urbanairship.util.RetryingExecutor.Operation
            public final RetryingExecutor.Result run() {
                return RetryingExecutor.lambda$execute$0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Result lambda$execute$0(Runnable runnable) {
        runnable.run();
        return finishedResult();
    }

    public void execute(@NonNull Operation operation) {
        execute(operation, 30000L);
    }

    public void execute(@NonNull Operation... operationArr) {
        execute(new ChainedOperations(Arrays.asList(operationArr)));
    }

    /* renamed from: com.urbanairship.util.RetryingExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long val$nextBackOff;
        final /* synthetic */ Operation val$operation;

        AnonymousClass1(Operation operation, long j) {
            this.val$operation = operation;
            this.val$nextBackOff = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (RetryingExecutor.this.pendingRunnables) {
                try {
                    if (RetryingExecutor.this.isPaused) {
                        RetryingExecutor.this.pendingRunnables.add(this);
                        return;
                    }
                    Result resultRun = this.val$operation.run();
                    if (resultRun.status == Status.RETRY) {
                        final long j = resultRun.nextBackOff >= 0 ? resultRun.nextBackOff : this.val$nextBackOff;
                        Handler handler = RetryingExecutor.this.scheduler;
                        final Operation operation = this.val$operation;
                        handler.postAtTime(new Runnable() { // from class: com.urbanairship.util.RetryingExecutor$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$0(operation, j);
                            }
                        }, RetryingExecutor.this.executor, SystemClock.uptimeMillis() + j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Operation operation, long j) {
            RetryingExecutor retryingExecutor = RetryingExecutor.this;
            retryingExecutor.execute(operation, retryingExecutor.calculateBackoff(j));
        }
    }

    public void execute(@NonNull Operation operation, long j) {
        this.executor.execute(new AnonymousClass1(operation, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateBackoff(long j) {
        if (j <= 0) {
            return 30000L;
        }
        return Math.min(j * 2, 120000L);
    }

    public void setPaused(boolean z) {
        if (z == this.isPaused) {
            return;
        }
        synchronized (this.pendingRunnables) {
            try {
                this.isPaused = z;
                if (!z && !this.pendingRunnables.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.pendingRunnables);
                    this.pendingRunnables.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.executor.execute((Runnable) it.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private class ChainedOperations implements Operation {
        private final List operations;

        ChainedOperations(List list) {
            this.operations = new ArrayList(list);
        }

        @Override // com.urbanairship.util.RetryingExecutor.Operation
        public Result run() {
            if (this.operations.isEmpty()) {
                return RetryingExecutor.finishedResult();
            }
            Result resultRun = ((Operation) this.operations.get(0)).run();
            if (resultRun.status == Status.FINISHED) {
                this.operations.remove(0);
                RetryingExecutor.this.execute(this);
            }
            return resultRun;
        }
    }

    public static class Result {
        private final long nextBackOff;
        private final Status status;

        /* synthetic */ Result(Status status, long j, AnonymousClass1 anonymousClass1) {
            this(status, j);
        }

        private Result(Status status, long j) {
            this.status = status;
            this.nextBackOff = j;
        }
    }
}
