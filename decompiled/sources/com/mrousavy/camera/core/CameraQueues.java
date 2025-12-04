package com.mrousavy.camera.core;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues;", "", "<init>", "()V", "Companion", "CameraQueue", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraQueues {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final ExecutorService analyzerExecutor;
    private static final ExecutorService cameraExecutor;
    private static final CameraQueue videoQueue;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues$Companion;", "", "<init>", "()V", "analyzerExecutor", "Ljava/util/concurrent/ExecutorService;", "getAnalyzerExecutor", "()Ljava/util/concurrent/ExecutorService;", "cameraExecutor", "getCameraExecutor", "videoQueue", "Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "getVideoQueue", "()Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ExecutorService getAnalyzerExecutor() {
            return CameraQueues.analyzerExecutor;
        }

        @NotNull
        public final ExecutorService getCameraExecutor() {
            return CameraQueues.cameraExecutor;
        }

        @NotNull
        public final CameraQueue getVideoQueue() {
            return CameraQueues.videoQueue;
        }
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        analyzerExecutor = executorServiceNewCachedThreadPool;
        ExecutorService executorServiceNewCachedThreadPool2 = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool2, "newCachedThreadPool(...)");
        cameraExecutor = executorServiceNewCachedThreadPool2;
        videoQueue = new CameraQueue("mrousavy/VisionCamera.video");
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/mrousavy/camera/core/CameraQueues$CameraQueue;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "thread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "finalize", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CameraQueue {
        private final CoroutineDispatcher coroutineDispatcher;
        private final Executor executor;
        private final Handler handler;
        private final HandlerThread thread;

        public CameraQueue(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            HandlerThread handlerThread = new HandlerThread(name);
            this.thread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.handler = handler;
            HandlerDispatcher handlerDispatcherFrom = HandlerDispatcherKt.from(handler, name);
            this.coroutineDispatcher = handlerDispatcherFrom;
            this.executor = ExecutorsKt.asExecutor(handlerDispatcherFrom);
        }

        @NotNull
        public final Handler getHandler() {
            return this.handler;
        }

        @NotNull
        public final Executor getExecutor() {
            return this.executor;
        }

        protected final void finalize() {
            this.thread.quitSafely();
        }
    }
}
