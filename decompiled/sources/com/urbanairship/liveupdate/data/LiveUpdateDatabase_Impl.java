package com.urbanairship.liveupdate.data;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class LiveUpdateDatabase_Impl extends LiveUpdateDatabase {
    private volatile LiveUpdateDao _liveUpdateDao;

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.urbanairship.liveupdate.data.LiveUpdateDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `live_update_state` (`name` TEXT NOT NULL, `type` TEXT NOT NULL, `isActive` INTEGER NOT NULL, `last_start_stop_time` INTEGER NOT NULL, `dismissal_date` INTEGER, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `live_update_content` (`name` TEXT NOT NULL, `content` TEXT NOT NULL, `last_update_time` INTEGER NOT NULL, PRIMARY KEY(`name`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dd75faf51b1c56afcc5d48421cf8193c')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `live_update_state`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `live_update_content`");
                List list = ((RoomDatabase) LiveUpdateDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) LiveUpdateDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) LiveUpdateDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                LiveUpdateDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) LiveUpdateDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(5);
                map.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                map.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, 1));
                map.put("last_start_stop_time", new TableInfo.Column("last_start_stop_time", "INTEGER", true, 0, null, 1));
                map.put("dismissal_date", new TableInfo.Column("dismissal_date", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("live_update_state", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "live_update_state");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "live_update_state(com.urbanairship.liveupdate.data.LiveUpdateState).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(3);
                map2.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map2.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                map2.put("last_update_time", new TableInfo.Column("last_update_time", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("live_update_content", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "live_update_content");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "live_update_content(com.urbanairship.liveupdate.data.LiveUpdateContent).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "dd75faf51b1c56afcc5d48421cf8193c", "79b2b2636ea9f0efb0eb67214a47b7d4")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "live_update_state", "live_update_content");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `live_update_state`");
            writableDatabase.execSQL("DELETE FROM `live_update_content`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(LiveUpdateDao.class, LiveUpdateDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return new ArrayList();
    }

    @Override // com.urbanairship.liveupdate.data.LiveUpdateDatabase
    public LiveUpdateDao liveUpdateDao() {
        LiveUpdateDao liveUpdateDao;
        if (this._liveUpdateDao != null) {
            return this._liveUpdateDao;
        }
        synchronized (this) {
            try {
                if (this._liveUpdateDao == null) {
                    this._liveUpdateDao = new LiveUpdateDao_Impl(this);
                }
                liveUpdateDao = this._liveUpdateDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return liveUpdateDao;
    }
}
