package com.urbanairship.android.layout.reporting;

import com.urbanairship.util.TaskSleeper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: loaded from: classes5.dex */
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

    /* JADX WARN: Code duplicated, block: B:22:0x0054 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0060 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0089  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ThomasFormField.AsyncValueFetcher asyncValueFetcher;
        ThomasFormField.AsyncValueFetcher.PendingResult pendingResult;
        ThomasFormField.AsyncValueFetcher.PendingResult pendingResult2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (this.$isInitialCall) {
                        TaskSleeper taskSleeper = this.this$0.taskSleeper;
                        long j = this.this$0.processDelay;
                        this.label = 1;
                        if (taskSleeper.m5200sleepVtjQ1oo(j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.label = 2;
                        if (YieldKt.yield(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    asyncValueFetcher = this.this$0;
                    this.label = 3;
                    if (asyncValueFetcher.processBackOff(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 4;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function1 function1 = this.this$0.fetchBlock;
                    this.label = 5;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 1:
                    ResultKt.throwOnFailure(obj);
                    this.label = 2;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    asyncValueFetcher = this.this$0;
                    this.label = 3;
                    if (asyncValueFetcher.processBackOff(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 4;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function1 function2 = this.this$0.fetchBlock;
                    this.label = 5;
                    obj = function2.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 2:
                    ResultKt.throwOnFailure(obj);
                    asyncValueFetcher = this.this$0;
                    this.label = 3;
                    if (asyncValueFetcher.processBackOff(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 4;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function1 function3 = this.this$0.fetchBlock;
                    this.label = 5;
                    obj = function3.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 3:
                    ResultKt.throwOnFailure(obj);
                    this.label = 4;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function1 function4 = this.this$0.fetchBlock;
                    this.label = 5;
                    obj = function4.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 4:
                    ResultKt.throwOnFailure(obj);
                    Function1 function5 = this.this$0.fetchBlock;
                    this.label = 5;
                    obj = function5.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 5:
                    ResultKt.throwOnFailure(obj);
                    pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
                    this.L$0 = pendingResult;
                    this.label = 6;
                    if (YieldKt.yield(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pendingResult2 = pendingResult;
                    return this.this$0.processResult(pendingResult2);
                case 6:
                    pendingResult2 = (ThomasFormField.AsyncValueFetcher.PendingResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return this.this$0.processResult(pendingResult2);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception unused) {
            return this.this$0.processResult(new ThomasFormField.AsyncValueFetcher.PendingResult.Error());
        }
    }
}
