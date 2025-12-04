package com.urbanairship.automation.limits.storage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.urbanairship.db.SuspendingBatchedQueryHelper;
import java.util.Collection;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0097@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\fH'J\u001c\u0010\r\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0097@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\fH§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH§@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/limits/storage/FrequencyLimitDao;", "", "delete", "", "entity", "Lcom/urbanairship/automation/limits/storage/ConstraintEntity;", "(Lcom/urbanairship/automation/limits/storage/ConstraintEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "constraintIds", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteConstraintsBatchedInternal", "", "deleteOccurrences", "deleteOccurrencesBatchedInternal", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllConstraints", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConstraint", "constraintId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOccurrences", "Lcom/urbanairship/automation/limits/storage/OccurrenceEntity;", "insert", "constraint", "occurrence", "(Lcom/urbanairship/automation/limits/storage/OccurrenceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FrequencyLimitDao {
    @Delete
    @Transaction
    @Nullable
    Object delete(@NotNull ConstraintEntity constraintEntity, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object delete(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return delete$suspendImpl(this, list, continuation);
    }

    @Query("DELETE FROM constraints WHERE (constraintId IN (:constraintIds))")
    void deleteConstraintsBatchedInternal(@NotNull Collection<String> constraintIds);

    @Transaction
    @Nullable
    default Object deleteOccurrences(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        return deleteOccurrences$suspendImpl(this, list, continuation);
    }

    @Query("DELETE FROM occurrences WHERE (parentConstraintId IN (:constraintIds))")
    @Nullable
    Object deleteOccurrencesBatchedInternal(@NotNull Collection<String> collection, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM constraints")
    @Nullable
    Object getAllConstraints(@NotNull Continuation<? super List<ConstraintEntity>> continuation);

    @Query("SELECT * FROM constraints WHERE (constraintId = :constraintId )")
    @Nullable
    Object getConstraint(@NotNull String str, @NotNull Continuation<? super ConstraintEntity> continuation);

    @Query("SELECT * FROM occurrences WHERE parentConstraintId = :constraintId ORDER BY timeStamp ASC")
    @Nullable
    Object getOccurrences(@NotNull String str, @NotNull Continuation<? super List<OccurrenceEntity>> continuation);

    @Insert(onConflict = 5)
    @Nullable
    Object insert(@NotNull ConstraintEntity constraintEntity, @NotNull Continuation<? super Unit> continuation);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull OccurrenceEntity occurrenceEntity, @NotNull Continuation<? super Unit> continuation);

    @Update
    @Nullable
    Object update(@NotNull ConstraintEntity constraintEntity, @NotNull Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object delete(@NotNull FrequencyLimitDao frequencyLimitDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDelete = FrequencyLimitDao.super.delete(list, continuation);
            return objDelete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelete : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteOccurrences(@NotNull FrequencyLimitDao frequencyLimitDao, @NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteOccurrences = FrequencyLimitDao.super.deleteOccurrences(list, continuation);
            return objDeleteOccurrences == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteOccurrences : Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.automation.limits.storage.FrequencyLimitDao$delete$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $constraintIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List list, Continuation continuation) {
            super(2, continuation);
            this.$constraintIds = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FrequencyLimitDao.this.new AnonymousClass2(this.$constraintIds, continuation);
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
            FrequencyLimitDao.this.deleteConstraintsBatchedInternal(this.$constraintIds);
            return Unit.INSTANCE;
        }
    }

    @Transaction
    static /* synthetic */ Object delete$suspendImpl(FrequencyLimitDao frequencyLimitDao, List<String> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, frequencyLimitDao.new AnonymousClass2(list, null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.limits.storage.FrequencyLimitDao$deleteOccurrences$2, reason: invalid class name and case insensitive filesystem */
    static final class C10562 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $constraintIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10562(List list, Continuation continuation) {
            super(2, continuation);
            this.$constraintIds = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FrequencyLimitDao.this.new C10562(this.$constraintIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C10562) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FrequencyLimitDao frequencyLimitDao = FrequencyLimitDao.this;
                List list = this.$constraintIds;
                this.label = 1;
                if (frequencyLimitDao.deleteOccurrencesBatchedInternal(list, this) == coroutine_suspended) {
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
    static /* synthetic */ Object deleteOccurrences$suspendImpl(FrequencyLimitDao frequencyLimitDao, List<String> list, Continuation<? super Unit> continuation) {
        Object objRunBatched = SuspendingBatchedQueryHelper.INSTANCE.runBatched(list, frequencyLimitDao.new C10562(list, null), continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }
}
