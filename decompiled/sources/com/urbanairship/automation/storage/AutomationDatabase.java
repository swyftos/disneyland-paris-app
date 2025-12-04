package com.urbanairship.automation.storage;

import android.content.Context;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.json.JsonTypeConverters;
import java.io.File;

@TypeConverters({Converters.class, JsonTypeConverters.class})
@Database(entities = {ScheduleEntity.class, TriggerEntity.class}, version = 7)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class AutomationDatabase extends RoomDatabase {
    private static final Migration MIGRATION_1_2;
    private static final Migration MIGRATION_2_3;
    private static final Migration MIGRATION_3_4;
    private static final Migration MIGRATION_4_5;
    private static final Migration MIGRATION_5_6;
    private static final Migration MIGRATION_6_7;

    public abstract AutomationDao getScheduleDao();

    static {
        int i = 2;
        MIGRATION_1_2 = new Migration(1, i) { // from class: com.urbanairship.automation.storage.AutomationDatabase.1
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN campaigns TEXT");
            }
        };
        int i2 = 3;
        MIGRATION_2_3 = new Migration(i, i2) { // from class: com.urbanairship.automation.storage.AutomationDatabase.2
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN frequencyConstraintIds TEXT");
            }
        };
        int i3 = 4;
        MIGRATION_3_4 = new Migration(i2, i3) { // from class: com.urbanairship.automation.storage.AutomationDatabase.3
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN reportingContext TEXT");
            }
        };
        int i4 = 5;
        MIGRATION_4_5 = new Migration(i3, i4) { // from class: com.urbanairship.automation.storage.AutomationDatabase.4
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN messageType TEXT");
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN bypassHoldoutGroups INTEGER NOT NULL DEFAULT 0");
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN newUserEvaluationDate INTEGER NOT NULL DEFAULT 0");
            }
        };
        int i5 = 6;
        MIGRATION_5_6 = new Migration(i4, i5) { // from class: com.urbanairship.automation.storage.AutomationDatabase.5
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN triggeredTime INTEGER NOT NULL DEFAULT -1");
            }
        };
        MIGRATION_6_7 = new Migration(i5, 7) { // from class: com.urbanairship.automation.storage.AutomationDatabase.6
            @Override // androidx.room.migration.Migration
            public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
                supportSQLiteDatabase.execSQL("ALTER TABLE schedules  ADD COLUMN productId TEXT");
            }
        };
    }

    public static AutomationDatabase createDatabase(@NonNull Context context, @NonNull AirshipRuntimeConfig airshipRuntimeConfig) {
        return (AutomationDatabase) Room.databaseBuilder(context, AutomationDatabase.class, new File(ContextCompat.getNoBackupFilesDir(context), airshipRuntimeConfig.getConfigOptions().appKey + "_in-app-automation").getAbsolutePath()).addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7).fallbackToDestructiveMigrationOnDowngrade().build();
    }

    public static AutomationDatabase createInMemoryDatabase(@NonNull Context context) {
        return (AutomationDatabase) Room.inMemoryDatabaseBuilder(context, AutomationDatabase.class).allowMainThreadQueries().build();
    }
}
