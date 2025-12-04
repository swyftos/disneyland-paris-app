package com.urbanairship.liveupdate.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
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
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class LiveUpdateDao_Impl implements LiveUpdateDao {
    private final Converters __converters = new Converters();
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllContent;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllState;
    private final SharedSQLiteStatement __preparedStmtOfDeleteContent;
    private final SharedSQLiteStatement __preparedStmtOfDeleteState;
    private final EntityUpsertionAdapter __upsertionAdapterOfLiveUpdateContent;
    private final EntityUpsertionAdapter __upsertionAdapterOfLiveUpdateState;

    public LiveUpdateDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__preparedStmtOfDeleteState = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM live_update_state WHERE name = ?";
            }
        };
        this.__preparedStmtOfDeleteContent = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM live_update_content WHERE name = ?";
            }
        };
        this.__preparedStmtOfDeleteAllState = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM live_update_state";
            }
        };
        this.__preparedStmtOfDeleteAllContent = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM live_update_content";
            }
        };
        this.__upsertionAdapterOfLiveUpdateState = new EntityUpsertionAdapter(new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT INTO `live_update_state` (`name`,`type`,`isActive`,`last_start_stop_time`,`dismissal_date`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LiveUpdateState liveUpdateState) {
                supportSQLiteStatement.bindString(1, liveUpdateState.getName());
                supportSQLiteStatement.bindString(2, liveUpdateState.getType());
                supportSQLiteStatement.bindLong(3, liveUpdateState.isActive() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, liveUpdateState.getTimestamp());
                if (liveUpdateState.getDismissalDate() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, liveUpdateState.getDismissalDate().longValue());
                }
            }
        }, new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.6
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE `live_update_state` SET `name` = ?,`type` = ?,`isActive` = ?,`last_start_stop_time` = ?,`dismissal_date` = ? WHERE `name` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LiveUpdateState liveUpdateState) {
                supportSQLiteStatement.bindString(1, liveUpdateState.getName());
                supportSQLiteStatement.bindString(2, liveUpdateState.getType());
                supportSQLiteStatement.bindLong(3, liveUpdateState.isActive() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, liveUpdateState.getTimestamp());
                if (liveUpdateState.getDismissalDate() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, liveUpdateState.getDismissalDate().longValue());
                }
                supportSQLiteStatement.bindString(6, liveUpdateState.getName());
            }
        });
        this.__upsertionAdapterOfLiveUpdateContent = new EntityUpsertionAdapter(new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT INTO `live_update_content` (`name`,`content`,`last_update_time`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LiveUpdateContent liveUpdateContent) {
                supportSQLiteStatement.bindString(1, liveUpdateContent.getName());
                supportSQLiteStatement.bindString(2, LiveUpdateDao_Impl.this.__converters.fromJsonMap(liveUpdateContent.getContent()));
                supportSQLiteStatement.bindLong(3, liveUpdateContent.getTimestamp());
            }
        }, new EntityDeletionOrUpdateAdapter(roomDatabase) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.8
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE `live_update_content` SET `name` = ?,`content` = ?,`last_update_time` = ? WHERE `name` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LiveUpdateContent liveUpdateContent) {
                supportSQLiteStatement.bindString(1, liveUpdateContent.getName());
                supportSQLiteStatement.bindString(2, LiveUpdateDao_Impl.this.__converters.fromJsonMap(liveUpdateContent.getContent()));
                supportSQLiteStatement.bindLong(3, liveUpdateContent.getTimestamp());
                supportSQLiteStatement.bindString(4, liveUpdateContent.getName());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$upsert$0(LiveUpdateState liveUpdateState, LiveUpdateContent liveUpdateContent, Continuation continuation) {
        return super.upsert(liveUpdateState, liveUpdateContent, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object upsert(final LiveUpdateState liveUpdateState, final LiveUpdateContent liveUpdateContent, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$upsert$0(liveUpdateState, liveUpdateContent, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$delete$1(String str, Continuation continuation) {
        return super.delete(str, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object delete(final String str, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$delete$1(str, (Continuation) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deleteAll$2(Continuation continuation) {
        return super.deleteAll(continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object deleteAll(Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$deleteAll$2((Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object deleteState(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.9
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LiveUpdateDao_Impl.this.__preparedStmtOfDeleteState.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                try {
                    LiveUpdateDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LiveUpdateDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__preparedStmtOfDeleteState.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object deleteContent(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LiveUpdateDao_Impl.this.__preparedStmtOfDeleteContent.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                try {
                    LiveUpdateDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LiveUpdateDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__preparedStmtOfDeleteContent.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object deleteAllState(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.11
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LiveUpdateDao_Impl.this.__preparedStmtOfDeleteAllState.acquire();
                try {
                    LiveUpdateDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LiveUpdateDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__preparedStmtOfDeleteAllState.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object deleteAllContent(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.12
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = LiveUpdateDao_Impl.this.__preparedStmtOfDeleteAllContent.acquire();
                try {
                    LiveUpdateDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LiveUpdateDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__preparedStmtOfDeleteAllContent.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object upsert(final LiveUpdateState liveUpdateState, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.13
            @Override // java.util.concurrent.Callable
            public Unit call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    LiveUpdateDao_Impl.this.__upsertionAdapterOfLiveUpdateState.upsert((EntityUpsertionAdapter) liveUpdateState);
                    LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object upsert(final LiveUpdateContent liveUpdateContent, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    LiveUpdateDao_Impl.this.__upsertionAdapterOfLiveUpdateContent.upsert((EntityUpsertionAdapter) liveUpdateContent);
                    LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object get(String str, Continuation<? super LiveUpdateStateWithContent> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM live_update_state WHERE name = ? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.15
            @Override // java.util.concurrent.Callable
            public LiveUpdateStateWithContent call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    LiveUpdateStateWithContent liveUpdateStateWithContent = null;
                    Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isActive");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_start_stop_time");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dismissal_date");
                        ArrayMap arrayMap = new ArrayMap();
                        while (cursorQuery.moveToNext()) {
                            arrayMap.put(cursorQuery.getString(columnIndexOrThrow), null);
                        }
                        cursorQuery.moveToPosition(-1);
                        LiveUpdateDao_Impl.this.__fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent(arrayMap);
                        if (cursorQuery.moveToFirst()) {
                            liveUpdateStateWithContent = new LiveUpdateStateWithContent(new LiveUpdateState(cursorQuery.getString(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5))), (LiveUpdateContent) arrayMap.get(cursorQuery.getString(columnIndexOrThrow)));
                        }
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return liveUpdateStateWithContent;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object getState(String str, Continuation<? super LiveUpdateState> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM live_update_state WHERE name = ? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.16
            @Override // java.util.concurrent.Callable
            public LiveUpdateState call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    LiveUpdateState liveUpdateState = null;
                    Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isActive");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_start_stop_time");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dismissal_date");
                        if (cursorQuery.moveToFirst()) {
                            liveUpdateState = new LiveUpdateState(cursorQuery.getString(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                        }
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return liveUpdateState;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object getContent(String str, Continuation<? super LiveUpdateContent> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM live_update_content WHERE name = ? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.17
            @Override // java.util.concurrent.Callable
            public LiveUpdateContent call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    LiveUpdateContent liveUpdateContent = null;
                    Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_update_time");
                        if (cursorQuery.moveToFirst()) {
                            liveUpdateContent = new LiveUpdateContent(cursorQuery.getString(columnIndexOrThrow), LiveUpdateDao_Impl.this.__converters.toJsonMap(cursorQuery.getString(columnIndexOrThrow2)), cursorQuery.getLong(columnIndexOrThrow3));
                        }
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return liveUpdateContent;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object getAllActive(Continuation<? super List<LiveUpdateStateWithContent>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM live_update_state WHERE isActive = 1", 0);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.18
            @Override // java.util.concurrent.Callable
            public List call() {
                LiveUpdateDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isActive");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_start_stop_time");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dismissal_date");
                        ArrayMap arrayMap = new ArrayMap();
                        while (cursorQuery.moveToNext()) {
                            arrayMap.put(cursorQuery.getString(columnIndexOrThrow), null);
                        }
                        cursorQuery.moveToPosition(-1);
                        LiveUpdateDao_Impl.this.__fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent(arrayMap);
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(new LiveUpdateStateWithContent(new LiveUpdateState(cursorQuery.getString(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, cursorQuery.getLong(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5))), (LiveUpdateContent) arrayMap.get(cursorQuery.getString(columnIndexOrThrow))));
                        }
                        LiveUpdateDao_Impl.this.__db.setTransactionSuccessful();
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } finally {
                    LiveUpdateDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object isAnyActive(Continuation<? super Boolean> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM live_update_state WHERE isActive = 1", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.19
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                Boolean boolValueOf;
                Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        boolValueOf = Boolean.valueOf(cursorQuery.getInt(0) != 0);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return boolValueOf;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object countState(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM live_update_state", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.20
            @Override // java.util.concurrent.Callable
            public Integer call() {
                int iValueOf;
                Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        iValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    } else {
                        iValueOf = 0;
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return iValueOf;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDao
    public Object countContent(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM live_update_content", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl.21
            @Override // java.util.concurrent.Callable
            public Integer call() {
                int iValueOf;
                Cursor cursorQuery = DBUtil.query(LiveUpdateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        iValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    } else {
                        iValueOf = 0;
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return iValueOf;
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
        }, continuation);
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent(ArrayMap arrayMap) {
        Set setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(arrayMap, false, new Function1() { // from class: com.urbanairship.liveupdate.data.LiveUpdateDao_Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$__fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent$3((ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `name`,`content`,`last_update_time` FROM `live_update_content` WHERE `name` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        Iterator it = setKeySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            roomSQLiteQueryAcquire.bindString(i, (String) it.next());
            i++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "name");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(columnIndex);
                if (arrayMap.containsKey(string)) {
                    arrayMap.put(string, new LiveUpdateContent(cursorQuery.getString(0), this.__converters.toJsonMap(cursorQuery.getString(1)), cursorQuery.getLong(2)));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent$3(ArrayMap arrayMap) {
        __fetchRelationshipliveUpdateContentAscomUrbanairshipLiveupdateDataLiveUpdateContent(arrayMap);
        return Unit.INSTANCE;
    }
}
