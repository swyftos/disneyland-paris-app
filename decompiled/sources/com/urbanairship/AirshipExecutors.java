package com.urbanairship;

import androidx.annotation.RestrictTo;
import com.urbanairship.util.AirshipThreadFactory;
import com.urbanairship.util.SerialExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/urbanairship/AirshipExecutors;", "", "()V", "THREAD_POOL_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "newSerialExecutor", "Ljava/util/concurrent/Executor;", "threadPoolExecutor", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class AirshipExecutors {

    @NotNull
    public static final AirshipExecutors INSTANCE = new AirshipExecutors();
    private static final ExecutorService THREAD_POOL_EXECUTOR;

    private AirshipExecutors() {
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(AirshipThreadFactory.DEFAULT_THREAD_FACTORY);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        THREAD_POOL_EXECUTOR = executorServiceNewCachedThreadPool;
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService threadPoolExecutor() {
        return THREAD_POOL_EXECUTOR;
    }

    @JvmStatic
    @NotNull
    public static final Executor newSerialExecutor() {
        return new SerialExecutor(THREAD_POOL_EXECUTOR);
    }
}
