package com.contentsquare.android.core.utils;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/contentsquare/android/core/utils/ThreadExecutor;", "", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "(Ljava/util/concurrent/BlockingQueue;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor$annotations", "()V", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "getWorkQueue", "()Ljava/util/concurrent/BlockingQueue;", "submit", "Ljava/util/concurrent/Future;", ExifInterface.GPS_DIRECTION_TRUE, "task", "Ljava/util/concurrent/Callable;", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThreadExecutor {
    private static final int BLOCKING_QUEUE_SIZE = 10;
    private static final int CORE_POOL_SIZE = 1;
    private static final long KEEP_ALIVE = 30;

    @NotNull
    private ThreadPoolExecutor executor;

    @NotNull
    private final BlockingQueue<Runnable> workQueue;
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    @NotNull
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    @NotNull
    private static final Logger LOGGER = new Logger("ThreadExecutor");

    public ThreadExecutor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @VisibleForTesting
    public static /* synthetic */ void getExecutor$annotations() {
    }

    @NotNull
    public final ThreadPoolExecutor getExecutor() {
        return this.executor;
    }

    @VisibleForTesting
    @NotNull
    public final BlockingQueue<Runnable> getWorkQueue() {
        return this.workQueue;
    }

    public final void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "<set-?>");
        this.executor = threadPoolExecutor;
    }

    @NotNull
    public final <T> Future<T> submit(Callable<T> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Future<T> futureSubmit = this.executor.submit(task);
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "executor.submit(task)");
        return futureSubmit;
    }

    public ThreadExecutor(BlockingQueue<Runnable> workQueue) {
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        this.workQueue = workQueue;
        Logger logger = LOGGER;
        StringBuilder sb = new StringBuilder("Building a ThreadPoolExecutor maxSize ");
        int i = AVAILABLE_PROCESSORS;
        sb.append(i);
        logger.d(sb.toString());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, i, 30L, TIME_UNIT, workQueue);
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
    }

    public /* synthetic */ ThreadExecutor(BlockingQueue blockingQueue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayBlockingQueue(10) : blockingQueue);
    }
}
