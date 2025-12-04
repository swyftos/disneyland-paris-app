package androidx.test.espresso.base;

import android.os.Handler;
import android.os.Looper;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
final class ThreadPoolExecutorExtractor {
    private final Handler mainHandler;
    private static final Callable MODERN_ASYNC_TASK_EXTRACTOR = new Callable<Optional<ThreadPoolExecutor>>() { // from class: androidx.test.espresso.base.ThreadPoolExecutorExtractor.2
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: merged with bridge method [inline-methods] */
        public Optional<ThreadPoolExecutor> call2() {
            try {
                return Optional.of((ThreadPoolExecutor) Class.forName("androidx.loader.content.ModernAsyncTask").getField("THREAD_POOL_EXECUTOR").get(null));
            } catch (ClassNotFoundException unused) {
                return Optional.absent();
            } catch (NoSuchFieldException unused2) {
                return Optional.absent();
            }
        }
    };
    private static final Callable LOAD_ASYNC_TASK_CLASS = new Callable<Class<?>>() { // from class: androidx.test.espresso.base.ThreadPoolExecutorExtractor.3
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: merged with bridge method [inline-methods] */
        public Class<?> call2() {
            return Class.forName("android.os.AsyncTask");
        }
    };
    private static final Callable LEGACY_ASYNC_TASK_EXECUTOR = new Callable<Optional<ThreadPoolExecutor>>() { // from class: androidx.test.espresso.base.ThreadPoolExecutorExtractor.4
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: merged with bridge method [inline-methods] */
        public Optional<ThreadPoolExecutor> call2() throws NoSuchFieldException, SecurityException {
            try {
                Field declaredField = ((Class) ThreadPoolExecutorExtractor.LOAD_ASYNC_TASK_CLASS.call()).getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                return Optional.of((ThreadPoolExecutor) declaredField.get(null));
            } catch (ClassNotFoundException unused) {
                return Optional.absent();
            } catch (NoSuchFieldException unused2) {
                return Optional.absent();
            }
        }
    };
    private static final Callable POST_HONEYCOMB_ASYNC_TASK_EXECUTOR = new Callable<Optional<ThreadPoolExecutor>>() { // from class: androidx.test.espresso.base.ThreadPoolExecutorExtractor.5
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: merged with bridge method [inline-methods] */
        public Optional<ThreadPoolExecutor> call2() {
            try {
                return Optional.of((ThreadPoolExecutor) ((Class) ThreadPoolExecutorExtractor.LOAD_ASYNC_TASK_CLASS.call()).getField("THREAD_POOL_EXECUTOR").get(null));
            } catch (ClassNotFoundException unused) {
                return Optional.absent();
            } catch (NoSuchFieldException unused2) {
                return Optional.absent();
            }
        }
    };

    ThreadPoolExecutorExtractor(Looper looper) {
        this.mainHandler = new Handler(looper);
    }

    private FutureTask runOnMainThread(final FutureTask futureTask) throws InterruptedException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mainHandler.post(new Runnable(this) { // from class: androidx.test.espresso.base.ThreadPoolExecutorExtractor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        futureTask.run();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                if (!futureTask.isDone()) {
                    throw new RuntimeException("Interrupted while waiting for task to complete.", e);
                }
            }
        } else {
            futureTask.run();
        }
        return futureTask;
    }

    public Optional getCompatAsyncTaskThreadPool() {
        try {
            return (Optional) runOnMainThread(new FutureTask(MODERN_ASYNC_TASK_EXTRACTOR)).get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to get the compat async executor!", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    public ThreadPoolExecutor getAsyncTaskThreadPool() {
        try {
            return (ThreadPoolExecutor) ((Optional) runOnMainThread(new FutureTask(POST_HONEYCOMB_ASYNC_TASK_EXECUTOR)).get()).get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to get the async task executor!", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }
}
