package com.urbanairship.analytics.data;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.urbanairship.UALog;
import com.urbanairship.analytics.data.EventEntity;
import com.urbanairship.util.UAStringUtil;
import java.util.Iterator;
import java.util.List;

@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public abstract class EventDao {
    @Query("SELECT COUNT(*) FROM events")
    public abstract int count();

    @Query("SELECT SUM(eventSize) FROM events")
    public abstract int databaseSize();

    abstract void delete(String str);

    @Delete
    public abstract void delete(EventEntity... eventEntityArr);

    @Query("DELETE FROM events")
    public abstract void deleteAll();

    abstract int deleteSession(String str);

    @Query("SELECT * FROM events ORDER BY id ASC")
    @Transaction
    public abstract List<EventEntity> get();

    @Query("SELECT id, eventId, data FROM events ORDER BY id ASC LIMIT :limit")
    @Transaction
    public abstract List<EventEntity.EventIdAndData> getBatch(int i);

    @Insert(onConflict = 1)
    public abstract void insert(EventEntity eventEntity);

    abstract String oldestSessionId();

    @Transaction
    public void deleteBatch(List<EventEntity.EventIdAndData> list) {
        Iterator<EventEntity.EventIdAndData> it = list.iterator();
        while (it.hasNext()) {
            delete(it.next().eventId);
        }
    }

    @Transaction
    public void trimDatabase(int i) {
        while (databaseSize() > i) {
            String strOldestSessionId = oldestSessionId();
            if (UAStringUtil.isEmpty(strOldestSessionId)) {
                return;
            }
            UALog.d("Event database size exceeded. Deleting oldest session: %s", strOldestSessionId);
            int iDeleteSession = deleteSession(strOldestSessionId);
            UALog.d("Deleted %d rows with session ID %s", Integer.valueOf(iDeleteSession), strOldestSessionId);
            if (iDeleteSession == 0) {
                return;
            }
        }
    }
}
