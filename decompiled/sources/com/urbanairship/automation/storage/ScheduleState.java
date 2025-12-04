package com.urbanairship.automation.storage;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface ScheduleState {
    public static final int EXECUTING = 2;
    public static final int FINISHED = 4;
    public static final int IDLE = 0;
    public static final int PAUSED = 3;
    public static final int PREPARING_SCHEDULE = 6;
    public static final int TIME_DELAYED = 5;
    public static final int WAITING_SCHEDULE_CONDITIONS = 1;
}
