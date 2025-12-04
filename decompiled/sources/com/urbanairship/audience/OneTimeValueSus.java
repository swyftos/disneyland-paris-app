package com.urbanairship.audience;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\rR\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR&\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/audience/OneTimeValueSus;", ExifInterface.GPS_DIRECTION_TRUE, "", "fetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "cached", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "getValue", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeviceInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/OneTimeValueSus\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,216:1\n120#2,10:217\n*S KotlinDebug\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/OneTimeValueSus\n*L\n209#1:217,10\n*E\n"})
/* loaded from: classes5.dex */
public final class OneTimeValueSus<T> {
    private Object cached;
    private Function1 fetcher;
    private Mutex lock;

    /* renamed from: com.urbanairship.audience.OneTimeValueSus$getValue$1, reason: invalid class name */
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
            return OneTimeValueSus.this.getValue(this);
        }
    }

    public OneTimeValueSus(@NotNull Function1<? super Continuation<? super T>, ? extends Object> fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.lock = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getValue(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.urbanairship.audience.OneTimeValueSus.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.audience.OneTimeValueSus$getValue$1 r0 = (com.urbanairship.audience.OneTimeValueSus.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.OneTimeValueSus$getValue$1 r0 = new com.urbanairship.audience.OneTimeValueSus$getValue$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r0 = r0.L$0
            com.urbanairship.audience.OneTimeValueSus r0 = (com.urbanairship.audience.OneTimeValueSus) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L35
            goto L7f
        L35:
            r8 = move-exception
            goto L85
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r2 = r0.L$0
            com.urbanairship.audience.OneTimeValueSus r2 = (com.urbanairship.audience.OneTimeValueSus) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r2
            goto L5f
        L4d:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.lock
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L5f
            return r1
        L5f:
            java.lang.Object r2 = r7.cached     // Catch: java.lang.Throwable -> L77
            if (r2 != 0) goto L7c
            kotlin.jvm.functions.Function1 r2 = r7.fetcher     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L77
            r0.label = r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object r0 = r2.invoke(r0)     // Catch: java.lang.Throwable -> L77
            if (r0 != r1) goto L72
            return r1
        L72:
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
            goto L7f
        L77:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L85
        L7c:
            r0 = r7
            r7 = r8
            r8 = r2
        L7f:
            r0.cached = r8     // Catch: java.lang.Throwable -> L35
            r7.unlock(r5)
            return r8
        L85:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.OneTimeValueSus.getValue(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
