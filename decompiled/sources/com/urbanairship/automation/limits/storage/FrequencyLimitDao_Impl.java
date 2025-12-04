package com.urbanairship.automation.limits.storage;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class FrequencyLimitDao_Impl implements FrequencyLimitDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfConstraintEntity;
    private final EntityInsertionAdapter __insertionAdapterOfConstraintEntity;
    private final EntityInsertionAdapter __insertionAdapterOfOccurrenceEntity;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfConstraintEntity;

    public FrequencyLimitDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfConstraintEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `constraints` (`id`,`constraintId`,`count`,`range`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ConstraintEntity constraintEntity) {
                supportSQLiteStatement.bindLong(1, constraintEntity.getId());
                if (constraintEntity.getConstraintId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, constraintEntity.getConstraintId());
                }
                supportSQLiteStatement.bindLong(3, constraintEntity.getCount());
                supportSQLiteStatement.bindLong(4, constraintEntity.get_rawRange());
            }
        };
        this.__insertionAdapterOfOccurrenceEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `occurrences` (`id`,`parentConstraintId`,`timeStamp`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, OccurrenceEntity occurrenceEntity) {
                supportSQLiteStatement.bindLong(1, occurrenceEntity.getId());
                if (occurrenceEntity.getParentConstraintId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, occurrenceEntity.getParentConstraintId());
                }
                supportSQLiteStatement.bindLong(3, occurrenceEntity.getTimeStamp());
            }
        };
        this.__deletionAdapterOfConstraintEntity = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `constraints` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ConstraintEntity constraintEntity) {
                supportSQLiteStatement.bindLong(1, constraintEntity.getId());
            }
        };
        this.__updateAdapterOfConstraintEntity = new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.4
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `constraints` SET `id` = ?,`constraintId` = ?,`count` = ?,`range` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ConstraintEntity constraintEntity) {
                supportSQLiteStatement.bindLong(1, constraintEntity.getId());
                if (constraintEntity.getConstraintId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, constraintEntity.getConstraintId());
                }
                supportSQLiteStatement.bindLong(3, constraintEntity.getCount());
                supportSQLiteStatement.bindLong(4, constraintEntity.get_rawRange());
                supportSQLiteStatement.bindLong(5, constraintEntity.getId());
            }
        };
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object insert(final ConstraintEntity constraintEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() {
                FrequencyLimitDao_Impl.this.__db.beginTransaction();
                try {
                    FrequencyLimitDao_Impl.this.__insertionAdapterOfConstraintEntity.insert((EntityInsertionAdapter) constraintEntity);
                    FrequencyLimitDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FrequencyLimitDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object insert(final OccurrenceEntity occurrenceEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() {
                FrequencyLimitDao_Impl.this.__db.beginTransaction();
                try {
                    FrequencyLimitDao_Impl.this.__insertionAdapterOfOccurrenceEntity.insert((EntityInsertionAdapter) occurrenceEntity);
                    FrequencyLimitDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FrequencyLimitDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object delete(final ConstraintEntity constraintEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() {
                FrequencyLimitDao_Impl.this.__db.beginTransaction();
                try {
                    FrequencyLimitDao_Impl.this.__deletionAdapterOfConstraintEntity.handle(constraintEntity);
                    FrequencyLimitDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FrequencyLimitDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object update(final ConstraintEntity constraintEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() {
                FrequencyLimitDao_Impl.this.__db.beginTransaction();
                try {
                    FrequencyLimitDao_Impl.this.__updateAdapterOfConstraintEntity.handle(constraintEntity);
                    FrequencyLimitDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FrequencyLimitDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$delete$0(List list, Continuation continuation) {
        return super.delete((List<String>) list, (Continuation<? super Unit>) continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object delete(final List<String> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$0(list, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteOccurrences$1(List list, Continuation continuation) {
        return super.deleteOccurrences(list, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object deleteOccurrences(final List<String> list, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteOccurrences$1(list, (Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object getConstraint(String str, Continuation<? super ConstraintEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM constraints WHERE (constraintId = ? )", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.9
            @Override // java.util.concurrent.Callable
            public ConstraintEntity call() {
                ConstraintEntity constraintEntity = null;
                String string = null;
                Cursor cursorQuery = DBUtil.query(FrequencyLimitDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "constraintId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "count");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "range");
                    if (cursorQuery.moveToFirst()) {
                        ConstraintEntity constraintEntity2 = new ConstraintEntity();
                        constraintEntity2.setId(cursorQuery.getInt(columnIndexOrThrow));
                        if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                            string = cursorQuery.getString(columnIndexOrThrow2);
                        }
                        constraintEntity2.setConstraintId(string);
                        constraintEntity2.setCount(cursorQuery.getInt(columnIndexOrThrow3));
                        constraintEntity2.set_rawRange(cursorQuery.getLong(columnIndexOrThrow4));
                        constraintEntity = constraintEntity2;
                    }
                    return constraintEntity;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object getAllConstraints(Continuation<? super List<ConstraintEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM constraints", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(FrequencyLimitDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "constraintId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "count");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "range");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ConstraintEntity constraintEntity = new ConstraintEntity();
                        constraintEntity.setId(cursorQuery.getInt(columnIndexOrThrow));
                        constraintEntity.setConstraintId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        constraintEntity.setCount(cursorQuery.getInt(columnIndexOrThrow3));
                        constraintEntity.set_rawRange(cursorQuery.getLong(columnIndexOrThrow4));
                        arrayList.add(constraintEntity);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object getOccurrences(String str, Continuation<? super List<OccurrenceEntity>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM occurrences WHERE parentConstraintId = ? ORDER BY timeStamp ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List call() {
                Cursor cursorQuery = DBUtil.query(FrequencyLimitDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentConstraintId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timeStamp");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        OccurrenceEntity occurrenceEntity = new OccurrenceEntity();
                        occurrenceEntity.setId(cursorQuery.getInt(columnIndexOrThrow));
                        occurrenceEntity.setParentConstraintId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        occurrenceEntity.setTimeStamp(cursorQuery.getLong(columnIndexOrThrow3));
                        arrayList.add(occurrenceEntity);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public void deleteConstraintsBatchedInternal(Collection<String> collection) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM constraints WHERE (constraintId IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, collection.size());
        sbNewStringBuilder.append("))");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        Iterator<String> it = collection.iterator();
        int i = 1;
        while (it.hasNext()) {
            supportSQLiteStatementCompileStatement.bindString(i, it.next());
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.urbanairship.automation.limits.storage.FrequencyLimitDao
    public Object deleteOccurrencesBatchedInternal(final Collection<String> collection, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.automation.limits.storage.FrequencyLimitDao_Impl.12
            @Override // java.util.concurrent.Callable
            public Unit call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("DELETE FROM occurrences WHERE (parentConstraintId IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, collection.size());
                sbNewStringBuilder.append("))");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = FrequencyLimitDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                Iterator it = collection.iterator();
                int i = 1;
                while (it.hasNext()) {
                    supportSQLiteStatementCompileStatement.bindString(i, (String) it.next());
                    i++;
                }
                FrequencyLimitDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    FrequencyLimitDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    FrequencyLimitDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
