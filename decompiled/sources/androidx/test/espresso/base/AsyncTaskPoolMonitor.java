package androidx.test.espresso.base;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class AsyncTaskPoolMonitor {
    private final ThreadPoolExecutor pool;
    private final AtomicReference monitor = new AtomicReference(null);
    private final AtomicInteger activeBarrierChecks = new AtomicInteger(0);

    private static class BarrierRestarter {
        private final CyclicBarrier barrier;
        private final AtomicInteger barrierGeneration;

        BarrierRestarter(CyclicBarrier cyclicBarrier, AtomicInteger atomicInteger) {
            this.barrier = cyclicBarrier;
            this.barrierGeneration = atomicInteger;
        }

        synchronized void restart(int i) {
            if (this.barrierGeneration.compareAndSet(i, i + 1)) {
                this.barrier.reset();
            }
        }
    }

    private class IdleMonitor {
        private final CyclicBarrier barrier;
        private final AtomicInteger barrierGeneration;
        private final Runnable onIdle;
        private volatile boolean poisoned;

        private IdleMonitor(final Runnable runnable) {
            this.barrierGeneration = new AtomicInteger(0);
            this.onIdle = (Runnable) Preconditions.checkNotNull(runnable);
            this.barrier = new CyclicBarrier(AsyncTaskPoolMonitor.this.pool.getCorePoolSize(), new Runnable() { // from class: androidx.test.espresso.base.AsyncTaskPoolMonitor.IdleMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!AsyncTaskPoolMonitor.this.pool.getQueue().isEmpty()) {
                        IdleMonitor.this.monitorForIdle();
                    } else {
                        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(AsyncTaskPoolMonitor.this.monitor, IdleMonitor.this, null);
                        runnable.run();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void monitorForIdle() {
            if (this.poisoned) {
                return;
            }
            if (AsyncTaskPoolMonitor.this.isIdleNow()) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(AsyncTaskPoolMonitor.this.monitor, this, null);
                this.onIdle.run();
                return;
            }
            int corePoolSize = AsyncTaskPoolMonitor.this.pool.getCorePoolSize();
            final BarrierRestarter barrierRestarter = new BarrierRestarter(this.barrier, this.barrierGeneration);
            for (int i = 0; i < corePoolSize; i++) {
                AsyncTaskPoolMonitor.this.pool.execute(new Runnable() { // from class: androidx.test.espresso.base.AsyncTaskPoolMonitor.IdleMonitor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        while (!IdleMonitor.this.poisoned) {
                            AsyncTaskPoolMonitor.this.activeBarrierChecks.incrementAndGet();
                            int i2 = IdleMonitor.this.barrierGeneration.get();
                            try {
                                try {
                                    IdleMonitor.this.barrier.await();
                                    return;
                                } catch (InterruptedException unused) {
                                    barrierRestarter.restart(i2);
                                } catch (BrokenBarrierException unused2) {
                                    barrierRestarter.restart(i2);
                                }
                            } finally {
                                AsyncTaskPoolMonitor.this.activeBarrierChecks.decrementAndGet();
                            }
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void poison() {
            this.poisoned = true;
            this.barrier.reset();
        }
    }

    AsyncTaskPoolMonitor(ThreadPoolExecutor threadPoolExecutor) {
        this.pool = (ThreadPoolExecutor) Preconditions.checkNotNull(threadPoolExecutor);
    }

    IdleNotifier asIdleNotifier() {
        return new IdleNotifier<Runnable>() { // from class: androidx.test.espresso.base.AsyncTaskPoolMonitor.1
            @Override // androidx.test.espresso.base.IdleNotifier
            public void cancelCallback() {
                AsyncTaskPoolMonitor.this.cancelIdleMonitor();
            }

            @Override // androidx.test.espresso.base.IdleNotifier
            public boolean isIdleNow() {
                return AsyncTaskPoolMonitor.this.isIdleNow();
            }

            @Override // androidx.test.espresso.base.IdleNotifier
            public void registerNotificationCallback(Runnable runnable) {
                AsyncTaskPoolMonitor.this.notifyWhenIdle(runnable);
            }
        };
    }

    void cancelIdleMonitor() {
        IdleMonitor idleMonitor = (IdleMonitor) this.monitor.getAndSet(null);
        if (idleMonitor != null) {
            idleMonitor.poison();
        }
    }

    boolean isIdleNow() {
        if (!this.pool.getQueue().isEmpty()) {
            return false;
        }
        int activeCount = this.pool.getActiveCount();
        if (activeCount != 0 && this.monitor.get() == null) {
            activeCount -= this.activeBarrierChecks.get();
        }
        return activeCount == 0;
    }

    void notifyWhenIdle(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        IdleMonitor idleMonitor = new IdleMonitor(runnable);
        Preconditions.checkState(PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.monitor, null, idleMonitor), "cannot monitor for idle recursively!");
        idleMonitor.monitorForIdle();
    }
}
