package com.urbanairship.cache;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.urbanairship.db.RetryingSQLiteOpenHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Database(entities = {CacheEntity.class}, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/cache/CacheDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cacheDao", "Lcom/urbanairship/cache/CacheDao;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CacheDatabase extends RoomDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public abstract CacheDao cacheDao();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/cache/CacheDatabase$Companion;", "", "()V", "DB_NAME", "", "inMemory", "Lcom/urbanairship/cache/CacheDatabase;", "context", "Landroid/content/Context;", "persistent", "appKey", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CacheDatabase persistent(@NotNull Context context, @NotNull String appKey) throws Exception {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appKey, "appKey");
            try {
                RetryingSQLiteOpenHelper.Factory factory = new RetryingSQLiteOpenHelper.Factory(new FrameworkSQLiteOpenHelperFactory(), true);
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String str = String.format("ua_items_cache-%s.db", Arrays.copyOf(new Object[]{appKey}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return (CacheDatabase) Room.databaseBuilder(applicationContext, CacheDatabase.class, str).openHelperFactory(factory).fallbackToDestructiveMigration().build();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }

        @NotNull
        public final CacheDatabase inMemory(@NotNull Context context) throws Exception {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                return (CacheDatabase) Room.inMemoryDatabaseBuilder(context, CacheDatabase.class).allowMainThreadQueries().build();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
}
