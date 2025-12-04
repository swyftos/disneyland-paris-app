package com.urbanairship.job;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface Scheduler {
    void schedule(@NonNull Context context, @NonNull JobInfo jobInfo, long j) throws SchedulerException;
}
