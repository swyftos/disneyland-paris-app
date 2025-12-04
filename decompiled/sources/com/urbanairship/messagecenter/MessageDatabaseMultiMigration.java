package com.urbanairship.messagecenter;

import android.database.SQLException;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.urbanairship.db.RecoverableMigration;

/* loaded from: classes5.dex */
class MessageDatabaseMultiMigration extends RecoverableMigration {
    public MessageDatabaseMultiMigration(int i, int i2) {
        super(i, i2);
    }

    @Override // com.urbanairship.db.RecoverableMigration
    public void tryMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        createTable(supportSQLiteDatabase, "richpush_new");
        supportSQLiteDatabase.execSQL("DELETE FROM richpush WHERE _id NOT IN (SELECT MIN(_id) FROM richpush GROUP BY message_id)");
        supportSQLiteDatabase.execSQL("UPDATE richpush SET unread_orig = 0 WHERE unread_orig IS NULL");
        supportSQLiteDatabase.execSQL("UPDATE richpush SET unread = 0 WHERE unread IS NULL");
        supportSQLiteDatabase.execSQL("UPDATE richpush SET deleted = 0 WHERE deleted IS NULL");
        supportSQLiteDatabase.execSQL("INSERT INTO richpush_new (_id, message_id, message_url, message_body_url, message_read_url, title, extra, unread, unread_orig, deleted, timestamp, raw_message_object, expiration_timestamp) SELECT _id, message_id, message_url, message_body_url, message_read_url, title, extra, unread, unread_orig, deleted, timestamp, raw_message_object, expiration_timestamp FROM richpush");
        dropOldAndRenameNewTable(supportSQLiteDatabase);
        createUniqueIndexOnMessageId(supportSQLiteDatabase);
    }

    @Override // com.urbanairship.db.RecoverableMigration
    public void tryRecover(SupportSQLiteDatabase supportSQLiteDatabase, Exception exc) throws SQLException {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush_new");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush");
        createTable(supportSQLiteDatabase, "richpush");
        createUniqueIndexOnMessageId(supportSQLiteDatabase);
    }

    private void createTable(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws SQLException {
        supportSQLiteDatabase.execSQL("CREATE TABLE " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, message_id TEXT, " + Message.KEY_MESSAGE_URL + " TEXT, " + Message.KEY_BODY_URL + " TEXT, " + Message.KEY_MESSAGE_READ_URL + " TEXT, title TEXT, " + Message.KEY_EXTRAS + " TEXT, " + Message.KEY_IS_UNREAD + " INTEGER NOT NULL, unread_orig INTEGER NOT NULL, deleted INTEGER NOT NULL, timestamp TEXT, raw_message_object TEXT, expiration_timestamp TEXT );");
    }

    private void dropOldAndRenameNewTable(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        supportSQLiteDatabase.execSQL("DROP TABLE richpush");
        supportSQLiteDatabase.execSQL("ALTER TABLE richpush_new RENAME TO richpush");
    }

    private void createUniqueIndexOnMessageId(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_richpush_message_id` ON `richpush` (`message_id`)");
    }
}
