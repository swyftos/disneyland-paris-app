package com.urbanairship.meteredusage;

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
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.id.android.lightbox.LightboxActivity;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class EventsDatabase_Impl extends EventsDatabase {
    private volatile EventsDao _eventsDao;

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.urbanairship.meteredusage.EventsDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `events` (`eventId` TEXT NOT NULL, `entityId` TEXT, `type` TEXT NOT NULL, `product` TEXT NOT NULL, `reportingContext` TEXT, `timestamp` INTEGER, `contactId` TEXT, PRIMARY KEY(`eventId`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8c7865b562d10a8ebc664e33c4c6fd7d')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `events`");
                List list = ((RoomDatabase) EventsDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) EventsDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) EventsDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                EventsDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) EventsDatabase_Impl.this).mCallbacks;
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
                HashMap map = new HashMap(7);
                map.put(LightboxActivity.EVENT_ID_EXTRA, new TableInfo.Column(LightboxActivity.EVENT_ID_EXTRA, "TEXT", true, 1, null, 1));
                map.put("entityId", new TableInfo.Column("entityId", "TEXT", false, 0, null, 1));
                map.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                map.put(TCEventPropertiesNames.TCI_PRODUCT, new TableInfo.Column(TCEventPropertiesNames.TCI_PRODUCT, "TEXT", true, 0, null, 1));
                map.put("reportingContext", new TableInfo.Column("reportingContext", "TEXT", false, 0, null, 1));
                map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", false, 0, null, 1));
                map.put("contactId", new TableInfo.Column("contactId", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo(UriBuilder.ANALYTICS_EVENT_ENDPOINT, map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, UriBuilder.ANALYTICS_EVENT_ENDPOINT);
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "events(com.urbanairship.meteredusage.MeteredUsageEventEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "8c7865b562d10a8ebc664e33c4c6fd7d", "1026af79c60e3675b30eb27355daaebe")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), UriBuilder.ANALYTICS_EVENT_ENDPOINT);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `events`");
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
        map.put(EventsDao.class, EventsDao_Impl.getRequiredConverters());
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

    @Override // com.urbanairship.meteredusage.EventsDatabase
    public EventsDao eventsDao() {
        EventsDao eventsDao;
        if (this._eventsDao != null) {
            return this._eventsDao;
        }
        synchronized (this) {
            try {
                if (this._eventsDao == null) {
                    this._eventsDao = new EventsDao_Impl(this);
                }
                eventsDao = this._eventsDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eventsDao;
    }
}
