package com.urbanairship.analytics.data;

import android.content.Context;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.urbanairship.UALog;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.db.RetryingSQLiteOpenHelper;
import com.urbanairship.json.JsonTypeConverters;
import java.io.File;

@TypeConverters({JsonTypeConverters.class})
@Database(entities = {EventEntity.class}, version = 3)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public abstract class AnalyticsDatabase extends RoomDatabase {
    static final Migration MIGRATION_1_2;
    static final Migration MIGRATION_2_3;

    public abstract EventDao getEventDao();

    static {
        int i = 2;
        MIGRATION_1_2 = new Migration(1, i) { // from class: com.urbanairship.analytics.data.AnalyticsDatabase.1
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("CREATE TABLE events_new (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, type TEXT, eventId TEXT, time TEXT, data TEXT, sessionId TEXT, eventSize INTEGER NOT NULL);");
                supportSQLiteDatabase.execSQL("INSERT INTO events_new (id, type, eventId, time, data, sessionId, eventSize) SELECT _id, type, event_id, time, data, session_id, event_size FROM events");
                supportSQLiteDatabase.execSQL("DROP TABLE events");
                supportSQLiteDatabase.execSQL("ALTER TABLE events_new RENAME TO events");
            }
        };
        MIGRATION_2_3 = new Migration(i, 3) { // from class: com.urbanairship.analytics.data.AnalyticsDatabase.2
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("DELETE FROM events WHERE id NOT IN (SELECT MIN(id) FROM events GROUP BY eventId)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_events_eventId` ON `events` (`eventId`)");
            }
        };
    }

    public static AnalyticsDatabase createDatabase(@NonNull Context context, @NonNull AirshipRuntimeConfig airshipRuntimeConfig) {
        String strMigrateExistingDbIfExists = migrateExistingDbIfExists(context, airshipRuntimeConfig);
        return (AnalyticsDatabase) Room.databaseBuilder(context, AnalyticsDatabase.class, strMigrateExistingDbIfExists).openHelperFactory(new RetryingSQLiteOpenHelper.Factory(new FrameworkSQLiteOpenHelperFactory(), true)).addMigrations(MIGRATION_1_2, MIGRATION_2_3).fallbackToDestructiveMigration().build();
    }

    private static String migrateExistingDbIfExists(Context context, AirshipRuntimeConfig airshipRuntimeConfig) {
        File file = new File(new File(ContextCompat.getNoBackupFilesDir(context), "com.urbanairship.databases"), airshipRuntimeConfig.getConfigOptions().appKey + "_ua_analytics.db");
        StringBuilder sb = new StringBuilder();
        sb.append(airshipRuntimeConfig.getConfigOptions().appKey);
        sb.append("_analytics");
        File file2 = new File(ContextCompat.getNoBackupFilesDir(context), sb.toString());
        if (file.exists() && !file2.exists() && !file.renameTo(file2)) {
            UALog.w("Failed to move analytics db: %s -> %s", file.getPath(), file2.getPath());
        }
        return file2.getAbsolutePath();
    }

    @VisibleForTesting
    public static AnalyticsDatabase createInMemoryDatabase(@NonNull Context context) {
        return (AnalyticsDatabase) Room.inMemoryDatabaseBuilder(context, AnalyticsDatabase.class).allowMainThreadQueries().build();
    }

    public boolean exists(Context context) {
        SupportSQLiteOpenHelper openHelper = getOpenHelper();
        return openHelper.getName() == null || context.getDatabasePath(openHelper.getName()).exists();
    }
}
