package androidx.test.espresso;

import androidx.media3.common.C;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.remote.NoRemoteEspressoInstanceException;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
abstract class InteractionResultsHandler {

    private static class ExecutionResult<T> {
        private final Throwable failure;
        private final boolean priority;
        private final Object result;
        private final boolean success;

        private ExecutionResult(Object obj, boolean z, Throwable th, boolean z2) {
            this.result = obj;
            this.success = z;
            this.failure = th;
            this.priority = z2;
        }

        public static ExecutionResult error(Throwable th) {
            return error(th, false);
        }

        public static ExecutionResult success(Object obj) {
            return new ExecutionResult(obj, true, null, true);
        }

        public Throwable getFailure() {
            Preconditions.checkState(!this.success);
            return this.failure;
        }

        public Object getResult() {
            Preconditions.checkState(this.success);
            return this.result;
        }

        public boolean isPriority() {
            return this.priority;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues().add(Constants.FirelogAnalytics.PARAM_PRIORITY, this.priority).add("success", this.success).add("result", this.result).add("failure", this.failure).toString();
        }

        public static ExecutionResult error(Throwable th, boolean z) {
            return new ExecutionResult(null, false, th, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutionResult adaptResult(Future future) {
        try {
            Preconditions.checkState(future.isDone());
            return ExecutionResult.success(future.get());
        } catch (Error e) {
            return ExecutionResult.error(e);
        } catch (InterruptedException e2) {
            return ExecutionResult.error(e2);
        } catch (RuntimeException e3) {
            return ExecutionResult.error(e3);
        } catch (ExecutionException e4) {
            return ExecutionResult.error(e4, getPriority(e4) == Integer.MAX_VALUE);
        }
    }

    private static Object finalResult(ExecutionResult executionResult) {
        if (executionResult.isSuccess()) {
            return executionResult.getResult();
        }
        Throwable failure = executionResult.getFailure();
        if (!(failure instanceof ExecutionException)) {
            if (failure instanceof InterruptedException) {
                throw new IllegalStateException("Interrupted while interacting remotely", failure);
            }
            throw new RuntimeException("Error interacting remotely", failure);
        }
        Throwable cause = failure.getCause();
        if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw new RuntimeException("Unknown error during interactions", executionResult.getFailure());
    }

    static Object gatherAnyResult(List list) {
        return gatherAnyResult(list, MoreExecutors.directExecutor());
    }

    static Object gatherAnyResult(List list, Executor executor) {
        Preconditions.checkNotNull(list);
        Preconditions.checkState(!list.isEmpty());
        int size = list.size();
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(size);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            listenableFuture.addListener(new Runnable() { // from class: androidx.test.espresso.InteractionResultsHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (listenableFuture.isCancelled()) {
                        return;
                    }
                    linkedBlockingQueue.offer(InteractionResultsHandler.adaptResult(listenableFuture));
                }
            }, executor);
        }
        ExecutionResult executionResultPickResult = null;
        while (size != 0) {
            if (executionResultPickResult != null) {
                try {
                    try {
                        if (executionResultPickResult.isPriority()) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted while interacting", e);
                    }
                } catch (Throwable th) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ((ListenableFuture) it2.next()).cancel(true);
                    }
                    throw th;
                }
            }
            size--;
            executionResultPickResult = pickResult(executionResultPickResult, (ExecutionResult) linkedBlockingQueue.take());
        }
        Object objFinalResult = finalResult(executionResultPickResult);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ((ListenableFuture) it3.next()).cancel(true);
        }
        return objFinalResult;
    }

    private static int getPriority(Throwable th) {
        if (th == null) {
            return Integer.MIN_VALUE;
        }
        if (!(th instanceof ExecutionException)) {
            return C.RATE_UNSET_INT;
        }
        if (th.getCause() instanceof NoRemoteEspressoInstanceException) {
            return 0;
        }
        return th.getCause() instanceof NoActivityResumedException ? 1 : Integer.MAX_VALUE;
    }

    private static ExecutionResult pickResult(ExecutionResult executionResult, ExecutionResult executionResult2) {
        return executionResult2 == null ? executionResult : executionResult == null ? executionResult2 : executionResult.isSuccess() ? executionResult : (!executionResult2.isSuccess() && getPriority(executionResult.getFailure()) > getPriority(executionResult2.getFailure())) ? executionResult : executionResult2;
    }
}
