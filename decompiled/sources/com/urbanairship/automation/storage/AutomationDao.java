package com.urbanairship.automation.storage;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import java.util.Collection;
import java.util.List;

@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class AutomationDao {
    @Delete
    public abstract void delete(@NonNull ScheduleEntity scheduleEntity);

    @NonNull
    @Query("SELECT * FROM schedules")
    @Transaction
    public abstract List<FullSchedule> getSchedules();

    @Insert(onConflict = 1)
    @Transaction
    public abstract void insert(@NonNull ScheduleEntity scheduleEntity, @NonNull List<TriggerEntity> list);

    @Transaction
    public void insert(@NonNull Collection<FullSchedule> collection) {
        for (FullSchedule fullSchedule : collection) {
            if (fullSchedule != null) {
                insert(fullSchedule);
            }
        }
    }

    public void insert(@NonNull FullSchedule fullSchedule) {
        insert(fullSchedule.schedule, fullSchedule.triggers);
    }

    public void delete(@NonNull FullSchedule fullSchedule) {
        delete(fullSchedule.schedule);
    }

    public void deleteSchedules(@NonNull Collection<FullSchedule> collection) {
        for (FullSchedule fullSchedule : collection) {
            if (fullSchedule != null) {
                delete(fullSchedule);
            }
        }
    }
}
