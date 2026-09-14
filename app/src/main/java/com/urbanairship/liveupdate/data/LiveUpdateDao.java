package com.urbanairship.liveupdate.data;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Upsert;
import com.dlp.BluetoothManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Dao
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0007H\u0097@¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u001eJ&\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0097@¢\u0006\u0002\u0010\u001f¨\u0006 À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "", "countContent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countState", "delete", "", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "deleteAllContent", "deleteAllState", "deleteContent", "deleteState", "get", "Lcom/urbanairship/liveupdate/data/LiveUpdateStateWithContent;", "getAllActive", "", "getContent", "Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "getState", "Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "isAnyActive", "", "upsert", "content", "(Lcom/urbanairship/liveupdate/data/LiveUpdateContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BluetoothManager.BLE_STATUS_PARAM, "(Lcom/urbanairship/liveupdate/data/LiveUpdateState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbanairship/liveupdate/data/LiveUpdateState;Lcom/urbanairship/liveupdate/data/LiveUpdateContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nLiveUpdateDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateDao.kt\ncom/urbanairship/liveupdate/data/LiveUpdateDao\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public interface LiveUpdateDao {

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$delete$1 */
    static final class C54131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C54131(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateDao.delete$suspendImpl(LiveUpdateDao.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$deleteAll$1 */
    static final class C54141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C54141(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateDao.deleteAll$suspendImpl(LiveUpdateDao.this, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$upsert$1 */
    static final class C54151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C54151(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateDao.upsert$suspendImpl(LiveUpdateDao.this, null, null, this);
        }
    }

    @Query("SELECT COUNT(*) FROM live_update_content")
    @Nullable
    Object countContent(@NotNull Continuation<? super Integer> continuation);

    @Query("SELECT COUNT(*) FROM live_update_state")
    @Nullable
    Object countState(@NotNull Continuation<? super Integer> continuation);

    @Transaction
    @Nullable
    default Object delete(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        return delete$suspendImpl(this, str, continuation);
    }

    @Transaction
    @Nullable
    default Object deleteAll(@NotNull Continuation<? super Unit> continuation) {
        return deleteAll$suspendImpl(this, continuation);
    }

    @Query("DELETE FROM live_update_content")
    @Transaction
    @Nullable
    Object deleteAllContent(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM live_update_state")
    @Transaction
    @Nullable
    Object deleteAllState(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM live_update_content WHERE name = :name")
    @Transaction
    @Nullable
    Object deleteContent(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM live_update_state WHERE name = :name")
    @Transaction
    @Nullable
    Object deleteState(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM live_update_state WHERE name = :name LIMIT 1")
    @Transaction
    @Nullable
    Object get(@NotNull String str, @NotNull Continuation<? super LiveUpdateStateWithContent> continuation);

    @Query("SELECT * FROM live_update_state WHERE isActive = 1")
    @Transaction
    @Nullable
    Object getAllActive(@NotNull Continuation<? super List<LiveUpdateStateWithContent>> continuation);

    @Query("SELECT * FROM live_update_content WHERE name = :name LIMIT 1")
    @Transaction
    @Nullable
    Object getContent(@NotNull String str, @NotNull Continuation<? super LiveUpdateContent> continuation);

    @Query("SELECT * FROM live_update_state WHERE name = :name LIMIT 1")
    @Transaction
    @Nullable
    Object getState(@NotNull String str, @NotNull Continuation<? super LiveUpdateState> continuation);

    @Query("SELECT COUNT(*) > 0 FROM live_update_state WHERE isActive = 1")
    @Nullable
    Object isAnyActive(@NotNull Continuation<? super Boolean> continuation);

    @Transaction
    @Upsert
    @Nullable
    Object upsert(@NotNull LiveUpdateContent liveUpdateContent, @NotNull Continuation<? super Unit> continuation);

    @Transaction
    @Nullable
    default Object upsert(@Nullable LiveUpdateState liveUpdateState, @Nullable LiveUpdateContent liveUpdateContent, @NotNull Continuation<? super Unit> continuation) {
        return upsert$suspendImpl(this, liveUpdateState, liveUpdateContent, continuation);
    }

    @Transaction
    @Upsert
    @Nullable
    Object upsert(@NotNull LiveUpdateState liveUpdateState, @NotNull Continuation<? super Unit> continuation);

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object upsert(@NotNull LiveUpdateDao liveUpdateDao, @Nullable LiveUpdateState liveUpdateState, @Nullable LiveUpdateContent liveUpdateContent, @NotNull Continuation<? super Unit> continuation) {
            Object objUpsert = LiveUpdateDao.super.upsert(liveUpdateState, liveUpdateContent, continuation);
            return objUpsert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpsert : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object delete(@NotNull LiveUpdateDao liveUpdateDao, @NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            Object objDelete = LiveUpdateDao.super.delete(str, continuation);
            return objDelete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelete : Unit.INSTANCE;
        }

        @Transaction
        @Deprecated
        @Nullable
        public static Object deleteAll(@NotNull LiveUpdateDao liveUpdateDao, @NotNull Continuation<? super Unit> continuation) {
            Object objDeleteAll = LiveUpdateDao.super.deleteAll(continuation);
            return objDeleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteAll : Unit.INSTANCE;
        }
    }

    static /* synthetic */ Object upsert$default(LiveUpdateDao liveUpdateDao, LiveUpdateState liveUpdateState, LiveUpdateContent liveUpdateContent, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upsert");
        }
        if ((i & 1) != 0) {
            liveUpdateState = null;
        }
        if ((i & 2) != 0) {
            liveUpdateContent = null;
        }
        return liveUpdateDao.upsert(liveUpdateState, liveUpdateContent, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Transaction
    static /* synthetic */ Object upsert$suspendImpl(LiveUpdateDao liveUpdateDao, LiveUpdateState liveUpdateState, LiveUpdateContent liveUpdateContent, Continuation<? super Unit> continuation) {
        C54151 c54151;
        if (continuation instanceof C54151) {
            c54151 = (C54151) continuation;
            int i = c54151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54151.label = i - Integer.MIN_VALUE;
            } else {
                c54151 = liveUpdateDao.new C54151(continuation);
            }
        } else {
            c54151 = liveUpdateDao.new C54151(continuation);
        }
        Object obj = c54151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54151.label;
        if (i2 != 0) {
            if (i2 == 1) {
                liveUpdateContent = (LiveUpdateContent) c54151.L$1;
                liveUpdateDao = (LiveUpdateDao) c54151.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (liveUpdateState != null) {
            c54151.L$0 = liveUpdateDao;
            c54151.L$1 = liveUpdateContent;
            c54151.label = 1;
            if (liveUpdateDao.upsert(liveUpdateState, c54151) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (liveUpdateContent != null) {
            c54151.L$0 = null;
            c54151.L$1 = null;
            c54151.label = 2;
            if (liveUpdateDao.upsert(liveUpdateContent, c54151) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Transaction
    static /* synthetic */ Object delete$suspendImpl(LiveUpdateDao liveUpdateDao, String str, Continuation<? super Unit> continuation) {
        C54131 c54131;
        if (continuation instanceof C54131) {
            c54131 = (C54131) continuation;
            int i = c54131.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54131.label = i - Integer.MIN_VALUE;
            } else {
                c54131 = liveUpdateDao.new C54131(continuation);
            }
        } else {
            c54131 = liveUpdateDao.new C54131(continuation);
        }
        Object obj = c54131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54131.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c54131.L$0 = liveUpdateDao;
            c54131.L$1 = str;
            c54131.label = 1;
            if (liveUpdateDao.deleteState(str, c54131) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                str = (String) c54131.L$1;
                liveUpdateDao = (LiveUpdateDao) c54131.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        c54131.L$0 = null;
        c54131.L$1 = null;
        c54131.label = 2;
        if (liveUpdateDao.deleteContent(str, c54131) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Transaction
    static /* synthetic */ Object deleteAll$suspendImpl(LiveUpdateDao liveUpdateDao, Continuation<? super Unit> continuation) {
        C54141 c54141;
        if (continuation instanceof C54141) {
            c54141 = (C54141) continuation;
            int i = c54141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54141.label = i - Integer.MIN_VALUE;
            } else {
                c54141 = liveUpdateDao.new C54141(continuation);
            }
        } else {
            c54141 = liveUpdateDao.new C54141(continuation);
        }
        Object obj = c54141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c54141.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c54141.L$0 = liveUpdateDao;
            c54141.label = 1;
            if (liveUpdateDao.deleteAllState(c54141) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                liveUpdateDao = (LiveUpdateDao) c54141.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        c54141.L$0 = null;
        c54141.label = 2;
        if (liveUpdateDao.deleteAllContent(c54141) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
