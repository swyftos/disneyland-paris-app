package com.urbanairship.job;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import com.urbanairship.UALog;
import com.urbanairship.job.JobRunner;
import com.urbanairship.job.RateLimiter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class JobDispatcher {
    static final long RESCHEDULE_RETRY_DELAY_MS = TimeUnit.HOURS.toMillis(1);
    private static JobDispatcher instance;
    private final Context context;
    private final JobRunner jobRunner;
    private final List pendingJobInfos;
    private final RateLimiter rateLimiter;
    private final Runnable retryPendingRunnable;
    private final Scheduler scheduler;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        try {
            dispatchPending();
        } catch (SchedulerException unused) {
            schedulePending();
        }
    }

    @NonNull
    public static JobDispatcher shared(@NonNull Context context) {
        if (instance == null) {
            synchronized (JobDispatcher.class) {
                try {
                    if (instance == null) {
                        instance = new JobDispatcher(context);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @VisibleForTesting
    public static void setInstance(@NonNull JobDispatcher jobDispatcher) {
        synchronized (JobDispatcher.class) {
            instance = jobDispatcher;
        }
    }

    private JobDispatcher(Context context) {
        this(context, new WorkManagerScheduler());
    }

    @VisibleForTesting
    public JobDispatcher(@NonNull Context context, @NonNull Scheduler scheduler) {
        this(context, scheduler, new JobRunner.DefaultRunner(), new RateLimiter());
    }

    @VisibleForTesting
    public JobDispatcher(@NonNull Context context, @NonNull Scheduler scheduler, @NonNull JobRunner jobRunner, @NonNull RateLimiter rateLimiter) {
        this.pendingJobInfos = new ArrayList();
        this.retryPendingRunnable = new Runnable() { // from class: com.urbanairship.job.JobDispatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.context = context.getApplicationContext();
        this.scheduler = scheduler;
        this.jobRunner = jobRunner;
        this.rateLimiter = rateLimiter;
    }

    public void setRateLimit(@NonNull String str, @IntRange(from = 1) int i, long j, @NonNull TimeUnit timeUnit) {
        this.rateLimiter.setLimit(str, i, j, timeUnit);
    }

    public void dispatch(@NonNull JobInfo jobInfo) {
        dispatch(jobInfo, getDelay(jobInfo));
    }

    private void dispatch(JobInfo jobInfo, long j) {
        try {
            dispatchPending();
            this.scheduler.schedule(this.context, jobInfo, j);
        } catch (SchedulerException e) {
            UALog.e(e, "Scheduler failed to schedule jobInfo", new Object[0]);
            synchronized (this.pendingJobInfos) {
                this.pendingJobInfos.add(new Pending(jobInfo, j));
                schedulePending();
            }
        }
    }

    private void schedulePending() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.retryPendingRunnable);
        handler.postDelayed(this.retryPendingRunnable, 1000L);
    }

    private void dispatchPending() {
        synchronized (this.pendingJobInfos) {
            try {
                Iterator it = new ArrayList(this.pendingJobInfos).iterator();
                while (it.hasNext()) {
                    Pending pending = (Pending) it.next();
                    this.scheduler.schedule(this.context, pending.jobInfo, pending.delayMs);
                    this.pendingJobInfos.remove(pending);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void onStartJob(@NonNull final JobInfo jobInfo, final long j, @NonNull final Consumer<JobResult> consumer) {
        UALog.v("Running job: %s, run attempt: %s", jobInfo, Long.valueOf(j));
        long rateLimitDelay = getRateLimitDelay(jobInfo);
        if (rateLimitDelay > 0) {
            consumer.accept(JobResult.FAILURE);
            dispatch(jobInfo, rateLimitDelay);
            return;
        }
        Iterator<String> it = jobInfo.getRateLimitIds().iterator();
        while (it.hasNext()) {
            this.rateLimiter.track(it.next());
        }
        this.jobRunner.run(jobInfo, new Consumer() { // from class: com.urbanairship.job.JobDispatcher$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$onStartJob$1(jobInfo, j, consumer, (JobResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$1(JobInfo jobInfo, long j, Consumer consumer, JobResult jobResult) {
        UALog.v("Job finished. Job info: %s, result: %s", jobInfo, jobResult);
        boolean z = jobResult == JobResult.RETRY;
        boolean z2 = j >= 5;
        boolean z3 = jobInfo.getConflictStrategy() == 1;
        if (z && z2 && !z3) {
            UALog.v("Job retry limit reached. Rescheduling for a later time. Job info: %s", jobInfo);
            dispatch(jobInfo, RESCHEDULE_RETRY_DELAY_MS);
            consumer.accept(JobResult.FAILURE);
            return;
        }
        consumer.accept(jobResult);
    }

    private long getDelay(JobInfo jobInfo) {
        return Math.max(jobInfo.getMinDelayMs(), getRateLimitDelay(jobInfo));
    }

    private long getRateLimitDelay(JobInfo jobInfo) {
        Iterator<String> it = jobInfo.getRateLimitIds().iterator();
        long jMax = 0;
        while (it.hasNext()) {
            RateLimiter.Status status = this.rateLimiter.status(it.next());
            if (status != null && status.getLimitStatus() == RateLimiter.LimitStatus.OVER) {
                jMax = Math.max(jMax, status.getNextAvailable(TimeUnit.MILLISECONDS));
            }
        }
        return jMax;
    }

    private static class Pending {
        private final long delayMs;
        private final JobInfo jobInfo;

        Pending(JobInfo jobInfo, long j) {
            this.jobInfo = jobInfo;
            this.delayMs = j;
        }
    }
}
