package com.urbanairship.automation.engine;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.room.Upsert;
import com.urbanairship.db.SuspendingBatchedQueryHelper;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0097@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0097@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0097@¢\u0006\u0002\u0010\tJ\u001c\u0010\u0014\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0097@¢\u0006\u0002\u0010\tJ$\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H§@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\bH§@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0097@¢\u0006\u0002\u0010\tJ$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ \u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH§@¢\u0006\u0002\u0010\u0018J,\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001a\u001a\u00020\u00052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0#H\u0097@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0017H§@¢\u0006\u0002\u0010'J>\u0010(\u001a\b\u0012\u0004\u0012\u00020!0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020!0)H\u0097@¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\bH§@¢\u0006\u0002\u0010\tJ\u001c\u0010-\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\bH\u0097@¢\u0006\u0002\u0010\tJ\u001c\u0010/\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0\bH§@¢\u0006\u0002\u0010\t¨\u00060À\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationDao;", "", "deleteSchedules", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedulesBatchInternal", "deleteTrigger", "scheduleId", "triggerId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTriggers", "scheduleIds", "triggerIds", "", "(Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTriggersExcluding", "deleteTriggersInternal", "getAllSchedules", "Lcom/urbanairship/automation/engine/ScheduleEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "id", "getSchedules", "getSchedulesBatchInternal", "getTrigger", "Lcom/urbanairship/automation/engine/TriggerEntity;", "getTriggersScheduleIds", "updateSchedule", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "closure", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScheduleInternal", "schedule", "(Lcom/urbanairship/automation/engine/ScheduleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedules", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedulesInternal", "schedules", "upsertTriggers", "triggers", "upsertTriggersInternal", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationStore.kt\ncom/urbanairship/automation/engine/AutomationDao\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,419:1\n1603#2,9:420\n1855#2:429\n1856#2:431\n1612#2:432\n1194#2,2:433\n1222#2,4:435\n1549#2:439\n1620#2,2:440\n1622#2:443\n1#3:430\n1#3:442\n*S KotlinDebug\n*F\n+ 1 AutomationStore.kt\ncom/urbanairship/automation/engine/AutomationDao\n*L\n213#1:420,9\n213#1:429\n213#1:431\n213#1:432\n214#1:433,2\n214#1:435,4\n218#1:439\n218#1:440,2\n218#1:443\n213#1:430\n*E\n"})
/* loaded from: classes5.dex */
public interface AutomationDao {

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationDao.deleteTriggersExcluding$suspendImpl(AutomationDao.this, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$updateSchedule$1, reason: invalid class name and case insensitive filesystem */
    static final class C09891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09891(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationDao.updateSchedule$suspendImpl(AutomationDao.this, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$upsertSchedules$1, reason: invalid class name and case insensitive filesystem */
    static final class C09901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09901(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationDao.upsertSchedules$suspendImpl(AutomationDao.this, null, null, this);
        }
    }

    @Query("DELETE FROM schedules WHERE `group` = :group")
    @Nullable
    Object deleteSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object deleteSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteSchedules$suspendImpl(this, list, continuation);
    }

    @Query("DELETE FROM schedules WHERE (scheduleId IN (:ids))")
    @Nullable
    Object deleteSchedulesBatchInternal(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM automation_trigger_data WHERE scheduleId = :scheduleId AND triggerId = :triggerId")
    @Transaction
    @Nullable
    Object deleteTrigger(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object deleteTriggers(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggers$suspendImpl(this, str, set, continuation);
    }

    @Transaction
    @Nullable
    default Object deleteTriggers(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggers$suspendImpl(this, list, continuation);
    }

    @Transaction
    @Nullable
    default Object deleteTriggersExcluding(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteTriggersExcluding$suspendImpl(this, list, continuation);
    }

    @Query("DELETE FROM automation_trigger_data WHERE scheduleId = :scheduleIds AND triggerId IN (:triggerIds) ")
    @Nullable
    Object deleteTriggersInternal(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM automation_trigger_data WHERE scheduleId IN (:scheduleIds)")
    @Nullable
    Object deleteTriggersInternal(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM schedules")
    @Nullable
    Object getAllSchedules(@NotNull Continuation<? super List<ScheduleEntity>> continuation);

    @Query("SELECT * FROM schedules WHERE scheduleId = :id")
    @Nullable
    Object getSchedule(@NotNull String str, @NotNull Continuation<? super ScheduleEntity> continuation);

    @Query("SELECT * FROM schedules WHERE (`group` = :group)")
    @Nullable
    Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<ScheduleEntity>> continuation);

    @Transaction
    @Nullable
    default Object getSchedules(@NotNull List<String> list, @NotNull Continuation<? super List<ScheduleEntity>> continuation) {
        return getSchedules$suspendImpl(this, list, continuation);
    }

    @Query("SELECT * FROM schedules WHERE (scheduleId IN (:ids))")
    @Nullable
    Object getSchedulesBatchInternal(@NotNull List<String> list, @NotNull Continuation<? super List<ScheduleEntity>> continuation);

    @Query("SELECT * FROM automation_trigger_data WHERE scheduleId = :scheduleId AND triggerId = :triggerId LIMIT 1")
    @Transaction
    @Nullable
    Object getTrigger(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super TriggerEntity> continuation);

    @Query("SELECT scheduleId FROM automation_trigger_data")
    @Nullable
    Object getTriggersScheduleIds(@NotNull Continuation<? super List<String>> continuation);

    @Transaction
    @Nullable
    default Object updateSchedule(@NotNull String str, @NotNull Function1<? super AutomationScheduleData, AutomationScheduleData> function1, @NotNull Continuation<? super AutomationScheduleData> continuation) {
        return updateSchedule$suspendImpl(this, str, function1, continuation);
    }

    @Update
    @Nullable
    Object updateScheduleInternal(@NotNull ScheduleEntity scheduleEntity, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object upsertSchedules(@NotNull List<String> list, @NotNull Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return upsertSchedules$suspendImpl(this, list, function2, continuation);
    }

    @Insert(onConflict = 1)
    @Nullable
    Object upsertSchedulesInternal(@NotNull List<ScheduleEntity> list, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object upsertTriggers(@NotNull List<TriggerEntity> list, @NotNull Continuation<? super Unit> continuation) {
        return upsertTriggers$suspendImpl(this, list, continuation);
    }

    @Upsert
    @Nullable
    Object upsertTriggersInternal(@NotNull List<TriggerEntity> list, @NotNull Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object upsertSchedules(@NotNull AutomationDao automationDao, @NotNull List<String> list, @NotNull Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
            return AutomationDao.super.upsertSchedules(list, function2, continuation);
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object getSchedules(@NotNull AutomationDao automationDao, @NotNull List<String> list, @NotNull Continuation<? super List<ScheduleEntity>> continuation) {
            return AutomationDao.super.getSchedules(list, continuation);
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object updateSchedule(@NotNull AutomationDao automationDao, @NotNull String str, @NotNull Function1<? super AutomationScheduleData, AutomationScheduleData> function1, @NotNull Continuation<? super AutomationScheduleData> continuation) {
            return AutomationDao.super.updateSchedule(str, function1, continuation);
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteSchedules(@NotNull AutomationDao automationDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteSchedules = AutomationDao.super.deleteSchedules(list, continuation);
            return objDeleteSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteSchedules : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object upsertTriggers(@NotNull AutomationDao automationDao, @NotNull List<TriggerEntity> list, @NotNull Continuation<? super Unit> continuation) {
            Object objUpsertTriggers = AutomationDao.super.upsertTriggers(list, continuation);
            return objUpsertTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpsertTriggers : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteTriggers(@NotNull AutomationDao automationDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteTriggers = AutomationDao.super.deleteTriggers(list, continuation);
            return objDeleteTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggers : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteTriggersExcluding(@NotNull AutomationDao automationDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteTriggersExcluding = AutomationDao.super.deleteTriggersExcluding(list, continuation);
            return objDeleteTriggersExcluding == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggersExcluding : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteTriggers(@NotNull AutomationDao automationDao, @NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteTriggers = AutomationDao.super.deleteTriggers(str, set, continuation);
            return objDeleteTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggers : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object upsertSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationDao r7, java.util.List<java.lang.String> r8, kotlin.jvm.functions.Function2<? super java.lang.String, ? super com.urbanairship.automation.engine.AutomationScheduleData, com.urbanairship.automation.engine.AutomationScheduleData> r9, kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.automation.engine.AutomationScheduleData>> r10) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationDao.upsertSchedules$suspendImpl(com.urbanairship.automation.engine.AutomationDao, java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$getSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C09882 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C09882(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09882 c09882 = AutomationDao.this.new C09882(continuation);
            c09882.L$0 = obj;
            return c09882;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C09882) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<String> list = (List) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                this.label = 1;
                obj = automationDao.getSchedulesBatchInternal(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Transaction
    static /* synthetic */ Object getSchedules$suspendImpl(AutomationDao automationDao, List<String> list, Continuation<? super List<ScheduleEntity>> continuation) {
        return SuspendingBatchedQueryHelper.INSTANCE.collectBatched(list, automationDao.new C09882(null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object updateSchedule$suspendImpl(com.urbanairship.automation.engine.AutomationDao r5, java.lang.String r6, kotlin.jvm.functions.Function1<? super com.urbanairship.automation.engine.AutomationScheduleData, com.urbanairship.automation.engine.AutomationScheduleData> r7, kotlin.coroutines.Continuation<? super com.urbanairship.automation.engine.AutomationScheduleData> r8) {
        /*
            boolean r0 = r8 instanceof com.urbanairship.automation.engine.AutomationDao.C09891
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.automation.engine.AutomationDao$updateSchedule$1 r0 = (com.urbanairship.automation.engine.AutomationDao.C09891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationDao$updateSchedule$1 r0 = new com.urbanairship.automation.engine.AutomationDao$updateSchedule$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.AutomationScheduleData r5 = (com.urbanairship.automation.engine.AutomationScheduleData) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.AutomationDao r5 = (com.urbanairship.automation.engine.AutomationDao) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r5.getSchedule(r6, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            com.urbanairship.automation.engine.ScheduleEntity r8 = (com.urbanairship.automation.engine.ScheduleEntity) r8
            r6 = 0
            if (r8 == 0) goto L7c
            com.urbanairship.automation.engine.AutomationScheduleData r8 = r8.toScheduleData()
            if (r8 != 0) goto L61
            goto L7c
        L61:
            java.lang.Object r7 = r7.invoke(r8)
            com.urbanairship.automation.engine.AutomationScheduleData r7 = (com.urbanairship.automation.engine.AutomationScheduleData) r7
            com.urbanairship.automation.engine.ScheduleEntity$Companion r8 = com.urbanairship.automation.engine.ScheduleEntity.INSTANCE
            com.urbanairship.automation.engine.ScheduleEntity r8 = r8.fromScheduleData(r7)
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r5.updateScheduleInternal(r8, r0)
            if (r5 != r1) goto L7a
            return r1
        L7a:
            r5 = r7
        L7b:
            return r5
        L7c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationDao.updateSchedule$suspendImpl(com.urbanairship.automation.engine.AutomationDao, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$deleteSchedules$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = AutomationDao.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<String> list = (List) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                this.label = 1;
                if (automationDao.deleteSchedulesBatchInternal(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object deleteSchedules$suspendImpl(AutomationDao automationDao, List<String> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, automationDao.new AnonymousClass2(null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$upsertTriggers$2, reason: invalid class name and case insensitive filesystem */
    static final class C09912 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C09912(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09912 c09912 = AutomationDao.this.new C09912(continuation);
            c09912.L$0 = obj;
            return c09912;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C09912) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<TriggerEntity> list = (List) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                this.label = 1;
                if (automationDao.upsertTriggersInternal(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object upsertTriggers$suspendImpl(AutomationDao automationDao, List<TriggerEntity> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, automationDao.new C09912(null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$deleteTriggers$2, reason: invalid class name and case insensitive filesystem */
    static final class C09862 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C09862(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09862 c09862 = AutomationDao.this.new C09862(continuation);
            c09862.L$0 = obj;
            return c09862;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C09862) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<String> list = (List) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                this.label = 1;
                if (automationDao.deleteTriggersInternal(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object deleteTriggers$suspendImpl(AutomationDao automationDao, List<String> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, automationDao.new C09862(null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object deleteTriggersExcluding$suspendImpl(com.urbanairship.automation.engine.AutomationDao r5, java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.urbanairship.automation.engine.AutomationDao.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$1 r0 = (com.urbanairship.automation.engine.AutomationDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$1 r0 = new com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L75
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.AutomationDao r5 = (com.urbanairship.automation.engine.AutomationDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.getTriggersScheduleIds(r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L58
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L58:
            java.util.Set r6 = kotlin.collections.CollectionsKt.toSet(r6)
            java.util.List r6 = kotlin.collections.CollectionsKt.minus(r7, r6)
            com.urbanairship.db.SuspendingBatchedQueryHelper r7 = com.urbanairship.db.SuspendingBatchedQueryHelper.INSTANCE
            com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$2 r2 = new com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$2
            r4 = 0
            r2.<init>(r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r5 = r7.runBatched(r6, r2, r0)
            if (r5 != r1) goto L75
            return r1
        L75:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationDao.deleteTriggersExcluding$suspendImpl(com.urbanairship.automation.engine.AutomationDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$deleteTriggersExcluding$2, reason: invalid class name and case insensitive filesystem */
    static final class C09872 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C09872(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09872 c09872 = AutomationDao.this.new C09872(continuation);
            c09872.L$0 = obj;
            return c09872;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C09872) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<String> list = (List) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                this.label = 1;
                if (automationDao.deleteTriggersInternal(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDao$deleteTriggers$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $scheduleIds;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str, Continuation continuation) {
            super(2, continuation);
            this.$scheduleIds = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = AutomationDao.this.new AnonymousClass4(this.$scheduleIds, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((AnonymousClass4) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Set<String> set = (Set) this.L$0;
                AutomationDao automationDao = AutomationDao.this;
                String str = this.$scheduleIds;
                this.label = 1;
                if (automationDao.deleteTriggersInternal(str, set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object deleteTriggers$suspendImpl(AutomationDao automationDao, String str, Set<String> set, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(set, automationDao.new AnonymousClass4(str, null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }
}
