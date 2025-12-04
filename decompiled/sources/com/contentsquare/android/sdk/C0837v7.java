package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C0837v7;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.v7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0837v7 {

    @NotNull
    public final ThreadPoolExecutor a;

    @NotNull
    public final Logger b;

    /* renamed from: com.contentsquare.android.sdk.v7$a */
    public static final class a {
        @NotNull
        public final ThreadPoolExecutor a(int i, @NotNull TimeUnit unit, @NotNull ArrayBlockingQueue workQueue, @NotNull ThreadPoolExecutor.AbortPolicy rejectedExecutionHandler, @NotNull final String threadName) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(workQueue, "workQueue");
            Intrinsics.checkNotNullParameter(rejectedExecutionHandler, "rejectedExecutionHandler");
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            return new ThreadPoolExecutor(i, 1, 30L, unit, workQueue, new ThreadFactory() { // from class: com.contentsquare.android.sdk.v7$a$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return C0837v7.a.a(threadName, runnable);
                }
            }, rejectedExecutionHandler);
        }

        public static final Thread a(String threadName, Runnable task) {
            Intrinsics.checkNotNullParameter(threadName, "$threadName");
            Intrinsics.checkNotNullParameter(task, "task");
            Thread thread = new Thread(task);
            thread.setPriority(10);
            thread.setName(threadName);
            return thread;
        }
    }

    public C0837v7(int i) {
        a threadPoolExecutorProvider = new a();
        Intrinsics.checkNotNullParameter(threadPoolExecutorProvider, "threadPoolExecutorProvider");
        this.b = new Logger("ThreadPool");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(60, true);
        int i2 = i != 0 ? 1 : 0;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor.AbortPolicy abortPolicy = (i == 0 || i != 1) ? new ThreadPoolExecutor.AbortPolicy() : new ThreadPoolExecutor.AbortPolicy();
        this.a = threadPoolExecutorProvider.a(i2, timeUnit, arrayBlockingQueue, abortPolicy, i != 0 ? i != 1 ? "cs" : "cs-cpu" : "cs-io");
    }
}
