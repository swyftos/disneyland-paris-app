package com.urbanairship.meteredusage;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.disney.id.android.lightbox.LightboxActivity;
import com.urbanairship.db.SuspendingBatchedQueryHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\u0003H'J\u001c\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0097@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\bH'¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbanairship/meteredusage/EventsDao;", "", "addEvent", "", "event", "Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "delete", LightboxActivity.EVENT_ID_EXTRA, "", "deleteAll", "eventIds", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllBatchInternal", "getAllEvents", "getEventWithId", "id", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface EventsDao {
    @Insert
    void addEvent(@NotNull MeteredUsageEventEntity event);

    @Query("DELETE FROM events WHERE eventId = :eventId")
    void delete(@NotNull String eventId);

    @Transaction
    @Nullable
    default Object deleteAll(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteAll$suspendImpl(this, list, continuation);
    }

    @Query("DELETE FROM events")
    void deleteAll();

    @Query("DELETE FROM events WHERE eventId IN (:eventIds)")
    void deleteAllBatchInternal(@NotNull List<String> eventIds);

    @Query("SELECT * FROM events")
    @NotNull
    List<MeteredUsageEventEntity> getAllEvents();

    @Query("SELECT * FROM events WHERE eventId = :id")
    @Nullable
    MeteredUsageEventEntity getEventWithId(@NotNull String id);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteAll(@NotNull EventsDao eventsDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteAll = EventsDao.super.deleteAll(list, continuation);
            return objDeleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteAll : Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.meteredusage.EventsDao$deleteAll$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $eventIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List list, Continuation continuation) {
            super(2, continuation);
            this.$eventIds = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EventsDao.this.new AnonymousClass2(this.$eventIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EventsDao.this.deleteAllBatchInternal(this.$eventIds);
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object deleteAll$suspendImpl(EventsDao eventsDao, List<String> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, eventsDao.new AnonymousClass2(list, null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }
}
