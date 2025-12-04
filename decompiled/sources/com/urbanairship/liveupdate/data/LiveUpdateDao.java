package com.urbanairship.liveupdate.data;

import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Upsert;
import com.dlp.BluetoothManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0097@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0007H\u0097@¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H§@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u001eJ&\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0097@¢\u0006\u0002\u0010\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateDao;", "", "countContent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countState", "delete", "", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "deleteAllContent", "deleteAllState", "deleteContent", "deleteState", "get", "Lcom/urbanairship/liveupdate/data/LiveUpdateStateWithContent;", "getAllActive", "", "getContent", "Lcom/urbanairship/liveupdate/data/LiveUpdateContent;", "getState", "Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "isAnyActive", "", "upsert", "content", "(Lcom/urbanairship/liveupdate/data/LiveUpdateContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BluetoothManager.BLE_STATUS_PARAM, "(Lcom/urbanairship/liveupdate/data/LiveUpdateState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbanairship/liveupdate/data/LiveUpdateState;Lcom/urbanairship/liveupdate/data/LiveUpdateContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nLiveUpdateDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateDao.kt\ncom/urbanairship/liveupdate/data/LiveUpdateDao\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
/* loaded from: classes5.dex */
public interface LiveUpdateDao {

    /* renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$delete$1, reason: invalid class name */
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
            return LiveUpdateDao.delete$suspendImpl(LiveUpdateDao.this, null, this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$deleteAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C11601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11601(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdateDao.deleteAll$suspendImpl(LiveUpdateDao.this, this);
        }
    }

    /* renamed from: com.urbanairship.liveupdate.data.LiveUpdateDao$upsert$1, reason: invalid class name and case insensitive filesystem */
    static final class C11611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11611(Continuation continuation) {
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

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object upsert$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao r5, com.urbanairship.liveupdate.data.LiveUpdateState r6, com.urbanairship.liveupdate.data.LiveUpdateContent r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof com.urbanairship.liveupdate.data.LiveUpdateDao.C11611
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.liveupdate.data.LiveUpdateDao$upsert$1 r0 = (com.urbanairship.liveupdate.data.LiveUpdateDao.C11611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.data.LiveUpdateDao$upsert$1 r0 = new com.urbanairship.liveupdate.data.LiveUpdateDao$upsert$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r7 = r5
            com.urbanairship.liveupdate.data.LiveUpdateContent r7 = (com.urbanairship.liveupdate.data.LiveUpdateContent) r7
            java.lang.Object r5 = r0.L$0
            com.urbanairship.liveupdate.data.LiveUpdateDao r5 = (com.urbanairship.liveupdate.data.LiveUpdateDao) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L53
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 == 0) goto L53
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r6 = r5.upsert(r6, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            if (r7 == 0) goto L63
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r5.upsert(r7, r0)
            if (r5 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.data.LiveUpdateDao.upsert$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao, com.urbanairship.liveupdate.data.LiveUpdateState, com.urbanairship.liveupdate.data.LiveUpdateContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object delete$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.urbanairship.liveupdate.data.LiveUpdateDao.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.liveupdate.data.LiveUpdateDao$delete$1 r0 = (com.urbanairship.liveupdate.data.LiveUpdateDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.data.LiveUpdateDao$delete$1 r0 = new com.urbanairship.liveupdate.data.LiveUpdateDao$delete$1
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
            goto L5f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.urbanairship.liveupdate.data.LiveUpdateDao r5 = (com.urbanairship.liveupdate.data.LiveUpdateDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.deleteState(r6, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = r5.deleteContent(r6, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.data.LiveUpdateDao.delete$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object deleteAll$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.urbanairship.liveupdate.data.LiveUpdateDao.C11601
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.liveupdate.data.LiveUpdateDao$deleteAll$1 r0 = (com.urbanairship.liveupdate.data.LiveUpdateDao.C11601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.liveupdate.data.LiveUpdateDao$deleteAll$1 r0 = new com.urbanairship.liveupdate.data.LiveUpdateDao$deleteAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            com.urbanairship.liveupdate.data.LiveUpdateDao r5 = (com.urbanairship.liveupdate.data.LiveUpdateDao) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.deleteAllState(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.deleteAllContent(r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.liveupdate.data.LiveUpdateDao.deleteAll$suspendImpl(com.urbanairship.liveupdate.data.LiveUpdateDao, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
