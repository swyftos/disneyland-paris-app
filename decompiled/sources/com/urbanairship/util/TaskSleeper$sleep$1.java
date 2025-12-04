package com.urbanairship.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class TaskSleeper$sleep$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSleeper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TaskSleeper$sleep$1(TaskSleeper taskSleeper, Continuation continuation) {
        super(continuation);
        this.this$0 = taskSleeper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TaskSleeper.m2956sleepVtjQ1oo$suspendImpl(this.this$0, 0L, this);
    }
}
