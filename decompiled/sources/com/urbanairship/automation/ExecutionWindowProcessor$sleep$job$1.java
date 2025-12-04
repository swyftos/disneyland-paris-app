package com.urbanairship.automation;

import com.urbanairship.util.TaskSleeper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class ExecutionWindowProcessor$sleep$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $duration;
    int label;
    final /* synthetic */ ExecutionWindowProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExecutionWindowProcessor$sleep$job$1(ExecutionWindowProcessor executionWindowProcessor, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = executionWindowProcessor;
        this.$duration = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExecutionWindowProcessor$sleep$job$1(this.this$0, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ExecutionWindowProcessor$sleep$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TaskSleeper taskSleeper = this.this$0.taskSleeper;
            long j = this.$duration;
            this.label = 1;
            if (taskSleeper.m2958sleepVtjQ1oo(j, this) == coroutine_suspended) {
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
