package com.urbanairship.automation.limits.storage;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.urbanairship.config.AirshipRuntimeConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Database(entities = {ConstraintEntity.class, OccurrenceEntity.class}, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/automation/limits/storage/FrequencyLimitDatabase;", "Landroidx/room/RoomDatabase;", "()V", "dao", "Lcom/urbanairship/automation/limits/storage/FrequencyLimitDao;", "getDao", "()Lcom/urbanairship/automation/limits/storage/FrequencyLimitDao;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FrequencyLimitDatabase extends RoomDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public abstract FrequencyLimitDao getDao();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/limits/storage/FrequencyLimitDatabase$Companion;", "", "()V", "createDatabase", "Lcom/urbanairship/automation/limits/storage/FrequencyLimitDatabase;", "context", "Landroid/content/Context;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "createInMemoryDatabase", "createInMemoryDatabase$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final FrequencyLimitDatabase createDatabase(@NotNull Context context, @NotNull AirshipRuntimeConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            return (FrequencyLimitDatabase) Room.databaseBuilder(context, FrequencyLimitDatabase.class, new File(ContextCompat.getNoBackupFilesDir(context), config.getConfigOptions().appKey + "_frequency_limits").getAbsolutePath()).fallbackToDestructiveMigrationOnDowngrade().build();
        }

        @VisibleForTesting
        @NotNull
        public final FrequencyLimitDatabase createInMemoryDatabase$urbanairship_automation_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (FrequencyLimitDatabase) Room.inMemoryDatabaseBuilder(context, FrequencyLimitDatabase.class).allowMainThreadQueries().build();
        }
    }
}
