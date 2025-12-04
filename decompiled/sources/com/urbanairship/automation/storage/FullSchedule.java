package com.urbanairship.automation.storage;

import androidx.annotation.RestrictTo;
import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class FullSchedule {

    @Embedded
    public ScheduleEntity schedule;

    @Relation(entityColumn = "parentScheduleId", parentColumn = "scheduleId")
    public List<TriggerEntity> triggers;

    public FullSchedule(ScheduleEntity scheduleEntity, List<TriggerEntity> list) {
        this.schedule = scheduleEntity;
        this.triggers = list;
    }

    @Ignore
    public String toString() {
        return "FullSchedule{schedule=" + this.schedule + ", triggers=" + this.triggers + '}';
    }
}
