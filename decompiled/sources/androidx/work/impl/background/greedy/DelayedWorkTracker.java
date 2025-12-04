package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    private final Clock mClock;
    final Scheduler mImmediateScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map mRunnables = new HashMap();

    public DelayedWorkTracker(@NonNull Scheduler scheduler, @NonNull RunnableScheduler runnableScheduler, @NonNull Clock clock) {
        this.mImmediateScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mClock = clock;
    }

    public void schedule(@NonNull final WorkSpec workSpec, long j) {
        Runnable runnable = (Runnable) this.mRunnables.remove(workSpec.id);
        if (runnable != null) {
            this.mRunnableScheduler.cancel(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.get().debug(DelayedWorkTracker.TAG, "Scheduling work " + workSpec.id);
                DelayedWorkTracker.this.mImmediateScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, runnable2);
        this.mRunnableScheduler.scheduleWithDelay(j - this.mClock.currentTimeMillis(), runnable2);
    }

    public void unschedule(@NonNull String str) {
        Runnable runnable = (Runnable) this.mRunnables.remove(str);
        if (runnable != null) {
            this.mRunnableScheduler.cancel(runnable);
        }
    }
}
