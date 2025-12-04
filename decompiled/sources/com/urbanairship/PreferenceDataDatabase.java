package com.urbanairship;

import android.content.Context;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.File;

@Database(entities = {PreferenceData.class}, version = 2)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public abstract class PreferenceDataDatabase extends RoomDatabase {
    static final Migration MIGRATION_1_2 = new Migration(1, 2) { // from class: com.urbanairship.PreferenceDataDatabase.1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            supportSQLiteDatabase.execSQL("CREATE TABLE preferences_new (_id TEXT PRIMARY KEY NOT NULL, value TEXT);");
            supportSQLiteDatabase.execSQL("INSERT INTO preferences_new (_id, value) SELECT _id, value FROM preferences");
            supportSQLiteDatabase.execSQL("DROP TABLE preferences");
            supportSQLiteDatabase.execSQL("ALTER TABLE preferences_new RENAME TO preferences");
        }
    };

    public abstract PreferenceDataDao getDao();

    public static PreferenceDataDatabase createDatabase(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions) {
        return (PreferenceDataDatabase) Room.databaseBuilder(context, PreferenceDataDatabase.class, new File(new File(ContextCompat.getNoBackupFilesDir(context), "com.urbanairship.databases"), airshipConfigOptions.appKey + "_ua_preferences.db").getAbsolutePath()).addMigrations(MIGRATION_1_2).fallbackToDestructiveMigrationOnDowngrade().build();
    }

    @VisibleForTesting
    public static PreferenceDataDatabase createInMemoryDatabase(@NonNull Context context) {
        return (PreferenceDataDatabase) Room.inMemoryDatabaseBuilder(context, PreferenceDataDatabase.class).allowMainThreadQueries().build();
    }

    public boolean exists(@NonNull Context context) {
        return getOpenHelper().getName() == null || context.getDatabasePath(getOpenHelper().getName()).exists();
    }
}
