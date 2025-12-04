package com.urbanairship.meteredusage;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Database(entities = {MeteredUsageEventEntity.class}, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/meteredusage/EventsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "eventsDao", "Lcom/urbanairship/meteredusage/EventsDao;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public abstract class EventsDatabase extends RoomDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public abstract EventsDao eventsDao();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/meteredusage/EventsDatabase$Companion;", "", "()V", "DB_NAME", "", "inMemory", "Lcom/urbanairship/meteredusage/EventsDatabase;", "context", "Landroid/content/Context;", "persistent", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EventsDatabase persistent(@NotNull Context context) throws Exception {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                return (EventsDatabase) Room.databaseBuilder(applicationContext, EventsDatabase.class, "ua_metered_usage.db").fallbackToDestructiveMigration().build();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }

        @NotNull
        public final EventsDatabase inMemory(@NotNull Context context) throws Exception {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                return (EventsDatabase) Room.inMemoryDatabaseBuilder(context, EventsDatabase.class).allowMainThreadQueries().build();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
}
