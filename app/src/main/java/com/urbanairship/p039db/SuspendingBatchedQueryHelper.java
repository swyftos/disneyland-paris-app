package com.urbanairship.p039db;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0086@¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\r2(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0086@¢\u0006\u0004\b\u000b\u0010\u000eJb\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000520\u0010\n\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0086@¢\u0006\u0004\b\u0010\u0010\fJX\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0087@¢\u0006\u0004\b\u000b\u0010\u0013JX\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\r2(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0087@¢\u0006\u0004\b\u000b\u0010\u0014¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/db/SuspendingBatchedQueryHelper;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", TCEventPropertiesNames.TCE_ITEMS, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "callback", "runBatched", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Set;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "collectBatched", "", "batchSize", "(ILjava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(ILjava/util/Set;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nSuspendingBatchedQueryHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuspendingBatchedQueryHelper.kt\ncom/urbanairship/db/SuspendingBatchedQueryHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
public final class SuspendingBatchedQueryHelper {

    @NotNull
    public static final SuspendingBatchedQueryHelper INSTANCE = new SuspendingBatchedQueryHelper();

    /* JADX INFO: renamed from: com.urbanairship.db.SuspendingBatchedQueryHelper$collectBatched$1 */
    static final class C52561 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52561(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendingBatchedQueryHelper.this.collectBatched(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$3 */
    static final class C52583 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52583(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendingBatchedQueryHelper.this.runBatched(0, (List) null, (Function2) null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$5 */
    static final class C52595 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52595(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendingBatchedQueryHelper.this.runBatched(0, (Set) null, (Function2) null, this);
        }
    }

    private SuspendingBatchedQueryHelper() {
    }

    @Nullable
    public final <T> Object runBatched(@NotNull List<? extends T> list, @NotNull Function2<? super List<? extends T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objRunBatched = runBatched(999, list, function2, continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    @Nullable
    public final <T> Object runBatched(@NotNull Set<? extends T> set, @NotNull Function2<? super Set<? extends T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objRunBatched = runBatched(999, set, function2, continuation);
        return objRunBatched == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunBatched : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final <T, R> Object collectBatched(@NotNull List<? extends T> list, @NotNull Function2<? super List<? extends T>, ? super Continuation<? super List<? extends R>>, ? extends Object> function2, @NotNull Continuation<? super List<? extends R>> continuation) {
        C52561 c52561;
        List list2;
        if (continuation instanceof C52561) {
            c52561 = (C52561) continuation;
            int i = c52561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52561.label = i - Integer.MIN_VALUE;
            } else {
                c52561 = new C52561(continuation);
            }
        } else {
            c52561 = new C52561(continuation);
        }
        Object obj = c52561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52561.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            C52572 c52572 = new C52572(function2, arrayList, null);
            c52561.L$0 = arrayList;
            c52561.label = 1;
            if (runBatched(999, list, c52572, c52561) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list2 = arrayList;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) c52561.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return CollectionsKt.toList(list2);
    }

    /* JADX INFO: renamed from: com.urbanairship.db.SuspendingBatchedQueryHelper$collectBatched$2 */
    static final class C52572 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $callback;
        final /* synthetic */ List $result;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52572(Function2 function2, List list, Continuation continuation) {
            super(2, continuation);
            this.$callback = function2;
            this.$result = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C52572 c52572 = new C52572(this.$callback, this.$result, continuation);
            c52572.L$0 = obj;
            return c52572;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List list, Continuation continuation) {
            return ((C52572) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                Function2 function2 = this.$callback;
                this.label = 1;
                obj = function2.invoke(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list2 = (List) obj;
            if (list2 != null) {
                Boxing.boxBoolean(this.$result.addAll(list2));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0083 -> B:21:0x0086). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    public final <T> java.lang.Object runBatched(@androidx.annotation.IntRange(from = 1) int r12, @org.jetbrains.annotations.NotNull java.util.List<? extends T> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.util.List<? extends T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.urbanairship.p039db.SuspendingBatchedQueryHelper.C52583
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$3 r0 = (com.urbanairship.p039db.SuspendingBatchedQueryHelper.C52583) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$3 r0 = new com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$3
            r0.<init>(r15)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3c
            int r12 = r0.I$2
            int r13 = r0.I$1
            int r14 = r0.I$0
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r3 = r0.L$0
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r14
            r14 = r3
            r10 = r1
            r1 = r0
            r0 = r10
            goto L86
        L3c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r12 == 0) goto L8b
            int r11 = r13.size()
            double r3 = (double) r11
            double r5 = (double) r12
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)
            int r11 = (int) r3
            r1 = 0
            r10 = r13
            r13 = r11
            r11 = r12
            r12 = r1
            r1 = r0
            r0 = r14
            r14 = r10
        L5d:
            if (r12 >= r13) goto L88
            int r3 = r12 * r11
            double r4 = (double) r3
            int r6 = r14.size()
            int r6 = r6 - r3
            double r6 = (double) r6
            double r8 = (double) r11
            double r6 = java.lang.Math.min(r6, r8)
            double r4 = r4 + r6
            int r4 = (int) r4
            java.util.List r3 = r14.subList(r3, r4)
            r1.L$0 = r14
            r1.L$1 = r0
            r1.I$0 = r11
            r1.I$1 = r13
            r1.I$2 = r12
            r1.label = r2
            java.lang.Object r3 = r0.invoke(r3, r1)
            if (r3 != r15) goto L86
            return r15
        L86:
            int r12 = r12 + r2
            goto L5d
        L88:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L8b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Failed to run batched! 'batchSize' must be greater than zero."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.p039db.SuspendingBatchedQueryHelper.runBatched(int, java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0076 A[LOOP:0: B:19:0x0074->B:20:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0092 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0090 -> B:24:0x0093). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    public final <T> java.lang.Object runBatched(@androidx.annotation.IntRange(from = 1) int r12, @org.jetbrains.annotations.NotNull java.util.Set<? extends T> r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.util.Set<? extends T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.urbanairship.p039db.SuspendingBatchedQueryHelper.C52595
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$5 r0 = (com.urbanairship.p039db.SuspendingBatchedQueryHelper.C52595) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$5 r0 = new com.urbanairship.db.SuspendingBatchedQueryHelper$runBatched$5
            r0.<init>(r15)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3c
            int r12 = r0.I$2
            int r13 = r0.I$1
            int r14 = r0.I$0
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r3 = r0.L$0
            java.util.Set r3 = (java.util.Set) r3
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r14
            r14 = r3
            r10 = r1
            r1 = r0
            r0 = r10
            goto L93
        L3c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r12 == 0) goto L98
            int r11 = r13.size()
            double r3 = (double) r11
            double r5 = (double) r12
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)
            int r11 = (int) r3
            r1 = 0
            r10 = r13
            r13 = r11
            r11 = r12
            r12 = r1
            r1 = r0
            r0 = r14
            r14 = r10
        L5d:
            if (r12 >= r13) goto L95
            int r3 = r12 * r11
            double r4 = (double) r3
            int r6 = r14.size()
            int r6 = r6 - r3
            double r6 = (double) r6
            double r8 = (double) r11
            double r6 = java.lang.Math.min(r6, r8)
            double r4 = r4 + r6
            int r4 = (int) r4
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
        L74:
            if (r3 >= r4) goto L80
            java.lang.Object r6 = kotlin.collections.CollectionsKt.elementAt(r14, r3)
            r5.add(r6)
            int r3 = r3 + 1
            goto L74
        L80:
            r1.L$0 = r14
            r1.L$1 = r0
            r1.I$0 = r11
            r1.I$1 = r13
            r1.I$2 = r12
            r1.label = r2
            java.lang.Object r3 = r0.invoke(r5, r1)
            if (r3 != r15) goto L93
            return r15
        L93:
            int r12 = r12 + r2
            goto L5d
        L95:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L98:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Failed to run batched! 'batchSize' must be greater than zero."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.p039db.SuspendingBatchedQueryHelper.runBatched(int, java.util.Set, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
