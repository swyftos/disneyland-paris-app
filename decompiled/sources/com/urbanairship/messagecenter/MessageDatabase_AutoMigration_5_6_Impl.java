package com.urbanairship.messagecenter;

import android.database.SQLException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes5.dex */
final class MessageDatabase_AutoMigration_5_6_Impl extends Migration {
    public MessageDatabase_AutoMigration_5_6_Impl() {
        super(5, 6);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `_new_richpush` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT, `message_url` TEXT, `message_body_url` TEXT, `message_read_url` TEXT, `title` TEXT, `extra` TEXT, `unread` INTEGER NOT NULL, `unread_orig` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `timestamp` TEXT, `raw_message_object` TEXT, `expiration_timestamp` TEXT)");
        supportSQLiteDatabase.execSQL("INSERT INTO `_new_richpush` (`_id`,`message_id`,`message_url`,`message_body_url`,`message_read_url`,`title`,`extra`,`unread`,`unread_orig`,`deleted`,`timestamp`,`raw_message_object`,`expiration_timestamp`) SELECT `_id`,`message_id`,`message_url`,`message_body_url`,`message_read_url`,`title`,`extra`,`unread`,`unread_orig`,`deleted`,`timestamp`,`raw_message_object`,`expiration_timestamp` FROM `richpush`");
        supportSQLiteDatabase.execSQL("DROP TABLE `richpush`");
        supportSQLiteDatabase.execSQL("ALTER TABLE `_new_richpush` RENAME TO `richpush`");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_richpush_message_id` ON `richpush` (`message_id`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_unread` ON `richpush` (`unread`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_deleted` ON `richpush` (`deleted`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_richpush_expiration_timestamp` ON `richpush` (`expiration_timestamp`)");
    }
}
