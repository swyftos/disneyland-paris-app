package com.urbanairship.liveupdate.data;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.db.RetryingSQLiteOpenHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@TypeConverters({Converters.class})
@Database(entities = {LiveUpdateState.class, LiveUpdateContent.class}, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateDatabase;", "Landroidx/room/RoomDatabase;", "()V", "liveUpdateDao", "Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class LiveUpdateDatabase extends RoomDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public abstract LiveUpdateDao liveUpdateDao();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateDatabase$Companion;", "", "()V", "createDatabase", "Lcom/urbanairship/liveupdate/data/LiveUpdateDatabase;", "context", "Landroid/content/Context;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "createInMemoryDatabase", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "createInMemoryDatabase$urbanairship_live_update_release", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final LiveUpdateDatabase createDatabase(@NotNull Context context, @NotNull AirshipRuntimeConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            return (LiveUpdateDatabase) Room.databaseBuilder(context, LiveUpdateDatabase.class, new File(ContextCompat.getNoBackupFilesDir(context), config.getConfigOptions().appKey + "_live_updates").getAbsolutePath()).openHelperFactory(new RetryingSQLiteOpenHelper.Factory(new FrameworkSQLiteOpenHelperFactory(), true)).fallbackToDestructiveMigration().build();
        }

        @VisibleForTesting
        @NotNull
        public final LiveUpdateDatabase createInMemoryDatabase$urbanairship_live_update_release(@NotNull Context context, @NotNull CoroutineDispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            return (LiveUpdateDatabase) Room.inMemoryDatabaseBuilder(context, LiveUpdateDatabase.class).allowMainThreadQueries().setTransactionExecutor(ExecutorsKt.asExecutor(dispatcher)).setQueryExecutor(ExecutorsKt.asExecutor(dispatcher)).build();
        }
    }
}
