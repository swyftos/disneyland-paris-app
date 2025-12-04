package com.mrousavy.camera.core.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"await", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/common/util/concurrent/ListenableFuture;", "executor", "Ljava/util/concurrent/Executor;", "(Lcom/google/common/util/concurrent/ListenableFuture;Ljava/util/concurrent/Executor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ListenableFuture_awaitKt {
    public static /* synthetic */ Object await$default(ListenableFuture listenableFuture, Executor executor, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            executor = null;
        }
        return await(listenableFuture, executor, continuation);
    }

    @Nullable
    public static final <V> Object await(@NotNull final ListenableFuture<V> listenableFuture, @Nullable Executor executor, @NotNull Continuation<? super V> continuation) throws Throwable {
        if (listenableFuture.isCancelled()) {
            throw new CancellationException("ListenableFuture<V> has been canceled!");
        }
        if (listenableFuture.isDone()) {
            return listenableFuture.get();
        }
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Runnable runnable = new Runnable() { // from class: com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt$await$2$1
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException {
                if (listenableFuture.isCancelled() || !JobKt.isActive(safeContinuation.getContext())) {
                    throw new CancellationException("ListenableFuture<V> has been canceled!");
                }
                try {
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2968constructorimpl(listenableFuture.get()));
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        Continuation continuation3 = safeContinuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(cause)));
                        return;
                    }
                    throw e;
                }
            }
        };
        if (executor == null) {
            executor = ExecutorsKt.asExecutor(Dispatchers.getMain());
        }
        listenableFuture.addListener(runnable, executor);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
