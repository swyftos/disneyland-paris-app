package com.urbanairship.job;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.job.JobRunner;
import com.urbanairship.util.UAStringUtil;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
interface JobRunner {
    void run(JobInfo jobInfo, Consumer consumer);

    public static class DefaultRunner implements JobRunner {
        private final Executor executor = AirshipExecutors.newSerialExecutor();

        @Override // com.urbanairship.job.JobRunner
        public void run(@NonNull final JobInfo jobInfo, @NonNull final Consumer<JobResult> consumer) {
            this.executor.execute(new Runnable() { // from class: com.urbanairship.job.JobRunner$DefaultRunner$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$1(jobInfo, consumer);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(final JobInfo jobInfo, final Consumer consumer) {
            final UAirship uAirshipWaitForTakeOff = UAirship.waitForTakeOff(5000L);
            if (uAirshipWaitForTakeOff == null) {
                UALog.e("UAirship not ready. Rescheduling job: %s", jobInfo);
                consumer.accept(JobResult.RETRY);
                return;
            }
            final AirshipComponent airshipComponentFindAirshipComponent = findAirshipComponent(uAirshipWaitForTakeOff, jobInfo.getAirshipComponentName());
            if (airshipComponentFindAirshipComponent == null) {
                UALog.e("Unavailable to find airship components for jobInfo: %s", jobInfo);
                consumer.accept(JobResult.SUCCESS);
            } else {
                airshipComponentFindAirshipComponent.getJobExecutor(jobInfo).execute(new Runnable() { // from class: com.urbanairship.job.JobRunner$DefaultRunner$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        JobRunner.DefaultRunner.lambda$run$0(airshipComponentFindAirshipComponent, uAirshipWaitForTakeOff, jobInfo, consumer);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(AirshipComponent airshipComponent, UAirship uAirship, JobInfo jobInfo, Consumer consumer) {
            JobResult jobResultOnPerformJob = airshipComponent.onPerformJob(uAirship, jobInfo);
            UALog.v("Finished: %s with result: %s", jobInfo, jobResultOnPerformJob);
            consumer.accept(jobResultOnPerformJob);
        }

        private AirshipComponent findAirshipComponent(UAirship uAirship, String str) {
            if (UAStringUtil.isEmpty(str)) {
                return null;
            }
            for (AirshipComponent airshipComponent : uAirship.getComponents()) {
                if (airshipComponent.getClass().getName().equals(str)) {
                    return airshipComponent;
                }
            }
            return null;
        }
    }
}
