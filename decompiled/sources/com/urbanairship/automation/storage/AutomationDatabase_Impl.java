package com.urbanairship.automation.storage;

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
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class AutomationDatabase_Impl extends AutomationDatabase {
    private volatile AutomationDao _automationDao;

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(7) { // from class: com.urbanairship.automation.storage.AutomationDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `schedules` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `scheduleId` TEXT, `group` TEXT, `metadata` TEXT, `limit` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `triggeredTime` INTEGER NOT NULL, `scheduleStart` INTEGER NOT NULL, `scheduleEnd` INTEGER NOT NULL, `editGracePeriod` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `scheduleType` TEXT, `data` TEXT, `count` INTEGER NOT NULL, `executionState` INTEGER NOT NULL, `executionStateChangeDate` INTEGER NOT NULL, `triggerContext` TEXT, `appState` INTEGER NOT NULL, `screens` TEXT, `seconds` INTEGER NOT NULL, `regionId` TEXT, `audience` TEXT, `campaigns` TEXT, `reportingContext` TEXT, `frequencyConstraintIds` TEXT, `messageType` TEXT, `bypassHoldoutGroups` INTEGER NOT NULL, `newUserEvaluationDate` INTEGER NOT NULL, `productId` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_schedules_scheduleId` ON `schedules` (`scheduleId`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `triggers` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `triggerType` INTEGER NOT NULL, `goal` REAL NOT NULL, `jsonPredicate` TEXT, `isCancellation` INTEGER NOT NULL, `progress` REAL NOT NULL, `parentScheduleId` TEXT, FOREIGN KEY(`parentScheduleId`) REFERENCES `schedules`(`scheduleId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_triggers_parentScheduleId` ON `triggers` (`parentScheduleId`)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f23110813aae29e5e5a4a4e90483e487')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `schedules`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `triggers`");
                List list = ((RoomDatabase) AutomationDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) AutomationDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                ((RoomDatabase) AutomationDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                AutomationDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) AutomationDatabase_Impl.this).mCallbacks;
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
                HashMap map = new HashMap(29);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map.put("scheduleId", new TableInfo.Column("scheduleId", "TEXT", false, 0, null, 1));
                map.put("group", new TableInfo.Column("group", "TEXT", false, 0, null, 1));
                map.put("metadata", new TableInfo.Column("metadata", "TEXT", false, 0, null, 1));
                map.put("limit", new TableInfo.Column("limit", "INTEGER", true, 0, null, 1));
                map.put(Constants.FirelogAnalytics.PARAM_PRIORITY, new TableInfo.Column(Constants.FirelogAnalytics.PARAM_PRIORITY, "INTEGER", true, 0, null, 1));
                map.put("triggeredTime", new TableInfo.Column("triggeredTime", "INTEGER", true, 0, null, 1));
                map.put("scheduleStart", new TableInfo.Column("scheduleStart", "INTEGER", true, 0, null, 1));
                map.put("scheduleEnd", new TableInfo.Column("scheduleEnd", "INTEGER", true, 0, null, 1));
                map.put("editGracePeriod", new TableInfo.Column("editGracePeriod", "INTEGER", true, 0, null, 1));
                map.put("interval", new TableInfo.Column("interval", "INTEGER", true, 0, null, 1));
                map.put("scheduleType", new TableInfo.Column("scheduleType", "TEXT", false, 0, null, 1));
                map.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, 1));
                map.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, 1));
                map.put("executionState", new TableInfo.Column("executionState", "INTEGER", true, 0, null, 1));
                map.put("executionStateChangeDate", new TableInfo.Column("executionStateChangeDate", "INTEGER", true, 0, null, 1));
                map.put("triggerContext", new TableInfo.Column("triggerContext", "TEXT", false, 0, null, 1));
                map.put("appState", new TableInfo.Column("appState", "INTEGER", true, 0, null, 1));
                map.put("screens", new TableInfo.Column("screens", "TEXT", false, 0, null, 1));
                map.put("seconds", new TableInfo.Column("seconds", "INTEGER", true, 0, null, 1));
                map.put("regionId", new TableInfo.Column("regionId", "TEXT", false, 0, null, 1));
                map.put("audience", new TableInfo.Column("audience", "TEXT", false, 0, null, 1));
                map.put("campaigns", new TableInfo.Column("campaigns", "TEXT", false, 0, null, 1));
                map.put("reportingContext", new TableInfo.Column("reportingContext", "TEXT", false, 0, null, 1));
                map.put("frequencyConstraintIds", new TableInfo.Column("frequencyConstraintIds", "TEXT", false, 0, null, 1));
                map.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, new TableInfo.Column(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "TEXT", false, 0, null, 1));
                map.put("bypassHoldoutGroups", new TableInfo.Column("bypassHoldoutGroups", "INTEGER", true, 0, null, 1));
                map.put("newUserEvaluationDate", new TableInfo.Column("newUserEvaluationDate", "INTEGER", true, 0, null, 1));
                map.put("productId", new TableInfo.Column("productId", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_schedules_scheduleId", true, Arrays.asList("scheduleId"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("schedules", map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "schedules");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "schedules(com.urbanairship.automation.storage.ScheduleEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(7);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map2.put("triggerType", new TableInfo.Column("triggerType", "INTEGER", true, 0, null, 1));
                map2.put("goal", new TableInfo.Column("goal", "REAL", true, 0, null, 1));
                map2.put("jsonPredicate", new TableInfo.Column("jsonPredicate", "TEXT", false, 0, null, 1));
                map2.put("isCancellation", new TableInfo.Column("isCancellation", "INTEGER", true, 0, null, 1));
                map2.put("progress", new TableInfo.Column("progress", "REAL", true, 0, null, 1));
                map2.put("parentScheduleId", new TableInfo.Column("parentScheduleId", "TEXT", false, 0, null, 1));
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.ForeignKey("schedules", "CASCADE", "NO ACTION", Arrays.asList("parentScheduleId"), Arrays.asList("scheduleId")));
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_triggers_parentScheduleId", false, Arrays.asList("parentScheduleId"), Arrays.asList("ASC")));
                TableInfo tableInfo3 = new TableInfo("triggers", map2, hashSet3, hashSet4);
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "triggers");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "triggers(com.urbanairship.automation.storage.TriggerEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "f23110813aae29e5e5a4a4e90483e487", "08b50f94d776593fa3d227772cfcefa3")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "schedules", "triggers");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `schedules`");
            writableDatabase.execSQL("DELETE FROM `triggers`");
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
        map.put(AutomationDao.class, AutomationDao_Impl.getRequiredConverters());
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

    @Override // com.urbanairship.automation.storage.AutomationDatabase
    public AutomationDao getScheduleDao() {
        AutomationDao automationDao;
        if (this._automationDao != null) {
            return this._automationDao;
        }
        synchronized (this) {
            try {
                if (this._automationDao == null) {
                    this._automationDao = new AutomationDao_Impl(this);
                }
                automationDao = this._automationDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return automationDao;
    }
}
