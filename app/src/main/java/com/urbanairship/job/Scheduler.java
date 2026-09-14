package com.urbanairship.job;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Scheduler {
    void schedule(@NonNull Context context, @NonNull JobInfo jobInfo, long j) throws SchedulerException;
}
