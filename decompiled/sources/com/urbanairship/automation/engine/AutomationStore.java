package com.urbanairship.automation.engine;

import android.content.Context;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Transaction;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.config.AirshipRuntimeConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001c\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0010\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eH\u0096@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0097@¢\u0006\u0002\u0010\u000fJ \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\"H\u0096@¢\u0006\u0002\u0010#J>\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00180%H\u0096@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006*"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationStore;", "Landroidx/room/RoomDatabase;", "Lcom/urbanairship/automation/engine/AutomationStoreInterface;", "()V", "dao", "Lcom/urbanairship/automation/engine/AutomationDao;", "getDao$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/AutomationDao;", "deleteSchedules", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTriggers", "scheduleID", "triggerIDs", "", "(Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleIDs", "deleteTriggersExcluding", "getSchedule", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "id", "getSchedules", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrigger", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggerID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "closure", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedules", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertTriggers", "triggers", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Database(entities = {ScheduleEntity.class, TriggerEntity.class}, version = 3)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAutomationStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationStore.kt\ncom/urbanairship/automation/engine/AutomationStore\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,419:1\n1603#2,9:420\n1855#2:429\n1856#2:431\n1612#2:432\n1603#2,9:433\n1855#2:442\n1856#2:444\n1612#2:445\n1603#2,9:446\n1855#2:455\n1856#2:457\n1612#2:458\n1549#2:459\n1620#2,3:460\n1#3:430\n1#3:443\n1#3:456\n*S KotlinDebug\n*F\n+ 1 AutomationStore.kt\ncom/urbanairship/automation/engine/AutomationStore\n*L\n143#1:420,9\n143#1:429\n143#1:431\n143#1:432\n147#1:433,9\n147#1:442\n147#1:444\n147#1:445\n152#1:446,9\n152#1:455\n152#1:457\n152#1:458\n189#1:459\n189#1:460,3\n143#1:430\n147#1:443\n152#1:456\n*E\n"})
/* loaded from: classes5.dex */
public abstract class AutomationStore extends RoomDatabase implements AutomationStoreInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final AutomationStore$Companion$MIGRATION_1_2$1 MIGRATION_1_2 = new Migration() { // from class: com.urbanairship.automation.engine.AutomationStore$Companion$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase db) throws SQLException {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE schedules ADD COLUMN triggerSessionId TEXT");
            db.execSQL("ALTER TABLE schedules ADD COLUMN associatedData TEXT");
        }
    };
    private static final AutomationStore$Companion$MIGRATION_2_3$1 MIGRATION_2_3 = new Migration() { // from class: com.urbanairship.automation.engine.AutomationStore$Companion$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase db) throws SQLException {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("DROP TABLE automation_trigger_data");
            db.execSQL("CREATE TABLE IF NOT EXISTS automation_trigger_data (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `triggerId` TEXT NOT NULL, `scheduleId` TEXT NOT NULL, `state` TEXT NOT NULL)");
        }
    };

    /* renamed from: com.urbanairship.automation.engine.AutomationStore$getSchedule$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationStore.getSchedule$suspendImpl(AutomationStore.this, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationStore$getSchedules$1, reason: invalid class name and case insensitive filesystem */
    static final class C10391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationStore.getSchedules$suspendImpl(AutomationStore.this, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationStore$getSchedules$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationStore.getSchedules$suspendImpl(AutomationStore.this, (String) null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationStore$getSchedules$5, reason: invalid class name */
    static final class AnonymousClass5 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass5(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationStore.getSchedules$suspendImpl(AutomationStore.this, (List) null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationStore$getTrigger$1, reason: invalid class name and case insensitive filesystem */
    static final class C10401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10401(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationStore.getTrigger$suspendImpl(AutomationStore.this, null, null, this);
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object deleteSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        return deleteSchedules$suspendImpl(this, str, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object deleteSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteSchedules$suspendImpl(this, list, continuation);
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggers(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggers$suspendImpl(this, str, set, continuation);
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggers(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggers$suspendImpl(this, list, continuation);
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggersExcluding(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggersExcluding$suspendImpl(this, list, continuation);
    }

    @NotNull
    public abstract AutomationDao getDao$urbanairship_automation_release();

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedule(@NotNull String str, @NotNull Continuation<? super AutomationScheduleData> continuation) {
        return getSchedule$suspendImpl(this, str, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return getSchedules$suspendImpl(this, str, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Transaction
    @Nullable
    public Object getSchedules(@NotNull List<String> list, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return getSchedules$suspendImpl(this, list, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedules(@NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return getSchedules$suspendImpl(this, continuation);
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object getTrigger(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super TriggerData> continuation) {
        return getTrigger$suspendImpl(this, str, str2, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object updateSchedule(@NotNull String str, @NotNull Function1<? super AutomationScheduleData, AutomationScheduleData> function1, @NotNull Continuation<? super AutomationScheduleData> continuation) {
        return updateSchedule$suspendImpl(this, str, function1, continuation);
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object upsertSchedules(@NotNull List<String> list, @NotNull Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return upsertSchedules$suspendImpl(this, list, function2, continuation);
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object upsertTriggers(@NotNull List<TriggerData> list, @NotNull Continuation<? super Unit> continuation) {
        return upsertTriggers$suspendImpl(this, list, continuation);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0004\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\u0010R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationStore$Companion;", "", "()V", "MIGRATION_1_2", "com/urbanairship/automation/engine/AutomationStore$Companion$MIGRATION_1_2$1", "Lcom/urbanairship/automation/engine/AutomationStore$Companion$MIGRATION_1_2$1;", "MIGRATION_2_3", "com/urbanairship/automation/engine/AutomationStore$Companion$MIGRATION_2_3$1", "Lcom/urbanairship/automation/engine/AutomationStore$Companion$MIGRATION_2_3$1;", "createDatabase", "Lcom/urbanairship/automation/engine/AutomationStore;", "context", "Landroid/content/Context;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "createInMemoryDatabase", "createInMemoryDatabase$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationStore createDatabase(@NotNull Context context, @NotNull AirshipRuntimeConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            return (AutomationStore) Room.databaseBuilder(context, AutomationStore.class, new File(ContextCompat.getNoBackupFilesDir(context), config.getConfigOptions().appKey + "_automation_store").getAbsolutePath()).addMigrations(AutomationStore.MIGRATION_1_2, AutomationStore.MIGRATION_2_3).fallbackToDestructiveMigrationOnDowngrade().build();
        }

        @VisibleForTesting
        @NotNull
        public final AutomationStore createInMemoryDatabase$urbanairship_automation_release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (AutomationStore) Room.inMemoryDatabaseBuilder(context, AutomationStore.class).allowMainThreadQueries().build();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof com.urbanairship.automation.engine.AutomationStore.C10391
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.automation.engine.AutomationStore$getSchedules$1 r0 = (com.urbanairship.automation.engine.AutomationStore.C10391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationStore$getSchedules$1 r0 = new com.urbanairship.automation.engine.AutomationStore$getSchedules$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.automation.engine.AutomationDao r4 = r4.getDao$urbanairship_automation_release()
            r0.label = r3
            java.lang.Object r5 = r4.getAllSchedules(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L64
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r5.iterator()
        L4e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L68
            java.lang.Object r0 = r5.next()
            com.urbanairship.automation.engine.ScheduleEntity r0 = (com.urbanairship.automation.engine.ScheduleEntity) r0
            com.urbanairship.automation.engine.AutomationScheduleData r0 = r0.toScheduleData()
            if (r0 == 0) goto L4e
            r4.add(r0)
            goto L4e
        L64:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L68:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationStore.getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore r4, java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof com.urbanairship.automation.engine.AutomationStore.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.automation.engine.AutomationStore$getSchedules$3 r0 = (com.urbanairship.automation.engine.AutomationStore.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationStore$getSchedules$3 r0 = new com.urbanairship.automation.engine.AutomationStore$getSchedules$3
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.automation.engine.AutomationDao r4 = r4.getDao$urbanairship_automation_release()
            r0.label = r3
            java.lang.Object r6 = r4.getSchedules(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L64
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r6.iterator()
        L4e:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L68
            java.lang.Object r6 = r5.next()
            com.urbanairship.automation.engine.ScheduleEntity r6 = (com.urbanairship.automation.engine.ScheduleEntity) r6
            com.urbanairship.automation.engine.AutomationScheduleData r6 = r6.toScheduleData()
            if (r6 == 0) goto L4e
            r4.add(r6)
            goto L4e
        L64:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L68:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationStore.getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore r4, java.util.List r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof com.urbanairship.automation.engine.AutomationStore.AnonymousClass5
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.automation.engine.AutomationStore$getSchedules$5 r0 = (com.urbanairship.automation.engine.AutomationStore.AnonymousClass5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationStore$getSchedules$5 r0 = new com.urbanairship.automation.engine.AutomationStore$getSchedules$5
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.automation.engine.AutomationDao r4 = r4.getDao$urbanairship_automation_release()
            r0.label = r3
            java.lang.Object r6 = r4.getSchedules(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r6.iterator()
        L4c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L62
            java.lang.Object r6 = r5.next()
            com.urbanairship.automation.engine.ScheduleEntity r6 = (com.urbanairship.automation.engine.ScheduleEntity) r6
            com.urbanairship.automation.engine.AutomationScheduleData r6 = r6.toScheduleData()
            if (r6 == 0) goto L4c
            r4.add(r6)
            goto L4c
        L62:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationStore.getSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationStore, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object updateSchedule$suspendImpl(AutomationStore automationStore, String str, Function1 function1, Continuation continuation) {
        return automationStore.getDao$urbanairship_automation_release().updateSchedule(str, function1, continuation);
    }

    static /* synthetic */ Object upsertSchedules$suspendImpl(AutomationStore automationStore, List list, Function2 function2, Continuation continuation) {
        return automationStore.getDao$urbanairship_automation_release().upsertSchedules(list, function2, continuation);
    }

    static /* synthetic */ Object deleteSchedules$suspendImpl(AutomationStore automationStore, List list, Continuation continuation) {
        Object objDeleteSchedules = automationStore.getDao$urbanairship_automation_release().deleteSchedules((List<String>) list, (Continuation<? super Unit>) continuation);
        return objDeleteSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteSchedules : Unit.INSTANCE;
    }

    static /* synthetic */ Object deleteSchedules$suspendImpl(AutomationStore automationStore, String str, Continuation continuation) {
        Object objDeleteSchedules = automationStore.getDao$urbanairship_automation_release().deleteSchedules(str, (Continuation<? super Unit>) continuation);
        return objDeleteSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteSchedules : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getSchedule$suspendImpl(com.urbanairship.automation.engine.AutomationStore r4, java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof com.urbanairship.automation.engine.AutomationStore.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.automation.engine.AutomationStore$getSchedule$1 r0 = (com.urbanairship.automation.engine.AutomationStore.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationStore$getSchedule$1 r0 = new com.urbanairship.automation.engine.AutomationStore$getSchedule$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.automation.engine.AutomationDao r4 = r4.getDao$urbanairship_automation_release()
            r0.label = r3
            java.lang.Object r6 = r4.getSchedule(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            com.urbanairship.automation.engine.ScheduleEntity r6 = (com.urbanairship.automation.engine.ScheduleEntity) r6
            if (r6 == 0) goto L4a
            com.urbanairship.automation.engine.AutomationScheduleData r4 = r6.toScheduleData()
            goto L4b
        L4a:
            r4 = 0
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationStore.getSchedule$suspendImpl(com.urbanairship.automation.engine.AutomationStore, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getTrigger$suspendImpl(com.urbanairship.automation.engine.AutomationStore r5, final java.lang.String r6, final java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof com.urbanairship.automation.engine.AutomationStore.C10401
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.automation.engine.AutomationStore$getTrigger$1 r0 = (com.urbanairship.automation.engine.AutomationStore.C10401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationStore$getTrigger$1 r0 = new com.urbanairship.automation.engine.AutomationStore$getTrigger$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r5 = r0.L$1
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.urbanairship.json.JsonException -> L34
            goto L52
        L34:
            r5 = move-exception
            goto L5b
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.automation.engine.AutomationDao r5 = r5.getDao$urbanairship_automation_release()     // Catch: com.urbanairship.json.JsonException -> L34
            r0.L$0 = r6     // Catch: com.urbanairship.json.JsonException -> L34
            r0.L$1 = r7     // Catch: com.urbanairship.json.JsonException -> L34
            r0.label = r4     // Catch: com.urbanairship.json.JsonException -> L34
            java.lang.Object r8 = r5.getTrigger(r6, r7, r0)     // Catch: com.urbanairship.json.JsonException -> L34
            if (r8 != r1) goto L52
            return r1
        L52:
            com.urbanairship.automation.engine.TriggerEntity r8 = (com.urbanairship.automation.engine.TriggerEntity) r8     // Catch: com.urbanairship.json.JsonException -> L34
            if (r8 == 0) goto L63
            com.urbanairship.automation.engine.triggerprocessor.TriggerData r3 = r8.toTriggerData()     // Catch: com.urbanairship.json.JsonException -> L34
            goto L63
        L5b:
            com.urbanairship.automation.engine.AutomationStore$getTrigger$2 r8 = new com.urbanairship.automation.engine.AutomationStore$getTrigger$2
            r8.<init>()
            com.urbanairship.UALog.w(r5, r8)
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationStore.getTrigger$suspendImpl(com.urbanairship.automation.engine.AutomationStore, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object upsertTriggers$suspendImpl(AutomationStore automationStore, List list, Continuation continuation) {
        AutomationDao dao$urbanairship_automation_release = automationStore.getDao$urbanairship_automation_release();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TriggerEntity((TriggerData) it.next()));
        }
        Object objUpsertTriggers = dao$urbanairship_automation_release.upsertTriggers(arrayList, continuation);
        return objUpsertTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpsertTriggers : Unit.INSTANCE;
    }

    static /* synthetic */ Object deleteTriggersExcluding$suspendImpl(AutomationStore automationStore, List list, Continuation continuation) {
        Object objDeleteTriggersExcluding = automationStore.getDao$urbanairship_automation_release().deleteTriggersExcluding(list, continuation);
        return objDeleteTriggersExcluding == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggersExcluding : Unit.INSTANCE;
    }

    static /* synthetic */ Object deleteTriggers$suspendImpl(AutomationStore automationStore, List list, Continuation continuation) {
        Object objDeleteTriggers = automationStore.getDao$urbanairship_automation_release().deleteTriggers(list, continuation);
        return objDeleteTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggers : Unit.INSTANCE;
    }

    static /* synthetic */ Object deleteTriggers$suspendImpl(AutomationStore automationStore, String str, Set set, Continuation continuation) {
        Object objDeleteTriggers = automationStore.getDao$urbanairship_automation_release().deleteTriggers(str, set, continuation);
        return objDeleteTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggers : Unit.INSTANCE;
    }
}
