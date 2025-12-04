package com.urbanairship.messagecenter;

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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class MessageDatabase_Impl extends MessageDatabase {
    private volatile MessageDao _messageDao;

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(7) { // from class: com.urbanairship.messagecenter.MessageDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `richpush` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT NOT NULL, `message_url` TEXT, `message_body_url` TEXT, `message_read_url` TEXT, `title` TEXT, `extra` TEXT, `unread` INTEGER NOT NULL, `unread_orig` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `timestamp` TEXT, `raw_message_object` TEXT NOT NULL, `expiration_timestamp` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_richpush_message_id` ON `richpush` (`message_id`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_unread` ON `richpush` (`unread`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_deleted` ON `richpush` (`deleted`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_expiration_timestamp` ON `richpush` (`expiration_timestamp`)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fe7a956551b5db56cb92eb4f4042e73d')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `richpush`");
                List list = ((RoomDatabase) MessageDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) MessageDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) MessageDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                MessageDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) MessageDatabase_Impl.this).mCallbacks;
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
                HashMap map = new HashMap(13);
                map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map.put("message_id", new TableInfo.Column("message_id", "TEXT", true, 0, null, 1));
                map.put(Message.KEY_MESSAGE_URL, new TableInfo.Column(Message.KEY_MESSAGE_URL, "TEXT", false, 0, null, 1));
                map.put(Message.KEY_BODY_URL, new TableInfo.Column(Message.KEY_BODY_URL, "TEXT", false, 0, null, 1));
                map.put(Message.KEY_MESSAGE_READ_URL, new TableInfo.Column(Message.KEY_MESSAGE_READ_URL, "TEXT", false, 0, null, 1));
                map.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map.put(Message.KEY_EXTRAS, new TableInfo.Column(Message.KEY_EXTRAS, "TEXT", false, 0, null, 1));
                map.put(Message.KEY_IS_UNREAD, new TableInfo.Column(Message.KEY_IS_UNREAD, "INTEGER", true, 0, null, 1));
                map.put("unread_orig", new TableInfo.Column("unread_orig", "INTEGER", true, 0, null, 1));
                map.put("deleted", new TableInfo.Column("deleted", "INTEGER", true, 0, null, 1));
                map.put("timestamp", new TableInfo.Column("timestamp", "TEXT", false, 0, null, 1));
                map.put("raw_message_object", new TableInfo.Column("raw_message_object", "TEXT", true, 0, null, 1));
                map.put("expiration_timestamp", new TableInfo.Column("expiration_timestamp", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(4);
                hashSet2.add(new TableInfo.Index("index_richpush_message_id", true, Arrays.asList("message_id"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_richpush_unread", false, Arrays.asList(Message.KEY_IS_UNREAD), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_richpush_deleted", false, Arrays.asList("deleted"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_richpush_expiration_timestamp", false, Arrays.asList("expiration_timestamp"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("richpush", map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "richpush");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "richpush(com.urbanairship.messagecenter.MessageEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "fe7a956551b5db56cb92eb4f4042e73d", "971e4c1df51b96cadcaccc13a2bd7b36")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "richpush");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `richpush`");
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
        map.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessageDatabase_AutoMigration_5_6_Impl());
        arrayList.add(new MessageDatabase_AutoMigration_6_7_Impl());
        return arrayList;
    }

    @Override // com.urbanairship.messagecenter.MessageDatabase
    public MessageDao getDao() {
        MessageDao messageDao;
        if (this._messageDao != null) {
            return this._messageDao;
        }
        synchronized (this) {
            try {
                if (this._messageDao == null) {
                    this._messageDao = new MessageDao_Impl(this);
                }
                messageDao = this._messageDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return messageDao;
    }
}
