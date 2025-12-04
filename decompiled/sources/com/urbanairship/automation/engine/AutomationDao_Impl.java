package com.urbanairship.automation.engine;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import ch.qos.logback.classic.spi.CallerData;
import com.dlp.BluetoothManager;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public final class AutomationDao_Impl implements AutomationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfScheduleEntity;
    private final JsonTypeConverters __jsonTypeConverters = new JsonTypeConverters();
    private final SharedSQLiteStatement __preparedStmtOfDeleteSchedules;
    private final SharedSQLiteStatement __preparedStmtOfDeleteTrigger;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfScheduleEntity;
    private final EntityUpsertionAdapter __upsertionAdapterOfTriggerEntity;

    public AutomationDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfScheduleEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `schedules` (`scheduleId`,`group`,`executionCount`,`preparedScheduleInfo`,`schedule`,`scheduleState`,`scheduleStateChangeDate`,`triggerInfo`,`triggerSessionId`,`associatedData`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ScheduleEntity scheduleEntity) {
                supportSQLiteStatement.bindString(1, scheduleEntity.getScheduleId());
                if (scheduleEntity.getGroup() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, scheduleEntity.getGroup());
                }
                supportSQLiteStatement.bindLong(3, scheduleEntity.getExecutionCount());
                String strJsonValueToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getPreparedScheduleInfo());
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonValueToString);
                }
                String strJsonValueToString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getSchedule());
                if (strJsonValueToString2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, strJsonValueToString2);
                }
                supportSQLiteStatement.bindString(6, scheduleEntity.getScheduleState());
                supportSQLiteStatement.bindLong(7, scheduleEntity.getScheduleStateChangeDate());
                String strJsonValueToString3 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getTriggerInfo());
                if (strJsonValueToString3 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, strJsonValueToString3);
                }
                if (scheduleEntity.getTriggerSessionId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, scheduleEntity.getTriggerSessionId());
                }
                String strJsonValueToString4 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getAssociatedData());
                if (strJsonValueToString4 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, strJsonValueToString4);
                }
            }
        };
        this.__updateAdapterOfScheduleEntity = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `schedules` SET `scheduleId` = ?,`group` = ?,`executionCount` = ?,`preparedScheduleInfo` = ?,`schedule` = ?,`scheduleState` = ?,`scheduleStateChangeDate` = ?,`triggerInfo` = ?,`triggerSessionId` = ?,`associatedData` = ? WHERE `scheduleId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ScheduleEntity scheduleEntity) {
                supportSQLiteStatement.bindString(1, scheduleEntity.getScheduleId());
                if (scheduleEntity.getGroup() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, scheduleEntity.getGroup());
                }
                supportSQLiteStatement.bindLong(3, scheduleEntity.getExecutionCount());
                String strJsonValueToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getPreparedScheduleInfo());
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonValueToString);
                }
                String strJsonValueToString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getSchedule());
                if (strJsonValueToString2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, strJsonValueToString2);
                }
                supportSQLiteStatement.bindString(6, scheduleEntity.getScheduleState());
                supportSQLiteStatement.bindLong(7, scheduleEntity.getScheduleStateChangeDate());
                String strJsonValueToString3 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getTriggerInfo());
                if (strJsonValueToString3 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, strJsonValueToString3);
                }
                if (scheduleEntity.getTriggerSessionId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, scheduleEntity.getTriggerSessionId());
                }
                String strJsonValueToString4 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(scheduleEntity.getAssociatedData());
                if (strJsonValueToString4 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, strJsonValueToString4);
                }
                supportSQLiteStatement.bindString(11, scheduleEntity.getScheduleId());
            }
        };
        this.__preparedStmtOfDeleteSchedules = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM schedules WHERE `group` = ?";
            }
        };
        this.__preparedStmtOfDeleteTrigger = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM automation_trigger_data WHERE scheduleId = ? AND triggerId = ?";
            }
        };
        this.__upsertionAdapterOfTriggerEntity = new EntityUpsertionAdapter(new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT INTO `automation_trigger_data` (`id`,`triggerId`,`scheduleId`,`state`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TriggerEntity triggerEntity) {
                supportSQLiteStatement.bindLong(1, triggerEntity.getId());
                supportSQLiteStatement.bindString(2, triggerEntity.getTriggerId());
                supportSQLiteStatement.bindString(3, triggerEntity.getScheduleId());
                String strJsonValueToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(triggerEntity.getState());
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonValueToString);
                }
            }
        }, new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.6
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE `automation_trigger_data` SET `id` = ?,`triggerId` = ?,`scheduleId` = ?,`state` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TriggerEntity triggerEntity) {
                supportSQLiteStatement.bindLong(1, triggerEntity.getId());
                supportSQLiteStatement.bindString(2, triggerEntity.getTriggerId());
                supportSQLiteStatement.bindString(3, triggerEntity.getScheduleId());
                String strJsonValueToString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueToString(triggerEntity.getState());
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, strJsonValueToString);
                }
                supportSQLiteStatement.bindLong(5, triggerEntity.getId());
            }
        });
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object upsertSchedulesInternal(final List<ScheduleEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() {
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    AutomationDao_Impl.this.__insertionAdapterOfScheduleEntity.insert((Iterable) list);
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object updateScheduleInternal(final ScheduleEntity scheduleEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() {
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    AutomationDao_Impl.this.__updateAdapterOfScheduleEntity.handle(scheduleEntity);
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$upsertSchedules$0(List list, Function2 function2, Continuation continuation) {
        return super.upsertSchedules(list, function2, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object upsertSchedules(final List<String> list, final Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, Continuation<? super List<AutomationScheduleData>> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$upsertSchedules$0(list, function2, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getSchedules$1(List list, Continuation continuation) {
        return super.getSchedules((List<String>) list, (Continuation<? super List<ScheduleEntity>>) continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getSchedules(final List<String> list, Continuation<? super List<ScheduleEntity>> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$getSchedules$1(list, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateSchedule$2(String str, Function1 function1, Continuation continuation) {
        return super.updateSchedule(str, function1, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object updateSchedule(final String str, final Function1<? super AutomationScheduleData, AutomationScheduleData> function1, Continuation<? super AutomationScheduleData> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updateSchedule$2(str, function1, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteSchedules$3(List list, Continuation continuation) {
        return super.deleteSchedules((List<String>) list, (Continuation<? super Unit>) continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteSchedules(final List<String> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteSchedules$3(list, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$upsertTriggers$4(List list, Continuation continuation) {
        return super.upsertTriggers(list, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object upsertTriggers(final List<TriggerEntity> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$upsertTriggers$4(list, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteTriggers$5(List list, Continuation continuation) {
        return super.deleteTriggers(list, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTriggers(final List<String> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteTriggers$5(list, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteTriggers$6(String str, Set set, Continuation continuation) {
        return super.deleteTriggers(str, set, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTriggers(final String str, final Set<String> set, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteTriggers$6(str, set, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteTriggersExcluding$7(List list, Continuation continuation) {
        return super.deleteTriggersExcluding(list, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTriggersExcluding(final List<String> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteTriggersExcluding$7(list, (Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteSchedules(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.9
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = AutomationDao_Impl.this.__preparedStmtOfDeleteSchedules.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                try {
                    AutomationDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        AutomationDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        AutomationDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    AutomationDao_Impl.this.__preparedStmtOfDeleteSchedules.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTrigger(final String str, final String str2, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = AutomationDao_Impl.this.__preparedStmtOfDeleteTrigger.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                supportSQLiteStatementAcquire.bindString(2, str2);
                try {
                    AutomationDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        AutomationDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        AutomationDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    AutomationDao_Impl.this.__preparedStmtOfDeleteTrigger.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object upsertTriggersInternal(final List<TriggerEntity> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.11
            @Override // java.util.concurrent.Callable
            public Unit call() {
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    AutomationDao_Impl.this.__upsertionAdapterOfTriggerEntity.upsert((Iterable) list);
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getAllSchedules(Continuation<? super List<ScheduleEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM schedules", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.12
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "executionCount");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "preparedScheduleInfo");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleState");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleStateChangeDate");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerInfo");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerSessionId");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "associatedData");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        int i = cursorQuery.getInt(columnIndexOrThrow3);
                        JsonValue jsonValueJsonValueFromString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        JsonValue jsonValueJsonValueFromString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        if (jsonValueJsonValueFromString2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                        }
                        arrayList.add(new ScheduleEntity(string, string2, i, jsonValueJsonValueFromString, jsonValueJsonValueFromString2, cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10))));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getSchedules(String str, Continuation<? super List<ScheduleEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM schedules WHERE (`group` = ?)", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.13
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "executionCount");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "preparedScheduleInfo");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleState");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleStateChangeDate");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerInfo");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerSessionId");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "associatedData");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        int i = cursorQuery.getInt(columnIndexOrThrow3);
                        JsonValue jsonValueJsonValueFromString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        JsonValue jsonValueJsonValueFromString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        if (jsonValueJsonValueFromString2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                        }
                        arrayList.add(new ScheduleEntity(string, string2, i, jsonValueJsonValueFromString, jsonValueJsonValueFromString2, cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10))));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getSchedulesBatchInternal(List<String> list, Continuation<? super List<ScheduleEntity>> continuation) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM schedules WHERE (scheduleId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append("))");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        Iterator<String> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindString(i, it.next());
            i++;
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.14
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "executionCount");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "preparedScheduleInfo");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleState");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleStateChangeDate");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerInfo");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerSessionId");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "associatedData");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        int i2 = cursorQuery.getInt(columnIndexOrThrow3);
                        JsonValue jsonValueJsonValueFromString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        JsonValue jsonValueJsonValueFromString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        if (jsonValueJsonValueFromString2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                        }
                        arrayList.add(new ScheduleEntity(string, string2, i2, jsonValueJsonValueFromString, jsonValueJsonValueFromString2, cursorQuery.getString(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8)), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10))));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getSchedule(String str, Continuation<? super ScheduleEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM schedules WHERE scheduleId = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.15
            @Override // java.util.concurrent.Callable
            public ScheduleEntity call() {
                ScheduleEntity scheduleEntity = null;
                String string = null;
                Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "group");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "executionCount");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "preparedScheduleInfo");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleState");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleStateChangeDate");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerInfo");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerSessionId");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "associatedData");
                    if (cursorQuery.moveToFirst()) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        int i = cursorQuery.getInt(columnIndexOrThrow3);
                        JsonValue jsonValueJsonValueFromString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        JsonValue jsonValueJsonValueFromString2 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        if (jsonValueJsonValueFromString2 == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                        }
                        String string4 = cursorQuery.getString(columnIndexOrThrow6);
                        long j = cursorQuery.getLong(columnIndexOrThrow7);
                        JsonValue jsonValueJsonValueFromString3 = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        String string5 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        if (!cursorQuery.isNull(columnIndexOrThrow10)) {
                            string = cursorQuery.getString(columnIndexOrThrow10);
                        }
                        scheduleEntity = new ScheduleEntity(string2, string3, i, jsonValueJsonValueFromString, jsonValueJsonValueFromString2, string4, j, jsonValueJsonValueFromString3, string5, AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(string));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return scheduleEntity;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getTriggersScheduleIds(Continuation<? super List<String>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT scheduleId FROM automation_trigger_data", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.16
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object getTrigger(String str, String str2, Continuation<? super TriggerEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM automation_trigger_data WHERE scheduleId = ? AND triggerId = ? LIMIT 1", 2);
        roomSQLiteQueryAcquire.bindString(1, str);
        roomSQLiteQueryAcquire.bindString(2, str2);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.17
            @Override // java.util.concurrent.Callable
            public TriggerEntity call() {
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    TriggerEntity triggerEntity = null;
                    String string = null;
                    Cursor cursorQuery = DBUtil.query(AutomationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "triggerId");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scheduleId");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, BluetoothManager.BLE_STATUS_PARAM);
                        if (cursorQuery.moveToFirst()) {
                            int i = cursorQuery.getInt(columnIndexOrThrow);
                            String string2 = cursorQuery.getString(columnIndexOrThrow2);
                            String string3 = cursorQuery.getString(columnIndexOrThrow3);
                            if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                                string = cursorQuery.getString(columnIndexOrThrow4);
                            }
                            JsonValue jsonValueJsonValueFromString = AutomationDao_Impl.this.__jsonTypeConverters.jsonValueFromString(string);
                            if (jsonValueJsonValueFromString == null) {
                                throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                            }
                            triggerEntity = new TriggerEntity(i, string2, string3, jsonValueJsonValueFromString);
                        }
                        AutomationDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return triggerEntity;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteSchedulesBatchInternal(final List<String> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.18
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM schedules WHERE (scheduleId IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
                sbNewStringBuilder.append("))");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = AutomationDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = list.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTriggersInternal(final List<String> list, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.19
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM automation_trigger_data WHERE scheduleId IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = AutomationDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = list.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.engine.AutomationDao
    public Object deleteTriggersInternal(final String str, final Set<String> set, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.engine.AutomationDao_Impl.20
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM automation_trigger_data WHERE scheduleId = ");
                sbNewStringBuilder.append(CallerData.NA);
                sbNewStringBuilder.append(" AND triggerId IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, set.size());
                sbNewStringBuilder.append(") ");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = AutomationDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                supportSQLiteStatementCompileStatement.bindString(1, str);
                Iterator it = set.iterator();
                int i = 2;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                AutomationDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    AutomationDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AutomationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
