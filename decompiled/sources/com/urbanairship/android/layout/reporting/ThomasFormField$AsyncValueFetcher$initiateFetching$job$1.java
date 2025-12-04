package com.urbanairship.android.layout.reporting;

import com.urbanairship.android.layout.reporting.ThomasFormField;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class ThomasFormField$AsyncValueFetcher$initiateFetching$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $isInitialCall;
    Object L$0;
    int label;
    final /* synthetic */ ThomasFormField.AsyncValueFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ThomasFormField$AsyncValueFetcher$initiateFetching$job$1(boolean z, ThomasFormField.AsyncValueFetcher asyncValueFetcher, Continuation continuation) {
        super(2, continuation);
        this.$isInitialCall = z;
        this.this$0 = asyncValueFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ThomasFormField$AsyncValueFetcher$initiateFetching$job$1(this.$isInitialCall, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ThomasFormField$AsyncValueFetcher$initiateFetching$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            switch(r1) {
                case 0: goto L2e;
                case 1: goto L2a;
                case 2: goto L26;
                case 3: goto L22;
                case 4: goto L1e;
                case 5: goto L1a;
                case 6: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L11:
            java.lang.Object r0 = r4.L$0
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult r0 = (com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.PendingResult) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L8a
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L7b
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L6b
        L22:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L61
        L26:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L55
        L2a:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L91
            goto L4b
        L2e:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.$isInitialCall     // Catch: java.lang.Exception -> L91
            if (r5 == 0) goto L55
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r5 = r4.this$0     // Catch: java.lang.Exception -> L91
            com.urbanairship.util.TaskSleeper r5 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$getTaskSleeper$p(r5)     // Catch: java.lang.Exception -> L91
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r1 = r4.this$0     // Catch: java.lang.Exception -> L91
            long r1 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$getProcessDelay$p(r1)     // Catch: java.lang.Exception -> L91
            r3 = 1
            r4.label = r3     // Catch: java.lang.Exception -> L91
            java.lang.Object r5 = r5.m2958sleepVtjQ1oo(r1, r4)     // Catch: java.lang.Exception -> L91
            if (r5 != r0) goto L4b
            return r0
        L4b:
            r5 = 2
            r4.label = r5     // Catch: java.lang.Exception -> L91
            java.lang.Object r5 = kotlinx.coroutines.YieldKt.yield(r4)     // Catch: java.lang.Exception -> L91
            if (r5 != r0) goto L55
            return r0
        L55:
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r5 = r4.this$0     // Catch: java.lang.Exception -> L91
            r1 = 3
            r4.label = r1     // Catch: java.lang.Exception -> L91
            java.lang.Object r5 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$processBackOff(r5, r4)     // Catch: java.lang.Exception -> L91
            if (r5 != r0) goto L61
            return r0
        L61:
            r5 = 4
            r4.label = r5     // Catch: java.lang.Exception -> L91
            java.lang.Object r5 = kotlinx.coroutines.YieldKt.yield(r4)     // Catch: java.lang.Exception -> L91
            if (r5 != r0) goto L6b
            return r0
        L6b:
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r5 = r4.this$0     // Catch: java.lang.Exception -> L91
            kotlin.jvm.functions.Function1 r5 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$getFetchBlock$p(r5)     // Catch: java.lang.Exception -> L91
            r1 = 5
            r4.label = r1     // Catch: java.lang.Exception -> L91
            java.lang.Object r5 = r5.invoke(r4)     // Catch: java.lang.Exception -> L91
            if (r5 != r0) goto L7b
            return r0
        L7b:
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult r5 = (com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.PendingResult) r5     // Catch: java.lang.Exception -> L91
            r4.L$0 = r5     // Catch: java.lang.Exception -> L91
            r1 = 6
            r4.label = r1     // Catch: java.lang.Exception -> L91
            java.lang.Object r1 = kotlinx.coroutines.YieldKt.yield(r4)     // Catch: java.lang.Exception -> L91
            if (r1 != r0) goto L89
            return r0
        L89:
            r0 = r5
        L8a:
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r5 = r4.this$0     // Catch: java.lang.Exception -> L91
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult r4 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$processResult(r5, r0)     // Catch: java.lang.Exception -> L91
            goto L9c
        L91:
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher r4 = r4.this$0
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult$Error r5 = new com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult$Error
            r5.<init>()
            com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$PendingResult r4 = com.urbanairship.android.layout.reporting.ThomasFormField.AsyncValueFetcher.access$processResult(r4, r5)
        L9c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.reporting.ThomasFormField$AsyncValueFetcher$initiateFetching$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
