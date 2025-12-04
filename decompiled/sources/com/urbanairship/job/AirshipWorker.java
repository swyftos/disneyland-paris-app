package com.urbanairship.job;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.common.util.concurrent.ListenableFuture;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import java.util.UUID;

/* loaded from: classes5.dex */
public class AirshipWorker extends ListenableWorker {
    public AirshipWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.urbanairship.job.AirshipWorker$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.lambda$startWork$1(completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$startWork$1(final CallbackToFutureAdapter.Completer completer) {
        JobInfo jobInfo = parseJobInfo();
        if (jobInfo == null) {
            return Boolean.valueOf(completer.set(ListenableWorker.Result.failure()));
        }
        UUID id = getId();
        int runAttemptCount = getRunAttemptCount();
        UALog.v("Running job: %s, work Id: %s run attempt: %s", jobInfo, id, Integer.valueOf(runAttemptCount));
        JobDispatcher.shared(getApplicationContext()).onStartJob(jobInfo, runAttemptCount, new Consumer() { // from class: com.urbanairship.job.AirshipWorker$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                AirshipWorker.lambda$startWork$0(completer, (JobResult) obj);
            }
        });
        return jobInfo;
    }

    /* renamed from: com.urbanairship.job.AirshipWorker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$job$JobResult;

        static {
            int[] iArr = new int[JobResult.values().length];
            $SwitchMap$com$urbanairship$job$JobResult = iArr;
            try {
                iArr[JobResult.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$job$JobResult[JobResult.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$job$JobResult[JobResult.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startWork$0(CallbackToFutureAdapter.Completer completer, JobResult jobResult) {
        int i = AnonymousClass1.$SwitchMap$com$urbanairship$job$JobResult[jobResult.ordinal()];
        if (i == 1) {
            completer.set(ListenableWorker.Result.retry());
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
            }
            completer.set(ListenableWorker.Result.success());
        }
        completer.set(ListenableWorker.Result.failure());
        completer.set(ListenableWorker.Result.success());
    }

    private JobInfo parseJobInfo() {
        try {
            return WorkUtils.convertToJobInfo(getInputData());
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse jobInfo.", new Object[0]);
            return null;
        }
    }
}
