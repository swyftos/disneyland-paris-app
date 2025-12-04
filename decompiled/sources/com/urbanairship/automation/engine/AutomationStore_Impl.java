package com.urbanairship.automation.engine;

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
import com.dlp.BluetoothManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class AutomationStore_Impl extends AutomationStore {
    private volatile AutomationDao _automationDao;

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) { // from class: com.urbanairship.automation.engine.AutomationStore_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `schedules` (`scheduleId` TEXT NOT NULL, `group` TEXT, `executionCount` INTEGER NOT NULL, `preparedScheduleInfo` TEXT, `schedule` TEXT NOT NULL, `scheduleState` TEXT NOT NULL, `scheduleStateChangeDate` INTEGER NOT NULL, `triggerInfo` TEXT, `triggerSessionId` TEXT, `associatedData` TEXT, PRIMARY KEY(`scheduleId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `automation_trigger_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `triggerId` TEXT NOT NULL, `scheduleId` TEXT NOT NULL, `state` TEXT NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5e6dc22f073cc3a468814afc65ce1d8d')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `schedules`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `automation_trigger_data`");
                List list = ((RoomDatabase) AutomationStore_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) AutomationStore_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) AutomationStore_Impl.this).mDatabase = supportSQLiteDatabase;
                AutomationStore_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) AutomationStore_Impl.this).mCallbacks;
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
                HashMap map = new HashMap(10);
                map.put("scheduleId", new TableInfo.Column("scheduleId", "TEXT", true, 1, null, 1));
                map.put("group", new TableInfo.Column("group", "TEXT", false, 0, null, 1));
                map.put("executionCount", new TableInfo.Column("executionCount", "INTEGER", true, 0, null, 1));
                map.put("preparedScheduleInfo", new TableInfo.Column("preparedScheduleInfo", "TEXT", false, 0, null, 1));
                map.put("schedule", new TableInfo.Column("schedule", "TEXT", true, 0, null, 1));
                map.put("scheduleState", new TableInfo.Column("scheduleState", "TEXT", true, 0, null, 1));
                map.put("scheduleStateChangeDate", new TableInfo.Column("scheduleStateChangeDate", "INTEGER", true, 0, null, 1));
                map.put("triggerInfo", new TableInfo.Column("triggerInfo", "TEXT", false, 0, null, 1));
                map.put("triggerSessionId", new TableInfo.Column("triggerSessionId", "TEXT", false, 0, null, 1));
                map.put("associatedData", new TableInfo.Column("associatedData", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("schedules", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "schedules");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "schedules(com.urbanairship.automation.engine.ScheduleEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(4);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map2.put("triggerId", new TableInfo.Column("triggerId", "TEXT", true, 0, null, 1));
                map2.put("scheduleId", new TableInfo.Column("scheduleId", "TEXT", true, 0, null, 1));
                map2.put(BluetoothManager.BLE_STATUS_PARAM, new TableInfo.Column(BluetoothManager.BLE_STATUS_PARAM, "TEXT", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("automation_trigger_data", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "automation_trigger_data");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "automation_trigger_data(com.urbanairship.automation.engine.TriggerEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "5e6dc22f073cc3a468814afc65ce1d8d", "cf9dd8c22ca2973ff7ba823c94fd8fe3")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "schedules", "automation_trigger_data");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `schedules`");
            writableDatabase.execSQL("DELETE FROM `automation_trigger_data`");
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

    @Override // com.urbanairship.automation.engine.AutomationStore
    public AutomationDao getDao$urbanairship_automation_release() {
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
