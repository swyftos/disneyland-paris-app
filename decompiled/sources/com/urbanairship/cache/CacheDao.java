package com.urbanairship.cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/urbanairship/cache/CacheDao;", "", "addEntry", "", "item", "Lcom/urbanairship/cache/CacheEntity;", "(Lcom/urbanairship/cache/CacheEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpired", "appVersion", "", "sdkVersion", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItemWithKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntryWithKey", "updateEntry", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CacheDao {

    /* renamed from: com.urbanairship.cache.CacheDao$updateEntry$1, reason: invalid class name */
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
            return CacheDao.updateEntry$suspendImpl(CacheDao.this, null, this);
        }
    }

    @Insert
    @Nullable
    Object addEntry(@NotNull CacheEntity cacheEntity, @NotNull Continuation<? super Unit> continuation);

    @Query("delete from cacheItems where appVersion != :appVersion or sdkVersion != :sdkVersion or expireOn < :timestamp")
    @Nullable
    Object deleteExpired(@NotNull String str, @NotNull String str2, long j, @NotNull Continuation<? super Unit> continuation);

    @Query("delete from cacheItems where `key` = :key")
    @Nullable
    Object deleteItemWithKey(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Query("select * from cacheItems where `key` = :key")
    @Nullable
    Object getEntryWithKey(@NotNull String str, @NotNull Continuation<? super CacheEntity> continuation);

    @Transaction
    @Nullable
    default Object updateEntry(@NotNull CacheEntity cacheEntity, @NotNull Continuation<? super Unit> continuation) {
        return updateEntry$suspendImpl(this, cacheEntity, continuation);
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object updateEntry(@NotNull CacheDao cacheDao, @NotNull CacheEntity cacheEntity, @NotNull Continuation<? super Unit> continuation) {
            Object objUpdateEntry = CacheDao.super.updateEntry(cacheEntity, continuation);
            return objUpdateEntry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateEntry : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.room.Transaction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object updateEntry$suspendImpl(com.urbanairship.cache.CacheDao r5, com.urbanairship.cache.CacheEntity r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.urbanairship.cache.CacheDao.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.cache.CacheDao$updateEntry$1 r0 = (com.urbanairship.cache.CacheDao.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.cache.CacheDao$updateEntry$1 r0 = new com.urbanairship.cache.CacheDao$updateEntry$1
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
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.urbanairship.cache.CacheEntity r6 = (com.urbanairship.cache.CacheEntity) r6
            java.lang.Object r5 = r0.L$0
            com.urbanairship.cache.CacheDao r5 = (com.urbanairship.cache.CacheDao) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.getKey()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.deleteItemWithKey(r7, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = r5.addEntry(r6, r0)
            if (r5 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.CacheDao.updateEntry$suspendImpl(com.urbanairship.cache.CacheDao, com.urbanairship.cache.CacheEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
