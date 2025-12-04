package com.contentsquare.rn.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class ExponentialBackoff {
    private double delay;
    private final FailureCallback failureCallback;
    private final double initialDelay;
    private final int maxRetries;
    private int retries = 0;
    private final Task task;

    public interface FailureCallback {
        void onFailure();
    }

    public interface Task {
        void run(TaskCompletionCallback taskCompletionCallback);
    }

    public interface TaskCompletionCallback {
        void onComplete(boolean z);
    }

    public ExponentialBackoff(int i, double d, Task task, FailureCallback failureCallback) {
        this.maxRetries = i;
        this.initialDelay = d;
        this.task = task;
        this.failureCallback = failureCallback;
        this.delay = d;
    }

    public void start() {
        attempt();
    }

    private void attempt() {
        this.task.run(new TaskCompletionCallback() { // from class: com.contentsquare.rn.utils.ExponentialBackoff$$ExternalSyntheticLambda0
            @Override // com.contentsquare.rn.utils.ExponentialBackoff.TaskCompletionCallback
            public final void onComplete(boolean z) {
                this.f$0.lambda$attempt$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attempt$1(boolean z) {
        if (z) {
            System.out.println("Exponential backoff task succeeded.");
            return;
        }
        int i = this.retries + 1;
        this.retries = i;
        if (i > this.maxRetries) {
            System.out.println("Exponential backoff task failed after " + this.maxRetries + " retries.");
            this.failureCallback.onFailure();
            return;
        }
        System.out.println("Exponential backoff task failed, retrying in " + this.delay + " seconds...");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.contentsquare.rn.utils.ExponentialBackoff$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$attempt$0();
            }
        }, (long) (this.delay * 1000.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attempt$0() {
        this.delay *= 2.0d;
        attempt();
    }
}
