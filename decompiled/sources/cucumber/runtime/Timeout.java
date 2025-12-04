package cucumber.runtime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class Timeout {

    public interface Callback<T> {
        T call() throws Throwable;
    }

    public static <T> T timeout(Callback<T> callback, long j) throws Throwable {
        if (j == 0) {
            return callback.call();
        }
        final Thread threadCurrentThread = Thread.currentThread();
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new Runnable() { // from class: cucumber.runtime.Timeout.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (obj) {
                    try {
                        if (!atomicBoolean.get()) {
                            threadCurrentThread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, j, TimeUnit.MILLISECONDS);
        try {
            try {
                T tCall = callback.call();
                if (Thread.interrupted()) {
                    throw new TimeoutException("Timed out after " + j + "ms.");
                }
                synchronized (obj) {
                    atomicBoolean.set(true);
                    scheduledFutureSchedule.cancel(true);
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
                    Thread.interrupted();
                }
                return tCall;
            } catch (InterruptedException unused) {
                throw new TimeoutException("Timed out after " + j + "ms.");
            }
        } catch (Throwable th) {
            synchronized (obj) {
                atomicBoolean.set(true);
                scheduledFutureSchedule.cancel(true);
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
                Thread.interrupted();
                throw th;
            }
        }
    }
}
