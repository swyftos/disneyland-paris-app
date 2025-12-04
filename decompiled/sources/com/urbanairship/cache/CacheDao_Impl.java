package com.urbanairship.cache;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class CacheDao_Impl implements CacheDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfCacheEntity;
    private final JsonTypeConverters __jsonTypeConverters = new JsonTypeConverters();
    private final SharedSQLiteStatement __preparedStmtOfDeleteExpired;
    private final SharedSQLiteStatement __preparedStmtOfDeleteItemWithKey;

    public CacheDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCacheEntity = new EntityInsertionAdapter(roomDatabase) { // from class: com.urbanairship.cache.CacheDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `cacheItems` (`key`,`appVersion`,`sdkVersion`,`expireOn`,`data`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CacheEntity cacheEntity) {
                supportSQLiteStatement.bindString(1, cacheEntity.getKey());
                supportSQLiteStatement.bindString(2, cacheEntity.getAppVersion());
                supportSQLiteStatement.bindString(3, cacheEntity.getSdkVersion());
                supportSQLiteStatement.bindLong(4, cacheEntity.getExpireOn());
                String strJsonValueToString = CacheDao_Impl.this.__jsonTypeConverters.jsonValueToString(cacheEntity.getData());
                if (strJsonValueToString == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, strJsonValueToString);
                }
            }
        };
        this.__preparedStmtOfDeleteItemWithKey = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.cache.CacheDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from cacheItems where `key` = ?";
            }
        };
        this.__preparedStmtOfDeleteExpired = new SharedSQLiteStatement(roomDatabase) { // from class: com.urbanairship.cache.CacheDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from cacheItems where appVersion != ? or sdkVersion != ? or expireOn < ?";
            }
        };
    }

    @Override // com.urbanairship.cache.CacheDao
    public Object addEntry(final CacheEntity cacheEntity, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.cache.CacheDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() {
                CacheDao_Impl.this.__db.beginTransaction();
                try {
                    CacheDao_Impl.this.__insertionAdapterOfCacheEntity.insert((EntityInsertionAdapter) cacheEntity);
                    CacheDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    CacheDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateEntry$0(CacheEntity cacheEntity, Continuation continuation) {
        return super.updateEntry(cacheEntity, continuation);
    }

    @Override // com.urbanairship.cache.CacheDao
    public Object updateEntry(final CacheEntity cacheEntity, Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: com.urbanairship.cache.CacheDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$updateEntry$0(cacheEntity, (Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.urbanairship.cache.CacheDao
    public Object deleteItemWithKey(final String str, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.cache.CacheDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = CacheDao_Impl.this.__preparedStmtOfDeleteItemWithKey.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                try {
                    CacheDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        CacheDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        CacheDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    CacheDao_Impl.this.__preparedStmtOfDeleteItemWithKey.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.cache.CacheDao
    public Object deleteExpired(final String str, final String str2, final long j, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable() { // from class: com.urbanairship.cache.CacheDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = CacheDao_Impl.this.__preparedStmtOfDeleteExpired.acquire();
                supportSQLiteStatementAcquire.bindString(1, str);
                supportSQLiteStatementAcquire.bindString(2, str2);
                supportSQLiteStatementAcquire.bindLong(3, j);
                try {
                    CacheDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        CacheDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        CacheDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    CacheDao_Impl.this.__preparedStmtOfDeleteExpired.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.urbanairship.cache.CacheDao
    public Object getEntryWithKey(String str, Continuation<? super CacheEntity> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from cacheItems where `key` = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, str);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable() { // from class: com.urbanairship.cache.CacheDao_Impl.7
            @Override // java.util.concurrent.Callable
            public CacheEntity call() {
                CacheEntity cacheEntity = null;
                String string = null;
                Cursor cursorQuery = DBUtil.query(CacheDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "key");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdkVersion");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expireOn");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                    if (cursorQuery.moveToFirst()) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
                        String string3 = cursorQuery.getString(columnIndexOrThrow2);
                        String string4 = cursorQuery.getString(columnIndexOrThrow3);
                        long j = cursorQuery.getLong(columnIndexOrThrow4);
                        if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                            string = cursorQuery.getString(columnIndexOrThrow5);
                        }
                        JsonValue jsonValueJsonValueFromString = CacheDao_Impl.this.__jsonTypeConverters.jsonValueFromString(string);
                        if (jsonValueJsonValueFromString == null) {
                            throw new IllegalStateException("Expected NON-NULL 'com.urbanairship.json.JsonValue', but it was NULL.");
                        }
                        cacheEntity = new CacheEntity(string2, string3, string4, j, jsonValueJsonValueFromString);
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    return cacheEntity;
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
}
