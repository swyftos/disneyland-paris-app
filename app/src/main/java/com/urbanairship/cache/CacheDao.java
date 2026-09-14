package com.urbanairship.cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Dao
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006¨\u0006\u0013À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/cache/CacheDao;", "", "addEntry", "", "item", "Lcom/urbanairship/cache/CacheEntity;", "(Lcom/urbanairship/cache/CacheEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpired", "appVersion", "", "sdkVersion", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItemWithKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntryWithKey", "updateEntry", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface CacheDao {

    /* JADX INFO: renamed from: com.urbanairship.cache.CacheDao$updateEntry$1 */
    static final class C51581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C51581(Continuation continuation) {
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

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @Transaction
        @Deprecated
        @Nullable
        public static Object updateEntry(@NotNull CacheDao cacheDao, @NotNull CacheEntity cacheEntity, @NotNull Continuation<? super Unit> continuation) {
            Object objUpdateEntry = CacheDao.super.updateEntry(cacheEntity, continuation);
            return objUpdateEntry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateEntry : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Transaction
    static /* synthetic */ Object updateEntry$suspendImpl(CacheDao cacheDao, CacheEntity cacheEntity, Continuation<? super Unit> continuation) {
        C51581 c51581;
        if (continuation instanceof C51581) {
            c51581 = (C51581) continuation;
            int i = c51581.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51581.label = i - Integer.MIN_VALUE;
            } else {
                c51581 = cacheDao.new C51581(continuation);
            }
        } else {
            c51581 = cacheDao.new C51581(continuation);
        }
        Object obj = c51581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51581.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String key = cacheEntity.getKey();
            c51581.L$0 = cacheDao;
            c51581.L$1 = cacheEntity;
            c51581.label = 1;
            if (cacheDao.deleteItemWithKey(key, c51581) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                cacheEntity = (CacheEntity) c51581.L$1;
                cacheDao = (CacheDao) c51581.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        c51581.L$0 = null;
        c51581.L$1 = null;
        c51581.label = 2;
        if (cacheDao.addEntry(cacheEntity, c51581) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
