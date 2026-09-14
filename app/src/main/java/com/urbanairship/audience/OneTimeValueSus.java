package com.urbanairship.audience;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\rR\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR&\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/audience/OneTimeValueSus;", ExifInterface.GPS_DIRECTION_TRUE, "", "fetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "cached", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "getValue", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nDeviceInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/OneTimeValueSus\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,216:1\n120#2,10:217\n*S KotlinDebug\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/OneTimeValueSus\n*L\n209#1:217,10\n*E\n"})
public final class OneTimeValueSus<T> {
    private Object cached;
    private Function1 fetcher;
    private Mutex lock;

    /* JADX INFO: renamed from: com.urbanairship.audience.OneTimeValueSus$getValue$1 */
    static final class C49671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C49671(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OneTimeValueSus.this.getValue(this);
        }
    }

    public OneTimeValueSus(@NotNull Function1<? super Continuation<? super T>, ? extends Object> fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.lock = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object getValue(@NotNull Continuation<? super T> continuation) throws Throwable {
        C49671 c49671;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        OneTimeValueSus<T> oneTimeValueSus;
        if (continuation instanceof C49671) {
            c49671 = (C49671) continuation;
            int i = c49671.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c49671.label = i - Integer.MIN_VALUE;
            } else {
                c49671 = new C49671(continuation);
            }
        } else {
            c49671 = new C49671(continuation);
        }
        Object obj = c49671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c49671.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.lock;
                c49671.L$0 = this;
                c49671.L$1 = mutex;
                c49671.label = 1;
                if (mutex.lock(null, c49671) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) c49671.L$1;
                    oneTimeValueSus = (OneTimeValueSus) c49671.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        oneTimeValueSus.cached = obj;
                        mutex2.unlock(null);
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                Mutex mutex3 = (Mutex) c49671.L$1;
                OneTimeValueSus<T> oneTimeValueSus2 = (OneTimeValueSus) c49671.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this = oneTimeValueSus2;
            }
            Object obj2 = this.cached;
            if (obj2 == null) {
                Function1 function1 = this.fetcher;
                c49671.L$0 = this;
                c49671.L$1 = mutex;
                c49671.label = 2;
                Object objInvoke = function1.invoke(c49671);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oneTimeValueSus = this;
                mutex2 = mutex;
                obj = objInvoke;
            } else {
                oneTimeValueSus = this;
                mutex2 = mutex;
                obj = obj2;
            }
            oneTimeValueSus.cached = obj;
            mutex2.unlock(null);
            return obj;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }
}
