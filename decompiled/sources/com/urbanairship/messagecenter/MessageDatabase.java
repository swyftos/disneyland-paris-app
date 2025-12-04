package com.urbanairship.messagecenter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.db.RetryingSQLiteOpenHelper;
import java.io.File;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@Database(autoMigrations = {@AutoMigration(from = 5, to = 6), @AutoMigration(from = 6, to = 7)}, entities = {MessageEntity.class}, version = 7)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class MessageDatabase extends RoomDatabase {
    static final Migration MIGRATION_1_5 = new MessageDatabaseMultiMigration(1, 5);
    static final Migration MIGRATION_2_5 = new MessageDatabaseMultiMigration(2, 5);
    static final Migration MIGRATION_3_5 = new MessageDatabaseMultiMigration(3, 5);
    static final Migration MIGRATION_4_5 = new MessageDatabaseMultiMigration(4, 5);

    public abstract MessageDao getDao();

    @NonNull
    public static MessageDatabase createDatabase(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions) {
        return (MessageDatabase) Room.databaseBuilder(context, MessageDatabase.class, new File(new File(ContextCompat.getNoBackupFilesDir(context), "com.urbanairship.databases"), airshipConfigOptions.appKey + "_ua_richpush.db").getAbsolutePath()).openHelperFactory(new RetryingSQLiteOpenHelper.Factory(new FrameworkSQLiteOpenHelperFactory(), true)).addMigrations(MIGRATION_1_5, MIGRATION_2_5, MIGRATION_3_5, MIGRATION_4_5).fallbackToDestructiveMigration().build();
    }

    @NonNull
    @VisibleForTesting
    public static MessageDatabase createInMemoryDatabase(@NonNull Context context, @NonNull CoroutineDispatcher coroutineDispatcher) {
        return (MessageDatabase) Room.inMemoryDatabaseBuilder(context, MessageDatabase.class).allowMainThreadQueries().setTransactionExecutor(ExecutorsKt.asExecutor(coroutineDispatcher)).setQueryExecutor(ExecutorsKt.asExecutor(coroutineDispatcher)).build();
    }
}
