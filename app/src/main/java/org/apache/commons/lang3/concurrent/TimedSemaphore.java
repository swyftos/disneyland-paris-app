package org.apache.commons.lang3.concurrent;

import androidx.camera.video.AudioStats;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public static class Builder implements Supplier<TimedSemaphore> {
        private int limit;
        private long period;
        private ScheduledExecutorService service;
        private TimeUnit timeUnit;

        @Override // java.util.function.Supplier
        public TimedSemaphore get() {
            return new TimedSemaphore(this);
        }

        public Builder setLimit(int i) {
            this.limit = i;
            return this;
        }

        public Builder setPeriod(long j) {
            this.period = j;
            return this;
        }

        public Builder setService(ScheduledExecutorService scheduledExecutorService) {
            this.service = scheduledExecutorService;
            return this;
        }

        public Builder setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private TimedSemaphore(Builder builder) {
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, builder.period, "Time period must be greater than 0.");
        this.period = builder.period;
        this.unit = builder.timeUnit;
        if (builder.service != null) {
            this.executorService = builder.service;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(builder.limit);
    }

    @Deprecated
    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    @Deprecated
    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        this(builder().setService(scheduledExecutorService).setPeriod(j).setTimeUnit(timeUnit).setLimit(i));
    }

    public synchronized void acquire() throws InterruptedException {
        boolean zAcquirePermit;
        prepareAcquire();
        do {
            zAcquirePermit = acquirePermit();
            if (!zAcquirePermit) {
                wait();
            }
        } while (!zAcquirePermit);
    }

    private boolean acquirePermit() {
        if (getLimit() > 0 && this.acquireCount >= getLimit()) {
            return false;
        }
        this.acquireCount++;
        return true;
    }

    synchronized void endOfPeriod() {
        int i = this.acquireCount;
        this.lastCallsPerPeriod = i;
        this.totalAcquireCount += (long) i;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        long j;
        j = this.periodCount;
        return j == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : this.totalAcquireCount / j;
    }

    protected ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    private void prepareAcquire() {
        if (isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.task == null) {
            this.task = startTimer();
        }
    }

    public final synchronized void setLimit(int i) {
        this.limit = i;
    }

    public synchronized void shutdown() {
        try {
            if (!this.shutdown) {
                if (this.ownExecutor) {
                    getExecutorService().shutdownNow();
                }
                ScheduledFuture scheduledFuture = this.task;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.shutdown = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    public synchronized boolean tryAcquire() {
        prepareAcquire();
        return acquirePermit();
    }
}
