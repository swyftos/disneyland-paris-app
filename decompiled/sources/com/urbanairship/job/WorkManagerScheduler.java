package com.urbanairship.job;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class WorkManagerScheduler implements Scheduler {
    WorkManagerScheduler() {
    }

    @Override // com.urbanairship.job.Scheduler
    public void schedule(Context context, JobInfo jobInfo, long j) throws SchedulerException {
        try {
            OneTimeWorkRequest oneTimeWorkRequestCreateWorkRequest = createWorkRequest(jobInfo, j);
            WorkManager.getInstance(context).enqueueUniqueWork(jobInfo.getAirshipComponentName() + ":" + jobInfo.getAction(), convertConflict(jobInfo.getConflictStrategy()), oneTimeWorkRequestCreateWorkRequest);
        } catch (Exception e) {
            throw new SchedulerException("Failed to schedule job", e);
        }
    }

    private static OneTimeWorkRequest createWorkRequest(JobInfo jobInfo, long j) {
        OneTimeWorkRequest.Builder inputData = new OneTimeWorkRequest.Builder(AirshipWorker.class).addTag("airship").setInputData(WorkUtils.convertToData(jobInfo));
        BackoffPolicy backoffPolicy = BackoffPolicy.EXPONENTIAL;
        long initialBackOffMs = jobInfo.getInitialBackOffMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OneTimeWorkRequest.Builder constraints = inputData.setBackoffCriteria(backoffPolicy, initialBackOffMs, timeUnit).setConstraints(createConstraints(jobInfo));
        if (j > 0) {
            constraints.setInitialDelay(j, timeUnit);
        }
        return constraints.build();
    }

    private static ExistingWorkPolicy convertConflict(int i) {
        if (i == 0) {
            return ExistingWorkPolicy.REPLACE;
        }
        if (i == 1) {
            return ExistingWorkPolicy.APPEND_OR_REPLACE;
        }
        return ExistingWorkPolicy.KEEP;
    }

    private static Constraints createConstraints(JobInfo jobInfo) {
        return new Constraints.Builder().setRequiredNetworkType(jobInfo.isNetworkAccessRequired() ? NetworkType.CONNECTED : NetworkType.NOT_REQUIRED).build();
    }
}
