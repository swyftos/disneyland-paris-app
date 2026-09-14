package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2908v7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ThreadPoolExecutor f3195a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f3196b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v7$a */
    public static final class a {
        @NotNull
        /* JADX INFO: renamed from: a */
        public final ThreadPoolExecutor m1221a(int i, @NotNull TimeUnit unit, @NotNull ArrayBlockingQueue workQueue, @NotNull ThreadPoolExecutor.AbortPolicy rejectedExecutionHandler, @NotNull final String threadName) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(workQueue, "workQueue");
            Intrinsics.checkNotNullParameter(rejectedExecutionHandler, "rejectedExecutionHandler");
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            return new ThreadPoolExecutor(i, 1, 30L, unit, workQueue, new ThreadFactory() { // from class: com.contentsquare.android.sdk.v7$a$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return C2908v7.a.m1220a(threadName, runnable);
                }
            }, rejectedExecutionHandler);
        }

        /* JADX INFO: renamed from: a */
        public static final Thread m1220a(String threadName, Runnable task) {
            Intrinsics.checkNotNullParameter(threadName, "$threadName");
            Intrinsics.checkNotNullParameter(task, "task");
            Thread thread = new Thread(task);
            thread.setPriority(10);
            thread.setName(threadName);
            return thread;
        }
    }

    public C2908v7(int i) {
        a threadPoolExecutorProvider = new a();
        Intrinsics.checkNotNullParameter(threadPoolExecutorProvider, "threadPoolExecutorProvider");
        this.f3196b = new Logger("ThreadPool");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(60, true);
        int i2 = i != 0 ? 1 : 0;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor.AbortPolicy abortPolicy = (i == 0 || i != 1) ? new ThreadPoolExecutor.AbortPolicy() : new ThreadPoolExecutor.AbortPolicy();
        this.f3195a = threadPoolExecutorProvider.m1221a(i2, timeUnit, arrayBlockingQueue, abortPolicy, i != 0 ? i != 1 ? "cs" : "cs-cpu" : "cs-io");
    }
}
